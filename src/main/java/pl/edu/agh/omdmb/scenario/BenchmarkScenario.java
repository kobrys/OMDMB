package pl.edu.agh.omdmb.scenario;

import pl.edu.agh.omdmb.jpa.EntityManagerProvider;
import pl.edu.agh.omdmb.jpa.util.EntityManagerBuilder;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.jpa.EntityManagerRegistry;

import java.util.Map;
import java.util.Properties;

public class BenchmarkScenario implements Runnable {

    private BenchmarkConfiguration benchmarkConfiguration;
    private BenchmarkConfigurationLoader benchmarkConfigurationLoader;

    private EntityManagerRegistry entityManagerRegistry;
    private EntityManagerBuilder entityManagerBuilder;

    @Override
    public void run() {

    }

    void loadConfiguration() {
        benchmarkConfiguration = benchmarkConfigurationLoader.load();
    }

    void createEnvironment() {
        for (Map.Entry<EntityManagerProviderType, PersistenceUnitConfiguration> persistenceUnitConfiguration :
                benchmarkConfiguration.getPersistenceUnitsConfiguration().entrySet()) {
            EntityManagerProviderType persistenceUnitType = persistenceUnitConfiguration.getKey();
            PersistenceUnitConfiguration persistenceUnitProperties = persistenceUnitConfiguration.getValue();

            EntityManagerProvider entityManagerProvider = entityManagerBuilder.createEntityManagerProvider(
                    persistenceUnitType, persistenceUnitProperties);

            entityManagerRegistry.register(persistenceUnitType, entityManagerProvider.getEntityManager());
        }
    }

    public BenchmarkConfiguration getBenchmarkConfiguration() {
        return benchmarkConfiguration;
    }

    public void setConfigurationLoader(BenchmarkConfigurationLoader benchmarkConfigurationLoader) {
        this.benchmarkConfigurationLoader = benchmarkConfigurationLoader;
    }

    public void setEntityManagerBuilder(EntityManagerBuilder entityManagerBuilder) {
        this.entityManagerBuilder = entityManagerBuilder;
    }

    public void setEntityManagerRegistry(EntityManagerRegistry entityManagerRegistry) {
        this.entityManagerRegistry = entityManagerRegistry;
    }
}
