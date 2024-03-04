package com.spring.core.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean");
    }
}
