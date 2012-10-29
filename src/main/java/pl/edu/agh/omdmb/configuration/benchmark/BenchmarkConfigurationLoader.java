package pl.edu.agh.omdmb.configuration.benchmark;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;
import pl.edu.agh.omdmb.configuration.util.XmlToObjectLoader;

public class BenchmarkConfigurationLoader {

    @Autowired
    private XmlToObjectLoader xmlToObjectLoader;

    public BenchmarkConfiguration loadConfiguration(String configurationFilename) {
        return xmlToObjectLoader.loadFromFile(configurationFilename);
    }
}
