package educar.controllers;

import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.DocenteView.DocenteView;
import educar.models.Actividad;
import educar.models.ActividadNotFound;
import educar.models.Resolucion;
import educar.models.ResolucionNotFound;
import educar.models.AdminModels.Alumno;

public class DocenteListaActividadesBorrar implements IController,
	IListController {

    private DocenteView view;

    @Override
    public void process(String model) {

    }

    @Override
    public void setView(IView view) {
	this.view = (DocenteView) view;
    }

    @Override
    public void processItemList(String item) {
	Actividad act = null;
	String codActividad = FuncionesAuxiliares.getCodActividad(item);
	try {
	    act = Actividad.getActividad(codActividad);
	} catch (ActividadNotFound e) {
	}
	view.setDEscripcionDeleteActividad(act.getDescripcionActividad());
	view.setCodigoMateriaDeleteActividad(act.getCodigoActividad());
    }

}
