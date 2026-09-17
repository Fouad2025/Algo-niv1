package app;

import model.Produit1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nom du produit : ");
        String nom = sc.nextLine();

        System.out.print("Prix du produit : ");
        double prix = Double.parseDouble(sc.nextLine().replace(',', '.'));

        Produit1 p = new Produit1(nom, prix);
        System.out.println("✅ Produit créé : " + p);

            sc.close();
        }
    }
if (!timeStr.matches("\\d{1,2}:\\d{2}")) {
            System.out.println("Format d'heure invalide ! Utilisez HH:mm.");
            continue;
        }