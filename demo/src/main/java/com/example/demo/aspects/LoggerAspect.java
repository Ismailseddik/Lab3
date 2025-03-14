package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* com.example.demo.User.UserController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before API call: " + joinPoint.getSignature().getName() + " is about to be executed.");

        if (joinPoint.getSignature().getName().startsWith("create") || joinPoint.getSignature().getName().startsWith("update")) {
            Object[] args = joinPoint.getArgs();
            System.out.println("Request Body: " + Arrays.toString(args));
        }
    }

    @After("execution(* com.example.demo.User.UserController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After API call: " + joinPoint.getSignature().getName() + " execution completed.");
    }
}
