package pl.edu.agh.omdmb;

import org.hibernate.ejb.Ejb3Configuration;

import java.util.List;
import java.util.Properties;

public class HibernateConfiguration {

    private final Properties hibernateProperties;
    private final List<Class<?>> annotadedClasses;

    public HibernateConfiguration(Properties aHibernateProperties, List<Class<?>> anAnnotatedClasses) {
        hibernateProperties = aHibernateProperties;
        annotadedClasses = anAnnotatedClasses;
    }

    Ejb3Configuration getEjbConfiguration() {
        Ejb3Configuration ejb3Configuration =  new Ejb3Configuration();
        ejb3Configuration.addProperties(hibernateProperties);

        for (Class<?> annotadedClass : annotadedClasses) {
            ejb3Configuration.addAnnotatedClass(annotadedClass);
        }

        return ejb3Configuration;
    }
}
