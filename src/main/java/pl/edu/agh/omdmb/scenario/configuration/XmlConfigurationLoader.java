package pl.edu.agh.omdmb.scenario.configuration;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.AbstractRulesModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.binder.RulesModule;

import java.io.File;

public class XmlConfigurationLoader {

    private Digester digester;

    public XmlConfigurationLoader(RulesModule rulesModule) {
        digester = DigesterLoader.newLoader(rulesModule).newDigester();
    }

    public Scenario loadScenarioFromFile(String filename) {
        try {
            return digester.parse(new File(filename));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setRulesModule(RulesModule rulesModule) {
        System.out.println("SertRulesModule");
    }
}
