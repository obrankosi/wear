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
import educar.models.AdminModels.FacultadNotFound;

/**
 * @author grupo wear
 *controlador de las facultades como administrador
 */
public class gestionFacultadController implements IController, defaultLanguaje,
	IListController {

    private administrador view;
    private static Facultad fac = null;
    private static LinkedList<String> facList;

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    @Override
    public void process(String model) {
	if (model.compareTo(ADD) == 0) {
	    addFacultad();
	    view.deleteViewFieldsAlta_F();
	    showFacultadInList();
	}
	if (model.compareTo(SEARCH) == 0) {
	    try {
		searchFacultadInDB();
	    } catch (FacultadNotFound e) {
		view.present(S40);
	    }
	    showFacultadInList();
	}
	if (model.compareTo(DELETE) == 0) {
	    try {
		deleteFacultad();
	    } catch (FacultadNotFound e) {
		view.present(S41);
	    }
	    showFacultadInList();
	    view.deleteViewFieldsAlta_F();
	}
	if (model.compareTo(CLEAR) == 0) {
	    view.deleteViewFieldsMod_F();
	}
	if (model.compareTo(MODIFY) == 0) {
	    showFacultadInList();
	    modifyFacultad();
	    showFacultadInList();
	    view.deleteViewFieldsAlta_F();
	}
    }

    /**
     * busca en la base de datos
     * @throws FacultadNotFound si no existe
     */
    private void searchFacultadInDB() throws FacultadNotFound {
	if (view.getCodigoModificarFacultad().compareTo("") == 0) {
	    view.present("ingrese codigo");
	} else {
	    fac = Facultad.getFacultadByCod(view.getCodigoModificarFacultad());
	    if (fac != null) {
		view.setNombreModificarFacultad(fac.getDescipcion());
	    } else {
		view.present(S42);
		view.deleteViewFieldsMod_F();
	    }
	}
    }

    /**
     * @throws FacultadNotFound si no existe
     */
    private void deleteFacultad() throws FacultadNotFound {
	searchFacultadInDB();
	if (!(view.getCodigoModificarFacultad().compareTo("") == 0)) {
	    if (fac.destroy()) {
		view.present(S43);
		view.deleteViewFieldsMod_F();
	    }
	}
    }

    /**
     * agrega facultad
     */
    private void addFacultad() {
	if (view.fieldsIsOkAlta_F()) {
	    Facultad f = new Facultad(view.getNombreAltaFacultad().trim());
	    if (f.save()) {
		view.present(S44);
	    } else {
		view.present(S45);
	    }
	} else {
	    view.present(S46);
	}
    }

    /**
     * modifica facultad
     */
    private void modifyFacultad() {
	if (fac != null) {
	    try {
		Facultad.update(view.getNombreModificarFacultad(), view
			.getCodigoModificarFacultad());
		view.present(ACTUALIZACIONEXITOSO);
	    } catch (SQLException e) {
		e.printStackTrace();
		view.present(ACTUALIZACIONFALLIDA);
	    }
	} else {
	    view.present(S47);
	}
    }

    private void showFacultadInList() {
	try {
	    facList = Facultad.ListFacultad();
	    view.setListFacultad_ABM(facList);
	} catch (SQLException e) {
	    e.printStackTrace();
	    view.present(ERROR);
	}
    }

    @Override
    public void processItemList(String item) {
	view.setCodigoModificarFacultad(FuncionesAuxiliares.idString(item));
	view.setNombreModificarFacultad(FuncionesAuxiliares.nameString(item));
    }

}
