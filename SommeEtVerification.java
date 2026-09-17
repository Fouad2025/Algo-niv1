import java.util.Scanner;

public class SommeEtVerification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Saisie des valeurs
        System.out.println("Donnez une valeur à A : ");
        int a = scanner.nextInt();
        
        System.out.println("Donnez une valeur à B : ");
        int b = scanner.nextInt();
        
        // Calcul de la somme
        int somme = a + b;
        
        // Affichage de la somme
        System.out.println("\nLa somme de " + a + " et " + b + " est : " + somme);
        
        // Vérification si la somme est supérieure à 10
        if (somme > 10) {
            System.out.println("Cette somme EST supérieure à 10." );
        } else {
            System.out.println("Cette somme N'EST PAS supérieure à 10.");
        }
        
        scanner.close();
    }
}