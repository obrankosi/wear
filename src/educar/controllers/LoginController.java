package educar.controllers;

import educar.gui.AdminView;
import educar.gui.IView;
import educar.gui.LoginView;
import educar.gui.RootView;
import educar.models.Session;
import educar.models.User;

public class LoginController implements IController {
    private LoginView view;

    public void process(String model) {
	if (null != view)
	    if (User.authenticate(((LoginView) view).getUsername(),
		    ((LoginView) view).getPassword())) {
		view.present("you are logged in as: "
			+ Session.getCurrentUser().getUsername());
		view.close();
		openView(Session.getCurrentUser());

	    } else {
		view.present("Wrong username/password");
	    }
    }

    private void openView(User currentUser) {
	String role = Session.getCurrentUser().getRole();
	// Segun el tipo de usario, es la View que abre
	if (role.equals("root")) {
	    new RootView().setVisible(true);
	}
	if (role.equals("admin")) {
	    new AdminView().setVisible(true);
	}
	// if (role.equals("teacher")) {
	// goTeacherWindow();
	// }
	// if (role.equals("student")) {
	// goStudentWindow();
	// }
    }

    @Override
    public void setView(IView view) {
	this.view = (LoginView) view;
    }
}
