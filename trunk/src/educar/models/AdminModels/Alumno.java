package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

public class Alumno {

    /**
     * @param dni
     * @param name
     * @param lastName
     * @param fN
     * @param dir
     * @param tel
     */
    public Alumno(String dni, String name, String lastName, String fN,
	    String dir, String tel) {
	Person(dni, name, lastName, fN, dir, tel);
    }

    /**
     * @retur true ssi guardado exitoso
     */
    public boolean save() {
	String[] columns = { "dni", "apellido_a", "nombre_a", "fechaNac_a",
		"telefono_a", "direccion_a" };
	return save("Alumnos", columns);
    }

    /**
     * @return  true ssi borrado exitoso
     */
    public boolean destroy() {
	return destroy("Alumnos");
    }

    /**
     * @param dni
     * @return Alumno
     */
    public static Alumno getAlumno(String dni) {
	return getPerson(dni, "Alumnos");
    }

    /**
     * @return {@link LinkedList} donde cada string es: DNI,NOMBRE,APELLIDO
     * @throws SQLException
     */
    public static LinkedList<String> ListAlumnos() throws SQLException {
	rst = jpa.proyeccion(" Alumnos ", " dni,nombre_a , apellido_a");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1) + " " + rst.getString(2) + " "
		    + rst.getString(3));
	}
	return result;
    }

    /**
     * @param values
     * @param primaryKey
     * @throws SQLException 
     */
    public static void update(String[] values, String primaryKey)
	    throws SQLException {
	String[] columns = { "dni", "apellido_a", "nombre_a", "fechaNac_a",
		"telefono_a", "direccion_a" };
	try {
	    jpa.update("Alumnos", columns, values, columns[0], primaryKey);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();
	}

    }

    private String name;
    private String lastName;
    private String fN;
    private String dni;
    private String tel;
    private String dir;
    private static JPA jpa = new JPA();
    private static ResultSet rst;

    private void Person(String dni, String lastName, String name, String fN,
	    String tel, String dir) {
	this.name = name;
	this.lastName = lastName;
	this.fN = fN;
	this.dni = dni;
	this.tel = tel;
	this.dir = dir;
    }

    
    private boolean save(String tableName, String[] nameColumns) {
	try {
	    Alumno.getPersonByDni(this.dni, tableName);
	    return false;
	} catch (PersonNotFound e1) {
	    String[] columns = nameColumns;
	    PreparedStatement stm = jpa.newRecord("educar_dev." + tableName,
		    columns);
	    try {
		stm.setString(1, dni);
		stm.setString(2, name);
		stm.setString(3, lastName);
		stm.setString(4, fN);
		stm.setString(5, tel);
		stm.setString(6, dir);
	    } catch (SQLException e) {
		e.printStackTrace();
		return false;
	    }

	    jpa.create(stm);
	    return true;
	}

    }

    /*
     * dni a buscar, nombre de la tabla, nombre de la columna
     */
    private static Alumno getPersonByDni(String dni2, String tableName)
	    throws PersonNotFound {
	// TODO Auto-generated method stub
	ResultSet rs = null;
	Alumno u = null;
	rs = jpa.getByField(tableName, "dni", dni2);

	try {
	    if (rs.next()) {
		u = new Alumno(rs.getString(1), rs.getString(2), rs
			.getString(3), rs.getString(4), rs.getString(5), rs
			.getString(6));
	    } else {
		throw new PersonNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return u;
    }

    private boolean destroy(String tableName) {
	try {
	    jpa.destroy(tableName, "dni", this.getDni());
	    return true;
	} catch (SQLException e) {
	    return false;
	}

    }

    private static Alumno getPerson(String dni, String tableName) {
	Alumno person = null;
	try {
	    person = Alumno.getPersonByDni(dni, tableName);
	    return person;
	} catch (PersonNotFound e) {
	    return person;
	}
    }


    public String getDni() {
	return dni;
    }

    public String getDir() {
	return dir;
    }

    public String getfN() {
	return fN;
    }

    public void setTel(String tel) {
	this.tel = tel;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setfN(String fN) {
	this.fN = fN;
    }

    public void setDni(String dni) {
	this.dni = dni;
    }

    public void setDir(String dir) {
	this.dir = dir;
    }

    public String getTel() {
	return tel;
    }

    public String getName() {
	return name;
    }

    public String getLastName() {
	return lastName;
    }

}
