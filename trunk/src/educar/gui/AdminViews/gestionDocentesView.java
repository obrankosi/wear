package educar.gui.AdminViews;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import educar.gui.IView;

public class gestionDocentesView extends JFrame implements IView
{

	private JPanel contentPane;
	private JTextField tfDni_alta;
	private JTextField tfNombre_alta;
	private JTextField tfApellido_alta;
	private JTextField tfFecha_alta;
	private JTextField tfTelefono_alta;
	private JTextField tfDireccion_alta;
	private JTextField tfDni_modif;
	private JTextField tfNombre_modif;
	private JTextField tfApellido_modif;
	private JTextField tfFechaNac_modif;
	private JTextField tfTelefono_modif;
	private JTextField tfDireccion_modif;

	
	/**
	 * Create the frame.
	 */
	public gestionDocentesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelAlta_doc = new JPanel();
		tabbedPane.addTab("Alta", null, panelAlta_doc, null);
		panelAlta_doc.setLayout(null);
		
		JLabel lblDni_alta = new JLabel("DNI");
		lblDni_alta.setBounds(10, 11, 46, 14);
		panelAlta_doc.add(lblDni_alta);
		
		tfDni_alta = new JTextField();
		tfDni_alta.setBounds(105, 8, 86, 20);
		panelAlta_doc.add(tfDni_alta);
		tfDni_alta.setColumns(10);
		
		JLabel lblNombre_alta = new JLabel("Nombre");
		lblNombre_alta.setBounds(10, 46, 46, 14);
		panelAlta_doc.add(lblNombre_alta);
		
		tfNombre_alta = new JTextField();
		tfNombre_alta.setBounds(105, 43, 86, 20);
		panelAlta_doc.add(tfNombre_alta);
		tfNombre_alta.setColumns(10);
		
		JLabel lblApellido_alta = new JLabel("Apellido");
		lblApellido_alta.setBounds(10, 77, 46, 14);
		panelAlta_doc.add(lblApellido_alta);
		
		tfApellido_alta = new JTextField();
		tfApellido_alta.setBounds(105, 74, 86, 20);
		panelAlta_doc.add(tfApellido_alta);
		tfApellido_alta.setColumns(10);
		
		JLabel lblFechanac_alta = new JLabel("fechaNac");
		lblFechanac_alta.setBounds(10, 112, 46, 14);
		panelAlta_doc.add(lblFechanac_alta);
		
		tfFecha_alta = new JTextField();
		tfFecha_alta.setBounds(105, 109, 86, 20);
		panelAlta_doc.add(tfFecha_alta);
		tfFecha_alta.setColumns(10);
		
		tfTelefono_alta = new JTextField();
		tfTelefono_alta.setBounds(105, 140, 86, 20);
		panelAlta_doc.add(tfTelefono_alta);
		tfTelefono_alta.setColumns(10);
		
		tfDireccion_alta = new JTextField();
		tfDireccion_alta.setBounds(105, 171, 86, 20);
		panelAlta_doc.add(tfDireccion_alta);
		tfDireccion_alta.setColumns(10);
		
		JLabel lblTelefono_alta = new JLabel("Telefono");
		lblTelefono_alta.setBounds(10, 143, 46, 14);
		panelAlta_doc.add(lblTelefono_alta);
		
		JLabel lblDireccion_alta = new JLabel("Direccion");
		lblDireccion_alta.setBounds(10, 174, 46, 14);
		panelAlta_doc.add(lblDireccion_alta);
		
		JButton btnClear_alta = new JButton("Clear");
		btnClear_alta.setBounds(10, 219, 89, 23);
		panelAlta_doc.add(btnClear_alta);
		
		JButton btnAdd_alta = new JButton("Add");
		btnAdd_alta.setBounds(105, 219, 89, 23);
		panelAlta_doc.add(btnAdd_alta);
		
		JPanel panelModif_doc = new JPanel();
		tabbedPane.addTab("Modificacion", null, panelModif_doc, null);
		panelModif_doc.setLayout(null);
		
		tfDni_modif = new JTextField();
		tfDni_modif.setBounds(109, 11, 86, 20);
		panelModif_doc.add(tfDni_modif);
		tfDni_modif.setColumns(10);
		
		tfNombre_modif = new JTextField();
		tfNombre_modif.setBounds(109, 42, 86, 20);
		panelModif_doc.add(tfNombre_modif);
		tfNombre_modif.setColumns(10);
		
		tfApellido_modif = new JTextField();
		tfApellido_modif.setBounds(109, 73, 86, 20);
		panelModif_doc.add(tfApellido_modif);
		tfApellido_modif.setColumns(10);
		
		tfFechaNac_modif = new JTextField();
		tfFechaNac_modif.setBounds(109, 104, 86, 20);
		panelModif_doc.add(tfFechaNac_modif);
		tfFechaNac_modif.setColumns(10);
		
		tfTelefono_modif = new JTextField();
		tfTelefono_modif.setBounds(109, 135, 86, 20);
		panelModif_doc.add(tfTelefono_modif);
		tfTelefono_modif.setColumns(10);
		
		tfDireccion_modif = new JTextField();
		tfDireccion_modif.setBounds(109, 166, 86, 20);
		panelModif_doc.add(tfDireccion_modif);
		tfDireccion_modif.setColumns(10);
		
		JLabel lblDni_modif = new JLabel("DNI");
		lblDni_modif.setBounds(10, 14, 46, 14);
		panelModif_doc.add(lblDni_modif);
		
		JLabel lblNombre_modif = new JLabel("Nombre");
		lblNombre_modif.setBounds(10, 45, 46, 14);
		panelModif_doc.add(lblNombre_modif);
		
		JLabel lblApellido_modif = new JLabel("Apellido");
		lblApellido_modif.setBounds(10, 76, 46, 14);
		panelModif_doc.add(lblApellido_modif);
		
		JLabel lblFechanac_modif = new JLabel("FechaNac");
		lblFechanac_modif.setBounds(10, 107, 59, 14);
		panelModif_doc.add(lblFechanac_modif);
		
		JLabel lblTelefono_modif = new JLabel("Telefono");
		lblTelefono_modif.setBounds(10, 138, 46, 14);
		panelModif_doc.add(lblTelefono_modif);
		
		JLabel lblDireccion_modif = new JLabel("Direccion");
		lblDireccion_modif.setBounds(10, 169, 46, 14);
		panelModif_doc.add(lblDireccion_modif);
		
		JButton btnClear_modif = new JButton("Clear");
		btnClear_modif.setBounds(10, 217, 89, 23);
		panelModif_doc.add(btnClear_modif);
		
		JButton btnDel_modif = new JButton("Del");
		btnDel_modif.setBounds(109, 217, 89, 23);
		panelModif_doc.add(btnDel_modif);
		
		JButton btnActualizar_modif = new JButton("Actualizar");
		btnActualizar_modif.setBounds(215, 217, 89, 23);
		panelModif_doc.add(btnActualizar_modif);
		
		JButton btnBuscar_modif = new JButton("Buscar");
		btnBuscar_modif.setBounds(215, 10, 89, 23);
		panelModif_doc.add(btnBuscar_modif);
	}


	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}
	public void clearAlta() {
		setDniAlta("");
		setNombreAlta("");
		setApellidoAlta("");
		setFechaAlta("");
		setTelefonoAlta("");
		setDireccionAlta("");
	}
	public void clearModif() {
		setDniModif("");
		setNombreModif("");
		setApellidoModif("");
		setFechaModif("");
		setTelefonoModif("");
		setDireccionModif("");
	}
	public String getDniAlta() {
		return tfDni_alta.getText().trim();
	}
	public void setDniAlta(String st) {
		tfDni_alta.setText(st);
	}
	public String getDniModif() {
		return tfDni_modif.getText().trim();
	}
	public void setDniModif(String st) {
		tfDni_modif.setText(st);
	}
	public String getNombreAlta() {
		return tfNombre_alta.getText().trim();
	}
	public void setNombreAlta(String st) {
		tfNombre_alta.setText(st);
	}
	public String getNombreModif() {
		return tfNombre_modif.getText().trim();
	}
	public void setNombreModif(String st) {
		tfNombre_modif.setText(st);
	}
	public String getApellidoAlta() {
		return tfApellido_alta.getText().trim();
	}
	public void setApellidoAlta(String st) {
		tfApellido_alta.setText(st);
	}
	public String getApellidoModif() {
		return tfApellido_modif.getText().trim();
	}
	public void setApellidoModif(String st) {
		tfApellido_modif.setText(st);
	}
	public String getFechaAlta() {
		return tfFecha_alta.getText().trim();
	}
	public void setFechaAlta(String st) {
		tfFecha_alta.setText(st);
	}
	public String getFechaModif() {
		return tfFechaNac_modif.getText().trim();
	}
	public void setFechaModif(String st) {
		tfFechaNac_modif.setText(st);
	}
	public String getTelefonoAlta() {
		return tfTelefono_alta.getText().trim();
	}
	public void setTelefonoAlta(String st) {
		tfTelefono_alta.setText(st);
	}
	public String getTelefonoModif() {
		return tfTelefono_modif.getText().trim();
	}
	public void setTelefonoModif(String st) {
		tfTelefono_modif.setText(st);
	}
	public String getDireccionAlta() {
		return tfDireccion_alta.getText().trim();
	}
	public void setDireccionAlta(String st) {
		tfDireccion_alta.setText(st);
	}
	public String getDireccionModif() {
		return tfDireccion_modif.getText().trim();
	}
	public void setDireccionModif(String st) {
		tfDireccion_modif.setText(st);
	}

}
