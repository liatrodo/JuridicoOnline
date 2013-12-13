package br.com.juridicoOnline.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {
	public static void main(String[] args) {
		Connection conexao = null;
		try {
			String url = "jdbc:mysql://localhost/JuridicoOnLine";
			String usuario = "root";
			String senha = "Cota60";
			
			conexao = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Connectou");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL. Erro: " + e.getMessage());
		} finally {
			try{
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar a conexao. Erro:" + e.getMessage());
			}
		}
		
	}
}
