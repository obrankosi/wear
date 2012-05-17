package educar.controllers;

import educar.gui.IView;
import educar.gui.AlumnoView.AlumnoView;
import educar.languaje.defaultLanguaje;

public class AlumnosViewController implements IController, defaultLanguaje {

    private AlumnoView view;

    @Override
    public void process(String model) {
	if (model.compareTo(CARGARSOLUCIONALUMNOPANEL) == 0) {
	     view.panelCargarSolucion();
	     //ACA LLENA LA LISTA DEL PANEL SOLUCION
	}
	if (model.compareTo(INSCRIBIRMALUMNOPANEL) == 0) {
	     view.panelInscripcionMateria();
	     //ACA LLENA LA LISTA DEL PANEL SOLUCION
	}
    }

    @Override
    public void setView(IView view) {
	this.view = (AlumnoView) view;
    }

}
