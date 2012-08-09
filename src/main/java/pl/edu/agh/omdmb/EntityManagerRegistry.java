package pl.edu.agh.omdmb;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManagerRegistry {

    private Map<String, EntityManager> entityManagerMap;

    public EntityManagerRegistry() {
        entityManagerMap = new HashMap<String, EntityManager>();
    }

    public List<String> getEntityManagersNames() {
        return new ArrayList<String>(entityManagerMap.keySet());
    }

    public void register(String entityManagerName, EntityManager entityManager) {
        entityManagerMap.put(entityManagerName, entityManager);
    }

    public EntityManager getEntityManager(String entityManagerName) {
        return entityManagerMap.get(entityManagerName);
    }
}
