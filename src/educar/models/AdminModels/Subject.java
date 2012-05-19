package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

/**
 * @author grupo wear Modelo {@link Subject}
 */
public class Subject implements Comparable<Subject> {

    private String subjectCode;
    private String subjectName;
    private String responsableTeacher;
    private String facultad;
    private static JPA jpa = new JPA();
    private static ResultSet rst;

    /**
     * @param code
     * @param name
     * @param responsable
     * @param facultad
     */
    public Subject(String code, String name, String responsable, String facultad) {
	this.subjectCode = code;
	this.subjectName = name;
	this.responsableTeacher = responsable;
	this.facultad = facultad;
    }

    /**
     * @param code
     * @param name
     * @param responsable
     */
    public Subject(String code, String name, String responsable) {
	this.subjectCode = code;
	this.subjectName = name;
	this.responsableTeacher = responsable;
    }

    /**
     * @param name
     * @param codFacultad
     */
    public Subject(String name, String codFacultad) {
	this.subjectName = name;
	this.facultad = codFacultad;
	this.responsableTeacher = null;
    }

    /**
     * setea con null el campo en la bd
     * 
     * @param column
     * @throws SQLException
     */
    public void updateNullDni(String column) throws SQLException {
	String columnKey = "cod_materia";
	String primaryKey = this.getCode();
	try {
	    jpa.updateNull("Materia", column, columnKey, primaryKey);
	} catch (SQLException e) {
	    throw new SQLException();
	}

    }

    /**
     * @throws SQLException
     */
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

    /**
     * @param values
     *            arreglo de valores
     * @param primaryKey
     * @throws SQLException
     */
    public static void update(String[] values, String primaryKey)
	    throws SQLException {
	String[] columns = { "cod_materia", "nombre_mat", "dni_docente",
		"facultad" };
	try {
	    jpa.update("Materia", columns, values, columns[0], primaryKey);
	} catch (Exception e) {
	    throw new SQLException();

	}

    }

    /**
     * @param columns
     * @param values
     * @param primaryKey
     * @throws SQLException
     *             NOTA: columna : valor , columna2 : valor2 tiene que concidir
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

    /**
     * @return {@link LinkedList}
     * @throws SQLException
     */
    public static LinkedList<String> subjectCodesList() throws SQLException {
	rst = jpa.proyeccion(" Materia ", "cod_materia ");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1));
	}
	return result;
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

    public boolean delete() {
	return this.destroy("Materia");
    }

    /**
     * @param dniEncargado
     * @return {@link LinkedList} con las materias que el docente es encargado
     */
    public static LinkedList<Subject> getSubjectsByDniE(String dniEncargado) {
	LinkedList<Subject> newList = new LinkedList<Subject>();
	ResultSet rs = null;
	Subject u = null;
	rs = jpa.getByField("Materia", "dni_docente", dniEncargado);
	try {
	    while (rs.next()) {
		u = new Subject(rs.getString(1), rs.getString(2), rs
			.getString(3), rs.getString(4));
		newList.add(u);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    newList = null;
	}
	return newList;
    }

    @Override
    public int compareTo(Subject o) {
	if ((o.getCode().compareTo(this.getCode()) == 0)
		&& (o.getCodigoFacultad().compareTo(this.getCodigoFacultad()) == 0)
		&& (o.getName().compareTo(this.getName()) == 0)
		&& (o.getRTeacher().compareTo(this.getRTeacher()) == 0)) {
	    return 0;
	} else
	    return 1;
    }

    public static  boolean contenido(LinkedList<Subject> list, Subject materia) {
	boolean encontre = false;
	Subject newMateria;
	for (int i = 0; i < list.size() && !encontre; i++) {
	    newMateria = list.get(i);
	    if (newMateria.compareTo(materia) == 0)
		encontre = true;
	}

	return encontre;
    }

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

    public String getCode() {
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

    public String getCodigoFacultad() {
	return facultad;
    }

    public void setNullDocente() {
	this.responsableTeacher = null;
    }

}
