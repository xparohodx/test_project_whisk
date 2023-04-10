package portal.utils.configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath= "src/config/selenium.conf";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public long getTimeout() {
        String timeout = properties.getProperty("timeout");
        if(timeout != null) return Long.parseLong(timeout);
        else throw new RuntimeException("timeout not specified in the Configuration.properties file.");
    }

    public String getWebURL() {
        String url = properties.getProperty("webURL");
        if(url != null) return url;
        else throw new RuntimeException("webURL not specified in the Configuration.properties file.");
    }

    public String getApiURL() {
        String url = properties.getProperty("apiURL");
        if(url != null) return url;
        else throw new RuntimeException("apiURL not specified in the Configuration.properties file.");
    }

    public String getBrowserType() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser type not specified in the Configuration.properties file.");
    }

    public String getAuthToken() {
        String token = properties.getProperty("authToken");
        if(token != null) return token;
        else throw new RuntimeException("auth token not specified in the Configuration.properties file.");
    }
}
