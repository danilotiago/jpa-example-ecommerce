package app.projetaria.appcommerce.tests;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Cliente;
import app.projetaria.appcommerce.entity.Produto;

public class RemovendoRegistrosTest extends EntityManagerTest {

	@Test
	public void removendoProdutoTest() {
		
		Produto produto = entityManager.find(Produto.class, 1);
		
		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
		
		Produto produtoRemovido = entityManager.find(Produto.class, 1);

		Assert.assertNull(produtoRemovido);
	}
	
	@Test
	public void removendoClienteTest() {
		
		Cliente cliente = entityManager.find(Cliente.class, 1);
		
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		Cliente clienteRemovido = entityManager.find(Cliente.class, 1);

		Assert.assertNull(clienteRemovido);
	}
}
