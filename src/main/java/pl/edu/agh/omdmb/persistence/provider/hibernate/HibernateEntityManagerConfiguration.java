package pl.edu.agh.omdmb.persistence.provider.hibernate;

import org.hibernate.ejb.Ejb3Configuration;
import pl.edu.agh.omdmb.persistence.provider.commons.EntityManagerConfiguration;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;
import java.util.Set;

public class HibernateEntityManagerConfiguration extends EntityManagerConfiguration {

    protected HibernateEntityManagerConfiguration(Properties aConfigurationProperties, Set<Class<?>> anAnnotatedClasses) {
        super(aConfigurationProperties, anAnnotatedClasses);
    }

    public EntityManagerFactory buildEntityManagerFactory() {
        Ejb3Configuration ejb3Configuration = createEjbConfiguration();
        ejb3Configuration.addProperties(getConfigurationProperties());

        for (Class<?> annotatedClass : getAnnotatedClasses()) {
            ejb3Configuration.addAnnotatedClass(annotatedClass);
        }

        return ejb3Configuration.buildEntityManagerFactory();
    }

    protected Ejb3Configuration createEjbConfiguration() {
        return new Ejb3Configuration();
    }
}
