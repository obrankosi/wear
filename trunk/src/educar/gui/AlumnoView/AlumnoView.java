package educar.gui.AlumnoView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AlumnoView extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenuAlumno;
	private JButton btnCargarSolucion;
	private JPanel panelCarcarSolucion;
	private List listaActividadesCargarMateria;
	private JTextField txtSolucionActividad;
	private JTextField txtDescripcionActividad;
	private JTextField txtNota;
	private JButton btnSubir;
	private JPanel panelIncripcionMateria;
	private List listaMateriasInscripo;
	private JButton btnIncribir;
	private JTextField txtCodigoMateria;
	private List listaMateriasAInscribir;
	private JButton btnIncripcionMateria;
	private JPanel panelBienvenido;

	/**
	 * Create the frame.
	 */
	public AlumnoView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, d.width, d.height - 50);// Tamaño de mi ventana

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

		btnCargarSolucion = new JButton("CARGAR SOLUCI\u00D3N");
		btnCargarSolucion.setFont(new Font("Arial", Font.BOLD, 12));
		btnCargarSolucion.setBounds(0, 0, 148, 340);
		panelMenuAlumno.add(btnCargarSolucion);
		btnCargarSolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCarcarSolucion.setVisible(true);
				panelIncripcionMateria.setVisible(false);
				panelBienvenido.setVisible(false);
			}
		});

		btnIncripcionMateria = new JButton("INCRIPCI\u00D3N MATERIA");
		btnIncripcionMateria.setFont(new Font("Arial", Font.BOLD, 11));
		btnIncripcionMateria.setBounds(0, 343, 148, 340);
		panelMenuAlumno.add(btnIncripcionMateria);
		btnIncripcionMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCarcarSolucion.setVisible(false);
				panelIncripcionMateria.setVisible(true);
				panelBienvenido.setVisible(false);
			}
		});

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
		lblFotoBiendenido.setIcon(new ImageIcon(AlumnoView.class.getResource("/educar/gui/AlumnoView/imagenIconAlumno/educar2012.jpg")));
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

		JLabel lblSolucionActividad = new JLabel("Solucion Actividad");
		lblSolucionActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolucionActividad.setFont(new Font("Arial", Font.BOLD, 23));
		lblSolucionActividad.setBounds(58, 158, 265, 54);
		panelCarcarSolucion.add(lblSolucionActividad);

		JLabel lblDescripicionActividad = new JLabel("Descripicion Actividad");
		lblDescripicionActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripicionActividad.setFont(new Font("Arial", Font.BOLD, 23));
		lblDescripicionActividad.setBounds(58, 313, 265, 54);
		panelCarcarSolucion.add(lblDescripicionActividad);

		JLabel lblNotaActividad = new JLabel("Nota ");
		lblNotaActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaActividad.setFont(new Font("Arial", Font.BOLD, 23));
		lblNotaActividad.setBounds(58, 468, 265, 54);
		panelCarcarSolucion.add(lblNotaActividad);
		JLabel lblCartelCargarMateria = new JLabel(
				"SELECCI\u00D3NE LA ACTIVIDAD Y INGRESE LA SOLUCI\u00D3N A SUBIR ");
		lblCartelCargarMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelCargarMateria.setFont(new Font("Arial", Font.BOLD, 24));
		lblCartelCargarMateria.setBounds(0, 11, 887, 92);
		panelCarcarSolucion.add(lblCartelCargarMateria);

		JLabel lblListaDeActividades = new JLabel("LISTA DE ACTIVIDADES");
		lblListaDeActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeActividades.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaDeActividades.setBounds(897, 17, 295, 54);
		panelCarcarSolucion.add(lblListaDeActividades);

		listaActividadesCargarMateria = new List();
		listaActividadesCargarMateria.setBounds(893, 77, 299, 592);
		panelCarcarSolucion.add(listaActividadesCargarMateria);

		txtSolucionActividad = new JTextField();
		txtSolucionActividad.setFont(new Font("Arial", Font.BOLD, 20));
		txtSolucionActividad.setBounds(380, 158, 377, 54);
		panelCarcarSolucion.add(txtSolucionActividad);
		txtSolucionActividad.setColumns(10);

		txtDescripcionActividad = new JTextField();
		txtDescripcionActividad.setEditable(false);
		txtDescripcionActividad.setFont(new Font("Arial", Font.BOLD, 20));
		txtDescripcionActividad.setColumns(10);
		txtDescripcionActividad.setBounds(380, 313, 377, 54);
		panelCarcarSolucion.add(txtDescripcionActividad);

		txtNota = new JTextField();
		txtNota.setEditable(false);
		txtNota.setFont(new Font("Arial", Font.BOLD, 20));
		txtNota.setColumns(10);
		txtNota.setBounds(380, 468, 377, 54);
		panelCarcarSolucion.add(txtNota);

		btnSubir = new JButton("SUBIR");
		btnSubir.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubir.setBounds(504, 585, 139, 54);
		panelCarcarSolucion.add(btnSubir);

		// //////////////////////////////// PANEL INCRIPCION MATERIA
		// //////////////////////////////////////////////////////
		panelIncripcionMateria = new JPanel();
		panelIncripcionMateria.setBackground(SystemColor.inactiveCaption);
		panelIncripcionMateria.setForeground(SystemColor.desktop);
		panelIncripcionMateria.setBounds(148, 0, 1202, 680);
		contentPane.add(panelIncripcionMateria);
		panelIncripcionMateria.setLayout(null);
		panelIncripcionMateria.setVisible(false);

		JLabel lblNombreMateria = new JLabel("Codigo Materia");
		lblNombreMateria.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreMateria.setFont(new Font("Arial", Font.BOLD, 23));
		lblNombreMateria.setBounds(0, 334, 265, 54);
		panelIncripcionMateria.add(lblNombreMateria);

		JLabel lblCartelIncribirmeMateria = new JLabel(
				"SELECCI\u00D3NE LA MATERIA A INCRIBIRSE ");
		lblCartelIncribirmeMateria
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelIncribirmeMateria.setFont(new Font("Arial", Font.BOLD, 26));
		lblCartelIncribirmeMateria.setBounds(0, 11, 650, 92);
		panelIncripcionMateria.add(lblCartelIncribirmeMateria);

		JLabel lblListaMaterias = new JLabel("LISTA DE MATERIA");
		lblListaMaterias.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaMaterias.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaMaterias.setBounds(927, 17, 265, 42);
		panelIncripcionMateria.add(lblListaMaterias);

		JLabel label = new JLabel("LISTA DE MATERIA");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 23));
		label.setBounds(652, 17, 265, 42);
		panelIncripcionMateria.add(label);

		JLabel lblaIncribirme = new JLabel("( A INCRIBIRME )");
		lblaIncribirme.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblaIncribirme.setHorizontalAlignment(SwingConstants.CENTER);
		lblaIncribirme.setBounds(660, 55, 257, 23);
		panelIncripcionMateria.add(lblaIncribirme);

		JLabel lblIncripto = new JLabel("(  INCRIPTO  )");
		lblIncripto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncripto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblIncripto.setBounds(935, 55, 257, 23);
		panelIncripcionMateria.add(lblIncripto);

		listaMateriasInscripo = new List();
		listaMateriasInscripo.setBounds(927, 77, 265, 592);
		panelIncripcionMateria.add(listaMateriasInscripo);

		listaMateriasAInscribir = new List();
		listaMateriasAInscribir.setBounds(656, 77, 265, 592);
		panelIncripcionMateria.add(listaMateriasAInscribir);

		txtCodigoMateria = new JTextField();
		txtCodigoMateria.setEditable(false);
		txtCodigoMateria.setFont(new Font("Arial", Font.BOLD, 20));
		txtCodigoMateria.setBounds(249, 335, 365, 54);
		panelIncripcionMateria.add(txtCodigoMateria);
		txtCodigoMateria.setColumns(10);

		btnIncribir = new JButton("INCRIBIR");
		btnIncribir.setFont(new Font("Arial", Font.BOLD, 20));
		btnIncribir.setBounds(378, 584, 139, 54);
		panelIncripcionMateria.add(btnIncribir);
	}

	// ///////////////// get y set de CARGAR SOLUCION //////////

	public String getSolucionActividad() {
		return txtSolucionActividad.getText();
	}

	public String getDescripcionActividad() {
		return txtDescripcionActividad.getText();
	}

	public String getNota() {
		return txtNota.getText();
	}

	public void setSolucionActividad(String s) {
		txtSolucionActividad.setText(s);
	}

	public void setDescripcionActividad(String s) {
		txtDescripcionActividad.setText(s);
	}

	public void setNota(String s) {
		txtNota.setText(s);
	}

	// ///////// get and set de INCRIPCION MATERIA /////////////

	public String getCodigoMateria() {
		return txtCodigoMateria.getText();
	}

	public void setCodigoMateria() {
		txtCodigoMateria.getText();
	}

}