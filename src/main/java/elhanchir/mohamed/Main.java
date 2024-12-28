package elhanchir.mohamed;

import elhanchir.mohamed.entities.Compte;
import elhanchir.mohamed.metier.IMetierBanque;
import elhanchir.mohamed.metier.IMetierBanqueImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        IMetierBanque metierBanque = new IMetierBanqueImpl();
        System.out.println("Démarrage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le montant du compte: ");
        double solde = scanner.nextDouble();
        System.out.println("Veuillez saisir le code du compte: ");
        Long code = scanner.nextLong();
        metierBanque.addCompte(new Compte(code, solde));
        System.out.println("Compte créé avec succès.");

        while (true){
            System.out.println("<------- Veuillez saisir le code de l'opération à effectuer ------->");
            System.out.println("1: Verser");
            System.out.println("2: Retirer");
            System.out.println("3: Quitter");
            System.out.println("Votre choix: ");
            int choix = scanner.nextInt();
            switch (choix){
                case 1:
                    System.out.println("Veuillez saisir le montant à verser: ");
                    double montant = scanner.nextDouble();
                    metierBanque.verser(code, montant);
                    System.out.println(metierBanque.getCompte(code));
                    break;
                case 2:
                    System.out.println("Veuillez saisir le montant à retirer: ");
                    montant = scanner.nextDouble();
                    metierBanque.retirer(code, montant);
                    System.out.println(metierBanque.getCompte(code));
                    break;
                case 3:
                    System.out.println("Merci d'avoir utilisé notre application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Veuillez saisir un choix valide!!");
            }
        }

    }
}