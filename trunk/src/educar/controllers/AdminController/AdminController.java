package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Alumno;
import educar.models.AdminModels.Cargos;
import educar.models.AdminModels.DedicacionDocente;
import educar.models.AdminModels.Docente;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.Subject;

/**
 * @author grupo wear
 * Controlador de Gui administrador
 * botones y listas 
 *
 */
public class AdminController implements IController, defaultLanguaje {
   
    private administrador view;
    private static LinkedList<String> studentsList;
    private static LinkedList<String> teachersList;
    private LinkedList<String> subjects;
    private LinkedList<String> facultades;
    private static LinkedList<String> facList;
    private static LinkedList<String> cargosList;
    private static LinkedList<String> docenteConCargo; 
   
    
    @Override
    public void process(String model) {

	if (model.compareTo(CLOSE_WINDOW) == 0) {
	    view.dispose();
	}
	if (model.compareTo(ALUMNOSPANEL) == 0) {
	    view.menuAlumnos();
	    listaAlumnos();
	}
	if (model.compareTo(DOCENTESPANEL) == 0) {
	    view.menuDocentes();
	    listaDocentes();
	}
	if (model.compareTo(MATERIAPANEL) == 0) {
	    view.menuMateria();
	    listaMaterias();

	}
	if (model.compareTo(FACULTADPANEL) == 0) {
	    view.menuFacultad();
	    listaFacultad();

	}
	if (model.compareTo(CARGOSPANEL) == 0) {
	    view.menuCargos();
	    listaCargos();
	}

	if (model.compareTo(DEDICACIONDOCENTEPANEL) == 0) {
	    view.menuDedicacionDocente();
	    listaDocentes();
	    listaFacultad();
	    listaCargos();
	    listaDocenteConCargos();
	}
	if (model.compareTo(ASIGNACIONDOCENTEPANEL) == 0) {
	    view.menuAsignacionDocente();
	    listaDocentes();
	    listaMaterias();
	}

    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    private void listaAlumnos() {
	try {
	    studentsList = Alumno.ListAlumnos();
	    view.setListAlumnos_ABM(studentsList);
	} catch (SQLException e) {
	    view.present("no entro por la lista de alumnos");
	}

    }

    private void listaDocentes() {
	try {
	    teachersList = Docente.ListDocente();
	    view.setListDocente_ABM(teachersList);
	} catch (SQLException e) {
	    view.present("no entro por la lista de alumnos");
	}

    }

    private void listaMaterias() {
	try {
	    subjects = Subject.subjectList();
	    view.setListMateria_ABM(subjects);
	    facultades = Facultad.ListFacultad();
	    view.setListFacultad_ABM(facultades);
	} catch (SQLException e) {
	    view.present("no entro por la lista de materias");
	}
    }

    private void listaFacultad() {
	try {
	    facList = Facultad.ListFacultad();
	    view.setListFacultad_ABM(facList);
	} catch (SQLException e) {
	    e.printStackTrace();
	    view.present("error al actualizar la lista de facultades");
	}
    }

    private void listaCargos() {
	try {
	    cargosList = Cargos.listaCargos();
	    view.setListModificarCargos(cargosList);
	} catch (SQLException e) {
	    view.present("no entro por la lista de los cargos");
	}

    }
    
    private void listaDocenteConCargos(){
	try {
	    docenteConCargo = DedicacionDocente.listDedicacion();
	    view.setListDedicacionDocenteAlta(docenteConCargo);
	} catch (SQLException e) {
	    view.present("no entro por la lista de los cargos");
	}
    }

}