package educar.controllers.AdminController;

import java.sql.ResultSet;
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
    private AsignacionDocente aDEncargado;

    @Override
    public void process(String model) {
	// asignar un docente cargo de una materia
	if (model.compareTo(ADD) == 0) {
	    asignacionDocente();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.setVacioAsignacionDocente();
	}

    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    private void asignacionDocente() {
	// ver si el dni es valido si no avisa
	// ATENCION SIEMPRE DESPUES DE AGREGAR BORRAR TODOS LOS CAMPOS
	if (!view.camposVaciosEncargadoMateria()) {// true ssi campos vacios
//	    Subject materia = Subject.getSubject(view
//		    .getMateriaAsignacionDocenteEncargado());// cod materia
	    /*
	     * if (tiene docente a cargo){ avisarle que lo borre antes }else{
	     * actualizar la materia }
	     */
	    // posibles formas de hacerlo
	    // materia.setRTeacher(view.getDniAsignacionDocenteEncargado());//dni
	    // profesor responsable
	    // Subject.update(campos a actualizar);
	    view.setVacioAsignacionDocente();
	} else {
	    if (!view.camposVaciosDesignacionMateria()) {
		// crear el modelo para dicta

		view.setVacioAsignacionDocente();
	    } else {// si las 2 solapas de la view estan vacias
		view.present("Faltan ingresar camapos ");
	    }

	}

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
            /*panel Encargado materia*/
	    view.setDocenteAsignacionDocenteEncargado(FuncionesAuxiliares
		    .nameString(item));

	    view.setDniAsignacionDocenteEncargado(FuncionesAuxiliares
		    .idString(item));
	    
	    /*panel Encargado materia*/
	    view.setDocenteAsignacionDocenteDesignacion(FuncionesAuxiliares
		    .nameString(item));

	    view.setDniAsignacionDocenteDesignacion(FuncionesAuxiliares
		    .idString(item));
	    
	}
	/* aca el codigo si lo que preciono fue materia*/
	else {

	}
    }
}
