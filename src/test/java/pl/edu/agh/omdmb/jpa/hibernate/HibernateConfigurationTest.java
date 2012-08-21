package pl.edu.agh.omdmb.jpa.hibernate;

import org.junit.Test;
import org.mockito.Spy;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class HibernateConfigurationTest {

    @Spy
    HibernateConfiguration hibernateConfiguration;

    Properties hibernateProperties = new Properties();
    List<Class<?>> annotatedClasses = new LinkedList<Class<?>>();

    @Test
    public void shouldCreateHibernateConfiguration() {
        hibernateConfiguration = new HibernateConfiguration(hibernateProperties, annotatedClasses);

        fail();
    }
}
