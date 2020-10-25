package app.projetaria.appcommerce.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import app.projetaria.appcommerce.entity.Produto;

public class ConsultandoRegistrosTest {

	private static String persistenceUnit = "app-ecommerce-mysql-connection";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	@BeforeClass
	public static void initOnInstance() {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
	}

	@AfterClass
	public static void destroyOnInstance() {
		entityManagerFactory.close();
	}

	@Before
	public void initOnMethod() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void destroyOnMethod() {
		entityManager.close();
	}
	
	@Test
	public void buscarPorIdTest() {
		//lazy => getReference
		//Produto produto = entityManager.getReference(Produto.class, 1);
		
		Produto produto = entityManager.find(Produto.class, 1);
		
		Assert.assertNotNull(produto);
		Assert.assertEquals("Kindle", produto.getNome());
	}
}
