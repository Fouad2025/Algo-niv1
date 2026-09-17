import java.util.Scanner;

public class Soustraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Donnez une valeur à A : ");
        int a = scanner.nextInt();
        
        System.out.println("Donnez une valeur à B : ");

        int b = scanner.nextInt();
        
        
        int resultat = a - b;
        
        System.out.println("\nLa soustraction de " + a + " et " + b + " est : " + resultat);
        
        
        if (resultat < 0) {
            System.out.println("Cette soustraction est inférieure ou égale à 0.");
        } else {
            System.out.println("Cette soustraction est supérieure ou égale à 0.");
        }
        
        scanner.close();
    }
}