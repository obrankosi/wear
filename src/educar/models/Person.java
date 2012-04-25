package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import educar.db.JPA;

public class Person {

    private String name;
    private String lastName;
    private String fN;
    private String age;
    private String dni;
    private String tel;
    private String dir;
    private static JPA jpa = new JPA();

    public Person(String dni, String name, String lastName, String fN,
	    String age, String dir, String tel) {
	this.name = name;
	this.lastName = lastName;
	this.fN = fN;
	this.dni = dni;
	this.tel = tel;
	this.dir = dir;
	this.age = age;
    }

    /*
     * Guarda una persona dar como parametro la tabla donde se guarda (docente ,
     * alumno) Return True ssi el borrado fues exitoso
     */
    public boolean save(String tableName) {
	try {
	    Person.getPersonByDni(dni, tableName);
	    return false;
	} catch (PersonNotFound e1) {
	    String[] columns = { "username", "password", "role" };

	    PreparedStatement stm = jpa.newRecord("educar_dev." + tableName,
		    columns);

	    try {
		stm.setString(1, name);
		stm.setString(2, lastName);
		stm.setString(3, fN);
		stm.setString(1, age);
		stm.setString(1, dir);
		stm.setString(1, tel);
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
    private static Person getPersonByDni(String dni2, String tableName)
	    throws PersonNotFound {
	// TODO Auto-generated method stub
	ResultSet rs = null;
	Person u = null;
	rs = jpa.getByField(tableName, "dni", dni2);

	try {
	    if (rs.next()) {
		u = new Person(rs.getString(1), rs.getString(2), rs
			.getString(3), rs.getString(4), rs.getString(5), rs
			.getString(6), rs.getString(7));
	    } else {
		throw new PersonNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return u;
    }

    /*
     * borra una persona entera por dni ,Return True ssi el borrado fues exitoso
     */
    public boolean destroy(String tableName) {
	try {
	    Person.getPersonByDni(this.getDni(), tableName);
	    return false;
	} catch (PersonNotFound e1) {
	    if (tableName.compareTo("Alumnos") == 0)
		jpa.destroy(tableName, "dni_a", this.getDni());
	    else
		jpa.destroy(tableName, "dni_docente", this.getDni());
	    return true;
	}
    }

    /*
     * Return una persona buscada por dni null en el caso que no exista;
     */

    public Person getPerson(String dni, String tableName) {
	Person person = null;
	try {
	    person = Person.getPersonByDni(dni, tableName);
	    return person;
	} catch (PersonNotFound e) {
	    // TODO Auto-generated catch block
	    return person;
	}
    }

    public String getDni() {
	// TODO Auto-generated method stub
	return dni;
    }

    public String getAge() {
	return age;
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

    public void setAge(String age) {
	this.age = age;
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