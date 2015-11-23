package br.univel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
private static Connection con;
	
	public static Connection getConnection() {
		
		
				try {
					con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TrabalhoJava4Bi", "postgres",
					        "univel");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return con;
		
	}
}
