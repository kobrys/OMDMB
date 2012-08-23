package pl.edu.agh.omdmb.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.agh.omdmb.core.scenario.BenchmarkScenarioBuilder;
import pl.edu.agh.omdmb.scenario.BenchmarkConfigurationLoader;
import pl.edu.agh.omdmb.scenario.BenchmarkScenario;
import pl.edu.agh.omdmb.scenario.BenchmarkScenarioExecutor;

public class OMDMB {

    public static final String APP_CONTEXT_XML = "appContext.xml";
    public static final String OMDMB = "omdmb";

    @Autowired private BenchmarkConfigurationLoader benchmarkConfigurationLoader;
    @Autowired private BenchmarkScenarioExecutor benchmarkScenarioExecutor;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APP_CONTEXT_XML);
        OMDMB omdmb = (OMDMB)applicationContext.getBean(OMDMB);
        omdmb.start(args);
    }

    public void start(String[] args) {
        args = new String[] {"D:/IntelijWorkspace/OMDMB/target/classes/META-INF/benchmark.xml"};

        for (String benchmarkConfigurationFilename : args) {
            BenchmarkScenario benchmarkScenario = benchmarkConfigurationLoader.loadConfiguration(benchmarkConfigurationFilename);

            benchmarkScenarioExecutor.execute(benchmarkScenario);
        }
    }
}
