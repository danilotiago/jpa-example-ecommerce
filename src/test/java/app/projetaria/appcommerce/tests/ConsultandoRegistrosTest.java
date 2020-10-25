package app.projetaria.appcommerce.tests;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Produto;

public class ConsultandoRegistrosTest extends EntityManagerTest {

	@Test
	public void buscarPorIdTest() {
		// lazy => getReference
		// Produto produto = entityManager.getReference(Produto.class, 1);

		Produto produto = entityManager.find(Produto.class, 1);

		Assert.assertNotNull(produto);
		Assert.assertEquals("Kindle", produto.getNome());
	}
}
