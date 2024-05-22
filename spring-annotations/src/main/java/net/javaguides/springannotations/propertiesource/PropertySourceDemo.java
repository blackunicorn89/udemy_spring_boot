package net.javaguides.springannotations.propertiesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceDemo {

    @Autowired
    private Environment environment;

//    @Value("${example.host}")
    private String host;
//    @Value("${example.email}")
    private String email;
//    @Value("${example.password}")
    private String password;

//    @Value( "${app.name}")
    private String appName;
//    @Value("${app.description}")
    private String appDescription;


    public String getHost() {
        return environment.getProperty("example.host");
    }

    public String getEmail() {
        return environment.getProperty("example.email");
    }

    public String getPassword() {
        return environment.getProperty("example.password");
    }

    public String getAppName() {
        return environment.getProperty("app.name");
    }

    public String getAppDescription() {
        return environment.getProperty("app.description");
    }
}
