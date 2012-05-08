package educar.controllers.AdminController;

import java.util.LinkedList;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.AsignacionDocente;
import educar.models.AdminModels.Subject;

public class AsignacionDocenteController implements IController,
	defaultLanguaje {
    private administrador view;
    private LinkedList<String> Docentes;
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
	    Subject materia = Subject.getSubject(view
		    .getMateriaAsignacionDocenteEncargado());//cod materia
	    //asignarle le dni docente encargado y guardarla
	    view.setVacioAsignacionDocente();
	} else {
	    if (!view.camposVaciosDesignacionMateria()) {
		//crear el modelo para dicta 
		view.setVacioAsignacionDocente();
	    } else {// si las 2 solapas de la view estan vacias
		view.present("Faltan ingresar camapos ");
	    }

	}

    }
    // @Override
    // public void processItemList(String item) {
    // view.
    // }

}
