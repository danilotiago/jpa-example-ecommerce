package app.projetaria.appcommerce.tests;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Produto;

public class ClonandoRegistrosTest extends EntityManagerTest {

	@Test
	public void clonandoSetandoNovoIdTest() {
		
		Produto produto = entityManager.find(Produto.class, 1);
		
		// removendo o objeto do entitymanager
		entityManager.detach(produto);
		
		produto.setId(null);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(produto);
		
		entityManager.getTransaction().commit();
		
		// reseta a memoria do entity manager (removendo o produto acima) para testar se
		// o produto foi persistido, fazendo uma nova busca no banco
		entityManager.clear();
		
		Produto produtoCadastrado = entityManager.find(Produto.class, 2);
		
		Assert.assertNotNull(produtoCadastrado);
		Assert.assertEquals(produto.getNome(), produtoCadastrado.getNome());
	}
}
