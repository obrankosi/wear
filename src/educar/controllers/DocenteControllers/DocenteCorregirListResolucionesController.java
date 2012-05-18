package educar.controllers.DocenteControllers;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.AdminViews.FuncionesAuxiliares;
import educar.gui.DocenteView.DocenteView;
import educar.languaje.defaultLanguaje;
import educar.models.Resolucion;
import educar.models.ResolucionNotFound;
import educar.models.AdminModels.Alumno;

/**
 * @author grupo wear
 *Controlador Lista de Resoluciones de Docente en la historia correccion 
 */
public class DocenteCorregirListResolucionesController implements IController,
	IListController,defaultLanguaje {

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
	Alumno alumno;
	String dniAlumno;
	String nombreAlumno;
	String nota;
	Resolucion resolucion = null;
	String resolucionAlumno;
	String codResolucion = FuncionesAuxiliares.getCodActividad(item);

	try {
	    resolucion = Resolucion.getResolucionByCod(codResolucion);
	} catch (ResolucionNotFound e) {
	}
	nota = resolucion.getNota();
	resolucionAlumno = resolucion.getResolucion();
	dniAlumno = FuncionesAuxiliares.getCargo(item);
	alumno = Alumno.getAlumno(dniAlumno);
	nombreAlumno = alumno.getName() + " " + alumno.getLastName();

	view.setDniCorregir(dniAlumno);
	view.setNombreAlumnoCorregir(nombreAlumno);
	view.setTextAreaCorregir(resolucionAlumno);
	view.setNotaCorregir(nota);
	DocenteCorregirController.setCodResolucion(codResolucion);
	if(!(nota.compareTo("0")== 0)){
	    view.present(S74);
	}
    }

}
