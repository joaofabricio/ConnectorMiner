package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GerenciadorConexao {
	
	private static GerenciadorConexao instance; 
	
	private static Connection conn = null;
	
	private String host = "localhost";
	private String porta = "5432";
	private String usuario = "postgres";
	private String senha = "postgres";
	
//	private String banco = "junit";
//	private String banco = "ci";
//	private String banco = "diaspora";
//	private String banco = "cs";
	private String banco = "bootstrap";
	
	private GerenciadorConexao() throws Exception {
		Class.forName("org.postgresql.Driver");
			
		conn = DriverManager.getConnection("jdbc:postgresql://"+host+":"+porta+"/"+banco, usuario, senha); 
			
	}

	public static GerenciadorConexao getInstance() throws Exception {
		return instance == null? instance = new GerenciadorConexao() : instance;
	}

	public ResultSet executeSQL(String query) {
		
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static void encerrarConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
