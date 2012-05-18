import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Docente;


public class TestLoginDocente {

	private Docente docente;
	
	@Before
	public void setUp() {
		docente = new Docente("35543985", "juan", "perez", "1978-05-11", "254437", "kowalk 328");
		docente.save();
	}
	
	@Test
	public void testLoginCorrecto() {
		assertEquals(User.authenticate("35543985", "43985"), true);
	}
	
	@After
	public void clean() throws userNotFound {
		docente.destroy();
	}

}
