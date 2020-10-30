package app.projetaria.appcommerce.tests;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Cliente;
import app.projetaria.appcommerce.entity.Produto;

public class AtualizandoRegistrosTest extends EntityManagerTest {

	@Test
	public void atualizandoProdutoTest() {

		Produto produto = entityManager.find(Produto.class, 2);

		String novoNome = produto.getNome() + " com novo nome";

		entityManager.getTransaction().begin();
		// altera o nome do produto
		// nao precisamos usar o merge se o objeto ja for gerenciado pelo JPA
		produto.setNome(novoNome);
		entityManager.getTransaction().commit();

		// limpando a memoria do entity manager para buscar novamente o produto
		entityManager.clear();

		Produto produtoAtualizado = entityManager.find(Produto.class, 2);

		Assert.assertTrue(produtoAtualizado.getNome().equals(novoNome));
	}
	
	@Test
	public void atualizandoClienteTest() {

		Cliente cliente = entityManager.find(Cliente.class, 2);

		String novoNome = cliente.getNome() + " com novo nome";

		entityManager.getTransaction().begin();
		// altera o nome do produto
		// nao precisamos usar o merge se o objeto ja for gerenciado pelo JPA
		cliente.setNome(novoNome);
		entityManager.getTransaction().commit();

		// limpando a memoria do entity manager para buscar novamente o produto
		entityManager.clear();

		Cliente clienteAtualizado = entityManager.find(Cliente.class, 2);

		Assert.assertTrue(clienteAtualizado.getNome().equals(novoNome));
	}
}
