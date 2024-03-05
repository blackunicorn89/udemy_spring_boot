package com.spring.core.scope;

import com.spring.core.di.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainScope {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean1.hashCode());
        SingletonBean singletonBean2 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean2.hashCode());
        SingletonBean singletonBean3 = applicationContext.getBean(SingletonBean.class);
        System.out.println(singletonBean3.hashCode());
        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.hashCode());
        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.hashCode());
        PrototypeBean prototypeBean3 = applicationContext.getBean(PrototypeBean.class);
        System.out.println(prototypeBean3.hashCode());
    }
}

