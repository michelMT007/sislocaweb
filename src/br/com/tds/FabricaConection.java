package br.com.tds;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConection {
	public static Connection getConection() throws SQLException{
		
		
		String url = "jdbc:mysql://localhost:3306/dbempresa";
		String usuario = "root";
	    String senha = "admin";
	    try {
	 			Class.forName("com.mysql.jdbc.Driver");
	 			Connection conn = DriverManager.getConnection(url,usuario, senha);
	 			conn.setAutoCommit(false);
	 			return conn;
	 			
	 		} catch (ClassNotFoundException e) {
	 		//subindo erro para o usuario	
	 			e.printStackTrace();
	 			throw new SQLException("Driver não encontrado");
	 			
	 		} catch (SQLException e) {
	 		//subindo erro para o usuario	
	 			e.printStackTrace();
	 			throw e;
	 		}
	         
	        // outro modo de registrar o banco DriverManager.registerDriver(new Driver());
	 	
	}
	public static void main (String [] args){
		//FabricaConection con = new FabricaConection(); 
   	 	try {
   		 getConection().close();
   		 
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
   	 
    }
}
