package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Docente;

/**
 * @author grupo wear
 *controlador de los docente como administrador
 */
public class gestionDocenteController implements IController, defaultLanguaje,
	IListController {
    
    private administrador view;
    private static Docente teacher = null;
    private static LinkedList<String> teachersList;

    @Override
    public void process(String model) {
	if (model.compareTo(ADD) == 0) {
	    AddTeacher();
	    showTeacherInList();
	}
	if (model.compareTo(DELETE) == 0) {
	    deletTeacher();
	    showTeacherInList();
	}
	if (model.compareTo(SEARCH) == 0) {
	    searchTeacherInDbase();
	    showTeacherInList();
	}
	if (model.compareTo(MODIFY) == 0) {
	    modifyTeacher();
	    showTeacherInList();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.deleteViewFieldsMod_D();
	}

    }

    /**
     *busca en docente 
     */
    private void searchTeacherInDbase() {
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

    /**
     *borra docente 
     */
    private void deletTeacher() {//
	searchTeacherInDbase();
	if (!(view.getDniModif_D().compareTo("") == 0)) {
	    if (teacher.destroy()) {
		view.present("borrado del docente exitoso");
	    } else
		view
			.present("No se puede borrar el docente verifique que no tenga materia a cargos o tareas");
	}
    }


    /**
     *guarda docete 
     */
    private void AddTeacher() {
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
		view.present("verifique los datos ingresados sean validos");
	    }
	} else
	    view.present("faltan completar campos");
    }

    /**
     *Modifica docente 
     */
    private void modifyTeacher() {
	if (teacher != null) {
	    String[] values = { view.getDniModif_D(),
		    view.getApellidoModif_D(), view.getNombreModif_D(),
		    view.getFechaModif_D(), view.getTelefonoModif_D(),
		    view.getDireccionModif_D() };
	    try {
		teacher.update(values, teacher.getDni());
		view.present("actualizacion realizada");
	    } catch (SQLException e) {
		view.present("NO se puede actualizar");
	    }
	} else {
	    view.present("el docente no existe");
	}
    }

    private void showTeacherInList() {
	try {
	    teachersList = Docente.ListDocente();
	    view.setListDocente_ABM(teachersList);
	} catch (SQLException e) {
	    view.present("no entro por la lista de alumnos");
	}
    }

    @Override
    public void processItemList(String item) {
	view.setDniModif_D(FuncionesAuxiliares.idString(item));
	searchTeacherInDbase();
    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }
    
}
