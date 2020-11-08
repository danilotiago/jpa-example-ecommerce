package app.projetaria.appcommerce.tests;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Categoria;
import app.projetaria.appcommerce.entity.Cliente;
import app.projetaria.appcommerce.entity.Produto;

public class ConsultandoRegistrosTest extends EntityManagerTest {

	@Test
	public void buscarProdutoPorIdTest() {
		// lazy => getReference
		// Produto produto = entityManager.getReference(Produto.class, 1);

		Produto produto = entityManager.find(Produto.class, 1);

		Assert.assertNotNull(produto);
		Assert.assertEquals("Kindle", produto.getNome());
	}
	
	@Test
	public void buscarClientePorIdTest() {
		// lazy => getReference
		// Cliente cliente = entityManager.getReference(Cliente.class, 1);

		Cliente cliente = entityManager.find(Cliente.class, 1);

		Assert.assertNotNull(cliente);
		Assert.assertEquals("Danilo Tiago", cliente.getNome());
	}
	
	@Test
	public void buscarCategoriaRaizPorIdTest() {
		Integer totalCategoriasFilha = 2;
		
		Categoria categoria = entityManager.find(Categoria.class, 1);
		
		Assert.assertTrue(totalCategoriasFilha == categoria.getCategoriasFilha().size());
	}
	
	@Test
	public void buscarCategoriaFilhaPorIdTest() {
		String categoriaRaizNome = "Eletrônicos";
		
		Categoria categoriaFilha = entityManager.find(Categoria.class, 2);
		
		Assert.assertEquals(categoriaRaizNome, categoriaFilha.getCategoriaRaiz().getNome());
	}
}
