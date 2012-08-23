package pl.edu.agh.omdmb.core.scenario;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfigurationBuilder;
import pl.edu.agh.omdmb.scenario.BenchmarkScenario;
import pl.edu.agh.omdmb.scenario.configuration.ExecutionParameters;
import pl.edu.agh.omdmb.scenario.configuration.Scenario;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.HIBERNATE;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkScenarioBuilderTest {

    @InjectMocks
    BenchmarkScenarioBuilder benchmarkScenarioBuilder;

    @Mock Scenario scenario;
    @Mock Properties hibernateProperties;
    @Mock PersistenceUnitConfiguration persistenceUnitConfiguration;
    @Mock PersistenceUnitConfigurationBuilder persistenceUnitConfigurationBuilder;
    @Mock ExecutionParameters executionParametersMock1;
    @Mock ExecutionParameters executionParametersMock2;
    Class<?> annotatedClass;
    List<Class<?>> annotatedClasses;

    @Test
    public void testBuilder() {
        //given
        annotatedClass = String.class;
        annotatedClasses = new LinkedList<Class<?>>(Arrays.asList(annotatedClass));
        when(scenario.getDataModelClasses()).thenReturn(annotatedClasses);

        Map<EntityManagerProviderType, Properties> entityManagerProviderTypePropertiesMap =
                new HashMap<EntityManagerProviderType, Properties>();
        entityManagerProviderTypePropertiesMap.put(HIBERNATE, hibernateProperties);

        when(persistenceUnitConfigurationBuilder.build(HIBERNATE, hibernateProperties, annotatedClasses)).
                thenReturn(persistenceUnitConfiguration);

        List<ExecutionParameters> executionParametersList = new LinkedList<ExecutionParameters>();
        executionParametersList.add(executionParametersMock1);
        executionParametersList.add(executionParametersMock2);

        when(scenario.getExecutionParametersList()).thenReturn(executionParametersList);

        //when
        BenchmarkScenario benchmarkScenario = benchmarkScenarioBuilder.buildScenario(scenario,
                entityManagerProviderTypePropertiesMap);

        //then
        assertNotNull(benchmarkScenario);
        verify(persistenceUnitConfigurationBuilder).build(HIBERNATE, hibernateProperties, annotatedClasses);
        assertEquals(1, benchmarkScenario.getPersistenceUnitConfigurations().size());
        assertEquals(persistenceUnitConfiguration, benchmarkScenario.getPersistenceUnitConfigurations().get(HIBERNATE));

        assertEquals(benchmarkScenario.getExecutionsParameters().size(), 2);
        assertEquals(benchmarkScenario.getExecutionsParameters().get(0), executionParametersMock1);
        assertEquals(benchmarkScenario.getExecutionsParameters().get(1), executionParametersMock2);
    }

}
