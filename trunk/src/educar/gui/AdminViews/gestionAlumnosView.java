package educar.gui.AdminViews;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.AdminController.gestionAlumnosController;
import educar.gui.IView;
import educar.gui.Listener.AdminListener;
import educar.languaje.defaultLanguaje;

public class gestionAlumnosView extends JFrame implements IView,
	defaultLanguaje {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfDni_alta;
    private JTextField tfNombre_alta;
    private JTextField tfApellido_alta;
    private JTextField tfFechaNac_alta;
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
    public gestionAlumnosView() {
	this.setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 271, 298);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	contentPane.add(tabbedPane, BorderLayout.CENTER);

	JPanel panel_modif = new JPanel();
	tabbedPane.addTab("Modificacion", null, panel_modif, null);
	panel_modif.setLayout(null);

	JLabel lblDni_modif = new JLabel("dni");
	lblDni_modif.setBounds(10, 11, 46, 14);
	panel_modif.add(lblDni_modif);

	tfDni_modif = new JTextField();
	tfDni_modif.setBounds(39, 8, 113, 20);
	panel_modif.add(tfDni_modif);
	tfDni_modif.setColumns(10);

	JButton btnBuscar_modif = new JButton(SEARCH);
	btnBuscar_modif.setBounds(162, 7, 78, 23);
	panel_modif.add(btnBuscar_modif);
	// asocio
	AdminListener bBuscar_mod = new AdminListener();
	IController gestionCBuscar_mod = new gestionAlumnosController();
	gestionCBuscar_mod.setView(this);
	bBuscar_mod.associate(btnBuscar_modif, gestionCBuscar_mod);

	JLabel lblNombre_modif = new JLabel("nombre");
	lblNombre_modif.setBounds(10, 49, 46, 14);
	panel_modif.add(lblNombre_modif);

	tfNombre_modif = new JTextField();
	tfNombre_modif.setBounds(66, 46, 174, 20);
	panel_modif.add(tfNombre_modif);
	tfNombre_modif.setColumns(10);

	JLabel lblApellido_modif = new JLabel("apellido");
	lblApellido_modif.setBounds(10, 80, 46, 14);
	panel_modif.add(lblApellido_modif);

	tfApellido_modif = new JTextField();
	tfApellido_modif.setBounds(66, 77, 174, 20);
	panel_modif.add(tfApellido_modif);
	tfApellido_modif.setColumns(10);

	JLabel lblFechanac_modif = new JLabel("fechaNac");
	lblFechanac_modif.setBounds(10, 105, 46, 14);
	panel_modif.add(lblFechanac_modif);

	JLabel lblTelefono_modif = new JLabel("Telefono");
	lblTelefono_modif.setBounds(10, 130, 46, 14);
	panel_modif.add(lblTelefono_modif);

	JLabel lblDireccion_modif = new JLabel("Direccion");
	lblDireccion_modif.setBounds(10, 155, 46, 14);
	panel_modif.add(lblDireccion_modif);

	tfFechaNac_modif = new JTextField();
	tfFechaNac_modif.setBounds(66, 102, 174, 20);
	panel_modif.add(tfFechaNac_modif);
	tfFechaNac_modif.setColumns(10);

	tfTelefono_modif = new JTextField();
	tfTelefono_modif.setBounds(66, 127, 174, 20);
	panel_modif.add(tfTelefono_modif);
	tfTelefono_modif.setColumns(10);

	tfDireccion_modif = new JTextField();
	tfDireccion_modif.setBounds(66, 152, 174, 20);
	panel_modif.add(tfDireccion_modif);
	tfDireccion_modif.setColumns(10);

	JButton btnClear_modif = new JButton(DELETE);
	btnClear_modif.setBounds(10, 198, 57, 23);
	panel_modif.add(btnClear_modif);
	// asocio
	AdminListener bClear_mod = new AdminListener();
	IController gestionCClear_mod = new gestionAlumnosController();
	gestionCClear_mod.setView(this);
	bClear_mod.associate(btnClear_modif, gestionCClear_mod);

	JButton btnActualizar = new JButton("Actualizar");
	btnActualizar.setBounds(154, 198, 86, 23);
	panel_modif.add(btnActualizar);
	// asocio
	AdminListener bUpdate = new AdminListener();
	IController gestionCUpdate = new gestionAlumnosController();
	gestionCUpdate.setView(this);
	bUpdate.associate(btnActualizar, gestionCUpdate);

	JButton btnDel = new JButton("CLEAR");
	btnDel.setBounds(77, 198, 57, 23);
	panel_modif.add(btnDel);
	// asocio
	AdminListener bDel = new AdminListener();
	IController gestionCDel = new gestionAlumnosController();
	gestionCDel.setView(this);
	bDel.associate(btnDel, gestionCDel);

	JPanel panel_alta = new JPanel();
	tabbedPane.addTab("Alta", null, panel_alta, null);
	panel_alta.setLayout(null);

	JLabel lblDni_alta = new JLabel("DNI");
	lblDni_alta.setBounds(10, 14, 46, 28);
	panel_alta.add(lblDni_alta);

	tfDni_alta = new JTextField();
	tfDni_alta.setText("");
	tfDni_alta.setBounds(66, 18, 158, 20);
	panel_alta.add(tfDni_alta);
	tfDni_alta.setColumns(10);

	JLabel lblNombre_alta = new JLabel("Nombre");
	lblNombre_alta.setBounds(10, 53, 46, 14);
	panel_alta.add(lblNombre_alta);

	JLabel lblApellido_alta = new JLabel("Apellido");
	lblApellido_alta.setBounds(10, 81, 46, 14);
	panel_alta.add(lblApellido_alta);

	JLabel lblFechanac_alta = new JLabel("fechaNac");
	lblFechanac_alta.setBounds(10, 109, 46, 14);
	panel_alta.add(lblFechanac_alta);

	JLabel lblTelefono_alta = new JLabel("Telefono");
	lblTelefono_alta.setBounds(10, 137, 46, 14);
	panel_alta.add(lblTelefono_alta);

	JLabel lblDireccion_alta = new JLabel("Direccion");
	lblDireccion_alta.setBounds(10, 165, 46, 14);
	panel_alta.add(lblDireccion_alta);

	tfNombre_alta = new JTextField();
	tfNombre_alta.setBounds(66, 50, 158, 20);
	panel_alta.add(tfNombre_alta);
	tfNombre_alta.setColumns(10);

	tfApellido_alta = new JTextField();
	tfApellido_alta.setBounds(66, 78, 158, 20);
	panel_alta.add(tfApellido_alta);
	tfApellido_alta.setColumns(10);

	tfFechaNac_alta = new JTextField();
	tfFechaNac_alta.setBounds(66, 106, 158, 20);
	panel_alta.add(tfFechaNac_alta);
	tfFechaNac_alta.setColumns(10);

	tfTelefono_alta = new JTextField();
	tfTelefono_alta.setBounds(66, 134, 158, 20);
	panel_alta.add(tfTelefono_alta);
	tfTelefono_alta.setColumns(10);

	tfDireccion_alta = new JTextField();
	tfDireccion_alta.setBounds(66, 162, 158, 20);
	panel_alta.add(tfDireccion_alta);
	tfDireccion_alta.setColumns(10);

	JButton btnAdd_alta = new JButton(ADD);
	btnAdd_alta.setBounds(151, 198, 89, 23);
	panel_alta.add(btnAdd_alta);
	// asocio
	AdminListener bAdd_alta = new AdminListener();
	IController gestionCAdd_alta = new gestionAlumnosController();
	gestionCAdd_alta.setView(this);
	bAdd_alta.associate(btnAdd_alta, gestionCAdd_alta);

	JButton btnClear_alta = new JButton("Clear");
	btnClear_alta.setBounds(52, 198, 89, 23);
	panel_alta.add(btnClear_alta);
	// asocio
	AdminListener bClear = new AdminListener();
	IController gestionCClear_alta = new gestionAlumnosController();
	gestionCClear_alta.setView(this);
	bClear.associate(btnClear_alta, gestionCClear_alta);
    }

    public void setTfTelefono_modif(String s) {
	tfTelefono_modif.setText(s);
    }

    public void setTfNombre_modif(String s) {
	tfNombre_modif.setText(s);
    }

    public void setTfFechaNac_modif(String s) {
	tfFechaNac_modif.setText(s);
    }

    public void setTfDni_modif(String s) {
	tfDni_modif.setText(s);
    }

    public void setTfDireccion_modif(String s) {
	tfDireccion_modif.setText(s);
    }

    public void setTfApellido_modif(String s) {
	tfApellido_modif.setText(s);
    }

    public String getNameAlta() {
	return tfNombre_alta.getText().trim();
    }

    public String getLastnameAlta() {
	return tfApellido_alta.getText().trim();
    }

    public String getFechaNacAlta() {
	return tfFechaNac_alta.getText().trim();
    }

    public String getTelefonoAlta() {
	return tfTelefono_alta.getText().trim();
    }

    public String getDireccionAlta() {
	return tfDireccion_alta.getText().trim();
    }

    public String getDniAlta() {
	return tfDni_alta.getText().trim();
    }

    public String getNameMod() {
	return tfNombre_modif.getText().trim();
    }

    public String getLastnameMod() {
	return tfApellido_modif.getText().trim();
    }

    public String getFechaNacMod() {
	return tfFechaNac_modif.getText().trim();
    }

    public String getTelefonoMod() {
	return tfTelefono_modif.getText().trim();
    }

    public String getDireccionMod() {
	return tfDireccion_modif.getText().trim();
    }

    public String getDniMod() {
	return tfDni_modif.getText().trim();
    }

    public void close() {
	this.dispose();
    }

    @Override
    public void present(String model) {
	// TODO Auto-generated method stub
	JOptionPane.showMessageDialog(null, model);

    }

    public void deleteViewFieldsMod() {
	// TODO Auto-generated method stub
	this.setTfTelefono_modif("");
	this.setTfNombre_modif("");
	this.setTfFechaNac_modif("");
	this.setTfDni_modif("");
	this.setTfDireccion_modif("");
	this.setTfApellido_modif("");

    }

    // si quedan campos en blancos retorna false en la pestaña alta
    public boolean fieldsIsOkAlta() {
	return !(this.getDireccionAlta().compareTo("") == 0)
		&& !(this.getTelefonoAlta().compareTo("") == 0)
		&& !(this.getDniAlta().compareTo("") == 0)
		&& !(this.getLastnameAlta().compareTo("") == 0)
		&& !(this.getNameAlta().compareTo("") == 0)
		&& !(this.getFechaNacAlta().compareTo("") == 0);

    }
}