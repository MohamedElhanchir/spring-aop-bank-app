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
            Scanner scanner = new Scanner(System.in);

            System.out.println("Démarrage de l'application");
            System.out.print("Veuillez saisir le montant du compte: ");
            double solde = scanner.nextDouble();
            System.out.print("Veuillez saisir le code du compte: ");
            Long code = scanner.nextLong();
            metierBanque.addCompte(new Compte(code, solde));
            System.out.println("Compte créé avec succès.");

            while (true) {
                System.out.println("<------- Veuillez saisir le code de l'opération à effectuer ------->");
                System.out.println("1: Verser");
                System.out.println("2: Retirer");
                System.out.println("3: Quitter");
                System.out.print("Votre choix: ");
                int choix = scanner.nextInt();

                try {
                    switch (choix) {
                        case 1:
                            effectuerOperation(metierBanque, scanner, code, "verser");
                            break;
                        case 2:
                            effectuerOperation(metierBanque, scanner, code, "retirer");
                            break;
                        case 3:
                            System.out.println("Merci d'avoir utilisé notre application");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Veuillez saisir un choix valide!!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    private void effectuerOperation(IMetierBanque metierBanque, Scanner scanner, Long code, String operation) throws InterruptedException {
        System.out.print("Veuillez saisir le montant à " + operation + ": ");
        double montant = scanner.nextDouble();
        if (operation.equals("verser")) {
            metierBanque.verser(code, montant);
        } else if (operation.equals("retirer")) {
            metierBanque.retirer(code, montant);
        }
        System.out.println(metierBanque.getCompte(code));
    }
}