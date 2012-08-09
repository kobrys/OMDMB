package pl.edu.agh.omdmb.component.jpa;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.component.jpa.dao.FirstDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class JpaManagerTest {

    EntityManagerFactory emf;
    EntityManager em;

    @Before
    public void setUp() {
        Properties props = new Properties();
        props.put("hibernate.connection.url", "jdbc:postgresql://localhost/postgres");
        props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        props.put("hibernate.connection.username", "postgres");
        props.put("hibernate.connection.password", "a23d2a87m");
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");

//        Configuration config = new Configuration().addAnnotatedClass(FirstDao.class).addProperties(props);
//        config.buildSessionFactory(null);
//        config.configure();
//        new SchemaExport(config).create(true, true);




        Ejb3Configuration conf = new Ejb3Configuration();
        em = conf.addProperties(props).addAnnotatedClass(FirstDao.class).buildEntityManagerFactory().createEntityManager();
    }

    @Test
    public void shouldAutoSetUpDatabaseConnection() {
        FirstDao firstDao = new FirstDao();
        firstDao.setStringField("stringFieldValue");

        em.getTransaction().begin();
        em.persist(firstDao);
        em.getTransaction().commit();
    }

    @After
    public void tearDown() {
        em.close();
    }
}
