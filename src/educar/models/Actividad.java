package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import educar.db.JPA;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.FacultadNotFound;
import educar.models.AdminModels.Subject;

/**
 * @author Elian
 * 
 */
/**
 * @author edu
 * 
 */
public class Actividad {

	private static JPA jpa = new JPA();
	private static String codigoActividad;
	private String descripcionActividad;
	private String codigoMateria;
	private static Subject materia;
	private static Facultad facultad;

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
		this.codigoMateria = codigo;
	}

	private void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	private void setCodigoActividad(String codigoAtividad) {
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

	/**
	 * @param codActividad
	 * @return {@link Actividad}
	 * @throws ActividadNotFound
	 *             si no existe la actividad
	 */
	public static Actividad getActividad(String codActividad)
			throws ActividadNotFound {

		ResultSet rs = null;
		Actividad act = null;
		rs = jpa.getByField("Actividad", "cod_actividad", codActividad);
		try {
			if (rs.next()) {
				String codigoActividad = rs.getString(1);
				String descripcion = rs.getString(2);
				String codMateria = rs.getString(3);
				act = new Actividad(codigoActividad, descripcion, codMateria);
			} else {
				throw new ActividadNotFound();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return act;
	}

	public boolean deleteActividad() {
		try {
			jpa.destroy("Actividad", "cod_actividad", this.getCodigoActividad());
			return true;
		} catch (SQLException e) {
			return false;
		}
	}


	// dada una lista de strings con codigos de materias validos, devuelve todas las actividades que tienen las materias
	// de la forma:  codigoActividad,Materia,Codigo,Facultad  , donde Facultad es la facultad a la que pertenece la materia
	/**
	 * @param codMaterias validos
	 * @return codigoActividad, Materia, Codigo, Facultad
	 */
	public static LinkedList<String> getActividadesDocente(
			LinkedList<String> codMaterias) {

		if (codMaterias.size() > 0) {
			LinkedList<String> result = new LinkedList<String>();
			// JPA jpa = new JPA();
			ResultSet rs = null;
			String mostrar;

			for (int i = 0; i < codMaterias.size(); i++) {
				rs = jpa.proyeccion("Actividad", "cod_actividad",
						"cod_materia", codMaterias.get(i));
				materia = Subject.getSubject(codMaterias.get(i));

				try {
					facultad = Facultad.getFacultadByCod(materia
							.getCodigoFacultad());
					mostrar = " | Materia: " + materia.getName()
							+ " - Codigo: " + materia.getCode()
							+ " | Facultad: " + facultad.getDescipcion();
					while (rs.next()) {
						result.add("Codigo Actividad: " + rs.getString(i)
								+ mostrar);

					}
				} catch (FacultadNotFound e) {
					return null;
				} catch (SQLException e) {
					System.out
							.println("Error en la consulta en la base de datos");
					return null;
				}
			}
			return result;
		} else
			return null;

	}

	
	// dada una lista de strings con codigos de materias validos, retorna las materias con su nombreMateria, codigoMateria y facultad
	/**
	 * @param codMaterias validos
	 * @return nombreMateria, codigoMateria y facultad
	 */
	public LinkedList<String> getMateriasDocente(LinkedList<String> codMaterias) {
		if (codMaterias.size() > 0) {
			try {
				LinkedList<String> result = new LinkedList<String>();
				String mostrar;
				for (int i = 0; i < codMaterias.size(); i++) {
					materia = Subject.getSubject(codMaterias.get(i));
					facultad = Facultad.getFacultadByCod(materia
							.getCodigoFacultad());
					mostrar = "Materia: " + materia.getName() + " - Codigo: "
							+ materia.getCode() + " | Facultad: "
							+ facultad.getDescipcion();
					result.add(mostrar);
				}
				return result;
			} catch (FacultadNotFound e) {
				return null;
			}
		} else
			return null;
	}

	
	
	/**
	 * @param codActividad
	 * @return Codigo de la materia que posee esta actividad
	 * @throws ActividadNotFound
	 *             si no existe
	 */
	public static String getCodMateriaActividad(String codActividad)
			throws ActividadNotFound {
		ResultSet rs = null;
		String codMateria = new String();
		Actividad act = null;
		JPA jpa = new JPA();
		rs = jpa.getByField("Actividad", "cod_actividad", codActividad);
		try {
			if (rs.next()) {
				codMateria = rs.getString(3);
			} else {
				throw new ActividadNotFound();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codMateria;
	}

}