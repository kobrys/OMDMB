package pl.edu.agh.omdmb.persistence;

import com.sun.org.apache.xml.internal.serializer.utils.BoolStack;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import javax.persistence.EntityManager;
import java.util.*;

public class EntityManagerRegistry {

    private Map<String, EntityManager> entityManagerMap;

    public EntityManagerRegistry() {
        entityManagerMap = new HashMap();
    }

    public void register(String entityManagerType, EntityManager entityManager) {
        if (!entityManagerMap.containsKey(entityManagerType)) {
            entityManagerMap.put(entityManagerType, entityManager);
        } else {
            throw new IllegalArgumentException("ElementManager of type " + entityManagerType + " already registered");
        }
    }

    public EntityManager getEntityManager(String entityManagerType) {
        if (entityManagerMap.containsKey(entityManagerType)) {
            return entityManagerMap.get(entityManagerType);
        }
        throw new NoSuchElementException("EntityManager of type " + entityManagerType + " registered");
    }

    public Collection<String> getEntityManagersNames() {
        return entityManagerMap.keySet();
    }
}
