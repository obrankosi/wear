import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.User;
import educar.models.userNotFound;
import educar.models.AdminModels.Alumno;


public class TestLoginAlumno {

	private Alumno alumno;
	
	@Before
	public void setUp() {
		alumno = new Alumno("34574548","sokky", "burifandela","1998-12-12", "4621722", "blas parera 1742");
		alumno.save();
	}
	
	@Test
	public void testLoginCorrecto() {
		assertEquals(User.authenticate("34574548", "74548"), true);
	}
	
	@After
	public void clean() throws userNotFound {
		alumno.destroy();
	}

}
