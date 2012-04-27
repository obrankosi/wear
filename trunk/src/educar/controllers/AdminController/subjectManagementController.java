package educar.controllers.AdminController;

import educar.controllers.IController;
import educar.gui.IView;
import educar.gui.AdminViews.SubjectView;
import educar.models.Subject;

public class subjectManagementController implements IController {

	private SubjectView view;
	private Subject materia;
	
	
	
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		this.view = (SubjectView) view;
	}

	@Override
	public void process(String model) {
		// TODO Auto-generated method stub
		if (model.compareTo("Clear") == 0) {
			view.setEmptyFields();
		}
		if (model.compareTo("Buscar") == 0) {
			materia = Subject.getSubject();
			view.setModifyCodeTF(materia.getSubject());
			view.setModifyNameTF(materia.getName());
		}
		if (model.compareTo("Delete") == 0) {
			materia.deleteSubject();
		}
		
		// hacer que borre todos los espacios en blanco!! 
		
	}
	private 
	

}
