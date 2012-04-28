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

public class gestionFacultadView extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre_alta;
	private JTextField tfDescripcion_alta;
	private JTextField tfCodigo_modif;
	private JTextField tfNombre_modif;
	private JTextField tfDescripcion_modif;

	/**
	 * Create the frame.
	 */
	public gestionFacultadView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_alta = new JPanel();
		tabbedPane.addTab("Alta", null, panel_alta, null);
		panel_alta.setLayout(null);
		
		JLabel lblAltasFacultad = new JLabel("ALTAS FACULTAD");
		lblAltasFacultad.setBounds(25, 11, 103, 14);
		panel_alta.add(lblAltasFacultad);
		
		JLabel lblNombre_alta = new JLabel("Nombre");
		lblNombre_alta.setBounds(10, 54, 46, 14);
		panel_alta.add(lblNombre_alta);
		
		tfNombre_alta = new JTextField();
		tfNombre_alta.setBounds(66, 51, 186, 20);
		panel_alta.add(tfNombre_alta);
		tfNombre_alta.setColumns(10);
		
		JLabel lblDescripcion_alta = new JLabel("Descripcion");
		lblDescripcion_alta.setBounds(10, 87, 62, 14);
		panel_alta.add(lblDescripcion_alta);
		
		tfDescripcion_alta = new JTextField();
		tfDescripcion_alta.setBounds(95, 84, 157, 20);
		panel_alta.add(tfDescripcion_alta);
		tfDescripcion_alta.setColumns(10);
		
		JButton btnClear_alta = new JButton("Clear");
		btnClear_alta.setBounds(91, 131, 62, 23);
		panel_alta.add(btnClear_alta);
		
		JButton btnAdd_alta = new JButton("Add");
		btnAdd_alta.setBounds(163, 131, 89, 23);
		panel_alta.add(btnAdd_alta);
		
		JPanel panel_modif = new JPanel();
		tabbedPane.addTab("Modificacion", null, panel_modif, null);
		panel_modif.setLayout(null);
		
		JLabel lblCodigo_modif = new JLabel("Codigo");
		lblCodigo_modif.setBounds(10, 32, 46, 14);
		panel_modif.add(lblCodigo_modif);
		
		tfCodigo_modif = new JTextField();
		tfCodigo_modif.setBounds(54, 29, 86, 20);
		panel_modif.add(tfCodigo_modif);
		tfCodigo_modif.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(150, 28, 86, 23);
		panel_modif.add(btnBuscar);
		
		JLabel lblNombre_modif = new JLabel("Nombre");
		lblNombre_modif.setBounds(10, 60, 46, 14);
		panel_modif.add(lblNombre_modif);
		
		tfNombre_modif = new JTextField();
		tfNombre_modif.setBounds(83, 57, 153, 20);
		panel_modif.add(tfNombre_modif);
		tfNombre_modif.setColumns(10);
		
		JLabel lblDescripcion_modif = new JLabel("Descripcion");
		lblDescripcion_modif.setBounds(10, 88, 62, 14);
		panel_modif.add(lblDescripcion_modif);
		
		tfDescripcion_modif = new JTextField();
		tfDescripcion_modif.setBounds(83, 85, 153, 20);
		panel_modif.add(tfDescripcion_modif);
		tfDescripcion_modif.setColumns(10);
		
		JButton btnClear_modif = new JButton("Clear");
		btnClear_modif.setBounds(10, 116, 57, 23);
		panel_modif.add(btnClear_modif);
		
		JButton btnBorrar_modif = new JButton("Borrar");
		btnBorrar_modif.setBounds(80, 116, 62, 23);
		panel_modif.add(btnBorrar_modif);
		
		JButton btnModif_modif = new JButton("Modif");
		btnModif_modif.setBounds(150, 116, 89, 23);
		panel_modif.add(btnModif_modif);
	}
}
