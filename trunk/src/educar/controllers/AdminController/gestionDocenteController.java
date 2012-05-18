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
 * @author grupo wear controlador de los docente como administrador
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
	    view.present(S29);
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
		view.present(S30);
	    } else
		view
			.present(S31);
	}
    }

    /**
     *guarda docete
     */
    private void AddTeacher() {
	if (view.fieldsIsOkAlta_D()) {// si no ingreso algun campo no permite
	    // guardad
	    String telefono = view.getTelefonoAlta_D().trim();
	    String fecha = view.getFechaAlta_D().trim();
	    String dniDocente = view.getDniAlta_D().trim();
	    boolean fechaOk = FuncionesAuxiliares.correctDateFormat(fecha);
	    boolean dniOk = FuncionesAuxiliares.hasAllNumbers(dniDocente);
	    boolean telOk = FuncionesAuxiliares.hasAllNumbers(telefono);
	    if (fechaOk && dniOk && telOk) {
		Docente docente = new Docente(dniDocente, view
			.getNombreAlta_D(), view.getApellidoAlta_D(), fecha,
			telefono, view.getDireccionAlta_D());
		if (docente.save()) {
		    view
			    .present(S32);
		    view.deleteViewFieldsMod_D();
		} else {
		    view.present(S33);
		}
	    } else
		view
			.present(S27);
	} else
	    view.present(FALTANCOMPLETARCAMPOS);
    }

    /**
     *Modifica docente
     */
    private void modifyTeacher() {
	if (teacher != null) {
	    String telefono = view.getTelefonoModif_D().trim();
	    String fecha = view.getFechaModif_D().trim();
	    String dniDocente = view.getDniModif_D().trim();
	    boolean fechaOk = FuncionesAuxiliares.correctDateFormat(fecha);
	    boolean dniOk = FuncionesAuxiliares.hasAllNumbers(dniDocente);
	    boolean telOk = FuncionesAuxiliares.hasAllNumbers(telefono);
	    if (fechaOk && dniOk && telOk) {
		String[] values = { dniDocente, view.getApellidoModif_D(),
			view.getNombreModif_D(), fecha, telefono,
			view.getDireccionModif_D() };
		try {
		    teacher.update(values, teacher.getDni());
		    view.present(ACTUALIZACIONEXITOSO);
		} catch (SQLException e) {
		    view.present(ACTUALIZACIONFALLIDA);
		}
	    } else {
		view
			.present(S27);
	    }

	} else {
	    view.present(S34);
	}
    }

    private void showTeacherInList() {
	try {
	    teachersList = Docente.ListDocente();
	    view.setListDocente_ABM(teachersList);
	} catch (SQLException e) {
	    view.present(ERROR);
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
