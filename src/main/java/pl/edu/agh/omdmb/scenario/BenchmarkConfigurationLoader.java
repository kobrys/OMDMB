package pl.edu.agh.omdmb.scenario;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.core.scenario.BenchmarkScenarioBuilder;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.configuration.benchmark.model.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.configuration.benchmark.model.PropertiesConfigurationLoader;
import pl.edu.agh.omdmb.configuration.benchmark.model.Scenario;
import pl.edu.agh.omdmb.util.XmlToObjectLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BenchmarkConfigurationLoader {

    @Autowired private XmlToObjectLoader xmlToObjectLoader;
    @Autowired private PropertiesConfigurationLoader propertiesConfigurationLoader;
    @Autowired private BenchmarkScenarioBuilder benchmarkScenarioBuilder;

    public BenchmarkScenario loadConfiguration(String configurationFilename) {
        Scenario scenario = xmlToObjectLoader.loadFromFile(configurationFilename);

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

    public void setXmlToObjectLoader(XmlToObjectLoader xmlToObjectLoader) {
        this.xmlToObjectLoader = xmlToObjectLoader;
    }

    public void setPropertiesConfigurationLoader(PropertiesConfigurationLoader propertiesConfigurationLoader) {
        this.propertiesConfigurationLoader = propertiesConfigurationLoader;
    }

    public void setBenchmarkScenarioBuilder(BenchmarkScenarioBuilder benchmarkScenarioBuilder) {
        this.benchmarkScenarioBuilder = benchmarkScenarioBuilder;
    }
}
