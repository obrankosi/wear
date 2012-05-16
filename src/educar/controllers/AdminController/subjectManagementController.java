package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.Subject;

public class subjectManagementController implements IController,
	defaultLanguaje, IListController {

    private administrador view;
    private static Subject materia;
    private LinkedList<String> subjects;
    private LinkedList<String> materias;
    private LinkedList<String> facultades;

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    @Override
    public void process(String model) {
	if (model.compareTo(CLEAR) == 0) {
	    view.setEmptyFields();
	}
	if (model.compareTo(SEARCH) == 0) {
	    searchSubject();
	    showSubjectInList();
	}
	if (model.compareTo(DELETE) == 0) {
	    deleteSubject();
	    showSubjectInList();
	    view.setEmptyFields();
	}
	if (model.compareTo(MODIFY) == 0) {
	    modifySubject();
	    showSubjectInList();
	    view.setEmptyFields();
	}
	if (model.compareTo(ADD) == 0) {
	    addSubject();
	    view.setEmptyFields();
	    showSubjectInList();
	}

    }

    private void addSubject() {
	// si no estan vacios
	if (!view.camposVaciosAltaMateria()) {
	    materia = new Subject(view.getAddNameTF_M().trim(), view
		    .getCodigoFacultadAltaMateria().trim());
	    if (materia.save()) {
		view.present("guardado exitoso");
	    } else
		view.present("no se pudo guardar la materia");
	} else
	    view.present("faltan completar campos");
    }

    private void deleteSubject() {
	materia = Subject.getSubject(view.getModifyCodeTF_M());
	if (materia != null) {
	    if (materia.delete()) {
		view.present("borrado de la materia exitosa");
	    } else {
		view
			.present("No se puede borrar la materia, Ya que posee un Docente a cargo. elimine este cargo");

	    }
	} else
	    view.present("La materia a borrar no existe");
    }

    public void searchSubject() {
	materia = Subject.getSubject(view.getModifyCodeTF_M());
	if (materia != null) {
	    view.setModifyNameTF_M(materia.getName());
	    view.setFacultadModificarMateria(materia.getCodigoFacultad());
	} else {
	    view.present("materia no encontrada");
	    view.setEmptyFields();
	}

    }

    private void showSubjectInList() {
	try {
	    subjects = Subject.subjectList();
	    view.setListMateria_ABM(subjects);
	    facultades = Facultad.ListFacultad();
	    view.setListFacultad_ABM(facultades);
	} catch (SQLException e) {
	    view.present("no entro por la lista de materias");
	}
    }

    private void modifySubject() {
	String[] values = { view.getModifyNameTF_M().trim(),
		view.getCodigoFacultadModificarMateria().trim() };
	String[] columns = { "nombre_mat", "facultad" };
	searchSubject();
	if (materia != null) {
	    try {
		Subject.update(columns, values, "cod_materia", materia
			.getCode());
		view.present("actualizacion realizada");
	    } catch (SQLException e) {
		view.present("NO se puede actualizar");
	    }
	} else {
	}
    }

    @Override
    public void processItemList(String item) {
	// lista de codigo de las materias
	try {
	    subjects = Subject.subjectCodesList();
	} catch (SQLException e) {
	    e.printStackTrace();
	}/* lo que trajo pertence a lista de materias */

	if (subjects.contains(FuncionesAuxiliares.idString(item))) {
	    view
		    .setFacultadModificarMateria(FuncionesAuxiliares
			    .idString(item));
	    view.setFacultadAltaMateria(FuncionesAuxiliares.idString(item));
	}/* lo que trajo es el codigo de facultad */
	else {
	    view.setFacultadAltaMateria(FuncionesAuxiliares.idString(item));
	}
    }
}
