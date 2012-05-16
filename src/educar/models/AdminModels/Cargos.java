package educar.models.AdminModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

public class Cargos {
    private static JPA jpa = new JPA();
    private String codigoCargo;
    private String nombreCargo;
    private static ResultSet rst;

    /**
     * @param codigo
     *            cargo
     * @param nombre
     *            cargo
     */
    public Cargos(String codigoCargo, String nombreCargo) {
	this.setCodigoCargo(codigoCargo);
	this.setNombreCargo(nombreCargo);

    }

    /**
     * @param nombreCargo
     */
    public Cargos(String nombreCargo) {
	this.setNombreCargo(nombreCargo);

    }

    /**
     * @param codCargo
     * @return cargo
     */
    public static Cargos getCargo(String cod) {
	try {
	    return getCodigo(cod, "Cargo");
	} catch (CargosNotFound e) {
	    return null;
	}

    }

    /**
     * @return true ssi guardado exitoso
     */
    public boolean save() {
	String[] columns = { "cod_cargo", "descripcion_cargo" };
	try {
	    return save("Cargo", columns);
	} catch (CargosNotFound e) {
	    return false;
	}
    }

    /**
     * @return {@link LinkedList} cargos
     * @throws SQLException
     */
    public static LinkedList<String> listaCargos() throws SQLException {
	rst = jpa.proyeccion("Cargo", "cod_cargo,descripcion_cargo");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1) + " " + rst.getString(2) + " ");
	}
	return result;
    }

    /**
     * @return {@link LinkedList} codigo de cargo
     * @throws SQLException
     */
    public static LinkedList<String> listCargosCod() throws SQLException {
	rst = jpa.proyeccion("Cargo", "cod_cargo");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1));
	}
	return result;
    }

    /**
     * @return true ssi borrado exitoso
     */
    public boolean destroy() {
	try {
	    jpa.destroy("Cargo", "cod_cargo", this.getCodigoCargo());
	    return true;
	} catch (SQLException e) {
	    return false;
	}

    }

    /**
     * @param values arreglo de valores
     * @param codigoCargo2
     * @throws SQLException
     */
    public void update(String[] values, String codigoCargo2)
	    throws SQLException {
	String[] columns = { "descripcion_cargo" };
	try {
	    jpa.update("Cargo", columns, values, "cod_cargo", codigoCargo2);
	} catch (Exception e) {
	    throw new SQLException();
	}
    }

    private static Cargos getCodigo(String cod, String tableName)
	    throws CargosNotFound {
	Cargos cargo = null;
	ResultSet rs = null;
	rs = jpa.getByField(tableName, "cod_cargo", cod);
	try {
	    if (rs.next()) {
		cargo = new Cargos(rs.getString(1), rs.getString(2));

	    } else {
		throw new CargosNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return cargo;
    }

    private boolean save(String tableName, String[] columns)
	    throws CargosNotFound {
	try {
	    String[] column = columns;
	    PreparedStatement stm = jpa.newRecord("educar_dev." + tableName,
		    column);

	    stm.setString(1, codigoCargo);
	    stm.setString(2, nombreCargo);
	    jpa.create(stm);
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
    }

    private void setNombreCargo(String nombreCargo2) {
	this.nombreCargo = nombreCargo2;

    }

    private void setCodigoCargo(String codigoCargo2) {
	this.codigoCargo = codigoCargo2;

    }

    public String getNombreCargo() {
	return this.nombreCargo;
    }

    public String getCodigoCargo() {
	return this.codigoCargo;
    }

}