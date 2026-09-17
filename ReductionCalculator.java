import java.util.Scanner;

public class ReductionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Demander le prix
            System.out.print("Entrez le prix initial (en euros) : ");
            double prix = scanner.nextDouble();

            // Demander la réduction en pourcentage
            System.out.print("Entrez la réduction (en pourcentage %) : ");
            double reductionPourcentage = scanner.nextDouble();

            // Vérifier que les valeurs sont valides
            if (prix < 0 || reductionPourcentage < 0 || reductionPourcentage > 100) {
                System.out.println("Erreur : Le prix et le pourcentage de réduction doivent être positifs, et le pourcentage ne peut pas dépasser 100.");
            } else {
                // Calculer le prix après réduction
                double prixApresReduction = prix - (prix * reductionPourcentage / 100);

                // Afficher le résultat
                System.out.printf("\nPrix après réduction de %.0f%% : %.2f euros\n", reductionPourcentage, prixApresReduction);
            }
        } catch (Exception e) {
            System.out.println("Erreur : Veuillez entrer des valeurs numériques valides.");
        } finally {
            scanner.close();
        }
    }
}