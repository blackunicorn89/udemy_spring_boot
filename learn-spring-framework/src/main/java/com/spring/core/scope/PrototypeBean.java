package com.spring.core.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prototypeBean")
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    public PrototypeBean(){
        System.out.println("PrototypeBean");
    }

}
