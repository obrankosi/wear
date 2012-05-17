package educar.controllers;

import java.util.Date;

import educar.gui.IView;
import educar.gui.AlumnoView.AlumnoView;
import educar.languaje.defaultLanguaje;

public class AlumnosViewController implements IController, defaultLanguaje {

	private AlumnoView view;

	@SuppressWarnings("deprecation")
	@Override
	public void process(String model) {
		if (model.compareTo(CARGARSOLUCIONALUMNOPANEL) == 0) {
			view.panelCargarSolucion();
			AlumnoControllers.showActividadInList();
			Date d=new Date(); 
			System.out.println(Integer.toString(d.getDay())); 
		}
		if (model.compareTo(INSCRIBIRMALUMNOPANEL) == 0) {
			view.panelInscripcionMateria();
			AlumnoControllers.showMateriasInscriptoInList();
			AlumnoControllers.showMateriasAinscribirInList();
		}
	}

	@Override
	public void setView(IView view) {
		this.view = (AlumnoView) view;
	}

}
