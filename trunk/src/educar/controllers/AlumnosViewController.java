package educar.controllers;

import educar.gui.IView;
import educar.gui.AlumnoView.AlumnoView;
import educar.languaje.defaultLanguaje;

/**
 * @author grupo wear
 * Controlador de la gui de Alumnos
 *
 */
public class AlumnosViewController implements IController, defaultLanguaje {

    private AlumnoView view;

    @Override
    public void process(String model) {
	if (model.compareTo(CARGARSOLUCIONALUMNOPANEL) == 0) {
	    view.panelCargarSolucion();
	    AlumnoControllers.showActividadInList();
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
