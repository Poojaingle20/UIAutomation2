package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs//Configuration.properties";
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    private ConfigFileReader() {
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

    public static ConfigFileReader getInstance() {
        return configFileReader;
    }

    public String getUrl() {
        String url = System.getProperty("url");
        if (url == null) {
            url = properties.getProperty("url");
        }
        return url;
    }

    public String getEmail() {
        String email = System.getProperty("email");
        if (email == null) {
            email = properties.getProperty("email");
        }
        return email;
    }

    public String getLoginEndPoint() {
        String loginEndpoint = System.getProperty("loginSuccessful");
        if (loginEndpoint == null) {
            loginEndpoint = properties.getProperty("loginSuccessful");
        }
        return loginEndpoint;

    }

    public String getSingleUserNotFoundEndPoint() {
        String singleUserEndPoint = System.getProperty("singleUserNotFound");
        if (singleUserEndPoint == null) {
            singleUserEndPoint = properties.getProperty("singleUserNotFound");
        }
        return singleUserEndPoint;
    }

    public String getPassword() {
        String password = System.getProperty("password");
        if (password == null) {
            password = properties.getProperty("password");
        }
        return password;
    }

    public String getContentType() {
        String contentType = System.getProperty("contentType");
        if (contentType == null) {
            contentType = properties.getProperty("contentType");
        }
        return contentType;
    }

    public String getListUser() {
        String listUser = System.getProperty("listUser");
        if (listUser == null) {
            listUser = properties.getProperty("listUser");
        }
        return listUser;
    }
    public String getDataFromPropertyFile(String key){
        String value=properties.getProperty(key);
        return value;

    }


    public String getSingleUser() {
        String singleUser = System.getProperty("singleUser");
        if (singleUser == null) {
            singleUser = properties.getProperty("singleUser");
        }
        return singleUser;
    }

    public String getSingleResourceNotFound() {
        String singleResourcesNotFoundEndPoint = System.getProperty("singleResourcesNotFound");
        if (singleResourcesNotFoundEndPoint == null) {
            singleResourcesNotFoundEndPoint = properties.getProperty("singleResourcesNotFound");
        }
        return singleResourcesNotFoundEndPoint;
    }

    public String getSingleResource() {
        String singleResourcesEndPoint = System.getProperty("singleResources");
        if (singleResourcesEndPoint == null) {
            singleResourcesEndPoint = properties.getProperty("singleResources");
        }
        return singleResourcesEndPoint;
    }

    public String getListResource() {
        String listResourcesEnnPoint = System.getProperty("listResources");
        if (listResourcesEnnPoint == null) {
            listResourcesEnnPoint = properties.getProperty("listResources");
        }
        return listResourcesEnnPoint;
    }

    public String getReportConfigPath() {
        String reportConfigPath = properties.getProperty("configs//extent-config.xml");
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
