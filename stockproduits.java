import java.util.*;
import java.text.*;

class Produit {
    private static int compteur = 1;
    private final int id;
    private String nom;
    private double prix;
    private String type;
    private String dateStockageStr;
    private boolean estSolde;

    public Produit(String nom, double prix, String type, String dateStockageStr, boolean estSolde) {
        this.id = compteur++;
        this.nom = nom;
        this.prix = prix;
        this.type = type;
        this.dateStockageStr = dateStockageStr;
        this.estSolde = estSolde;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public String getType() { return type; }
    public String getDateStockageStr() { return dateStockageStr; }
    public boolean isSolde() { return estSolde; }

    public void appliquerReductions(Date dateSysteme, SimpleDateFormat dateFormat) throws ParseException {
        Date dateStockage = dateFormat.parse(dateStockageStr);
        Calendar calStock = Calendar.getInstance();
        calStock.setTime(dateStockage);
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(dateSysteme);

        int diffYear = calNow.get(Calendar.YEAR) - calStock.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + calNow.get(Calendar.MONTH) - calStock.get(Calendar.MONTH);

        if (diffMonth > 4) {
            prix *= 0.9;
        }
        if (estSolde) {
            prix *= 0.6;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nom + " | " + type + " | " + dateStockageStr + " | " +
                (estSolde ? "Soldé" : "Normal") + " | Prix: " + String.format("%.2f", prix) + "€";
    }
}

public class StockProduits {
    private static final ArrayList<Produit> produits = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date dateSysteme = new Date();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = lireEntier("Votre choix : ");
            switch (choix) {
                case 1 -> ajouterProduit();
                case 2 -> afficherProduits();
                case 3 -> supprimerProduit();
                case 4 -> rechercherProduit();
                case 5 -> continuer = false;
                default -> System.out.println("Choix invalide !");
            }
        }
        sc.close();
        System.out.println("Fin du programme.");
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
            System.out.println("Nom du produit ? :");
            String nom = sc.nextLine();

            double prix = lireDouble("Prix du produit ? :");

            System.out.println("Type de produit ? :");
            String type = sc.nextLine();

            System.out.println("Date de stockage du produit ? (dd/MM/yyyy) :");
            String dateStockageStr = sc.nextLine();

            // Vérification de la date
            dateFormat.parse(dateStockageStr);

            System.out.println("Est-ce que le produit est soldé ? (V/F) :");
            String input = sc.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = sc.nextLine().trim().toUpperCase();
            }
            boolean estSolde = input.equals("V");

            Produit p = new Produit(nom, prix, type, dateStockageStr, estSolde);
            p.appliquerReductions(dateSysteme, dateFormat);
            produits.add(p);
            System.out.println("Produit ajouté avec succès !");
        } catch (ParseException e) {
            System.out.println("Erreur : Format de date invalide !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    private static void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré !");
        } else {
            System.out.println("\nListe des produits :");
            for (Produit p : produits) {
                System.out.println(p);
            }
        }
    }

    private static void supprimerProduit() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit à supprimer !");
            return;
        }
        int id = lireEntier("Entrez l'ID du produit à supprimer : ");
        Produit aSupprimer = null;
        for (Produit p : produits) {
            if (p.getId() == id) {
                aSupprimer = p;
                break;
            }
        }
        if (aSupprimer != null) {
            produits.remove(aSupprimer);
            System.out.println("Produit supprimé !");
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
        for (Produit p : produits) {
            if (p.getId() == id) {
                System.out.println("Produit trouvé : " + p);
                return;
            }
        }
        System.out.println("Aucun produit trouvé avec cet ID.");
    }

    // Méthode utilitaire pour lire un entier avec gestion d'erreur
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

    // Méthode utilitaire pour lire un double avec gestion d'erreur
    private static double lireDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
            }
        }
    }
}