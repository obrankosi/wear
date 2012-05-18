import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.AdminModels.AsignacionDocente;
import educar.models.AdminModels.Docente;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.Subject;


/**
 * @author GRUPO WEAR 
 *creacion y eliminacon de una asignacion
 */
public class AsignacionDocenteTest {

	
	private AsignacionDocente dicta;
	private Docente docente;
	private Subject materia;
	private Facultad facultad;


	/**crea una asinacion docente
	 *
	 */
	@Before
	public void setUp() {
		docente= new Docente("27693874","Juan", "Castro","1984-12-12","12456","4621");
		docente.save();
		facultad=new Facultad("exaxtas");
		facultad.save();
		materia = new Subject("quimica",docente.getDni(),facultad.getCodigo());
		materia.save(); 		
		dicta = new AsignacionDocente(materia.getCode(),docente.getDni());
		
	}	

	@Test
	public void guardarFacultad()   {
		Assert.assertEquals(true,facultad.save());  	
	}

	
	@Test
	public void guardarMateria()   {
		Assert.assertEquals(true,materia.save());  	
	}

	/**guarda una asignacion creada anteriormente
	 * 
	 */
	@Test
	public void guardarDicata()   {
		Assert.assertEquals(true,dicta.save());  	
	}

	/**elimina la asinacion guardada
	 * tambien elimina los demas objetos creados
	 */
	@After
	public void tearDown(){
		docente.destroy();
		facultad.destroy();
		materia.delete();
		dicta.delete();
		
	}

}
