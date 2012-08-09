package pl.edu.agh.omdmb;

import javax.persistence.EntityManager;

public class HibernateEntityManagerProvider {

    private EntityManager entityManager;

    public HibernateEntityManagerProvider(HibernateConfiguration configuration) {
        entityManager = configuration
                .getEjbConfiguration()
                .buildEntityManagerFactory()
                .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
