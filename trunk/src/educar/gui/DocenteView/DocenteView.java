package educar.gui.DocenteView;

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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.IListController;
import educar.controllers.DocenteControllers.DocenteController;
import educar.controllers.DocenteControllers.DocenteCorregirController;
import educar.controllers.DocenteControllers.DocenteCorregirListResolucionesController;
import educar.controllers.DocenteControllers.DocenteListaActividadesBorrar;
import educar.controllers.DocenteControllers.DocenteViewController;
import educar.gui.IView;
import educar.gui.Listener.DocenteListListener;
import educar.gui.Listener.DocenteListener;
import educar.languaje.defaultLanguaje;

public class DocenteView extends JFrame implements IView, defaultLanguaje {

    private JPanel contentPane;
    private JPanel panelMenuDocente;
    private JButton btnActividadMenuDocente;
    private JButton btnCorregirActividad;
    private JPanel panelBienvenido;
    private JPanel panelActividadDocente;
    private JPanel panelAddActividadDocente;
    private JPanel panelDeleteActividadDocente;
    private List listaMateriaActividadDocente;
    private JTextField txtCodigoMAteriaAddActividad;
    private JButton btnGuardarAddActividad;
    private JTextField txtCodigoMAteriaDeleteActividad;
    private List listaActividadDocente;
    private JButton btnBorrarDeleteActividad;
    private JPanel panelCorregirDocente;
    private List litaCorregirMateria;
    private JTextField txtDniCorregir;
    private JTextField textNombreAlumno;
    private JTextField txtNotaCorregir;
    private JButton btnSubirCorregir;
    private JTextArea textAreaAddActividad;
    private JTextArea textAreaDeleteActividad;
    private JTextArea textAreaCorregir;

    private static final long serialVersionUID = 1L;
    private List listaResolucionCorregir;
    private JLabel label;
    private JTextArea textAreaActividadCorregir;
    private JLabel lblActividad;

    /**
     * Create the frame.
     */
    /**
	 * 
	 */
    public DocenteView() {
    	setTitle("DOCENTE");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(DocenteView.class.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")));
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setBounds(0, 0, d.width, d.height - 50);// Tama�o de mi ventana

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	// ////////////// MENU DOCENTE // ////////////////////////////

	panelMenuDocente = new JPanel();
	panelMenuDocente.setLayout(null);
	panelMenuDocente.setAutoscrolls(true);
	panelMenuDocente.setBounds(0, 0, 148, 680);
	contentPane.add(panelMenuDocente);

	btnActividadMenuDocente = new JButton(ACTIVIDADOCENTEPANEL);
	btnActividadMenuDocente.setFont(new Font("Arial", Font.BOLD, 12));
	btnActividadMenuDocente.setBounds(0, 0, 148, 340);
	panelMenuDocente.add(btnActividadMenuDocente);

	DocenteListener btnPanelAct = new DocenteListener();
	IController addActividad = new DocenteViewController();
	addActividad.setView(this);
	btnPanelAct.associate(btnActividadMenuDocente, addActividad);

	btnCorregirActividad = new JButton(CORREGIRDOCENTEPANEL);
	btnCorregirActividad.setFont(new Font("Arial", Font.BOLD, 11));
	btnCorregirActividad.setBounds(0, 343, 148, 340);
	panelMenuDocente.add(btnCorregirActividad);

	DocenteListener btnPanelCor = new DocenteListener();
	IController corregir = new DocenteViewController();
	corregir.setView(this);
	btnPanelCor.associate(btnCorregirActividad, corregir);

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
			DocenteView.class
				.getResource("/educar/gui/DocenteView/imagenIconDocente/educar2012.jpg")));
	lblFotoBiendenido.setHorizontalAlignment(SwingConstants.CENTER);
	lblFotoBiendenido.setFont(new Font("Arial", Font.BOLD, 23));
	lblFotoBiendenido.setBounds(0, 0, 1202, 680);
	panelBienvenido.add(lblFotoBiendenido);

	// ////////////PANEL ACTIVIDAD /////////////////////////
	panelActividadDocente = new JPanel();
	panelActividadDocente.setBackground(SystemColor.activeCaption);
	panelActividadDocente.setForeground(SystemColor.desktop);
	panelActividadDocente.setBounds(148, 0, 1202, 680);
	contentPane.add(panelActividadDocente);
	panelActividadDocente.setLayout(null);

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(0, 0, 1202, 680);
	panelActividadDocente.add(tabbedPane);
	panelActividadDocente.setVisible(false);
	// ------------------------panel ADD actividad -------------
	panelAddActividadDocente = new JPanel();
	panelAddActividadDocente.setBackground(SystemColor.activeCaption);
	tabbedPane
		.addTab(
			S101,
			new ImageIcon(
				DocenteView.class
					.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")),
			panelAddActividadDocente, null);
	panelAddActividadDocente.setLayout(null);

	JLabel lblListaMaterias = new JLabel(S102);
	lblListaMaterias.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaMaterias.setFont(new Font("Arial", Font.BOLD, 23));
	lblListaMaterias.setBounds(896, 29, 265, 42);
	panelAddActividadDocente.add(lblListaMaterias);

	JLabel lblDescripcionAddActividad = new JLabel(S103);
	lblDescripcionAddActividad.setHorizontalAlignment(SwingConstants.LEFT);
	lblDescripcionAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
	lblDescripcionAddActividad.setBounds(22, 114, 315, 42);
	panelAddActividadDocente.add(lblDescripcionAddActividad);

	JLabel lblCodigoMAteriaAddActividad = new JLabel(S104);
	lblCodigoMAteriaAddActividad
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCodigoMAteriaAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
	lblCodigoMAteriaAddActividad.setBounds(61, 384, 276, 49);
	panelAddActividadDocente.add(lblCodigoMAteriaAddActividad);

	JLabel lblCartelAddActividad = new JLabel(S105);
	lblCartelAddActividad.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelAddActividad.setFont(new Font("Arial", Font.BOLD, 26));
	lblCartelAddActividad.setBounds(0, 11, 886, 92);
	panelAddActividadDocente.add(lblCartelAddActividad);

	txtCodigoMAteriaAddActividad = new JTextField();
	txtCodigoMAteriaAddActividad.setEditable(false);
	txtCodigoMAteriaAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
	txtCodigoMAteriaAddActividad.setBounds(384, 381, 365, 54);
	panelAddActividadDocente.add(txtCodigoMAteriaAddActividad);
	txtCodigoMAteriaAddActividad.setColumns(10);

	listaMateriaActividadDocente = new List();
	listaMateriaActividadDocente.setBounds(896, 77, 265, 515);
	panelAddActividadDocente.add(listaMateriaActividadDocente);

	DocenteListListener lMateriasA = new DocenteListListener();
	IListController listaMaterias = new DocenteController();
	((DocenteController) listaMaterias).setView(this);
	lMateriasA.associate(listaMateriaActividadDocente, listaMaterias);

	btnGuardarAddActividad = new JButton(SUBIR);
	btnGuardarAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
	btnGuardarAddActividad.setBounds(378, 515, 183, 64);
	panelAddActividadDocente.add(btnGuardarAddActividad);

	DocenteListener bSubirA = new DocenteListener();
	IController subirActividad = new DocenteController();
	subirActividad.setView(this);
	bSubirA.associate(btnGuardarAddActividad, subirActividad);

	textAreaAddActividad = new JTextArea();
	textAreaAddActividad.setBounds(22, 114, 621, 224);
	JScrollPane scroll = new JScrollPane(textAreaAddActividad);
	scroll.setBounds(22, 144, 799, 222);
	panelAddActividadDocente.add(scroll);

	// --------------------panel DELETE actividad ---------

	panelDeleteActividadDocente = new JPanel();
	panelDeleteActividadDocente.setBackground(SystemColor.inactiveCaption);
	tabbedPane
		.addTab(
			S106,
			new ImageIcon(
				DocenteView.class
					.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")),
			panelDeleteActividadDocente, null);
	panelDeleteActividadDocente.setLayout(null);

	JLabel lblListaActividades = new JLabel(S107);
	lblListaActividades.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaActividades.setFont(new Font("Arial", Font.BOLD, 23));
	lblListaActividades.setBounds(896, 29, 265, 42);
	panelDeleteActividadDocente.add(lblListaActividades);

	JLabel lblDescripcionDeleteActividad = new JLabel(S108);
	lblDescripcionDeleteActividad.setFont(new Font("Arial", Font.BOLD, 20));
	lblDescripcionDeleteActividad.setBounds(22, 114, 315, 42);
	panelDeleteActividadDocente.add(lblDescripcionDeleteActividad);

	JLabel lblCodigoMAteriaDeleteActividad = new JLabel(S109);
	lblCodigoMAteriaDeleteActividad
		.setHorizontalAlignment(SwingConstants.CENTER);
	lblCodigoMAteriaDeleteActividad
		.setFont(new Font("Arial", Font.BOLD, 20));
	lblCodigoMAteriaDeleteActividad.setBounds(61, 384, 276, 49);
	panelDeleteActividadDocente.add(lblCodigoMAteriaDeleteActividad);

	JLabel lblCartelDeleteActividad = new JLabel(S110);
	lblCartelDeleteActividad.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelDeleteActividad.setFont(new Font("Arial", Font.BOLD, 26));
	lblCartelDeleteActividad.setBounds(0, 11, 886, 92);
	panelDeleteActividadDocente.add(lblCartelDeleteActividad);

	txtCodigoMAteriaDeleteActividad = new JTextField();
	txtCodigoMAteriaDeleteActividad.setEditable(false);
	txtCodigoMAteriaDeleteActividad
		.setFont(new Font("Arial", Font.BOLD, 20));
	txtCodigoMAteriaDeleteActividad.setBounds(384, 381, 365, 54);
	panelDeleteActividadDocente.add(txtCodigoMAteriaDeleteActividad);
	txtCodigoMAteriaDeleteActividad.setColumns(10);

	listaActividadDocente = new List();
	listaActividadDocente.setBounds(896, 77, 265, 515);
	panelDeleteActividadDocente.add(listaActividadDocente);

	DocenteListListener lBorrarA = new DocenteListListener();
	IListController listaActividades = new DocenteListaActividadesBorrar();
	((DocenteListaActividadesBorrar) listaActividades).setView(this);
	lBorrarA.associate(listaActividadDocente, listaActividades);

	btnBorrarDeleteActividad = new JButton(DELETE);
	btnBorrarDeleteActividad.setFont(new Font("Arial", Font.BOLD, 20));
	btnBorrarDeleteActividad.setBounds(378, 517, 183, 63);
	panelDeleteActividadDocente.add(btnBorrarDeleteActividad);

	DocenteListener bBorrarA = new DocenteListener();
	IController borrarActividad = new DocenteController();
	borrarActividad.setView(this);
	bBorrarA.associate(btnBorrarDeleteActividad, borrarActividad);

	textAreaDeleteActividad = new JTextArea();
	textAreaDeleteActividad.setEditable(false);
	textAreaDeleteActividad.setBounds(22, 114, 621, 224);
	JScrollPane scroll2 = new JScrollPane(textAreaDeleteActividad);
	scroll2.setBounds(22, 144, 799, 222);
	panelDeleteActividadDocente.add(scroll2);

	// ////////////////// PANEL CORREGIR //////////////////

	panelCorregirDocente = new JPanel();
	panelCorregirDocente.setBackground(SystemColor.activeCaption);
	panelCorregirDocente.setForeground(SystemColor.desktop);
	panelCorregirDocente.setBounds(148, 0, 1202, 680);
	contentPane.add(panelCorregirDocente);
	panelCorregirDocente.setLayout(null);
	panelCorregirDocente.setVisible(false);

	JLabel lblDniCorregir = new JLabel(S111);
	lblDniCorregir.setHorizontalAlignment(SwingConstants.RIGHT);
	lblDniCorregir.setFont(new Font("Arial", Font.BOLD, 23));
	lblDniCorregir.setBounds(0, 585, 51, 54);
	panelCorregirDocente.add(lblDniCorregir);

	JLabel lblNombreAlumno = new JLabel(S112);
	lblNombreAlumno.setFont(new Font("Arial", Font.BOLD, 20));
	lblNombreAlumno.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNombreAlumno.setBounds(250, 585, 88, 54);
	panelCorregirDocente.add(lblNombreAlumno);

	JLabel lblResolucionCorregir = new JLabel(S113);
	lblResolucionCorregir.setHorizontalAlignment(SwingConstants.LEFT);
	lblResolucionCorregir.setFont(new Font("Arial", Font.BOLD, 17));
	lblResolucionCorregir.setBounds(22, 308, 265, 37);
	panelCorregirDocente.add(lblResolucionCorregir);

	JLabel lblNotaCorregir = new JLabel(S114);
	lblNotaCorregir.setHorizontalAlignment(SwingConstants.CENTER);
	lblNotaCorregir.setFont(new Font("Arial", Font.BOLD, 23));
	lblNotaCorregir.setBounds(537, 585, 69, 54);
	panelCorregirDocente.add(lblNotaCorregir);

	JLabel lblCartelCorregir = new JLabel(
		S115);
	lblCartelCorregir.setHorizontalAlignment(SwingConstants.CENTER);
	lblCartelCorregir.setFont(new Font("Arial", Font.BOLD, 24));
	lblCartelCorregir.setBounds(0, 0, 887, 57);
	panelCorregirDocente.add(lblCartelCorregir);

	JLabel lblListaMisActividades = new JLabel(S116);
	lblListaMisActividades.setHorizontalAlignment(SwingConstants.CENTER);
	lblListaMisActividades.setFont(new Font("Arial", Font.BOLD, 23));
	lblListaMisActividades.setBounds(897, 17, 295, 54);
	panelCorregirDocente.add(lblListaMisActividades);

	litaCorregirMateria = new List();
	litaCorregirMateria.setBounds(893, 77, 299, 268);
	panelCorregirDocente.add(litaCorregirMateria);

	DocenteListListener listaMC = new DocenteListListener();
	IListController listaMController = new DocenteCorregirController();
	((DocenteCorregirController) listaMController).setView(this);
	listaMC.associate(litaCorregirMateria, listaMController);

	txtDniCorregir = new JTextField();
	txtDniCorregir.setEditable(false);
	txtDniCorregir.setFont(new Font("Arial", Font.BOLD, 20));
	txtDniCorregir.setBounds(61, 585, 179, 54);
	panelCorregirDocente.add(txtDniCorregir);
	txtDniCorregir.setColumns(10);

	textNombreAlumno = new JTextField();
	textNombreAlumno.setEditable(false);
	textNombreAlumno.setFont(new Font("Arial", Font.BOLD, 14));
	textNombreAlumno.setColumns(10);
	textNombreAlumno.setBounds(348, 585, 179, 54);
	panelCorregirDocente.add(textNombreAlumno);

	txtNotaCorregir = new JTextField();
	txtNotaCorregir.setFont(new Font("Arial", Font.BOLD, 20));
	txtNotaCorregir.setColumns(10);
	txtNotaCorregir.setBounds(616, 585, 72, 54);
	panelCorregirDocente.add(txtNotaCorregir);

	btnSubirCorregir = new JButton(UPLOAD);
	btnSubirCorregir.setFont(new Font("Arial", Font.BOLD, 20));
	btnSubirCorregir.setBounds(708, 585, 179, 54);
	panelCorregirDocente.add(btnSubirCorregir);

	DocenteListener btnSubirC = new DocenteListener();
	IController btnSubirCController = new DocenteCorregirController();
	btnSubirCController.setView(this);
	btnSubirC.associate(btnSubirCorregir, btnSubirCController);

	textAreaCorregir = new JTextArea();
	textAreaCorregir.setBounds(22, 114, 621, 224);
	JScrollPane scroll3 = new JScrollPane(textAreaCorregir);
	scroll3.setBounds(22, 334, 799, 238);
	panelCorregirDocente.add(scroll3);

	textAreaActividadCorregir = new JTextArea();
	textAreaActividadCorregir.setBounds(22, 114, 621, 224);
	textAreaActividadCorregir.setEditable(false);
	JScrollPane scroll4 = new JScrollPane(textAreaActividadCorregir);
	scroll4.setBounds(22, 77, 799, 220);
	panelCorregirDocente.add(scroll4);

	listaResolucionCorregir = new List();
	listaResolucionCorregir.setBounds(897, 402, 295, 268);
	panelCorregirDocente.add(listaResolucionCorregir);

	DocenteListListener listaCorregirResolucion = new DocenteListListener();
	IListController listaRA = new DocenteCorregirListResolucionesController();
	((DocenteCorregirListResolucionesController) listaRA).setView(this);
	listaCorregirResolucion.associate(listaResolucionCorregir, listaRA);

	label = new JLabel(S117);
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Arial", Font.BOLD, 23));
	label.setBounds(897, 334, 295, 92);
	panelCorregirDocente.add(label);

	lblActividad = new JLabel(S118);
	lblActividad.setHorizontalAlignment(SwingConstants.LEFT);
	lblActividad.setFont(new Font("Arial", Font.BOLD, 17));
	lblActividad.setBounds(22, 44, 265, 37);
	panelCorregirDocente.add(lblActividad);

    }

    // // metodos get y set de ACTIVIDAD

    public String getTextAreaCorregir() {
	return textAreaCorregir.getText();
    }

    public void setTextAreaCorregir(String textAreaCorregir) {
	this.textAreaCorregir.setText(textAreaCorregir);
    }

    public String getTextAreaActividadCorregir() {
	return textAreaActividadCorregir.getText();
    }

    public void setTextAreaActividadCorregir(String textAreaActividadCorregir) {
	this.textAreaActividadCorregir.setText(textAreaActividadCorregir);
    }

    public String getDescripcionAddActividad() {
	return textAreaAddActividad.getText();
    }

    public void setDescripcionAddActividad(String s) {
	textAreaAddActividad.setText(s);
    }

    public String getCodigoMateriaAddActividad() {
	return txtCodigoMAteriaAddActividad.getText();
    }

    public void setCodigoMateriaAddActividad(String s) {
	txtCodigoMAteriaAddActividad.setText(s);
    }

    public String getDescripcionDeleteActividad() {
	return textAreaDeleteActividad.getText();
    }

    public void setDEscripcionDeleteActividad(String s) {
	textAreaDeleteActividad.setText(s);
    }

    public String getCodigoMateriaDeleteActividad() {
	return txtCodigoMAteriaDeleteActividad.getText();
    }

    public void setCodigoMateriaDeleteActividad(String s) {
	txtCodigoMAteriaDeleteActividad.setText(s);
    }

    public boolean algunCampoVacioSubirA() {
	return (this.getCodigoMateriaAddActividad().compareTo("") == 0 || this
		.getDescripcionAddActividad().compareTo("") == 0);
    }

    @Override
    public void present(String model) {
	JOptionPane.showMessageDialog(null, model);

    }

    public void limpiarCamposActividad() {
	this.setDescripcionAddActividad("");
	this.setCodigoMateriaAddActividad("");
	this.setDEscripcionDeleteActividad("");
	this.setCodigoMateriaDeleteActividad("");
    }

    public boolean algunCampoVacioBorrarA() {
	return (this.getCodigoMateriaDeleteActividad().compareTo("") == 0 || this
		.getDescripcionDeleteActividad().compareTo("") == 0);

    }

    // // metodos get y set de CORREGIR

    public void setNombreAlumnoCorregir(String s) {
	textNombreAlumno.setText(s);
    }

    public String getDniCorregir() {
	return txtDniCorregir.getText();
    }

    public void setDniCorregir(String s) {
	txtDniCorregir.setText(s);
    }

    public String getCodigoActividadCorregir() {
	return textNombreAlumno.getText();
    }

    public String getResolucionCorregir() {
	return textAreaCorregir.getText();
    }

    public void setResolucionCorregir(String s) {
	textAreaCorregir.setText(s);
    }

    public String getNotaCorregir() {
	return txtNotaCorregir.getText();
    }

    public void setNotaCorregir(String s) {
	txtNotaCorregir.setText(s);
    }

    public boolean algunCampoVacioResolucion() {
	return (this.getDniCorregir().compareTo("") == 0
		|| this.getCodigoActividadCorregir().compareTo("") == 0
		|| this.getNotaCorregir().compareTo("") == 0 || this
		.getResolucionCorregir().compareTo("") == 0);
    }

    public void setearVacioCorregir() {
	this.setResolucionCorregir("");
	this.setDniCorregir("");
	this.setNombreAlumnoCorregir("");
	this.setNotaCorregir("");
	this.setTextAreaActividadCorregir("");
    }

    // ||||||||||||metodos control listas view||||||||||||||
    // ||||||||||||||||||||||||||||||||||||||||||||||||||||

    /**
     * @param listaMaterias
     */
    public void setListCorregirM(LinkedList<String> listaMaterias) {
	litaCorregirMateria.removeAll();
	for (int i = 0; i < listaMaterias.size(); i++) {
	    litaCorregirMateria.add(listaMaterias.get(i), i);
	}
    }

    /**
     * @param actividades
     */
    public void setListActividadD(LinkedList<String> actividades) {
	listaActividadDocente.removeAll();
	listaMateriaActividadDocente.removeAll();
	litaCorregirMateria.removeAll();
	for (int i = 0; i < actividades.size(); i++) {
	    listaActividadDocente.add(actividades.get(i), i);
	    listaMateriaActividadDocente.add(actividades.get(i), i);
	    litaCorregirMateria.add(actividades.get(i), i);
	}
    }

    /**
     * @param listaMaterias
     */
    public void setListMAteriaD(LinkedList<String> listaMaterias) {
	listaMateriaActividadDocente.removeAll();
	for (int i = 0; i < listaMaterias.size(); i++) {
	    listaMateriaActividadDocente.add(listaMaterias.get(i), i);
	}
    }

    /**
     * @param resoluciones
     */
    public void setListResoluciones(LinkedList<String> resoluciones) {
	listaResolucionCorregir.removeAll();
	for (int i = 0; i < resoluciones.size(); i++) {
	    listaResolucionCorregir.add(resoluciones.get(i), i);
	}
    }

    // ||||||||||||metodos control panel view||||||||||||||
    // ||||||||||||||||||||||||||||||||||||||||||||||||||||

    public void panelActividad() {
	panelCorregirDocente.setVisible(false);
	panelActividadDocente.setVisible(true);
	panelBienvenido.setVisible(false);
    }

    public void panelCorregir() {
	panelCorregirDocente.setVisible(true);
	panelActividadDocente.setVisible(false);
	panelBienvenido.setVisible(false);
    }

}