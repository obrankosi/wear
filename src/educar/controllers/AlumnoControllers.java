package educar.controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import educar.gui.IView;
import educar.gui.AlumnoView.AlumnoView;
import educar.languaje.defaultLanguaje;
import educar.models.Actividad;
import educar.models.ActividadNotFound;
import educar.models.Cursa;
import educar.models.Resolucion;
import educar.models.Session;
import educar.models.TieneActividad;
import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Subject;

public class AlumnoControllers implements IController, defaultLanguaje,
		IListController {
	private static Cursa cursa;
	private static LinkedList<String> actividadList;
	private static LinkedList<String> materiasIncriptoList;
	private static LinkedList<String> materiaAinscribirList;
	private static AlumnoView view;

	@Override
	public void process(String model) {
		if (model.compareTo(SUBIR) == 0) {
			saveActividadInDBase();
			// view.setVacioCargarSolucion(); // limpia los campo
		}
		if (model.compareTo(ADD) == 0) {
			saveMateriasInDBase();

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
				Date fecha = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formato2 = new SimpleDateFormat("H:mm:ss");

				Resolucion res = new Resolucion(formato2.format(fecha),
						formato.format(fecha), getDniDocente(),
						view.getCodActividad(), getCodigoAlumno(),
						view.getSolucionActividad(), view.getNota());
				if (!res.pertenece()) {

					if (res.save()) {
						view.present("Resolucion subida Correctamente");
					} else {
						view.present("verifique los datos ingresados sean validos");
					}
				} else {
					Resolucion fecha1 = new Resolucion();
					view.present("Usted ya subio una resolucion de esta Actividad el dia : "
							+ fecha1.getFecha(getCodigoAlumno(),
									view.getCodActividad()));
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

	public static void showMateriasAinscribirInList() { // mostrar la lista con
														// las //
		try { // materias en la que se pueede inscribir
			materiaAinscribirList = Subject.subjectList();
			view.setListaMaterias(materiaAinscribirList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	public static void showMateriasInscriptoInList() { // mostra una lista con
														// las
		try { // materias q esta incripto
			materiasIncriptoList = Cursa.cursaList(getCodigoAlumno());
			view.setListaMateriasInscripto(materiasIncriptoList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// pueede inscribir
	}

	public static void showActividadInList() {// / mostrar las actividades que
												// tieneun
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
