package pl.edu.agh.omdmb.scenario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkScenarioExecutorTest {

    @Mock Executor executor;
    @Mock BenchmarkScenario scenario;

    @InjectMocks
    BenchmarkScenarioExecutor benchmarkScenarioExecutor;

    @Test
    public void testExecute() throws Exception {
        //when
        benchmarkScenarioExecutor.execute(scenario);

        //then
        verify(executor).execute(scenario);
    }
}
