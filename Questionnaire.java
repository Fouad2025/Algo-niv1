import java.util.Scanner;

public class Questionnaire {
    public static void main(String[] args) {
        poserQuestion();
    }

    public static void poserQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you speak english? (yes/no): ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        while (!reponse.equals("yes") && !reponse.equals("no")) {
            System.out.print("Please answer with 'yes' or 'no': ");
            reponse = scanner.nextLine().trim().toLowerCase();
            
        }

        if (reponse.equals("yes")) {
            System.out.println("Nice to meet you");
        } else {
            System.out.println("So learn english !");
        }
        scanner.close();
    }
}
