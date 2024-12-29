package elhanchir.mohamed.aspect;

import elhanchir.mohamed.entities.Compte;
import elhanchir.mohamed.metier.IMetierBanqueImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchAspect {
    @Pointcut("execution(* elhanchir.mohamed.metier.IMetierBanqueImpl.retirer(..))")
    public void pc1(){}

    @Around("pc1() && args(code,solde)")
    public Object autourRetirer(Long code,double solde, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        IMetierBanqueImpl metierBanque = (IMetierBanqueImpl) proceedingJoinPoint.getTarget();
        Compte compte = metierBanque.getCompte(code);
        if (compte.getSolde() < solde) throw new RuntimeException("Solde insuffisant");
        return proceedingJoinPoint.proceed();
    }

    @Pointcut("execution(* elhanchir.mohamed.metier.IMetierBanqueImpl.verser(..))")
    public void pc2(){}

    @Around("pc2() && args(code,solde)")
    public Object autourVerser(Long code,double solde, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (solde < 0) throw new RuntimeException("Impossible de verser un montant négatif");
        return proceedingJoinPoint.proceed();
    }


}
