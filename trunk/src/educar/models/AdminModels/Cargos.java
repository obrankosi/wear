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

    public Cargos(String nombreCargo) {
	this.setNombreCargo(nombreCargo);

    }

    public static Cargos getCargo(String cod) {
	try {
	    return getCodigo(cod, "Cargo");
	} catch (CargosNotFound e) {
	    // TODO Auto-generated catch block
	    return null;
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

    public boolean save() {
	String[] columns = { "cod_cargo", "descripcion_cargo" };
	try {
	    return save("Cargo", columns);
	} catch (CargosNotFound e) {
	    return false;// TODO Auto-generated catch block
	}
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

    public static LinkedList<String> listaCargos() throws SQLException {
	rst = jpa.proyeccion("Cargo", "cod_cargo,descripcion_cargo");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1) + " " + rst.getString(2) + " ");
	}
	return result;
    }
    
    public static LinkedList<String> listCargosCod() throws SQLException {
	rst = jpa.proyeccion("Cargo", "cod_cargo");
	LinkedList<String> result = new LinkedList<String>();
	while (rst.next()) {
	    result.add(rst.getString(1));
	}
	return result;
    }

    // ------------------------------------------------------------------------------------
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

    public void update(String[] values, String codigoCargo2)
	    throws SQLException {
	String[] columns = { "descripcion_cargo" };
	try {
	    jpa.update("Cargo", columns, values, "cod_cargo", codigoCargo2);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();

	}
    }

    public boolean destroy() {
	// TODO Auto-generated method stub
	try {
	    jpa.destroy("Cargo", "cod_cargo", this.getCodigoCargo());
	    return true;
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    return false;
	}

    }
}