package educar.controllers;

import educar.gui.IView;

public interface IController {
	public void setView(IView view);
	public void process(String model);
}
