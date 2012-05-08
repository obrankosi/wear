package educar.gui.AdminViews;

public class FuncionesAuxiliares {

    public static String idString(String s) {

	return (s.substring(0, s.indexOf(" "))).trim();
    }

    public static String nameString(String s) {

	return (s.substring(s.indexOf(" "), s.length())).trim();
    }
    
    /***************************funciones para campos de texto en la view ***********************************************************/
    /** asignacion Docente 
    * 			Encargado & designacion***/
    public static boolean camposVaciosAsignacionDocente( String campo1,String campo2) {
	return (campo1.compareTo("") == 0)
		|| (campo2.compareTo("") == 0);
    }
    

}
