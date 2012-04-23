package educar.controllers;

import educar.gui.IView;
import educar.gui.LoginView;
import educar.models.Session;
import educar.models.User;

public class LoginController implements IController {
	private LoginView view;

	public void process(String model){
		if(null!=view)
			if (User.authenticate(view.getUsername(), view.getPassword())){
				view.present("you are logged in as: " + Session.getCurrentUser().getUsername());
			} else {
				view.present("Wrong username/password");
			}
	}

	@Override
	public void setView(IView view) {
		this.view = (LoginView) view;	
	}	
}
