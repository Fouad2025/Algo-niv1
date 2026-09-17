import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Produits {
    private final int id;
    private final String nom;
    private final String type;
    private final double prixBase;
    private final boolean solde;
    private final LocalDate dateStock;

    public Produit(int id, String nom, String type, double prixBase, boolean solde, LocalDate dateStock) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.prixBase = prixBase;
        this.solde = solde;
        this.dateStock = dateStock;
    }

    public int getId() {
        return id;
    }

    public void afficher() {
        System.out.println("\nID : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Type : " + type);
        System.out.println("Date de stockage : " + dateStock);
        System.out.println("Soldé : " + (solde ? "Oui (-40%)" : "Non"));
        System.out.printf("Prix final : %.2f €\n", calculerPrixFinal());
    }

    private double calculerPrixFinal() {
        long mois = ChronoUnit.MONTHS.between(dateStock, LocalDate.now());
        if (solde) return prixBase * 0.6;
        if (mois > 4) return prixBase * 0.9;
        return prixBase;
    }
}
import java.time.LocalDate;
import java.util.*;

public class StockManager {
    static Scanner scanner = new Scanner(System.in);
    static List<Produit> stock = new ArrayList<>();
    static int prochainId = 1;

    public static void main(String[] args) {
        boolean actif = true;
        while (actif) {
            System.out.println("\n--- MENU STOCK ---");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Rechercher un produit");
            System.out.println("4. Afficher tous les produits");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

            String choix = scanner.nextLine();
            try {
                switch (choix) {
                    case "1" -> ajouterProduit();
                    case "2" -> supprimerProduit();
                    case "3" -> rechercherProduit();
                    case "4" -> afficherProduits();
                    case "5" -> {
                        actif = false;
                        System.out.println("À bientôt !");
                    }
                    default -> System.out.println("Choix invalide.");
                }
            } catch (Exception e) {
                System.out.println("❌ Erreur : " + e.getMessage());
            } finally {
                System.out.println("✔ Opération terminée.");
            }
        }
        scanner.close();
    }

    static void ajouterProduit() {
        System.out.print("Nom (ville/pays) : ");
        String nom = scanner.nextLine();

        System.out.print("Type (TV/Electro-ménager/Micro-Informatique/Audio) : ");
        String type = scanner.nextLine();

        System.out.print("Prix de base (€) : ");
        double prix = Double.parseDouble(scanner.nextLine());

        System.out.print("Date de stockage (aaaa-mm-jj) ou vide pour aujourd'hui : ");
        String dateStr = scanner.nextLine();
        LocalDate date = dateStr.isEmpty() ? LocalDate.now() : LocalDate.parse(dateStr);

        System.out.print("Produit soldé ? (oui/non) : ");
        boolean solde = scanner.nextLine().equalsIgnoreCase("oui");

        Produit p = new Produit(prochainId++, nom, type, prix, solde, date);
        stock.add(p);
        System.out.println("✅ Produit ajouté !");
    }

    static void afficherProduits() {
        if (stock.isEmpty()) {
            System.out.println("Aucun produit enregistré.");
        } else {
            for (Produit p : stock) p.afficher();
        }
    }

    static void rechercherProduit() {
        System.out.print("ID à rechercher : ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Produit p : stock) {
            if (p.getId() == id) {
                p.afficher();
                return;
            }
        }
        System.out.println("Produit introuvable.");
    }

    static void supprimerProduit() {
        System.out.print("ID à supprimer : ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean retiré = stock.removeIf(p -> p.getId() == id);
        if (retiré) System.out.println("✅ Produit supprimé.");
        else System.out.println("Aucun produit avec cet ID.");
    }
}
