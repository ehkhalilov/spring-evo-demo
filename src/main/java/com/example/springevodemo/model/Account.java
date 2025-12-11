package com.example.springevodemo.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(scopeName = "prototype")
public class Account {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    private String number;

    public Account() {}

    public Account(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account [number=" + number + "]";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
