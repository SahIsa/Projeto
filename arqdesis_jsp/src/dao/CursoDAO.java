package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory.ConnectionFactory;
import to.CursoTO;
import to.ListaDeCursos;

public class CursoDAO {
	public void incluir(CursoTO to) {
		String sqlInsert = "INSERT INTO Curso (nomeCurso, dataIniCurso, dataFimCurso, valorCurso, numVagasCurso) VALUES (?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNomeCurso());
			stm.setString(2, to.getDataIniCurso());
			stm.setString(3, to.getDataFimCurso());
			stm.setString(4, to.getValorCurso());
			stm.setString(5, to.getNumVagasCurso());
			stm.execute();
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm1 = conn.prepareStatement(sqlSelect); 
					ResultSet rs = stm1.executeQuery();) {
				if (rs.next()) {
					to.setIdCurso(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(CursoTO to) {
		String sqlUpdate = "UPDATE Curso SET nomeCurso = ?, dataIniCurso = ?, dataFimCurso = ? , valorCurso = ?, numVagasCurso = ? WHERE idCurso = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNomeCurso());
			stm.setString(2, to.getDataIniCurso());
			stm.setString(3, to.getDataFimCurso());
			stm.setString(4, to.getValorCurso());
			stm.setString(5, to.getNumVagasCurso());
			stm.setInt(6, to.getIdCurso());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(CursoTO to) {
		String sqlDelete = "DELETE from Curso WHERE idCurso = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getIdCurso());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CursoTO carregar(int idCurso) {
		CursoTO to = new CursoTO();
		to.setIdCurso(idCurso);
		String sqlSelect = "SELECT nomeCurso, dataIniCurso, dataFimCurso, valorCurso, numVagasCurso FROM Curso WHERE idCurso = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idCurso);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNomeCurso(rs.getString("nomeCurso"));
					to.setDataIniCurso(rs.getString("dataIniCurso"));
					to.setDataFimCurso(rs.getString("dataFimCurso"));	
					to.setValorCurso(rs.getString("valorCurso"));
					to.setNumVagasCurso(rs.getString("numVagasCurso"));
					to.setIdCurso(rs.getInt("idCurso"));
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
