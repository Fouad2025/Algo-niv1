import java.util.Scanner;

/***--------Donner un nom à votre class -------------------****/

public class Lesson {

    public static void main(String[] args) {

        /***--------  Début du code  -------------------****/

        int a;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        a = sc.nextInt();

        System.out.println("You entered: " + a);

        sc.close();

        /***--------  Fin du code  -------------------****/
    }
}