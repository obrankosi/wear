package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Docente;

public class ChargeController implements IController, defaultLanguaje {
    private Docente  docente;
    private administrador rView;
	
    @Override
	public void process(String model) {
		// TODO Auto-generated method stub
		
	}

		@Override
		public void setView(IView view) {
			// TODO Auto-generated method stub
			
		}
}