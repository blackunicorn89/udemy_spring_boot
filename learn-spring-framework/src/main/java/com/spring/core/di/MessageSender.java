package com.spring.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    @Qualifier("emailService")
    private MessageService emailService;
    @Autowired
    @Qualifier("smsService")
    private MessageService smsService;

//    @Autowired
//    public MessageSender (@Qualifier("emailService") MessageService messageService) {
//        this.messageService = messageService;
//        System.out.println("Constructor based dependency injection");
//    }

//    @Autowired
//    public MessageSender (@Qualifier("emailService") MessageService emailService, MessageService smsService) {
//        this.emailService = emailService;
//        this.smsService = smsService;
//        System.out.println("Constructor based dependency injection 2");
//    }

//    @Autowired
//    public void setEmailService(@Qualifier("emailService") MessageService emailService) {
//        this.emailService = emailService;
//        System.out.println("setter based emailservice dependency injection");
//    }
//
    public void sendMessage (String message) {
        this.emailService.sendMessage(message);
        this.smsService.sendMessage(message);
    }
//
//
//    @Autowired
//    public void setSmsService(@Qualifier("smsService") MessageService smsService) {
//        this.smsService = smsService;
//        System.out.println("setter based smsservice dependency injection");
//    }
}
