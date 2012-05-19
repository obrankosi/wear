package educar.gui.AlumnoView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.controllers.AlumnosControllers.AlumnoControllers;
import educar.controllers.AlumnosControllers.AlumnoListController;
import educar.controllers.AlumnosControllers.AlumnoListSolucionController;
import educar.controllers.AlumnosControllers.AlumnosViewController;
import educar.gui.IView;
import educar.gui.Listener.AlumnoListListener;
import educar.gui.Listener.AlumnoListener;
import educar.languaje.defaultLanguaje;

public class AlumnoView extends JFrame implements IView, defaultLanguaje {

    private JPanel contentPane;
    private JPanel panelMenuAlumno;
    private JButton btnCargarSolucion;
    private JPanel panelCarcarSolucion;
    private List listaActividadesCargarMateria;
    private JTextField txtNota;
    private JPanel panelIncripcionMateria;
    private List listaMateriasInscripo;
    private JButton btnIncribir;
    private JTextField txtCodigoMateria;
    private List listaMateriasAInscribir;
    private JButton btnIncripcionMateria;
    private JPanel panelBienvenido;
    private JTextArea textArea;
    private JTextArea textArea2;
    private String codActividad;

    /**
     * Create the frame.
     */
    public AlumnoView() {
    	setTitle("ALUMNO");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AlumnoView.class.getResource("/educar/gui/AdminViews/imagenIcon/1336865201_graduated.png")));
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setBounds(0, 0, d.width, d.height - 50);// Tama�o de mi ventana

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	// ////////////// MENU ALUMNO // ////////////////////////////

	panelMenuAlumno = new JPanel();
	panelMenuAlumno.setLayout(null);
	panelMenuAlumno.setAutoscrolls(true);
	panelMenuAlumno.setBounds(0, 0, 148, 680);
	contentPane.add(panelMenuAlumno);

	btnCargarSolucion = new JButton(CARGARSOLUCIONALUMNOPANEL);
	btnCargarSolucion.setFont(new Font("Arial", Font.BOLD, 12));
	btnCargarSolucion.setBounds(0, 0, 148, 340);
	panelMenuAlumno.add(btnCargarSolucion);

	AlumnoListener btnPanelCargarS = new AlumnoListener();
	IController addSolve = new AlumnosViewController();
	addSolve.setView(this);
	btnPanelCargarS.associate(btnCargarSolucion, addSolve);

	btnIncripcionMateria = new JButton(INSCRIBIRMALUMNOPANEL);
	btnIncripcionMateria.setFont(new Font("Arial", Font.BOLD, 11));
	btnIncripcionMateria.setBounds(0, 343, 148, 340);
	panelMenuAlumno.add(btnIncripcionMateria);

	AlumnoListener InscribirM = new AlumnoListener();
	IController InscribirMC = new AlumnosViewController();
	InscribirMC.setView(this);
	InscribirM.associate(btnIncripcionMateria, InscribirMC);

	// ////// PANEL BIENVENIDO ////////////////////////////////////////
	panelBienvenido = new JPanel();
	panelBienvenido.setBackground(Color.WHITE);
	panelBienvenido.setForeground(SystemColor.desktop);
	panelBienvenido.setBounds(148, 0, 1202, 680);
	contentPane.add(panelBienvenido);
	panelBienvenido.setLayout(null);
	panelBienvenido.setVisible(true);

	JLabel lblFotoBiendenido = new JLabel("");
	lblFotoBiendenido.setBackground(Color.WHITE);
	lblFotoBiendenido
		.setIcon(new ImageIcon(
			AlumnoView.class
				.getResource("/educar/gui/AlumnoView/imagenIconAlumno/educar2012.jpg")));
	lblFotoBiendenido.setHorizontalAlignment(SwingConstants.CENTER);
	lblFotoBiendenido.setFont(new Font("Arial", Font.BOLD, 23));
	lblFotoBiendenido.setBounds(0, 0, 1202, 680);
	panelBienvenido.add(lblFotoBiendenido);

	// ///////////////////////////// APANEL CARGAR SOLUCION DE ACTIVIDAD
	// ///////////////////////

	panelCarcarSolucion = new JPanel();
	panelCarcarSolucion.setBackground(SystemColor.activeCaption);
	panelCarcarSolucion.setForeground(SystemColor.desktop);
	panelCarcarSolucion.setBounds(148, 0, 1202, 680);
	contentPane.add(panelCarcarSolucion);
	panelCarcarSolucion.setLayout(null);
	panelCarcarSolucion.setVisible(false);

	JLabel lblSolucionActividad = new JLabel(S81);
	lblSolucionActividad.setHorizontalAlignment(SwingConstants.LEFT);
	lblSolucionActividad.setFont(new Font("Arial", Font.BOLD, 23));
	lblSolucionActividad.setBounds(22, 120, 276, 28);
	panelCarcarSolucion.add(lblSolucionActividad);

	JLabel lblDescripicionActividad = new JLabel(S82);
	lblDescripicionActividad.setHorizontalAlignment(SwingConstants.LEFT);
	lblDescripicionActividad.setFont(new Font("Arial", Font.BOLD, 23));
	lblDescripicionActividad.setBounds(22, 351, 276, 28);
	panelCarcarSolucion.add(lblDescripicionActividad);

	JLabel lblNotaActividad = new JLabel(S83);
	lblNotaActividad.setHorizontalAlignment(SwingConstants.CENTER);
	lblNotaActividad.setFont(new Font("Arial", Font.BOLD, 23));
	lblNotaActividad.setBounds(58, 598, 265, 59);
	panelCarcarSolucion.add(lblNotaActividad);
	JLabel lblCartelCargarMateria = new JLabel(S84);
	lblCartelCargarMateria.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelCargarMateria.setFont(new Font("Arial", Font.BOLD, 24));
	lblCartelCargarMateria.setBounds(0, 11, 887, 92);
	panelCarcarSolucion.add(lblCartelCargarMateria);

	JLabel lblListaDeActividades = new JLabel(S85);
	lblListaDeActividades.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaDeActividades.setFont(new Font("Arial", Font.BOLD, 23));
	lblListaDeActividades.setBounds(897, 17, 295, 54);
	panelCarcarSolucion.add(lblListaDeActividades);

	listaActividadesCargarMateria = new List();
	listaActividadesCargarMateria.setFont(new Font("Arial", Font.BOLD, 12));
	listaActividadesCargarMateria.setBounds(893, 77, 299, 592);
	panelCarcarSolucion.add(listaActividadesCargarMateria);

	AlumnoListListener listaActividades2 = new AlumnoListListener();
	IListController listaActividadControllers2 = new AlumnoListSolucionController();
	((IController) listaActividadControllers2).setView(this);
	listaActividades2.associate(listaActividadesCargarMateria,
		listaActividadControllers2);

	txtNota = new JTextField();
	txtNota.setEditable(false);
	txtNota.setFont(new Font("Arial", Font.BOLD, 20));
	txtNota.setColumns(10);
	txtNota.setBounds(333, 598, 90, 59);
	panelCarcarSolucion.add(txtNota);

	JButton btnSubir = new JButton(SUBIR);
	btnSubir.setFont(new Font("Arial", Font.BOLD, 20));
	btnSubir.setBounds(555, 598, 244, 59);
	panelCarcarSolucion.add(btnSubir);

	AlumnoListener bSubir = new AlumnoListener();
	IController alumnoSolucion = new AlumnoControllers();
	alumnoSolucion.setView(this);
	bSubir.associate(btnSubir, alumnoSolucion);

	textArea = new JTextArea();
	textArea.setFont(new Font("Arial", Font.BOLD, 13));
	textArea.setText("");
	textArea.setBounds(22, 114, 621, 224);
	JScrollPane scroll = new JScrollPane(textArea);
	scroll.setBounds(22, 144, 799, 201);
	panelCarcarSolucion.add(scroll);

	textArea2 = new JTextArea();
	textArea2.setFont(new Font("Arial", Font.BOLD, 13));
	textArea2.setText("");
	textArea2.setEditable(false);
	textArea2.setBounds(22, 114, 621, 224);
	JScrollPane scroll2 = new JScrollPane(textArea2);
	scroll2.setBounds(22, 381, 799, 201);
	panelCarcarSolucion.add(scroll2);

	// //////////////////////////////// PANEL INCRIPCION MATERIA
	// //////////////////////////////////////////////////////
	panelIncripcionMateria = new JPanel();
	panelIncripcionMateria.setBackground(SystemColor.inactiveCaption);
	panelIncripcionMateria.setForeground(SystemColor.desktop);
	panelIncripcionMateria.setBounds(148, 0, 1202, 680);
	contentPane.add(panelIncripcionMateria);
	panelIncripcionMateria.setLayout(null);
	panelIncripcionMateria.setVisible(false);

	JLabel lblNombreMateria = new JLabel(S86);
	lblNombreMateria.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombreMateria.setFont(new Font("Arial", Font.BOLD, 23));
	lblNombreMateria.setBounds(0, 334, 265, 54);
	panelIncripcionMateria.add(lblNombreMateria);

	JLabel lblCartelIncribirmeMateria = new JLabel(S87);
	lblCartelIncribirmeMateria
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelIncribirmeMateria.setFont(new Font("Arial", Font.BOLD, 26));
	lblCartelIncribirmeMateria.setBounds(0, 11, 650, 92);
	panelIncripcionMateria.add(lblCartelIncribirmeMateria);

	JLabel lblListaMaterias = new JLabel(S88);
	lblListaMaterias.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaMaterias.setFont(new Font("Arial", Font.BOLD, 23));
	lblListaMaterias.setBounds(927, 17, 265, 42);
	panelIncripcionMateria.add(lblListaMaterias);

	JLabel label = new JLabel(S89);
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Arial", Font.BOLD, 23));
	label.setBounds(652, 17, 265, 42);
	panelIncripcionMateria.add(label);

	JLabel lblaIncribirme = new JLabel(S90);
	lblaIncribirme.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
	lblaIncribirme.setHorizontalAlignment(SwingConstants.CENTER);
	lblaIncribirme.setBounds(660, 55, 257, 23);
	panelIncripcionMateria.add(lblaIncribirme);

	JLabel lblIncripto = new JLabel(S100);
	lblIncripto.setHorizontalAlignment(SwingConstants.CENTER);
	lblIncripto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
	lblIncripto.setBounds(935, 55, 257, 23);
	panelIncripcionMateria.add(lblIncripto);

	listaMateriasInscripo = new List();
	listaMateriasInscripo.setFont(new Font("Arial", Font.BOLD, 12));
	listaMateriasInscripo.setBounds(927, 77, 265, 592);
	panelIncripcionMateria.add(listaMateriasInscripo);

	listaMateriasAInscribir = new List();
	listaMateriasAInscribir.setFont(new Font("Arial", Font.BOLD, 12));
	listaMateriasAInscribir.setBounds(656, 77, 265, 592);
	panelIncripcionMateria.add(listaMateriasAInscribir);

	AlumnoListListener listaMaterias = new AlumnoListListener();
	IListController listaMateriasControllers = new AlumnoListController();
	((IController) listaMateriasControllers).setView(this);
	listaMaterias.associate(listaMateriasAInscribir,
		listaMateriasControllers);

	txtCodigoMateria = new JTextField();
	txtCodigoMateria.setEditable(false);
	txtCodigoMateria.setFont(new Font("Arial", Font.BOLD, 20));
	txtCodigoMateria.setBounds(249, 335, 365, 54);
	panelIncripcionMateria.add(txtCodigoMateria);
	txtCodigoMateria.setColumns(10);

	btnIncribir = new JButton(ADD);
	btnIncribir.setFont(new Font("Arial", Font.BOLD, 20));
	btnIncribir.setBounds(378, 584, 139, 54);
	panelIncripcionMateria.add(btnIncribir);

	AlumnoListener bInscribir = new AlumnoListener();
	IController alumnoInscribir = new AlumnoControllers();
	alumnoInscribir.setView(this);
	bInscribir.associate(btnIncribir, alumnoInscribir);

    }

    // ///////////////// get y set de CARGAR SOLUCION //////////

    public String getSolucionActividad() {
	return this.textArea.getText();
    }

    public String getDescripcionActividad() { // aca seria el get para bajar un
	// archivo
	return this.textArea2.getText();
    }

    public String getNota() {
	return this.txtNota.getText();
    }

    public void setSolucionActividad(String s) {
	this.textArea.setText(s);
    }

    public void setDescripcionActividad(String s) {
	this.textArea2.setText(s);
    }

    public void setNota(String s) {
	this.txtNota.setText(s);
    }

    public boolean camposVaciosCargarSolucion() {
	return (this.getSolucionActividad().compareTo("") == 0)
		&& (this.getDescripcionActividad().compareTo("") == 0);// &&

    }

    public void setVacioCargarSolucion() {
	this.setSolucionActividad("");
	this.setDescripcionActividad("");
	this.setNota("");
    }

    public void setListaActividad(LinkedList<String> listaActividad) {
	listaActividadesCargarMateria.removeAll();
	for (int i = 0; i < listaActividad.size(); i++) {
	    listaActividadesCargarMateria.add(listaActividad.get(i), i);

	}
    }

    // ///////// get and set de INCRIPCION MATERIA /////////////

    public String getCodigoMateria() {
	return txtCodigoMateria.getText();
    }

    public void setCodigoMateria(String s) {
	txtCodigoMateria.setText(s);
    }

    public boolean camposVaciosIncripcionMateria() {
	return (this.getCodigoMateria().compareTo("") == 0);

    }

    public void setVaciosIncripcionMateria() {
	this.setCodigoMateria("");
    }

    public void setListaMaterias(LinkedList<String> listaMaterias) {
	listaMateriasAInscribir.removeAll();
	for (int i = 0; i < listaMaterias.size(); i++) {
	    listaMateriasAInscribir.add(listaMaterias.get(i), i);

	}
    }

    public void setListaMateriasInscripto(
	    LinkedList<String> listaMateriasIncripto) {
	listaMateriasInscripo.removeAll();
	for (int i = 0; i < listaMateriasIncripto.size(); i++) {
	    listaMateriasInscripo.add(listaMateriasIncripto.get(i), i);

	}
    }

    @Override
    public void present(String model) {
	// TODO Auto-generated method stub
	JOptionPane.showMessageDialog(null, model);
    }

    public void setCodActividad(String item) {
	// TODO Auto-generated method stub
	this.codActividad = item;
    }

    public String getCodActividad() {
	// TODO Auto-generated method stub
	return this.codActividad;
    }

    // ||||||||||||||||||metodos cargar paneles|||||||||||||
    // |||||||||||||||||||||||||||||||||||||||||||||||||||||

    public void panelCargarSolucion() {
	panelCarcarSolucion.setVisible(true);
	panelIncripcionMateria.setVisible(false);
	panelBienvenido.setVisible(false);

    }

    public void panelInscripcionMateria() {
	panelCarcarSolucion.setVisible(false);
	panelIncripcionMateria.setVisible(true);
	panelBienvenido.setVisible(false);
    }

}
