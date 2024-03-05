package com.spring.core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements DataSource {
    @Override
    public String[] getEmails() {
        return new String[]{
                "zikoxhmrjq@Postgemail.com",
                "mqyopdfrdc@Postgesample.com",
                "icwqzjmieh@Postgedemo.com",
                "bffvoatczh@Postgesample.com",
                "rkxyvmgwhe@Postgedemo.com",
                "djyfjrhhun@Postgesample.com",
                "avjesuktrx@Postgetest.com",
                "cnufkjtbnj@Postgedemo.com",
                "knhhjkgljs@Postgesample.com",
                "hboggifude@Postgemail.com"};
    };
}
