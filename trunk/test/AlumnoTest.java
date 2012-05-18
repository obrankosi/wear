import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.AdminModels.Alumno;


/**	GRUPO WEAR
 * @author CHICHO
 *test pasa la alta y baja de un alumno
 */
public class AlumnoTest {

	private Alumno alumno;


	/**creo un alumno y lo guardo 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		     alumno = new Alumno("32328847","saul", "coria","1998-12-12", "4621722", "blas parera 1742");
		     alumno.save();
	}	
	
	/**pruebo si puedo insertar de nuevo el mismo alumno ya guardado
	 * se espera que retorne FALSE sino puede guardarse
	 */
	@Test
	public void guardarElMismoALumno() {
		 Assert.assertEquals(false, alumno.save());
	}
	
	// Testea que la recuperacion de un alumno sea correcta. A re loco
	@Test
	public void getAlumno() {
		assertEquals(Alumno.getAlumno(alumno.getDni()).getDni(), alumno.getDni());
	}
	
	/**pruebo si el alumno creado y guardado anteriormente ahora puedo boorrarlo
	 * 
	 */
	@After
	public void tearDown(){
		alumno.destroy();
	}

}
