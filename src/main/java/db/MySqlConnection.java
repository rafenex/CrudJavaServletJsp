package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	private static final String url = "jdbc:mysql://localhost:3306/estudantes";
	private static final String user = "root";
	private static final String password = "root";
	
	public static Connection createConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado com o banco de dados");
			return connection;
		} catch (Exception e) {
			System.out.println("Não Conectado com o banco de dados" + e.getMessage());
			return null;
		}
		
	}
	

}
