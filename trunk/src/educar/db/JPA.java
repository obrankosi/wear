package educar.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JPA {
    /**
     * @param sentence
     * @return
     */
    public ResultSet runQuery(String sentence) {
	ResultSet res = null;
	try {
	    Statement sent = (Statement) DbConnection.getInstance()
		    .createStatement();
	    res = sent.executeQuery(sentence);// para realizar selec con alguna
	    // tabla de la base de datos
	} catch (Exception ex) {
	    ex.printStackTrace();
	    System.out.println("la consulta : " + sentence + "fallo");
	}
	return res;
    }

    // exception agregada por las dudas que no se pueda realizar un DELET o
    // UPDATE
    // debido a las restricciones de la base de datos
    /**
     * @param sentence
     * @throws SQLException
     */
    public void runUpdate(String sentence) throws SQLException {
	Statement stm = (Statement) DbConnection.getInstance()
		.createStatement();
	try {
	    stm.executeUpdate(sentence);// para realizar delet,update en la bd
	    // con cualquier tabla
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();
	}

    }

    /**
     * Create the statement to insert into the table
     * 
     * @param table
     *            "name of table"
     * @param columns
     *            "name of columns to use in the insertion"
     * @return PreparedStatement
     *         "Statement to insert, to modify values to insert set this object"
     * 
     *         i.e.: DB: db Table: table Columns: id (integer) y name (text)
     * 
     *         String[] columns = {"id", "name"}; PreparedStatement stm =
     *         conn.newRecord("db.table", columns); // Set id with 3
     *         stm.setInt(1, 3);
     * 
     *         // Set name stm.setString(2, "Text to insert");
     * 
     *         // do insertion conn.create(stm); sentencia preCompilada nos va a
     *         mejorar la eficiencia siempre que no la cree de nuevo esto lo
     *         podems hacer si la llevamos como un atriburo de la clace una ves
     *         que la conecte queda conectada. a diferencia de statement tener
     *         cuidado con los tipos!! aca esta echo para INsertar pero tambien
     *         se puder hacer para delelt y update
     */
    public PreparedStatement newRecord(String table, String[] columns) {
	PreparedStatement stmt = null;
	try {
	    String values = "";
	    String columnNames = "";
	    int i = 0;
	    while (i != columns.length) {
		values += "?,";
		columnNames += (columnNames.equals("")) ? columns[i] : ", "
			+ columns[i];
		i++;
	    }
	    values = (String) values.subSequence(0, values.length() - 1);

	    String command = "INSERT INTO " + table + " (" + columnNames
		    + ") VALUES (" + values + ")";
	    stmt = (PreparedStatement) DbConnection.getInstance()
		    .prepareStatement(command);
	} catch (Exception ex) {
	    System.err.println("ERROR createInsertStatement");
	    ex.printStackTrace();
	}
	return stmt;
    }

    /**
     * do insertion
     * 
     * @param stm
     *            to insert
     * 
     */
    public void create(java.sql.PreparedStatement stm) {
	try {
	    stm.executeUpdate();// ejecuta la sentencia sql
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    /**
     * Edit content
     * 
     * @param sentence
     *            SQL (i.e. "UPDATE table set name = 'TEST NAME' where id = 10")
     * 
     *            i.e.:
     *            conexion.update("UPDATE db.table set name= 'TEST NAME' where id = 10"
     *            ); columnId = nombre de la columna a comparar
     * @throws SQLException
     */
    public void update(String tableName, String column, String value,
	    String columnId, String id) throws SQLException {

	String query = "UPDATE " + DbConnection.bd + "." + tableName;
	query += " set " + column + "= \"" + value + "\" WHERE " + columnId
		+ " = " + id + ";";
	try {
	    runUpdate(query);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();
	}

    }

    /*
     * arma el string de la sentencia en esta caso para una actualizacion, luego
     * llama a a runUpdate que la ejecuta con statement Lanza una exception por
     * si no pudo actualizar debio a una restriccion de la tabla
     */
    /**
     * @param tableName
     * @param column
     * @param values
     * @param columnId
     * @param id
     * @throws SQLException
     */
    public void update(String tableName, String[] column, String[] values,
	    String columnId, String id) throws SQLException {
	String updateValues = column[0] + "= \"" + values[0] + "\"";
	for (int i = 1; i < values.length; i++) {
	    updateValues += "," + column[i] + " = \"" + values[i] + "\"";
	}
	String query = "UPDATE " + DbConnection.bd + "." + tableName;
	query += " set " + updateValues + " WHERE " + columnId + " = " + id
		+ ";";
	try {
	    runUpdate(query);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();
	}

    }

    /**
     * Destroy (by column and id)
     * 
     * @param table
     *            "table name"
     * @param columnId
     *            "Column use to destroy"
     * @param id
     *            "value to destroy"
     * 
     *            i.e.: conn.destroy("table", "id", "3");
     * @throws SQLException
     * 
     */
    public void destroy(String tableName, String columnName, String id)
	    throws SQLException {
	String query = "DELETE from " + DbConnection.bd + "." + tableName;
	query += " Where " + columnName + " = \"" + id + "\";";
	try {
	    runUpdate(query);
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new SQLException();
	}
    }

    /**
     * Shows all records from a table
     * 
     * @param tableName
     * 
     *            i.e.: conn.showAll("table");
     */
    public ResultSet showAll(String tableName) {
	ResultSet result = null;
	String query = "SELECT * from " + DbConnection.bd + "." + tableName
		+ ";";

	result = runQuery(query);

	return result;
    }

    /**
     * Shows one record
     * 
     * @param tableName
     * @param id
     * 
     *            i.e.: conn.show("table", 1); columnId = nombre de columna que
     *            va a comparar
     */
    public ResultSet show(String tableName, String columnId, String id) {
	ResultSet result = null;
	String query = "SELECT * from " + DbConnection.bd + "." + tableName
		+ " WHERE " + columnId + " = " + id + ";";

	result = runQuery(query);

	return result;
    }

    /*
     * es la proyeccion de sql todos los elementos sin where columnName =
     * columna1,columna2....columnaN
     */
    /**
     * @param tableName
     * @param columnName
     * @return
     */
    public ResultSet proyeccion(String tableName, String columnName) {
	ResultSet result = null;
	String query = "SELECT " + columnName + " from " + DbConnection.bd
		+ "." + tableName + ";";
	result = runQuery(query);
	return result;
    }

    /*
     * es la proyeccion de sql con where, donde columnName =
     * columna1,columna2....columnaN nameId = nombreDeLaColumna
     */
    /**
     * @param tableName
     * @param columnName
     * @param nameId
     * @param id
     * @return
     */
    public ResultSet proyeccion(String tableName, String columnName,
	    String nameId, String id) {
	ResultSet result = null;
	String query = "SELECT " + columnName + " from " + DbConnection.bd
		+ "." + tableName + " WHERE " + nameId + " = " + id + ";";
	result = runQuery(query);
	return result;
    }

    /**
     * @tableName
     * @fieldName
     * @value
     * 
     *        i.e.: conn.getByField("table", "column", "pp")
     */
    public ResultSet getByField(String tableName, String fieldName, String value) {
	ResultSet result = null;
	String query = "SELECT * from " + DbConnection.bd + "." + tableName
		+ " WHERE " + fieldName + "= \"" + value + "\";";

	result = runQuery(query);

	return result;
    }
}
