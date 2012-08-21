package pl.edu.agh.omdmb.jpa;

import pl.edu.agh.omdmb.jpa.hibernate.HibernateConfiguration;
import pl.edu.agh.omdmb.jpa.hibernate.HibernateEntityManagerProvider;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import javax.persistence.EntityManager;

import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.*;

public abstract class EntityManagerProvider {

    public abstract EntityManager getEntityManager();
}
