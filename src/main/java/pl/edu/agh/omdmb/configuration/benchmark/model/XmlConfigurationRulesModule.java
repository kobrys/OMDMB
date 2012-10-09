package pl.edu.agh.omdmb.configuration.benchmark.model;

import org.apache.commons.digester3.binder.AbstractRulesModule;

import java.util.LinkedList;

public class XmlConfigurationRulesModule extends AbstractRulesModule {
    @Override
    protected void configure() {
        forPattern("scenario").createObject().ofType(Scenario.class);
        forPattern("scenario/persistence/jpaPersistenceFile").setBeanProperty();
        forPattern("scenario/persistence/persistenceUnitConfigurations").createObject().ofType(LinkedList.class).then().setNext("setPersistenceUnits");
        forPattern("scenario/persistence/persistenceUnitConfigurations/unit").createObject().ofType(PersistenceUnitConfiguration.class).then().setNext("add");
        forPattern("scenario/persistence/persistenceUnitConfigurations/unit/typeName").setBeanProperty();
        forPattern("scenario/persistence/persistenceUnitConfigurations/unit/configurationFile").setBeanProperty();

        forPattern("scenario/dataModel/classes/annotatedClass").createObject().ofType(AnnotatedClass.class).then().setNext("addDataModelClass");;
        forPattern("scenario/dataModel/classes/annotatedClass/name").setBeanProperty();

        forPattern("scenario/data").createObject().ofType(LinkedList.class).then().setNext("setExecutionParametersList");
        forPattern("scenario/data/execution").createObject().ofType(ExecutionParameters.class).then().setNext("add");
        forPattern("scenario/data/execution/dataDensity").setBeanProperty();
        forPattern("scenario/data/execution/overlap").setBeanProperty();
        forPattern("scenario/data/execution/numberOfObjects").setBeanProperty();
        forPattern("scenario/data/execution/independence").setBeanProperty();
    }
}
