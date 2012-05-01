package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;

public class AdminController implements IController, defaultLanguaje {
    private administrador view;

    @Override
    public void process(String model) {
	if (model.compareTo(CLOSE_WINDOW) == 0) {
	    view.dispose();
	} else {
	    new administrador();
	}

    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (administrador) view;
    }
}
