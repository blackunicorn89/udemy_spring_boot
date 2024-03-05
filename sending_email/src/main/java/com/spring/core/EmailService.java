package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
    private DataSource datasource;

    public EmailService(DataSource datasource) {
        this.datasource = datasource;
    }

    public void sendEmail() {
        String[] recipients = datasource.getEmails();
        for (String recipient: recipients) {
            System.out.println(recipient);
        }

    }
}
