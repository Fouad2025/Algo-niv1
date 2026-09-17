import java.util.InputMismatchException;
import java.util.Scanner;

public class equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Bienvenue dans la calculatrice magique !");

        boolean continuer = true;
        while (continuer) {
            try {
                double a = demanderNombre(scanner, "Entrez le premier nombre : ");
                double b = demanderNombre(scanner, "Entrez le deuxième nombre : ");
                double c = demanderNombre(scanner, "Entrez le troisième nombre : ");

                double resultat = multiplierEtDiviser(a, b, c);
                afficherResultat(a, b, c, "x", resultat);

                continuer = demanderContinuer(scanner);
            } catch (InputMismatchException e) {
                System.out.println(" Erreur : Veuillez entrer un nombre valide !");
                scanner.nextLine(); // Nettoyage du buffer
            } catch (ArithmeticException e) {
                System.out.println(" Erreur : " + e.getMessage());
            }
        }
        scanner.close();
    
}
    // Fonction pour demander un nombre à l'utilisateur
    private static double demanderNombre(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextDouble();

    }

   

    // Fonction pour effectuer le calcul
    public static double multiplierEtDiviser(double a, double b, double c) {
    if (c == 0) {
        throw new IllegalArgumentException("Division par zéro interdite !");
    }
    return (a * b) / c;
}


    // Fonction pour afficher le résultat
    private static void afficherResultat(double a, double b, double c, String operation, double resultat) {
        System.out.printf(" Résultat : %.2f %s %.2f %s %.2f = %.2f%n", a, operation, b, operation, c, resultat);
    }

    // Fonction pour demander si l'utilisateur veut continuer
    private static boolean demanderContinuer(Scanner scanner) {
        System.out.print("Voulez-vous continuer ? (oui/non) : ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        return reponse.equals("oui");
    }
}