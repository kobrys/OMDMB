package pl.edu.agh.omdmb.jpa.util;

import pl.edu.agh.omdmb.jpa.EntityManagerProvider;
import pl.edu.agh.omdmb.jpa.EntityManagerRegistry;
import pl.edu.agh.omdmb.jpa.hibernate.HibernateConfiguration;
import pl.edu.agh.omdmb.jpa.hibernate.HibernateEntityManagerProvider;

import javax.persistence.EntityManager;

import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.HIBERNATE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.KEY_VALUE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.OBJECT_DB;

public class EntityManagerBuilder {
    private EntityManagerRegistry entityManagerRegistry;

    public EntityManagerProvider createEntityManagerProvider(EntityManagerProviderType entityManagerProviderType,
                                                    PersistenceUnitConfiguration entityManagerProviderConfiguration) {
        if (entityManagerProviderType == HIBERNATE) {
            return new HibernateEntityManagerProvider((HibernateConfiguration)entityManagerProviderConfiguration);
        } else if (entityManagerProviderType == OBJECT_DB) {

        } else if (entityManagerProviderType == KEY_VALUE) {

        } else {
            throw new RuntimeException("Unsupported EntityManagerProviderType");
        }

        return null;
    }

    public void setEntityManagerRegistry(EntityManagerRegistry entityManagerRegistry) {
        this.entityManagerRegistry = entityManagerRegistry;
    }
}
