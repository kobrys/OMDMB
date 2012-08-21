package pl.edu.agh.omdmb.jpa.hibernate;

import org.hibernate.ejb.Ejb3Configuration;
import pl.edu.agh.omdmb.jpa.util.PersistenceUnitConfiguration;

import java.util.List;
import java.util.Properties;

public class HibernateConfiguration extends PersistenceUnitConfiguration {



    public HibernateConfiguration(Properties aHibernateProperties, List<Class<?>> annotatedClasses) {
        super(aHibernateProperties, annotatedClasses);
    }

    Ejb3Configuration getEjbConfiguration() {
        Ejb3Configuration ejb3Configuration =  new Ejb3Configuration();
        ejb3Configuration.addProperties(getProperties());

        for (Class<?> annotatedClass : getAnnotadedClasses()) {
            ejb3Configuration.addAnnotatedClass(annotatedClass);
        }

        return ejb3Configuration;
    }
}
