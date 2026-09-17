import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatriceModulaire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🧮 Bienvenue dans la calculatrice magique !");

        boolean continuer = true;
        while (continuer) {
            try {
                double a = demanderNombre(scanner, "Entrez le premier nombre : ");
                double b = demanderNombre(scanner, "Entrez le deuxième nombre : ");
                String operation = demanderOperation(scanner);

                double resultat = calculer(a, b, operation);
                afficherResultat(a, b, operation, resultat);

                continuer = demanderContinuer(scanner);
            } catch (InputMismatchException e) {
                System.out.println("🚫 Erreur : Veuillez entrer un nombre valide !");
                scanner.nextLine(); // Nettoyage du buffer
            } catch (ArithmeticException e) {
                System.out.println("🚫 Erreur : " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Fonction pour demander un nombre à l'utilisateur
    private static double demanderNombre(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    // Fonction pour demander l'opération à effectuer
    private static String demanderOperation(Scanner scanner) {
        scanner.nextLine(); // Nettoyage du buffer
        System.out.print("Choisissez l'opération (+ ; - ; * ; /) : ");
        return scanner.nextLine().trim();
    }

    // Fonction pour effectuer le calcul
    private static double calculer(double a, double b, String operation) {
        switch (operation) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division par zéro impossible !");
                return a / b;
            default: throw new IllegalArgumentException("Opération inconnue !");
        }
    }

    // Fonction pour afficher le résultat
    private static void afficherResultat(double a, double b, String operation, double resultat) {
        System.out.printf("✅ Résultat : %.2f %s %.2f = %.2f%n", a, operation, b, resultat);
    }

    // Fonction pour demander si l'utilisateur veut continuer
    private static boolean demanderContinuer(Scanner scanner) {
        System.out.print("\nSouhaitez-vous faire un autre calcul ? (oui/non) : ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        if (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("o")) {
            System.out.println("\n👋 Merci d’avoir utilisé la calculatrice magique !");
            return false;
        }
        return true;
    }
}