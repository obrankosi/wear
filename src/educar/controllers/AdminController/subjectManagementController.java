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

/**
 * @author grupo wear
 *controlador de la las materias como administrador
 */
public class subjectManagementController implements IController,
	defaultLanguaje, IListController {

    private administrador view;
    private static Subject materia;
    private LinkedList<String> subjects;
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

    /**
     * agrega materia 
     */
    private void addSubject() {
	// si no estan vacios
	if (!view.camposVaciosAltaMateria()) {
	    materia = new Subject(view.getAddNameTF_M().trim(), view
		    .getCodigoFacultadAltaMateria().trim());
	    if (materia.save()) {
		view.present(CARGADOEXITOSO);
	    } else
		view.present(S35);
	} else
	    view.present(FALTANCOMPLETARCAMPOS);
    }

    /**
     * borra materia
     */
    private void deleteSubject() {
	materia = Subject.getSubject(view.getModifyCodeTF_M());
	if (materia != null) {
	    if (materia.delete()) {
		view.present(S36);
	    } else {
		view
			.present(S37);

	    }
	} else
	    view.present(S38);
    }

    /**
     *busca materia 
     */
    public void searchSubject() {
	materia = Subject.getSubject(view.getModifyCodeTF_M());
	if (materia != null) {
	    view.setModifyNameTF_M(materia.getName());
	    view.setFacultadModificarMateria(materia.getCodigoFacultad());
	} else {
	    view.present(S39);
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
	    view.present(ERROR);
	}
    }

    /**
     * modifica materia 
     */
    private void modifySubject() {
	String[] values = { view.getModifyNameTF_M().trim(),
		view.getCodigoFacultadModificarMateria().trim() };
	String[] columns = { "nombre_mat", "facultad" };
	searchSubject();
	if (materia != null) {
	    try {
		Subject.update(columns, values, "cod_materia", materia
			.getCode());
		view.present(ACTUALIZACIONEXITOSO);
	    } catch (SQLException e) {
		view.present(ACTUALIZACIONFALLIDA);
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
