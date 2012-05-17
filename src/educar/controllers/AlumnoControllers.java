package educar.controllers;

import java.sql.SQLException;
import java.util.LinkedList;

import javax.management.timer.TimerNotification;

import educar.gui.IView;
import educar.gui.AlumnoView.AlumnoView;
import educar.languaje.defaultLanguaje;
import educar.models.Actividad;
import educar.models.ActividadNotFound;
import educar.models.Cursa;
import educar.models.Resolucion;
import educar.models.ResolucionNotFound;
import educar.models.Session;
import educar.models.TieneActividad;
import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Subject;

public class AlumnoControllers implements IController, defaultLanguaje,
		IListController {
	private static Actividad actividad;
	private static Resolucion resolucion;
	private static Cursa cursa;
	private static LinkedList<String> actividadList;
	private static LinkedList<String> materiasIncriptoList;
	private static LinkedList<String> materiaAinscribirList;
	private AlumnoView view;

	@Override
	public void process(String model) {
		if (model.compareTo(SUBIR) == 0) {
			saveActividadInDBase();
			// view.setVacioCargarSolucion(); // limpia los campo
		}
		if (model.compareTo(ADD) == 0) {
			showActividadInList();

			saveMateriasInDBase();
			showMateriasInscriptoInList();
			showMateriasAinscribirInList();
			// // view.setVaciosIncripcionMateria();// limpia los campo
		}

	}

	@Override
	public void processItemList(String item) {

	}

	private void saveMateriasInDBase() { // guardar una materia en la base de
		if (!view.camposVaciosIncripcionMateria()) {
			cursa = new Cursa(getCodigoAlumno(), view.getCodigoMateria());
			if (!cursa.pertenece()) { // si en la materia q quiere incribirse ya
										// esta incripto
				if (cursa.save()) {
					view.present("Incripto correctamente Correctamente");
				} else {
					view.present("verifique los  datos ingresados sean validos");
				}
			} else {
				view.present("Usted ya esta incripto en Dicha Materia");
			}
		} else {
			view.present("faltan completar campos");
		}
	}

	private static String getCodigoAlumno() {
		// TODO Auto-generated method stub
		try {
			return User.getUserByUsername(
					Session.getCurrentUser().getUsername()).getUsername();
		} catch (userNotFound e) {
			return null;
			// TODO Auto-generated catch block
		}

	}

	private void saveActividadInDBase() { // guardar una actividad en la base de
											// datos
		if (!(view.getSolucionActividad().compareTo("") == 0)) {
			if (!(getDniDocente().compareTo("") == 0)) {
				Resolucion res = new Resolucion("12:12:12", "1982-12-12",
						getDniDocente(), view.getCodActividad(),
						getCodigoAlumno(), view.getSolucionActividad(),
						view.getNota());
				if (!res.pertenece()) {

					if (res.save()) {
						view.present("Resolucion subida Correctamente");
					} else {
						view.present("verifique los datos ingresados sean validos");
					}
				} else {
					view.present("Usted ya subio una resolucion de esta Actividad");
				}
			} else {
				view.present("por favor selecciones una actividad");
			}
		} else {
			view.present("Faltar Completar Campo Resolucion");
		}
	}

	public static String getNota(String codActividad) {
		Resolucion reso = new Resolucion();
		return reso.getNota(getCodigoAlumno(), codActividad);
	}

	private String getDniDocente() {

		try {
			return Subject.getSubject(
					Actividad.getCodMateriaActividad(view.getCodActividad()))
					.getRTeacher();

		} catch (ActividadNotFound e) {
			// TODO Auto-generated catch block
			return "";

		}

	}

	private void showMateriasAinscribirInList() { // mostrar la lista con las //
		try { // materias en la que se pueede inscribir
			materiaAinscribirList = Subject.subjectList();
			view.setListaMaterias(materiaAinscribirList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	private void showMateriasInscriptoInList() { // mostra una lista con las
		try { // materias q esta incripto
			materiasIncriptoList = Cursa.cursaList(getCodigoAlumno());
			view.setListaMateriasInscripto(materiasIncriptoList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// pueede inscribir
	}

	private void showActividadInList() {// / mostrar las actividades que tieneun
										// alumno dado
		actividadList = TieneActividad
				.listaActividadesAlumnos(getCodigoAlumno());
		view.setListaActividad(actividadList);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see educar.controllers.IController#setView(educar.gui.IView)
	 */
	@Override
	public void setView(IView view) {
		this.view = (AlumnoView) view;
	}

}