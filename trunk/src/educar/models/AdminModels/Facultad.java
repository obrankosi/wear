package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import educar.db.JPA;
import java.util.LinkedList;

public class Facultad {

    private static JPA jpa = new JPA();
    private String codigoFac;
    private String descFac;
    private static ResultSet rst;

    /**
     * @param codigo
     *            Facultad
     * @param descripcion
     *            Facultad
     */
    public Facultad(String codigo, String descripcion) {
	this.setDescripcion(descripcion);
	this.setCodigo(codigo);
    }

    /**
     * @param descripcion
     */
    public Facultad(String descripcion) {
	this.setDescripcion(descripcion);
    }

    /**
     * @return true ssi guardado exitoso
     */
    public boolean save() {
	String[] columns = { "descripcion_fac" };
	return save("Facultad", columns);
    }

    /**
     * @param cod Facultad
     * @return {@link Facultad} 
     * @throws FacultadNotFound
     */
    public static Facultad getFacultadByCod(String cod) throws FacultadNotFound {
	ResultSet rs = null;
	Facultad fac = null;
	rs = jpa.getByField("Facultad", "cod_facultad", cod);
	try {
	    if (rs.next()) {
		fac = new Facultad(rs.getString(1), rs.getString(2));
	    } else {
		throw new FacultadNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return fac;
    }

    /**
     * @return true ssi borrado exitoso
     */
    public boolean destroy() {
	try {
	    jpa.destroy("Facultad", "cod_facultad", this.getCodigo());
	    return true;
	} catch (SQLException r) {
	    return false;
	}
    }

    /**
     * @param desc descripcion facultad
     * @param id de facultad
     * @throws SQLException
     */
    public static void update(String desc, String id) throws SQLException {
	try {
	    jpa.update("Facultad", "descripcion_fac", desc, "cod_facultad", id);
	} catch (Exception e) {
	    throw new SQLException();
	}
    }

    /**
     * @return {@link LinkedList}
     * @throws SQLException
     */
    public static LinkedList<String> ListFacultad() throws SQLException {
	rst = jpa.showAll("Facultad");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1) + " " + rst.getString(2));
	}
	return result;
    }

    /**
     * @return {@link LinkedList} con codigo facultad solamente
     * @throws SQLException
     */
    public static LinkedList<String> ListFacultadCod() throws SQLException {
	rst = jpa.proyeccion(" Facultad", "cod_facultad");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1));
	}
	return result;
    }

    private boolean save(String table, String[] columns) {
	try {
	    Facultad.getFacultadByCod(this.getCodigo());
	    return false;
	} catch (FacultadNotFound e) {
	    PreparedStatement stm = jpa.newRecord("educar_dev." + table,
		    columns);
	    try {
		stm.setString(1, descFac);
	    } catch (SQLException e1) {
		e1.printStackTrace();
		return false;
	    }
	    jpa.create(stm);
	    return true;
	}
    }

    public String getDescipcion() {
	return this.descFac;
    }

    public void setDescripcion(String desc) {
	this.descFac = desc;
    }

    public String getCodigo() {
	return this.codigoFac;
    }

    public void setCodigo(String codigo) {
	this.codigoFac = codigo;
    }

}
