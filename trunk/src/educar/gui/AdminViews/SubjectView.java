package educar.gui.AdminViews;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.AdminController.subjectManagementController;
import educar.gui.IView;
import educar.gui.Listener.AdminListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubjectView extends JFrame implements IView {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField tfAddCode;
	private JTextField tfAddName;

	private JTextField tfModifyCode;
	private JTextField tfModifyName;

	/**
	 * Create the frame.
	 */
	public SubjectView() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// PANEL DE BAJAS
		JPanel panel_modif = new JPanel();
		tabbedPane.addTab("Modificacion", null, panel_modif, null);
		panel_modif.setLayout(null);

		JLabel lblModifyCodeSubj = new JLabel("Código");
		lblModifyCodeSubj.setBounds(10, 11, 46, 14);
		panel_modif.add(lblModifyCodeSubj);

		tfModifyCode = new JTextField();
		tfModifyCode.setBounds(54, 8, 90, 20);
		panel_modif.add(tfModifyCode);
		tfModifyCode.setColumns(10);

		JButton btnBuscar_modif = new JButton("Buscar");
		btnBuscar_modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnBuscar_modif.setBounds(154, 7, 78, 23);
		panel_modif.add(btnBuscar_modif);
		// asocio el boton con su controlador
		AdminListener bBuscar_mod = new AdminListener();
		IController gestionCBuscar_mod = new subjectManagementController();
		gestionCBuscar_mod.setView(this);
		bBuscar_mod.associate(btnBuscar_modif, gestionCBuscar_mod);

		JLabel lblModifyName = new JLabel("Nombre");
		lblModifyName.setBounds(10, 49, 46, 14);
		panel_modif.add(lblModifyName);

		tfModifyName = new JTextField();
		tfModifyName.setBounds(54, 46, 176, 20);
		panel_modif.add(tfModifyName);
		tfModifyName.setColumns(10);

		// ALGUNAS ACCIONES
		JButton btnClear_modif = new JButton("Clear");
		btnClear_modif.setBounds(10, 198, 81, 23);
		panel_modif.add(btnClear_modif);
		// asocio boton con controlador
		AdminListener bClear_mod = new AdminListener();
		IController gestionCClear_mod = new subjectManagementController();
		gestionCClear_mod.setView(this);
		bBuscar_mod.associate(btnClear_modif, gestionCClear_mod);

		JButton btnActualizar = new JButton("Update");
		btnActualizar.setBounds(189, 198, 90, 23);
		panel_modif.add(btnActualizar);

		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(101, 198, 78, 23);
		panel_modif.add(btnDel);

		// //////////////////////////
		// PANEL DE ALTAS
		JPanel panel_alta = new JPanel();
		tabbedPane.addTab("Alta", null, panel_alta, null);
		panel_alta.setLayout(null);

		JLabel lblAddCode = new JLabel("Código");
		lblAddCode.setBounds(10, 14, 46, 28);
		panel_alta.add(lblAddCode);

		tfAddCode = new JTextField();
		tfAddCode.setText("");
		tfAddCode.setBounds(66, 18, 158, 20);
		panel_alta.add(tfAddCode);
		tfAddCode.setColumns(10);

		JLabel lblAddName = new JLabel("Nombre");
		lblAddName.setBounds(10, 53, 46, 14);
		panel_alta.add(lblAddName);

		tfAddName = new JTextField();
		tfAddName.setBounds(66, 50, 158, 20);
		panel_alta.add(tfAddName);
		tfAddName.setColumns(10);

		JButton btnAdd_alta = new JButton("Add");
		btnAdd_alta.setBounds(94, 201, 89, 23);
		panel_alta.add(btnAdd_alta);

	}

	// ///////////////////////

	// devuelve lo que tienen los textFields
	public String getModifyNameTF() {
		return tfModifyName.getText();
	}

	public String getModifyCodeTF() {
		return tfModifyCode.getText();
	}

	public String getAddCodeTF() {
		return tfAddCode.getText();
	}

	public String getAddNameTF() {
		return tfAddName.getText();
	}

	// setea lo que tienen los textFields
	public void setModifyNameTF(String s) {
		tfModifyName.setText(s);
	}

	public void setModifyCodeTF(String s) {
		tfModifyCode.setText(s);
	}

	public void setAddCodeTF(String s) {
		tfAddCode.setText(s);
	}

	public void setAddNameTF(String s) {
		tfAddName.setText(s);
	}

	// setea los textFields de gestionar materia en blanco
	public void setEmptyFields() {
		this.setModifyNameTF("");
		this.setModifyCodeTF("");
	}

	public void close() {
		this.dispose();
	}

	@Override
	public void present(String model) {
		// TODO Auto-generated method stub

	}

}
