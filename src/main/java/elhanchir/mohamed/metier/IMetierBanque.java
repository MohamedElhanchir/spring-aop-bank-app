package elhanchir.mohamed.metier;

import elhanchir.mohamed.entities.Compte;

public interface IMetierBanque {
    void addCompte(Compte cp);
    void verser(Long code, double solde);
    void retirer(Long code, double solde);
    Compte getCompte(Long code);
}
