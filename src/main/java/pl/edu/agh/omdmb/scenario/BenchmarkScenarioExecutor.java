package pl.edu.agh.omdmb.scenario;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executor;

public class BenchmarkScenarioExecutor {

    @Autowired
    private Executor threadExecutor;

    public void execute(BenchmarkScenario scenario) {
        threadExecutor.execute(scenario);
    }

    public void setExecutor(Executor executor) {
        this.threadExecutor = executor;
    }
}
