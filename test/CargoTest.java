import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import educar.models.AdminModels.Cargos;
import educar.models.AdminModels.Subject;

/**
 * GRUPO WEAR
 * 
 * @author CHICHO test de creacion,alta y borrado de una Materia
 */
public class CargoTest {

	private Cargos cargo;
	private Cargos cargo2;

	/**
	 * creo un cargo
	 */
	@Before
	public void setUp() {
		cargo = new Cargos("6", "Decano");
		cargo2 = new Cargos("9", "Rector");
		cargo2.save();
	}

	/**
	 * este test devolvera siempre true ya que cargo.destroy() devolvera true si
	 * borra el cargo de la BD o si el cargo no existia. Solamente devuelve
	 * false si el query esta mal formado (cosa que no pasara en el programa)
	 */
	@Test
	public void borrarCargoNoExistente() {
		assertEquals(true, cargo.destroy());
	}

	/**
	 * este devolvera true si el cargo existente en la BD es borrado
	 */
	@Test
	public void borrarCargoExistente() {
		assertEquals(true, cargo2.destroy());
	}

	/**
	 * elimino la materia creada anteriormente el resultado esperado es TRUE si
	 * la eliminacion fue exitosa
	 */
	@After
	public void tearDown() {
		cargo.destroy();
		cargo2.destroy();
	}
}
