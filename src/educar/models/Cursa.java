package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;
import educar.models.AdminModels.CargosNotFound;
import educar.models.AdminModels.Subject;

/**
 * @author grupo wear Modelo {@link Cursa}
 * 
 */
public class Cursa {

    private static JPA jpa = new JPA();
    private String dniAlumno;
    private String codMateria;

    /**
     * @param dniAlumno
     * @param codMateria
     */
    public Cursa(String dniAlumno, String codMateria) {
	this.setDniAlumno(dniAlumno);
	this.setCodMateria(codMateria);
    }

    /**
     * @return true ssi guardado exitiso
     */
    public boolean save() { // guardar la materia que cursa un alumno
	String[] columns = { "dni_a", "cod_mat" };
	try {
	    return save("cursa", columns);
	} catch (CargosNotFound e) {
	    return false;
	}
    }

    /**
     * @return true ssi pertenece 
     */
    public boolean pertenece() {
	String[] fieldNames = { "dni_a", "cod_mat" };
	String[] values = { dniAlumno, codMateria };
	ResultSet res = jpa.getByField("cursa", fieldNames, values);
	try {
	    if (res.next()) {
		if ((res.getString(1).compareTo(dniAlumno) == 0)
			&& (res.getString(2).compareTo(codMateria) == 0)) {
		    return true;
		}
	    }
	} catch (SQLException e) {
	    return false;
	}
	return false;
    }

    /**
     * @param id
     * @return {@link LinkedList} {@link String} materias que cursa un alumno 
     * @throws SQLException 
     */
    public static LinkedList<String> cursaList(String id) throws SQLException {
	ResultSet rst = jpa.proyeccion("cursa", "dni_a,cod_mat", "dni_a", id);
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(2) + "  |   "
		    + Subject.getSubject(rst.getString(2)).getName());
	}
	return result;
    }

    /**
     * @param codMateria
     * @return {@link LinkedList} alumnos que cursan la materia
     * @throws SQLException
     *             si
     */
    public static LinkedList<String> alumnosCursanMateria(String codMateria) {
	ResultSet rst = jpa.proyeccion("cursa", "dni_a", "cod_mat", codMateria);
	LinkedList<String> result = new LinkedList<String>();
	try {
	    while (rst.next()) {
		result.add(rst.getString(1));
	    }
	} catch (SQLException e) {
	    result = null;
	}
	return result;
    }

    public String getDniAlumno() {
	return dniAlumno;
    }

    
    private boolean save(String tableName, String[] columns)
	    throws CargosNotFound {
	try {
	    String[] column = columns;
	    PreparedStatement stm = jpa.newRecord("educar_dev." + tableName,
		    column);
	    stm.setString(1, dniAlumno);
	    stm.setString(2, codMateria);
	    jpa.create(stm);
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
    }

    private void setCodMateria(String codMateria) {
	this.codMateria = codMateria;
    }

    private void setDniAlumno(String dniAlumno) {
	this.dniAlumno = dniAlumno;
    }

    
}