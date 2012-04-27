package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.AdminView;
import educar.gui.IView;
import educar.gui.RootView;
import educar.gui.AdminViews.SubjectView;
import educar.gui.AdminViews.gestionAlumnosView;
import educar.languaje.defaultLanguaje;

public class AdminController implements IController, defaultLanguaje {
    private AdminView view;

    @Override
    public void process(String model) {
	if (model.compareTo(CLOSE_WINDOW) == 0) {
	    view.close();
	}
	if (model.compareTo(MANAGE_TEACHER) == 0) {
	    view.close();
	    new RootView(); // TEACHER VIEW
	}
	if (model.compareTo(MANAGE_STUDENT) == 0) {
	    view.close();
	    new gestionAlumnosView();
	}
	if (model.compareTo(MANAGE_CHARGE) == 0) {
	    view.close(); // CHARGE VIEW
	}
	if (model.compareTo(MANAGE_SUBJECT) == 0) {
	    view.close();
	    new SubjectView(); // SUBJECT VIEW
	}
	if (model.compareTo(MANAGE_FACULTY) == 0) {
	    view.close(); // FACULTY VIEW 
	}

    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
    	this.view = (AdminView) view;
    }
}
