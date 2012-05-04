package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.administrador;
import educar.models.AdminModels.Subject;

public class subjectManagementController implements IController {

    private administrador view;
    private Subject materia;

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.view = (administrador) view;
    }

    @Override
    public void process(String model) {
	// TODO Auto-generated method stub
	if (model.compareTo("Clear") == 0) {
	    view.setEmptyFields();
	}
	if (model.compareTo("Buscar") == 0) {
	    materia = materia.getSubject();
	    if (materia != null) {
		actualizarView();
	    } else {
		view.present("La materia no existe");
	    }
	}
	if (model.compareTo("Delete") == 0) {
	    if (materia.deleteSubject())
		view.present("Materia borrada exitosamente");
	    else
		view.present("La materia no existe");
	}

	// hacer que borre todos los espacios en blanco!!

    }

    private void actualizarView() {
	view.setModifyCodeTF_M(materia.getCode());
	view.setModifyNameTF_M(materia.getName());
    }

    // modificar para realizar la conexion a la base de datos
    private void getSubjectFromDB() {
	// TODO Auto-generated method stub
	materia.setCode(view.getModifyCodeTF_M());
	materia = materia.getSubject();
	if (materia != null) {
	    view.setModifyCodeTF_M(materia.getCode());
	    view.setModifyNameTF_M(materia.getName());
	} else {
	    view.present("El codigo de la materia no existe o es incorrecto");
	    view.setEmptyFields();
	}

    }
}
