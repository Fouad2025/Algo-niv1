import java.util.Scanner;

public class taille {
    public static void main(String[] args) {
        taille();
    }

    public static void taille() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Quelle est votre taille en cm ? ");
            double tailleCm = scanner.nextDouble();
            
            // Validation de la taille (doit être positive)
            if (tailleCm <= 0) {
                System.out.println("Erreur : La taille doit être positive");
                return;
            }
            
            // Conversion en mètres avec arrondi à 2 décimales
            double tailleM = Math.round(tailleCm * 100.0) / 10000.0;
            
            System.out.printf("Votre taille est de %.2f mètres%n", tailleM);
        } catch (Exception e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide");
        } finally {
            scanner.close();
        }
    }
}