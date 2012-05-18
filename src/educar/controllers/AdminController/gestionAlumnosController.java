package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Alumno;

/**
 * @author grupo wear controlador de los alumnos como administrador
 */
public class gestionAlumnosController implements IController, defaultLanguaje,
	IListController {

    private administrador view;
    private static Alumno student = null;
    private static LinkedList<String> studentsList;

    @Override
    public void process(String model) {
	if (model.compareTo(ADD) == 0) {
	    AddStudent();
	    showStudentInList();
	}
	if (model.compareTo(DELETE) == 0) {
	    deletStudent();
	    showStudentInList();
	}
	if (model.compareTo(SEARCH) == 0) {
	    searchAStudentInDbase();
	    showStudentInList();
	}
	if (model.compareTo(MODIFY) == 0) {
	    modifyStudent();
	    showStudentInList();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.deleteViewFieldsAlta_A();
	}

    }

    /**
     *Busca alumnos
     */
    private void searchAStudentInDbase() {
	student = Alumno.getAlumno(view.getDniMod_A());
	if (student != null) {
	    view.setTfNombre_modif_A(student.getName());
	    view.setTfApellido_modif_A(student.getLastName());
	    view.setTfDireccion_modif_A(student.getDir());
	    view.setTfDni_modif_A(student.getDni());
	    view.setTfFechaNac_modif_A(student.getfN());
	    view.setTfTelefono_modif_A(student.getTel());
	} else {
	    view.present(S22);
	    view.deleteViewFieldsMod_A();
	}

    }

    /**
     * Borrado de alumnos
     */
    private void deletStudent() {//
	searchAStudentInDbase();
	if (!(view.getDniMod_A().compareTo("") == 0)) {
	    if (student.destroy()) {
		view.present(S23);
		view.deleteViewFieldsMod_A();
	    } else {
		view
			.present(S24);
	    }
	}
    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    /**
     *Agrega alumnos
     */
    private void AddStudent() {
	if (view.fieldsIsOkAlta_A()) {
	    // guardad
	    String telefono = view.getTelefonoAlta_A().trim();
	    String fecha = view.getFechaNacAlta_A().trim();
	    String dniAlumno = view.getDniAlta_A().trim();
	    boolean fechaOk = FuncionesAuxiliares.correctDateFormat(fecha);
	    boolean dniOk = FuncionesAuxiliares.hasAllNumbers(dniAlumno);
	    boolean telOk = FuncionesAuxiliares.hasAllNumbers(telefono);
	    if (fechaOk && dniOk && telOk) {
		Alumno alumno = new Alumno(dniAlumno, view.getNameAlta_A(),
			view.getLastnameAlta_A(), fecha, telefono, view
				.getDireccionAlta_A());
		if (alumno.save()) {
		    view
			    .present(S25);
		    view.deleteViewFieldsAlta_A();
		} else {
		    view.present(S26);
		}
	    } else {
		view
			.present(S27);
	    }
	} else
	    view.present(FALTANCOMPLETARCAMPOS);
    }

    /**
     *Modifica alumno
     */
    private void modifyStudent() {
	if (student != null) {
	    String telefono = view.getTelefonoMod_A().trim();
	    String fecha = view.getFechaNacMod_A().trim();
	    String dniAlumno = view.getDniMod_A().trim();
	    boolean fechaOk = FuncionesAuxiliares.correctDateFormat(fecha);
	    boolean dniOk = FuncionesAuxiliares.hasAllNumbers(dniAlumno);
	    boolean telOk = FuncionesAuxiliares.hasAllNumbers(telefono);
	    if (fechaOk && dniOk && telOk) {
		String[] values = { dniAlumno, view.getLastnameMod_A(),
			view.getNameMod_A(), fecha, telefono,
			view.getDireccionMod_A() };
		try {
		    Alumno.update(values, student.getDni());
		    view.present(ACTUALIZACIONEXITOSO);
		} catch (SQLException e) {
		    e.printStackTrace();
		    view.present(ACTUALIZACIONFALLIDA);
		}
	    } else {
		view
			.present(S27);
	    }
	} else {
	    view.present(S28);
	}

    }

    private void showStudentInList() {
	try {
	    studentsList = Alumno.ListAlumnos();
	    view.setListAlumnos_ABM(studentsList);
	} catch (SQLException e) {
	    view.present(ERROR);
	}
    }

    @Override
    public void processItemList(String item) {
	view.setTfDni_modif_A(FuncionesAuxiliares.idString(item));
	searchAStudentInDbase();
    }
}
