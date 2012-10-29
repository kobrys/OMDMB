package pl.edu.agh.omdmb.configuration.util;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.apache.commons.digester3.binder.RulesModule;

public class ConfigurableDigesterFactory extends Digester {

    public static Digester buildDigesterForRulesModule(RulesModule rulesModule) {
        return DigesterLoader.newLoader(rulesModule).newDigester();
    }
}
