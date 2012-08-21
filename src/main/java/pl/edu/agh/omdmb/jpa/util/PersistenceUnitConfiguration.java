package pl.edu.agh.omdmb.jpa.util;

import java.util.List;
import java.util.Properties;

public class PersistenceUnitConfiguration {

    private final Properties properties;
    private final List<Class<?>> annotadedClasses;

    protected PersistenceUnitConfiguration(Properties aProperties, List<Class<?>> anAnnotatedClasses) {
        properties = aProperties;
        annotadedClasses = anAnnotatedClasses;
    }

    public List<Class<?>> getAnnotadedClasses() {
        return annotadedClasses;
    }

    public Properties getProperties() {
        return properties;
    }
}
