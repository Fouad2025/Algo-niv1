import java.util.InputMismatchException;
import java.util.Scanner;

public class AdditionEnBoucle {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        boolean continuer = true;

        System.out.println("🧮 Bienvenue dans l'addition magique !");
        
        while (continuer) {
            try {
                System.out.print("Entrez le premier entier : ");
                int a = clavier.nextInt();

                System.out.print("Entrez le deuxième entier : ");
                int b = clavier.nextInt();

                int resultat = a + b;
                System.out.println("✅ Résultat : " + a + " + " + b + " = " + resultat);

                // Nettoyage du buffer
                clavier.nextLine();

                System.out.print("\nSouhaitez-vous faire une autre addition ? (oui/non) : ");
                String reponse = clavier.nextLine().trim().toLowerCase();
                if (!reponse.equals("oui")) {
                    continuer = false;
                    System.out.println("\n👋 Merci d’avoir utilisé l’addition magique !");
                }

            } catch (InputMismatchException e) {
                System.out.println("🚫 Veuillez entrer uniquement des nombres entiers !");
                clavier.nextLine(); // Nettoie le scanner pour repartir proprement
            }
        }

        clavier.close();
    }
}
