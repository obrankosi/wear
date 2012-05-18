import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.Actividad;

/**
 * GRUPO WEAR
 * 
 * @author elian
 */
public class ActividadTest {

	private Actividad actividad;
	private Actividad actividadNoExistente;

	/**
	 * creo actividades
	 */
	@Before
	public void setUp() {
		actividad = new Actividad("Hacer algoritmo busqueda", "1");
		actividad.save();
		actividadNoExistente = new Actividad("6","No hacer nada","2");
	}

	/**
	 * devuelve true si se almacena correctamente la actividad
	 */
	@Test
	public void almacenarActividad() {
		assertEquals(true, actividadNoExistente.save());
	}

	/**
	 * este devolvera true si el la actividad existente en la BD es borrada exitosamente
	 */
	@Test
	public void borrarActividadExistente() {
		assertEquals(true, actividad.deleteActividad());
	}

	/**
	 * deleteActividad() retorna true si la actividad fue borrada de la BD o si no existia, por lo
	 * que siempre retornara true
	 */
	@Test
	public void borrarActividadNoExistente() {
		assertEquals(true, actividadNoExistente.deleteActividad());
	}
	
	/**
	 * elimino las actividades creadas anteriormente
	 */
	
	@After
	public void tearDown() {
		actividad.deleteActividad();
		actividadNoExistente.deleteActividad();
	}
}
