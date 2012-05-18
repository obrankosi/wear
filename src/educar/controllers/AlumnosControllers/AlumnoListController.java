package educar.controllers.AlumnosControllers;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AlumnoView.AlumnoView;

/**
 * @author grupo wear
 *Controlador de la lista de inscripcion de materia de un alumno
 */
public class AlumnoListController implements IListController, IController {
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
