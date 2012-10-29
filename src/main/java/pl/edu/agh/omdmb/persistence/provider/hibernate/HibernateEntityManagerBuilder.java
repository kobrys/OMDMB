package pl.edu.agh.omdmb.persistence.provider.hibernate;

import pl.edu.agh.omdmb.persistence.provider.commons.EntityManagerBuilder;
import pl.edu.agh.omdmb.persistence.provider.commons.EntityManagerConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class HibernateEntityManagerBuilder extends EntityManagerBuilder {

    @Override
    public EntityManager build(EntityManagerConfiguration entityManagerConfiguration) {
        HibernateEntityManagerConfiguration configuration =
                (HibernateEntityManagerConfiguration) entityManagerConfiguration;

        return configuration.buildEntityManagerFactory().createEntityManager();
    }
}
