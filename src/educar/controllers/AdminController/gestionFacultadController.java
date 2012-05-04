package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.FacultadNotFound;


public class gestionFacultadController implements IController, defaultLanguaje {
	
	private administrador view;
	private static Facultad fac = null;
	private static LinkedList<String> facList;
	
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		this.view = (administrador) view;
	}

	@Override
	public void process(String model) {
		// TODO Auto-generated method stub
		if (model.compareTo(ADD) == 0) {
			view.present("Apretaste ADD");
			addFacultad();
			view.deleteViewFieldsAlta_F();
			showFacultadInList();
		}
		if (model.compareTo(SEARCH) == 0) {
			view.present("apretaste SEARCH");
			try {
				searchFacultadInDB();
			} catch (FacultadNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showFacultadInList();
		}
		if (model.compareTo(DELETE) == 0) {
			try {
				deleteFacultad();
			} catch (FacultadNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showFacultadInList();
		}
		if (model.compareTo(CLEAR) == 0) {
			view.deleteViewFieldsAlta_F();
		}
		if (model.compareTo(MODIFY) == 0) {
			showFacultadInList();
			modifyFacultad();
		}
	}
	
	private void searchFacultadInDB() throws FacultadNotFound {
		fac = Facultad.getFacultadByCod(view.getCodigoModificarFacultad());
		if (fac != null) {
			view.setNombreModificarFacultad(fac.getDescipcion());
		} else {
			view.present("El codigo de facultad no existe");
			view.deleteViewFieldsMod_F();
		}
	}
	
	private void deleteFacultad() throws FacultadNotFound {
		searchFacultadInDB();
		if (!(view.getCodigoModificarFacultad().compareTo("") == 0)) {
			if (fac.destroy()) {
				view.present("Borrado de la facultad exitoso");
				view.deleteViewFieldsMod_F();
			}
		}
	}
	
	private void addFacultad() {
		if (view.fieldsIsOkAlta_F()) {
			Facultad f = new Facultad("", view.getNombreAltaFacultad());
			if (f.save()) {
				view.present("Facultad Agregada");
			} else {
				view.present("Datos No validos");
			}
		} else {
			view.present("Datos incompletos");
		}
	}
	
	private void modifyFacultad() {
		if (fac != null) {
			try {
				Facultad.update(view.getNombreModificarFacultad());
				view.present("Actualizacion con exito");
			} catch (SQLException e) {
				e.printStackTrace();
				view.present("No se pudo actualizar");
			}
		} else {
			view.present("La facultad no existe");
		}
	}
	
	private void showFacultadInList() {
		try {
			facList = Facultad.ListFacultad();
			view.setListFacultad_ABM(facList);
		} catch (SQLException e) {
			e.printStackTrace();
			view.present("error al actualizar la lista de facultades");
		}
	}

}
