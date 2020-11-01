package app.projetaria.appcommerce.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import app.projetaria.appcommerce.EntityManagerTest;
import app.projetaria.appcommerce.entity.Cliente;
import app.projetaria.appcommerce.entity.Endereco;
import app.projetaria.appcommerce.entity.Pedido;
import app.projetaria.appcommerce.entity.Produto;
import app.projetaria.appcommerce.enums.SexoCliente;
import app.projetaria.appcommerce.enums.StatusPedido;

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
		cliente.setSexo(SexoCliente.FEMININO);

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
	
	@Test
	public void criarPedidoTest() {
		
		Endereco endereco = new Endereco();
		Pedido pedido = new Pedido();
		
		endereco.setCep("03000-011");
		endereco.setLogradouro("Rua JPA sete");
		endereco.setNumero("58");
		endereco.setBairro("Lones");
		endereco.setCidade("São Carlos");
		endereco.setEstado("São Paulo");
		
		pedido.setEnderecoEntrega(endereco);
		
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(1000.00);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoCadastrado = entityManager.find(Pedido.class, 1);
		
		Assert.assertNotNull(pedidoCadastrado);
		Assert.assertEquals(pedido.getTotal(), pedidoCadastrado.getTotal());
		
	}
}
