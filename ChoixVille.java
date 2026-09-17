import java.util.Scanner;

public class ChoixVille {

    static String[] villes = {"Paris", "Londres", "Madrid", "Lisbonne", "Berlin"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            afficherVilles();
            choisirVille(scanner);

            System.out.print("\nSouhaitez-vous choisir une autre ville ? (oui/non) : ");
            String reponse = scanner.next().trim().toLowerCase();
            if (!reponse.equals("oui")) {
                continuer = false;
                System.out.println("\nMerci pour votre visite, à bientôt !");
            }
        }
        scanner.close();
    }

    public static void afficherVilles() {
        System.out.println("\nBonjour, quelle ville voulez-vous visiter ?");
        for (int i = 0; i < villes.length; i++) {
            System.out.println(i + " - " + villes[i]);
        }
    }

    public static void choisirVille(Scanner scanner) {
        System.out.print("\nEntrez le numéro de la ville : ");
        try {
            int index = scanner.nextInt();
            String ville = villes[index];
            afficherBienvenue(ville);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur : numéro de ville invalide.");
        } catch (Exception e) {
            System.out.println("Erreur : veuillez entrer un nombre entier.");
            scanner.nextLine(); // pour vider le buffer
        }
    }

    public static void afficherBienvenue(String ville) {
        switch (ville) {
            case "Paris":
                System.out.println("Bienvenue à Paris !");
                break;
            case "Londres":
                System.out.println("Welcome to London!");
                break;
            case "Madrid":
                System.out.println("¡Bienvenido a Madrid!");
                break;
            case "Lisbonne":
                System.out.println("Bem-vindo a Lisboa!");
                break;
            case "Berlin":
                System.out.println("Willkommen in Berlin!");
                break;
            default:
                System.out.println("Ville inconnue.");
        }
    }
}
