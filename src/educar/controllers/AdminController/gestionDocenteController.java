package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.gestionDocentesView;
import educar.languaje.defaultLanguaje;
import educar.models.Alumno;
import educar.models.Docente;

public class gestionDocenteController implements IController, defaultLanguaje {
    private gestionDocentesView view;
    private Docente teacher = null;

    @Override
    public void process(String model) {
	// TODO agregar docente
	if (model.compareTo(ADD) == 0) {
	    AddTeacher();
	}
	if (model.compareTo(DELETE) == 0) {
	    deletTeacher();
	}
	if (model.compareTo(SEARCH) == 0) {
	    searchTeacherInDbase();
	}
	if (model.compareTo(MODIFY) == 0) {
	    modifyTeacher();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.deleteViewFieldsMod();
	}

    }

    private void searchTeacherInDbase() {
	// TODO Auto-generated method stub
	teacher = Docente.getDocente(view.getDniModif());
	if (teacher != null) {
	    view.setNombreModif(teacher.getName());
	    view.setApellidoModif(teacher.getLastName());
	    view.setDireccionModif(teacher.getDir());
	    view.setDniModif(teacher.getDni());
	    view.setFechaModif(teacher.getfN());
	    view.setTelefonoModif(teacher.getTel());
	} else {
	    view.present("El dni del doncente no existe ");
	    view.deleteViewFieldsMod();
	}

    }

    // se supones que tiene un docente lo borro teacher tiene un docente
    private void deletTeacher() {//
	searchTeacherInDbase();
	if (!(view.getDniModif().compareTo("") == 0)) {// si no tengo un
	    // documento
	    // en
	    // pantalla es porque no pudo
	    // encontrar el docente
	    if (teacher.destroy()) {
		view.present("borrado del docente exitoso");
	    }

	}

    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (gestionDocentesView) view;
    }

    private void AddTeacher() {
	// TODO ("3563", "xxx", "xxx","2000-12-12","22","xxx","xxx") falta
	// agregar a la vista edad!
	if (view.fieldsIsOkAlta()) {// si no ingreso algun campo no permite
	    // guardad
	    Docente docente= new Docente(view.getDniAlta(), view.getNombreAlta(),
		    view.getApellidoAlta(), view.getFechaAlta(), "22", view
			    .getTelefonoAlta(), view.getDireccionAlta());
	    if (docente.save()) {
		view.present("docente agregado correctamente. Se creo el Usuario para docente");

	    } else {
		// datos ingresados no son validos hacer una funcion que avise
		// que
		// campo esta mal!
		view.present("verifique los datos ingresados sean validos");
	    }
	} else
	    view.present("faltan completar campos");
    }

    private void modifyTeacher() {// ponerle la edad !!!!
	// {
	// searchAteacherInDbase();
	String[] values = { view.getDniModif(), view.getApellidoModif(),
		view.getNombreModif(), view.getFechaModif(), "22",
		view.getTelefonoModif(), view.getDireccionModif() };
	teacher.update(values);
	// view.deleteViewFieldsMod();
    }

}
