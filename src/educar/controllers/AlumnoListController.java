package educar.controllers;

import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AlumnoView.AlumnoView;


	
	public class AlumnoListController implements IListController,
		IController {
	    private AlumnoView view;

	    @Override
	    public void processItemList(String item) {

		view.setCodigoMateria(FuncionesAuxiliares.idString(item));
	    }

	    @Override
	    public void process(String model) {

	    }

	    @Override
	    public void setView(IView view) {
		this.view = (AlumnoView) view;
	    }

	}


