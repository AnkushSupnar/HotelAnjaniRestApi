package com.anjani.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
    @Pointcut(value = "execution(* com.anjani.*.*.*(..))")
    public void myPointcut(){

    }
    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp){
        ObjectMapper mapper = new ObjectMapper();
        String method = pjp.getSignature().getName();
        String classname = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        try {
            log.info("Methos invoiked: "+classname+" :"+method+"()"+" arguments:"+mapper.writeValueAsString(array));
       Object obj = pjp.proceed();
            log.info(classname+" :"+method+"()"+" Response :"+mapper.writeValueAsString(obj));
       return obj;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
