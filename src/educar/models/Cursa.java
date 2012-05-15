package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;
import educar.models.AdminModels.CargosNotFound;
import educar.models.AdminModels.Subject;

public class Cursa {

	private static JPA jpa = new JPA();
	private String dniAlumno;
	private String codMateria;

	public Cursa(String dniAlumno, String codMateria) {
		this.setDniAlumno(dniAlumno);
		this.setCodMateria(codMateria);
	}

	public boolean save() { // guardar la materia que cursa un alumno
		String[] columns = { "dni_a", "cod_mat" };
		try {
			return save("cursa", columns);
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
			stm.setString(1, dniAlumno);
			stm.setString(2, codMateria);
			jpa.create(stm);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean pertenece() { 
		String[] fieldNames = { "dni_a", "cod_mat" };
		String[] values = { dniAlumno, codMateria };
		ResultSet res = jpa.getByField("cursa", fieldNames, values);
		try {
			if (res.next()) {
				if ((res.getString(1).compareTo(dniAlumno) == 0)
						&& (res.getString(2).compareTo(codMateria) == 0)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}

	private void setCodMateria(String codMateria) {
		// TODO Auto-generated method stub
		this.codMateria = codMateria;
	}

	private void setDniAlumno(String dniAlumno) {
		// TODO Auto-generated method stub
		this.dniAlumno = dniAlumno;
	}

	public static LinkedList<String> cursaList(String id) throws SQLException {
		ResultSet rst = jpa.proyeccion("cursa", "dni_a,cod_mat", "dni_a", id);
		LinkedList<String> result = new LinkedList<String>();
		while (rst.next()) {
			result.add(rst.getString(2) + "  |   "
					+ Subject.getSubject(rst.getString(2)).getName());
		}
		return result;
	}

	public String getDniAlumno() {
		// TODO Auto-generated method stub
		return dniAlumno;
	}

}