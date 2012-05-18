import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.AdminModels.Docente;

/**
 * GRUPO WEAR
 * 
 * @author elian test para la alta y baja de un docente
 */
public class DocenteTest {

	private Docente docente;
	private Docente docente2;

	/**
	 * creo un docente y lo almaceno
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		docente = new Docente("35543985", "juan", "perez", "1978-05-11",
				"254437", "kowalk 328");

		docente.save();
	}

	/**
	 * intento insertar 2 veces el mismo docente
	 */
	@Test
	public void guardarDosVecesElMismoDocente() {
		assertEquals(false, docente.save());
	}

	/**
	 * intento insertar otro docente con el mismo dni (para que se considere como
	 * otro docente debe tener si o si un dni diferente)
	 */
	@Test
	public void guardarDosVecesUnDocente() {
		docente2 = new Docente("35543985", "elian", "marchisio", "1998-09-28",
				"72358", "lavalle 490");
		assertEquals(false, docente2.save());
	}

	/**
	 * elimino el docente creado para realizar el test
	 */
	@After
	public void tearDown() {
		docente.destroy();

	}

}
