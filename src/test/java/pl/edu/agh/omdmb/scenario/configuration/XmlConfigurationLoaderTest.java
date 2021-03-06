package pl.edu.agh.omdmb.scenario.configuration;

import org.apache.commons.digester3.Digester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;
import pl.edu.agh.omdmb.configuration.util.XmlToObjectLoader;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class XmlConfigurationLoaderTest {

    public static final String FILENAME = "FILENAME";
    @Mock Digester digester;
    @Mock BenchmarkConfiguration scenario;

    @InjectMocks
    XmlToObjectLoader xmlToObjectLoader = new XmlToObjectLoader();

    @Test
    public void testLoadScenarioFromFile() throws Exception {
        //given
        String filename = FILENAME;
        when(digester.parse(new File(FILENAME))).thenReturn(scenario);

        //when
        BenchmarkConfiguration parsedScenario = xmlToObjectLoader.loadFromFile(FILENAME);

        //then
        assertEquals(scenario, parsedScenario);
        verify(digester).parse(new File(FILENAME));

    }
}
