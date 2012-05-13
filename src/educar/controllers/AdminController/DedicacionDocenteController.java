package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;

public class DedicacionDocenteController implements IController,
	defaultLanguaje, IListController {

    private administrador view;
    
    
    
    @Override
    public void process(String model) {
	
	if (model.compareTo(CLEAR) == 0) {

	}
	if (model.compareTo(MODIFY) == 0) {

	}
	if (model.compareTo(DELETE) == 0) {

	}
	if (model.compareTo(CLEAR) == 0) {

	}
	if (model.compareTo(ADD) == 0) {

	}
    }
    

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    @Override
    public void processItemList(String item) {
	// TODO Auto-generated method stub

    }

}
