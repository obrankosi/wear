package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;
import educar.models.AdminModels.Facultad;
import educar.models.AdminModels.FacultadNotFound;
import educar.models.AdminModels.Subject;

/**
 * @author grupo wear Modelo {@link Actividad}
 */
public class Actividad {

    private static JPA jpa = new JPA();
    private String codigoActividad;
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

    /**
     * @param descripcionActiv
     * @param codMateria
     */
    public Actividad(String descripcionActiv, String codMateria) {
	this.setDescripcionActividad(descripcionActiv);
	this.setCodigoMateria(codMateria);
    }

    public void setCodigoMateria(String codigo) {
	this.codigoMateria = codigo;
    }

    public void setDescripcionActividad(String descripcionActividad) {
	this.descripcionActividad = descripcionActividad;
    }

    public void setCodigoActividad(String codigoAtividad) {
	this.codigoActividad = codigoAtividad;
    }

    public String getCodigoMateria() {
	return codigoMateria;
    }

    public String getDescripcionActividad() {
	return descripcionActividad;
    }

    public String getCodigoActividad() {
	return codigoActividad;
    }

    /**
     * @return true ssi guardado exitoso
     */
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
	    jpa
		    .destroy("Actividad", "cod_actividad", this
			    .getCodigoActividad());
	    return true;
	} catch (SQLException e) {
	    return false;
	}
    }

    /**
     * @param codMateria
     * @return {@link LinkedList} con las activdades de la materia ,null si no
     *         posee
     */
    public static LinkedList<Actividad> getActDocente(String codMateria) {
	LinkedList<Actividad> result = new LinkedList<Actividad>();
	ResultSet rs = null;
	Actividad act = null;
	rs = jpa.getByField("Actividad", "cod_materia", codMateria);
	try {
	    while (rs.next()) {
		String codigoActividad = rs.getString(1);
		String descripcion = rs.getString(2);
		String codigoMateria = rs.getString(3);
		act = new Actividad(codigoActividad, descripcion, codigoMateria);
		result.add(act);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    result = null;
	}
	return result;
    }

    // dada una lista de strings con codigos de materias validos, devuelve todas
    // las actividades que tienen las materias
    // de la forma: codigoActividad,Materia,Codigo,Facultad , donde Facultad es
    // la facultad a la que pertenece la materia
    /**
     * @param codMaterias
     *            validos
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

    // dada una lista de strings con codigos de materias validos, retorna las
    // materias con su nombreMateria, codigoMateria y facultad
    /**
     * @param codMaterias
     *            validos
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

    public static String codigoUltimaIngresada() {
	String codigo = new String();
	JPA jpa = new JPA();
	ResultSet rst = jpa.showUltimoCod("Actividad", "cod_actividad");
	try {
	    if (rst.next()) {
		codigo = rst.getString(1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return codigo;
    }

}