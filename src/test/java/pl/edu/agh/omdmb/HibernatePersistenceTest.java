package pl.edu.agh.omdmb;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Test;
import pl.edu.agh.omdmb.component.jpa.dao.FirstDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class HibernatePersistenceTest {

    private EntityManagerFactory entityManagerFactory;

    @Test
    public void shouldCreateHibernatePersistence() {
        Properties properties = new Properties();
        URL url = ClassLoader.getSystemResource("META-INF/hibernate_connection.properties");

        try {
            properties.load(new FileInputStream(new File(url.getFile())));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        Ejb3Configuration configuration = new Ejb3Configuration().addProperties(properties).addAnnotatedClass(FirstDao.class);
        configuration.buildEntityManagerFactory();



    }

}
