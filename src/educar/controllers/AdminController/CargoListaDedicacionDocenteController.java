package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;

/**
 * @author grupo wear
 * controlador de la lista de cargos de la historia Dedicacion Docente
 */
public class CargoListaDedicacionDocenteController implements IListController ,IController {

    private administrador view;
    
    @Override
    public void processItemList(String item) {
	view.setCargoAltaDedicacionDocente(FuncionesAuxiliares.idString(item));
    }
    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }
    @Override
    public void process(String model) {
    }

}
