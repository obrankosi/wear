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
	    view.present("El dni del alumno no existe ");
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
		view.present("borrado del alumno exitoso");
		view.deleteViewFieldsMod_A();
	    } else {
		view
			.present("el alumno no se puede borrar, ya que esta cursando materias");
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
			    .present("alumno agregado correctamente. Se creo el Usuario para el alumno ");
		    view.deleteViewFieldsAlta_A();
		} else {
		    view.present("verifique los datos ingresados sean validos");
		}
	    } else {
		view
			.present("ingreso mal el campo Dni o Tele (NUMEROS) o Fecha (aaaa-mm-dd)");
	    }
	} else
	    view.present("faltan completar campos");
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
		    view.present("acutalizacion realizada");
		} catch (SQLException e) {
		    e.printStackTrace();
		    view.present("NO se pude actualizar");
		}
	    } else {
		view
			.present("ingreso mal el campo Dni o Tele (NUMEROS) o Fecha (aaaa-mm-dd)");
	    }
	} else {
	    view.present("el alumno no existe");
	}

    }

    private void showStudentInList() {
	try {
	    studentsList = Alumno.ListAlumnos();
	    view.setListAlumnos_ABM(studentsList);
	} catch (SQLException e) {
	    view.present("no entro por la lista de alumnos");
	}
    }

    @Override
    public void processItemList(String item) {
	view.setTfDni_modif_A(FuncionesAuxiliares.idString(item));
	searchAStudentInDbase();
    }
}
