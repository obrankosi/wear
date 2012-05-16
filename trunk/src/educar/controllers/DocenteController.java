package educar.controllers;

import java.util.LinkedList;

import educar.gui.IView;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;
import educar.models.Actividad;

public class DocenteController implements IController, defaultLanguaje,
		IListController {

	private static DocenteView view;
	private Actividad actividad;
	private static LinkedList<String> materias;

	@Override
	public void process(String model) {
		if (model.compareTo("SUBIR") == 0) {
			if (view.hasDescriptionAddActividad() && view.hasCodeAddActividad()) {
				actividad.save();
				view.limpiarCamposActividad();
				view.present("La actividad ha sido guardada con exito");
			} else {
				view.present("Ingrese la descripcion de la actividad o seleccione la materia");
			}
		}
		if (model.compareTo("BORRAR") == 0) {
			if (view.hasDescriptionDeleteActividad()
					&& view.hasCodeDeleteActividad()) {
				actividad.deleteActividad();
				view.limpiarCamposActividad();
				view.present("La actividad ha sido borrada con exito. NOTA: Tambien ha sido borrada de los alumnos que la realizaban");
			} else {
				view.present("Seleccione la actividad");
			}

		}

	}

	@Override
	public void processItemList(String item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setView(IView view) {
		this.view = (DocenteView) view;
	}

}
