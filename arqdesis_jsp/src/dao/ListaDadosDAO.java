package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.AlunoTO;
import to.CursoTO;
import to.ListaDeAlunos;
import to.ListaDeCursos;

public class ListaDadosDAO {
	
	/*
	 *  LISTAGEM DE ALUNOS 
	 */
	
	public ListaDeAlunos listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT cpf, nome, rg, email, telefone, id FROM Aluno";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setCpf(rs.getString("cpf"));
					to.setNome(rs.getString("nome"));
					to.setRg(rs.getString("rg"));
					to.setEmail(rs.getString("email"));
					to.setTelefone(rs.getString("telefone"));
					to.setId(rs.getInt("id"));
					
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaDeAlunos ldc = new ListaDeAlunos();
		ldc.setAlunos(lista);
		return ldc;
	}
	
	public ListaDeAlunos listarAlunos(String chave) {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT cpf, nome, rg, email, telefone, id FROM aluno where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setCpf(rs.getString("cpf"));
					to.setNome(rs.getString("nome"));
					to.setRg(rs.getString("rg"));
					to.setEmail(rs.getString("email"));
					to.setTelefone(rs.getString("telefone"));
					to.setId(rs.getInt("id"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaDeAlunos ldc = new ListaDeAlunos();
		ldc.setAlunos(lista);
		return ldc;
	}
	
	/*
	 *  LISTAGEM DE CURSOS 
	 */
	
	public ListaDeCursos listarCursos() {
		CursoTO to;
		ArrayList<CursoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Curso";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoTO();
					to.setIdCurso(rs.getInt("idCurso"));
					to.setNomeCurso(rs.getString("nomeCurso"));
					to.setDataIniCurso(rs.getString("dataIniCurso"));
					to.setDataFimCurso(rs.getString("dataFimCurso"));
					to.setValorCurso(rs.getString("valorCurso"));
					to.setNumVagasCurso(rs.getString("numVagasCurso"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaDeCursos ldc = new ListaDeCursos();
		ldc.setCursos(lista);
		return ldc;
	}
	
	public ListaDeCursos listarCursos(String chave) {
		CursoTO to;
		ArrayList<CursoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Curso where upper(nomeCurso) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoTO();
					to.setIdCurso(rs.getInt("idCurso"));
					to.setNomeCurso(rs.getString("nomeCurso"));
					to.setDataIniCurso(rs.getString("dataIniCurso"));
					to.setDataFimCurso(rs.getString("dataFimCurso"));
					to.setValorCurso(rs.getString("valorCurso"));
					to.setNumVagasCurso(rs.getString("numVagasCurso"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaDeCursos ldc = new ListaDeCursos();
		ldc.setCursos(lista);
		return ldc;
	}
}
