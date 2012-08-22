package pl.edu.agh.omdmb.scenario;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.jpa.EntityManagerProvider;
import pl.edu.agh.omdmb.jpa.util.EntityManagerBuilder;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.jpa.EntityManagerRegistry;
import pl.edu.agh.omdmb.scenario.configuration.ExecutionParameters;
import pl.edu.agh.omdmb.scenario.configuration.Scenario;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BenchmarkScenario implements Runnable {

    @Autowired private EntityManagerRegistry entityManagerRegistry;
    @Autowired private EntityManagerBuilder entityManagerBuilder;

    private List<PersistenceUnitConfiguration> persistenceUnitConfigurations;
    private List<ExecutionParameters> executionsParameters;

    public BenchmarkScenario() {
        persistenceUnitConfigurations = new LinkedList<PersistenceUnitConfiguration>();
        executionsParameters = new LinkedList<ExecutionParameters>();
    }

    @Override
    public void run() {

    }

//    void createEnvironment(Map<EntityManagerProviderType, Properties> entityManagerProviderTypePropertiesMap,
//                           List<Class<?>> dataModelClasses) {
//        for (Map.Entry<EntityManagerProviderType, Properties> entityManagerProviderTypePropertiesEntry :
//                entityManagerProviderTypePropertiesMap.entrySet()) {
//            EntityManagerProviderType persistenceUnitType = entityManagerProviderTypePropertiesEntry.getKey();
//
//        }
//
//
////        for (Map.Entry<EntityManagerProviderType, P> persistenceUnitConfiguration :
////                entityManagerProviderTypePropertiesMap.entrySet()) {
////            EntityManagerProviderType persistenceUnitType = persistenceUnitConfiguration.getKey();
////            PersistenceUnitConfiguration persistenceUnitProperties = persistenceUnitConfiguration.getValue();
//
////            EntityManagerProvider entityManagerProvider = entityManagerBuilder.createEntityManagerProvider(
////                    persistenceUnitType, persistenceUnitProperties);
////
////            entityManagerRegistry.register(persistenceUnitType, entityManagerProvider.getEntityManager());
////        }
//    }

    public void addPersistenceUnitConfiguration(PersistenceUnitConfiguration persistenceUnitConfiguration) {
        persistenceUnitConfigurations.add(persistenceUnitConfiguration);

    }

    public List<PersistenceUnitConfiguration> getPersistenceUnitConfigurations() {
        return persistenceUnitConfigurations;
    }

    public void addExecutionParameters(ExecutionParameters executionParameters) {
        executionsParameters.add(executionParameters);
    }

    public List<ExecutionParameters> getExecutionsParameters() {
        return executionsParameters;
    }
}
