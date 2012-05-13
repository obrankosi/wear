package educar.controllers.AdminController;

import java.sql.SQLException;
import java.util.LinkedList;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.AdminViews.administrador;
import educar.languaje.defaultLanguaje;
import educar.models.AdminModels.Cargos;
import educar.models.AdminModels.DedicacionDocente;
import educar.models.AdminModels.Docente;
import educar.models.AdminModels.Facultad;

public class DedicacionDocenteController implements IController,
	defaultLanguaje, IListController {

    private administrador view;
    private static LinkedList<String> docentes;
    private static LinkedList<String> facultades;
    private static LinkedList<String> cargos;
    private static DedicacionDocente newArg;
    private static LinkedList<String> docenteConCargo;

    @Override
    public void process(String model) {

	if (model.compareTo(CLEAR) == 0) {
	    view.setCamposVacioDD();
	}
	if (model.compareTo(MODIFY) == 0) {

	}
	if (model.compareTo(DELETE) == 0) {

	}
	if (model.compareTo(CLEAR) == 0) {
	    view.setCamposVacioDD();
	}
	if (model.compareTo(ADD) == 0) {
	    addDedicacionDocente();
	    listaDocenteCargoconDedicacion();
	}
    }

    private void addDedicacionDocente() {
	// si hay algun campo vacio avisa
	try {
	    cargos = Cargos.listCargosCod();
	} catch (SQLException e) {
	}
	if (!view.algunCampoVacioAlta()) {
	    if (!cargos.contains(view.getCargoAltaDedicacionDocente())) {
		view.present("el cargo ingresado no existe");
	    } else {
		// si no existe el cargo guardar
		String dniDocente = view.getDniAltaDedicacionDocente();
		String codCargo = view.getCargoAltaDedicacionDocente();
		String hsDedicacion = view.getDedicacionAltaDedicacionDocente();
		String codFacultad = view.getFacultadAltaDedicacionDocente();
		newArg = new DedicacionDocente(codFacultad, dniDocente,
			codCargo, hsDedicacion);
		if (DedicacionDocente.containtDedicacionDocente(newArg)) {
		    view.present("el docente ya posee cargo");
		} else {// ver si esta bien
		    if (DedicacionDocente.containtDedicacionCargo(newArg)) {
			view.present("el cargo ya esta ocupado");
		    } else {
			// **** guardar ****
			if (newArg.save()) {
			    view.present("guardado exitoso");
			}
		    }
		}

	    }

	} else {
	    view.present("faltan ingresar campos");
	}

    }

    private void listaDocenteCargoconDedicacion() {
	try {
	    docenteConCargo = DedicacionDocente.listDedicacion();
	    view.setListDedicacionDocenteAlta(docenteConCargo);
	} catch (SQLException e) {
	    view.present("no entro por la lista de los cargos");
	}
    }

    @Override
    public void setView(IView view) {
	this.view = (administrador) view;
    }

    // siempre
    @Override
    public void processItemList(String item) {
	try {
	    docentes = Docente.ListDocenteDni();
	    facultades = Facultad.ListFacultadCod();
	    cargos = Cargos.listCargosCod();
	} catch (SQLException e) {
	}
	String id = FuncionesAuxiliares.idString(item);
	String noId = FuncionesAuxiliares.nameString(item);

	// lo que trajo pertenece a docente
	if (docentes.contains(id)) {
	    view.setDniAltaDedicacionDocente(id);
	} else {
	    if (facultades.contains(id)) {
		view.setFacultadAltaDedicacionDocente(id);
	    }
	}

    }
}
