package educar.db;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class DbConnection {
	public static String bd = "educar_dev";
	private static String login = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost/"+bd;
	private static DbConnection instance;
	private static Connection conn;
	
	public synchronized static Connection getInstance(){
		if (instance == null)
			instance = new DbConnection();
		return conn;
	}

	public DbConnection() {
	      try{
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = (Connection) DriverManager.getConnection(url, login, password);
	         if (conn!=null){
	            System.out.println("Dabase " + bd + " Connected");
	         }
	      }catch(Exception ex){
	    	  ex.printStackTrace();
	      }
	   }

	public void closeConnection(){
	    conn = null;
	}
}


