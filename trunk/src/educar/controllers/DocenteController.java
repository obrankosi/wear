package educar.controllers;

import java.util.LinkedList;

import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;
import educar.models.Actividad;
import educar.models.ActividadNotFound;
import educar.models.DictaMateria;
import educar.models.DictaMateriaNotFound;
import educar.models.Session;
import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Subject;

public class DocenteController implements IController, defaultLanguaje,
	IListController {

    private static DocenteView view;

    @Override
    public void process(String model) {
	if (model.compareTo(SUBIR) == 0) {
	    subirActividad();
	    view.setListMAteriaD(misMaterias());
	}
	if (model.compareTo(DELETE) == 0) {
	    borrarActividad();
	    view.setListMAteriaD(misMaterias());
	}

    }

    private void borrarActividad() {
	if (!view.algunCampoVacioBorrarA()) {
	    String codActivdad = view.getCodigoMateriaDeleteActividad();
	    Actividad act = null;
	    try {
		act = Actividad.getActividad(codActivdad);
	    } catch (ActividadNotFound e) {
	    }
	    if (act.deleteActividad()) {
		view.present("borrado Exitoso");
	    }
	} else {
	    view.present("No hay actividad que borrar, seleccion una");
	}
	view.limpiarCamposActividad();

    }

    private void subirActividad() {
	if (!view.algunCampoVacioSubirA()) {
	    String descripcionActiv = view.getDescripcionAddActividad();
	    String codMateria = view.getCodigoMateriaAddActividad();
	    Actividad act = new Actividad(descripcionActiv, codMateria);
	    if (act.save()) {
		view.present("se agrego la actividad");
	    }
	} else {
	    view.present("faltan ingresar campos");
	}
	view.limpiarCamposActividad();
    }

    @Override
    public void processItemList(String item) {
	String codMateria = FuncionesAuxiliares.getDni(item);
	view.setCodigoMateriaAddActividad(codMateria);
    }

    @Override
    public void setView(IView view) {
	this.view = (DocenteView) view;
    }

    public static LinkedList<String> misActividades() {
	String dniDocente = getDniDocenteSession();
	Subject materia;
	String newArg;
	LinkedList<Actividad> listAct = new LinkedList<Actividad>();
	LinkedList<Actividad> listActAux = new LinkedList<Actividad>();
	Actividad act;
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
		}// todas mis materias
	    }
	    for (int i = 0; i < materiasEncargado.size(); i++) {
		materia = materiasEncargado.get(i);
		// guarod todas las actividades de una materia VER aca
		listActAux = Actividad.getActDocente(materia.getCode());
		if (listActAux != null) {
		    listAct.addAll(listActAux);
		    listActAux.clear();
		}
	    }
	    materiasDicta.clear();
	    for (int i = 0; i < listAct.size(); i++) {
		act = listAct.get(i);
		newArg = ("act_nro: " + act.getCodigoActividad() + " | " + getInfoMateria(
			materiasEncargado, act.getCodigoMateria()));
		materiasDicta.add(newArg);
	    }
	}

	return materiasDicta;

    }

    private static String getInfoMateria(LinkedList<Subject> materias,
	    String codigoM) {
	String res = null;
	Subject materia;
	boolean encontre = false;

	for (int i = 0; i < materias.size() && !encontre; i++) {
	    materia = materias.get(i);
	    if (materia.getCode().compareTo(codigoM) == 0) {
		res = ("materia: " + materia.getName() + " | " + "facultad: " + materia
			.getCodigoFacultad());
		encontre = true;
	    }
	}

	return res;
    }

    public static LinkedList<String> misMaterias() {
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
		}// todas mis materias
	    }
	}
	materiasDicta.clear();
	for (int i = 0; i < materiasEncargado.size(); i++) {
	    materia = materiasEncargado.get(i);
	    newArg = ("nro materia: " + materia.getCode() + " | " + "materia: "
		    + materia.getName() + " | " + "facultad: " + materia
		    .getCodigoFacultad());
	    materiasDicta.add(newArg);
	}
	return materiasDicta;
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
