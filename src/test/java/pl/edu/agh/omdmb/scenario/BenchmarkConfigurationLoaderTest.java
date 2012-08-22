package pl.edu.agh.omdmb.scenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;
import pl.edu.agh.omdmb.scenario.configuration.PersistenceUnitConfiguration;
import pl.edu.agh.omdmb.scenario.configuration.PropertiesConfigurationLoader;
import pl.edu.agh.omdmb.scenario.configuration.Scenario;
import pl.edu.agh.omdmb.scenario.configuration.XmlConfigurationLoader;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.HIBERNATE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.KEY_VALUE;
import static pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType.OBJECT_DB;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkConfigurationLoaderTest {

    public static final String XML_CONFIGURATION_FILENAME = "XML_CONFIGURATION_FILENAME";
    public static final String FILE_1 = "FILE_1";
    public static final String FILE_2 = "FILE_2";
    public static final String FILE_3 = "FILE_3";

    @Mock XmlConfigurationLoader xmlConfigurationLoader;
    @Mock PropertiesConfigurationLoader propertiesConfigurationLoader;
    @Mock Scenario scenario;

    @Mock PersistenceUnitConfiguration persistenceUnitConfigurationMock1;
    @Mock PersistenceUnitConfiguration persistenceUnitConfigurationMock2;
    @Mock PersistenceUnitConfiguration persistenceUnitConfigurationMock3;

    @InjectMocks
    BenchmarkConfigurationLoader benchmarkConfigurationLoader;

    @Test
    public void loadXmlScenarioConfiguration() {
        //given
        when(xmlConfigurationLoader.loadScenarioFromFile(XML_CONFIGURATION_FILENAME)).thenReturn(scenario);

        //when
        benchmarkConfigurationLoader.loadConfiguration(XML_CONFIGURATION_FILENAME);

        //then
        verify(xmlConfigurationLoader).loadScenarioFromFile(XML_CONFIGURATION_FILENAME);
        verify(scenario).getPersistenceUnits();
    }

    @Test
    public void loadEntityManagerPropertiesFiles() {
        //given
        when(xmlConfigurationLoader.loadScenarioFromFile(XML_CONFIGURATION_FILENAME)).thenReturn(scenario);
        List<PersistenceUnitConfiguration> persistenceUnitConfigurationList =
                new LinkedList<PersistenceUnitConfiguration>();
        givenPersistenceUnitConfiguration(persistenceUnitConfigurationList);

        //when
        benchmarkConfigurationLoader.loadConfiguration(XML_CONFIGURATION_FILENAME);

        //then
        verify(xmlConfigurationLoader).loadScenarioFromFile(XML_CONFIGURATION_FILENAME);
        verify(scenario).getPersistenceUnits();
        verify(propertiesConfigurationLoader).loadPropertiesFromFile(FILE_1);
        verify(propertiesConfigurationLoader).loadPropertiesFromFile(FILE_2);
        verify(propertiesConfigurationLoader).loadPropertiesFromFile(FILE_3);
    }

    private void givenPersistenceUnitConfiguration(List<PersistenceUnitConfiguration> persistenceUnitConfigurationList) {
        when(persistenceUnitConfigurationMock1.getEntityManagerProviderType()).thenReturn(HIBERNATE);
        when(persistenceUnitConfigurationMock1.getPropertiesConfigurationFile()).thenReturn(FILE_1);
        when(persistenceUnitConfigurationMock2.getEntityManagerProviderType()).thenReturn(OBJECT_DB);
        when(persistenceUnitConfigurationMock2.getPropertiesConfigurationFile()).thenReturn(FILE_2);
        when(persistenceUnitConfigurationMock3.getEntityManagerProviderType()).thenReturn(KEY_VALUE);
        when(persistenceUnitConfigurationMock3.getPropertiesConfigurationFile()).thenReturn(FILE_3);

        persistenceUnitConfigurationList.add(persistenceUnitConfigurationMock1);
        persistenceUnitConfigurationList.add(persistenceUnitConfigurationMock2);
        persistenceUnitConfigurationList.add(persistenceUnitConfigurationMock3);
        when(scenario.getPersistenceUnits()).thenReturn(persistenceUnitConfigurationList);
    }
}
