package pl.edu.agh.omdmb.persistence.provider.hibernate;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Properties;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class HibernateEntityManagerConfigurationTest {

    HibernateEntityManagerConfiguration hibernateEntityManagerConfiguration;

    protected Properties properties;
    protected Set<Class<?>> annotatedClasses;

    @Before
    public void setUp() {
        properties = Mockito.mock(Properties.class);
        annotatedClasses = Mockito.mock(Set.class);

        hibernateEntityManagerConfiguration = new HibernateEntityManagerConfiguration(properties, annotatedClasses);
    }

    @Test
    public void shouldInitConfigurationAndReturnAnnotatedClasses() {
        assertEquals(annotatedClasses, hibernateEntityManagerConfiguration.getAnnotatedClasses());
    }

    @Test
    public void shouldInitConfigurationAndReturnProperties() {
        assertEquals(properties, hibernateEntityManagerConfiguration.getConfigurationProperties());
    }

    @Test
    public void shouldCreateEjbConfiguration() {
        assertThat(hibernateEntityManagerConfiguration.createEjbConfiguration(), instanceOf(Ejb3Configuration.class));
    }
}
