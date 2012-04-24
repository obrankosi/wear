package educar.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.RegistrarController;
import educar.gui.Listener.RootListener;

public class RootView extends JFrame implements IView {
    /**
     * 
     */
    //esto puede ir o no lo agrega el eclipse por un supuesto warning
    private static final long serialVersionUID = 1L;
    private JFrame jfWindow;
    JTextField tfUsername;
    JPasswordField pfPassword;

    public RootView() {
	jfWindow = new JFrame();
	java.awt.Container container = jfWindow.getContentPane();

	setupMainContainer(container);

	jfWindow.pack();
	jfWindow.setVisible(true);
	jfWindow.setResizable(false);
	jfWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setupMainContainer(Container container) {
	container.setLayout((LayoutManager) new BoxLayout(jfWindow
		.getContentPane(), BoxLayout.Y_AXIS));

	((JComponent) container).setBorder(new EmptyBorder(20, 20, 20, 20));

	JLabel lblAddAdm = new JLabel("Registrar Administrador");
	lblAddAdm.setAlignmentX(Component.CENTER_ALIGNMENT);
	lblAddAdm.setFont(new Font("Serif", Font.BOLD, 16));
	lblAddAdm.setBorder(new EmptyBorder(10, 10, 10, 10));
	container.add(lblAddAdm);

	// Lay out the buttons from left to right.
	JLabel lblUserName = new JLabel("usuario     ");
	tfUsername = new JTextField(20);
	JPanel usernamePane = new JPanel();
	usernamePane
		.setLayout(new BoxLayout(usernamePane, BoxLayout.LINE_AXIS));
	usernamePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
	usernamePane.add(Box.createHorizontalGlue());
	usernamePane.add(lblUserName);
	Component rigidArea = Box.createRigidArea(new Dimension(10, 0));
	usernamePane.add(rigidArea);
	usernamePane.add(tfUsername);
	container.add(usernamePane);

	// Lay out the buttons from left to right.
	JLabel lblPassword = new JLabel("password ");
	pfPassword = new JPasswordField(20);
	JPanel passwordPane = new JPanel();
	passwordPane
		.setLayout(new BoxLayout(passwordPane, BoxLayout.LINE_AXIS));
	passwordPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
	passwordPane.add(lblPassword);
	passwordPane.add(Box.createRigidArea(new Dimension(10, 0)));
	passwordPane.add(pfPassword);
	container.add(passwordPane, BorderLayout.PAGE_END);

	JButton bRegistrar = new JButton("Registrar");
	bRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
	container.add(bRegistrar);

	// creo un listener para el botn y su controlador
	RootListener buttonListener = new RootListener();
	IController RegistrarController = new RegistrarController();
	// le paso esta view al controlador para poder obtener el userName y el
	// password
	RegistrarController.setView(this);
	buttonListener.associate(bRegistrar, RegistrarController);
    }

    public void present(String model) {
	JOptionPane.showMessageDialog(null, model);
    }

    public String getUsername() {
	return tfUsername.getText().trim();
    }

    public String getPassword() {
	return new String(pfPassword.getPassword());
    }

    public void close() {
	jfWindow.dispose();
    }
}
