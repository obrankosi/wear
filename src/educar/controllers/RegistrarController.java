package educar.controllers;

import educar.gui.IView;
import educar.gui.RootView;
import educar.models.User;

public class RegistrarController implements IController {
    private User admin;
    private RootView rView;

    @Override
    public void process(String model) {
	// creo el usuario nuevo y lo guardo en la BD
	admin = new User(rView.getUsername(), rView.getPassword(), "admin");
	if (admin.save()) {
	   //cierra la ventana de rootView
	    rView.close();
	    rView.present("Administrador Agregado");

	} else
	    rView
		    .present("No se pudo agregar administrador, verifique que el nombre de usuario no exista");
    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.rView = (RootView) view;
    }

}
