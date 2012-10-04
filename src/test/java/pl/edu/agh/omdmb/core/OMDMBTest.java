package pl.edu.agh.omdmb.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.scenario.BenchmarkConfigurationLoader;
import pl.edu.agh.omdmb.scenario.BenchmarkScenario;
import pl.edu.agh.omdmb.scenario.BenchmarkScenarioExecutor;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OMDMBTest {

    public static final String FIRST = "FIRST";
    public static final String SECOND = "SECOND";

    @Mock BenchmarkConfigurationLoader benchmarkConfigurationLoader;
//    @Mock BenchmarkConfiguration benchmarkConfiguration1;
//    @Mock BenchmarkConfiguration benchmarkConfiguration2;
    @Mock BenchmarkScenarioExecutor benchmarkScenarioExecutor;

    @InjectMocks
    OMDMB omdmb;

    @Test
    public void initTest() {
        //given
        String[] args = new String[] { FIRST, SECOND };
//        when(benchmarkConfigurationLoader.loadConfiguration(args[0])).thenReturn(benchmarkConfiguration1);
//        when(benchmarkConfigurationLoader.loadConfiguration(args[1])).thenReturn(benchmarkConfiguration2);

        //when
        omdmb.start();

        //then
        verify(benchmarkConfigurationLoader).loadConfiguration(FIRST);
        verify(benchmarkConfigurationLoader).loadConfiguration(SECOND);

        verify(benchmarkScenarioExecutor, times(2)).execute(any(BenchmarkScenario.class));
    }
}
