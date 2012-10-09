package pl.edu.agh.omdmb.core.scenario;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfigurationBuilder;
import pl.edu.agh.omdmb.scenario.BenchmarkScenario;
import pl.edu.agh.omdmb.configuration.benchmark.model.ExecutionParameters;
import pl.edu.agh.omdmb.configuration.benchmark.model.Scenario;

import java.util.Map;
import java.util.Properties;

public class BenchmarkScenarioBuilder {

    @Autowired
    private PersistenceUnitConfigurationBuilder persistenceUnitConfigurationBuilder;

    public BenchmarkScenario buildScenario(Scenario scenario,
                                           Map<EntityManagerProviderType, Properties> configurationProperties) {
        BenchmarkScenario benchmarkScenario = new BenchmarkScenario();

        createPersistenceUnitConfigurations(scenario, configurationProperties, benchmarkScenario);
        setExecutionsParameters(scenario, benchmarkScenario);

        return benchmarkScenario;
    }

    private void createPersistenceUnitConfigurations(Scenario scenario, Map<EntityManagerProviderType, Properties> configurationProperties, BenchmarkScenario benchmarkScenario) {
        for (Map.Entry<EntityManagerProviderType, Properties> configurationEntry : configurationProperties.entrySet()) {
            benchmarkScenario.addPersistenceUnitConfiguration(configurationEntry.getKey(), persistenceUnitConfigurationBuilder.build(
                    configurationEntry.getKey(), configurationEntry.getValue(), scenario.getDataModelClasses()));
        }
    }

    private void setExecutionsParameters(Scenario scenario, BenchmarkScenario benchmarkScenario) {
        for (ExecutionParameters executionParameters : scenario.getExecutionParametersList()) {
            benchmarkScenario.addExecutionParameters(executionParameters);
        }
    }
}
