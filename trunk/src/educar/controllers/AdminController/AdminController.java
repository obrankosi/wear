package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.AdminView;
import educar.gui.IView;

public class AdminController implements IController {
    private AdminView view;

    @Override
    public void process(String model) {
	view.close();
    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (AdminView) view;
    }
}
