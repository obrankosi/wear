package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;

public class HsDedicacionDocenteListController implements IListController,
	IController {
    private administrador view;

    @Override
    public void processItemList(String item) {

	view.setDniModificarDedicacionDocente(FuncionesAuxiliares.getDni(item));
	view.setFacultadModificarDedicacionDocente(FuncionesAuxiliares
		.getfacultad(item));
	view.setCargoModificarDedicacionDocente(FuncionesAuxiliares
		.getCargo(item));
	view.setDedicacionModificarDedicacionDocente(FuncionesAuxiliares
		.getHs(item));
    }

    @Override
    public void process(String model) {

    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

}
