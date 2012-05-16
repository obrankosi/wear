package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;


/**
 * @author Elian
 *
 */
public class Actividad {

	private static JPA jpa = new JPA();
	private static String codigoActividad;
	private String descripcionActividad;
	private String codigoMateria;

	/**
	 * @param codigoActividad
	 * @param descripcionActividad
	 * @param codMateria
	 */
	public Actividad(String codigoActividad, String descripcionActividad,
			String codMateria) {
		this.setCodigoActividad(codigoActividad);
		this.setDescripcionActividad(descripcionActividad);
		this.setCodigoMateria(codMateria);
	}

	// utilizo este constructor para almacenar en la base de datos. Como el
	// codigo
	// de la materia es auto-incremental, no debo pasarselo a la hora de hacer
	// el save
	
	/**
	 * @param descripcionActiv
	 * @param codMateria
	 */
	public Actividad(String descripcionActiv, String codMateria) {
		this.setDescripcionActividad(descripcionActiv);
		this.setCodigoMateria(codMateria);
	}

	private void setCodigoMateria(String codigo) {
		// TODO Auto-generated method stub
		this.codigoMateria = codigo;
	}

	private void setDescripcionActividad(String descripcionActividad) {
		// TODO Auto-generated method stub
		this.descripcionActividad = descripcionActividad;
	}

	private void setCodigoActividad(String codigoAtividad) {
		// TODO Auto-generated method stub
		this.codigoActividad = codigoAtividad;
	}

	private String getCodigoMateria() {
		return codigoMateria;
	}

	private String getDescripcionActividad() {
		return descripcionActividad;
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	// guarda una materia. Si la materia ya existia, retorna false
	// Si la materia no existia, la guarda en la BD y retorna true
	public boolean save() {
		try {
			String[] columnas = { "descripcion_act", "cod_materia" };
			PreparedStatement stm = jpa.newRecord("educar_dev." + "Actividad",
					columnas);

			stm.setString(1, descripcionActividad);
			stm.setString(2, codigoMateria);
			jpa.create(stm);
			return true;
		} catch (SQLException e) {
			return false;// TODO Auto-generated catch block
		}
	}

	// dado el codigo de una actividad: si esta existe, devuelve dicha
	// actividad, sino, retorna null
	public static Actividad getActividad() {
		try {
			ResultSet rs = null;
			Actividad act = null;
			rs = jpa.getByField("Actividad", "cod_actividad", codigoActividad);

			if (rs.next()) {
				act = new Actividad(rs.getString(1), rs.getString(2),
						rs.getString(3));
			}
			return act;
		} catch (SQLException e) {
			return null;
		}

	}

	// dado el codigo de una actividad, si existe en la BD, la borra y retorna true
	// si no existe, retorna false
	public boolean deleteActividad() {
		try {
			jpa.destroy("Actividad", "cod_actividad", this.getCodigoActividad());
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// /////////// VER.. MODIFICAR TODO -----
	/*
	 * retorna una lista de strings donde cada string tiene el codigo de la
	 * actividad
	 */
	public static LinkedList<String> subjectCodesList() throws SQLException {
		ResultSet rst;
		rst = jpa.proyeccion("Actividad", "cod_materia");
		LinkedList<String> result = new LinkedList<String>();
		while (rst.next()) {
			result.add(rst.getString(1));
		}
		return result;
	}

}