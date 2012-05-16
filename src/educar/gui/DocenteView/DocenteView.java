package educar.gui.DocenteView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import educar.controllers.DocenteController;
import educar.controllers.IController;
import educar.controllers.IListController;
import educar.gui.IView;
import educar.gui.Listener.DocenteListListener;
import educar.gui.Listener.DocenteListener;

public class DocenteView extends JFrame implements IView {

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
	private List listaResolucionCorregir;
	private JTextField txtDniCorregir;
	private JTextField txtCodigoActividadCorregir;
	private JTextField txtNotaCorregir;
	private JButton btnSubirCorregir;
	private JTextArea textAreaAddActividad;
	private JTextArea textAreaDeleteActividad;
	private JTextArea textAreaCorregir;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public DocenteView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, d.width, d.height - 50);// Tamaño de mi ventana

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

		btnActividadMenuDocente = new JButton("ACTIVIDAD");
		btnActividadMenuDocente.setFont(new Font("Arial", Font.BOLD, 12));
		btnActividadMenuDocente.setBounds(0, 0, 148, 340);
		panelMenuDocente.add(btnActividadMenuDocente);
		btnActividadMenuDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCorregirDocente.setVisible(false);
				panelActividadDocente.setVisible(true);
				panelBienvenido.setVisible(false);
			}
		});

		btnCorregirActividad = new JButton("CORREGIR");
		btnCorregirActividad.setFont(new Font("Arial", Font.BOLD, 11));
		btnCorregirActividad.setBounds(0, 343, 148, 340);
		panelMenuDocente.add(btnCorregirActividad);
		btnCorregirActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCorregirDocente.setVisible(true);
				panelActividadDocente.setVisible(false);
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
				.addTab("SUBIR ACTIVIDAD",
						new ImageIcon(
								DocenteView.class
										.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")),
						panelAddActividadDocente, null);
		panelAddActividadDocente.setLayout(null);

		JLabel lblListaMaterias = new JLabel("LISTA DE MATERIA");
		lblListaMaterias.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaMaterias.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaMaterias.setBounds(896, 29, 265, 42);
		panelAddActividadDocente.add(lblListaMaterias);

		JLabel lblDescripcionAddActividad = new JLabel("DESCRIPCION ACTIVIDAD");
		lblDescripcionAddActividad.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcionAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		lblDescripcionAddActividad.setBounds(22, 114, 315, 42);
		panelAddActividadDocente.add(lblDescripcionAddActividad);

		JLabel lblCodigoMAteriaAddActividad = new JLabel("CODIGO MATERIA");
		lblCodigoMAteriaAddActividad
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoMAteriaAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		lblCodigoMAteriaAddActividad.setBounds(61, 384, 276, 49);
		panelAddActividadDocente.add(lblCodigoMAteriaAddActividad);

		JLabel lblCartelAddActividad = new JLabel(
				"SELECCIONE LA MATERIA E INGRESE LA ACTIVIDAD A CARGAR");
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
		
		
		btnGuardarAddActividad = new JButton("SUBIR");
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
				.addTab("BORRAR ACTIVIDAD",
						new ImageIcon(
								DocenteView.class
										.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")),
						panelDeleteActividadDocente, null);
		panelDeleteActividadDocente.setLayout(null);

		JLabel lblListaActividades = new JLabel("LISTA DE ACTIVIDADES");
		lblListaActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaActividades.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaActividades.setBounds(896, 29, 265, 42);
		panelDeleteActividadDocente.add(lblListaActividades);

		JLabel lblDescripcionDeleteActividad = new JLabel(
				"DESCRIPCION ACTIVIDAD");
		lblDescripcionDeleteActividad.setFont(new Font("Arial", Font.BOLD, 20));
		lblDescripcionDeleteActividad.setBounds(22, 114, 315, 42);
		panelDeleteActividadDocente.add(lblDescripcionDeleteActividad);

		JLabel lblCodigoMAteriaDeleteActividad = new JLabel("CODIGO MATERIA");
		lblCodigoMAteriaDeleteActividad
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoMAteriaDeleteActividad
				.setFont(new Font("Arial", Font.BOLD, 20));
		lblCodigoMAteriaDeleteActividad.setBounds(61, 384, 276, 49);
		panelDeleteActividadDocente.add(lblCodigoMAteriaDeleteActividad);

		JLabel lblCartelDeleteActividad = new JLabel(
				"SELECCIONE LA ACTIVIDAD A ELIMINAR ");
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
		IListController listaActividades = new DocenteController();
		((DocenteController) listaActividades).setView(this);
		lBorrarA.associate(listaActividadDocente, listaActividades);

		
		btnBorrarDeleteActividad = new JButton("BORRAR");
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

		JLabel lblDniCorregir = new JLabel("D.N.I Alumno");
		lblDniCorregir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDniCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblDniCorregir.setBounds(120, 158, 250, 54);
		panelCorregirDocente.add(lblDniCorregir);

		JLabel lblCodigoActividadCorregir = new JLabel("CODIGO ACTIVIDAD");
		lblCodigoActividadCorregir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoActividadCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		lblCodigoActividadCorregir.setBounds(120, 223, 250, 54);
		panelCorregirDocente.add(lblCodigoActividadCorregir);

		JLabel lblResolucionCorregir = new JLabel("RESOLUCION");
		lblResolucionCorregir.setHorizontalAlignment(SwingConstants.LEFT);
		lblResolucionCorregir.setFont(new Font("Arial", Font.BOLD, 17));
		lblResolucionCorregir.setBounds(22, 269, 265, 39);
		panelCorregirDocente.add(lblResolucionCorregir);

		JLabel lblNotaCorregir = new JLabel("NOTA");
		lblNotaCorregir.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblNotaCorregir.setBounds(58, 585, 233, 54);
		panelCorregirDocente.add(lblNotaCorregir);

		JLabel lblCartelCorregir = new JLabel(
				"SELECCIONE LA RESOLUCIÓN E INGRESE LA NOTA A CARGAR");
		lblCartelCorregir.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelCorregir.setFont(new Font("Arial", Font.BOLD, 24));
		lblCartelCorregir.setBounds(0, 11, 887, 92);
		panelCorregirDocente.add(lblCartelCorregir);

		JLabel lblListaResolucionesCorregir = new JLabel(
				"LISTA DE RESOLUCIONES");
		lblListaResolucionesCorregir
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaResolucionesCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaResolucionesCorregir.setBounds(897, 17, 295, 54);
		panelCorregirDocente.add(lblListaResolucionesCorregir);

		listaResolucionCorregir = new List();
		listaResolucionCorregir.setBounds(893, 77, 299, 592);
		panelCorregirDocente.add(listaResolucionCorregir);

		txtDniCorregir = new JTextField();
		txtDniCorregir.setEditable(false);
		txtDniCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtDniCorregir.setBounds(380, 158, 377, 54);
		panelCorregirDocente.add(txtDniCorregir);
		txtDniCorregir.setColumns(10);

		txtCodigoActividadCorregir = new JTextField();
		txtCodigoActividadCorregir.setEditable(false);
		txtCodigoActividadCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtCodigoActividadCorregir.setColumns(10);
		txtCodigoActividadCorregir.setBounds(380, 219, 377, 54);
		panelCorregirDocente.add(txtCodigoActividadCorregir);

		txtNotaCorregir = new JTextField();
		txtNotaCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtNotaCorregir.setColumns(10);
		txtNotaCorregir.setBounds(301, 585, 96, 54);
		panelCorregirDocente.add(txtNotaCorregir);

		btnSubirCorregir = new JButton("SUBIR");
		btnSubirCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubirCorregir.setBounds(504, 585, 139, 54);
		panelCorregirDocente.add(btnSubirCorregir);

		textAreaCorregir = new JTextArea();
		textAreaCorregir.setBounds(22, 114, 621, 224);
		JScrollPane scroll3 = new JScrollPane(textAreaCorregir);
		scroll3.setBounds(22, 304, 799, 268);
		panelCorregirDocente.add(scroll3);

	}

	// // metodos get y set de ACTIVIDAD

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

	public boolean hasDescriptionAddActividad() {
		return !(this.getDescripcionAddActividad().compareTo("") == 0);
	}

	public boolean hasCodeAddActividad() {
		return !(this.getCodigoMateriaAddActividad().compareTo("") == 0);
	}

	@Override
	public void present(String model) {
		JOptionPane.showMessageDialog(null, model);

	}

	public void limpiarCamposActividad() {
		setDescripcionAddActividad("");
		setCodigoMateriaAddActividad("");
	}

	public boolean hasDescriptionDeleteActividad() {
		return !(this.getDescripcionDeleteActividad().compareTo("") == 0)
				|| (this.getDescripcionDeleteActividad() == null);
	}

	public boolean hasCodeDeleteActividad() {
		return !(this.getCodigoMateriaDeleteActividad().compareTo("") == 0)
				|| (this.getCodigoMateriaDeleteActividad() == null);

	}

	/**
	 * @param listaMaterias
	 */
	public void setListMostrarMaterias(LinkedList<String> listaMaterias) {
		listaMateriaActividadDocente.removeAll();
		for (int i = 0; i < listaMaterias.size(); i++) {
			listaMateriaActividadDocente.add(listaMaterias.get(i), i);
			}
	}

	// // metodos get y set de CORREGIR

	public String getDniCorregir() {
		return txtDniCorregir.getText();
	}

	public void setDniCorregir(String s) {
		txtDniCorregir.setText(s);
	}

	public String getCodigoActividadCorregir() {
		return txtCodigoActividadCorregir.getText();
	}

	public void setCodigoActividadCorregir(String s) {
		txtCodigoActividadCorregir.setText(s);
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

}