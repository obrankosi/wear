package educar.models;

import educar.db.JPA;


public class Actividad {

	private static JPA jpa = new JPA();
	private String codigoActividad;
	private String descripcionActividad;
	private String nota;
	
	public Actividad(String codigoActividad,String descripcionActividad,String nota){
		 this.setCodigoActividad(codigoActividad);
	  	this.setDescripcionActividad(descripcionActividad);
		 this.setNota(nota);
	}

	private void setNota(String nota) {
		// TODO Auto-generated method stub
		this.codigoActividad=nota;
	}

	private void setDescripcionActividad(String descripcionActividad) {
		// TODO Auto-generated method stub
		this.descripcionActividad=descripcionActividad;
	}

	private void setCodigoActividad(String codigoAtividad) {
		// TODO Auto-generated method stub
		this.codigoActividad=codigoAtividad;
	}
	
}