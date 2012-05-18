package educar.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

/**
 * @author grupo wear
 * Modelo {@link DictaMateria}
 * 
 */
public class DictaMateria {

    private String dniDocente;
    private String codMateria;

    /**
     * @param dniDocente
     * @param codMateria
     */
    public DictaMateria(String dniDocente, String codMateria) {
	this.dniDocente = dniDocente;
	this.codMateria = codMateria;
    }

    /**
     * @return true ssi el guardado es exitoso
     */
    public boolean save() {
	String[] columns = { "dni_doc", "cod_mat" };
	JPA jpa = new JPA();
	PreparedStatement stm = jpa.newRecord("educar_dev." + "Dicta", columns);
	try {
	    stm.setString(1, this.getDniDocente().trim());
	    stm.setString(2, this.getCodMateria().trim());
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	jpa.create(stm);
	return true;
    }

    /**
     * @return {@link LinkedList} si encontro en la base de datos
     * @throws DictaMateriaNotFound
     */
    /**
     * @param dniDocente
     * @return {@link LinkedList} si encontro en la base de datos
     * @throws DictaMateriaNotFound
     */
    public static LinkedList<String> getMateriasDictaByCod(String dniDocente)
	    throws DictaMateriaNotFound {
	LinkedList<String> newList = new LinkedList<String>();
	ResultSet rst = null;
	JPA jpa = new JPA();
	rst = jpa.getByField("Dicta", "dni_doc", dniDocente);
	String codMateria = new String();
	try {
	    while (rst.next()) {
		codMateria = rst.getString(2);
		newList.add(codMateria);
	    }
	} catch (SQLException e) {
	    throw new DictaMateriaNotFound();
	}
	return newList;
    }

    /**
     * @param dniDocente
     * @param codMateria
     * @return {@link DictaMateria} ssi existe en Bs
     * @throws DictaMateriaNotFound
     */
    public static DictaMateria getDictaMateriaByCod(String dniDocente,
	    String codMateria) throws DictaMateriaNotFound {
	JPA jpa = new JPA();
	ResultSet rs = null;
	DictaMateria dm = null;
	String[] columsKey = { "dni_doc", "cod_mat" };
	String[] valuesKey = { dniDocente, codMateria };
	rs = jpa.getByField("Dicta", columsKey, valuesKey);
	try {
	    if (rs.next()) {
		dm = new DictaMateria(rs.getString(1), rs.getString(2));
	    } else {
		throw new DictaMateriaNotFound();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return dm;
    }

    public String getDniDocente() {
	return dniDocente;
    }

    public void setDniDocente(String dniDocente) {
	this.dniDocente = dniDocente;
    }

    public String getCodMateria() {
	return codMateria;
    }

    public void setCodMateria(String codMateria) {
	this.codMateria = codMateria;
    }

}
