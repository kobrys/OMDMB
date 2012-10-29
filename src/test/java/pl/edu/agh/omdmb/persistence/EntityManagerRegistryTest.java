package pl.edu.agh.omdmb.persistence;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.HIBERNATE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.OBJECT_DB;

@RunWith(MockitoJUnitRunner.class)
public class EntityManagerRegistryTest {

    static final String ENTITY_MANAGER_1_NAME = "ENTITY_MANAGER_1_NAME";
    static final String ENTITY_MANAGER_2_NAME = "ENTITY_MANAGER_2_NAME";

    @Mock EntityManager entityManager1;
    @Mock EntityManager entityManager2;

    @InjectMocks
    EntityManagerRegistry entityManagerRegistry;

    @Before
    public void setUp() {
        entityManagerRegistry = new EntityManagerRegistry();
    }

    @Test
    public void shouldContainNoObjectsAtStart() {
        assertEquals(0, entityManagerRegistry.getEntityManagersNames().size());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionWhenObjectIsNotRegistered() {
        entityManagerRegistry.getEntityManager("NOT_REGISTERED_ENTITY_MANAGER");
    }

    @Test
    public void shouldAddAndReturnOneElement() {
        entityManagerRegistry.register(ENTITY_MANAGER_1_NAME, entityManager1);

        assertEquals(1, entityManagerRegistry.getEntityManagersNames().size());
        assertEquals(ENTITY_MANAGER_1_NAME, entityManagerRegistry.getEntityManagersNames().iterator().next());
        assertEquals(entityManager1, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_1_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenObjectIsAlreadyRegistered() {
        entityManagerRegistry.register(ENTITY_MANAGER_1_NAME, entityManager1);
        entityManagerRegistry.register(ENTITY_MANAGER_1_NAME, entityManager2);
    }

    @Test
    public void shouldRegisterTwoEntityManagers() {
        entityManagerRegistry.register(ENTITY_MANAGER_1_NAME, entityManager1);
        entityManagerRegistry.register(ENTITY_MANAGER_2_NAME, entityManager2);

        assertEquals(2, entityManagerRegistry.getEntityManagersNames().size());

        assertTrue(entityManagerRegistry.getEntityManagersNames().contains(ENTITY_MANAGER_1_NAME));
        assertTrue(entityManagerRegistry.getEntityManagersNames().contains(ENTITY_MANAGER_2_NAME));

        assertEquals(entityManager1, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_1_NAME));
        assertEquals(entityManager2, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_2_NAME));
    }
}
