package pl.edu.agh.omdmb.jpa;

import javax.persistence.EntityManager;

public abstract class EntityManagerProvider {

    public abstract EntityManager getEntityManager();
}
