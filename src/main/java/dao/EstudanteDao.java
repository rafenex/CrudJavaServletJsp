package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Estudante;


public class EstudanteDao implements CRUD {
	// criando conexão com o banco de dados
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Estudante estudante) {
		sql = "INSERT INTO estudantes VALUES(null, ?, ?, ?, ?, ?)";

		// preparando os parametros para serem inseridos ao banco de dados
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, estudante.getNome());
			preparedStatement.setString(2, estudante.getCurso());
			preparedStatement.setString(3, estudante.getCpf());
			preparedStatement.setString(4, estudante.getImagem());
			preparedStatement.setString(5, estudante.getSituacao());
	

			// executa uma atualização/inserção/delete no banco
			preparedStatement.executeUpdate();

			System.out.println("== estudante inserido no banco de dados");

		} catch (Exception e) {
			System.out.println("== estudante não inserido no banco de dados " + e.getMessage());
		}
	}

	public static List<Estudante> find(String pesquisa) {
		sql = String.format("SELECT * FROM estudantes WHERE nome like '%s%%' OR cpf LIKE '%S%%' ", pesquisa, pesquisa);
		List<Estudante> estudantes = new ArrayList<Estudante>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Estudante estudante = new Estudante();
				estudante.setId(resultSet.getInt("id"));
				estudante.setNome(resultSet.getString("nome"));
				estudante.setCurso(resultSet.getString("curso"));
				estudante.setCpf(resultSet.getString("cpf"));
				estudante.setImagem(resultSet.getString("imagem"));
				estudante.setSituacao(resultSet.getString("situacao"));
		

				estudantes.add(estudante);
			}

			System.out.println("--Correta pesquisa por estudantes");
			return estudantes;
		} catch (SQLException e) {
			System.out.println("--Incorreta pesquisa por estudantes" + e.getMessage());
			return null;
		}

	}

	public static void delete(int estudanteId) {
		sql = "DELETE FROM estudantes WHERE id = ?";
		try {
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setInt(1, estudanteId);
			preparedStatment.executeUpdate();
			System.out.println("Estudante deletado");
		} catch (SQLException e) {
			System.out.println("Estudante não deletado ERRO " + e.getMessage());
		}

	}

	public static Estudante findByPk(int estudanteId) {
		sql = String.format("SELECT * FROM estudantes WHERE id = %d ", estudanteId);		

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Estudante estudante = new Estudante();

			while (resultSet.next()) {
				
				estudante.setId(resultSet.getInt("id"));
				estudante.setNome(resultSet.getString("nome"));
				estudante.setCurso(resultSet.getString("curso"));
				estudante.setCpf(resultSet.getString("cpf"));
				estudante.setImagem(resultSet.getString("imagem"));
				estudante.setSituacao(resultSet.getString("situacao"));
		
			}

			System.out.println("--Busca por primary key");
			return estudante;

		} catch (SQLException e) {
			System.out.println("--Busca por primary key ERRO" + e.getMessage());
			return null;
		}

	}
	public static void update(Estudante estudante) {
		
		sql = "UPDATE estudantes SET nome=?, curso=?, cpf=?, imagem=?, situacao=? WHERE id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, estudante.getNome());
			preparedStatement.setString(2, estudante.getCurso());
			preparedStatement.setString(3, estudante.getCpf());
			preparedStatement.setString(4, estudante.getImagem());
			preparedStatement.setString(5, estudante.getSituacao());
			preparedStatement.setInt(6, estudante.getId());
			

			preparedStatement.executeUpdate();

			System.out.println("--Atualização feita");

		} catch (SQLException e) {
			System.out.println("--Atualização não feita ERRO " + e.getMessage());
		}
	}
}
