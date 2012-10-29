package pl.edu.agh.omdmb.configuration.benchmark;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;
import pl.edu.agh.omdmb.configuration.util.XmlToObjectLoader;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkConfigurationLoaderTest {

    public static final String CONFIGURATION_FILENAME = "configuration_filename";

    @Mock XmlToObjectLoader xmlToObjectLoader;
    @Mock BenchmarkConfiguration benchmarkConfiguration;

    @InjectMocks
    private BenchmarkConfigurationLoader benchmarkConfigurationLoader;

    @Test
    public void shouldLoadConfiguration() {
        given(xmlToObjectLoader.loadFromFile(CONFIGURATION_FILENAME)).willReturn(benchmarkConfiguration);

        benchmarkConfigurationLoader.loadConfiguration(CONFIGURATION_FILENAME);

        verify(xmlToObjectLoader).loadFromFile(CONFIGURATION_FILENAME);
    }
}
