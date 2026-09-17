
   import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

public class pricereduc {
    public static void main(String[] args) {
        pricereduc(); // Appel de la méthode pricereduc pour démarrer le programme
    }

    public static void pricereduc() {
        double price = 0.0; // Prix initial du produit
        double discount = 0.0; // Taux de réduction
        double finalPrice = 0.0; // Prix final après application de la réduction

        Scanner clavier = new Scanner(System.in);

        try {
            System.out.println("Votre prix ?");
            price = clavier.nextDouble();

            System.out.println("Votre réduction (en pourcentage %)");
            discount = clavier.nextDouble();

            price = Math.round(price * 100) / 100.0;
            System.out.println("Votre prix : " + price + " euros");

            finalPrice = price * (1 - discount / 100.0);
            finalPrice = Math.round(finalPrice * 100) / 100.0;

            System.out.println("Votre prix après réduction : " + finalPrice + " euros");
            System.out.println("Votre prix de " + price + " euros après une réduction de " + discount + "% vaut " + finalPrice + " euros");
        } catch (Exception e) {
            System.out.println("Erreur : Veuillez entrer des valeurs valides !");
        } finally {
            clavier.close();
        }
    }
}