package system.pl.edu.agh.omdmb.system;

import org.junit.Test;

import javax.persistence.*;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolverHolder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.Assert.notNull;

public class EntityManagerCreationTest {

    private List<PersistenceProvider> persistenceProviders;

    @Test
    public void entityManagerTest() {
        System.out.println(PersistenceProviderResolverHolder.getPersistenceProviderResolver().getPersistenceProviders().get(0));
        persistenceProviders = PersistenceProviderResolverHolder.getPersistenceProviderResolver().getPersistenceProviders();

        PersistenceProvider persistenceProvider = persistenceProviders.get(0);

        Map<String, String> properties = new HashMap<String, String>();
        properties.put("openjpa.ConnectionURL", "jdbc:sqlserver://");
        properties.put("openjpa.ConnectionUserName", "dbName");
        properties.put("openjpa.ConnecitonPassword", "password");
        properties.put("openjpa.SynchronizeMappings", "buildSchema");
        properties.put("openjpa.Log", "DefaultLevel=WARN");
        properties.put("openjpa.RuntimeUnenhancedClasses", "supported");


//        EntityManagerFactory emf = Persistence.
        EntityManagerFactory emf = persistenceProvider.createEntityManagerFactory("a", properties);
        EntityManager em = emf.createEntityManager(null);

        em.persist(new String(""));


        notNull(emf);
    }
}
