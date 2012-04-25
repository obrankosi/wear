package educar.models;

import java.sql.Date;

import educar.db.JPA;

public class Person {

    private String nombre;
    private String apellido;
    private Date fNacimiento;
    private Integer dni;
    private String tel;
    private String direccion;
    private static JPA jpa = new JPA();

    private String username;
    private String password;
    private String role;

    public Person(Integer dni, String nombre, String apellido, String dir,
	    Date fN, String tel) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.fNacimiento = fN;
	this.dni = dni;
	this.tel = tel;
	this.direccion = dir;
    }
}