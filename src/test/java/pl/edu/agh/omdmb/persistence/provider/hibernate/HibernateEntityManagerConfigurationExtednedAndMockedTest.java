package pl.edu.agh.omdmb.persistence.provider.hibernate;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HibernateEntityManagerConfigurationExtednedAndMockedTest extends HibernateEntityManagerConfigurationTest {

    @Mock Ejb3Configuration ejb3Configuration;

    @Before
    public void setUp() {
        properties = preparePropertiesSet();
        annotatedClasses = prepareAnnotatedClassesSet();

        hibernateEntityManagerConfiguration = new SubclassedHibernateEntityManagerConfiguration(properties, annotatedClasses);
    }

    @Test
    public void shouldBuildEntityManagerConfiguration() {
        hibernateEntityManagerConfiguration.buildEntityManagerFactory();

        verify(ejb3Configuration, times(1)).addAnnotatedClass(String.class);
        verify(ejb3Configuration, times(1)).addProperties(properties);
        verify(ejb3Configuration, times(1)).buildEntityManagerFactory();
    }

    private Properties preparePropertiesSet() {
        return Mockito.mock(Properties.class);
    }

    private Set<Class<?>> prepareAnnotatedClassesSet() {
        Set<Class<?>> annotatedClasses = new HashSet();
        annotatedClasses.add(String.class);

        return annotatedClasses;
    }

    class SubclassedHibernateEntityManagerConfiguration extends HibernateEntityManagerConfiguration {

        protected SubclassedHibernateEntityManagerConfiguration(Properties aConfigurationProperties, Set<Class<?>> anAnnotatedClasses) {
            super(aConfigurationProperties, anAnnotatedClasses);
        }

        @Override
        protected Ejb3Configuration createEjbConfiguration() {
            return ejb3Configuration;
        }
    }
}
