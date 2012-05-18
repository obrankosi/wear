import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.Actividad;
import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.AsignacionDocente;
import educar.models.AdminModels.Docente;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.Subject;


public class TestLoginDocente {

	private Docente docente;
	private Facultad facultad;
	private Subject materia;
	private AsignacionDocente dicta;
	private Actividad act;
	
	@Before
	public void setUp() {
		docente = new Docente("35543985", "juan", "perez", "1978-05-11", "254437", "kowalk 328");
		docente.save();
		facultad=new Facultad("exaxtas");
		facultad.save();
		materia = new Subject("quimica",docente.getDni(),facultad.getCodigo());
		materia.save();
		dicta = new AsignacionDocente(materia.getCode(),docente.getDni());
		
	}
	
	@Test
	public void testLoginCorrecto() {
		assertEquals(User.authenticate("35543985", "43985"), true);
	}
	
	@Test
	public void testLoginIncorrecto() {
		assertEquals(User.authenticate("35543985", "1234"), false);
	}
	
	@After
	public void clean() throws userNotFound {
		docente.destroy();
		facultad.destroy();
		materia.delete();
		dicta.delete();
	}

}
