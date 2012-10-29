package pl.edu.agh.omdmb.persistence.provider.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.persistence.provider.commons.EntityManagerConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HibernateEntityManagerBuilderTest {

    @Mock EntityManagerConfiguration entityManagerConfiguration;
    @Mock HibernateEntityManagerConfiguration hibernateEntityManagerConfiguration;
    @Mock EntityManagerFactory entityManagerFactory;
    @Mock EntityManager entityManager;

    HibernateEntityManagerBuilder hibernateEntityManagerBuilder;

    @Before
    public void setUp() {
        hibernateEntityManagerBuilder = new HibernateEntityManagerBuilder();
    }

    @Test(expected = ClassCastException.class)
    public void shouldThrowExceptionWhenIllegalConfigurationProvided() {
        hibernateEntityManagerBuilder.build(entityManagerConfiguration);
    }

    @Test
    public void shouldBuildEntityManager() {
        when(hibernateEntityManagerConfiguration.buildEntityManagerFactory()).thenReturn(entityManagerFactory);
        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);

        hibernateEntityManagerBuilder.build(hibernateEntityManagerConfiguration);

        verify(hibernateEntityManagerConfiguration, times(1)).buildEntityManagerFactory();
        verify(entityManagerFactory, times(1)).createEntityManager();
    }
}
