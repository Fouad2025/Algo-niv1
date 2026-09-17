import java.util.InputMismatchException;
import java.util.Scanner;

public class prenom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le programme de gestion des prénoms !");

        boolean continuer = true;
        while (continuer) {
            try {
                String prenom = demanderPrenom(scanner, "Entrez un prénom : ");
                afficherPrenom(prenom);

                int age = demanderNombre(scanner, "Entrez l'âge de " + prenom + " : ");
                System.out.println("Je m'appelle " + prenom + ", j'ai " + age + " ans");

                continuer = demanderContinuer(scanner);
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un prénom valide !");
                scanner.nextLine(); // Nettoyage du buffer
            }
        }
        scanner.close();
    }

    // Fonction pour demander un prénom à l'utilisateur
    private static String demanderPrenom(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Fonction pour afficher le prénom
    private static void afficherPrenom(String prenom) {
        System.out.println("Le prénom entré est : " + prenom);
    }

    // Fonction pour demander si l'utilisateur veut continuer
    private static boolean demanderContinuer(Scanner scanner) {
        System.out.print("Voulez-vous continuer ? (oui/non) : ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        return reponse.equals("oui") || reponse.equals("o");
    }

    // Fonction pour demander un nombre à l'utilisateur (par exemple, l'âge)
    private static int demanderNombre(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int nombre = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour à la ligne
                return nombre;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide !");
                scanner.nextLine(); // Nettoyer le buffer
            }
        }
    }
}
   