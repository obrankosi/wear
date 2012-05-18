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

/**
 * @author grupo wear
 *
 */
public class ChargeController implements IController, defaultLanguaje,
	IListController {
 
    private static Cargos cargo;
    private static LinkedList<String> cargosList;
    private administrador rView;

    @Override
    public void process(String model) {
	if (model.compareTo(SEARCH) == 0) {
	    searchChargeInDBase();
	    showCargosInList();
	}
	if (model.compareTo(ADD) == 0) {
	    saveChargeInDBase();
	    rView.clearNombreAltaCargo();
	    showCargosInList();
	}

	if (model.compareTo(MODIFY) == 0) {
	    modifyChargeInDBase();
	    rView.clearModificarCargo();
	    showCargosInList();
	}

	if (model.compareTo(DELETE) == 0) {
	    deleteChargeInDBase();
	    rView.clearModificarCargo();
	    showCargosInList();
	}

	if (model.compareTo(CLEAR) == 0) {
	    showCargosInList();
	    rView.clearModificarCargo();
	}

    }

    /**
     * Borra un cargo de la base de datos 
     */
    private void deleteChargeInDBase() {
	searchChargeInDBase();
	if (!(rView.getCodigoModificarCargo().compareTo("") == 0)) {
	    if (cargo.destroy()) {
		rView.present(BORRADOEXITOSO);
	    } else
		rView
			.present(S15);

	}
    }

    /**
     * modifica cargo de la base de datos
     */
    private void modifyChargeInDBase() {
	if (cargo != null) {
	    String[] values = { rView.getNombreModificarCargo() };
	    try {
		cargo.update(values, cargo.getCodigoCargo());
		rView.present(ACTUALIZACIONEXITOSO);
	    } catch (SQLException e) {
		rView.present(ACTUALIZACIONFALLIDA);
	    }
	} else {
	    rView.present(S16);
	}

    }

    /**
     * guarda cargo en la base de datos
     */
    private void saveChargeInDBase() {
	if (rView.fieldsIsOkAltaCargo()) {
	    Cargos cargo = new Cargos(rView.getNombreAltaCargo());
	    if (cargo.save()) {
		rView.present(S17);

	    } else {
		rView.present(S18);
	    }
	} else {
	    rView.present(FALTANCOMPLETARCAMPOS);
	}
    }

    /**
     * busca cargo
     */
    private void searchChargeInDBase() {
	cargo = Cargos.getCargo(rView.getCodigoModificarCargo());
	if (cargo != null) {
	    rView.setCodigoModificarCargo(cargo.getCodigoCargo());
	    rView.setNombreModificarCargo(cargo.getNombreCargo());
	} else {
	    rView.present(S19);
	    rView.clearModificarCargo();
	}
    }

    private void showCargosInList() {
	try {
	    cargosList = Cargos.listaCargos();
	    rView.setListModificarCargos(cargosList);
	} catch (SQLException e) {
	    rView.present(ERROR);
	}
    }

    @Override
    public void setView(IView view) {
	this.rView = (administrador) view;
    }

    @Override
    public void processItemList(String item) {
	this.rView.setCodigoModificarCargo(FuncionesAuxiliares.idString(item));
	this.rView
		.setNombreModificarCargo(FuncionesAuxiliares.nameString(item));
    }

}