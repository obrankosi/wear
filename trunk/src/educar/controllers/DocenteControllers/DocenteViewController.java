package educar.controllers.DocenteControllers;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;

/**
 * @author grupo wear Controlador de la gui de doncete
 */
public class DocenteViewController implements IController, defaultLanguaje {

    private DocenteView view;

    @Override
    public void process(String model) {
	if (model.compareTo(ACTIVIDADOCENTEPANEL) == 0) {
	    view.panelActividad();
	    view.setListMAteriaD(DocenteController.misMaterias());
	    view.setListActividadD(DocenteController.misActividades());
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
