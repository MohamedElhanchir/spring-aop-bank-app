package elhanchir.mohamed.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* elhanchir.mohamed.Main.start())")
    public void startAppPointcut(){}


    @Around("startAppPointcut()")
    public void autourStart(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le mot de passe: ");
        String password = scanner.nextLine();
        if (password.equals("1234")) {
            proceedingJoinPoint.proceed();
        } else {
            System.out.println("Mot de passe incorrect");
        }
    }
}
