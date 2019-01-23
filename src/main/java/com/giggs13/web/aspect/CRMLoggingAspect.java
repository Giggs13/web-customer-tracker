package com.giggs13.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class CRMLoggingAspect {

    @Before("com.giggs13.web.aspect.AopExpressions.appFlowMethods()")
    private void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n---> Executing @Before advice on a method " + method);

        Arrays.stream(joinPoint.getArgs())
                .forEach(argument -> logger.info("\n---> Argument: {}", argument));
    }

    @AfterReturning(
            pointcut = "com.giggs13.web.aspect.AopExpressions.appFlowMethods()",
            returning = "result")
    private void afterReturning(JoinPoint joinPoint,
                                Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n<--- Executing @AfterReturning advice on a method " + method);

        logger.info("\n<--- Result: {}", result);
    }
}
