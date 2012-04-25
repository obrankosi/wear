package educar.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import educar.controllers.IController;
import educar.controllers.AdminController.AdminController;
import educar.gui.Listener.AdminListener;

public class AdminView extends JFrame implements IView {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public AdminView() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JButton buttonGDocentes = new JButton("Gestionar Docente");
	buttonGDocentes.setBounds(117, 10, 141, 36);
	contentPane.add(buttonGDocentes);

	AdminListener bGstDocente = new AdminListener();
	IController adminCD = new AdminController();
	adminCD.setView(this);
	bGstDocente.associate(buttonGDocentes, adminCD);


	JButton buttonGAlumnos = new JButton("Gestionar Alumno");
	buttonGAlumnos.setBounds(117, 52, 141, 36);
	contentPane.add(buttonGAlumnos);

	AdminListener bGstAlumnos = new AdminListener();
	IController adminCA = new AdminController();
	adminCA.setView(this);
	bGstAlumnos.associate(buttonGAlumnos, adminCA);

	
	JButton buttonGMaterias = new JButton("Gestionar Materia");
	buttonGMaterias.setBounds(117, 94, 141, 36);
	contentPane.add(buttonGMaterias);

	AdminListener bGstMateria = new AdminListener();
	IController adminCM = new AdminController();
	adminCM.setView(this);
	bGstMateria.associate(buttonGMaterias, adminCM);

	JButton buttonGFacultad = new JButton("Gestionar Facultad");
	buttonGFacultad.setBounds(117, 136, 141, 36);
	contentPane.add(buttonGFacultad);
	
	AdminListener bGstFacultad = new AdminListener();
	IController adminCF = new AdminController();
	adminCF.setView(this);
	bGstFacultad.associate(buttonGFacultad, adminCF);

	JButton buttonGCargos = new JButton("**Gestionar Cargo");
	buttonGCargos.setBounds(117, 178, 141, 36);
	contentPane.add(buttonGCargos);

	/* pendiente */

	JButton buttonClose = new JButton("cerrar");
	buttonClose.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
	buttonClose.setBounds(352, 241, 86, 23);
	contentPane.add(buttonClose);

	// creo un listener para el botn y su controlador
	AdminListener buttonListener = new AdminListener();
	IController adminController = new AdminController();
	// le paso esta view al controlador
	adminController.setView(this);
	buttonListener.associate(buttonClose, adminController);
    }

    public void close() {
	this.dispose();
    }

    @Override
    public void present(String model) {
	// TODO Auto-generated method stub

    }
}
