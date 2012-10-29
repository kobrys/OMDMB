package pl.edu.agh.omdmb.persistence.provider.commons;

import javax.persistence.EntityManager;

public abstract class EntityManagerBuilder {

    public abstract EntityManager build(EntityManagerConfiguration entityManagerConfiguration);
}
