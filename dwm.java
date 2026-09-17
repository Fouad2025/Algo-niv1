import java.util.*;
import java.text.*;

public class dwm {
    private static final ArrayList<ArrayList<String>> produits = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        boolean continuer = true;
        System.out.println("Bienvenue dans le système de gestion de stock de produits !");
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
        System.out.println("3. Supprimer un produit par nom");
        System.out.println("4. Rechercher un produit par nom");
        System.out.println("5. Quitter");
    }

    private static void ajouterProduit() {
        try {
            System.out.print("Nom du produit ? : ");
            String nom = sc.nextLine();

            double prix;
            while (true) {
                System.out.print("Prix du produit ? : ");
                String input = sc.nextLine().replace(',', '.');
                try {
                    prix = Double.parseDouble(input);
                    prix = Math.round(prix * 100.0) / 100.0;
                    if (prix >= 0) {
                        break;
                    } else {
                        System.out.println("Le prix doit être positif !");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer un nombre valide (ex: 4,20 ou 4.20) !");
                }
            }

            System.out.print("Type de produit ? : ");
            String type = sc.nextLine();

            // Date de fabrication
            String dateFabricationStr;
            Date dateFabrication;
            while (true) {
                System.out.print("Date de fabrication du produit ? (dd/MM/yyyy) : ");
                dateFabricationStr = sc.nextLine();
                try {
                    dateFabrication = dateFormat.parse(dateFabricationStr);
                    if (dateFabrication.after(new Date())) {
                        System.out.println("Erreur : la date de fabrication ne peut pas être dans le futur !");
                    } else {
                        break;
                    }
                } catch (ParseException e) {
                    System.out.println("Format de date invalide !");
                }
            }

            // Date de péremption
            String datePeremptionStr;
            Date datePeremption;
            while (true) {
                System.out.print("Date de péremption du produit ? (dd/MM/yyyy) : ");
                datePeremptionStr = sc.nextLine();
                try {
                    datePeremption = dateFormat.parse(datePeremptionStr);
                    if (datePeremption.before(dateFabrication)) {
                        System.out.println("Erreur : la date de péremption doit être après la date de fabrication !");
                    } else {
                        break;
                    }
                } catch (ParseException e) {
                    System.out.println("Format de date invalide !");
                }
            }

            // Réduction si la date de péremption est dans 3 jours ou moins
            long diffMillis = datePeremption.getTime() - new Date().getTime();
            long diffJours = diffMillis / (1000 * 60 * 60 * 24);
            if (diffJours >= 0 && diffJours <= 3) {
                prix = prix * 0.8;
                System.out.println("Attention : la date de péremption est proche, réduction de 20% appliquée !");
            }

            ArrayList<String> produit = new ArrayList<>();
            produit.add(nom);
            produit.add(type);
            produit.add(dateFabricationStr);
            produit.add(datePeremptionStr);
            produit.add(String.format("%.2f", prix));
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
                System.out.println(i++ + ". Nom: " + p.get(0) + " | Type: " + p.get(1) + " | Fab: " + p.get(2) + " | Péremption: " + p.get(3) + " | Prix: " + p.get(4) + "€");
            }
        }
    }

    private static void supprimerProduit() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit à supprimer !");
            return;
        }
        System.out.print("Entrez le nom du produit à supprimer : ");
        String nom = sc.nextLine().trim();
        boolean trouve = false;
        Iterator<ArrayList<String>> it = produits.iterator();
        while (it.hasNext()) {
            ArrayList<String> p = it.next();
            if (p.get(0).equalsIgnoreCase(nom)) {
                it.remove();
                trouve = true;
            }
        }
        if (trouve) {
            System.out.println("Produit(s) supprimé(s) avec le nom \"" + nom + "\".");
        } else {
            System.out.println("Aucun produit trouvé avec ce nom.");
        }
    }

    private static void rechercherProduit() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit enregistré !");
            return;
        }
        System.out.print("Entrez le nom du produit à rechercher : ");
        String nom = sc.nextLine().trim();
        boolean trouve = false;
        for (ArrayList<String> p : produits) {
            if (p.get(0).equalsIgnoreCase(nom)) {
                System.out.println("Produit trouvé : Nom: " + p.get(0) + " | Type: " + p.get(1) + " | Fab: " + p.get(2) + " | Péremption: " + p.get(3) + " | Prix: " + p.get(4) + "€");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun produit trouvé avec ce nom.");
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