package pl.edu.agh.omdmb.configuration.benchmark.model;

import java.util.LinkedList;
import java.util.List;

public class DataModel {

    private List<Class<?>> configuredClasses;

    public DataModel() {
        configuredClasses = new LinkedList<Class<?>>();
    }

    public List<Class<?>> getConfiguredClasses() {
        return configuredClasses;
    }

    public void addConfiguredClass(String configuredClass) {
        try {
            Class clazz = Class.forName(configuredClass);
            configuredClasses.add(clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
