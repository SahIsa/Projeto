package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import to.CursoTO;
import dao.CursoDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDAOTest {
	static CursoDAO dao;
	static CursoTO to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe ClienteTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		dao = new CursoDAO();
		to = new CursoTO();
		to.setNomeCurso("Jornalismo");
		to.setDataIniCurso("21/02/2016");
		to.setDataFimCurso("21/05/2016");
		to.setValorCurso("1,000.00");
		to.setNumVagasCurso("20");
		to.setIdCurso(-1);
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone, email) values ('nome1', 'fone1', 'email1');
		CursoTO fixture = new CursoTO();
		fixture.setNomeCurso(nomeCurso);
		fixture.setDataIniCurso(dataIniCurso);
		fixture.setDataFimCurso(dataFimCurso);
		fixture.setValorCurso(valorCurso);
		fixture.setNumVagasCurso(numVagasCurso);
		fixture.setIdCurso(1);
		CursoTO novo = dao.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		CursoTO novo = dao.carregar(to.getIdCurso());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setValorCurso("5.000,00");
		dao.atualizar(to);
		CursoTO novo = dao.carregar(to.getIdCurso());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setNomeCurso(null);
		to.setDataIniCurso(null);
		to.setDataFimCurso(null);
		to.setValorCurso(null);
		to.setNumVagasCurso(null);
		dao.excluir(to);
		CursoTO novo = dao.carregar(to.getIdCurso());
		assertEquals("testa inclusao", novo, to);
	}
}
