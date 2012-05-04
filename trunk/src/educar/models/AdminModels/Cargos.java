package educar.models.AdminModels;

	
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import educar.db.JPA;

	public class Cargos {
		private static JPA jpa = new JPA();
		private String codigoCargo;
		private String nombreCargo;
	

		/**
		 * @param codigo cargo
		 * @param nombre cargo
		 */
		public Cargos(String codigoCargo, String nombreCargo) {
			this.setCodigoCargo(codigoCargo);
			this.setNombreCargo(nombreCargo);

		}


		
		
		
		
		
		
		private void setNombreCargo(String nombreCargo2) {
			this.nombreCargo=nombreCargo2;
			
		}


		private void setCodigoCargo(String codigoCargo2) {
			this.codigoCargo=codigoCargo2;
			
		}

}
