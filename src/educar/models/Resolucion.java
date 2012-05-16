package educar.models;

import educar.db.JPA;

public class Resolucion {
	private static JPA jpa = new JPA();
	private String codResolucion;
	private String hrEnvio;
	private String fecha;
	private String dniDocente;
	private String codActividad;
	private String dniAlumno;
	private String nota;

	public Resolucion(String codResolucion, String hrEnvio, String fecha,
			String dniDocente, String codActividad, String dniAlumno,
			String nota) {
		this.setCodResolucion(codResolucion);
		this.setHrEnvio(hrEnvio);
		this.setFecha(fecha);
		this.setDniDocente(dniDocente);
		this.setCodAtividad(codActividad);
		this.setDniAlumno(dniAlumno);
		this.setNota(nota);

	}

	public void setNota(String nota) {
		// TODO Auto-generated method stub
		this.nota = nota;
	}

	public String getNota(){
		return this.nota;
	}
	
	public void setDniAlumno(String dniAlumno) {
		// TODO Auto-generated method stub
		this.dniAlumno=dniAlumno;
	}

	public String getDniAlumno(){
		return this.dniAlumno;
	}
	
	public void setCodAtividad(String codActividad) {
		// TODO Auto-generated method stub
    this.codActividad=codActividad;
	}

	public String getCodActividad(){
		return this.codActividad;
	}
	
	public void setDniDocente(String dniDocente) {
		// TODO Auto-generated method stub
     this.dniDocente=dniDocente;
	}

	public String getDniDocente(){
		return this.dniDocente;
	}
	public void setFecha(String fecha) {
		// TODO Auto-generated method stub
       this.fecha=fecha;
	}

	public String getFecha(){
		return this.fecha;
	}
	
	public void setHrEnvio(String hrEnvio) {
		// TODO Auto-generated method stub
    this.hrEnvio=hrEnvio;
	}

	public String getHrEnvio(){
		return this.hrEnvio;
	}

	public void setCodResolucion(String codResolucion) {
		// TODO Auto-generated method stub
     this.codResolucion=codResolucion;
	}

	public String getCodigoResolucion(){
		return this.codResolucion;
	}
}
