package net.javaguides.springannotations.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotationDemo {

    @Value("Default name")
    private String defaultName;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.email}")
    private String email;

    @Value("${mail.password}")
    private String password;

    @Value("${NVM_HOME}")
    private String nvmHome;

    @Value("${OS}")
    private String os;

    public String getNvmHome() {
        return nvmHome;
    }

    public String getOS() {
        return os;
    }

    public String getHost() {
        return host;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDefaultName() {
        return defaultName;
    }
}
