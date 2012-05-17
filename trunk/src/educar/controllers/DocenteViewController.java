package educar.controllers;

import educar.controllers.DocenteCorregirController;
import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;

public class DocenteViewController implements IController, defaultLanguaje {

    private DocenteView view;

    @Override
    public void process(String model) {
	if (model.compareTo(ACTIVIDADOCENTEPANEL) == 0) {
	    view.panelActividad();
	    view.setListMAteriaD(DocenteController.misMaterias());
	}
	if (model.compareTo(CORREGIRDOCENTEPANEL) == 0) {
	    view.panelCorregir();
	    view.setListActividadD((DocenteController.misActividades()));
	}
    }

    @Override
    public void setView(IView view) {
	this.view = (DocenteView) view;
    }

    
    
}
