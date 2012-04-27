package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.gestionAlumnosView;
import educar.languaje.defaultLanguaje;
import educar.models.Alumno;

public class gestionAlumnosController implements IController, defaultLanguaje {
    private gestionAlumnosView view;
    private Alumno student = null;

    @Override
    public void process(String model) {
	// TODO agregar alumno
	if (model.compareTo(ADD) == 0) {
	    AddStudent();
	}
	if (model.compareTo(DELETE) == 0) {
	    deletStudent();
	}
	if (model.compareTo(SEARCH) == 0) {
	    searchAStudentInDbase();
	}
	if (model.compareTo(MODIFY) == 0) {
	    modifyStudent();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.deleteViewFieldsMod();
	}

    }

    private void searchAStudentInDbase() {
	// TODO Auto-generated method stub
	student = Alumno.getAlumno(view.getDniMod());
	if (student != null) {
	    view.setTfNombre_modif(student.getName());
	    view.setTfApellido_modif(student.getLastName());
	    view.setTfDireccion_modif(student.getDir());
	    view.setTfDni_modif(student.getDni());
	    view.setTfFechaNac_modif(student.getfN());
	    view.setTfTelefono_modif(student.getTel());
	} else {
	    view.present("El dni del alumno no existe ");
	    view.deleteViewFieldsMod();
	}

    }

    // se supones que tiene un alumno lo borro student tiene un alumno
    private void deletStudent() {//
	searchAStudentInDbase();
	if (!(view.getDniMod().compareTo("") == 0)) {// si no tengo un documento
	    // en
	    // pantalla es porque no pudo
	    // encontrar el alumno
	    if (student.destroy()) {
		view.present("borrado del alumno exitoso");
	    }

	}

    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (gestionAlumnosView) view;
    }

    private void AddStudent() {
	// TODO ("3563", "xxx", "xxx","2000-12-12","22","xxx","xxx") falta
	// agregar a la vista edad!
	if (view.fieldsIsOkAlta()) {// si no ingreso algun campo no permite
	    // guardad
	    Alumno alumno = new Alumno(view.getDniAlta(), view.getNameAlta(),
		    view.getLastnameAlta(), view.getFechaNacAlta(), "22", view
			    .getTelefonoAlta(), view.getDireccionAlta());
	    if (alumno.save()) {
		view.present("alumno agregado correctamente");

	    } else {
		// datos ingresados no son validos hacer una funcion que avise
		// que
		// campo esta mal!
		view.present("verifique los datos ingresados sean validos");
	    }
	} else
	    view.present("faltan completar campos");
    }

    private void modifyStudent() {// ponerle la edad !!!!
	// {
	// searchAStudentInDbase();
	String[] values = { view.getDniMod(), view.getLastnameMod(),
		view.getNameMod(), view.getFechaNacMod(), "22",
		view.getTelefonoMod(), view.getDireccionMod() };
	Alumno.update(values);
	// view.deleteViewFieldsMod();
    }

}
