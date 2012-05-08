package educar.models.AdminModels;


public class AsignacionDocente {

    private Subject materia;
    private Docente docente;

    public AsignacionDocente() {
	// TODO Auto-generated constructor stub
    }

    /**
     * el codigo de la materia lo saco al hacer doble click en la lista de las
     * materias
     * 
     * @param codigoMateria
     * @return true ssi la materia tiene profesor acargo
     * @throws SubjectNotFound
     */
    public boolean tieneDocenteAcargo(String codigoMateria)
	    throws SubjectNotFound {
	materia = Subject.getSubject(codigoMateria);
	if (materia == null) {
	    throw new SubjectNotFound();
	} else
	    return !(materia.getRTeacher().isEmpty());
    }
    

}
