package pl.edu.agh.omdmb.scenario;

import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import java.util.Map;
import java.util.Properties;

public class BenchmarkConfiguration {

    private Map<EntityManagerProviderType, PersistenceUnitConfiguration> persistenceUnitsConfiguration;

    public Map<EntityManagerProviderType, PersistenceUnitConfiguration> getPersistenceUnitsConfiguration() {
        return persistenceUnitsConfiguration;
    }
}
