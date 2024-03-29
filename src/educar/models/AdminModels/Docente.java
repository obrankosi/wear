package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

/**
 * @author grupo wear
 * Modelo {@link Docente}
 *
 */
public class Docente {

    /**
     * @param dni
     * @param name
     * @param lastName
     * @param fN
     * @param dir
     * @param tel
     */
    public Docente(String dni, String name, String lastName, String fN,
	    String dir, String tel) {
	Person(dni, name, lastName, fN, dir, tel);
    }

    /**
     * @return true ssi el guardado es exitoso
     */
    public boolean save() {
	String[] columns = { "dni_docente", "apellido_d", "nombre_d",
		"fechaNac_d", "tel_d", "direccion_d" };
	return save("Docente", columns);
    }

    /**
     * @return true ssi el borrado es exitoso
     */
    public boolean destroy() {
	return destroy("Docente");
    }

    /**
     * @param dni
     * @return
     */
    public static Docente getDocente(String dni) {
	return getPerson(dni, "Docente");
    }

    /**
     * @return {@link LinkedList} donde cada string es: DNI,NOMBRE,APELLIDO
     * @throws SQLException
     */
    public static LinkedList<String> ListDocente() throws SQLException {
	rst = jpa.proyeccion(" Docente ", " dni_docente,nombre_d, apellido_d");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1) + " " + rst.getString(2) + " "
		    + rst.getString(3));
	}
	return result;
    }

    /**
     * @return  {@link LinkedList} donde cada string es: DNI
     * @throws SQLException
     */
    public static LinkedList<String> ListDocenteDni() throws SQLException {
	rst = jpa.proyeccion(" Docente ", " dni_docente ");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1));
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
	String[] columns = { "dni_docente", "apellido_d", "nombre_d",
		"fechaNac_d", "tel_d", "direccion_d" };
	try {
	    jpa.update("Docente", columns, values, columns[0], primaryKey);
	} catch (Exception e) {
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
	    Docente.getPersonByDni(this.dni, tableName);// si la persona no
							// existe tira una ex
							// personnotfound
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

    private static Docente getPersonByDni(String dni2, String tableName)
	    throws PersonNotFound {
	ResultSet rs = null;
	Docente u = null;
	rs = jpa.getByField(tableName, "dni_docente", dni2);

	try {
	    if (rs.next()) {
		u = new Docente(rs.getString(1), rs.getString(2), rs
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
	    jpa.destroy(tableName, "dni_docente", this.getDni());
	    return true;
	} catch (SQLException e) {
	    return false;
	}

    }

    private static Docente getPerson(String dni, String tableName) {
	Docente person = null;
	try {
	    person = Docente.getPersonByDni(dni, tableName);
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
