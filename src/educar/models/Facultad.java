package educar.models;

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
	
	public Facultad(String codigo, String descripcion) {
		this.setDescripcion(descripcion);
		this.setCodigo(codigo);
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
	
	public boolean save() {
		String[] col = {"descripcion_fac"};
		try {
			Facultad.getFacultadByCod(this.getCodigo());
			return false;
		} catch (FacultadNotFound e) {
			PreparedStatement stm = jpa.newRecord("educar_dev."+"facultad", col);
			try {
				stm.setString(1, descFac);
			} catch (SQLException e1){
				e1.printStackTrace();
				return false;
			}
			jpa.create(stm);
			return true;
		}
	}
	
	public static Facultad getFacultadByCod(String cod) throws FacultadNotFound {
		ResultSet rs = null;
		Facultad fac = null;
		rs = jpa.getByField("facultad", "cod_facultad", cod);
		
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
	
	public boolean destroy() {
		try {
			jpa.destroy("facultad", "codigo_fac",  this.getCodigo());
			return true;
		} catch (SQLException r) {
			return false;
		}
	}
	
	/**
	 * @param codigo
	 * @param tableName
	 * @return
	 */
//	public static Facultad getFacultad(String codigo, String tableName) {
//		Facultad fac = null;
//		try {
//			fac = Facultad.getFacultadByCod(codigo, tableName);
//			return fac;
//		} catch (FacultadNotFound e) {
//			return fac;
//		}
//	}
	
	public static void update(String desc) throws SQLException {
		try {
			jpa.update("facultad", "descripcion_fac", desc, "cod_facultad", "cod_facultad");
		} catch (Exception e) {
			throw new SQLException();
		}
	}
	
	public static LinkedList<String> ListFacultad() throws SQLException {
		rst = jpa.proyeccion("facultad", "cod_facultad");
		LinkedList<String> result = new LinkedList<String>();
		while (rst.next()) {
			result.add(rst.getString(1)+ " " + rst.getString(2));
		}
		return result;
	}
}
