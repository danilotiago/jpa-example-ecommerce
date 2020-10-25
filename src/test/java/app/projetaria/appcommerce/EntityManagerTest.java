package app.projetaria.appcommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EntityManagerTest {

	protected static String persistenceUnit = "app-ecommerce-mysql-connection";
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;

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
}
