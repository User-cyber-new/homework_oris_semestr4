package org.oris.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
    private Properties properties = new Properties();

    public DBProperties(){
        loadProperties();
    }

    private void loadProperties(){
        InputStream inputStream = getClass().getResourceAsStream("/db.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(String key){
        return properties.getProperty(key);
    }

}
