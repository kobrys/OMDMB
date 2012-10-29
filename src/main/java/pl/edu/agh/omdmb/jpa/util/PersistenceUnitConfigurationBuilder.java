package pl.edu.agh.omdmb.jpa.util;

import java.util.List;
import java.util.Properties;

import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.HIBERNATE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.KEY_VALUE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.OBJECT_DB;

public class PersistenceUnitConfigurationBuilder {

    public PersistenceUnitConfiguration build(EntityManagerProviderType type, Properties properties,
                                              List<Class<?>> modelClasses) {
        if (type == HIBERNATE) {
            throw new UnsupportedOperationException();
        } else if (type == OBJECT_DB) {
            throw new UnsupportedOperationException();
        } else if (type == KEY_VALUE) {
            throw new UnsupportedOperationException();
        } else {
            throw new RuntimeException("Wrong entity manager provider type");
        }
    }
}
