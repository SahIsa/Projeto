package to;

public class CursoTO {
	private String nomeCurso, dataIniCurso, dataFimCurso, valorCurso, numVagasCurso;
	private int idCurso;
	
	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDataIniCurso() {
		return dataIniCurso;
	}

	public void setDataIniCurso(String dataIniCurso) {
		this.dataIniCurso = dataIniCurso;
	}

	public String getDataFimCurso() {
		return dataFimCurso;
	}

	public void setDataFimCurso(String dataFimCurso) {
		this.dataFimCurso = dataFimCurso;
	}

	public String getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(String valorCurso) {
		this.valorCurso = valorCurso;
	}

	public String getNumVagasCurso() {
		return numVagasCurso;
	}

	public void setNumVagasCurso(String numVagasCurso) {
		this.numVagasCurso = numVagasCurso;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoTO other = (CursoTO) obj;
		if (nomeCurso == null) {
			if (other.nomeCurso != null)
				return false;
		} else if (!nomeCurso.equals(other.nomeCurso))
			return false;
		if (dataIniCurso == null) {
			if (other.dataIniCurso != null)
				return false;
		} else if (!dataIniCurso.equals(other.dataIniCurso))
			return false;
		if (dataFimCurso == null) {
			if (other.dataFimCurso != null)
				return false;
		} else if (!dataFimCurso.equals(other.dataFimCurso))
			return false;
		if (idCurso != other.idCurso)
			return false;
		if (numVagasCurso != other.numVagasCurso)
			return false;
		if (valorCurso != other.valorCurso)
			return false;
		return true;
	}
}