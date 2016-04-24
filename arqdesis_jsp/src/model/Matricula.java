package model;

public class Matricula {
	
	private String nome, dataMatricula, dataCancelMatricula, statusPagMatricula, valorMatricula;
	private int idMatricula, idAluno, idCurso;
	
	public Matricula(String nome, String dataMatricula, String dataCancelMatricula, String statusPagMatricula,
			String valorMatricula, int idMatricula, int idAluno, int idCurso) {
		this.nome = nome;
		this.dataMatricula = dataMatricula;
		this.dataCancelMatricula = dataCancelMatricula;
		this.statusPagMatricula = statusPagMatricula;
		this.valorMatricula = valorMatricula;
		this.idMatricula = idMatricula;
		this.idAluno = idAluno;
		this.idCurso = idCurso;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public void setDataCancelMatricula(String dataCancelMatricula) {
		this.dataCancelMatricula = dataCancelMatricula;
	}

	public void setStatusPagMatricula(String statusPagMatricula) {
		this.statusPagMatricula = statusPagMatricula;
	}

	public void setValorMatricula(String valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public String getDataCancelMatricula() {
		return dataCancelMatricula;
	}

	public String getStatusPagMatricula() {
		return statusPagMatricula;
	}

	public String getValorMatricula() {
		return valorMatricula;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public int getIdCurso() {
		return idCurso;
	}

}
