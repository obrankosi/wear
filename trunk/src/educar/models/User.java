package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import educar.db.JPA;

public class User {
	private static JPA jpa = new JPA();
	private String username;
	private String password;
	private String role;

	public User(String username, String password, String role) {
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
	}

	public static boolean authenticate(String username, String password) {
		try {
			User u = getUserByUsername(username);

			if (password.equals(u.getPassword())) {
				Session.setCurrentUser(u);
				return true;
			}
		} catch (userNotFound ex) {
			return false;
		}

		return false;
	}

	public boolean save() {
		try {
			User.getUserByUsername(username);
			return false;
		} catch (userNotFound e1) {
			String[] columns = { "username", "password", "role" };

			PreparedStatement stm = jpa.newRecord("educar_dev.users", columns);

			try {
				stm.setString(1, username);
				stm.setString(2, password);
				stm.setString(3, role);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			jpa.create(stm);//inserta en la base de datos 
			return true;
		}
	}

	public boolean destroy() {
		try {
		    jpa.destroy("users", "username", this.getUsername());
		    return true;
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		    return false;
		}
	}

	public static User getUserByUsername(String username) throws userNotFound {
		ResultSet rs = null;
		User u = null;

		rs = jpa.getByField("users", "username", username);

		try {
			if (rs.next()) {
				u = new User(rs.getString(2), rs.getString(3), rs.getString(4));
			} else {
				throw new userNotFound();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
