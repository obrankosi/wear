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
import educar.controllers.LoginController;
import educar.gui.Listener.LoginListener;
import educar.languaje.defaultLanguaje;

public class LoginView implements IView, defaultLanguaje {
    private JFrame jfWindow;
    JTextField tfUsername;
    JPasswordField pfPassword;

    public LoginView() {
	jfWindow = new JFrame();
	jfWindow.setVisible(true);
	jfWindow.setResizable(false);
	
	Container container = jfWindow.getContentPane();
	setupMainContainer(container);

	jfWindow.pack();
	jfWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setupMainContainer(Container container) {
	container.setLayout((LayoutManager) new BoxLayout(jfWindow
		.getContentPane(), BoxLayout.Y_AXIS));

	((JComponent) container).setBorder(new EmptyBorder(20, 20, 20, 20));

	JLabel lblWelcome = new JLabel(WELCOME);
	lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
	lblWelcome.setFont(new Font("Serif", Font.BOLD, 16));
	lblWelcome.setBorder(new EmptyBorder(10, 10, 10, 10));
	container.add(lblWelcome);

	// Lay out the buttons from left to right.
	JLabel lblUserName = new JLabel(USERNAME + ":");
	tfUsername = new JTextField(20);
	JPanel usernamePane = new JPanel();
	usernamePane
		.setLayout(new BoxLayout(usernamePane, BoxLayout.LINE_AXIS));
	usernamePane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
	usernamePane.add(Box.createHorizontalGlue());
	usernamePane.add(lblUserName);
	usernamePane.add(Box.createRigidArea(new Dimension(10, 0)));
	usernamePane.add(tfUsername);
	container.add(usernamePane);

	// Lay out the buttons from left to right.
	JLabel lblPassword = new JLabel(PASSWORD + ":");
	pfPassword = new JPasswordField(20);
	JPanel passwordPane = new JPanel();
	passwordPane
		.setLayout(new BoxLayout(passwordPane, BoxLayout.LINE_AXIS));
	passwordPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
	passwordPane.add(Box.createHorizontalGlue());
	passwordPane.add(lblPassword);
	passwordPane.add(Box.createRigidArea(new Dimension(10, 0)));
	passwordPane.add(pfPassword);
	container.add(passwordPane, BorderLayout.PAGE_END);

	JButton bLogin = new JButton(LOGIN);
	bLogin.setAlignmentX(Component.RIGHT_ALIGNMENT);
	container.add(bLogin);

	LoginListener buttonListener = new LoginListener();
	IController loginController = new LoginController();
	loginController.setView(this);
	buttonListener.associate(bLogin, loginController);
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
