package pl.edu.agh.omdmb;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.Enumeration;
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
