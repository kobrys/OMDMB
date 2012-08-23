package system.pl.edu.agh.omdmb.jpa.hibernate;

import org.junit.Test;
import pl.edu.agh.omdmb.jpa.hibernate.HibernateConfiguration;
import pl.edu.agh.omdmb.jpa.hibernate.HibernateEntityManagerProvider;
import pl.edu.agh.omdmb.testdao.FirstDao;

import javax.persistence.EntityManager;
import javax.persistence.spi.PersistenceProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class HibernateEntityManagerCreationTest {

    public static final String STRING_FIELD_VALUE = "stringFieldValue";
    private List<PersistenceProvider> persistenceProviders;

    @Test
    public void entityManagerTest() {
        Properties hibernateConnectionProperties = null;
        List<Class<?>> annotatedClasses = null;
        HibernateConfiguration hibernateConfiguration = null;
        FirstDao objectToPersist = null;

        hibernateConnectionProperties = givenHibernateConnectionProperties();
        annotatedClasses = givenAnnotatedClasses();
        hibernateConfiguration = givenHibernateConfiguration(hibernateConnectionProperties, annotatedClasses);
        objectToPersist = givenObjectToPersist();

        HibernateEntityManagerProvider entityManagerProvider = new HibernateEntityManagerProvider(hibernateConfiguration);

        EntityManager entityManager = entityManagerProvider.getEntityManager();

        persistObject(objectToPersist, entityManager);
        validatePersistence(objectToPersist, entityManager);
    }

    private Properties givenHibernateConnectionProperties() {
        Properties hibernateConnectionProperties = new Properties();
        URL url = ClassLoader.getSystemResource("META-INF/hibernate_connection.properties");

        try {
            hibernateConnectionProperties.load(new FileInputStream(new File(url.getFile())));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return hibernateConnectionProperties;
    }

    private List<Class<?>> givenAnnotatedClasses() {
        List<Class<?>> annotatedClasses = new LinkedList<Class<?>>();
        annotatedClasses.add(FirstDao.class);
        return annotatedClasses;
    }

    private HibernateConfiguration givenHibernateConfiguration(
            Properties hibernateConnectionProperties, List<Class<?>> annotatedClasses) {
        return new HibernateConfiguration(hibernateConnectionProperties, annotatedClasses);
    }

    private FirstDao givenObjectToPersist() {
        FirstDao objectToPersist = new FirstDao();
        objectToPersist.setStringField(STRING_FIELD_VALUE);
        return objectToPersist;
    }

    private void persistObject(FirstDao objectToPersist, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(objectToPersist);
        entityManager.getTransaction().commit();
    }

    private void validatePersistence(FirstDao objectToPersist, EntityManager entityManager) {
        FirstDao persistedObject = entityManager.find(FirstDao.class, objectToPersist.getId());

        assertNotNull(persistedObject);
        assertEquals(objectToPersist.getStringField(), persistedObject.getStringField());
    }
}
