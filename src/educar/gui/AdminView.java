package educar.gui;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

	Button buttonGDocentes = new Button("Gestionar Docente");
	buttonGDocentes.setBounds(117, 10, 141, 36);
	contentPane.add(buttonGDocentes);

	Button buttonGAlumnos = new Button("Gestionar Alumno");
	buttonGAlumnos.setBounds(117, 52, 141, 36);
	contentPane.add(buttonGAlumnos);

	Button buttonGMaterias = new Button("Gestionar Materia");
	buttonGMaterias.setBounds(117, 94, 141, 36);
	contentPane.add(buttonGMaterias);

	Button buttonGFacultad = new Button("Gestionar Facultad");
	buttonGFacultad.setBounds(117, 136, 141, 36);
	contentPane.add(buttonGFacultad);

	Button buttonGCargos = new Button("**Gestionar Cargo");
	buttonGCargos.setBounds(117, 178, 141, 36);
	contentPane.add(buttonGCargos);

	Button buttonClose = new Button("cerrar");
	buttonClose.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		buttonCloseActionPerformed(arg0);
	    }
	});
	buttonClose.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 12));
	buttonClose.setBounds(352, 241, 86, 23);
	contentPane.add(buttonClose);
    }

    // accion al evento del btn close
    private void buttonCloseActionPerformed(ActionEvent arg0) {
	this.dispose();
    }

    @Override
    public void present(String model) {
	// TODO Auto-generated method stub

    }
}
