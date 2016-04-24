package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Aluno;
import to.AlunoTO;

public class AlunoDAO {

	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO Aluno (cpf, nome, rg, email, telefone) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getCpf());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getRg());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getTelefone());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm1 = conn.prepareStatement(sqlSelect); 
					ResultSet rs = stm1.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(AlunoTO to) {
		String sqlUpdate = "UPDATE Aluno set cpf=?, nome=?, rg=?, email=?, telefone=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getCpf());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getRg());
			stm.setString(4, to.getEmail());
			stm.setString(5, to.getTelefone());
			stm.setInt(6, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(AlunoTO to) {
		String sqlDelete = "DELETE from Aluno WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AlunoTO carregar(int id) {
		AlunoTO to = new AlunoTO();
		to.setId(id);
		String sqlSelect = "SELECT * from Aluno WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setRg(rs.getString("rg"));
					to.setEmail(rs.getString("email"));
					to.setTelefone(rs.getString("telefone"));
					to.setCpf(rs.getString("cpf"));
					to.setId(rs.getInt("id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
}
