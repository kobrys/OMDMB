package pl.edu.agh.omdmb;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HibernateEntityManagerProviderTest {

    HibernateEntityManagerProvider entityManagerProvider;

    @Mock HibernateConfiguration configuration;
    @Mock Ejb3Configuration ejb3Configuration;
    @Mock EntityManagerFactory entityManagerFactory;
    @Mock EntityManager entityManager;

    @Test
    public void shouldCreateEntityManager() {
        given(configuration.getEjbConfiguration()).willReturn(ejb3Configuration);
        given(ejb3Configuration.buildEntityManagerFactory()).willReturn(entityManagerFactory);
        given(entityManagerFactory.createEntityManager()).willReturn(entityManager);

        entityManagerProvider = new HibernateEntityManagerProvider(configuration);

        verify(configuration).getEjbConfiguration();
        verify(ejb3Configuration).buildEntityManagerFactory();
        verify(entityManagerFactory).createEntityManager();

        assertEquals(entityManager, entityManagerProvider.getEntityManager());
    }
}
