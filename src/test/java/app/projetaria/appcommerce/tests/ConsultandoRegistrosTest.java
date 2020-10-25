package app.projetaria.appcommerce.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class ConsultandoRegistrosTest {

	private String persistenceUnit = "app-ecommerce-mysql-connection";
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@BeforeClass
	public void initOnInstance() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.persistenceUnit);
	}

	@AfterClass
	public void destroyOnInstance() {
		this.entityManagerFactory.close();
	}

	@Before
	public void initOnMethod() {
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@After
	public void destroyOnMethod() {
		this.entityManager.close();
	}
	
	
}
