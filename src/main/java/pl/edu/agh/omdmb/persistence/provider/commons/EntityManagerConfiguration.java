package pl.edu.agh.omdmb.persistence.provider.commons;

import javax.persistence.EntityManagerFactory;
import java.util.*;

public abstract class EntityManagerConfiguration {

    private final Properties configurationProperties;
    private final Set<Class<?>> annotatedClasses;

    public abstract EntityManagerFactory buildEntityManagerFactory();

    protected EntityManagerConfiguration(Properties aConfigurationProperties, Set<Class<?>> anAnnotatedClasses) {
        configurationProperties = aConfigurationProperties;
        annotatedClasses = anAnnotatedClasses;
    }

    public Properties getConfigurationProperties() {
        return configurationProperties;
    }

    public Set<Class<?>> getAnnotatedClasses() {
        return annotatedClasses;
    }
}
