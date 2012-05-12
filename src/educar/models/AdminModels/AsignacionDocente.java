package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import educar.db.JPA;

public class AsignacionDocente {

    private Subject materia;
    private Docente docente;

    private String codMateria;
    private String dniDocente;

    private static JPA jpa = new JPA();

    /**
     * @param materia
     * @param docente
     */

    public AsignacionDocente(String materia, String docente) {
	this.codMateria = materia;
	this.dniDocente = docente;
    }

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

    public boolean delete() {
	return destroy("Dicta");
    }

    private boolean destroy(String tableName) {
	try {
	    String[] column = { "dni_doc", "cod_mat" };
	    String[] values = { this.getDniDocente(), this.getCodMateria() };
	    jpa.destroy(tableName,column, values);
	    return true;
	} catch (SQLException e) {
	    return false;
	}
    }

    public static AsignacionDocente getAsignacionDocente(String dniDocente,
	    String codMateria) {
	try {
	    return getAsignacionDocenteByCode(dniDocente, codMateria);
	} catch (AsignacionDocenteNotFound e) {
	    return null;
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
		u = new AsignacionDocente( rs.getString(2),rs.getString(1));
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
