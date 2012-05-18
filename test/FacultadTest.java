import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.AdminModels.Facultad;

/**
 * GRUPO WEAR
 * 
 * @author elian
 */
public class FacultadTest {

	private Facultad facultad;
	private Facultad facultad2;

	/**
	 * creo una facultad
	 */
	@Before
	public void setUp() {
		facultad = new Facultad("10", "Ingenieria");
		facultad2 = new Facultad("CEFQyN");
		facultad2.save();
	}

	/**
	 * este test devolvera siempre true ya que facultad.destroy() devolvera true
	 * si borra la facultad de la BD o si la facultad no existia. Solamente
	 * devuelve false si el query esta mal formado (cosa que no pasara en el
	 * programa)
	 */
	@Test
	public void borrarFacultadNoExistente() {
		assertEquals(true, facultad2.destroy());
	}

	/**
	 * este devolvera true si el cargo existente en la BD es borrado
	 */
	@Test
	public void borrarCargoExistente() {
		assertEquals(true, facultad2.destroy());
	}

	/**
	 * elimino la materia creada anteriormente el resultado esperado es TRUE si
	 * la eliminacion fue exitosa
	 */
	@After
	public void tearDown() {
		facultad.destroy();
		facultad2.destroy();
	}
}
