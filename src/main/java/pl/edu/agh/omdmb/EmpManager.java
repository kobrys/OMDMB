package pl.edu.agh.omdmb;

import org.springframework.beans.factory.annotation.Autowired;

public class EmpManager {

    @Autowired
    private DatabaseConfiguration dbConfiguration;

    public DatabaseConfiguration getDbConfiguration() {
        return dbConfiguration;
    }
}
