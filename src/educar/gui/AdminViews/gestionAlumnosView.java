package educar.gui.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class gestionAlumnosView extends JFrame {

	private JPanel contentPane;
	private JTextField tfDni_alta;
	private JTextField tfNombre_alta;
	private JTextField tfApellido_alta;
	private JTextField tfFechaNac_alta;
	private JTextField tfTelefono_alta;
	private JTextField tfDireccion_alta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionAlumnosView frame = new gestionAlumnosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gestionAlumnosView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_alta = new JPanel();
		tabbedPane.addTab("Alta", null, panel_alta, null);
		panel_alta.setLayout(null);
		
		JLabel lblDni_alta = new JLabel("DNI");
		lblDni_alta.setBounds(10, 0, 419, 28);
		panel_alta.add(lblDni_alta);
		
		tfDni_alta = new JTextField();
		tfDni_alta.setText("");
		tfDni_alta.setBounds(66, 4, 158, 20);
		panel_alta.add(tfDni_alta);
		tfDni_alta.setColumns(10);
		
		JLabel lblNombre_alta = new JLabel("Nombre");
		lblNombre_alta.setBounds(10, 29, 46, 14);
		panel_alta.add(lblNombre_alta);
		
		JLabel lblApellido_alta = new JLabel("Apellido");
		lblApellido_alta.setBounds(10, 54, 46, 14);
		panel_alta.add(lblApellido_alta);
		
		JLabel lblFechanac_alta = new JLabel("fechaNac");
		lblFechanac_alta.setBounds(10, 79, 46, 14);
		panel_alta.add(lblFechanac_alta);
		
		JLabel lblTelefono_alta = new JLabel("Telefono");
		lblTelefono_alta.setBounds(10, 104, 46, 14);
		panel_alta.add(lblTelefono_alta);
		
		JLabel lblDireccion_alta = new JLabel("Direccion");
		lblDireccion_alta.setBounds(10, 129, 46, 14);
		panel_alta.add(lblDireccion_alta);
		
		tfNombre_alta = new JTextField();
		tfNombre_alta.setBounds(66, 26, 158, 20);
		panel_alta.add(tfNombre_alta);
		tfNombre_alta.setColumns(10);
		
		tfApellido_alta = new JTextField();
		tfApellido_alta.setBounds(66, 51, 158, 20);
		panel_alta.add(tfApellido_alta);
		tfApellido_alta.setColumns(10);
		
		tfFechaNac_alta = new JTextField();
		tfFechaNac_alta.setBounds(66, 76, 158, 20);
		panel_alta.add(tfFechaNac_alta);
		tfFechaNac_alta.setColumns(10);
		
		tfTelefono_alta = new JTextField();
		tfTelefono_alta.setBounds(66, 101, 158, 20);
		panel_alta.add(tfTelefono_alta);
		tfTelefono_alta.setColumns(10);
		
		tfDireccion_alta = new JTextField();
		tfDireccion_alta.setBounds(66, 126, 158, 20);
		panel_alta.add(tfDireccion_alta);
		tfDireccion_alta.setColumns(10);
		
		JButton btnAdd_alta = new JButton("Add");
		btnAdd_alta.setBounds(138, 157, 89, 23);
		panel_alta.add(btnAdd_alta);
		
		JPanel panel_modif = new JPanel();
		tabbedPane.addTab("Modificacion", null, panel_modif, null);
		
		JPanel panel_baja = new JPanel();
		tabbedPane.addTab("Baja", null, panel_baja, null);
	}
}
