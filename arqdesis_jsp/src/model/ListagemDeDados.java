package model;

import dao.ListaDadosDAO;
import to.ListaDeAlunos;
import to.ListaDeCursos;

public class ListagemDeDados{
	
	/*
	 * LISTAGEM DE ALUNOS
	 */
	
	public ListaDeAlunos listarAlunos(){
		ListaDeAlunos lista;
		ListaDadosDAO dao = new ListaDadosDAO();
		lista = dao.listarAlunos();
		return lista;
	}
	public ListaDeAlunos listarAlunos(String chave){
		ListaDeAlunos lista;
		ListaDadosDAO dao = new ListaDadosDAO();
		lista = dao.listarAlunos(chave);
		return lista;
	}
	
	/*
	 * LISTAGEM DE CURSOS
	 */
	
	public ListaDeCursos listarCursos(){
		ListaDeCursos lista;
		ListaDadosDAO dao = new ListaDadosDAO();
		lista = dao.listarCursos();
		return lista;
	}
	public ListaDeCursos listarCursos(String chave){
		ListaDeCursos lista;
		ListaDadosDAO dao = new ListaDadosDAO();
		lista = dao.listarCursos(chave);
		return lista;
	}
}
