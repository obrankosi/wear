package educar.models.AdminModels;

import java.io.ObjectInputStream.GetField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import educar.db.JPA;

public class DedicacionDocente implements Comparable<DedicacionDocente> {

    private String dniDocente;
    private String codCargo;
    private String hsDedicacion;
    private String codFacultad;
    private JPA jpa;

    private static ResultSet rst;
    private DedicacionDocente elem;

    public DedicacionDocente(String codFacultad, String dniDocente,
	    String codCargo, String hsDedicacion) {
	this.dniDocente = dniDocente;
	this.codCargo = codCargo;
	this.hsDedicacion = hsDedicacion;
	this.codFacultad = codFacultad;
    }

    public static boolean containtDedicacionDocente(DedicacionDocente arg1) {
	String[] column = { "codigo_fac", "dni_doc" };
	String[] values = { arg1.getCodFacultad(), arg1.getDniDocente() };
	JPA jpa = new JPA();
	rst = jpa.getByField("Trabaja", column, values);
	try {
	    if (rst.next()) {
		return true;
	    } else {
		return false;
	    }
	} catch (SQLException e) {

	    return false;
	}

    }

    public static boolean containtDedicacionCargo(DedicacionDocente arg1) {
	String[] column = { "codigo_fac","codigo_cargo" };
	String[] values = {arg1.getCodFacultad(), arg1.getCodCargo() };
	JPA jpa = new JPA();
	rst = jpa.getByField("Trabaja", column, values);
	try {
	    if (rst.next()) {
		return true;
	    } else {
		return false;
	    }
	} catch (SQLException e) {
	    // la consulta dio error
	    return false;
	}

    }

    public boolean save() {
	String[] columns = { "codigo_fac", "dni_doc", "codigo_cargo",
		"hs_dedicacion" };
	JPA jpa = new JPA();
	PreparedStatement stm = jpa.newRecord("educar_dev." + "Trabaja",
		columns);
	try {
	    stm.setString(1, this.getCodFacultad());
	    stm.setString(2, this.getDniDocente());
	    stm.setString(3, this.getCodCargo());
	    stm.setString(4, this.getHsDedicacion());
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	jpa.create(stm);
	return true;

    }

    // no la use todavia
    public static LinkedList<DedicacionDocente> getListDedicacion()
	    throws SQLException {
	LinkedList<DedicacionDocente> result = new LinkedList<DedicacionDocente>();
	JPA jpa = new JPA();
	rst = jpa.showAll("Trabaja");
	while (rst.next()) {
	    String codFac = rst.getString(1);
	    String dniD = rst.getString(2);
	    String codC = rst.getString(3);
	    String hsD = rst.getString(4);
	    result.add(new DedicacionDocente(codFac, dniD, codC, hsD));
	}
	return result;
    }

    public static LinkedList<String> listDedicacion() throws SQLException {
	LinkedList<String> result = new LinkedList<String>();
	JPA jpa = new JPA();
	rst = jpa.showAll("Trabaja");
	while (rst.next()) {
	    String codFac = rst.getString(1);
	    String dniD = rst.getString(2);
	    String codC = rst.getString(3);
	    String hsD = rst.getString(4);
	    result.add("docente: " + dniD + " | " + "cargo nro : " + codC
		    + " | " + " facultad nro : " + codFac + " | "
		    + " cantidad horas: " + hsD);
	}
	return result;

    }

    @Override
    public int compareTo(DedicacionDocente arg0) {
	if (this.getCodCargo().compareTo(arg0.getCodCargo()) == 0
		&& this.getCodFacultad().compareTo(arg0.getCodFacultad()) == 0
		&& this.getDniDocente().compareTo(arg0.getDniDocente()) == 0) {
	    return 0;
	} else
	    return 1;
    }

    public String getDniDocente() {
	return dniDocente;
    }

    public void setDniDocente(String dniDocente) {
	this.dniDocente = dniDocente;
    }

    public String getCodCargo() {
	return codCargo;
    }

    public void setCodCargo(String codCargo) {
	this.codCargo = codCargo;
    }

    public String getHsDedicacion() {
	return hsDedicacion;
    }

    public void setHsDedicacion(String hsDedicacion) {
	this.hsDedicacion = hsDedicacion;
    }

    public String getCodFacultad() {
	return codFacultad;
    }

    public void setCodFacultad(String codFacultad) {
	this.codFacultad = codFacultad;
    }

    // public static boolean containtDedicacionDocente(DedicacionDocente arg1) {
    // ResultSet rs = null;
    // String[] column = { "codigo_fac", "dni_doc" };
    // String[] values = { arg1.getCodFacultad(), arg1.getDniDocente() };
    // rs = jpa.getByField("Trabaja", column, values);
    // try {
    // if (rs.next()) {
    // // String codFac = rst.getString(1);
    // // String dniD = rst.getString(2);
    // // String codC = rst.getString(3);
    // // String hsD = rst.getString(4);
    // // DedicacionDocente u = new DedicacionDocente(codFac, dniD,
    // // codC,
    // // hsD);
    // return true;
    // } else {
    // return false;
    // }
    // } catch (SQLException e) {
    // // la consulta dio error
    // return false;
    // }
    //
    // }

}
