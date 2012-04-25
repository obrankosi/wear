package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.AdminView;
import educar.gui.IView;
import educar.gui.RootView;
import educar.gui.AdminViews.gestionAlumnosView;

public class AdminController implements IController {
    private AdminView view;

    @Override
    public void process(String model) {
	if (model.compareTo("cerrar") == 0) {
	    view.close();
	}
	if (model.compareTo("Gestionar Docente") == 0) {
	    view.close();
	    new RootView();
	}
	if (model.compareTo("Gestionar Alumno") == 0) {
	    view.close();
	    new gestionAlumnosView().setVisible(true);
	}
	if (model.compareTo("Gestionar Cargo") == 0) {
	    view.close();
	}
	if (model.compareTo("Gestionar Materia") == 0) {
	    view.close();
	}
	if (model.compareTo("Gestionar Facultad") == 0) {
	    view.close();
	}
>>>>>>> .r16
    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
    	this.view = (AdminView) view;
    }
}
