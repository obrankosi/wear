package educar.controllers.AlumnosControllers;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AlumnoView.AlumnoView;
import educar.languaje.defaultLanguaje;
import educar.models.Actividad;
import educar.models.ActividadNotFound;

/**
 * @author grupo wear Controlador de las lista de actividades de un alumno
 */
public class AlumnoListSolucionController implements IListController,
	IController,defaultLanguaje {
    private AlumnoView view;

    @Override
    public void processItemList(String item) {
	view.setCodActividad(FuncionesAuxiliares.getCodActividad(item));
	if (!(view.getCodActividad().compareTo("") == 0)) {
	    try {
		view.setDescripcionActividad(Actividad.getActividad(
			view.getCodActividad()).getDescripcionActividad());
		view.setNota(AlumnoControllers.getNota(view.getCodActividad()));
		view.setSolucionActividad(AlumnoControllers.getSolucion(view
			.getCodActividad()));
	    } catch (ActividadNotFound e) {
		view.present(S59);
	    }
	}
    }

    @Override
    public void process(String model) {

    }

    @Override
    public void setView(IView view) {
	this.view = (AlumnoView) view;
    }

}
