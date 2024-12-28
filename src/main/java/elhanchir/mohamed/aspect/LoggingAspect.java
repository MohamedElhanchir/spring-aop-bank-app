package elhanchir.mohamed.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    long t1, t2;
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.txt"));
        logger.setUseParentHandlers(false);
    }
    @Pointcut("execution(* elhanchir.mohamed.metier.IMetierBanqueImpl.*(..))")
    public void pc1(){}

    /*@Before("pc1()")
    public void logBefore(JoinPoint joinPoint){
        t1 = System.currentTimeMillis();
        logger.info("----------------------------------");
        logger.info("Log avant l'exécution de la méthode"+joinPoint.getSignature().getName());
    }

    @After("pc1()")
    public void logAfter(JoinPoint joinPoint){
        t2 = System.currentTimeMillis();
        logger.info("Durée d'exécution de la méthode "+joinPoint.getSignature().getName()+" est de "+(t2-t1)+" ms");
        logger.info("Log après l'exécution de la méthode");
        logger.info("----------------------------------");
    }*/
    @Around("pc1()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        t1 = System.currentTimeMillis();
        logger.info("----------------------------------");
        logger.info("Log avant l'exécution de la méthode "+proceedingJoinPoint.getSignature().getName());
        Object o = proceedingJoinPoint.proceed();
        t2 = System.currentTimeMillis();
        logger.info("Durée d'exécution de la méthode "+proceedingJoinPoint.getSignature().getName()+" est de "+(t2-t1)+" ms");
        logger.info("Log après l'exécution de la méthode");
        logger.info("----------------------------------");
        return o;
    }
}
