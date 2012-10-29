package pl.edu.agh.omdmb.configuration.util;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.Rules;
import org.apache.commons.digester3.binder.AbstractRulesModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.configuration.benchmark.XmlConfigurationRulesModule;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;

import java.io.File;

public class XmlToObjectLoader {

    private Digester digester;

    public BenchmarkConfiguration loadFromFile(String filename) {
        try {
            return digester.parse(new File(filename));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setDigester(Digester digester) {
        this.digester = digester;
    }
}
