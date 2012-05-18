package educar.controllers;

import educar.gui.IView;
import educar.gui.RootView;
import educar.languaje.defaultLanguaje;
import educar.models.User;
import educar.models.userNotFound;

public class RegistrarController implements IController, defaultLanguaje {
    private static User admin;
    private RootView rView;

    @Override
    public void process(String model) {
	if (model.compareTo(DELETE) == 0) {
	    deleteAdministrator();
	}

	if (model.compareTo(ADD) == 0) {
	    saveAdministrador();
	}
    }

    private void saveAdministrador() {
	try {
	    if (rView.getUsername().compareTo("") == 0
		    || rView.getPassword().compareTo("") == 0) {
		throw new Exception();
	    }
	    // creo el usuario nuevo y lo guardo en la BD
	    admin = new User(rView.getUsername(), rView.getPassword(), "admin");
	    if (admin.save()) {
		// cierra la ventana de rootView
		rView.close();
		rView.present(S75);

	    } else
		rView.present(S76);

	} catch (Exception e) {
	    rView.present(S77);
	}
    }

    @Override
    public void setView(IView view) {
	this.rView = (RootView) view;
    }

    /**
     * 
     */
    private void deleteAdministrator() {
	try {
	    admin = User.getUserByUsername(rView.getUsername());
	    if (rView.getUsername().compareTo("") != 0
		    && rView.getPassword().compareTo("") != 0) {
		if (admin.destroy()) {
		    rView.present(S78);
		} else {
		    rView.present(S79);

		}
	    }
	} catch (userNotFound e) {
	    rView.present(S80);
	}
    }
}