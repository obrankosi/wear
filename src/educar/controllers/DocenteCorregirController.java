package educar.controllers;

import java.util.LinkedList;

import educar.gui.IView;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;
import educar.models.DictaMateria;
import educar.models.DictaMateriaNotFound;
import educar.models.Resolucion;
import educar.models.ResolucionNotFound;
import educar.models.Session;
import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Subject;

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

    private LinkedList<String> materiasLigadas() {
	String dniDocente = getDniDocenteSession();
	Subject materia;
	String newArg;
	LinkedList<String> materiasDicta;
	LinkedList<Subject> materiasEncargado = Subject
		.getSubjectsByDniE(dniDocente);
	try {
	    materiasDicta = DictaMateria.getMateriasDictaByCod(dniDocente);
	} catch (DictaMateriaNotFound e) {
	    materiasDicta = null;
	}
	if (materiasDicta != null) {
	    for (int i = 0; i < materiasDicta.size(); i++) {
		materia = Subject.getSubject(materiasDicta.get(i));
		if (!materiasEncargado.contains(materia)) {
		    materiasEncargado.add(materia);
		}
	    }
	    materiasDicta.clear();
	    for (int i = 0; i < materiasEncargado.size(); i++) {
		materia = materiasEncargado.get(i);
		newArg = ("codigo: " + materia.getCode() + " | " + "nombre: "
			+ materia.getName() + " | " + "facultad: " + materia
			.getCodigoFacultad());
		materiasDicta.add(newArg);
	    }
	}

	return materiasDicta;
    }
}
