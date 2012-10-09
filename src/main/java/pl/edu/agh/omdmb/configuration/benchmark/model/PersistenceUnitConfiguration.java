package pl.edu.agh.omdmb.configuration.benchmark.model;

import org.springframework.scheduling.support.SimpleTriggerContext;
import pl.edu.agh.omdmb.jpa.util.EntityManagerProviderType;

import java.io.File;

public class PersistenceUnitConfiguration {

    private EntityManagerProviderType entityManagerProviderType;
    private String propertiesConfigurationFile;

    public PersistenceUnitConfiguration() {

    }

    public void setTypeName(String entityManagerProviderType) {
        this.entityManagerProviderType = EntityManagerProviderType.valueOf(entityManagerProviderType);
    }

    public EntityManagerProviderType getEntityManagerProviderType() {
        return entityManagerProviderType;
    }

    public void setConfigurationFile(String filename) {
        propertiesConfigurationFile = filename;
    }

    public String getPropertiesConfigurationFile() {
        return propertiesConfigurationFile;
    }
}
