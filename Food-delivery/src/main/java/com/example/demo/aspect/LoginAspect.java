package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {
    @Before("execution(* com.example.demo.service.impl.CustomerServiceImpl.signUpCustomer(..))")
    public void log(){
        System.out.println("Aspect log called, before fucntion");
    }
    @After("execution(* com.example.demo.service.impl.CustomerServiceImpl.signUpCustomer(..))")
    public void afterLog(){
        System.out.println("Aspect log called, after function");
    }
}
