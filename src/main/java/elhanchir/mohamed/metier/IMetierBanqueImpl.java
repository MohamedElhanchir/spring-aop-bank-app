package elhanchir.mohamed.metier;

import elhanchir.mohamed.aspect.PatchAspect;
import elhanchir.mohamed.entities.Compte;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class IMetierBanqueImpl extends PatchAspect implements IMetierBanque {
    private HashMap<Long, Compte> comptes = new HashMap<>();
    @Override
    public void addCompte(Compte cp) {
        comptes.put(cp.getCode(), cp);
    }

    @Override
    public void verser(Long code, double solde) throws InterruptedException {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() + solde);
        sleep(1000);
    }

    @Override
    public void retirer(Long code, double solde) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() - solde);
    }

    @Override
    public Compte getCompte(Long code) {
        return comptes.get(code);
    }
}
