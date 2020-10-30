package app.projetaria.appcommerce.tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Cliente;
import app.projetaria.appcommerce.entity.Produto;

public class CriandoRegistrosTest extends EntityManagerTest {

	@Test
	public void criarProdutoTest() {
		Produto produto = new Produto();
		produto.setNome("Drone V6");
		produto.setDescricao("Voa até 1KM");
		produto.setPreco(new BigDecimal(5000));

		entityManager.getTransaction().begin();

		entityManager.persist(produto);

		entityManager.getTransaction().commit();

		// reseta a memoria do entity manager (removendo o produto acima) para testar se
		// o produto foi persistido, fazendo uma nova busca no banco
		entityManager.clear();
		
		Produto produtoCadastrado = entityManager.find(Produto.class, produto.getId());
		
		Assert.assertNotNull(produtoCadastrado);
		Assert.assertEquals(produto.getNome(), produtoCadastrado.getNome());
	}
	
	@Test
	public void criarClienteTest() {
		Cliente cliente = new Cliente();
		
		cliente.setNome("Marcela Oliveira");

		entityManager.getTransaction().begin();

		entityManager.persist(cliente);

		entityManager.getTransaction().commit();

		// reseta a memoria do entity manager (removendo o produto acima) para testar se
		// o produto foi persistido, fazendo uma nova busca no banco
		entityManager.clear();
		
		Cliente clienteCadastrado = entityManager.find(Cliente.class, cliente.getId());
		
		Assert.assertNotNull(clienteCadastrado);
		Assert.assertEquals(cliente.getNome(), clienteCadastrado.getNome());
	}
}
