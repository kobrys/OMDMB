package pl.edu.agh.omdmb.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.DatabaseConfiguration;

public class JpaManager {

    @Autowired
    private DatabaseConfiguration databaseConfiguration;

    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }
}
