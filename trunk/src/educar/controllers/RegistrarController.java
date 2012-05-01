package educar.controllers;

import educar.gui.IView;
import educar.gui.RootView;
import educar.languaje.defaultLanguaje;
import educar.models.User;
import educar.models.userNotFound;

public class RegistrarController implements IController, defaultLanguaje {
    private static User admin;
    private RootView rView;

    @Override
    public void process(String model) {
    	if (model.compareTo(DELETE) == 0) {
    	    deleteAdministrator();
    	}
    
    	if (model.compareTo(ADD) == 0) {
    	    saveAdministrador();
    	}}
    	
    	
    	
    private void saveAdministrador(){	
	try {
	    if (rView.getUsername().compareTo("") == 0 || rView.getPassword().compareTo("") == 0) 
	    {throw new Exception();}
	    // creo el usuario nuevo y lo guardo en la BD
	    admin = new User(rView.getUsername(), rView.getPassword(), "admin");
	    if (admin.save()) {
		// cierra la ventana de rootView
		rView.close();
		rView.present("Administrador Agregado");

	    } else
		rView
			.present("No se pudo agregar administrador, verifique que el nombre de usuario no exista");

	} catch (Exception e) {
	    rView.present("Ingrese los campos faltantes");
	}
    }

    @Override
    public void setView(IView view) {
	// TODO Auto-generated method stub
	this.rView = (RootView) view;
    }

    /**
     * 
     */
    private void deleteAdministrator() {
	try {
	    admin = User.getUserByUsername(rView.getUsername());
	    if (rView.getUsername().compareTo("") != 0 && rView.getPassword().compareTo("") != 0) 
	    {  
	    	if (admin.destroy()) {
	    	    rView.present("Administrador Borrado con exito");
	    	} else {
	    	    rView.present("NO se pudo borrar el administrador ");
	    	
	    	}
	}
	    } catch (userNotFound e) {
	    // TODO Auto-generated catch block
	    rView.present("El nombre de usuario  no existe  o  campos vacios");
	}
   }
}