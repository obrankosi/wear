package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;

public class listaMateriaModificarController implements IListController,
	IController {

    private administrador view;

    @Override
    public void processItemList(String item) {
	view.setModifyNameTF_M(FuncionesAuxiliares.nombreMateria(item));
	view.setModifyCodeTF_M(FuncionesAuxiliares.idString(item));
	view.setFacultadModificarMateria(FuncionesAuxiliares
		.facultadMateria(item));

    }

    @Override
    public void process(String model) {

    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

}
