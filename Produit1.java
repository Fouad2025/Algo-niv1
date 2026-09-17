package model;

public class Produit1 {
    private String nom;
    private double prix;

    public Produit1(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Produit: " + nom + " | Prix: " + String.format("%.2f", prix) + "€";
    }
}
