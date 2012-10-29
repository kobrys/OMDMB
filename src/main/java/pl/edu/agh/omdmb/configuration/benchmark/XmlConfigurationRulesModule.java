package pl.edu.agh.omdmb.configuration.benchmark;

import org.apache.commons.digester3.binder.AbstractRulesModule;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;
import pl.edu.agh.omdmb.configuration.benchmark.model.DataModel;

public class XmlConfigurationRulesModule extends AbstractRulesModule {

    @Override
    protected void configure() {
        forPattern("configuration").createObject().ofType(BenchmarkConfiguration.class);
        forPattern("configuration/persistence/jpaPersistenceFileName").setBeanProperty();

        forPattern("configuration/dataModel").createObject().ofType(DataModel.class).then().setNext("setDataModel");

        // annotated classes
//        forPattern("configuration/dataModel/classes/configuredClass").createObject().ofType(ConfiguredClass.class).then().setNext("addConfiguredClass");
        forPattern("configuration/dataModel/configuredClasses/clazz").callMethod("addConfiguredClass").usingElementBodyAsArgument();
    }
}
