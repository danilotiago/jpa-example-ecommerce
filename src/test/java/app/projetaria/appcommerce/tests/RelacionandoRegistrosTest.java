package app.projetaria.appcommerce.tests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Categoria;
import app.projetaria.appcommerce.entity.Produto;

public class RelacionandoRegistrosTest extends EntityManagerTest {

	@Test
	public void relacionandoProdutoComCategoriaTest() {
		Integer quantidadeCategorias = 2;
		Produto produto = entityManager.find(Produto.class, 1);
		Categoria categoria1 = entityManager.find(Categoria.class, 1);
		Categoria categoria2 = entityManager.find(Categoria.class, 2);

		entityManager.getTransaction().begin();
		// fizemos a relacao a partir de produto pois ele eh o owner da relacao
		produto.setCategorias(Arrays.asList(categoria1, categoria2));
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoRelacao = entityManager.find(Produto.class, 1);

		Assert.assertTrue(quantidadeCategorias == produtoRelacao.getCategorias().size());
	}

}
