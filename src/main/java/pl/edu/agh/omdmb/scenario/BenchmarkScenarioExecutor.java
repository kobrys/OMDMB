package pl.edu.agh.omdmb.scenario;

import java.util.concurrent.Executor;

public class BenchmarkScenarioExecutor {

    public void execute(BenchmarkScenario scenario) {
        new Thread(scenario).start();
    }
}
