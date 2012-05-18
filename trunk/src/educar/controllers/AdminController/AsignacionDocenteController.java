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

/**
 * @author grupo wear controlador sobre las asignaciones de docentes a las
 *         materias
 */
public class AsignacionDocenteController implements IController,
	defaultLanguaje, IListController {

    private administrador view;
    private LinkedList<String> docentes;
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

    /**
     * borra un docente que dicta una materia, distinto a encargado
     */
    private void removerDocenteDictado() {
	if (!(view.camposVaciosDesignacionMateria())) {
	    String materia = view.getMateriaAsignacionDocenteDesignacion();
	    String docente = view.getDniAsignacionDocenteDesignacion();
	    AsignacionDocente dicta = AsignacionDocente.getAsignacionDocente(
		    docente, materia);
	    if (dicta != null) {
		dicta.delete();
		view.present(BORRADOEXITOSO);
	    } else
		view.present(S1 + docente
			+ S2);
	} else
	    view.present(FALTANCOMPLETARCAMPOS);
	view.setVacioAsignacionDocente();
    }

    /**
     * Asigna liga un docente al dictado a una materia
     */
    private void asignarDocenteDictado() {
	if (!(view.camposVaciosDesignacionMateria())) {
	    String materia = view.getMateriaAsignacionDocenteDesignacion();
	    String docente = view.getDniAsignacionDocenteDesignacion();
	    AsignacionDocente dicta = AsignacionDocente.getAsignacionDocente(
		    docente, materia);
	    if (dicta == null) {
		dicta = new AsignacionDocente(materia, docente);
		dicta.save();
		view.present(S3);
	    } else
		view.present(S1 + docente
			+ S4);
	} else
	    view.present(FALTANCOMPLETARCAMPOS);
	view.setVacioAsignacionDocente();
    }

    /**
     * Borra un docente encargado
     */
    private void borrarDocenteEncargado() {
	// ATENCION SIEMPRE DESPUES DE AGREGAR BORRAR TODOS LOS CAMPOS
	if (!view.camposVaciosEncargadoMateria()) {// true ssi campos vacios
	    if (materia.getRTeacher() != null) {
		materia.setNullDocente();
		try {
		    materia.updateNullDni(S5);
		    view
			    .present(S6);
		} catch (SQLException e) {
		    view
			    .present(S7);
		}
	    }
	    view.setVacioAsignacionDocente();
	} else {
	    view.present(S8);
	}

    }

    /**
     *Asigna un docente como encargado
     */
    private void asignacionDocenteEncargado() {
	boolean asignoOk = false;
	// ATENCION SIEMPRE DESPUES DE AGREGAR BORRAR TODOS LOS CAMPOS
	if (!view.camposVaciosEncargadoMateria()) {// true ssi campos vacios
	    if (materia.getRTeacher() != null) {
		view
			.present(S9);
	    } else {
		// materia que no tiene docente encargado
		materia.setRTeacher(view.getDniAsignacionDocenteEncargado());
		try {
		    materia.update();
		    view.present(CARGADOEXITOSO);
		    asignoOk = true;
		} catch (SQLException e) {
		}
	    }
	    // IMPORTANTE PARA EL FUNCIONAMIENTO VACIAR LOS CAMPOS
	    view.setVacioAsignacionDocente();
	} else {
	    view.present(FALTANCOMPLETARCAMPOS);
	}
	if (asignoOk) {
	    listaDocenteLigados(materia.getCode());
	}
    }

    private void listaDocenteLigados(String codMateria) {
	docentesLigados = AsignacionDocente.getDocentesAsignados(codMateria);
	LinkedList<String> result = new LinkedList<String>();
	String newArgs = new String();
	Docente newDocente;
	for (int i = 0; i < docentesLigados.size(); i++) {
	    newDocente = Docente.getDocente(docentes.get(i));
	    newArgs = (S10 + docentes.get(i) + S11 + S12
		    + newDocente.getName() + S11 + S13 + newDocente
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
		view.present(S14);
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

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

}
