package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

/**
 * @author grupo wear
 * Modelo {@link AsignacionDocente}
 *
 */
public class AsignacionDocente {

    private String codMateria;
    private String dniDocente;

    private static ResultSet rst;
    private static JPA jpa = new JPA();

    /**
     * @param materia
     * @param docente
     */
    public AsignacionDocente(String materia, String docente) {
	this.codMateria = materia;
	this.dniDocente = docente;
    }

    /**
     * @return true ssi borrado exitoso
     */
    public boolean save() {
	String[] columns = { "dni_doc", "cod_mat" };
	PreparedStatement stm = jpa.newRecord("educar_dev." + "Dicta", columns);
	try {
	    stm.setString(1, dniDocente);
	    stm.setString(2, codMateria);
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	jpa.create(stm);
	return true;
    }

    /**
     * @return true ssi borrado exitoso
     */
    public boolean delete() {
	return destroy("Dicta");
    }

    /**
     * @param codMateria
     * @return {@link LinkedList} codigos docentes asignados sin el responsable
     */
    public static LinkedList<String> getDocentesAsignados(String codMateria) {
	LinkedList<String> result = new LinkedList<String>();
	JPA jpa = new JPA();
	rst = jpa.proyeccion("Dicta", "dni_doc", "cod_mat", codMateria);
	try {
	    while (rst.next()) {
		String dniD = rst.getString(1);
		result.add((dniD).trim());
	    }
	} catch (SQLException e) {
	    System.out.println("erro en la consulta en la base de datos");
	    return null;
	}
	return result;

    }

    /**
     * @param dniDocente
     * @param codMateria
     * @return {@link AsignacionDocente}
     */
    public static AsignacionDocente getAsignacionDocente(String dniDocente,
	    String codMateria) {
	try {
	    return getAsignacionDocenteByCode(dniDocente, codMateria);
	} catch (AsignacionDocenteNotFound e) {
	    return null;
	}

    }

    private boolean destroy(String tableName) {
	try {
	    String[] column = { "dni_doc", "cod_mat" };
	    String[] values = { this.getDniDocente(), this.getCodMateria() };
	    jpa.destroy(tableName, column, values);
	    return true;
	} catch (SQLException e) {
	    return false;
	}
    }

    private static AsignacionDocente getAsignacionDocenteByCode(
	    String dniDocente2, String codMateria2)
	    throws AsignacionDocenteNotFound {
	ResultSet rs = null;
	AsignacionDocente u = null;
	String[] column = { "dni_doc", "cod_mat" };
	String[] values = { dniDocente2, codMateria2 };
	rs = jpa.getByField("Dicta", column, values);
	try {
	    if (rs.next()) {
		u = new AsignacionDocente(rs.getString(2), rs.getString(1));
	    } else {
		throw new AsignacionDocenteNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return u;

    }

    public String getCodMateria() {
	return codMateria;
    }

    public String getDniDocente() {
	return dniDocente;
    }
}
