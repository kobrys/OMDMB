package pl.edu.agh.omdmb;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class EntityManagerProvider {

    public abstract EntityManager getEntityManager();

}
