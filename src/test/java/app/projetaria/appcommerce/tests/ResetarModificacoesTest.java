package app.projetaria.appcommerce.tests;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Produto;

public class ResetarModificacoesTest extends EntityManagerTest {

	@Test
	public void resetarModificacoesTest() {

		// nome => Kindle
		Produto produto = entityManager.find(Produto.class, 1);

		produto.setNome("Drone v6");

		// reseta as modificacoes do setNome, buscando novamente o objeto do banco
		entityManager.refresh(produto);

		Assert.assertEquals("Kindle", produto.getNome());
	}
}
