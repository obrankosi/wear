package educar.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.AbstractButton;

import educar.controllers.IController;

public class RegistrarListener implements ActionListener {

    private Hashtable<AbstractButton, IController> componentControllerMap;

    public RegistrarListener() {
	componentControllerMap = new Hashtable<AbstractButton, IController>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	IController controller = componentControllerMap.get(e.getSource());

	if (null != controller) {
	    controller.process(e.getActionCommand());
	}
    }

    public void associate(AbstractButton button, IController controller) {
	button.addActionListener(this);
	componentControllerMap.put(button, controller);
    }
}
