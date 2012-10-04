package pl.edu.agh.omdmb.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.omdmb.scenario.BenchmarkConfigurationLoader;
import pl.edu.agh.omdmb.scenario.BenchmarkScenario;
import pl.edu.agh.omdmb.scenario.BenchmarkScenarioExecutor;

public class OMDMB {

    public static String APP_CONTEXT_XML = "appContext.xml";
    public static final String OMDMB = "omdmb";

    @Value("#{configurationProperties[configuration_benchmark_dir]}")
    private String configurationBenchmarkFileDir;

    @Autowired
    private BenchmarkConfigurationLoader benchmarkConfigurationLoader;
    @Autowired
    private BenchmarkScenarioExecutor benchmarkScenarioExecutor;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APP_CONTEXT_XML);
        OMDMB omdmb = (OMDMB) applicationContext.getBean(OMDMB);
        omdmb.start();
    }

    public void start() {
        BenchmarkScenario benchmarkScenario = loadConfiguration();
        runBenchmark(benchmarkScenario);
    }

    private BenchmarkScenario loadConfiguration() {
        return benchmarkConfigurationLoader.loadConfiguration(configurationBenchmarkFileDir);
    }

    private void runBenchmark(BenchmarkScenario benchmarkScenario) {
        benchmarkScenarioExecutor.execute(benchmarkScenario);
    }
}
