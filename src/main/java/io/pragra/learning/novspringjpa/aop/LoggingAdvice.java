package io.pragra.learning.novspringjpa.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Objects;

@Aspect
@Slf4j
public class LoggingAdvice {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut("execution(* io.pragra.learning.novspringjpa.*.*.*(..))")
    public void myPointCut1(){

    }

    @Pointcut("execution(* io.pragra.learning.novspringjpa.*.*.*(..))")
    public void myPointCut2(){

    }
    @Around("myPointCut1(),myPointCut2()")
    public Object loggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();
        String stringArgs = objectMapper.writeValueAsString(args);
        logger.info(Instant.now() + " Class: "+className+" Method: "+methodName+" started execution with Parameter" + stringArgs );
        Object returnData = pjp.proceed();
        String stringReturnData = objectMapper.writeValueAsString(returnData);
        logger.info(Instant.now() + " Class: "+className+" Method: "+methodName+" finished execution with return data" + stringReturnData );
        return returnData;
    }
}
