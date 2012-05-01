package educar.gui.AdminViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import educar.controllers.ChargeController;
import educar.controllers.IController;
import educar.controllers.AdminController.gestionAlumnosController;
import educar.controllers.AdminController.gestionDocenteController;
import educar.controllers.AdminController.subjectManagementController;
import educar.gui.IView;
import educar.gui.Listener.AdminListener;
import educar.gui.Listener.ChargeListener;
import educar.languaje.defaultLanguaje;

public class administrador extends JFrame implements IView, defaultLanguaje {

    private static final JComponent manuAlumno = null;
    private JPanel administrador;
    private JPanel menuAccionesPanel;
    private JScrollPane menuAccionesScroll;
    private JPanel menuAcciones;
    private JScrollPane menuAdminScroll;
    private JTabbedPane menuAlumno;
    private JTabbedPane menuDocente;
    private JTabbedPane menuCargo;
    private JTabbedPane menuFacultad;
    private JTabbedPane menuMateria;
    private JTabbedPane bienvenido;
    private JPanel panelBienvenido;
    private static JTextField txtFBuscarDniModificarAlmuno;
    private JTextField txtFNombreModificarAlumno;
    private JTextField txtFApellidoModificarAlumno;
    private JTextField txtFDireccionModificarAlumno;
    private JTextField txtFFechaNacModificarAlumno;
    private JTextField txtFTelefonoModificarAlumno;
    // ----------------------------------------------------------
    private JTextField txtFDniAltaAlumno;
    private JTextField txtFNombreAltaAlumno;
    private JTextField txtFApellidoAltaAlumno;
    private JTextField txtFDireccionAltaAlumno;
    private JTextField txtFFechaNacAltaAlumno;
    private JTextField txtFTelefonoAltaAlumno;
    // ------------------------------------------------------------
    private JTextField txtFApellidoAltaDocente;
    private JTextField txtFDireccionAltaDocente;
    private JTextField txtFFechaNacAltaDocente;
    private JTextField txtFTelefonoAltaDocente;
    private JTextField txtFNombreAltaDocente;
    private JTextField txtFDniAltaDocente;

    // --------------------------------------------------------------
    private JTextField txtFBuscarDniModificarDocente;
    private JTextField txtFNombreModificarDocente;
    private JTextField txtFApellidoModificaDocente;
    private JTextField txtFDireccionModificaDocente;
    private JTextField txtFFechaNacModificarDocente;
    private JTextField txtFTelefonoModificarDocente;
    // /
    // -------------------------------------------------------------------------
    private JTextField txtFCodigoModificarMateria;
    private JTextField txtFNombreModificarMateria;
    private JTextField txtFNombreAltaMateria;
    private JTextField txtFCodigoModificarFacultad;
    private JTextField txtFNombreModificarFacultad;
    private JTextField txtFNombreAltaFacultad;
    private JTextField txtFCodigoModificarCargo;
    private JTextField txtFNombreModificarCargo;
    private JTextField txtFNombreAltaCargo;
    private List listaModificarDocente;
    private List listaAltaDocente;
    private List listaAltaFacultad;
    private JButton btnLimpiarModificarMateria;
    private JButton btnBorrarModificarMateria;
    private JButton btnBuscarModificarMateria;
    private JButton btnGuardarModificarMateria;
    private JButton btnGuardarAltaMateria;
    private List listaAltaMateria;
    private List listaMoificarFacultad;
    private JButton btnLimpiarModificarFacultad;
    private JButton btnBorrarModificarFacultad;
    private JButton btnBuscarModificarFacultad;
    private JButton btnGuardarModificarFacultad;
    private JButton btnGuardarAltaFacultad;
    private JButton btnLimpiarModificarCargo;
    private List listaModificarCargo;
    private JButton btnBorrarModificarCargo;
    private JButton btnBuscarModificarCargo;
    private JButton btnGuardarModificarCargo;
    private JButton btnGuardarAltaCargo;
    private List listaAltaCargo;
    private JButton btnBuscarModificarAlumno;
    private JButton btnBorrarModificarAlumno;
    private JPanel panelModificarAlumno;
    private List listaModificarAlumno;
    private JButton btnLimpiarModificarAlumno;
    private JButton btnGuardarModificarAlumno;
    private  List listaAltaAlumno;
    private JButton btnLimpiarAltaAlumno;
    private JButton btnGuardarAltaAlumno;
    private JButton btnLimpiarModificarDocente;
    private JButton btnGuardarModificarDocente;
    private JButton btnBorrarModificarDocente;
    private JButton btnBuscarModificarDocente;
    private JButton btnLimpiarAltaDocente;
    private JButton btnGuardarAltaDocente;
    private List listaModificarMateria;

    /**
     * Create the frame.
     */
    public administrador() {
	setVisible(true);
	setIconImage(Toolkit
		.getDefaultToolkit()
		.getImage(
			administrador.class
				.getResource("/educar/gui/AdminViews/imagenIcon/admin.png")));
	setTitle("ADMINISTRADOR  ");
	setForeground(new Color(0, 0, 255));
	setBackground(new Color(0, 0, 255));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setBounds(0, 0, d.width, d.height - 50);// Tama�o de mi ventana

	administrador = new JPanel();
	administrador.setBackground(new Color(51, 51, 102));
	administrador.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(administrador);

	menuAdminScroll = new JScrollPane();

	menuAcciones = new JPanel();
	GroupLayout gl_administrador = new GroupLayout(administrador);
	gl_administrador.setHorizontalGroup(gl_administrador
		.createParallelGroup(Alignment.TRAILING).addGroup(
			Alignment.LEADING,
			gl_administrador.createSequentialGroup().addComponent(
				menuAdminScroll, GroupLayout.PREFERRED_SIZE,
				181, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(menuAcciones,
					GroupLayout.DEFAULT_SIZE, 1153,
					Short.MAX_VALUE)));
	gl_administrador.setVerticalGroup(gl_administrador.createParallelGroup(
		Alignment.LEADING).addComponent(menuAdminScroll).addComponent(
		menuAcciones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
		670, Short.MAX_VALUE));

	menuAccionesScroll = new JScrollPane();
	menuAccionesScroll.setEnabled(false);
	GroupLayout gl_menuAcciones = new GroupLayout(menuAcciones);
	gl_menuAcciones.setHorizontalGroup(gl_menuAcciones.createParallelGroup(
		Alignment.LEADING).addComponent(menuAccionesScroll,
		Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 182,
		Short.MAX_VALUE));
	gl_menuAcciones.setVerticalGroup(gl_menuAcciones.createParallelGroup(
		Alignment.LEADING).addGroup(
		gl_menuAcciones.createSequentialGroup().addGap(2).addComponent(
			menuAccionesScroll, GroupLayout.DEFAULT_SIZE, 175,
			Short.MAX_VALUE)));

	menuAccionesPanel = new JPanel();
	menuAccionesPanel.setBackground(new Color(119, 136, 153));
	menuAccionesScroll.setViewportView(menuAccionesPanel);

	menuAlumno = new JTabbedPane(JTabbedPane.TOP);
	menuAlumno.setBounds(0, 0, 1151, 666);
	menuAlumno.setVisible(false);

	menuDocente = new JTabbedPane(JTabbedPane.TOP);
	menuDocente.setBackground(new Color(176, 196, 222));
	menuDocente.setBounds(0, 0, 1151, 655);
	menuDocente.setVisible(false);

	menuMateria = new JTabbedPane(JTabbedPane.TOP);
	menuMateria.setBounds(0, 0, 1151, 666);
	menuMateria.setVisible(false);

	menuFacultad = new JTabbedPane(JTabbedPane.TOP);
	menuFacultad.setBounds(0, 0, 1151, 666);
	menuFacultad.setVisible(false);

	menuCargo = new JTabbedPane(JTabbedPane.TOP);
	menuCargo.setBounds(0, 0, 1151, 666);
	menuCargo.setVisible(false);

	bienvenido = new JTabbedPane(JTabbedPane.TOP);
	bienvenido.setBounds(0, 0, 1151, 666);
	bienvenido.setVisible(true);

	panelBienvenido = new JPanel();
	bienvenido.addTab("", null, panelBienvenido, null);

	JLabel label_8 = new JLabel(
		"           BIENVENIDO ADMINISTRADOR       ");

	JLabel label_9 = new JLabel(
		"                        precione el boton de lo q dese hacer como andministrador");
	GroupLayout gl_panelBienvenido = new GroupLayout(panelBienvenido);
	gl_panelBienvenido.setHorizontalGroup(gl_panelBienvenido
		.createParallelGroup(Alignment.LEADING).addGroup(
			gl_panelBienvenido.createSequentialGroup().addGap(497)
				.addComponent(label_8,
					GroupLayout.PREFERRED_SIZE, 341,
					GroupLayout.PREFERRED_SIZE)).addGroup(
			gl_panelBienvenido.createSequentialGroup().addGap(462)
				.addComponent(label_9,
					GroupLayout.PREFERRED_SIZE, 430,
					GroupLayout.PREFERRED_SIZE)));
	gl_panelBienvenido.setVerticalGroup(gl_panelBienvenido
		.createParallelGroup(Alignment.LEADING).addGroup(
			gl_panelBienvenido.createSequentialGroup().addGap(46)
				.addComponent(label_8,
					GroupLayout.PREFERRED_SIZE, 73,
					GroupLayout.PREFERRED_SIZE).addGap(179)
				.addComponent(label_9,
					GroupLayout.PREFERRED_SIZE, 176,
					GroupLayout.PREFERRED_SIZE)));
	panelBienvenido.setLayout(gl_panelBienvenido);
	menuAccionesPanel.setLayout(null);
	menuAccionesPanel.add(menuDocente);
	// /////////////////////////////////////////////// ALTA DOCENTE
	// ////////////////////////
	JPanel panelAltaDocente = new JPanel();
	panelAltaDocente.setLayout(null);
	panelAltaDocente.setBackground(new Color(218, 165, 32));
	menuDocente
		.addTab(
			"                           ALTA DOCENTE                            ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/docentepng.png")),
			panelAltaDocente, null);
	menuDocente.setEnabledAt(0, true);
	menuDocente.setBackgroundAt(0, new Color(112, 128, 144));

	JLabel lblCartelAltaDocente = new JLabel(
		"Inserte los Datos del Docente a dar de Alta");
	lblCartelAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelAltaDocente.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelAltaDocente.setBounds(229, 21, 419, 58);
	panelAltaDocente.add(lblCartelAltaDocente);

	JLabel lblListaAltaDocente = new JLabel("LISTA DE DOCENTES");
	lblListaAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaAltaDocente.setBounds(916, 0, 229, 58);
	panelAltaDocente.add(lblListaAltaDocente);

	JLabel lblDniAltaDocente = new JLabel(" D.N.I ");
	lblDniAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblDniAltaDocente.setBackground(Color.BLUE);
	lblDniAltaDocente.setBounds(0, 118, 229, 45);
	panelAltaDocente.add(lblDniAltaDocente);

	listaAltaDocente = new List();
	listaAltaDocente.setBounds(916, 58, 229, 464);
	panelAltaDocente.add(listaAltaDocente);

	JLabel lblNombreAltaDocente = new JLabel("NOMBRE");
	lblNombreAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreAltaDocente.setBounds(0, 174, 229, 45);
	panelAltaDocente.add(lblNombreAltaDocente);

	txtFNombreAltaDocente = new JTextField();
	txtFNombreAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreAltaDocente.setColumns(10);
	txtFNombreAltaDocente.setBounds(229, 174, 305, 45);
	panelAltaDocente.add(txtFNombreAltaDocente);

	JLabel lblApellidoAltaDocente = new JLabel("APELLIDO");
	lblApellidoAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblApellidoAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblApellidoAltaDocente.setBounds(0, 232, 229, 45);
	panelAltaDocente.add(lblApellidoAltaDocente);

	txtFApellidoAltaDocente = new JTextField();
	txtFApellidoAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFApellidoAltaDocente.setColumns(10);
	txtFApellidoAltaDocente.setBounds(229, 232, 305, 45);
	panelAltaDocente.add(txtFApellidoAltaDocente);

	JLabel lblDireccionAltaDocente = new JLabel("DIRECCI\u00D3N");
	lblDireccionAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblDireccionAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblDireccionAltaDocente.setBounds(0, 290, 229, 45);
	panelAltaDocente.add(lblDireccionAltaDocente);

	txtFDireccionAltaDocente = new JTextField();
	txtFDireccionAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDireccionAltaDocente.setColumns(10);
	txtFDireccionAltaDocente.setBounds(229, 290, 305, 45);
	panelAltaDocente.add(txtFDireccionAltaDocente);

	JLabel lblFechaNacAltaDocente = new JLabel("FECHA NACIMIENTO");
	lblFechaNacAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblFechaNacAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblFechaNacAltaDocente.setBounds(0, 348, 229, 45);
	panelAltaDocente.add(lblFechaNacAltaDocente);

	txtFFechaNacAltaDocente = new JTextField();
	txtFFechaNacAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFFechaNacAltaDocente.setColumns(10);
	txtFFechaNacAltaDocente.setBounds(229, 348, 305, 45);
	panelAltaDocente.add(txtFFechaNacAltaDocente);

	JLabel lblTelefonoAltaDocente = new JLabel("TELEFONO");
	lblTelefonoAltaDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblTelefonoAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblTelefonoAltaDocente.setBounds(0, 406, 229, 45);
	panelAltaDocente.add(lblTelefonoAltaDocente);

	txtFTelefonoAltaDocente = new JTextField();
	txtFTelefonoAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFTelefonoAltaDocente.setColumns(10);
	txtFTelefonoAltaDocente.setBounds(229, 406, 305, 45);
	panelAltaDocente.add(txtFTelefonoAltaDocente);

	btnLimpiarAltaDocente = new JButton(CLEAR);
	btnLimpiarAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarAltaDocente.setBounds(229, 522, 190, 58);
	panelAltaDocente.add(btnLimpiarAltaDocente);

	AdminListener bLimpiarAD = new AdminListener();
	IController gestionLimpiarAD = new gestionDocenteController();
	gestionLimpiarAD.setView(this);
	bLimpiarAD.associate(btnLimpiarAltaDocente, gestionLimpiarAD);

	btnGuardarAltaDocente = new JButton(ADD);
	btnGuardarAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaDocente.setBounds(573, 522, 190, 58);
	panelAltaDocente.add(btnGuardarAltaDocente);

	AdminListener bGuardarAD = new AdminListener();
	IController gestionGuardAD = new gestionDocenteController();
	gestionGuardAD.setView(this);
	bGuardarAD.associate(btnGuardarAltaDocente, gestionGuardAD);

	txtFDniAltaDocente = new JTextField();
	txtFDniAltaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDniAltaDocente.setColumns(10);
	txtFDniAltaDocente.setBounds(229, 118, 305, 45);
	panelAltaDocente.add(txtFDniAltaDocente);

	// ////////////////////////// MODIFICAR DOCENTE
	// ///////////////////////////////////////

	JPanel panelModificacionDocente = new JPanel();
	panelModificacionDocente.setLayout(null);
	panelModificacionDocente.setBorder(new SoftBevelBorder(
		BevelBorder.LOWERED, null, null, null, null));
	panelModificacionDocente.setBackground(UIManager
		.getColor("Button.focus"));
	menuDocente
		.addTab(
			"                         MODIFICACION DOCENTE                            ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/docentepng.png")),
			panelModificacionDocente, null);

	JLabel lblCartelModificarDocente = new JLabel(
		"Buscar Docente a Modificar");
	lblCartelModificarDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelModificarDocente.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelModificarDocente.setBounds(229, 0, 305, 58);
	panelModificacionDocente.add(lblCartelModificarDocente);

	JLabel lblListaModificarDocente = new JLabel("LISTA DE DOCENTES");
	lblListaModificarDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaModificarDocente.setBounds(916, 0, 229, 58);
	panelModificacionDocente.add(lblListaModificarDocente);

	JLabel lblDniModificarDocente = new JLabel(" D.N.I ");
	lblDniModificarDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblDniModificarDocente.setBackground(Color.BLUE);
	lblDniModificarDocente.setBounds(0, 58, 229, 45);
	panelModificacionDocente.add(lblDniModificarDocente);

	txtFBuscarDniModificarDocente = new JTextField();
	txtFBuscarDniModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFBuscarDniModificarDocente.setColumns(10);
	txtFBuscarDniModificarDocente.setBounds(229, 58, 305, 45);
	panelModificacionDocente.add(txtFBuscarDniModificarDocente);

	btnBuscarModificarDocente = new JButton(SEARCH);
	btnBuscarModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarDocente.setBounds(587, 58, 190, 45);
	panelModificacionDocente.add(btnBuscarModificarDocente);

	AdminListener bBuscarMD = new AdminListener();
	IController gestionBuscarMD = new gestionDocenteController();
	gestionBuscarMD.setView(this);
	bBuscarMD.associate(btnBuscarModificarDocente, gestionBuscarMD);

	listaModificarDocente = new List();
	listaModificarDocente.setBounds(916, 58, 229, 464);
	panelModificacionDocente.add(listaModificarDocente);

	JLabel lblNombreModificarDocente = new JLabel("NOMBRE");
	lblNombreModificarDocente.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreModificarDocente.setBounds(0, 174, 229, 45);
	panelModificacionDocente.add(lblNombreModificarDocente);

	txtFNombreModificarDocente = new JTextField();
	txtFNombreModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreModificarDocente.setColumns(10);
	txtFNombreModificarDocente.setBounds(229, 174, 305, 45);
	panelModificacionDocente.add(txtFNombreModificarDocente);

	JLabel lblApellidoModificarDocente = new JLabel("APELLIDO");
	lblApellidoModificarDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblApellidoModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblApellidoModificarDocente.setBounds(0, 232, 229, 45);
	panelModificacionDocente.add(lblApellidoModificarDocente);

	txtFApellidoModificaDocente = new JTextField();
	txtFApellidoModificaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFApellidoModificaDocente.setColumns(10);
	txtFApellidoModificaDocente.setBounds(229, 232, 305, 45);
	panelModificacionDocente.add(txtFApellidoModificaDocente);

	JLabel lblDireccionModificarDocente = new JLabel("DIRECCI\u00D3N");
	lblDireccionModificarDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDireccionModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblDireccionModificarDocente.setBounds(0, 290, 229, 45);
	panelModificacionDocente.add(lblDireccionModificarDocente);

	txtFDireccionModificaDocente = new JTextField();
	txtFDireccionModificaDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDireccionModificaDocente.setColumns(10);
	txtFDireccionModificaDocente.setBounds(229, 290, 305, 45);
	panelModificacionDocente.add(txtFDireccionModificaDocente);

	JLabel lblFechaNacModificarDocente = new JLabel("FECHA NACIMIENTO");
	lblFechaNacModificarDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblFechaNacModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblFechaNacModificarDocente.setBounds(0, 348, 229, 45);
	panelModificacionDocente.add(lblFechaNacModificarDocente);

	txtFFechaNacModificarDocente = new JTextField();
	txtFFechaNacModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFFechaNacModificarDocente.setColumns(10);
	txtFFechaNacModificarDocente.setBounds(229, 348, 305, 45);
	panelModificacionDocente.add(txtFFechaNacModificarDocente);

	JLabel lblTelefonoModificarDocente = new JLabel("TELEFONO");
	lblTelefonoModificarDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblTelefonoModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblTelefonoModificarDocente.setBounds(0, 406, 229, 45);
	panelModificacionDocente.add(lblTelefonoModificarDocente);

	txtFTelefonoModificarDocente = new JTextField();
	txtFTelefonoModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFTelefonoModificarDocente.setColumns(10);
	txtFTelefonoModificarDocente.setBounds(229, 406, 305, 45);
	panelModificacionDocente.add(txtFTelefonoModificarDocente);

	btnBorrarModificarDocente = new JButton(DELETE);
	btnBorrarModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarDocente.setBounds(229, 522, 190, 58);
	panelModificacionDocente.add(btnBorrarModificarDocente);

	AdminListener bBorrarMD = new AdminListener();
	IController gestionBorrarMD = new gestionDocenteController();
	gestionBorrarMD.setView(this);
	bBorrarMD.associate(btnBorrarModificarDocente, gestionBorrarMD);

	btnLimpiarModificarDocente = new JButton(CLEAR);
	btnLimpiarModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarDocente.setBounds(458, 522, 190, 58);
	panelModificacionDocente.add(btnLimpiarModificarDocente);

	AdminListener bLimpiarMD = new AdminListener();
	IController gestionLimpiarMD = new gestionDocenteController();
	gestionLimpiarMD.setView(this);
	bLimpiarMD.associate(btnLimpiarModificarDocente, gestionLimpiarMD);

	btnGuardarModificarDocente = new JButton(MODIFY);
	btnGuardarModificarDocente.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarDocente.setBounds(687, 522, 190, 58);
	panelModificacionDocente.add(btnGuardarModificarDocente);
	menuAccionesPanel.add(bienvenido);
	menuAccionesPanel.add(menuFacultad);

	AdminListener bGuardarMD = new AdminListener();
	IController gestionGuardarMD = new gestionDocenteController();
	gestionGuardarMD.setView(this);
	bGuardarMD.associate(btnGuardarModificarDocente, gestionGuardarMD);
	// ///////////////////////////// MODIFICAR FACULTAD
	// ///////////////////////////////////////////////////////////////////

	JPanel panelModificarFacultad = new JPanel();
	panelModificarFacultad.setLayout(null);
	panelModificarFacultad.setBackground(SystemColor.activeCaption);
	menuFacultad
		.addTab(
			"                      MODIFICAR FACULTAD                         ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/facultadespng.png")),
			panelModificarFacultad, null);

	JLabel lblCartelModificarFacultad = new JLabel(
		"Inserte el Codigo de la Facultad ");
	lblCartelModificarFacultad
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelModificarFacultad.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelModificarFacultad.setBounds(229, 21, 419, 58);
	panelModificarFacultad.add(lblCartelModificarFacultad);

	JLabel lblListaModificarFacultad = new JLabel("LISTA DE FACULTADES");
	lblListaModificarFacultad.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaModificarFacultad.setBounds(916, 0, 229, 58);
	panelModificarFacultad.add(lblListaModificarFacultad);

	JLabel lblCodigoModificarFacultad = new JLabel("CODIGO");
	lblCodigoModificarFacultad
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCodigoModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	lblCodigoModificarFacultad.setBackground(Color.BLUE);
	lblCodigoModificarFacultad.setBounds(0, 118, 229, 45);
	panelModificarFacultad.add(lblCodigoModificarFacultad);

	txtFCodigoModificarFacultad = new JTextField();
	txtFCodigoModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	txtFCodigoModificarFacultad.setColumns(10);
	txtFCodigoModificarFacultad.setBounds(229, 118, 305, 45);
	panelModificarFacultad.add(txtFCodigoModificarFacultad);

	listaMoificarFacultad = new List();
	listaMoificarFacultad.setBounds(916, 58, 229, 464);
	panelModificarFacultad.add(listaMoificarFacultad);

	JLabel lblNombreModificarFacultad = new JLabel("NOMBRE FACULTAD");
	lblNombreModificarFacultad
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreModificarFacultad.setBounds(0, 232, 229, 45);
	panelModificarFacultad.add(lblNombreModificarFacultad);

	txtFNombreModificarFacultad = new JTextField();
	txtFNombreModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreModificarFacultad.setColumns(10);
	txtFNombreModificarFacultad.setBounds(229, 232, 305, 45);
	panelModificarFacultad.add(txtFNombreModificarFacultad);

	btnLimpiarModificarFacultad = new JButton("LIMPIAR");
	btnLimpiarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarFacultad.setBounds(220, 522, 190, 58);
	panelModificarFacultad.add(btnLimpiarModificarFacultad);

	btnBorrarModificarFacultad = new JButton("BORRAR");
	btnBorrarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarFacultad.setBounds(420, 522, 190, 58);
	panelModificarFacultad.add(btnBorrarModificarFacultad);

	btnBuscarModificarFacultad = new JButton("BUSCAR");
	btnBuscarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarFacultad.setBounds(584, 116, 190, 47);
	panelModificarFacultad.add(btnBuscarModificarFacultad);

	btnGuardarModificarFacultad = new JButton(" GUARDAR");
	btnGuardarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarFacultad.setBounds(620, 522, 190, 58);
	panelModificarFacultad.add(btnGuardarModificarFacultad);

	JPanel panelAltaFacultad = new JPanel();
	panelAltaFacultad.setLayout(null);
	panelAltaFacultad.setBackground(SystemColor.inactiveCaptionBorder);
	menuFacultad
		.addTab(
			"                          ALTA FACULTAD                            ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/facultadespng.png")),
			panelAltaFacultad, null);

	JLabel lblCartelAltaFacultad = new JLabel(
		"Inserte el Nombre de la Facultad  a Guardar");
	lblCartelAltaFacultad.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelAltaFacultad.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelAltaFacultad.setBounds(269, 29, 419, 58);
	panelAltaFacultad.add(lblCartelAltaFacultad);

	JLabel lblListaAltaFacultad = new JLabel("LISTA DE FACULTADES");
	lblListaAltaFacultad.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaAltaFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaAltaFacultad.setBounds(916, 0, 229, 58);
	panelAltaFacultad.add(lblListaAltaFacultad);

	listaAltaFacultad = new List();
	listaAltaFacultad.setBounds(916, 58, 229, 464);
	panelAltaFacultad.add(listaAltaFacultad);

	JLabel lblNombreAltaFacultad = new JLabel("NOMBRE FACULTAD");
	lblNombreAltaFacultad.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreAltaFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreAltaFacultad.setBounds(104, 232, 229, 45);
	panelAltaFacultad.add(lblNombreAltaFacultad);

	txtFNombreAltaFacultad = new JTextField();
	txtFNombreAltaFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreAltaFacultad.setColumns(10);
	txtFNombreAltaFacultad.setBounds(343, 232, 305, 45);
	panelAltaFacultad.add(txtFNombreAltaFacultad);

	btnGuardarAltaFacultad = new JButton(" GUARDAR");
	btnGuardarAltaFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaFacultad.setBounds(408, 441, 190, 58);
	panelAltaFacultad.add(btnGuardarAltaFacultad);
	menuAccionesPanel.add(menuAlumno);
	// //////////////////////////////////////////// panel MODIFICAR ALUMNO
	// /////////////////////////////
	panelModificarAlumno = new JPanel();
	panelModificarAlumno.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
		null, null, null, null));
	panelModificarAlumno.setLayout(null);
	panelModificarAlumno.setBackground(SystemColor.activeCaption);
	menuAlumno
		.addTab(
			"                           MODIFICAR ALUMNO                         ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/alumnopng.png")),
			panelModificarAlumno, null);
	menuAlumno.setBackgroundAt(0, SystemColor.menu);

	JLabel lblCartelBuscarAlumno = new JLabel("Buscar Alumno a Modificar");
	lblCartelBuscarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelBuscarAlumno.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelBuscarAlumno.setBounds(229, 0, 305, 58);
	panelModificarAlumno.add(lblCartelBuscarAlumno);

	JLabel lblListaAlumnoModificarAlumno = new JLabel("LISTA DE ALUMNOS");
	lblListaAlumnoModificarAlumno
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaAlumnoModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaAlumnoModificarAlumno.setBounds(916, 0, 229, 58);
	panelModificarAlumno.add(lblListaAlumnoModificarAlumno);

	JLabel lblDniModificarAlumno = new JLabel(" DNI alumno");
	lblDniModificarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblDniModificarAlumno.setBackground(Color.BLUE);
	lblDniModificarAlumno.setBounds(0, 58, 229, 45);
	panelModificarAlumno.add(lblDniModificarAlumno);

	txtFBuscarDniModificarAlmuno = new JTextField();
	txtFBuscarDniModificarAlmuno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFBuscarDniModificarAlmuno.setColumns(10);
	txtFBuscarDniModificarAlmuno.setBounds(229, 58, 305, 45);
	panelModificarAlumno.add(txtFBuscarDniModificarAlmuno);

	btnBuscarModificarAlumno = new JButton(SEARCH);
	btnBuscarModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarAlumno.setBounds(587, 58, 190, 45);
	panelModificarAlumno.add(btnBuscarModificarAlumno);

	AdminListener bBuscarMA = new AdminListener(); // / MA=modificar alumno
	IController gestionBuscarMA = new gestionAlumnosController();
	gestionBuscarMA.setView(this);
	bBuscarMA.associate(btnBuscarModificarAlumno, gestionBuscarMA);

	// ACA SIGUIR HACIENDOOOOOOOO ************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	listaModificarAlumno = new List();
	listaModificarAlumno.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		if (listaModificarAlumno.getSelectedItem() != null) {
		    setTfDni_modif_A(listaModificarAlumno.getSelectedItem());
		}
	    }
	});
	panelModificarAlumno.add(listaModificarAlumno);
	listaModificarAlumno.setBounds(916, 58, 229, 464);

	JLabel lblNombreModificarAlumno = new JLabel("NOMBRE");
	lblNombreModificarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreModificarAlumno.setBounds(0, 174, 229, 45);
	panelModificarAlumno.add(lblNombreModificarAlumno);

	txtFNombreModificarAlumno = new JTextField();
	txtFNombreModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreModificarAlumno.setColumns(10);
	txtFNombreModificarAlumno.setBounds(229, 174, 305, 45);
	panelModificarAlumno.add(txtFNombreModificarAlumno);

	JLabel lblApellidoModificarAlumno = new JLabel("APELLIDO");
	lblApellidoModificarAlumno
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblApellidoModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblApellidoModificarAlumno.setBounds(0, 232, 229, 45);
	panelModificarAlumno.add(lblApellidoModificarAlumno);

	txtFApellidoModificarAlumno = new JTextField();
	txtFApellidoModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFApellidoModificarAlumno.setColumns(10);
	txtFApellidoModificarAlumno.setBounds(229, 232, 305, 45);
	panelModificarAlumno.add(txtFApellidoModificarAlumno);

	JLabel lblDireccionModificarAlumno = new JLabel("DIRECCI\u00D3N");
	lblDireccionModificarAlumno
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDireccionModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblDireccionModificarAlumno.setBounds(0, 290, 229, 45);
	panelModificarAlumno.add(lblDireccionModificarAlumno);

	txtFDireccionModificarAlumno = new JTextField();
	txtFDireccionModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDireccionModificarAlumno.setColumns(10);
	txtFDireccionModificarAlumno.setBounds(229, 290, 305, 45);
	panelModificarAlumno.add(txtFDireccionModificarAlumno);

	JLabel lblFecharNacModificarAlumno = new JLabel("FECHA NACIMIENTO");
	lblFecharNacModificarAlumno
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblFecharNacModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblFecharNacModificarAlumno.setBounds(0, 348, 229, 45);
	panelModificarAlumno.add(lblFecharNacModificarAlumno);

	txtFFechaNacModificarAlumno = new JTextField();
	txtFFechaNacModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFFechaNacModificarAlumno.setColumns(10);
	txtFFechaNacModificarAlumno.setBounds(229, 348, 305, 45);
	panelModificarAlumno.add(txtFFechaNacModificarAlumno);

	JLabel lblTelefonoModificarAlumno = new JLabel("TELEFONO");
	lblTelefonoModificarAlumno
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblTelefonoModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblTelefonoModificarAlumno.setBounds(0, 406, 229, 45);
	panelModificarAlumno.add(lblTelefonoModificarAlumno);

	txtFTelefonoModificarAlumno = new JTextField();
	txtFTelefonoModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFTelefonoModificarAlumno.setColumns(10);
	txtFTelefonoModificarAlumno.setBounds(229, 406, 305, 45);
	panelModificarAlumno.add(txtFTelefonoModificarAlumno);

	btnBorrarModificarAlumno = new JButton(DELETE);
	btnBorrarModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarAlumno.setBounds(229, 522, 190, 58);
	panelModificarAlumno.add(btnBorrarModificarAlumno);

	AdminListener bBorrarMA = new AdminListener(); // / MA=modificar alumno
	IController gestionBorrarMA = new gestionAlumnosController();
	gestionBorrarMA.setView(this);
	bBorrarMA.associate(btnBorrarModificarAlumno, gestionBorrarMA);

	btnLimpiarModificarAlumno = new JButton(CLEAR);
	btnLimpiarModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarAlumno.setBounds(458, 522, 190, 58);
	panelModificarAlumno.add(btnLimpiarModificarAlumno);

	AdminListener bLimpiarMA = new AdminListener(); // / MA=modificar alumno
	IController gestionLimpiarMA = new gestionAlumnosController();
	gestionLimpiarMA.setView(this);
	bLimpiarMA.associate(btnLimpiarModificarAlumno, gestionLimpiarMA);

	btnGuardarModificarAlumno = new JButton(MODIFY);
	btnGuardarModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarAlumno.setBounds(687, 522, 190, 58);
	panelModificarAlumno.add(btnGuardarModificarAlumno);

	AdminListener bGuardarMA = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarMA = new gestionAlumnosController();
	gestionGuardarMA.setView(this);
	bGuardarMA.associate(btnGuardarModificarAlumno, gestionGuardarMA);

	// ////////////////////////// PANEL ALUMNO ALTA
	// ////////////////////////////////////
	JPanel panelAltaAlumno = new JPanel();
	panelAltaAlumno.setLayout(null);
	panelAltaAlumno.setBackground(SystemColor.inactiveCaptionBorder);
	menuAlumno
		.addTab(
			"                            ALTA ALUMNO                           ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/alumnopng.png")),
			panelAltaAlumno, null);

	JLabel lblCartelAltaAlumno = new JLabel(
		"Inserte los Datos del Alumno a dar de Alta");
	lblCartelAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelAltaAlumno.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelAltaAlumno.setBounds(229, 21, 419, 58);
	panelAltaAlumno.add(lblCartelAltaAlumno);

	JLabel lblCartelListaAltaALumno = new JLabel("LISTA DE ALUMNOS");
	lblCartelListaAltaALumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelListaAltaALumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblCartelListaAltaALumno.setBounds(916, 0, 229, 58);
	panelAltaAlumno.add(lblCartelListaAltaALumno);

	JLabel lblDniAltaAlumno = new JLabel(" D.N.I ");
	lblDniAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblDniAltaAlumno.setBackground(Color.BLUE);
	lblDniAltaAlumno.setBounds(0, 118, 229, 45);
	panelAltaAlumno.add(lblDniAltaAlumno);

	txtFDniAltaAlumno = new JTextField();
	txtFDniAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDniAltaAlumno.setColumns(10);
	txtFDniAltaAlumno.setBounds(229, 118, 305, 45);
	panelAltaAlumno.add(txtFDniAltaAlumno);

	listaAltaAlumno = new List();
	listaAltaAlumno.setBounds(916, 58, 229, 464);
	panelAltaAlumno.add(listaAltaAlumno);

	JLabel lblNombreAltaAlumno = new JLabel("NOMBRE");
	lblNombreAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreAltaAlumno.setBounds(0, 174, 229, 45);
	panelAltaAlumno.add(lblNombreAltaAlumno);

	txtFNombreAltaAlumno = new JTextField();
	txtFNombreAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreAltaAlumno.setColumns(10);
	txtFNombreAltaAlumno.setBounds(229, 174, 305, 45);
	panelAltaAlumno.add(txtFNombreAltaAlumno);

	JLabel lblApellidoAltaAlumno = new JLabel("APELLIDO");
	lblApellidoAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblApellidoAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblApellidoAltaAlumno.setBounds(0, 232, 229, 45);
	panelAltaAlumno.add(lblApellidoAltaAlumno);

	txtFApellidoAltaAlumno = new JTextField();
	txtFApellidoAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFApellidoAltaAlumno.setColumns(10);
	txtFApellidoAltaAlumno.setBounds(229, 232, 305, 45);
	panelAltaAlumno.add(txtFApellidoAltaAlumno);

	JLabel lblDireccionAltaAlumno = new JLabel("DIRECCI\u00D3N");
	lblDireccionAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblDireccionAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblDireccionAltaAlumno.setBounds(0, 290, 229, 45);
	panelAltaAlumno.add(lblDireccionAltaAlumno);

	txtFDireccionAltaAlumno = new JTextField();
	txtFDireccionAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDireccionAltaAlumno.setColumns(10);
	txtFDireccionAltaAlumno.setBounds(229, 290, 305, 45);
	panelAltaAlumno.add(txtFDireccionAltaAlumno);

	JLabel lblFechaNacAltaAlumno = new JLabel("FECHA NACIMIENTO");
	lblFechaNacAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblFechaNacAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblFechaNacAltaAlumno.setBounds(0, 348, 229, 45);
	panelAltaAlumno.add(lblFechaNacAltaAlumno);

	txtFFechaNacAltaAlumno = new JTextField();
	txtFFechaNacAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFFechaNacAltaAlumno.setColumns(10);
	txtFFechaNacAltaAlumno.setBounds(229, 348, 305, 45);
	panelAltaAlumno.add(txtFFechaNacAltaAlumno);

	JLabel lblTelefonoAltaAlumno = new JLabel("TELEFONO");
	lblTelefonoAltaAlumno.setHorizontalAlignment(SwingConstants.CENTER);
	lblTelefonoAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblTelefonoAltaAlumno.setBounds(0, 406, 229, 45);
	panelAltaAlumno.add(lblTelefonoAltaAlumno);

	txtFTelefonoAltaAlumno = new JTextField();
	txtFTelefonoAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	txtFTelefonoAltaAlumno.setColumns(10);
	txtFTelefonoAltaAlumno.setBounds(229, 406, 305, 45);
	panelAltaAlumno.add(txtFTelefonoAltaAlumno);

	btnLimpiarAltaAlumno = new JButton(CLEAR);
	btnLimpiarAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarAltaAlumno.setBounds(229, 522, 190, 58);
	panelAltaAlumno.add(btnLimpiarAltaAlumno);

	AdminListener bLimpiarAA = new AdminListener(); // / MA=modificar alumno
	IController gestionLimpiarAA = new gestionAlumnosController();
	gestionLimpiarAA.setView(this);
	bLimpiarAA.associate(btnLimpiarAltaAlumno, gestionLimpiarAA);

	btnGuardarAltaAlumno = new JButton(ADD);
	btnGuardarAltaAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaAlumno.setBounds(573, 522, 190, 58);
	panelAltaAlumno.add(btnGuardarAltaAlumno);
	menuAccionesPanel.add(menuCargo);

	AdminListener bGuardarAA = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarAA = new gestionAlumnosController();
	gestionGuardarAA.setView(this);
	bGuardarAA.associate(btnGuardarAltaAlumno, gestionGuardarAA);

	// ///////////////////////////////////////////////////////////// PANEL
	// DE MODIFICAR CARGO ////////////
	JPanel panelModificarCargo = new JPanel();
	panelModificarCargo.setLayout(null);
	panelModificarCargo.setBackground(SystemColor.activeCaption);
	menuCargo
		.addTab(
			"                          MODIFICAR CARGO                          ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/cargospng.png")),
			panelModificarCargo, null);

	JLabel lblInserteElCodigo = new JLabel("Inserte el Codigo del Cargo");
	lblInserteElCodigo.setHorizontalAlignment(SwingConstants.CENTER);
	lblInserteElCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
	lblInserteElCodigo.setBounds(229, 21, 419, 58);
	panelModificarCargo.add(lblInserteElCodigo);

	JLabel lblListaModificarCArgo = new JLabel("LISTA DE CARGOS");
	lblListaModificarCArgo.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaModificarCArgo.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaModificarCArgo.setBounds(916, 0, 229, 58);
	panelModificarCargo.add(lblListaModificarCArgo);

	JLabel lblCodigoModificarCargo = new JLabel("CODIGO");
	lblCodigoModificarCargo.setHorizontalAlignment(SwingConstants.CENTER);
	lblCodigoModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	lblCodigoModificarCargo.setBackground(Color.BLUE);
	lblCodigoModificarCargo.setBounds(0, 118, 229, 45);
	panelModificarCargo.add(lblCodigoModificarCargo);

	txtFCodigoModificarCargo = new JTextField();
	txtFCodigoModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	txtFCodigoModificarCargo.setColumns(10);
	txtFCodigoModificarCargo.setBounds(229, 118, 305, 45);
	panelModificarCargo.add(txtFCodigoModificarCargo);

	listaModificarCargo = new List();
	listaModificarCargo.setBounds(916, 58, 229, 464);
	panelModificarCargo.add(listaModificarCargo);

	JLabel label_51 = new JLabel("NOMBRE CARGO");
	label_51.setHorizontalAlignment(SwingConstants.CENTER);
	label_51.setFont(new Font("Arial", Font.BOLD, 20));
	label_51.setBounds(0, 232, 229, 45);
	panelModificarCargo.add(label_51);

	txtFNombreModificarCargo = new JTextField();
	txtFNombreModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreModificarCargo.setColumns(10);
	txtFNombreModificarCargo.setBounds(229, 232, 305, 45);
	panelModificarCargo.add(txtFNombreModificarCargo);

	btnLimpiarModificarCargo = new JButton(CLEAR);
	btnLimpiarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarCargo.setBounds(220, 522, 190, 58);
	panelModificarCargo.add(btnLimpiarModificarCargo);
	
	ChargeListener bLimpiarMC= new ChargeListener(); 
	IController gestionLimpiarMC = new ChargeController();
	gestionLimpiarMC.setView(this);
	bLimpiarMC.associate(btnLimpiarModificarCargo, gestionLimpiarMC);

	btnBorrarModificarCargo = new JButton(DELETE);
	btnBorrarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarCargo.setBounds(420, 522, 190, 58);
	panelModificarCargo.add(btnBorrarModificarCargo);

	ChargeListener bBorrarMC= new ChargeListener(); 
	IController gestionBorrarMC = new ChargeController();
	gestionBorrarMC.setView(this);
	bBorrarMC.associate(btnBorrarModificarCargo, gestionBorrarMC);

	btnBuscarModificarCargo = new JButton(SEARCH);
	btnBuscarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarCargo.setBounds(584, 116, 190, 47);
	panelModificarCargo.add(btnBuscarModificarCargo);

	ChargeListener bBuscarMC= new ChargeListener(); 
	IController gestionBuscarMC = new ChargeController();
	gestionBuscarMC.setView(this);
	bBuscarMC.associate(btnBuscarModificarCargo, gestionBuscarMC);
	
	btnGuardarModificarCargo = new JButton(ADD);
	btnGuardarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarCargo.setBounds(620, 522, 190, 58);
	panelModificarCargo.add(btnGuardarModificarCargo);

	ChargeListener bGuardarMC= new ChargeListener(); 
	IController gestionGuardarMC = new ChargeController();
	gestionGuardarMC.setView(this);
	bGuardarMC.associate(btnGuardarModificarCargo, gestionGuardarMC);

	JPanel panelAltaCargo = new JPanel();
	panelAltaCargo.setLayout(null);
	panelAltaCargo.setBackground(SystemColor.inactiveCaptionBorder);
	menuCargo
		.addTab(
			"                        ALTA CARGO                        ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/cargospng.png")),
			panelAltaCargo, null);

	JLabel lblCartelAltaCargo = new JLabel(
		"Inserte el Nombre del Cargo  a Guardar");
	lblCartelAltaCargo.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelAltaCargo.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelAltaCargo.setBounds(269, 29, 419, 58);
	panelAltaCargo.add(lblCartelAltaCargo);

	JLabel lblListaAltaCargo = new JLabel("LISTA DE CARGOS");
	lblListaAltaCargo.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaAltaCargo.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaAltaCargo.setBounds(916, 0, 229, 58);
	panelAltaCargo.add(lblListaAltaCargo);

	listaAltaCargo = new List();
	listaAltaCargo.setBounds(916, 58, 229, 464);
	panelAltaCargo.add(listaAltaCargo);

	JLabel lblNombreAltaCargo = new JLabel("NOMBRE CARGO");
	lblNombreAltaCargo.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreAltaCargo.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreAltaCargo.setBounds(104, 232, 229, 45);
	panelAltaCargo.add(lblNombreAltaCargo);

	txtFNombreAltaCargo = new JTextField();
	txtFNombreAltaCargo.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreAltaCargo.setColumns(10);
	txtFNombreAltaCargo.setBounds(343, 232, 305, 45);
	panelAltaCargo.add(txtFNombreAltaCargo);

	btnGuardarAltaCargo = new JButton(" GUARDAR");
	btnGuardarAltaCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaCargo.setBounds(408, 441, 190, 58);
	panelAltaCargo.add(btnGuardarAltaCargo);
	menuAccionesPanel.add(menuMateria);
	
	ChargeListener bGuardarAC= new ChargeListener(); 
	IController gestionGuardarAC = new ChargeController();
	gestionGuardarAC.setView(this);
	bGuardarAC.associate(btnGuardarAltaCargo, gestionGuardarAC);

	// ////////////////////////////////// MODIFICAR MATERIA
	// //////////////////////////
	JPanel panelModificarMateria = new JPanel();
	panelModificarMateria.setLayout(null);
	panelModificarMateria.setBackground(SystemColor.activeCaption);
	menuMateria
		.addTab(
			"                             MODIFICAR MATERIA                          ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/materiapng.png")),
			panelModificarMateria, null);

	JLabel label_34 = new JLabel("Inserte el Codigo de la Materia ");
	label_34.setHorizontalAlignment(SwingConstants.CENTER);
	label_34.setFont(new Font("Arial", Font.PLAIN, 20));
	label_34.setBounds(229, 21, 419, 58);
	panelModificarMateria.add(label_34);

	JLabel label_35 = new JLabel("LISTA DE MATERIAS");
	label_35.setHorizontalAlignment(SwingConstants.CENTER);
	label_35.setFont(new Font("Arial", Font.BOLD, 20));
	label_35.setBounds(916, 0, 229, 58);
	panelModificarMateria.add(label_35);

	JLabel label_36 = new JLabel("CODIGO");
	label_36.setHorizontalAlignment(SwingConstants.CENTER);
	label_36.setFont(new Font("Arial", Font.BOLD, 20));
	label_36.setBackground(Color.BLUE);
	label_36.setBounds(0, 118, 229, 45);
	panelModificarMateria.add(label_36);

	txtFCodigoModificarMateria = new JTextField();
	txtFCodigoModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFCodigoModificarMateria.setColumns(10);
	txtFCodigoModificarMateria.setBounds(229, 118, 305, 45);
	panelModificarMateria.add(txtFCodigoModificarMateria);

	listaModificarMateria = new List();
	listaModificarMateria.setBounds(916, 58, 229, 464);
	panelModificarMateria.add(listaModificarMateria);

	JLabel label_37 = new JLabel("NOMBRE MATERIA");
	label_37.setHorizontalAlignment(SwingConstants.CENTER);
	label_37.setFont(new Font("Arial", Font.BOLD, 20));
	label_37.setBounds(0, 232, 229, 45);
	panelModificarMateria.add(label_37);

	txtFNombreModificarMateria = new JTextField();
	txtFNombreModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreModificarMateria.setColumns(10);
	txtFNombreModificarMateria.setBounds(229, 232, 305, 45);
	panelModificarMateria.add(txtFNombreModificarMateria);

	btnLimpiarModificarMateria = new JButton(CLEAR);
	btnLimpiarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarMateria.setBounds(220, 522, 190, 58);
	panelModificarMateria.add(btnLimpiarModificarMateria);

	AdminListener bLimpiarMM = new AdminListener(); // / MA=modificar alumno
	IController gestionLimpiarMM = new subjectManagementController();
	gestionLimpiarMM.setView(this);
	bLimpiarMM.associate(btnLimpiarModificarMateria, gestionLimpiarMM);

	btnBorrarModificarMateria = new JButton(DELETE);
	btnBorrarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarMateria.setBounds(420, 522, 190, 58);
	panelModificarMateria.add(btnBorrarModificarMateria);

	AdminListener bBorrarMM = new AdminListener(); // / MA=modificar alumno
	IController gestionBorrarMM = new subjectManagementController();
	gestionBorrarMM.setView(this);
	bBorrarMM.associate(btnBorrarModificarMateria, gestionBorrarMM);

	btnBuscarModificarMateria = new JButton(SEARCH);
	btnBuscarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarMateria.setBounds(584, 116, 190, 47);
	panelModificarMateria.add(btnBuscarModificarMateria);

	AdminListener bBuscarMM = new AdminListener(); // / MA=modificar alumno
	IController gestionBuscarMM = new subjectManagementController();
	gestionBuscarMM.setView(this);
	bBuscarMM.associate(btnBuscarModificarMateria, gestionBuscarMM);

	btnGuardarModificarMateria = new JButton(ADD);
	btnGuardarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarMateria.setBounds(620, 522, 190, 58);
	panelModificarMateria.add(btnGuardarModificarMateria);

	AdminListener bGuardarMM = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarMM = new subjectManagementController();
	gestionGuardarMM.setView(this);
	bGuardarMM.associate(btnGuardarModificarMateria, gestionGuardarMM);

	// /////////////////////////////////////// ALTA MATERIA
	// ////////////////////////////////////////////////////////
	JPanel panelAltaMateria = new JPanel();
	panelAltaMateria.setLayout(null);
	panelAltaMateria.setBackground(SystemColor.inactiveCaptionBorder);
	menuMateria
		.addTab(
			"                      ALTA MATERIA                         ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/materiapng.png")),
			panelAltaMateria, null);

	JLabel label_38 = new JLabel(
		"Inserte el Nombre de la Materia  a Guardar");
	label_38.setHorizontalAlignment(SwingConstants.CENTER);
	label_38.setFont(new Font("Arial", Font.PLAIN, 20));
	label_38.setBounds(269, 29, 419, 58);
	panelAltaMateria.add(label_38);

	JLabel label_39 = new JLabel("LISTA DE MATERIAS");
	label_39.setHorizontalAlignment(SwingConstants.CENTER);
	label_39.setFont(new Font("Arial", Font.BOLD, 20));
	label_39.setBounds(916, 0, 229, 58);
	panelAltaMateria.add(label_39);

	listaAltaMateria = new List();
	listaAltaMateria.setBounds(916, 58, 229, 464);
	panelAltaMateria.add(listaAltaMateria);

	JLabel label_41 = new JLabel("NOMBRE MATERIA");
	label_41.setHorizontalAlignment(SwingConstants.CENTER);
	label_41.setFont(new Font("Arial", Font.BOLD, 20));
	label_41.setBounds(104, 232, 229, 45);
	panelAltaMateria.add(label_41);

	txtFNombreAltaMateria = new JTextField();
	txtFNombreAltaMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreAltaMateria.setColumns(10);
	txtFNombreAltaMateria.setBounds(343, 232, 305, 45);
	panelAltaMateria.add(txtFNombreAltaMateria);

	btnGuardarAltaMateria = new JButton(" GUARDAR");
	btnGuardarAltaMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaMateria.setBounds(408, 441, 190, 58);
	panelAltaMateria.add(btnGuardarAltaMateria);
	menuAcciones.setLayout(gl_menuAcciones);

	AdminListener bGuardarAM = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarAM = new subjectManagementController();
	gestionGuardarAM.setView(this);
	bGuardarAM.associate(btnGuardarAltaMateria, gestionGuardarAM);

	JPanel menuAdmin = new JPanel();
	menuAdmin.setBackground(new Color(119, 136, 153));
	menuAdminScroll.setViewportView(menuAdmin);
	// ---------------------------------PANELES DE ALUMNO,DOCENTE,FACULTAD Y
	// CARGO-----------------------------------------
	JButton btnAlumnos = new JButton("ALUMNOS");
	btnAlumnos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(
		51, 51, 102), null, null, null));
	btnAlumnos.setBackground(UIManager.getColor("Button.shadow"));
	btnAlumnos.setBounds(10, 32, 159, 70);
	btnAlumnos.setForeground(UIManager.getColor("Button.foreground"));
	btnAlumnos.setFont(new Font("Arial", Font.BOLD, 20));
	btnAlumnos
		.setSelectedIcon(new ImageIcon(
			administrador.class
				.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
	btnAlumnos.setIcon(null);
	btnAlumnos.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		menuAlumno.setVisible(true);
		menuDocente.setVisible(false);
		menuFacultad.setVisible(false);
		menuMateria.setVisible(false);
		menuCargo.setVisible(false);
		bienvenido.setVisible(false);

	    }
	});

	JButton btnDocentes = new JButton("DOCENTES");
	btnDocentes.setBackground(UIManager.getColor("Button.shadow"));
	btnDocentes.setFont(new Font("Arial", Font.BOLD, 20));
	btnDocentes.setBounds(10, 164, 159, 70);
	btnDocentes.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		menuAlumno.setVisible(false);
		menuDocente.setVisible(true);
		menuFacultad.setVisible(false);
		menuMateria.setVisible(false);
		menuCargo.setVisible(false);
		bienvenido.setVisible(false);
	    }
	});
	JButton btnMateria = new JButton("  MATERIA");
	btnMateria.setBackground(UIManager.getColor("Button.shadow"));
	btnMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnMateria.setBounds(10, 297, 159, 70);
	btnMateria.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		menuAlumno.setVisible(false);
		menuDocente.setVisible(false);
		menuFacultad.setVisible(false);
		menuMateria.setVisible(true);
		menuCargo.setVisible(false);
		bienvenido.setVisible(false);
	    }
	});

	JButton btnFacultad = new JButton("FACULTAD");
	btnFacultad.setBackground(UIManager.getColor("Button.shadow"));
	btnFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnFacultad.setBounds(10, 437, 159, 65);
	btnFacultad.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		menuAlumno.setVisible(false);
		menuDocente.setVisible(false);
		menuFacultad.setVisible(true);
		menuMateria.setVisible(false);
		menuCargo.setVisible(false);
		bienvenido.setVisible(false);
	    }
	});

	JButton btnCargos = new JButton("CARGOS");
	btnCargos.setFont(new Font("Arial", Font.BOLD, 20));
	btnCargos.setBackground(UIManager.getColor("Button.shadow"));
	btnCargos.setBounds(10, 570, 159, 65);
	btnCargos.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		menuAlumno.setVisible(false);
		menuDocente.setVisible(false);
		menuFacultad.setVisible(false);
		menuMateria.setVisible(false);
		menuCargo.setVisible(true);
	    }
	});
	menuAdmin.setLayout(null);
	menuAdmin.add(btnAlumnos);
	menuAdmin.add(btnDocentes);
	menuAdmin.add(btnMateria);
	menuAdmin.add(btnFacultad);
	menuAdmin.add(btnCargos);
	administrador.setLayout(gl_administrador);
    }

    // cuando presione entert sobre algun elemento de la lista o doble clic lo q
    // hace pone el numero de documento en la pesta�a buscar de dicha trabbla
    /*
     * private void getDniFronListMod() { return null; }
     */
    // -------------------------------------------------------------------------------
    // //------------------------------------------------------------------------------

    public void setTfTelefono_modif_A(String s) {
	txtFTelefonoModificarAlumno.setText(s);
    }

    public void setTfNombre_modif_A(String s) {
	txtFNombreModificarAlumno.setText(s);
    }

    public void setTfFechaNac_modif_A(String s) {
	txtFFechaNacModificarAlumno.setText(s);
    }

    public void setTfDni_modif_A(String s) {
	txtFBuscarDniModificarAlmuno.setText(s);
    }

    public void setTfDireccion_modif_A(String s) {
	txtFDireccionModificarAlumno.setText(s);
    }

    public void setTfApellido_modif_A(String s) {
	txtFApellidoModificarAlumno.setText(s);
    }

    public void setDniAlta_A(String s) {
	txtFDniAltaAlumno.setText(s);
    }

    public void setNombreAlta_A(String s) {
	txtFNombreAltaAlumno.setText(s);
    }

    public void setApellidoAlta_A(String s) {
	txtFApellidoAltaAlumno.setText(s);
    }

    public void setDireccionAlta_A(String s) {
	txtFDireccionAltaAlumno.setText(s);
    }

    public void setFechaNacAlta_A(String s) {
	txtFFechaNacAltaAlumno.setText(s);
    }

    public void setTelefonoAlta_A(String s) {
	txtFTelefonoAltaAlumno.setText(s);
    }

    public String getNameAlta_A() {
	return txtFNombreAltaAlumno.getText().trim();
    }

    public String getLastnameAlta_A() {
	return txtFApellidoAltaAlumno.getText().trim();
    }

    public String getFechaNacAlta_A() {
	return txtFFechaNacAltaAlumno.getText().trim();
    }

    public String getTelefonoAlta_A() {
	return txtFTelefonoAltaAlumno.getText().trim();
    }

    public String getDireccionAlta_A() {
	return txtFDireccionAltaAlumno.getText().trim();
    }

    public String getDniAlta_A() {
	return txtFDniAltaAlumno.getText().trim();
    }

    public String getNameMod_A() {
	return txtFNombreModificarAlumno.getText().trim();
    }

    public String getLastnameMod_A() {
	return txtFApellidoModificarAlumno.getText().trim();
    }

    public String getFechaNacMod_A() {
	return txtFFechaNacModificarAlumno.getText().trim();
    }

    public String getTelefonoMod_A() {
	return txtFTelefonoModificarAlumno.getText().trim();
    }

    public String getDireccionMod_A() {
	return txtFDireccionModificarAlumno.getText().trim();
    }

    public String getDniMod_A() {
	return txtFBuscarDniModificarAlmuno.getText().trim();
    }

    public void close() {
	this.dispose();
    }

    public void deleteViewFieldsAlta_A() {
	this.setNombreAlta_A("");
	this.setDireccionAlta_A("");
	this.setDniAlta_A("");
	this.setApellidoAlta_A("");
	this.setFechaNacAlta_A("");
	this.setTelefonoAlta_A("");

    }

    public void deleteViewFieldsMod_A() {
	// TODO Auto-generated method stub
	this.setTfTelefono_modif_A("");
	this.setTfNombre_modif_A("");
	this.setTfFechaNac_modif_A("");
	this.setTfDni_modif_A("");
	this.setTfDireccion_modif_A("");
	this.setTfApellido_modif_A("");

    }

    // si quedan campos en blancos retorna false en la pestaña alta
    public boolean fieldsIsOkAlta_A() {
	return !(this.getDireccionAlta_A().compareTo("") == 0)
		&& !(this.getTelefonoAlta_A().compareTo("") == 0)
		&& !(this.getDniAlta_A().compareTo("") == 0)
		&& !(this.getLastnameAlta_A().compareTo("") == 0)
		&& !(this.getNameAlta_A().compareTo("") == 0)
		&& !(this.getFechaNacAlta_A().compareTo("") == 0);

    }

    // ************************************************************************************
    // ******************Y ESTO PARA
    // DOCENTE*****************************************************************
    // ***********A
    // TODO*************************************************************************

    public void clearAlta() {
	setDniAlta_D("");
	setNombreAlta_D("");
	setApellidoAlta_D("");
	setFechaAlta_D("");
	setTelefonoAlta_D("");
	setDireccionAlta_D("");
    }

    public void clearModif() {
	setDniModif_D("");
	setNombreModif_D("");
	setApellidoModif_D("");
	setFechaModif_D("");
	setTelefonoModif_D("");
	setDireccionModif_D("");
    }

    public String getDniAlta_D() {
	return txtFDniAltaDocente.getText().trim();
    }

    public void setDniAlta_D(String st) {
	txtFDniAltaDocente.setText(st);
    }

    public String getDniModif_D() {
	return txtFBuscarDniModificarDocente.getText().trim();
    }

    public void setDniModif_D(String st) {
	txtFBuscarDniModificarDocente.setText(st);
    }

    public String getNombreAlta_D() {
	return txtFNombreAltaDocente.getText().trim();
    }

    public void setNombreAlta_D(String st) {
	txtFNombreAltaDocente.setText(st);
    }

    public String getNombreModif_D() {
	return txtFNombreModificarDocente.getText().trim();
    }

    public void setNombreModif_D(String st) {
	txtFNombreModificarDocente.setText(st);
    }

    public String getApellidoAlta_D() {
	return txtFApellidoAltaDocente.getText().trim();
    }

    public void setApellidoAlta_D(String st) {
	txtFApellidoAltaDocente.setText(st);
    }

    public String getApellidoModif_D() {
	return txtFApellidoModificaDocente.getText().trim();
    }

    public void setApellidoModif_D(String st) {
	txtFApellidoModificaDocente.setText(st);
    }

    public String getFechaAlta_D() {
	return txtFFechaNacAltaDocente.getText().trim();
    }

    public void setFechaAlta_D(String st) {
	txtFFechaNacAltaDocente.setText(st);
    }

    public String getFechaModif_D() {
	return txtFFechaNacModificarDocente.getText().trim();
    }

    public void setFechaModif_D(String st) {
	txtFFechaNacModificarDocente.setText(st);
    }

    public String getTelefonoAlta_D() {
	return txtFTelefonoAltaDocente.getText().trim();
    }

    public void setTelefonoAlta_D(String st) {
	txtFTelefonoAltaDocente.setText(st);
    }

    public String getTelefonoModif_D() {
	return txtFTelefonoModificarDocente.getText().trim();
    }

    public void setTelefonoModif_D(String st) {
	txtFTelefonoModificarDocente.setText(st);
    }

    public String getDireccionAlta_D() {
	return txtFDireccionAltaDocente.getText().trim();
    }

    public void setDireccionAlta_D(String st) {
	txtFDireccionAltaDocente.setText(st);
    }

    public String getDireccionModif_D() {
	return txtFDireccionModificaDocente.getText().trim();
    }

    public void setDireccionModif_D(String st) {
	txtFDireccionModificaDocente.setText(st);
    }

    public boolean fieldsIsOkAlta_D() {
	return !(this.getDireccionAlta_D().compareTo("") == 0)
		&& !(this.getTelefonoAlta_D().compareTo("") == 0)
		&& !(this.getDniAlta_D().compareTo("") == 0)
		&& !(this.getApellidoAlta_D().compareTo("") == 0)
		&& !(this.getNombreAlta_D().compareTo("") == 0)
		&& !(this.getFechaAlta_D().compareTo("") == 0);

    }

    public void deleteViewFieldsMod_D() {
	// TODO Auto-generated method stub
	this.setTelefonoModif_D("");
	this.setNombreModif_D("");
	this.setFechaModif_D("");
	this.setDniModif_D("");
	this.setDireccionModif_D("");
	this.setApellidoModif_D("");
	this.setTelefonoAlta_D("");
	this.setNombreAlta_D("");
	this.setFechaAlta_D("");
	this.setDniAlta_D("");
	this.setDireccionAlta_D("");
	this.setApellidoAlta_D("");

    }

    // ----------------------FACULTAD GET AND
    // SET-------------------------------//
    // ////////////////////////////////////////////////////////////////////////////////////////////////
    public String getCodigoModificarFacultad() {
	return txtFCodigoModificarFacultad.getText().trim();
    }

    public void setCodigoModificarFacultad(String s) {
	txtFCodigoModificarFacultad.setText(s);
    }

    public String getNombreModificarFacultad() {
	return txtFNombreModificarFacultad.getText().trim();
    }

    public void setNombreModificarFacultad(String s) {
	txtFNombreModificarFacultad.setText(s);
    }

    public String getNombreAltaFacultad() {
	return txtFNombreAltaFacultad.getText().trim();
    }

    public void setNombreAltaFacultad(String s) {
	txtFNombreAltaFacultad.setText(s);
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // *************************************************************************************************
    // **************************GET Y SET DE
    // MATERIAS***********************************************************************
    // *************************************************************************************************

    // devuelve lo que tienen los textFields
    public String getModifyNameTF_M() {
	return txtFNombreModificarMateria.getText();
    }

    public String getModifyCodeTF_M() {
	return txtFCodigoModificarMateria.getText();
    }

    public String getAddNameTF_M() {
	return txtFNombreAltaMateria.getText();
    }

    // setea lo que tienen los textFields
    public void setModifyNameTF_M(String s) {
	txtFNombreModificarMateria.setText(s);
    }

    public void setModifyCodeTF_M(String s) {
	txtFCodigoModificarMateria.setText(s);
    }

    public void setAddNameTF_(String s) {
	txtFNombreAltaMateria.setText(s);
    }

    // setea los textFields de gestionar materia en blanco
    public void setEmptyFields() {
	this.setModifyNameTF_M("");
	this.setModifyCodeTF_M("");
    }

    // /////////////////////////////////////////////////////////////////////////////
    // /---------------------------CARGO ------GET Y SET --------------------

    public String getCodigoModificarCargo() {
	return txtFCodigoModificarMateria.getText();
    }

    public void setCodigoModificarCargo(String s) {
	txtFCodigoModificarMateria.setText(s);
    }

    public String getNombreModificarCargo() {
	return txtFNombreModificarMateria.getText();
    }

    public void setNombreModificarCargo(String s) {
	txtFNombreModificarMateria.setText(s);
    }

    public String getNombreAltaCargo() {
	return txtFNombreAltaMateria.getText();
    }

    public void setNombreAltaCargo(String s) {
	txtFNombreAltaMateria.setText(s);
    }

    @Override
    public void present(String model) {
	JOptionPane.showMessageDialog(null, model);
    }

    /**
     * @param listaAlumnos
     */
    public void setListAlumnos_ABM(LinkedList<String> listaAlumnos) {
	listaModificarAlumno.removeAll();
	listaAltaAlumno.removeAll();
	for (int i = 0; i < listaAlumnos.size(); i++) {
	    listaModificarAlumno.add(listaAlumnos.get(i), i);
	    listaAltaAlumno.add(listaAlumnos.get(i), i);
	}
    }

    /**
     * @param listaDocente
     */
    public void setListDocente_ABM(LinkedList<String> listaDocente) {
	listaModificarDocente.removeAll();
	listaAltaDocente.removeAll();
	for (int i = 0; i < listaDocente.size(); i++) {
	    listaModificarDocente.add(listaDocente.get(i), i);
	    listaAltaDocente.add(listaDocente.get(i), i);
	}
    }

    /**
     * @param listaFacultad
     */
    public void setListFacultad_ABM(LinkedList<String> listaFacultad) {
	listaAltaFacultad.removeAll();
	listaMoificarFacultad.removeAll();
	for (int i = 0; i < listaFacultad.size(); i++) {
	    listaAltaFacultad.add(listaFacultad.get(i), i);
	    listaMoificarFacultad.add(listaFacultad.get(i), i);
	}
    }

    /**
     * @param listaMateria
     */
    public void setListMateria_ABM(LinkedList<String> listaMateria) {
	listaAltaMateria.removeAll();
	listaModificarMateria.removeAll();
	for (int i = 0; i < listaMateria.size(); i++) {
	    listaModificarMateria.add(listaMateria.get(i), i);
	    listaAltaMateria.add(listaMateria.get(i), i);
	}
    }

    // /////////////////////////////////////////////////////////////////////////////////
}
	