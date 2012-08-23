package pl.edu.agh.omdmb.scenario;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.core.scenario.BenchmarkScenarioBuilder;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.scenario.configuration.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.scenario.configuration.PropertiesConfigurationLoader;
import pl.edu.agh.omdmb.scenario.configuration.Scenario;
import pl.edu.agh.omdmb.scenario.configuration.XmlConfigurationLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BenchmarkConfigurationLoader {

    @Autowired private XmlConfigurationLoader xmlConfigurationLoader;
    @Autowired private PropertiesConfigurationLoader propertiesConfigurationLoader;
    @Autowired private BenchmarkScenarioBuilder benchmarkScenarioBuilder;

    public BenchmarkScenario loadConfiguration(String configurationFilename) {
        Scenario scenario = xmlConfigurationLoader.loadScenarioFromFile(configurationFilename);

        Map<EntityManagerProviderType, Properties> entityManagerProviderTypePropertiesMap
                = loadPersistenceUnitsConfigurations(scenario.getPersistenceUnits());

        return benchmarkScenarioBuilder.buildScenario(scenario, entityManagerProviderTypePropertiesMap);
    }

    private Map<EntityManagerProviderType, Properties> loadPersistenceUnitsConfigurations(
            List<PersistenceUnitConfiguration> persistenceUnits) {
        Map<EntityManagerProviderType, Properties> entityManagerProvidersConfigurations =
                new HashMap<EntityManagerProviderType, Properties>();

        for (PersistenceUnitConfiguration persistenceUnit : persistenceUnits) {
            Properties properties = propertiesConfigurationLoader.loadPropertiesFromFile(
                    persistenceUnit.getPropertiesConfigurationFile());

            entityManagerProvidersConfigurations.put(persistenceUnit.getEntityManagerProviderType(), properties);
        }

        return entityManagerProvidersConfigurations;
    }
}
