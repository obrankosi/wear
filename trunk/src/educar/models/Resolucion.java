package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

public class Resolucion {

    private static JPA jpa = new JPA();
    private String codResolucion;
    private String hrEnvio;
    private String fecha;
    private String dniDocente;
    private String codActividad;
    private String dniAlumno;
    private String nota;
    private String resolucion;

    /**
     * @param hrEnvio
     * @param fecha
     * @param dniDocente
     * @param codActividad
     * @param dniAlumno
     * @param resActividad
     * @param nota
     */
    public Resolucion(String hrEnvio, String fecha, String dniDocente,
	    String codActividad, String dniAlumno, String resActividad,
	    String nota) {

	this.hrEnvio = hrEnvio;
	this.fecha = fecha;
	this.dniDocente = dniDocente;
	this.codActividad = codActividad;
	this.dniAlumno = dniAlumno;
	this.resolucion = resActividad;
	this.nota = nota;
    }

    public Resolucion() {

    };

    /**
     * @param codResolucion
     * @param hrEnvio
     * @param fecha
     * @param dniDocente
     * @param codActividad
     * @param dniAlumno
     * @param resActividad
     * @param nota
     */
    public Resolucion(String codResolucion, String hrEnvio, String fecha,
	    String dniDocente, String codActividad, String dniAlumno,
	    String resActividad, String nota) {

	this.codResolucion = codResolucion;
	this.hrEnvio = hrEnvio;
	this.fecha = fecha;
	this.dniDocente = dniDocente;
	this.codActividad = codActividad;
	this.dniAlumno = dniAlumno;
	this.nota = nota;
	this.resolucion = resActividad;
    }

    /**
     * @return true ssi el guardado es exitoso
     */
    public boolean save() {
	String[] columns = { "hr_envio", "fecha_res", "dni_docente",
		" cod_actividad", "dni_alumno", "res_actividad ", "nota" };
	JPA jpa = new JPA();
	PreparedStatement stm = jpa.newRecord("educar_dev." + "Resolucion",
		columns);
	try {

	    stm.setString(1, this.getHrEnvio().trim());
	    stm.setString(2, this.getFecha().trim());
	    stm.setString(3, this.getDniDocente().trim());
	    stm.setString(4, this.getCodActividad().trim());
	    stm.setString(5, this.getDniAlumno().trim());
	    stm.setString(6, this.getResolucion().trim());
	    stm.setString(7, this.getNota().trim());

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	jpa.create(stm);
	return true;
    }

    /**
     * @return true ssi actulizacion exitosa
     */
    public boolean update() {
	String[] columns = { "res_actividad", "nota" };
	String[] values = { this.getResolucion(), this.getNota() };
	String[] columsId = { "codigo_res" };
	String[] valuesId = { this.getCodigoResolucion() };
	JPA jpa = new JPA();
	try {
	    jpa.update("Resolucion", columns, values, columsId, valuesId);
	    return true;
	} catch (SQLException e) {
	    return false;
	}

    }

    /**
     * @param codigoResolucion
     * @return {@link Resolucion} si encontro en la base de datos
     * @throws ResolucionNotFound
     *             no encotro la resolucion
     */
    public static Resolucion getResolucionByCod(String codigoResolucion)
	    throws ResolucionNotFound {
	ResultSet rst = null;
	Resolucion res = null;
	rst = jpa.getByField("Resolucion", "codigo_res", codigoResolucion);
	try {
	    if (rst.next()) {
		String codResolucion = rst.getString(1);
		String hrEnvio = rst.getString(2);
		String fecha = rst.getString(3);
		String dniDocente = rst.getString(4);
		String codActividad = rst.getString(5);
		String dniAlumno = rst.getString(6);
		String resActividad = rst.getString(7);
		String nota = rst.getString(8);
		res = new Resolucion(codResolucion, hrEnvio, fecha, dniDocente,
			codActividad, dniAlumno, resActividad, nota);
	    } else {
		throw new ResolucionNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return res;
    }

    /**
     * @param codAct
     * @return {@link LinkedList} con todas las resoluciones de la actividad
     *         null si no tiene
     */
    public static LinkedList<Resolucion> getResolucionesActividad(String codAct) {
	LinkedList<Resolucion> result = new LinkedList<Resolucion>();
	ResultSet rs = null;
	Resolucion resolucion = null;
	rs = jpa.getByField("Resolucion", "cod_actividad", codAct);
	try {
	    while (rs.next()) {
		String codResolucion = rs.getString(1);
		String hrEnvio = rs.getString(2);
		String fecha = rs.getString(3);
		String dniDocente = rs.getString(4);
		String codActividad = rs.getString(5);
		String dniAlumno = rs.getString(6);
		String resActividad = rs.getString(7);
		String nota = rs.getString(8);
		resolucion = new Resolucion(codResolucion, hrEnvio, fecha,
			dniDocente, codActividad, dniAlumno, resActividad, nota);
		result.add(resolucion);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    result = null;
	}
	return result;
    }

    public boolean pertenece() {
	String[] fieldNames = { "dni_alumno", "cod_actividad" };
	String[] values = { dniAlumno, codActividad };
	ResultSet res = jpa.getByField("Resolucion", fieldNames, values);
	try {
	    if (res.next()) {
		if ((res.getString(5).compareTo(dniAlumno) == 0)
			&& (res.getString(6).compareTo(codActividad) == 0)) {
		    return true;
		}
	    }
	} catch (SQLException e) {
	    return false;
	}
	return false;
    }

    public String getNota(String dniAlumno, String codActividad) {
	String[] fieldNames = { "dni_alumno", "cod_actividad" };
	String[] values = { dniAlumno, codActividad };
	ResultSet res = jpa.getByField("Resolucion", fieldNames, values);
	try {
	    if (res.next()) {
		if ((res.getString(5).compareTo(dniAlumno) == 0)
			&& (res.getString(6).compareTo(codActividad) == 0)) {
		    return res.getString(8);
		}
	    }
	} catch (SQLException e) {
	    return "0";
	}
	return "0";
    }
    public String getFecha(String dniAlumno,String codActividad) {
		String[] fieldNames = { "dni_alumno", "cod_actividad" };
		String[] values = { dniAlumno, codActividad };
		ResultSet res = jpa.getByField("Resolucion", fieldNames, values);
		try {
			if (res.next()) {
				if ((res.getString(5).compareTo(dniAlumno) == 0)
						&& (res.getString(6).compareTo(codActividad) == 0)) {
					return res.getString(3)+" Hora: "+res.getString(2);
				}
			}
		} catch (SQLException e) {
			return "0";
		}
		return "0";
	}


    public void setNota(String nota) {
	this.nota = nota;
    }

    public String getNota() {
	return this.nota;
    }

    public void setDniAlumno(String dniAlumno) {
	this.dniAlumno = dniAlumno;
    }

    public String getDniAlumno() {
	return this.dniAlumno;
    }

    public void setCodAtividad(String codActividad) {
	this.codActividad = codActividad;
    }

    public String getCodActividad() {
	return this.codActividad;
    }

    public void setDniDocente(String dniDocente) {
	this.dniDocente = dniDocente;
    }

    public String getDniDocente() {
	return this.dniDocente;
    }

    public void setFecha(String fecha) {
	this.fecha = fecha;
    }

    public String getFecha() {
	return this.fecha;
    }

    public void setHrEnvio(String hrEnvio) {
	this.hrEnvio = hrEnvio;
    }

    public String getHrEnvio() {
	return this.hrEnvio;
    }

    public void setCodResolucion(String codResolucion) {
	this.codResolucion = codResolucion;
    }

    public String getCodigoResolucion() {
	return this.codResolucion;
    }

    public void setResolucion(String resolucion) {
	this.resolucion = resolucion;
    }

    public String getResolucion() {
	return resolucion;
    }
}
