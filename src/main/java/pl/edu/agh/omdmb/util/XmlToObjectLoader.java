package pl.edu.agh.omdmb.util;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.binder.RulesModule;
import pl.edu.agh.omdmb.configuration.benchmark.model.Scenario;

import java.io.File;

public class XmlToObjectLoader {

    private Digester digester;

//    public XmlToObjectLoader(RulesModule rulesModule) {
//        digester = DigesterLoader.newLoader(rulesModule).newDigester();
//    }

    public Scenario loadFromFile(String filename) {
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
