package systemtest.pl.edu.agh.omdmb.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.omdmb.configuration.benchmark.BenchmarkConfigurationLoader;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/benchmarkConfigurationContext.xml")
public class BenchmarkConfigurationLoaderSystemTest {

    @Autowired
    BenchmarkConfigurationLoader benchmarkConfigurationLoader;

    @Test
    public void shouldLoadConfigurationTest() {
        BenchmarkConfiguration benchmarkConfiguration = benchmarkConfigurationLoader.
                loadConfiguration("src/test/resources/examples/configuration/benchmark/example_configuration_1.xml");

        assertNotNull(benchmarkConfiguration);
    }
}
