package educar.gui.AdminViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.controllers.AdminController.AdminController;
import educar.controllers.AdminController.AsignacionDocenteController;
import educar.controllers.AdminController.CargoListaDedicacionDocenteController;
import educar.controllers.AdminController.ChargeController;
import educar.controllers.AdminController.DedicacionDocenteController;
import educar.controllers.AdminController.HsDedicacionDocenteListController;
import educar.controllers.AdminController.gestionAlumnosController;
import educar.controllers.AdminController.gestionDocenteController;
import educar.controllers.AdminController.gestionFacultadController;
import educar.controllers.AdminController.subjectManagementController;
import educar.gui.IView;
import educar.gui.Listener.AdminListListener;
import educar.gui.Listener.AdminListener;
import educar.languaje.defaultLanguaje;

public class administrador extends JFrame implements IView, defaultLanguaje {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
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
    private JTabbedPane menuAsignacionDocente;
    private JTabbedPane menuDedicacionDocente;
    private JTabbedPane bienvenido;
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
    // -----------------------------------------------------------------------
    private List listaModificarDocente;
    private List listaAltaDocente;
    private List listaAltaFacultad;
    private JButton btnLimpiarModificarMateria;
    private JButton btnBorrarModificarMateria;
    private JButton btnBuscarModificarMateria;
    private JButton btnGuardarModificarMateria;
    private JButton btnGuardarAltaMateria;
    private List listaMateriaAltaMateria;
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
    private List listaAltaAlumno;
    private JButton btnLimpiarAltaAlumno;
    private JButton btnGuardarAltaAlumno;
    private JButton btnLimpiarModificarDocente;
    private JButton btnGuardarModificarDocente;
    private JButton btnBorrarModificarDocente;
    private JButton btnBuscarModificarDocente;
    private JButton btnLimpiarAltaDocente;
    private JButton btnGuardarAltaDocente;
    private List listaMateriaModificarMateria;

    private JPanel panelModificarDedicacionDocente;
    private JTextField txtFDniModificarDedicacionDocente;
    private JTextField txtFFacultadModificarDedicacionDocente;
    private JTextField txtFCargoModificarDedicacionDocente;
    private JTextField txtFDedicacionModificarDedicacionDocente;
    private JButton btnLimpiarModificacionDedicacionDocente;
    private JButton btnGuardarModificacionDedicacionDocente;
    private List listaModificarDedicacionDocente;
    private JButton btnBorrarModificacionDedicacionDocente;
    private JPanel panelAltaDedicacionDocente;
    private JTextField txtFDniAltaDedicacionDocente;
    private List listaCargoAltaDedicacionDocente;
    private JTextField txtFFacultadAltaDedicacionDocente;
    private JTextField txtFCargoAltaDedicacionDocente;
    private JTextField txtFDedicacionAltaDedicacionDocente;
    private JButton btnLimpiarAltaDedicacionDocente;
    private JButton btnGuardarAltaDedicacionDocente;
    private List listaFacultadAltaDedicacionDocente;
    private List listaDniAltaDedicacionDocente;
    private List listaListaDocentesDedicacionAltaDedicacionDocente;
    private JPanel panelEncargadoAsignacionDocente;
    private JTextField txtFMateriaEncargadoAsignacionMateria;
    private JTextField txtFDocenteEncargadoAsignacionMateria;
    private JButton btnLimpiarEncargadoAsignacionMateria;
    private JButton btnGuardarEncargadoAsignacionMateria;
    private List listaAsignacionMateria;
    private JButton btnBorrarEncargadoAsignacionMateria;
    private JTextField txtFDniEncargadoAsignacionMateria;
    private List listaAsignacionDocente2;
    private JPanel panelDesignacionAsignacionDocente;
    private JTextField txtFMateriaDesignacionAsignacionDocente;
    private JTextField txtFDocenteDesignacionAsignacionDocente;
    private JButton btnLimpiarDesignacionAsignacionDocente;
    private JButton btnGuardarDesignacionAsignacionDocente;
    private List listaAsignacionMateria2;
    private JButton btnBorrarDesignacionAsignacionDocente;
    private JTextField txtFDniDesignacionAsignacionDocente;
    private List listaAsignacionDocente;
    private JPanel panel;
    private JLabel label;
    private JTextField txtFFacultadAltaMateria;
    private List listFacultadAltaMateria;
    private JLabel lblListaDeFacultadMMateria;
    private List listFacultadModificarMateria;
    private JTextField textFFacultadModificarMateria;

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

	bienvenido = new JTabbedPane(JTabbedPane.TOP);
	bienvenido.setBounds(0, 0, 1151, 666);
	bienvenido.setVisible(true);

	menuAlumno = new JTabbedPane(JTabbedPane.TOP);
	menuAlumno.setBounds(0, 0, 1151, 666);
	menuAlumno.setVisible(false);

	menuDocente = new JTabbedPane(JTabbedPane.TOP);
	menuDocente.setBounds(0, 0, 1151, 655);
	menuDocente.setBackground(new Color(176, 196, 222));
	menuDocente.setVisible(false);

	menuMateria = new JTabbedPane(JTabbedPane.TOP);
	menuMateria.setBounds(0, 0, 1151, 666);
	menuMateria.setVisible(false);

	menuFacultad = new JTabbedPane(JTabbedPane.TOP);
	menuFacultad.setBounds(0, 0, 1151, 666);
	menuFacultad.setVisible(false);

	menuCargo = new JTabbedPane(JTabbedPane.TOP);
	menuCargo.setBounds(0, 0, 1151, 666);

	menuDedicacionDocente = new JTabbedPane(JTabbedPane.TOP);
	menuDedicacionDocente.setBounds(0, 0, 1151, 666);
	menuDedicacionDocente.setVisible(false);

	menuAsignacionDocente = new JTabbedPane(JTabbedPane.TOP);
	menuAsignacionDocente.setBounds(0, 0, 1151, 666);
	menuAsignacionDocente.setVisible(false);

	// ||||||||||||||||PANEL ALTA DOCENTE||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||//

	JPanel panelAltaDocente = new JPanel();
	panelAltaDocente.setLayout(null);
	panelAltaDocente.setBackground(SystemColor.activeCaption);
	menuDocente
		.addTab(
			"                           ALTA DOCENTE                            ",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/docentepng.png")),
			panelAltaDocente, null);
	menuDocente.setEnabledAt(0, true);
	menuDocente.setBackgroundAt(0, SystemColor.windowBorder);

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

	AdminListListener listaDA1 = new AdminListListener();
	IListController listaControllerDA1 = new gestionDocenteController();
	((IController) listaControllerDA1).setView(this);
	listaDA1.associate(listaAltaDocente, listaControllerDA1);

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

	// ||||||||||||||||PANEL MODIFICAR DOCENTE||||||||||||||||//
	// |||||||||||||||||||||||||||||||||||||||||||||||||||||||//

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
	menuDocente.setBackgroundAt(1, SystemColor.windowBorder);

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

	AdminListListener listaDM1 = new AdminListListener();
	IListController listaControllerDM = new gestionDocenteController();
	((IController) listaControllerDM).setView(this);
	listaDM1.associate(listaModificarDocente, listaControllerDM);

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

	AdminListener bGuardarMD = new AdminListener();
	IController gestionGuardarMD = new gestionDocenteController();
	gestionGuardarMD.setView(this);
	bGuardarMD.associate(btnGuardarModificarDocente, gestionGuardarMD);

	// ||||||||||||||||PANEL MODIFICAR FACULTAD||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

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

	AdminListListener listaMF1 = new AdminListListener();
	IListController listaMFController1 = new gestionFacultadController();
	((IController) listaMFController1).setView(this);
	listaMF1.associate(listaMoificarFacultad, listaMFController1);

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

	btnLimpiarModificarFacultad = new JButton(CLEAR);
	btnLimpiarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarFacultad.setBounds(220, 522, 190, 58);
	panelModificarFacultad.add(btnLimpiarModificarFacultad);

	AdminListener bLimpiarMF = new AdminListener(); // / MA=modificar alumno
	IController gestionLimpiarMF = new gestionFacultadController();
	gestionLimpiarMF.setView(this);
	bLimpiarMF.associate(btnLimpiarModificarFacultad, gestionLimpiarMF);

	btnBorrarModificarFacultad = new JButton(DELETE);
	btnBorrarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarFacultad.setBounds(420, 522, 190, 58);
	panelModificarFacultad.add(btnBorrarModificarFacultad);

	AdminListener bBorrarMF = new AdminListener(); // / MF=modificar
	// facultad
	IController gestionBorrarMF = new gestionFacultadController();
	gestionBorrarMF.setView(this);
	bBorrarMF.associate(btnBorrarModificarFacultad, gestionBorrarMF);

	btnBuscarModificarFacultad = new JButton(SEARCH);
	btnBuscarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarFacultad.setBounds(584, 116, 190, 47);
	panelModificarFacultad.add(btnBuscarModificarFacultad);

	AdminListener bBuscarMF = new AdminListener(); // / MA=modificar alumno
	IController gestionBuscarMF = new gestionFacultadController();
	gestionBuscarMF.setView(this);
	bBuscarMF.associate(btnBuscarModificarFacultad, gestionBuscarMF);

	btnGuardarModificarFacultad = new JButton(MODIFY);
	btnGuardarModificarFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarFacultad.setBounds(620, 522, 190, 58);
	panelModificarFacultad.add(btnGuardarModificarFacultad);

	AdminListener bGuardarMF = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarMF = new gestionFacultadController();
	gestionGuardarMF.setView(this);
	bGuardarMF.associate(btnGuardarModificarFacultad, gestionGuardarMF);

	// ||||||||||||||||PANEL ALTA FACULTAD||||||||||||||||//
	// |||||||||||||||||||||||||||||||||||||||||||||||||||//

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

	AdminListListener listaMF2 = new AdminListListener();
	IListController listaMFController2 = new gestionFacultadController();
	((IController) listaMFController2).setView(this);
	listaMF2.associate(listaAltaFacultad, listaMFController2);

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

	btnGuardarAltaFacultad = new JButton(ADD);
	btnGuardarAltaFacultad.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaFacultad.setBounds(408, 441, 190, 58);
	panelAltaFacultad.add(btnGuardarAltaFacultad);
	menuAccionesPanel.add(menuAlumno);

	AdminListener bGuardarAF = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarAF = new gestionFacultadController();
	gestionGuardarAF.setView(this);
	bGuardarAF.associate(btnGuardarAltaFacultad, gestionGuardarAF);

	// ||||||||||||||||PANEL MODIFICAR ALUMNO||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||||||//

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

	listaModificarAlumno = new List();
	listaModificarAlumno.setFont(new Font("Arial", Font.BOLD, 20));
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

	// ||||||||||||||||PANEL ALTA ALUMNO|||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||//

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

	AdminListener bGuardarAA = new AdminListener(); // / MA=modificar alumno
	IController gestionGuardarAA = new gestionAlumnosController();
	gestionGuardarAA.setView(this);
	bGuardarAA.associate(btnGuardarAltaAlumno, gestionGuardarAA);

	// ||||||||||||||||PANEL MODIFICAR CARGO||||||||||||||||//
	// |||||||||||||||||||||||||||||||||||||||||||||||||||||//

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
	menuCargo.setBackgroundAt(0, SystemColor.windowBorder);

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

	AdminListListener listaMC1 = new AdminListListener();
	IListController listaMCController1 = new ChargeController();
	((IController) listaMCController1).setView(this);
	listaMC1.associate(listaModificarCargo, listaMCController1);

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

	AdminListener bLimpiarMC = new AdminListener();
	IController gestionLimpiarMC = new ChargeController();
	gestionLimpiarMC.setView(this);
	bLimpiarMC.associate(btnLimpiarModificarCargo, gestionLimpiarMC);

	btnBorrarModificarCargo = new JButton(DELETE);
	btnBorrarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarCargo.setBounds(420, 522, 190, 58);
	panelModificarCargo.add(btnBorrarModificarCargo);

	AdminListener bBorrarMC = new AdminListener();
	IController gestionBorrarMC = new ChargeController();
	gestionBorrarMC.setView(this);
	bBorrarMC.associate(btnBorrarModificarCargo, gestionBorrarMC);

	btnBuscarModificarCargo = new JButton(SEARCH);
	btnBuscarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarCargo.setBounds(584, 116, 190, 47);
	panelModificarCargo.add(btnBuscarModificarCargo);

	AdminListener bBuscarMC = new AdminListener();
	IController gestionBuscarMC = new ChargeController();
	gestionBuscarMC.setView(this);
	bBuscarMC.associate(btnBuscarModificarCargo, gestionBuscarMC);

	btnGuardarModificarCargo = new JButton(MODIFY);
	btnGuardarModificarCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarCargo.setBounds(620, 522, 190, 58);
	panelModificarCargo.add(btnGuardarModificarCargo);

	AdminListener bGuardarMC = new AdminListener();
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
	menuCargo.setBackgroundAt(1, SystemColor.windowBorder);

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

	AdminListListener listaMC2 = new AdminListListener();
	IListController listaMCController2 = new subjectManagementController();
	((IController) listaMCController2).setView(this);
	listaMC2.associate(listaAltaCargo, listaMCController2);

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

	btnGuardarAltaCargo = new JButton(ADD);
	btnGuardarAltaCargo.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaCargo.setBounds(408, 441, 190, 58);
	panelAltaCargo.add(btnGuardarAltaCargo);

	AdminListener bGuardarAC = new AdminListener();
	IController gestionGuardarAC = new ChargeController();
	gestionGuardarAC.setView(this);
	bGuardarAC.associate(btnGuardarAltaCargo, gestionGuardarAC);

	// ||||||||||||||||PANEL MODIFICAR MATERIA||||||||||||||||//
	// |||||||||||||||||||||||||||||||||||||||||||||||||||||||//

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
	label_34.setBounds(10, 21, 638, 58);
	panelModificarMateria.add(label_34);

	JLabel lblListaDeFacultades = new JLabel("LISTA DE FACULTADES");
	lblListaDeFacultades.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDeFacultades.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaDeFacultades.setBounds(658, 0, 229, 58);
	panelModificarMateria.add(lblListaDeFacultades);

	JLabel label_35 = new JLabel("LISTA DE MATERIAS");
	label_35.setHorizontalAlignment(SwingConstants.CENTER);
	label_35.setFont(new Font("Arial", Font.BOLD, 20));
	label_35.setBounds(916, 0, 229, 58);
	panelModificarMateria.add(label_35);

	JLabel label_36 = new JLabel("CODIGO");
	label_36.setHorizontalAlignment(SwingConstants.CENTER);
	label_36.setFont(new Font("Arial", Font.BOLD, 20));
	label_36.setBackground(Color.BLUE);
	label_36.setBounds(0, 118, 200, 45);
	panelModificarMateria.add(label_36);

	txtFCodigoModificarMateria = new JTextField();
	txtFCodigoModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFCodigoModificarMateria.setColumns(10);
	txtFCodigoModificarMateria.setBounds(229, 118, 265, 45);
	panelModificarMateria.add(txtFCodigoModificarMateria);

	listaMateriaModificarMateria = new List();
	listaMateriaModificarMateria.setBounds(916, 58, 229, 444);
	panelModificarMateria.add(listaMateriaModificarMateria);

	/*
	 * AdminListListener listaMM1 = new AdminListListener(); IListController
	 * listaMMController1 = new subjectManagementController();
	 * ((IController) listaMMController1).setView(this);
	 * listaMM1.associate(listaMateriaModificarMateria, listaMMController1);
	 */

	listFacultadModificarMateria = new List();
	listFacultadModificarMateria.setBounds(654, 58, 242, 444);
	panelModificarMateria.add(listFacultadModificarMateria);

	AdminListListener listaFacultadM1 = new AdminListListener();
	IListController listaFacultadMController1 = new subjectManagementController();
	((IController) listaFacultadMController1).setView(this);
	listaFacultadM1.associate(listFacultadModificarMateria,
		listaFacultadMController1);

	JLabel label_37 = new JLabel("NOMBRE MATERIA");
	label_37.setHorizontalAlignment(SwingConstants.CENTER);
	label_37.setFont(new Font("Arial", Font.BOLD, 20));
	label_37.setBounds(0, 232, 200, 45);
	panelModificarMateria.add(label_37);

	txtFNombreModificarMateria = new JTextField();
	txtFNombreModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreModificarMateria.setColumns(10);

	txtFNombreModificarMateria.setBounds(229, 232, 265, 45);
	panelModificarMateria.add(txtFNombreModificarMateria);

	JLabel lblCodigoFacultadModificarMAteria = new JLabel("CODIGO FACULTAD");
	lblCodigoFacultadModificarMAteria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCodigoFacultadModificarMAteria.setFont(new Font("Arial", Font.BOLD,
		20));
	lblCodigoFacultadModificarMAteria.setBounds(0, 323, 200, 45);
	panelModificarMateria.add(lblCodigoFacultadModificarMAteria);

	textFFacultadModificarMateria = new JTextField();
	textFFacultadModificarMateria.setEditable(false);
	textFFacultadModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	textFFacultadModificarMateria.setColumns(10);
	textFFacultadModificarMateria.setBounds(229, 323, 265, 45);
	panelModificarMateria.add(textFFacultadModificarMateria);

	btnLimpiarModificarMateria = new JButton(CLEAR);
	btnLimpiarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarModificarMateria.setBounds(220, 522, 190, 58);
	panelModificarMateria.add(btnLimpiarModificarMateria);

	AdminListener bLimpiarMM = new AdminListener();
	IController gestionLimpiarMM = new subjectManagementController();
	gestionLimpiarMM.setView(this);
	bLimpiarMM.associate(btnLimpiarModificarMateria, gestionLimpiarMM);

	btnBorrarModificarMateria = new JButton(DELETE);
	btnBorrarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarModificarMateria.setBounds(420, 522, 190, 58);
	panelModificarMateria.add(btnBorrarModificarMateria);

	AdminListener bBorrarMM = new AdminListener();
	IController gestionBorrarMM = new subjectManagementController();
	gestionBorrarMM.setView(this);
	bBorrarMM.associate(btnBorrarModificarMateria, gestionBorrarMM);

	btnBuscarModificarMateria = new JButton(SEARCH);
	btnBuscarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnBuscarModificarMateria.setBounds(512, 116, 130, 47);
	panelModificarMateria.add(btnBuscarModificarMateria);

	AdminListener bBuscarMM = new AdminListener();
	IController gestionBuscarMM = new subjectManagementController();
	gestionBuscarMM.setView(this);
	bBuscarMM.associate(btnBuscarModificarMateria, gestionBuscarMM);

	btnGuardarModificarMateria = new JButton(MODIFY);
	btnGuardarModificarMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarModificarMateria.setBounds(620, 522, 190, 58);
	panelModificarMateria.add(btnGuardarModificarMateria);

	AdminListener bGuardarMM = new AdminListener();
	IController gestionGuardarMM = new subjectManagementController();
	gestionGuardarMM.setView(this);
	bGuardarMM.associate(btnGuardarModificarMateria, gestionGuardarMM);

	// ||||||||||||||||PANEL ALTA MATERIA||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||//

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

	JLabel lblCartelPresentacionMMateria = new JLabel(
		"Inserte el Nombre de la Materia  a Guardar");
	lblCartelPresentacionMMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelPresentacionMMateria
		.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelPresentacionMMateria.setBounds(10, 29, 652, 58);
	panelAltaMateria.add(lblCartelPresentacionMMateria);

	lblListaDeFacultadMMateria = new JLabel("LISTA DE FACULTAD");
	lblListaDeFacultadMMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDeFacultadMMateria.setFont(new Font("Arial", Font.BOLD, 20));
	lblListaDeFacultadMMateria.setBounds(668, 0, 229, 58);
	panelAltaMateria.add(lblListaDeFacultadMMateria);

	JLabel label_39 = new JLabel("LISTA DE MATERIAS");
	label_39.setHorizontalAlignment(SwingConstants.CENTER);
	label_39.setFont(new Font("Arial", Font.BOLD, 20));
	label_39.setBounds(916, 0, 229, 58);
	panelAltaMateria.add(label_39);

	listaMateriaAltaMateria = new List();
	listaMateriaAltaMateria.setBounds(916, 58, 229, 464);
	panelAltaMateria.add(listaMateriaAltaMateria);

	listFacultadAltaMateria = new List();
	listFacultadAltaMateria.setBounds(668, 58, 229, 464);
	panelAltaMateria.add(listFacultadAltaMateria);

	AdminListListener listaFacultadM = new AdminListListener();
	IListController listaFacultadMController2 = new subjectManagementController();
	((IController) listaFacultadMController2).setView(this);
	listaFacultadM.associate(listFacultadAltaMateria,
		listaFacultadMController2);

	JLabel lblNombreMateria = new JLabel("NOMBRE MATERIA");
	lblNombreMateria.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreMateria.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreMateria.setBounds(46, 232, 229, 45);
	panelAltaMateria.add(lblNombreMateria);

	JLabel lblNombreFacutadMMateria = new JLabel("CODIGO FACULTAD");
	lblNombreFacutadMMateria.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreFacutadMMateria.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreFacutadMMateria.setBounds(46, 301, 229, 45);
	panelAltaMateria.add(lblNombreFacutadMMateria);

	txtFFacultadAltaMateria = new JTextField();
	txtFFacultadAltaMateria.setEditable(false);
	txtFFacultadAltaMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFFacultadAltaMateria.setColumns(10);
	txtFFacultadAltaMateria.setBounds(301, 301, 305, 45);
	panelAltaMateria.add(txtFFacultadAltaMateria);

	txtFNombreAltaMateria = new JTextField();
	txtFNombreAltaMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtFNombreAltaMateria.setColumns(10);
	txtFNombreAltaMateria.setBounds(301, 232, 305, 45);
	panelAltaMateria.add(txtFNombreAltaMateria);

	btnGuardarAltaMateria = new JButton(ADD);
	btnGuardarAltaMateria.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaMateria.setBounds(408, 441, 190, 58);
	panelAltaMateria.add(btnGuardarAltaMateria);
	menuAcciones.setLayout(gl_menuAcciones);

	AdminListener bGuardarAM = new AdminListener();
	IController gestionGuardarAM = new subjectManagementController();
	gestionGuardarAM.setView(this);
	bGuardarAM.associate(btnGuardarAltaMateria, gestionGuardarAM);

	// ||||||||||||||||PANEL MODIFICAR DEDICACION DOCENTE||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

	panelModificarDedicacionDocente = new JPanel();
	panelModificarDedicacionDocente.setLayout(null);
	panelModificarDedicacionDocente.setBorder(new SoftBevelBorder(
		BevelBorder.LOWERED,

		null, null, null, null));
	panelModificarDedicacionDocente
		.setBackground(SystemColor.activeCaption);
	menuDedicacionDocente
		.addTab(
			"MODIFICAR DEDICACION DOCENTE",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/dedicacion Docente.png")),
			panelModificarDedicacionDocente, null);

	JLabel lblCartelModificarDedicacionDoncente = new JLabel(
		"Seleccione los Datos del Docente para Modificar su Dedicacion");
	lblCartelModificarDedicacionDoncente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelModificarDedicacionDoncente.setFont(new Font("Arial",
		Font.PLAIN, 20));
	lblCartelModificarDedicacionDoncente.setBounds(10, 0, 560, 81);
	panelModificarDedicacionDocente
		.add(lblCartelModificarDedicacionDoncente);

	JLabel lblDniModificarDedicacionDoncente = new JLabel("D.N.I ");
	lblDniModificarDedicacionDoncente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniModificarDedicacionDoncente.setFont(new Font("Arial", Font.BOLD,
		20));
	lblDniModificarDedicacionDoncente.setBackground(Color.BLUE);
	lblDniModificarDedicacionDoncente.setBounds(0, 81, 229, 45);
	panelModificarDedicacionDocente.add(lblDniModificarDedicacionDoncente);

	txtFDniModificarDedicacionDocente = new JTextField();
	txtFDniModificarDedicacionDocente.setFont(new Font("Arial", Font.BOLD,
		20));
	txtFDniModificarDedicacionDocente.setEditable(false);
	txtFDniModificarDedicacionDocente.setColumns(10);
	txtFDniModificarDedicacionDocente.setBounds(229, 81, 305, 45);
	panelModificarDedicacionDocente.add(txtFDniModificarDedicacionDocente);

	JLabel lblFacultadModificarDedicacionDoncente = new JLabel("FACULTAD");
	lblFacultadModificarDedicacionDoncente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblFacultadModificarDedicacionDoncente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblFacultadModificarDedicacionDoncente.setBounds(0, 194, 229, 45);
	panelModificarDedicacionDocente
		.add(lblFacultadModificarDedicacionDoncente);

	txtFFacultadModificarDedicacionDocente = new JTextField();
	txtFFacultadModificarDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFFacultadModificarDedicacionDocente.setEditable(false);
	txtFFacultadModificarDedicacionDocente.setColumns(10);
	txtFFacultadModificarDedicacionDocente.setBounds(229, 194, 305, 45);
	panelModificarDedicacionDocente
		.add(txtFFacultadModificarDedicacionDocente);

	JLabel lblCargoModificarDedicacionDoncente = new JLabel("CARGO");
	lblCargoModificarDedicacionDoncente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCargoModificarDedicacionDoncente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblCargoModificarDedicacionDoncente.setBounds(0, 311, 229, 45);
	panelModificarDedicacionDocente
		.add(lblCargoModificarDedicacionDoncente);

	txtFCargoModificarDedicacionDocente = new JTextField();
	txtFCargoModificarDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFCargoModificarDedicacionDocente.setEditable(false);
	txtFCargoModificarDedicacionDocente.setColumns(10);
	txtFCargoModificarDedicacionDocente.setBounds(229, 311, 305, 45);
	panelModificarDedicacionDocente
		.add(txtFCargoModificarDedicacionDocente);

	JLabel lblDedicacionModificarDedicacionDoncente = new JLabel(
		"DEDICACION(horas)");
	lblDedicacionModificarDedicacionDoncente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDedicacionModificarDedicacionDoncente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblDedicacionModificarDedicacionDoncente.setBounds(0, 426, 229, 45);
	panelModificarDedicacionDocente
		.add(lblDedicacionModificarDedicacionDoncente);

	txtFDedicacionModificarDedicacionDocente = new JTextField();
	txtFDedicacionModificarDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFDedicacionModificarDedicacionDocente.setColumns(10);
	txtFDedicacionModificarDedicacionDocente.setBounds(229, 426, 305, 45);
	panelModificarDedicacionDocente
		.add(txtFDedicacionModificarDedicacionDocente);

	btnLimpiarModificacionDedicacionDocente = new JButton(CLEAR);
	btnLimpiarModificacionDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnLimpiarModificacionDedicacionDocente.setBounds(210, 526, 175, 51);
	panelModificarDedicacionDocente
		.add(btnLimpiarModificacionDedicacionDocente);

	AdminListener btnLimiarMD = new AdminListener();
	IController bcontrollerLimpiarMD = new DedicacionDocenteController();
	bcontrollerLimpiarMD.setView(this);
	btnLimiarMD.associate(btnLimpiarModificacionDedicacionDocente,
		bcontrollerLimpiarMD);

	btnGuardarModificacionDedicacionDocente = new JButton(MODIFY);
	btnGuardarModificacionDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnGuardarModificacionDedicacionDocente.setBounds(395, 526, 175, 51);
	panelModificarDedicacionDocente
		.add(btnGuardarModificacionDedicacionDocente);

	AdminListener btnModificarMD = new AdminListener();
	IController bcontrollerModificarMD = new DedicacionDocenteController();
	bcontrollerModificarMD.setView(this);
	btnModificarMD.associate(btnGuardarModificacionDedicacionDocente,
		bcontrollerModificarMD);

	listaModificarDedicacionDocente = new List();
	listaModificarDedicacionDocente.setBounds(591, 54, 545, 531);
	panelModificarDedicacionDocente.add(listaModificarDedicacionDocente);

	AdminListListener listaMDD = new AdminListListener();
	IListController listControllerMDD = new HsDedicacionDocenteListController();
	((IController) listControllerMDD).setView(this);
	listaMDD.associate(listaModificarDedicacionDocente, listControllerMDD);

	JLabel lblCarteListaModificarDedicacionDoncente = new JLabel(
		"Lista de Docente con su Dedicacion");
	lblCarteListaModificarDedicacionDoncente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCarteListaModificarDedicacionDoncente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblCarteListaModificarDedicacionDoncente.setBounds(591, 10, 545, 38);
	panelModificarDedicacionDocente
		.add(lblCarteListaModificarDedicacionDoncente);

	btnBorrarModificacionDedicacionDocente = new JButton(DELETE);
	btnBorrarModificacionDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnBorrarModificacionDedicacionDocente.setBounds(24, 526, 175, 51);
	panelModificarDedicacionDocente
		.add(btnBorrarModificacionDedicacionDocente);

	AdminListener btnBorrarMD = new AdminListener();
	IController bcontrollerBorrarMD = new DedicacionDocenteController();
	bcontrollerBorrarMD.setView(this);
	btnBorrarMD.associate(btnBorrarModificacionDedicacionDocente,
		bcontrollerBorrarMD);

	// ||||||||||||||||PANEL ALTA DEDICACION DOCENTE||||||||||||||||//
	// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

	panelAltaDedicacionDocente = new JPanel();
	panelAltaDedicacionDocente.setLayout(null);
	panelAltaDedicacionDocente.setBorder(new SoftBevelBorder(
		BevelBorder.LOWERED,

		null, null, null, null));
	panelAltaDedicacionDocente.setBackground(SystemColor.activeCaption);
	menuDedicacionDocente
		.addTab(
			"ALTA DEDICACION DOCENTE",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/dedicacion Docente.png")),
			panelAltaDedicacionDocente, null);

	JLabel lblCartelAltaDedicacionDocente = new JLabel(
		"Seleccione los Datos del Docente a dar de Alta su Dedicacion");
	lblCartelAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelAltaDedicacionDocente
		.setFont(new Font("Arial", Font.PLAIN, 20));
	lblCartelAltaDedicacionDocente.setBounds(10, 0, 560, 58);
	panelAltaDedicacionDocente.add(lblCartelAltaDedicacionDocente);

	JLabel lblCargolAltaDedicacionDocente = new JLabel("CARGO");
	lblCargolAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCargolAltaDedicacionDocente
		.setFont(new Font("Arial", Font.BOLD, 20));
	lblCargolAltaDedicacionDocente.setBounds(965, 0, 171, 58);
	panelAltaDedicacionDocente.add(lblCargolAltaDedicacionDocente);

	JLabel lblDniAltaDedicacionDocente = new JLabel("D.N.I ");
	lblDniAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblDniAltaDedicacionDocente.setBackground(Color.BLUE);
	lblDniAltaDedicacionDocente.setBounds(0, 81, 229, 45);
	panelAltaDedicacionDocente.add(lblDniAltaDedicacionDocente);

	txtFDniAltaDedicacionDocente = new JTextField();
	txtFDniAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD, 20));
	txtFDniAltaDedicacionDocente.setEditable(false);
	txtFDniAltaDedicacionDocente.setColumns(10);
	txtFDniAltaDedicacionDocente.setBounds(229, 81, 305, 45);
	panelAltaDedicacionDocente.add(txtFDniAltaDedicacionDocente);

	listaCargoAltaDedicacionDocente = new List();
	listaCargoAltaDedicacionDocente.setBounds(965, 58, 171, 298);
	panelAltaDedicacionDocente.add(listaCargoAltaDedicacionDocente);

	AdminListListener listaCAD = new AdminListListener();
	IListController listControllerCAD = new CargoListaDedicacionDocenteController();
	((IController) listControllerCAD).setView(this);
	listaCAD.associate(listaCargoAltaDedicacionDocente, listControllerCAD);

	JLabel lblFacultadAltaDedicacionDocente = new JLabel("FACULTAD");
	lblFacultadAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblFacultadAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD,
		20));
	lblFacultadAltaDedicacionDocente.setBounds(0, 194, 229, 45);
	panelAltaDedicacionDocente.add(lblFacultadAltaDedicacionDocente);

	txtFFacultadAltaDedicacionDocente = new JTextField();
	txtFFacultadAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD,
		20));
	txtFFacultadAltaDedicacionDocente.setEditable(false);
	txtFFacultadAltaDedicacionDocente.setColumns(10);
	txtFFacultadAltaDedicacionDocente.setBounds(229, 194, 305, 45);
	panelAltaDedicacionDocente.add(txtFFacultadAltaDedicacionDocente);

	JLabel lblCargoAltaDedicacionDocente = new JLabel("CARGO");
	lblCargoAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCargoAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD, 20));
	lblCargoAltaDedicacionDocente.setBounds(0, 311, 229, 45);
	panelAltaDedicacionDocente.add(lblCargoAltaDedicacionDocente);

	txtFCargoAltaDedicacionDocente = new JTextField();
	txtFCargoAltaDedicacionDocente
		.setFont(new Font("Arial", Font.BOLD, 20));
	txtFCargoAltaDedicacionDocente.setEditable(false);
	txtFCargoAltaDedicacionDocente.setColumns(10);
	txtFCargoAltaDedicacionDocente.setBounds(229, 311, 305, 45);
	panelAltaDedicacionDocente.add(txtFCargoAltaDedicacionDocente);

	JLabel lblDedicacionAltaDedicacionDocente = new JLabel("DEDICACION");
	lblDedicacionAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDedicacionAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD,
		20));
	lblDedicacionAltaDedicacionDocente.setBounds(0, 426, 229, 45);
	panelAltaDedicacionDocente.add(lblDedicacionAltaDedicacionDocente);

	txtFDedicacionAltaDedicacionDocente = new JTextField();
	txtFDedicacionAltaDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFDedicacionAltaDedicacionDocente.setColumns(10);
	txtFDedicacionAltaDedicacionDocente.setBounds(229, 426, 305, 45);
	panelAltaDedicacionDocente.add(txtFDedicacionAltaDedicacionDocente);

	btnLimpiarAltaDedicacionDocente = new JButton(CLEAR);
	btnLimpiarAltaDedicacionDocente
		.setFont(new Font("Arial", Font.BOLD, 20));
	btnLimpiarAltaDedicacionDocente.setBounds(89, 526, 175, 51);
	panelAltaDedicacionDocente.add(btnLimpiarAltaDedicacionDocente);

	AdminListener btnLimpiarAD = new AdminListener();
	IController bcontrollerLimpiarAD = new DedicacionDocenteController();
	bcontrollerLimpiarAD.setView(this);
	btnLimpiarAD.associate(btnLimpiarAltaDedicacionDocente,
		bcontrollerLimpiarAD);

	btnGuardarAltaDedicacionDocente = new JButton(ADD);
	btnGuardarAltaDedicacionDocente
		.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAltaDedicacionDocente.setBounds(341, 526, 175, 51);
	panelAltaDedicacionDocente.add(btnGuardarAltaDedicacionDocente);

	AdminListener btnGuardarAD = new AdminListener();
	IController bcontrollerGuardarAD = new DedicacionDocenteController();
	bcontrollerGuardarAD.setView(this);
	btnGuardarAD.associate(btnGuardarAltaDedicacionDocente,
		bcontrollerGuardarAD);

	listaFacultadAltaDedicacionDocente = new List();
	listaFacultadAltaDedicacionDocente.setBounds(779, 58, 171, 298);
	panelAltaDedicacionDocente.add(listaFacultadAltaDedicacionDocente);

	AdminListListener listaFAD = new AdminListListener();
	IListController listControllerFAD = new DedicacionDocenteController();
	((IController) listControllerFAD).setView(this);
	listaFAD.associate(listaFacultadAltaDedicacionDocente,
		listControllerFAD);

	listaDniAltaDedicacionDocente = new List();
	listaDniAltaDedicacionDocente.setBounds(591, 58, 171, 298);
	panelAltaDedicacionDocente.add(listaDniAltaDedicacionDocente);

	AdminListListener listaDAD = new AdminListListener();
	IListController listControllerDAD = new DedicacionDocenteController();
	((IController) listControllerDAD).setView(this);
	listaDAD.associate(listaDniAltaDedicacionDocente, listControllerDAD);

	listaListaDocentesDedicacionAltaDedicacionDocente = new List();
	listaListaDocentesDedicacionAltaDedicacionDocente.setBounds(591, 398,
		545, 197);
	panelAltaDedicacionDocente
		.add(listaListaDocentesDedicacionAltaDedicacionDocente);

	// AdminListListener listaDDAD = new AdminListListener();
	// IListController listControllerDDAD = new
	// DedicacionDocenteController();
	// ((IController) listControllerDDAD).setView(this);
	// listaDDAD.associate(listaListaDocentesDedicacionAltaDedicacionDocente,
	// listControllerDDAD);

	JLabel lblCartelFacultadAltaDedicacionDocente = new JLabel("FACULTAD");
	lblCartelFacultadAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelFacultadAltaDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblCartelFacultadAltaDedicacionDocente.setBounds(779, 0, 171, 58);
	panelAltaDedicacionDocente.add(lblCartelFacultadAltaDedicacionDocente);

	JLabel lblCartelDniAltaDedicacionDocente = new JLabel("DNI");
	lblCartelDniAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelDniAltaDedicacionDocente.setFont(new Font("Arial", Font.BOLD,
		20));
	lblCartelDniAltaDedicacionDocente.setBounds(591, 0, 171, 58);
	panelAltaDedicacionDocente.add(lblCartelDniAltaDedicacionDocente);

	JLabel lblCartelListaAltaDedicacionDocente = new JLabel(
		"Lista de Docente con su Dedicacion");
	lblCartelListaAltaDedicacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelListaAltaDedicacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblCartelListaAltaDedicacionDocente.setBounds(591, 362, 545, 38);
	panelAltaDedicacionDocente.add(lblCartelListaAltaDedicacionDocente);

	JLabel lblEnHorasAltaDedicacionDocente = new JLabel("(en horas)");
	lblEnHorasAltaDedicacionDocente.setBounds(89, 467, 81, 14);
	panelAltaDedicacionDocente.add(lblEnHorasAltaDedicacionDocente);

	// ||||||||||||||||PANEL ENCARGADO ASIGANACION DOCENTE||||||||||||||||//
	// |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

	panelEncargadoAsignacionDocente = new JPanel();
	panelEncargadoAsignacionDocente.setLayout(null);
	panelEncargadoAsignacionDocente.setBorder(new SoftBevelBorder(
		BevelBorder.LOWERED,

		null, null, null, null));
	panelEncargadoAsignacionDocente
		.setBackground(SystemColor.activeCaption);
	menuAsignacionDocente
		.addTab(
			"ENCARGADO  MATERIA",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/asignacion docente.png")),
			panelEncargadoAsignacionDocente, null);

	JLabel lblCartelPrincipalEncargadoAsigDocente = new JLabel(
		"Seleccione la Materia y DocenteEncargado");
	lblCartelPrincipalEncargadoAsigDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelPrincipalEncargadoAsigDocente.setFont(new Font("Arial",
		Font.PLAIN, 19));
	lblCartelPrincipalEncargadoAsigDocente.setBounds(10, 0, 575, 82);
	panelEncargadoAsignacionDocente
		.add(lblCartelPrincipalEncargadoAsigDocente);

	JLabel lblMateriaEncargadoAsignacionMateria = new JLabel("MATERIA");
	lblMateriaEncargadoAsignacionMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblMateriaEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblMateriaEncargadoAsignacionMateria.setBackground(Color.BLUE);
	lblMateriaEncargadoAsignacionMateria.setBounds(0, 81, 229, 45);
	panelEncargadoAsignacionDocente
		.add(lblMateriaEncargadoAsignacionMateria);

	txtFMateriaEncargadoAsignacionMateria = new JTextField();
	txtFMateriaEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFMateriaEncargadoAsignacionMateria.setEditable(false);
	txtFMateriaEncargadoAsignacionMateria.setColumns(10);
	txtFMateriaEncargadoAsignacionMateria.setBounds(229, 81, 305, 45);
	panelEncargadoAsignacionDocente
		.add(txtFMateriaEncargadoAsignacionMateria);

	JLabel lblDocenteEncargadoAsignacionMateria = new JLabel("DOCENTE");
	lblDocenteEncargadoAsignacionMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDocenteEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblDocenteEncargadoAsignacionMateria.setBounds(0, 194, 229, 45);
	panelEncargadoAsignacionDocente
		.add(lblDocenteEncargadoAsignacionMateria);

	txtFDocenteEncargadoAsignacionMateria = new JTextField();
	txtFDocenteEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFDocenteEncargadoAsignacionMateria.setEditable(false);
	txtFDocenteEncargadoAsignacionMateria.setColumns(10);
	txtFDocenteEncargadoAsignacionMateria.setBounds(229, 194, 305, 45);
	panelEncargadoAsignacionDocente
		.add(txtFDocenteEncargadoAsignacionMateria);

	btnLimpiarEncargadoAsignacionMateria = new JButton(CLEAR);
	btnLimpiarEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnLimpiarEncargadoAsignacionMateria.setBounds(229, 450, 175, 58);
	panelEncargadoAsignacionDocente
		.add(btnLimpiarEncargadoAsignacionMateria);
	// asocio
	AdminListener bLimpiarAE = new AdminListener();
	IController gestionLimpiarAE = new AsignacionDocenteController();
	gestionLimpiarAE.setView(this);
	bLimpiarAE.associate(btnLimpiarEncargadoAsignacionMateria,
		gestionLimpiarAE);

	btnGuardarEncargadoAsignacionMateria = new JButton(ADD);
	btnGuardarEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnGuardarEncargadoAsignacionMateria.setBounds(410, 450, 175, 58);
	panelEncargadoAsignacionDocente
		.add(btnGuardarEncargadoAsignacionMateria);
	// asocio AE = Asignacion Encargado
	AdminListener bGuardarAE = new AdminListener();
	IController gestionGuardarAE = new AsignacionDocenteController();
	gestionGuardarAE.setView(this);
	bGuardarAE.associate(btnGuardarEncargadoAsignacionMateria,
		gestionGuardarAE);

	listaAsignacionMateria = new List();
	listaAsignacionMateria.setBounds(591, 81, 267, 514);
	panelEncargadoAsignacionDocente.add(listaAsignacionMateria);

	AdminListListener listaAE = new AdminListListener();
	IListController listControllerAE = new AsignacionDocenteController();
	((IController) listControllerAE).setView(this);
	listaAE.associate(listaAsignacionMateria, listControllerAE);

	btnBorrarEncargadoAsignacionMateria = new JButton(DELETE);
	btnBorrarEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnBorrarEncargadoAsignacionMateria.setBounds(38, 450, 175, 58);
	panelEncargadoAsignacionDocente
		.add(btnBorrarEncargadoAsignacionMateria);
	// asocio AE = Asignacion Encargado
	AdminListener bBorrarAE = new AdminListener();
	IController gestionBorrarAE = new AsignacionDocenteController();
	gestionBorrarAE.setView(this);
	bBorrarAE.associate(btnBorrarEncargadoAsignacionMateria,
		gestionBorrarAE);

	txtFDniEncargadoAsignacionMateria = new JTextField();
	txtFDniEncargadoAsignacionMateria.setFont(new Font("Arial", Font.BOLD,
		20));
	txtFDniEncargadoAsignacionMateria.setColumns(10);
	txtFDniEncargadoAsignacionMateria.setBounds(229, 308, 305, 45);
	panelEncargadoAsignacionDocente.add(txtFDniEncargadoAsignacionMateria);

	JLabel lblDniEncargadoAsignacionMateria = new JLabel("D.N.I");
	lblDniEncargadoAsignacionMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniEncargadoAsignacionMateria.setFont(new Font("Arial", Font.BOLD,
		20));
	lblDniEncargadoAsignacionMateria.setBounds(0, 308, 229, 45);
	panelEncargadoAsignacionDocente.add(lblDniEncargadoAsignacionMateria);

	listaAsignacionDocente2 = new List();
	listaAsignacionDocente2.setBounds(869, 81, 267, 514);
	panelEncargadoAsignacionDocente.add(listaAsignacionDocente2);

	AdminListListener listaAD2 = new AdminListListener();
	IListController listaADController2 = new AsignacionDocenteController();
	((IController) listaADController2).setView(this);
	listaAD2.associate(listaAsignacionDocente2, listaADController2);

	JLabel lblListaDocenteEncargadoAsignacionMateria = new JLabel("DOCENTE");
	lblListaDocenteEncargadoAsignacionMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDocenteEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblListaDocenteEncargadoAsignacionMateria.setBounds(882, 25, 229, 45);
	panelEncargadoAsignacionDocente
		.add(lblListaDocenteEncargadoAsignacionMateria);

	JLabel lblListaMateriaEncargadoAsignacionMateria = new JLabel("MATERIA");
	lblListaMateriaEncargadoAsignacionMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaMateriaEncargadoAsignacionMateria.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblListaMateriaEncargadoAsignacionMateria.setBackground(Color.BLUE);
	lblListaMateriaEncargadoAsignacionMateria.setBounds(600, 25, 229, 45);
	panelEncargadoAsignacionDocente
		.add(lblListaMateriaEncargadoAsignacionMateria);

	JLabel lblCartelACargoEncargadoAsignacionMateria = new JLabel(
		"(a cargo)");
	lblCartelACargoEncargadoAsignacionMateria.setBounds(90, 229, 61, 14);
	panelEncargadoAsignacionDocente
		.add(lblCartelACargoEncargadoAsignacionMateria);

	// ||||||||||||||||PANEL DESIGNACION ASIGNACION
	// DOCENTE||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

	panelDesignacionAsignacionDocente = new JPanel();
	panelDesignacionAsignacionDocente.setLayout(null);
	panelDesignacionAsignacionDocente.setBorder(new SoftBevelBorder(
		BevelBorder.LOWERED,

		null, null, null, null));
	panelDesignacionAsignacionDocente
		.setBackground(SystemColor.activeCaption);
	menuAsignacionDocente
		.addTab(
			"DESIGNACION MATERIA",
			new ImageIcon(
				administrador.class
					.getResource("/educar/gui/AdminViews/imagenIcon/asignacion docente.png")),
			panelDesignacionAsignacionDocente, null);

	JLabel lblCartelPrincDesignacionAsignacionDocente = new JLabel(
		"Seleccione la Materia y Docente para asignarlo a una Materia  ");
	lblCartelPrincDesignacionAsignacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelPrincDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.PLAIN, 19));
	lblCartelPrincDesignacionAsignacionDocente.setBounds(10, 0, 575, 82);
	panelDesignacionAsignacionDocente
		.add(lblCartelPrincDesignacionAsignacionDocente);

	JLabel lblMateriaDesignacionAsignacionDocente = new JLabel("MATERIA");
	lblMateriaDesignacionAsignacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblMateriaDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblMateriaDesignacionAsignacionDocente.setBackground(Color.BLUE);
	lblMateriaDesignacionAsignacionDocente.setBounds(0, 81, 229, 45);
	panelDesignacionAsignacionDocente
		.add(lblMateriaDesignacionAsignacionDocente);

	txtFMateriaDesignacionAsignacionDocente = new JTextField();
	txtFMateriaDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFMateriaDesignacionAsignacionDocente.setEditable(false);
	txtFMateriaDesignacionAsignacionDocente.setColumns(10);
	txtFMateriaDesignacionAsignacionDocente.setBounds(229, 81, 305, 45);
	panelDesignacionAsignacionDocente
		.add(txtFMateriaDesignacionAsignacionDocente);

	JLabel lblDocenteDesignacionAsignacionDocente = new JLabel("DOCENTE");
	lblDocenteDesignacionAsignacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDocenteDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblDocenteDesignacionAsignacionDocente.setBounds(0, 194, 229, 45);
	panelDesignacionAsignacionDocente
		.add(lblDocenteDesignacionAsignacionDocente);

	txtFDocenteDesignacionAsignacionDocente = new JTextField();
	txtFDocenteDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFDocenteDesignacionAsignacionDocente.setEditable(false);
	txtFDocenteDesignacionAsignacionDocente.setColumns(10);
	txtFDocenteDesignacionAsignacionDocente.setBounds(229, 194, 305, 45);
	panelDesignacionAsignacionDocente
		.add(txtFDocenteDesignacionAsignacionDocente);

	btnLimpiarDesignacionAsignacionDocente = new JButton(CLEAR);
	btnLimpiarDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnLimpiarDesignacionAsignacionDocente.setBounds(229, 450, 175, 58);
	panelDesignacionAsignacionDocente
		.add(btnLimpiarDesignacionAsignacionDocente);

	AdminListener bLimpiarDA = new AdminListener();
	IController gestionLimpiarDA = new AsignacionDocenteController();
	gestionLimpiarDA.setView(this);
	bLimpiarDA.associate(btnLimpiarDesignacionAsignacionDocente,
		gestionLimpiarDA);

	btnGuardarDesignacionAsignacionDocente = new JButton(ASIGNAR);
	btnGuardarDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnGuardarDesignacionAsignacionDocente.setBounds(410, 450, 175, 58);
	panelDesignacionAsignacionDocente
		.add(btnGuardarDesignacionAsignacionDocente);

	AdminListener bGuardarDA = new AdminListener();
	IController gestionGuardarDA = new AsignacionDocenteController();
	gestionGuardarDA.setView(this);
	bGuardarDA.associate(btnGuardarDesignacionAsignacionDocente,
		gestionGuardarDA);

	listaAsignacionMateria2 = new List();
	listaAsignacionMateria2.setBounds(591, 81, 267, 514);
	panelDesignacionAsignacionDocente.add(listaAsignacionMateria2);

	AdminListListener listaAM1 = new AdminListListener();
	IListController listControllerAM1 = new AsignacionDocenteController();
	((IController) listControllerAM1).setView(this);
	listaAM1.associate(listaAsignacionMateria2, listControllerAM1);

	btnBorrarDesignacionAsignacionDocente = new JButton(REMOVE);
	btnBorrarDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	btnBorrarDesignacionAsignacionDocente.setBounds(38, 450, 175, 58);
	panelDesignacionAsignacionDocente
		.add(btnBorrarDesignacionAsignacionDocente);

	AdminListener bBorrarDA = new AdminListener();
	IController gestionBorrarDA = new AsignacionDocenteController();
	gestionBorrarDA.setView(this);
	bBorrarDA.associate(btnBorrarDesignacionAsignacionDocente,
		gestionBorrarDA);

	txtFDniDesignacionAsignacionDocente = new JTextField();
	txtFDniDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	txtFDniDesignacionAsignacionDocente.setColumns(10);
	txtFDniDesignacionAsignacionDocente.setBounds(229, 308, 305, 45);
	panelDesignacionAsignacionDocente
		.add(txtFDniDesignacionAsignacionDocente);

	JLabel lblDniDesignacionAsignacionDocente = new JLabel("D.N.I");
	lblDniDesignacionAsignacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblDniDesignacionAsignacionDocente.setFont(new Font("Arial", Font.BOLD,
		20));
	lblDniDesignacionAsignacionDocente.setBounds(0, 308, 229, 45);
	panelDesignacionAsignacionDocente
		.add(lblDniDesignacionAsignacionDocente);

	listaAsignacionDocente = new List();
	listaAsignacionDocente.setBounds(869, 81, 267, 514);
	panelDesignacionAsignacionDocente.add(listaAsignacionDocente);

	AdminListListener listaAD1 = new AdminListListener();
	IListController listaADController1 = new AsignacionDocenteController();
	((IController) listaADController1).setView(this);
	listaAD1.associate(listaAsignacionDocente, listaADController1);

	JLabel lblListaDocenteDesignacionAsignacionDocente = new JLabel(
		"DOCENTE");
	lblListaDocenteDesignacionAsignacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDocenteDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblListaDocenteDesignacionAsignacionDocente.setBounds(882, 25, 229, 45);
	panelDesignacionAsignacionDocente
		.add(lblListaDocenteDesignacionAsignacionDocente);

	JLabel lblListaMateriaDesignacionAsignacionDocente = new JLabel(
		"MATERIA");
	lblListaMateriaDesignacionAsignacionDocente
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaMateriaDesignacionAsignacionDocente.setFont(new Font("Arial",
		Font.BOLD, 20));
	lblListaMateriaDesignacionAsignacionDocente.setBackground(Color.BLUE);
	lblListaMateriaDesignacionAsignacionDocente.setBounds(600, 25, 229, 45);
	panelDesignacionAsignacionDocente
		.add(lblListaMateriaDesignacionAsignacionDocente);

	JLabel lblCartelAAsignarDesignacionAsignacionDocente = new JLabel(
		"(a designar)");
	lblCartelAAsignarDesignacionAsignacionDocente
		.setBounds(90, 229, 75, 14);
	panelDesignacionAsignacionDocente
		.add(lblCartelAAsignarDesignacionAsignacionDocente);

	// ||||||||||||||||PANEL GENERAL|||||||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||//

	menuAccionesPanel.setLayout(null);
	menuAccionesPanel.add(menuCargo);
	menuAccionesPanel.add(menuDedicacionDocente);
	menuAccionesPanel.add(menuAsignacionDocente);
	menuAccionesPanel.add(menuDocente);
	menuAccionesPanel.add(bienvenido);

	panel = new JPanel();
	panel.setLayout(null);
	panel.setForeground(Color.WHITE);
	panel.setBackground(Color.WHITE);
	bienvenido.addTab("", null, panel, null);

	label = new JLabel("");
	label
		.setIcon(new ImageIcon(
			administrador.class
				.getResource("/educar/gui/AdminViews/imagenIcon/educar2012.jpg")));
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Arial", Font.PLAIN, 20));
	label.setBackground(Color.WHITE);
	label.setBounds(168, 0, 811, 638);
	panel.add(label);
	menuAccionesPanel.add(menuFacultad);
	menuAccionesPanel.add(menuAlumno);
	menuAccionesPanel.add(menuMateria);

	JPanel menuAdmin = new JPanel();
	menuAdmin.setBackground(new Color(119, 136, 153));
	menuAdminScroll.setViewportView(menuAdmin);

	// ||||||||||||||||CONTROL DE BOTONES DE BARRA DE
	// ADMINISTRADOR||||||||||||||||//
	// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

	JButton btnAlumnos = new JButton(ALUMNOSPANEL);
	btnAlumnos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(
		51, 51, 102), null, null, null));
	btnAlumnos.setBackground(UIManager.getColor("Button.shadow"));
	btnAlumnos.setForeground(UIManager.getColor("Button.foreground"));
	btnAlumnos.setFont(new Font("Arial", Font.BOLD, 20));
	btnAlumnos
		.setSelectedIcon(new ImageIcon(
			administrador.class
				.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
	btnAlumnos.setIcon(null);

	AdminListener menuA = new AdminListener();
	IController adminMenuAlumno = new AdminController();
	adminMenuAlumno.setView(this);
	menuA.associate(btnAlumnos, adminMenuAlumno);

	JButton btnDocentes = new JButton(DOCENTESPANEL);
	btnDocentes.setBackground(UIManager.getColor("Button.shadow"));
	btnDocentes.setFont(new Font("Arial", Font.BOLD, 20));

	AdminListener menuD = new AdminListener();
	IController adminMenuDocente = new AdminController();
	adminMenuDocente.setView(this);
	menuD.associate(btnDocentes, adminMenuDocente);

	JButton btnMateria = new JButton(MATERIAPANEL);
	btnMateria.setBackground(UIManager.getColor("Button.shadow"));
	btnMateria.setFont(new Font("Arial", Font.BOLD, 20));

	AdminListener menuM = new AdminListener();
	IController adminMenuMateria = new AdminController();
	adminMenuMateria.setView(this);
	menuM.associate(btnMateria, adminMenuMateria);

	JButton btnFacultad = new JButton(FACULTADPANEL);
	btnFacultad.setBackground(UIManager.getColor("Button.shadow"));
	btnFacultad.setFont(new Font("Arial", Font.BOLD, 20));

	AdminListener menuF = new AdminListener();
	IController adminMenuFacultad = new AdminController();
	adminMenuFacultad.setView(this);
	menuF.associate(btnFacultad, adminMenuFacultad);

	JButton btnCargos = new JButton(CARGOSPANEL);
	btnCargos.setFont(new Font("Arial", Font.BOLD, 20));
	btnCargos.setBackground(UIManager.getColor("Button.shadow"));

	AdminListener menuC = new AdminListener();
	IController adminMenuCargo = new AdminController();
	adminMenuCargo.setView(this);
	menuC.associate(btnCargos, adminMenuCargo);

	JButton btnDedicacionDocente = new JButton(DEDICACIONDOCENTEPANEL);
	btnDedicacionDocente.setFont(new Font("Arial", Font.BOLD, 13));
	btnDedicacionDocente.setBackground(UIManager.getColor("Button.shadow"));

	AdminListener menuDC = new AdminListener();
	IController adminMenuDC = new AdminController();
	adminMenuDC.setView(this);
	menuDC.associate(btnDedicacionDocente, adminMenuDC);

	JButton btnAsinacionDocente = new JButton(ASIGNACIONDOCENTEPANEL);
	btnAsinacionDocente.setFont(new Font("Arial", Font.BOLD, 13));
	btnAsinacionDocente.setBackground(UIManager.getColor("Button.shadow"));

	AdminListener menuAC = new AdminListener();
	IController adminMenuAC = new AdminController();
	adminMenuAC.setView(this);
	menuAC.associate(btnAsinacionDocente, adminMenuAC);

	menuAdmin.setLayout(new GridLayout(0, 1, 0, 0));
	menuAdmin.add(btnAlumnos);
	menuAdmin.add(btnDocentes);
	menuAdmin.add(btnMateria);
	menuAdmin.add(btnFacultad);
	menuAdmin.add(btnCargos);
	menuAdmin.add(btnAsinacionDocente);
	menuAdmin.add(btnDedicacionDocente);

	administrador.setLayout(gl_administrador);
    }

    // ||||||||||||||||GET & SET ALUMNOS||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE CAMPOS||||||||||||||||//

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

    // ||||||||||||||||GET & SET DOCENTES||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE CAMPOS||||||||||||||||//

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

    // ||||||||||||||||GET & SET FACULTAD||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE CAMPOS||||||||||||||||//

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

    public boolean fieldsIsOkAlta_F() {
	return !(this.getNombreAltaFacultad().compareTo("") == 0);
    }

    public void deleteViewFieldsMod_F() {
	this.setCodigoModificarFacultad("");
	this.setNombreModificarFacultad("");
    }

    public void deleteViewFieldsAlta_F() {
	this.setNombreAltaFacultad("");
	System.out.println("limpiar");
    }

    /*
     * public void deleteViewFieldsAlta_F() { this.setNombreAltaFacultad(""); }
     */

    // ||||||||||||||||GET & SET MATERIA||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE CAMPOS||||||||||||||||//

    // devuelve lo que tienen los textFields
    public String getModifyNameTF_M() {
	return txtFNombreModificarMateria.getText();
    }

    public String getCodigoFacultadModificarMateria() {
	return textFFacultadModificarMateria.getText();
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

    public void setFacultadAltaMateria(String s) {
	txtFFacultadAltaMateria.setText(s);
    }

    public void setFacultadModificarMateria(String s) {
	textFFacultadModificarMateria.setText(s);
    }

    // setea los textFields de gestionar materia en blanco
    public void setEmptyFields() {
	this.setModifyNameTF_M("");
	this.setModifyCodeTF_M("");
	this.setAddNameTF_("");
	this.setFacultadModificarMateria("");
	this.setFacultadAltaMateria("");
    }

    public String getCodigoFacultadAltaMateria() {
	return txtFFacultadAltaMateria.getText();
    }

    public boolean camposVaciosAltaMateria() {
	return (getNombreAltaCargo().compareTo("") == 0 && getCodigoFacultadAltaMateria()
		.compareTo("") == 0);
    }

    // ||||||||||||||||GET & SET CARGO||||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE CAMPOS||||||||||||||||//

    public String getCodigoModificarCargo() {
	return txtFCodigoModificarCargo.getText();
    }

    public void setCodigoModificarCargo(String s) {
	txtFCodigoModificarCargo.setText(s);
    }

    public String getNombreModificarCargo() {
	return txtFNombreModificarCargo.getText();
    }

    public void setNombreModificarCargo(String s) {
	txtFNombreModificarCargo.setText(s);
    }

    public String getNombreAltaCargo() {
	return txtFNombreAltaCargo.getText();
    }

    public void setNombreAltaCargo(String s) {
	txtFNombreAltaCargo.setText(s);
    }

    public boolean fieldsIsOkAltaCargo() {
	return !(this.getNombreAltaCargo().compareTo("") == 0);
    }

    public void clearNombreAltaCargo() {
	this.setNombreAltaCargo("");
    }

    public void clearModificarCargo() {
	this.setCodigoModificarCargo("");
	this.setNombreModificarCargo("");
    }

    // ||||||||||||||||GET & SET ASIGNACION
    // DOCENTE||||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE
    // CAMPOS|||||||||||||||||||||||||||||//

    public void setMateriaAsignacionDocenteDesignacion(String s) {
	this.txtFMateriaDesignacionAsignacionDocente.setText(s);
    }

    public void setDocenteAsignacionDocenteDesignacion(String s) {
	this.txtFDocenteDesignacionAsignacionDocente.setText(s);
    }

    public void setDniAsignacionDocenteDesignacion(String s) {
	this.txtFDniDesignacionAsignacionDocente.setText(s);
    }

    public void setMateriaAsignacionDocenteEncargado(String s) {
	this.txtFMateriaEncargadoAsignacionMateria.setText(s);
    }

    public void setDocenteAsignacionDocenteEncargado(String s) {
	this.txtFDocenteEncargadoAsignacionMateria.setText(s);
    }

    public void setDniAsignacionDocenteEncargado(String s) {
	this.txtFDniEncargadoAsignacionMateria.setText(s);
    }

    public String getDniAsignacionDocenteEncargado() {
	return txtFDniEncargadoAsignacionMateria.getText();
    }

    public String getMateriaAsignacionDocenteEncargado() {
	return txtFMateriaEncargadoAsignacionMateria.getText();
    }

    public String getDniAsignacionDocenteDesignacion() {
	return txtFDniDesignacionAsignacionDocente.getText();
    }

    public String getMateriaAsignacionDocenteDesignacion() {
	return txtFMateriaDesignacionAsignacionDocente.getText();
    }

    public boolean camposVaciosEncargadoMateria() {
	return FuncionesAuxiliares.camposVaciosAsignacionDocente(
		getDniAsignacionDocenteEncargado(),
		getMateriaAsignacionDocenteEncargado());
    }

    public boolean camposVaciosDesignacionMateria() {
	return FuncionesAuxiliares.camposVaciosAsignacionDocente(
		getDniAsignacionDocenteDesignacion(),
		getMateriaAsignacionDocenteDesignacion());
    }

    public void setVacioAsignacionDocente() {
	this.setMateriaAsignacionDocenteEncargado("");
	this.setDocenteAsignacionDocenteEncargado("");
	this.setDniAsignacionDocenteEncargado("");
	this.setMateriaAsignacionDocenteDesignacion("");
	this.setDocenteAsignacionDocenteDesignacion("");
	this.setDniAsignacionDocenteEncargado("");
	this.setDniAsignacionDocenteDesignacion("");
    }

    // ||||||||||||||||GET & SET DEDICACION
    // DOCENTE||||||||||||||||||||||||||||//
    // |||||||||||||||BORRADO Y CHECKEADO DE
    // CAMPOS|||||||||||||||||||||||||||||//

    public void setDniModificarDedicacionDocente(String s) {
	txtFDniModificarDedicacionDocente.setText(s);
    }

    public void setFacultadModificarDedicacionDocente(String s) {
	txtFFacultadModificarDedicacionDocente.setText(s);
    }

    public void setCargoModificarDedicacionDocente(String s) {
	txtFCargoModificarDedicacionDocente.setText(s);
    }

    public void setDedicacionModificarDedicacionDocente(String s) {
	txtFDedicacionModificarDedicacionDocente.setText(s);
    }

    public void setDniAltaDedicacionDocente(String s) {
	txtFDniAltaDedicacionDocente.setText(s);
    }

    public void setFacultadAltaDedicacionDocente(String s) {
	txtFFacultadAltaDedicacionDocente.setText(s);
    }

    public void setCargoAltaDedicacionDocente(String s) {
	txtFCargoAltaDedicacionDocente.setText(s);
    }

    public void setDedicacionAltaDedicacionDocente(String s) {
	txtFDedicacionAltaDedicacionDocente.setText(s);
    }

    public String getDniModificarDedicacionDocente() {
	return txtFDniModificarDedicacionDocente.getText();
    }

    public String getFacultadModificarDedicacionDocente() {
	return txtFFacultadModificarDedicacionDocente.getText();
    }

    public String getCargoModificarDedicacionDocente() {
	return txtFCargoModificarDedicacionDocente.getText();
    }

    public String getDedicacionModificarDedicacionDocente() {
	return txtFDedicacionModificarDedicacionDocente.getText();
    }

    public String getDniAltaDedicacionDocente() {
	return txtFDniAltaDedicacionDocente.getText();
    }

    public String getFacultadAltaDedicacionDocente() {
	return txtFFacultadAltaDedicacionDocente.getText();
    }

    public String getCargoAltaDedicacionDocente() {
	return txtFCargoAltaDedicacionDocente.getText();
    }

    public String getDedicacionAltaDedicacionDocente() {
	return txtFDedicacionAltaDedicacionDocente.getText();
    }

    public void setCamposVacioDD() {
	this.setDedicacionAltaDedicacionDocente("");
	this.setCargoAltaDedicacionDocente("");
	this.setFacultadAltaDedicacionDocente("");
	this.setDniAltaDedicacionDocente("");
	this.setDedicacionModificarDedicacionDocente("");
	this.setCargoModificarDedicacionDocente("");
	this.setFacultadModificarDedicacionDocente("");
	this.setDniModificarDedicacionDocente("");
    }

    public boolean algunCampoVacioAlta() {
	return (getDniAltaDedicacionDocente().compareTo("") == 0
		|| getFacultadAltaDedicacionDocente().compareTo("") == 0
		|| getCargoAltaDedicacionDocente().compareTo("") == 0 || getDedicacionAltaDedicacionDocente()
		.compareTo("") == 0);
    }

    public boolean algunCampoVacioModificacion() {
	return (getDniModificarDedicacionDocente().compareTo("") == 0
		|| getFacultadModificarDedicacionDocente().compareTo("") == 0
		|| getDedicacionModificarDedicacionDocente().compareTo("") == 0 || getCargoModificarDedicacionDocente()
		.compareTo("") == 0);
    }

    // ||||||||||||||||METODOS PARA TODAS LAS
    // LISTAS||||||||||||||||||||||||||||//
    // |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||//

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
     * tambien estan las lista de las view asignacion
     * 
     * @param listaDocente
     */
    public void setListDocente_ABM(LinkedList<String> listaDocente) {
	listaAsignacionDocente.removeAll();
	listaAsignacionDocente2.removeAll();
	listaModificarDocente.removeAll();
	listaAltaDocente.removeAll();
	listaDniAltaDedicacionDocente.removeAll();
	for (int i = 0; i < listaDocente.size(); i++) {
	    listaAsignacionDocente2.add(listaDocente.get(i), i);
	    listaAsignacionDocente.add(listaDocente.get(i), i);
	    listaModificarDocente.add(listaDocente.get(i), i);
	    listaAltaDocente.add(listaDocente.get(i), i);
	    listaDniAltaDedicacionDocente.add(listaDocente.get(i), i);
	}
    }

    /**
     * @param listaFacultad
     */
    public void setListFacultad_ABM(LinkedList<String> listaFacultad) {
	listaAltaFacultad.removeAll();
	listaMoificarFacultad.removeAll();
	listFacultadModificarMateria.removeAll();
	listFacultadAltaMateria.removeAll();
	listaFacultadAltaDedicacionDocente.removeAll();
	for (int i = 0; i < listaFacultad.size(); i++) {
	    listaAltaFacultad.add(listaFacultad.get(i), i);
	    listaMoificarFacultad.add(listaFacultad.get(i), i);
	    listFacultadModificarMateria.add(listaFacultad.get(i), i);
	    listFacultadAltaMateria.add(listaFacultad.get(i), i);
	    listaFacultadAltaDedicacionDocente.add(listaFacultad.get(i), i);
	}
    }

    /**
     * @param listaCargos
     */
    public void setListModificarCargos(LinkedList<String> listaCargos) {
	listaModificarCargo.removeAll();
	listaAltaCargo.removeAll();
	listaCargoAltaDedicacionDocente.removeAll();
	for (int i = 0; i < listaCargos.size(); i++) {
	    listaModificarCargo.add(listaCargos.get(i), i);
	    listaAltaCargo.add(listaCargos.get(i), i);
	    listaCargoAltaDedicacionDocente.add(listaCargos.get(i), i);
	}
    }

    /**
     * tambien estan las lista de las view asignacion
     * 
     * @param listaMateria
     */
    public void setListMateria_ABM(LinkedList<String> listaMateria) {
	listaAsignacionMateria.removeAll();
	listaAsignacionMateria2.removeAll();
	listaMateriaAltaMateria.removeAll();
	listaMateriaModificarMateria.removeAll();
	for (int i = 0; i < listaMateria.size(); i++) {
	    listaAsignacionMateria.add(listaMateria.get(i), i);
	    listaAsignacionMateria2.add(listaMateria.get(i), i);
	    listaMateriaModificarMateria.add(listaMateria.get(i), i);
	    listaMateriaAltaMateria.add(listaMateria.get(i), i);
	}
    }

    /**
     * @param lista
     */
    public void setListDedicacionDocenteAlta(LinkedList<String> lista) {
	listaModificarDedicacionDocente.removeAll();
	listaListaDocentesDedicacionAltaDedicacionDocente.removeAll();
	for (int i = 0; i < lista.size(); i++) {
	    listaListaDocentesDedicacionAltaDedicacionDocente.add(lista.get(i),
		    i);
	    listaModificarDedicacionDocente.add(lista.get(i), i);
	}
    }

    // ||||||||||||||||||||||||||||||||||||||||||||//
    // ||||||||||||||||||||||||||||||||||||||||||||//

    @Override
    public void present(String model) {
	JOptionPane.showMessageDialog(null, model);
    }

    public void close() {
	this.dispose();
    }

    public void menuAlumnos() {
	menuAlumno.setVisible(true);
	menuDocente.setVisible(false);
	menuFacultad.setVisible(false);
	menuMateria.setVisible(false);
	menuCargo.setVisible(false);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(false);
	menuDedicacionDocente.setVisible(false);

    }

    public void menuDocentes() {
	menuAlumno.setVisible(false);
	menuDocente.setVisible(true);
	menuFacultad.setVisible(false);
	menuMateria.setVisible(false);
	menuCargo.setVisible(false);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(false);
	menuDedicacionDocente.setVisible(false);

    }

    public void menuMateria() {
	menuAlumno.setVisible(false);
	menuDocente.setVisible(false);
	menuFacultad.setVisible(false);
	menuMateria.setVisible(true);
	menuCargo.setVisible(false);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(false);
	menuDedicacionDocente.setVisible(false);

    }

    public void menuFacultad() {
	menuAlumno.setVisible(false);
	menuDocente.setVisible(false);
	menuFacultad.setVisible(true);
	menuMateria.setVisible(false);
	menuCargo.setVisible(false);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(false);
	menuDedicacionDocente.setVisible(false);

    }

    public void menuCargos() {
	menuAlumno.setVisible(false);
	menuDocente.setVisible(false);
	menuFacultad.setVisible(false);
	menuMateria.setVisible(false);
	menuCargo.setVisible(true);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(false);
	menuDedicacionDocente.setVisible(false);

    }

    public void menuDedicacionDocente() {
	menuAlumno.setVisible(false);
	menuDocente.setVisible(false);
	menuFacultad.setVisible(false);
	menuMateria.setVisible(false);
	menuCargo.setVisible(false);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(false);
	menuDedicacionDocente.setVisible(true);
    }

    public void menuAsignacionDocente() {
	menuAlumno.setVisible(false);
	menuDocente.setVisible(false);
	menuFacultad.setVisible(false);
	menuMateria.setVisible(false);
	menuCargo.setVisible(false);
	bienvenido.setVisible(false);
	menuAsignacionDocente.setVisible(true);
	menuDedicacionDocente.setVisible(false);

    }

}
