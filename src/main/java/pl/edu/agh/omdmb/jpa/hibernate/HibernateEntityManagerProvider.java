package pl.edu.agh.omdmb.jpa.hibernate;

import pl.edu.agh.omdmb.jpa.EntityManagerProvider;

import javax.persistence.EntityManager;

public class HibernateEntityManagerProvider extends EntityManagerProvider {

    private EntityManager entityManager;

    public HibernateEntityManagerProvider(HibernateConfiguration configuration) {
//        entityManager = configuration
//                .getEjbConfiguration()
//                .buildEntityManagerFactory()
//                .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
