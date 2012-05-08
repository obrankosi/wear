package educar.gui.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.AbstractButton;

import educar.controllers.IController;

public class AdminListener implements ActionListener {

    private Hashtable<AbstractButton, IController> componentControllerMap;

    public AdminListener() {
	componentControllerMap = new Hashtable<AbstractButton, IController>();
    }

    public void associate(AbstractButton button, IController controller) {
	button.addActionListener(this);
	componentControllerMap.put(button, controller);
    }

    // e.getSource The object on which the Event initially occurred.
    // Returns:
    // The object on which the Event initially occurred.
    // es el evento que ocurrio en este caso trae el boton apretado que KEY en
    // la tabla
    @Override
    public void actionPerformed(ActionEvent e) {
	IController controller = componentControllerMap.get(e.getSource());// me
	// da
	// el
	// controlador
	// del
	// evnto
	if (null != controller) {
	    controller.process(e.getActionCommand());
	}
    }
}
