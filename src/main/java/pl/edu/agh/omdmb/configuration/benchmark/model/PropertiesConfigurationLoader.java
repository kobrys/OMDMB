package pl.edu.agh.omdmb.configuration.benchmark.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesConfigurationLoader {

    public Properties loadPropertiesFromFile(String filename) {
        Properties properties = new Properties();
        URL url = ClassLoader.getSystemResource(filename);

        if (url == null) {
             throw new RuntimeException("File not found");
        }

        File file = new File(url.getFile());

        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return properties;
    }
}
