package pl.edu.agh.omdmb.jpa;

import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManagerRegistry {

    private Map<EntityManagerProviderType, EntityManager> entityManagerMap;

    public EntityManagerRegistry() {
        entityManagerMap = new HashMap<EntityManagerProviderType, EntityManager>();
    }

    public List<EntityManagerProviderType> getEntityManagerTypes() {
        return new ArrayList<EntityManagerProviderType>(entityManagerMap.keySet());
    }

    public void register(EntityManagerProviderType entityManagerType, EntityManager entityManager) {
        entityManagerMap.put(entityManagerType, entityManager);
    }

    public EntityManager getEntityManager(EntityManagerProviderType entityManagerType) {
        return entityManagerMap.get(entityManagerType);
    }
}
