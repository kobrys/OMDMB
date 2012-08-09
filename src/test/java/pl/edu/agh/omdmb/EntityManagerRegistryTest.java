package pl.edu.agh.omdmb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class EntityManagerRegistryTest {

    public static final String ENTITY_MANAGER_1 = "ENTITY_MANAGER_1";
    public static final String ENTITY_MANAGER_2 = "ENTITY_MANAGER_2";
    EntityManagerRegistry entityManagerRegistry;

    @Mock EntityManager entityManager1;
    @Mock EntityManager entityManager2;

    @Before
    public void setUp() {
        entityManagerRegistry = new EntityManagerRegistry();
    }

    @Test
    public void shouldReturnEmptyRegistry() {
        assertEquals(0, entityManagerRegistry.getEntityManagersNames().size());
    }

    @Test
    public void shouldReturnOneElementRegistryList() {
        entityManagerRegistry.register(ENTITY_MANAGER_1, entityManager1);

        assertEquals(1, entityManagerRegistry.getEntityManagersNames().size());

        List<String> entityManagersNames = entityManagerRegistry.getEntityManagersNames();

        assertEquals(ENTITY_MANAGER_1, entityManagersNames.get(0));
        assertEquals(entityManager1, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_1));
    }

    @Test
    public void shoultReturnTwoElementsRegistry() {
        entityManagerRegistry.register(ENTITY_MANAGER_1, entityManager1);
        entityManagerRegistry.register(ENTITY_MANAGER_2, entityManager2);

        assertEquals(2, entityManagerRegistry.getEntityManagersNames().size());

        List<String> entityManagersNames = entityManagerRegistry.getEntityManagersNames();

        assertTrue(entityManagersNames.contains(ENTITY_MANAGER_1));
        assertEquals(entityManager1, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_1));

        assertTrue(entityManagersNames.contains(ENTITY_MANAGER_2));
        assertEquals(entityManager2, entityManagerRegistry.getEntityManager(ENTITY_MANAGER_2));
    }

}
