import java.util.*;
import java.text.*;

public class Stockage {
    private static final ArrayList<ArrayList<String>> produits = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner sc = new Scanner(System.in);
    private static int compteurId = 1; // Ajout du compteur d'ID

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1:
                    ajouterProduit();
                    break;
                case 2:
                    afficherProduits();
                    break;
                case 3:
                    supprimerProduit();
                    break;
                case 4:
                    rechercherProduit();
                    break;
                case 5:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        }
        sc.close();
        System.out.println("Merci de votre visite.");
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Afficher les produits");
        System.out.println("3. Supprimer un produit par ID");
        System.out.println("4. Rechercher un produit par ID");
        System.out.println("5. Quitter");
    }

    private static void ajouterProduit() {
        try {
            System.out.print("Origine du produit ? (Ville/Pays): ");
            String nom = sc.nextLine();

            double prix = lireDouble("Prix du produit ? : ");

            String type = "";
            boolean typeValide = false;
            while (!typeValide) {
                System.out.println("Veuillez choisir un type de produit :");
                System.out.println("1. Electro-ménager");
                System.out.println("2. TV");
                System.out.println("3. Micro-Informatique");
                System.out.println("4. Audio");
                System.out.print("Votre choix : ");
                String choixStr = sc.nextLine();
                switch (choixStr) {
                    case "1":
                        type = "Electro-ménager";
                        typeValide = true;
                        break;
                    case "2":
                        type = "TV";
                        typeValide = true;
                        break;
                    case "3":
                        type = "Micro-Informatique";
                        typeValide = true;
                        break;
                    case "4":
                        type = "Audio";
                        typeValide = true;
                        break;
                    default:
                        System.out.println("Type invalide, veuillez recommencer.");
                        break;
                }
            }

            String dateStockageStr;
            Date dateStockage;
            while (true) {
                System.out.print("Date de stockage du produit ? (dd/MM/yyyy) : ");
                dateStockageStr = sc.nextLine();
                if (dateStockageStr.isEmpty()) {
                    System.out.println("Date de stockage ne peut pas être vide.");
                    continue;
                }
                try {
                    dateStockage = dateFormat.parse(dateStockageStr);
                    if (dateStockage.after(new Date())) {
                        System.out.println("Erreur : la date de stockage ne peut pas être dans le futur !");
                        continue;
                    }
                    break;
                } catch (ParseException e) {
                    System.out.println("Erreur : Format de date invalide !");
                }
            }

            System.out.print("Est-ce que le produit est soldé ? (V/F) : ");
            String input = sc.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = sc.nextLine().trim().toUpperCase();
            }
            String estSolde = input.equals("V") ? "Soldé" : "Normal";

            // Application des réductions
            Calendar calStock = Calendar.getInstance();
            calStock.setTime(dateStockage);
            Calendar calNow = Calendar.getInstance();
            calNow.setTime(new Date());
            int diffYear = calNow.get(Calendar.YEAR) - calStock.get(Calendar.YEAR);
            int diffMonth = diffYear * 12 + calNow.get(Calendar.MONTH) - calStock.get(Calendar.MONTH);
            double prixFinal = prix;
            if (diffMonth > 4) prixFinal *= 0.9;
            if (estSolde.equals("Soldé")) prixFinal *= 0.6;

            ArrayList<String> produit = new ArrayList<>();
            produit.add(String.valueOf(compteurId++)); // Ajout de l'ID
            produit.add(nom);
            produit.add(type);
            produit.add(dateStockageStr);
            produit.add(estSolde);
            produit.add(String.format("%.2f", prixFinal));
            produits.add(produit);

            System.out.println("Produit ajouté avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    private static void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré !");
        } else {
            System.out.println("\nListe des produits :");
            int i = 1;
            for (ArrayList<String> p : produits) {
                System.out.println(i++ + ". ID: " + p.get(0) + " | Nom: " + p.get(1) + " | " + p.get(2) + " | " + p.get(3) + " | " + p.get(4) + " | Prix: " + p.get(5) + "€");
            }
        }
    }

    private static void supprimerProduit() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit à supprimer !");
            return;
        }
        int id = lireEntier("Entrez l'ID du produit à supprimer : ");
        boolean trouve = false;
        Iterator<ArrayList<String>> it = produits.iterator();
        while (it.hasNext()) {
            ArrayList<String> p = it.next();
            if (Integer.parseInt(p.get(0)) == id) {
                it.remove();
                trouve = true;
                break;
            }
        }
        if (trouve) {
            System.out.println("Produit supprimé avec l'ID " + id + ".");
        } else {
            System.out.println("Aucun produit trouvé avec cet ID.");
        }
    }

    private static void rechercherProduit() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré !");
            return;
        }
        int id = lireEntier("Entrez l'ID du produit à rechercher : ");
        boolean trouve = false;
        for (ArrayList<String> p : produits) {
            if (Integer.parseInt(p.get(0)) == id) {
                System.out.println("Produit trouvé : ID: " + p.get(0) + " | Nom: " + p.get(1) + " | " + p.get(2) + " | " + p.get(3) + " | " + p.get(4) + " | Prix: " + p.get(5) + "€");
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            System.out.println("Aucun produit trouvé avec cet ID.");
        }
    }

    private static int lireEntier(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entier valide !");
            }
        }
    }

    private static double lireDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                return Double.parseDouble(input.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
            }
        }
    }
}