package test;

import static org.junit.Assert.assertEquals;
import model.Cliente;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {
	Cliente cliente, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente(3, "Bela Lugosi", "123456789", "bela@bauhaus.net" );
		copia = new Cliente(3, "Bela Lugosi", "123456789", "bela@bauhaus.net" );
	}
	
	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone) values ('nome1', 'fone1');
		Cliente fixture = new Cliente(1, "nome1", "fone1", "email1");
		Cliente novo = new Cliente(1, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		cliente.criar();
		cliente.carregar();
		copia.setId(cliente.getId());
		assertEquals("testa criacao", cliente, copia);
	}

	@Test
	public void test02Atualizar() {
		cliente.setFone("999999");
		copia.setFone("999999");		
		cliente.atualizar();
		assertEquals("testa inclusao", cliente, copia);
	}

	@Test
	public void test03Excluir() {
		cliente.setNome(null);
		cliente.setFone(null);
		copia.setNome(null);
		copia.setFone(null);
		cliente.excluir();
		assertEquals("testa inclusao", cliente, copia);
	}
}