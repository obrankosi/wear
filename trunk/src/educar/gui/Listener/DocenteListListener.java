package educar.gui.Listener;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import educar.controllers.IListController;

public class DocenteListListener implements ActionListener {
	private Hashtable<List, IListController> componentControllerMap;

	public DocenteListListener() {
		componentControllerMap = new Hashtable<List, IListController>();
	}

	public void associate(List list, IListController controller) {
		list.addActionListener(this);
		componentControllerMap.put(list, controller);
	}

	@Override
	public void actionPerformed(ActionEvent item) {
		IListController controller = componentControllerMap.get(item
				.getSource());

		if (null != controller) {
			controller.processItemList(item.getActionCommand());
		}

	}

}
