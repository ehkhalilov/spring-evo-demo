package com.example.springevodemo;

import com.example.springevodemo.model.Account;
import com.example.springevodemo.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringEvoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEvoDemoApplication.class, args);
//        Account account = appContext.getBean("account", Account.class);
//        account.setNumber("12345");
//        System.out.println(account);
//
//        Account account2 = appContext.getBean("account", Account.class);
//        System.out.println(account2);
//        appContext.close();
//        System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));
    }

}
