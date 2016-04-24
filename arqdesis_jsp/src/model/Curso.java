package model;

import dao.CursoDAO;
import to.CursoTO;

public class Curso {
	
	private String nomeCurso, dataIniCurso, dataFimCurso, valorCurso, numVagasCurso;
	private int idCurso;
	
	public Curso(int idCurso, String nomeCurso, String dataIniCurso, String dataFimCurso, String valorCurso, String numVagasCurso) {
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.dataIniCurso = dataIniCurso;
		this.dataFimCurso = dataFimCurso;
		this.valorCurso = valorCurso;
		this.numVagasCurso = numVagasCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public void setDataIniCurso(String dataIniCurso) {
		this.dataIniCurso = dataIniCurso;
	}

	public void setDataFimCurso(String dataFimCurso) {
		this.dataFimCurso = dataFimCurso;
	}

	public void setValorCurso(String valorCurso) {
		this.valorCurso = valorCurso;
	}

	public void setNumVagasCurso(String numVagasCurso) {
		this.numVagasCurso = numVagasCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public String getDataIniCurso() {
		return dataIniCurso;
	}

	public String getDataFimCurso() {
		return dataFimCurso;
	}

	public String getValorCurso() {
		return valorCurso;
	}

	public String getNumVagasCurso() {
		return numVagasCurso;
	}

	public int getIdCurso() {
		return idCurso;
	}
	
	public void criar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getTO();
		dao.incluir(to);
		this.idCurso = to.getIdCurso();
	}

	public CursoTO getTO() {
		CursoTO to = new CursoTO();
		to.setIdCurso(idCurso);
		to.setNomeCurso(nomeCurso);
		to.setDataIniCurso(dataIniCurso);
		to.setDataFimCurso(dataFimCurso);
		to.setValorCurso(valorCurso);
		to.setNumVagasCurso(numVagasCurso);
		return to;
	}

	public void atualizar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = new CursoTO();
		to.setIdCurso(idCurso);
		dao.excluir(to);
	}

	public void carregar() {
		CursoDAO dao = new CursoDAO();
		CursoTO to = dao.carregar(idCurso);
		idCurso = to.getIdCurso();
		nomeCurso = to.getNomeCurso();
		dataIniCurso = to.getDataIniCurso();
		dataFimCurso = to.getDataFimCurso();
		valorCurso = to.getValorCurso();
		numVagasCurso = to.getNumVagasCurso();
	}
	
}
