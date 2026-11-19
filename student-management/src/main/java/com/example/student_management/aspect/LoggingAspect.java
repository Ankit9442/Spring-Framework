
package com.example.student_management.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger log =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.student_management.service..*(..))")
    public void serviceMethods() {
    }

    // Performance and exception logging
    @Around("serviceMethods()")
    public Object monitorExecution(ProceedingJoinPoint joinPoint)
            throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        long startTime = System.nanoTime();

        try {
            return joinPoint.proceed();

        } catch (Throwable exception) {

            log.error(
                    "Service execution failed. method={}",
                    methodName,
                    exception
            );

            throw exception;

        } finally {

            long executionTime =
                    (System.nanoTime() - startTime) / 1_000_000;

            log.info(
                    "Service execution completed. method={} durationMs={}",
                    methodName,
                    executionTime
            );
        }
    }

    // Audit logging
    @AfterReturning(
            pointcut = "@annotation(audited)",
            argNames = "audited"
    )
    public void auditOperation(Audited audited) {

        log.info(
                "AUDIT_EVENT action={}",
                audited.action()
        );
    }
}
