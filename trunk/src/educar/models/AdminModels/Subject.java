package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

public class Subject {

    private static String subjectCode;
    private String subjectName;
    private String responsableTeacher;
    private String facultad;
    private static JPA jpa = new JPA();
    private static ResultSet rst;

    public void updateNullDni(String column) throws SQLException {
	String columnKey = "cod_materia";
	String primaryKey = this.getCode();
	try {
	    jpa.updateNull("Materia", column, columnKey, primaryKey);
	} catch (SQLException e) {
	    throw new SQLException();
	}

    }

    public void update() throws SQLException {
	String[] columns = { "nombre_mat", "dni_docente", "facultad" };
	String[] values = { this.getName(), this.getRTeacher(),
		this.getCodigoFacultad() };
	String columnKey = "cod_materia";
	String primaryKey = this.getCode();
	try {
	    jpa.update("Materia", columns, values, columnKey, primaryKey);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();

	}

    }

    public static void update(String[] values, String primaryKey)
	    throws SQLException {
	String[] columns = { "cod_materia", "nombre_mat", "dni_docente",
		"facultad" };
	try {
	    jpa.update("Materia", columns, values, columns[0], primaryKey);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();

	}

    }

    /**
     * @param columns
     * @param values
     * @param primaryKey
     * @throws SQLException
     *             IMPORTANTE: columna : valor , columna2 : valor2 tine que
     *             concidir
     */
    public static void update(String[] columns, String[] values,
	    String columnKey, String primaryKey) throws SQLException {
	try {
	    jpa.update("Materia", columns, values, columnKey, primaryKey);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();

	}

    }

    public Subject(String code, String name, String responsable, String facultad) {
	this.subjectCode = code;
	this.subjectName = name;
	this.responsableTeacher = responsable;
	this.facultad = facultad;
    }

    public Subject(String code, String name, String responsable) {
	this.subjectCode = code;
	this.subjectName = name;
	this.responsableTeacher = responsable;
    }

    public Subject(String name, String codFacultad) {
	this.subjectName = name;
	this.facultad = codFacultad;
	this.responsableTeacher = null;
    }

    /**
     * @param tableName
     * @return true ssi inserto correctamente la materia
     */
    public boolean save() {
	String[] columns = { "nombre_mat", "dni_docente", "facultad" };
	PreparedStatement stm = jpa.newRecord("educar_dev." + "Materia",
		columns);
	try {
	    stm.setString(1, subjectName);
	    stm.setString(2, responsableTeacher);
	    stm.setString(3, facultad);
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	jpa.create(stm);
	return true;
    }

    /**
     * @param CodeSubject
     * @return materia ssi encontro, sino null
     */
    public static Subject getSubject(String CodeSubject) {
	try {
	    return getSubjectByCode(CodeSubject);
	} catch (SubjectNotFound e) {
	    return null;
	}
    }

    /*
     * retorna una lista de string donde cada string es: DNI,NOMBRE,APELLIDO
     * para poder mostrarlo en una lista
     */
    public static LinkedList<String> subjectCodesList() throws SQLException {
	rst = jpa.proyeccion(" Materia ", "cod_materia ");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1));
	}
	return result;
    }

    /*
     * busca en la BD una materia por su codigo (es unico)
     */
    private static Subject getSubjectByCode(String codMateria)
	    throws SubjectNotFound {

	ResultSet rs = null;
	Subject u = null;
	rs = jpa.getByField("Materia", "cod_materia", codMateria);
	try {
	    if (rs.next()) {
		u = new Subject(rs.getString(1), rs.getString(2), rs
			.getString(3), rs.getString(4));
	    } else {
		throw new SubjectNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return u;
    }

    /*
     * borra una materia por su codigo, retorna true ssi el borrado fue exitoso
     * si la materia no existe, retorna false
     */
    public boolean delete() {
	return this.destroy("Materia");
    }

    /*
     * borra una Materia entera por cod_mat, Return True ssi el borrado fues
     * exitoso supongo que la materia a borrar existe
     */
    private boolean destroy(String tableName) {
	try {
	    jpa.destroy(tableName, "cod_materia", this.getCode());
	    return true;
	} catch (SQLException e) {
	    return false;
	}

    }

    public void setCode(String code) {
	this.subjectCode = code;
    }

    public static String getCode() {
	return subjectCode;
    }

    public void setName(String name) {
	this.subjectName = name;
    }

    public String getName() {
	return this.subjectName;
    }

    public void setRTeacher(String teacher) {
	this.responsableTeacher = teacher;
    }

    public String getRTeacher() {
	return this.responsableTeacher;
    }

    /**
     * @return lista Materias {...cod_materia,nombre,cod_facultad...}
     * @throws SQLException
     */
    public static LinkedList<String> subjectList() throws SQLException {
	rst = jpa.proyeccion("Materia", "cod_materia,nombre_mat,facultad");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1) + " " + rst.getString(2) + " "
		    + rst.getString(3));
	}
	return result;
    }

    public String getCodigoFacultad() {
	return facultad;
    }

    public void setNullDocente() {
	this.responsableTeacher = null;
    }
}
