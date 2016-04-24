package model;

import dao.AlunoDAO;
import to.AlunoTO;
import to.ListaDeAlunos;

public class Aluno {
	private String cpf, nome, rg, email, telefone;
	private int id;

	public Aluno(String nome, String email, String pCpf, String pRg, String telefone, int id) {
		this.nome = nome;
		this.email = email;
		this.cpf = pCpf;
		this.rg = pRg;
		this.telefone = telefone;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void criar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.incluir(to);
		this.id = to.getId();
	}

	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setCpf(cpf);
		to.setNome(nome);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setRg(rg);
		to.setId(id);
		return to;
	}

	public void atualizar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = getTO();
		dao.atualizar(to);
	}

	public void excluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		dao.excluir(to);
	}

	public void carregar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.carregar(id);
		cpf = to.getCpf();
		nome = to.getNome();
		telefone = to.getTelefone();
		email = to.getEmail();
		rg = to.getRg();
		id = to.getId();
	}
}
