package educar.gui;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.RegistrarController;
import educar.gui.Listener.RootListener;
import educar.languaje.defaultLanguaje;


public class RootView extends JFrame implements IView, defaultLanguaje {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5081100611233717924L;
	private JPanel contentPane;
	private JTextField txtFUserName;
	private JPasswordField txtFPassword;
	private JButton btnBorrar;
	private JButton btnRegistrar;


	

	/**
	 * Create the frame.
	 */
	public RootView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		
		JLabel lblRegistrarAdministrador = new JLabel("Registrar Administrador");
		lblRegistrarAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarAdministrador.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 23));
		lblRegistrarAdministrador.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblRegistrarAdministrador.setAlignmentX(0.5f);
		lblRegistrarAdministrador.setBounds(0, 0, 434, 84);
		panel.add(lblRegistrarAdministrador);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Arial", Font.BOLD, 20));
		lblUserName.setBounds(0, 75, 146, 45);
		panel.add(lblUserName);
		
		txtFUserName = new JTextField(20);
		txtFUserName.setFont(new Font("Arial", Font.BOLD, 20));
		txtFUserName.setBounds(136, 75, 268, 45);
		panel.add(txtFUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblPassword.setBounds(0, 131, 146, 45);
		panel.add(lblPassword);
		
		txtFPassword = new JPasswordField(20);
		txtFPassword.setFont(new Font("Arial", Font.BOLD, 20));
		txtFPassword.setBounds(136, 131, 268, 45);
		panel.add(txtFPassword);
		
		btnBorrar = new JButton(DELETE);
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnBorrar.setBounds(78, 193, 117, 46);
		panel.add(btnBorrar);
		
		RootListener bBorrarAdmin = new RootListener();
		IController controlerResgistar = new RegistrarController();
		controlerResgistar.setView(this);
		bBorrarAdmin.associate(btnBorrar, controlerResgistar);
		
		btnRegistrar = new JButton(ADD);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegistrar.setBounds(243, 193, 117, 46);
		panel.add(btnRegistrar);
		// creo un listener para el botn y su controlador
				RootListener buttonListener = new RootListener();
				IController RegistrarController = new RegistrarController();
				RegistrarController.setView(this);
				buttonListener.associate(btnRegistrar, RegistrarController);
			}

			public void present(String model) {
				JOptionPane.showMessageDialog(null, model);
			}

			public String getUsername() {
				return txtFUserName.getText().trim();
			}

			public String getPassword() {
				return new String(txtFPassword.getPassword());
			}

			public void close() {
				
			}
}
