import java.util.InputMismatchException;
import java.util.Scanner;

public class AdditionEnBoucle {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        boolean continuer = true;

        System.out.println("🧮 Bienvenue dans la calculatrice magique !");

        while (continuer) {
            try {
                System.out.print("Entrez le premier entier : ");
                double a = clavier.nextDouble();

                System.out.print("Entrez le deuxième entier : ");
                double b = clavier.nextDouble();

                clavier.nextLine(); // Nettoyage du buffer

                System.out.print("Choisissez l'opération (+;;*;/;-) : ");
                String operation = clavier.nextLine().trim();

               double resultat = 0;

                if (operation.equals("+")) {
                    resultat = a + b;
                    System.out.println("✅ Résultat : " + a + " + " + b + " = " + resultat);
                } else if (operation.equals("-")) {
                    resultat = a - b;
                    System.out.println("✅ Résultat : " + a + " - " + b + " = " + resultat);
                } else if (operation.equals("*")) {
                    resultat = a * b;
                    System.out.println("✅ Résultat : " + a + " * " + b + " = " + resultat);
                } else if (operation.equals("/")) {
                    if (b != 0) {
                        resultat = a / b;
                        System.out.println("✅ Résultat : " + a + " / " + b + " = " + String.format("%.2f", resultat));
                    } else {
                        System.out.println("🚫 Division par zéro impossible !");
                    }
                } else {
                    System.out.println("🚫 Opération non reconnue !");
                }

                System.out.print("\nSouhaitez-vous faire un autre calcul ? (oui/non) : ");
                String reponse = clavier.nextLine().trim().toLowerCase();
                if (!reponse.equals("oui")) {
                    continuer = false;
                    System.out.println("\n👋 Merci d’avoir utilisé la calculatrice magique !");
                }

            } catch (InputMismatchException e) {
                System.out.println("🚫 Veuillez entrer uniquement des nombres entiers !");
                clavier.nextLine(); // Nettoie le scanner pour repartir proprement
            }
        }

        clavier.close();
    }
}