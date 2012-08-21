package pl.edu.agh.omdmb.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import javax.persistence.EntityManager;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.HIBERNATE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.OBJECT_DB;

@RunWith(MockitoJUnitRunner.class)
public class EntityManagerRegistryTest {

    public static final EntityManagerProviderType ENTITY_MANAGER_1 = HIBERNATE;
    public static final EntityManagerProviderType ENTITY_MANAGER_2 = OBJECT_DB;
    EntityManagerRegistry entityManagerRegistry;

    @Mock EntityManager entityManager1;
    @Mock EntityManager entityManager2;

    @Before
    public void setUp() {
        entityManagerRegistry = new EntityManagerRegistry();
    }

    @Test
    public void shouldReturnEmptyRegistry() {
        assertEquals(0, entityManagerRegistry.getEntityManagerTypes().size());
    }

    @Test
    public void shouldReturnOneElementRegistryList() {
        entityManagerRegistry.register(ENTITY_MANAGER_1, entityManager1);

        assertEquals(1, entityManagerRegistry.getEntityManagerTypes().size());

        List<EntityManagerProviderType> entityManagersNames = entityManagerRegistry.getEntityManagerTypes();

        assertEquals(ENTITY_MANAGER_1, entityManagersNames.get(0));
        assertEquals(entityManager1, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_1));
    }

    @Test
    public void shoultReturnTwoElementsRegistry() {
        entityManagerRegistry.register(ENTITY_MANAGER_1, entityManager1);
        entityManagerRegistry.register(ENTITY_MANAGER_2, entityManager2);

        assertEquals(2, entityManagerRegistry.getEntityManagerTypes().size());

        List<EntityManagerProviderType> entityManagersTypes = entityManagerRegistry.getEntityManagerTypes();

        assertTrue(entityManagersTypes.contains(ENTITY_MANAGER_1));
        assertEquals(entityManager1, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_1));

        assertTrue(entityManagersTypes.contains(ENTITY_MANAGER_2));
        assertEquals(entityManager2, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_2));
    }

}
