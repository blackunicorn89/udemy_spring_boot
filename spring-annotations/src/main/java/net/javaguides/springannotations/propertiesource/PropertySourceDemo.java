package net.javaguides.springannotations.propertiesource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceDemo {
    @Value("example.host")
    private String host;
    @Value("example.email")
    private String email;
    @Value("example.password")
    private String password;

    public String getHost() {
        return host;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
