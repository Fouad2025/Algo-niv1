import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date;  
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class stockproduitsversion1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans le système de gestion de stock de produits !");
        System.out.println("Veuillez entrer les informations du produit :");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateSysteme = new Date();
        boolean estSolde = false;
        System.out.println("Date actuelle : " + dateFormat.format(dateSysteme));

        try {
            System.out.println("Nom du produit ? :");
            String nom = sc.nextLine();

            System.out.println("Prix du produit ? :");
            double prix = sc.nextDouble();
            sc.nextLine(); // Nettoie le buffer

            System.out.println("Type de produit ? :");
            String type = sc.nextLine();

            System.out.println("Date de stockage du produit ? (dd/MM/yyyy) :");
            String dateStockageStr = sc.nextLine();

            // Calcul de la différence de mois
            Date dateStockage = dateFormat.parse(dateStockageStr);
            Calendar calStock = Calendar.getInstance();
            calStock.setTime(dateStockage);
            Calendar calNow = Calendar.getInstance();
            calNow.setTime(dateSysteme);

            int diffYear = calNow.get(Calendar.YEAR) - calStock.get(Calendar.YEAR);
            int diffMonth = diffYear * 12 + calNow.get(Calendar.MONTH) - calStock.get(Calendar.MONTH);

            if (diffMonth > 4) {
                prix *= 0.9; // Réduction de 10%
                System.out.println("Produit stocké depuis plus de 4 mois : réduction de 10% appliquée.");
            }

            System.out.println("Est-ce que le produit est soldé ? (V/F) :");
            String input = sc.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = sc.nextLine().trim().toUpperCase();
            }
            estSolde = input.equals("V");
            if (estSolde) {
                prix *= 0.6; // Applique une réduction de 40% si le produit est soldé
                System.out.println("Le produit est soldé (-40%).");
            } else {
                System.out.println("Le produit n'est pas soldé.");
            }

            

            System.out.println("Le produit " + nom + " de type " + type + " au prix de " + prix +
                    " a été stocké le " + dateStockageStr );
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer des valeurs valides !");
        } catch (ParseException e) {
            System.out.println("Erreur : Format de date invalide !");
        } finally {
            sc.close();
        }
    }
}