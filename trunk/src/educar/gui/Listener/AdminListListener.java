package educar.gui.Listener;

import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

import educar.controllers.IController;

public class AdminListListener implements ItemListener {

    private Hashtable<List, IController> componentControllerMap;

    public AdminListListener() {
	componentControllerMap = new Hashtable<List, IController>();
    }

    public void associate(List list, IController controller) {
	list.addItemListener(this);
	componentControllerMap.put(list, controller);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	
    }

    // @Override
    // public void itemStateChanged(ItemEvent item) {
    // IController controller = componentControllerMap.get(item.getSource());//
    // me
    // if (null != controller) {
    // controller.processItemList(item.paramString());
    // }
    //
    // }
}
