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
import educar.models.Resolucion;
import educar.models.ResolucionNotFound;
import educar.models.Session;
import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Subject;

/**
 * @author grupo wear
 *Controlador de la historia corregir como docente actividades
 */
public class DocenteCorregirController implements IController, defaultLanguaje,
	IListController {

    private DocenteView view;
    private static Resolucion resolucion;
    private static String codResolucion;

    @Override
    public void process(String model) {

	if (model.compareTo(UPLOAD) == 0) {
	    cargarSolucion();
	    view.setearVacioCorregir();
	}
    }

    @Override
    public void setView(IView view) {
	this.view = (DocenteView) view;
    }

    @Override
    public void processItemList(String item) {
	view.setearVacioCorregir();
	String codAct = FuncionesAuxiliares.getCodActividad(item);
	Actividad act = null;
	LinkedList<String> resoluicones;
	try {
	    act = Actividad.getActividad(codAct);
	} catch (ActividadNotFound e) {
	}
	resoluicones = resolucionesActividad(codAct);
	view.setTextAreaActividadCorregir(act.getDescripcionActividad());
	if (!resoluicones.isEmpty()) {
	    view.setListResoluciones(resoluicones);
	} else {
	    view.present("la actividad no tiene resoluciones cargadas");
	    view.setListResoluciones(resoluicones);
	}
    }

    /**
     * @return {@link LinkedList} {@link String} actividades ligadas materia
     */
    public static LinkedList<String> ActividadesLigadasmaterias() {
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

    /**
     * @param codRes {@link String}
     */
    public static void setCodResolucion(String codRes){
	codResolucion = codRes;
    }
    
    /**
     *Carga solucion 
     */
    private void cargarSolucion() {
	if (!view.algunCampoVacioResolucion()) {
	    String codResolucion = DocenteCorregirController.codResolucion;
	    String notaResolucion = view.getNotaCorregir();
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

    private static String getDniDocenteSession() {
	try {
	    return User.getUserByUsername(
		    Session.getCurrentUser().getUsername()).getUsername();
	} catch (userNotFound e) {
	    return null;
	}
    }

    
    /**
     * @param codActividad
     * @return resoluciones de una actividad
     */
    private static LinkedList<String> resolucionesActividad(String codActividad) {
	LinkedList<String> result = new LinkedList<String>();
	LinkedList<Resolucion> resoluciones;
	Resolucion resolucion;
	String newString;
	resoluciones = Resolucion.getResolucionesActividad(codActividad);
	for (int i = 0; i < resoluciones.size(); i++) {
	    resolucion = resoluciones.get(i);
	    newString = ("Res_nro: " + resolucion.getCodigoResolucion() + " | "
		    + "alumno: " + resolucion.getDniAlumno() + " | "
		    + "hrEnvio: " + resolucion.getHrEnvio() + " | " + "fecha: " + resolucion
		    .getFecha());
	    result.add(newString);
	}
	return result;
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

}
