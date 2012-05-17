package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

public class TieneActividad {

    private static ResultSet rst;
    private String dniAlumno;
    private String codActividad;

    /**
     * @param dniAlumno
     * @param codAcitividad
     */
    public TieneActividad(String dniAlumno, String codAcitividad) {
	this.dniAlumno = dniAlumno;
	this.codActividad = codAcitividad;

    }

    /**
     * @return true ssi el guardado fue exitoso
     */
    public boolean save() {
	String[] columns = { "dni_alumno", "codigo_a" };
	JPA jpa = new JPA();
	PreparedStatement stm = jpa.newRecord("educar_dev." + "TieneActividad",
		columns);
	try {
	    stm.setString(1, this.getDniAlumno().trim());
	    stm.setString(2, this.getCodActividad().trim());
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	jpa.create(stm);
	return true;

    }

    /**
     * @param dniAlumno
     * @return {@link LinkedList} numero de actividades
     * 
     */
    public static LinkedList<String> listaActividadesAlumnos(String dniAlumno) {
	LinkedList<String> result = new LinkedList<String>();
	JPA jpa = new JPA();
	rst = jpa.proyeccion("TieneActividad", "codigo_a", "dni_alumno",
		dniAlumno);
	try {
	    while (rst.next()) {
		String codA = rst.getString(1);
		result.add((codA).trim());
	    }
	} catch (SQLException e) {
	    System.out.println("erro en la consulta en la base de datos");
	    return null;
	}
	return result;
    }

    public String getDniAlumno() {
	return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
	this.dniAlumno = dniAlumno;
    }

    public String getCodActividad() {
	return codActividad;
    }

    public void setCodActividad(String codActividad) {
	this.codActividad = codActividad;
    }

}
