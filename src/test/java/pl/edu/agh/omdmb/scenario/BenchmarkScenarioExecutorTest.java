package pl.edu.agh.omdmb.scenario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkScenarioExecutorTest {

    @Mock BenchmarkScenario scenario;

    BenchmarkScenarioExecutor benchmarkScenarioExecutor;

    @Before
    public void setUp() {
        benchmarkScenarioExecutor = new BenchmarkScenarioExecutor();
    }

    @Test
    public void testExecute() throws Exception {
        //when
        benchmarkScenarioExecutor.execute(scenario);

        //then
        Mockito.verify(scenario).run();
    }
}
