package com.giggs13.web.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {

    @Pointcut("execution(* com.giggs13.web.controller.*.*(..))")
    private void controllerMethods() {
    }

    @Pointcut("execution(* com.giggs13.web.service.*.*(..))")
    private void serviceMethods() {
    }

    @Pointcut("execution(* com.giggs13.web.dao.*.*(..))")
    private void repositoryMethods() {
    }

    @Pointcut("controllerMethods() || serviceMethods() || repositoryMethods()")
    void appFlowMethods() {
    }
}
