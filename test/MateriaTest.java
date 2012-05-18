import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.AdminModels.Subject;


/** 
 * @author GRUPO WEAR
 * test de creacion,alta y borrado de una  Materia
 */
public class MateriaTest {

	private Subject  materia;

	/**creo una materia 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		 materia = new Subject("calculo","1");
				
	}	
	
	/**creo una materia y la guardo
	 * el resultado esperado es TRUE si se guardo con exito
	 */
	@Test
	public void guardadoDeMAteria() {
       	Assert.assertEquals(true, materia.save());
	}


	/**elimino la materia creada anteriormente
	 * 
	 */
	@After
	public void tearDown(){
		materia.delete();
	}
}
