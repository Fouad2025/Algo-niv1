import java.util.Scanner;

public class ReductionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander le prix
        System.out.println("Votre prix ?");
        double prix = scanner.nextDouble();

        // Demander la réduction en pourcentage
        System.out.println("Votre réduction (en pourcentage %) ?");
        double reductionPourcentage = scanner.nextDouble();

        // Calculer le prix après réduction
        double prixApresReduction = prix - (prix * reductionPourcentage / 100);

        // Afficher le résultat
        System.out.printf("\nPrix après réduction de %.0f%% :\n\n%.2f\n", reductionPourcentage, prixApresReduction);

        scanner.close();
    }
}