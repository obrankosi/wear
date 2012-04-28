package educar.db;

import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JPA {
    public ResultSet runQuery(String sentence) {
	ResultSet res = null;
	try {
	    Statement sent = (Statement) DbConnection.getInstance()
		    .createStatement();
	    res = sent.executeQuery(sentence);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return res;
    }

    public void runUpdate(String sentence) {
	try {
	    Statement stm = (Statement) DbConnection.getInstance()
		    .createStatement();
	    stm.executeUpdate(sentence);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    
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
     *         // do insertion conn.create(stm);
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
	    stm.executeUpdate();
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
     *            );
     */
    public void update(String tableName, String column, String value, String id) {
	String query = "UPDATE " + DbConnection.bd + "." + tableName;

	query += " set " + column + "= \"" + value + "\" WHERE id =" + id + ";";
	runUpdate(query);
    }

    // modularizar el id!!
    public void update(String tableName, String[] column, String[] values,
	    String columnId, String id) {
	String updateValues = column[0] + "= \"" + values[0] + "\"";
	for (int i = 1; i < values.length; i++) {
	    updateValues += "," + column[i] + " = \"" + values[i] + "\"";
	}
	String query = "UPDATE " + DbConnection.bd + "." + tableName;
	query += " set " + updateValues + " WHERE " + columnId + " = " + id
		+ ";";
	System.out.println(query + "************************");
	runUpdate(query);
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
     */
    public void destroy(String tableName, String columnName, String id) {
	String query = "DELETE from " + DbConnection.bd + "." + tableName;
	query += " Where " + columnName + " = \"" + id + "\";";
	runUpdate(query);
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
     *            i.e.: conn.show("table", 1);
     */
    public ResultSet show(String tableName, String id) {
	ResultSet result = null;
	String query = "SELECT * from " + DbConnection.bd + "." + tableName
		+ " WHERE id=" + id + ";";

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
