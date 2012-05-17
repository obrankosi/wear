package educar.controllers;

import educar.gui.IView;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;
import educar.models.Resolucion;
import educar.models.ResolucionNotFound;
import educar.models.Session;
import educar.models.User;
import educar.models.userNotFound;

public class DocenteCorregirController implements IController, defaultLanguaje,
	IListController {

    private DocenteView view;
    private static Resolucion resolucion;

    @Override
    public void process(String model) {

	if (model.compareTo(UPLOAD) == 0) {
	    cargarSolucion();
	}
	if (model.compareTo("") == 0) {

		}
	if (model.compareTo("") == 0) {

	}

    }

    private void cargarSolucion() {
	if (!view.algunCampoVacioResolucion()) {
	    String codResolucion = new String(); // aca va el da la view
	    String notaResolucion = new String();// aca va el de la view
	    try {
		resolucion = Resolucion.getResolucionByCod(codResolucion);
	    } catch (ResolucionNotFound e) {
		resolucion = null;
	    }
	    if (resolucion != null) {
		// no se cargo la resolucion
		if (resolucion.getResolucion().compareTo("") == 0) {
		    view.present("El alumno todavia no cargo la solucion");
		    // resolucion cargada
		} else {
		    resolucion.setNota(notaResolucion);
		    resolucion.update();
		    view.present("Se a cargado la nota");
		}
	    }
	} else {
	    view.present("faltan ingresar campos");
	}
    }

    @Override
    public void setView(IView view) {
	this.view = (DocenteView) view;
    }

    @Override
    public void processItemList(String item) {

    }

    private static String getDniDocenteSession() {
	try {
	    return User.getUserByUsername(
		    Session.getCurrentUser().getUsername()).getUsername();
	} catch (userNotFound e) {
	    return null;
	}

    }

}
