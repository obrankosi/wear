package educar.gui.AdminViews;

public class FuncionesAuxiliares {

    public static String idString(String s) {
	return (s.substring(0, s.indexOf(" "))).trim();
    }

    public static String nameString(String s) {
	return (s.substring(s.indexOf(" "), s.length())).trim();
    }

    /**
     * asignacion Docente Encargado & designacion
     ***/
    public static boolean camposVaciosAsignacionDocente(String campo1,
	    String campo2) {
	return (campo1.compareTo("") == 0) || (campo2.compareTo("") == 0);
    }

    // docente: 3345232 | cargo nro: 33 | facultad nro: 5 | cantidad horas: 55
    public static String getDni(String txt) {
	int index = txt.indexOf(":") + 1;// me paro en los :
	String subS = txt.substring(index);// borro todo lo anterior
	int indez2 = subS.indexOf("|");// busco el primer |
	String dniD = ((String) subS.subSequence(0, indez2)).trim();// me quedo
	// con el
	// numero
	return dniD;
    }

    public static String getCargo(String txt) {
	int index;
	int indez2;
	String subS;
	index = txt.indexOf("|") + 1;// ma paro en los | 18
	subS = txt.substring(index);// borro todo lo anterior

	index = subS.indexOf(":") + 1;// ma paro en los : 11
	subS = subS.substring(index);// borro todo lo anterior
	indez2 = subS.indexOf("|");// busco el primer |
	String cargo = ((String) subS.subSequence(0, indez2)).trim();// me quedo
	// con el
	// numero
	return cargo;
    }

    public static String getfacultad(String txt) {
	int index;
	int indez2 = 0;
	String subS = null;
	index = txt.indexOf("|") + 1;
	subS = txt.substring(index);
	index = subS.indexOf("|") + 1;
	subS = subS.substring(index);

	index = subS.indexOf(":") + 1;
	subS = subS.substring(index);
	indez2 = subS.indexOf("|");

	String facu = ((String) subS.subSequence(0, indez2)).trim();
	return facu;
    }

    public static String getHs(String txt) {
	int index;
	int indez2 = 0;
	String subS = null;
	index = txt.indexOf("|") + 1;
	subS = txt.substring(index);
	index = subS.indexOf("|") + 1;
	subS = subS.substring(index);
	index = subS.indexOf("|") + 1;
	subS = subS.substring(index);

	index = subS.indexOf(":") + 1;
	subS = subS.substring(index);
	indez2 = subS.length();

	String hs = ((String) subS.subSequence(0, indez2)).trim();
	return hs;
    }

    public static String nombreMateria(String txt) {
	int index = txt.indexOf(" ") + 1;
	String subS = txt.substring(index);
	index = subS.length() - 1;
	subS = (subS.substring(0, index)).trim();
	return subS;
    }

    public static String facultadMateria(String txt) {
	String subS = (txt.substring(txt.length() - 1, txt.length())).trim();
	return subS;
    }

}
