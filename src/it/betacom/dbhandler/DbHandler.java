package it.betacom.dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandler {

	private static final String jdbc_url = "jdbc:mysql://localhost:3306/esEstrazione";
	private static final String username = "root";
	private static final String password = "rootroot";
	
	private static Connection connection;
	
	private DbHandler() {
		
	}
	
	public static Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(jdbc_url, username, password);
			}
			return connection;
		} catch (SQLException e) {
			System.out.println("Errore connessione db " + e);
		}
		return null;
	}
	
	public static void closeConnection() {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Impossibile chiudere la connessione "+ e);
		}
	}
}
