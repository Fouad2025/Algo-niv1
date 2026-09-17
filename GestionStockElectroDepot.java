import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Produit {
    private static int dernierId = 456;
    private final String id;
    private final String nom;
    private final LocalDate dateStockage;
    private boolean solde;
    private final double prix;

    public Produit(String nom, double prix, String suffixeId) {
        this.id = (++dernierId) + suffixeId;
        this.nom = nom;
        this.prix = prix;
        this.dateStockage = LocalDate.now();
        this.solde = false;
    }

    public Produit(String nom, double prix, String suffixeId, LocalDate dateStockage) {
        this.id = (++dernierId) + suffixeId;
        this.nom = nom;
        this.prix = prix;
        this.dateStockage = dateStockage;
        this.solde = false;
    }

    // Getters
    public String getId() { return id; }
    public String getNom() { return nom; }
    public LocalDate getDateStockage() { return dateStockage; }
    public boolean isSolde() { return solde; }
    public double getPrix() { return prix; }

    // Setter pour solde
    public void setSolde(boolean solde) { this.solde = solde; }

    public double getPrixSolde() {
        return solde ? prix * 0.6 : prix; // 40% de réduction si en solde
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
            "ID: %-6s | Nom: %-20s | Date: %-10s | Prix: %-8.2f€ | %-8s | Prix final: %.2f€",
            id, 
            nom, 
            dateStockage.format(formatter), 
            prix,
            solde ? "[SOLDE]" : "[NORMAL]",
            getPrixSolde()
        );
    }
}

public class GestionStockElectroDepot {
    private static final ArrayList<Produit> stock = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialiserExemples();
        
        int choix;
        do {
            afficherMenu();
            choix = lireChoix();
            executerChoix(choix);
        } while (choix != 6);
        
        scanner.close();
    }

    private static void initialiserExemples() {
        stock.add(new Produit("TV Samsung 4K", 850.0, "op", LocalDate.of(2025, 2, 4)));
        stock.add(new Produit("Réfrigérateur LG", 1200.0, "fr", LocalDate.of(2025, 1, 15)));
        stock.add(new Produit("Smartphone iPhone", 999.0, "ph", LocalDate.of(2025, 3, 10)));
        stock.add(new Produit("Lave-linge Bosch", 650.0, "lg", LocalDate.of(2025, 2, 28)));
    }

    private static void afficherMenu() {
        System.out.println("\n=== GESTION STOCK ELECTRODEPOT ===");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Afficher tous les produits");
        System.out.println("3. Rechercher un produit par ID");
        System.out.println("4. Mettre un produit en solde");
        System.out.println("5. Afficher les produits en solde");
        System.out.println("6. Quitter");
        System.out.print("Choix : ");
    }

    private static int lireChoix() {
        try {
            int choix = scanner.nextInt();
            scanner.nextLine();
            return choix;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void executerChoix(int choix) {
        switch (choix) {
            case 1 -> ajouterProduit();
            case 2 -> afficherStock(false);
            case 3 -> rechercherProduit();
            case 4 -> mettreEnSolde();
            case 5 -> afficherStock(true);
            case 6 -> System.out.println("Fermeture du système...");
            default -> System.out.println("Option invalide !");
        }
    }

    private static void ajouterProduit() {
        try {
            System.out.print("Nom du produit : ");
            String nom = scanner.nextLine();
            
            System.out.print("Suffixe d'ID (ex: 'op' pour TV) : ");
            String suffixe = scanner.nextLine();
            
            System.out.print("Prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine();
            
            if (prix <= 0) throw new IllegalArgumentException("Le prix doit être positif");
            
            Produit p = new Produit(nom, prix, suffixe);
            stock.add(p);
            System.out.println("Produit ajouté ! ID : " + p.getId());
            
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Prix invalide");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void afficherStock(boolean seulementSoldes) {
        if (stock.isEmpty()) {
            System.out.println("Aucun produit en stock !");
            return;
        }
        
        System.out.println("\n=== " + (seulementSoldes ? "PRODUITS EN SOLDE" : "TOUS LES PRODUITS") + " ===");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("ID     | Nom                 | Date       | Prix     | Statut   | Prix final");
        System.out.println("-------------------------------------------------------------------------------");
        
        for (Produit p : stock) {
            if (!seulementSoldes || p.isSolde()) {
                System.out.println(p);
            }
        }
    }

    private static void rechercherProduit() {
        System.out.print("ID du produit à rechercher (ex: 457op) : ");
        String id = scanner.nextLine();
        
        for (Produit p : stock) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("\nPRODUIT TROUVÉ :");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Aucun produit trouvé avec l'ID " + id);
    }

    private static void mettreEnSolde() {
        System.out.print("ID du produit à mettre en solde (ex: 457op) : ");
        String id = scanner.nextLine();
        
        for (Produit p : stock) {
            if (p.getId().equalsIgnoreCase(id)) {
                p.setSolde(true);
                System.out.println("Produit mis en solde ! Nouveau prix : " + p.getPrixSolde() + "€");
                return;
            }
        }
        System.out.println("Aucun produit trouvé avec l'ID " + id);
    }
}