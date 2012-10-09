package pl.edu.agh.omdmb.configuration.benchmark.model;

import java.util.LinkedList;
import java.util.List;

public class Scenario {

    private String jpaPersistenceFile;
    private List<PersistenceUnitConfiguration> persistenceUnits;
    private List<Class<?>> dataModelClasses;
    private List<ExecutionParameters> executionParametersList;

    public Scenario() {
        persistenceUnits = new LinkedList<PersistenceUnitConfiguration>();
        dataModelClasses = new LinkedList<Class<?>>();
        executionParametersList = new LinkedList<ExecutionParameters>();
    }

    public void setPersistenceUnits(List<PersistenceUnitConfiguration> persistenceUnits) {
        this.persistenceUnits = persistenceUnits;
    }

    public List<PersistenceUnitConfiguration> getPersistenceUnits() {
        return persistenceUnits;
    }

    public String getJpaPersistenceFile() {
        return jpaPersistenceFile;
    }

    public void setJpaPersistenceFile(String jpaPersistenceFile) {
        this.jpaPersistenceFile = jpaPersistenceFile;
    }

    public List<Class<?>> getDataModelClasses() {
        return dataModelClasses;
    }

    public void addDataModelClass(AnnotatedClass annotatedClass) {
        try {
            Class clazz = Class.forName(annotatedClass.getName());
            dataModelClasses.add(clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ExecutionParameters> getExecutionParametersList() {
        return executionParametersList;
    }

    public void setExecutionParametersList(List<ExecutionParameters> executionParametersList) {
        this.executionParametersList = executionParametersList;
    }
}
