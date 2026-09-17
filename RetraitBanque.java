import java.util.Scanner;

public class RetraitBanque {
    public static void main(String[] args) {
        double solde = 3000.0;
        solde = retirerArgent(solde);
    }

    public static double retirerArgent(double solde) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour, combien voulez-vous retirer ?");
        double montant = scanner.nextDouble();

        if (montant > solde) {
            System.out.println("Opération refusée, fond insuffissant !");
        } else {
            solde -= montant;
            System.out.printf("Retrait de %.2f€ effectué. Nouveau solde : %.2f€%n", montant, solde);
        }

        scanner.close();
        return solde;
        }
}