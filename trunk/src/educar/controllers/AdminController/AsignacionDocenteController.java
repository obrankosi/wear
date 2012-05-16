package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.AsignacionDocente;
import educar.models.AdminModels.Docente;
import educar.models.AdminModels.Subject;

public class AsignacionDocenteController implements IController,
	defaultLanguaje, IListController {
    private administrador view;
    private LinkedList<String> docentes;
    private LinkedList<String> materias;
    private static Subject materia;
    private static LinkedList<String> docentesLigados;

    @Override
    public void process(String model) {
	if (model.compareTo(ADD) == 0) {
	    asignacionDocenteEncargado();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.setVacioAsignacionDocente();
	}
	if (model.compareTo(DELETE) == 0) {
	    // MUY IMPORTANTE QUE EL BORRADO SEA DARLE NULL AL CAMPO DE LA BD
	    borrarDocenteEncargado();
	}
	if (model.compareTo(ASIGNAR) == 0) {
	    asignarDocenteDictado();

	}
	if (model.compareTo(REMOVE) == 0) {
	    removerDocenteDictado();
	}

    }

    private void removerDocenteDictado() {
	if (!(view.camposVaciosDesignacionMateria())) {
	    String materia = view.getMateriaAsignacionDocenteDesignacion();
	    String docente = view.getDniAsignacionDocenteDesignacion();
	    AsignacionDocente dicta = AsignacionDocente.getAsignacionDocente(
		    docente, materia);
	    if (dicta != null) {
		dicta.delete();
		view.present("Borrado exitoso");
	    } else
		view.present("El docente : " + docente
			+ " No dicta esta materia ");
	} else
	    view.present("falta completar campos");
	view.setVacioAsignacionDocente();
    }

    private void asignarDocenteDictado() {
	if (!(view.camposVaciosDesignacionMateria())) {
	    String materia = view.getMateriaAsignacionDocenteDesignacion();
	    String docente = view.getDniAsignacionDocenteDesignacion();
	    AsignacionDocente dicta = AsignacionDocente.getAsignacionDocente(
		    docente, materia);
	    if (dicta == null) {
		dicta = new AsignacionDocente(materia, docente);
		dicta.save();
		view.present("Asignacion cargada");
	    } else
		view.present("El docente : " + docente
			+ " Ya esta Asignado a esta materia ");
	} else
	    view.present("falta completar campos");
	view.setVacioAsignacionDocente();
    }

    private void borrarDocenteEncargado() {
	// ATENCION SIEMPRE DESPUES DE AGREGAR BORRAR TODOS LOS CAMPOS
	if (!view.camposVaciosEncargadoMateria()) {// true ssi campos vacios
	    if (materia.getRTeacher() != null) {
		materia.setNullDocente();
		try {
		    materia.updateNullDni("dni_docente = null");
		    view
			    .present("el borrado del docente encargado fue exitoso");
		} catch (SQLException e) {
		    view
			    .present("el borrado del docente encargado No se puedo realizar ");
		}
	    }
	    view.setVacioAsignacionDocente();
	} else {
	    view.present("no hay docente que borrar");
	}

    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    private void asignacionDocenteEncargado() {
	// ATENCION SIEMPRE DESPUES DE AGREGAR BORRAR TODOS LOS CAMPOS
	if (!view.camposVaciosEncargadoMateria()) {// true ssi campos vacios
	    if (materia.getRTeacher() != null) {
		view
			.present("la materia ya tiene docente encargado, borrelo primero y luego podra asignarle uno nuevo");
	    } else {
		// materia que no tiene docente encargado
		materia.setRTeacher(view.getDniAsignacionDocenteEncargado());
		try {
		    materia.update();
		    view.present("Cargado Exitoso");
		} catch (SQLException e) {
		}
	    }
	    // IMPORTANTE PARA EL FUNCIONAMIENTO VACIAR LOS CAMPOS
	    view.setVacioAsignacionDocente();
	} else {
	    view.present("Faltan ingresar camapos ");
	}
    }

    private void listaDocenteLigados(String codMateria) {
	docentesLigados = AsignacionDocente.getDocentesAsignados(codMateria);
	LinkedList<String> result = new LinkedList<String>();
	String newArgs = new String();
	Docente newDocente;
	for (int i = 0; i < docentesLigados.size(); i++) {
	    newDocente = Docente.getDocente(docentes.get(i));
	    newArgs = ("dni: " + docentes.get(i) + " | " + "nombre : "
		    + newDocente.getName() + " | " + " apellido: " + newDocente
		    .getLastName());
	    result.add(newArgs);
	}
	view.setListDocentesLigadosMateria(result);
    }

    @Override
    public void processItemList(String item) {
	try {
	    docentes = Docente.ListDocenteDni();
	} catch (SQLException e) {
	    docentes = null;
	}
	/* si lo que traje pertenece a docente */
	if (docentes.contains(FuncionesAuxiliares.idString(item))) {
	    /* panel Encargado materia */
	    view.setDocenteAsignacionDocenteEncargado(FuncionesAuxiliares
		    .nameString(item));
	    view.setDniAsignacionDocenteEncargado(FuncionesAuxiliares
		    .idString(item));

	    /* panel designacion */
	    view.setDocenteAsignacionDocenteDesignacion(FuncionesAuxiliares
		    .nameString(item));
	    view.setDniAsignacionDocenteDesignacion(FuncionesAuxiliares
		    .idString(item));

	}
	/* aca el codigo si lo que preciono fue materia */
	else {
	    materia = Subject.getSubject(FuncionesAuxiliares.idString(item));
	    listaDocenteLigados(FuncionesAuxiliares.idString(item));
	    if (materia.getRTeacher() != null) {
		view.present("Atencion la materia tiene docente encargado");
		view.setDniAsignacionDocenteEncargado(materia.getRTeacher());
		view.setDocenteAsignacionDocenteEncargado("");
	    } else {
		view.setDniAsignacionDocenteEncargado("");
	    }

	    view.setMateriaAsignacionDocenteEncargado(FuncionesAuxiliares
		    .idString(item));
	    view.setMateriaAsignacionDocenteDesignacion(FuncionesAuxiliares
		    .idString(item));
	}
    }
}
