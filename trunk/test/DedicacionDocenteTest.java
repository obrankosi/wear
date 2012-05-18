import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import educar.models.AdminModels.Cargos;
import educar.models.AdminModels.DedicacionDocente;
import educar.models.AdminModels.Docente;
import educar.models.AdminModels.Facultad;

public class DedicacionDocenteTest {

    private static Docente docente;
    private static Facultad facultad;
    private static Cargos cargo;
    private static DedicacionDocente newTest;

    @BeforeClass
    public void cargarDatos() {
	String dni = "31454090";
	String name = "German";
	String lastName = "Castro";
	String fN = "1982-02-11";
	String dir = "dinkeldein 1497";
	String tel = "4627163";
	Docente docente = new Docente(dni, name, lastName, fN, dir, tel);
	docente.save();

	String codigo = "50";
	String descripcion = " Actividad : hacer test para que pueda aprobar la materia";
	Facultad facultad = new Facultad(codigo, descripcion);
	facultad.save();

	String codigoCargo = "40";
	String nombreCargo = "Director de Facultad";
	Cargos cargo = new Cargos(codigoCargo, nombreCargo);
	cargo.save();

	String codFacultad = codigo;
	String dniDocente = dni;
	String codCargo = codigoCargo;
	String hsDedicacion = "46";
	DedicacionDocente newTest = new DedicacionDocente(codFacultad,
		dniDocente, codCargo, hsDedicacion);
    }

    @Test
    public void alta() {
	assertTrue(newTest.save());

    }

    @Test
    public void baja() {
	assertTrue(newTest.delete());
	assertTrue(cargo.destroy());
	assertTrue(facultad.destroy());
	assertTrue(docente.destroy());
    }

    @After
    public void BorrarDatosCargados() {
	if (newTest != null && cargo != null && facultad != null
		&& docente != null) {
	    newTest.delete();
	    cargo.destroy();
	    facultad.destroy();
	    docente.destroy();
	}
    }

}
