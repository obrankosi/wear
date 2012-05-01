package educar.controllers.AdminController;

import java.sql.SQLException;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.Docente;

public class gestionDocenteController implements IController, defaultLanguaje {
    private administrador view;
    private static Docente teacher = null;

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
	    view.deleteViewFieldsMod_D();
	}

    }

    private void searchTeacherInDbase() {
	// TODO Auto-generated method stub
	teacher = Docente.getDocente(view.getDniModif_D());
	if (teacher != null) {
	    view.setNombreModif_D(teacher.getName());
	    view.setApellidoModif_D(teacher.getLastName());
	    view.setDireccionModif_D(teacher.getDir());
	    view.setDniModif_D(teacher.getDni());
	    view.setFechaModif_D(teacher.getfN());
	    view.setTelefonoModif_D(teacher.getTel());
	} else {
	    view.present("El dni del doncente no existe ");
	    view.deleteViewFieldsMod_D();
	}

    }

    // se supones que tiene un docente lo borro teacher tiene un docente
    private void deletTeacher() {//
	searchTeacherInDbase();
	if (!(view.getDniModif_D().compareTo("") == 0)) {// si no tengo un
	    // documento
	    // en
	    // pantalla es porque no pudo
	    // encontrar el docente
	    if (teacher.destroy()) {
		view.present("borrado del docente exitoso");
	    } else
		view
			.present("No se puede borrar el docente verifique que no tenga materia a cargos o tareas");

	}

    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (administrador) view;
    }

    private void AddTeacher() {
	// TODO ("3563", "xxx", "xxx","2000-12-12","xxx","xxx") falta
	if (view.fieldsIsOkAlta_D()) {// si no ingreso algun campo no permite
	    // guardad
	    Docente docente = new Docente(view.getDniAlta_D(), view
		    .getNombreAlta_D(), view.getApellidoAlta_D(), view
		    .getFechaAlta_D(), view.getTelefonoAlta_D(), view
		    .getDireccionAlta_D());
	    if (docente.save()) {
		view
			.present("docente agregado correctamente. Se creo el Usuario para docente");

	    } else {
		// datos ingresados no son validos hacer una funcion que avise
		// que
		// campo esta mal!
		view.present("verifique los datos ingresados sean validos");
	    }
	} else
	    view.present("faltan completar campos");
    }

    private void modifyTeacher() {
	// {
	// searchAteacherInDbase();
	String[] values = { view.getDniModif_D(), view.getApellidoModif_D(),
		view.getNombreModif_D(), view.getFechaModif_D(),
		view.getTelefonoModif_D(), view.getDireccionModif_D() };
	try {
	    teacher.update(values, teacher.getDni());
	    view.present("actualizacion realizada");
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    view.present("NO se puede actualizar");
	}
	// view.deleteViewFieldsMod();
    }

}
