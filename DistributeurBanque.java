import java.util.Scanner;

public class DistributeurBanque {
    public static void main(String[] args) {
        // Initialisation du solde
       

        // Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        double solde = 3000.0;
        // Affichage du message
        System.out.println("Bonjour, combien voulez-vous retirer ?");

        // Lecture du montant à retirer
        double montant = scanner.nextDouble();

        // Vérification du solde
        if (montant > solde) {
            System.out.println("Opération refusée, fond insuffisant !");
        } else {
            solde -= montant;
            System.out.println("Retrait effectué avec succès. Nouveau solde : " + solde + "€");
        }

        // Fermeture du scanner
        scanner.close();
    }
}
