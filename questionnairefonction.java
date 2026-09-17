import java.util.Scanner;

public class questionnairefonction {
    public static void main(String[] args) {
        poserQuestion();
    }

    public static void poserQuestion() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        try {
            System.out.print("L'informatique a besoin des mathématiques ? (V/F) ");
            String input = scanner.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = scanner.nextLine().trim().toUpperCase();
            }
            boolean reponse = input.equals("V");
            System.out.println("Votre réponse : " + (reponse ? "Oui" : "Non"));
            if (reponse) score++;

            System.out.print("L'Algèbre de Boole a été inventé par Steve Jobs ? (V/F) ");
            input = scanner.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = scanner.nextLine().trim().toUpperCase();
            }
            reponse = input.equals("V");
            if (!reponse) score++;
            System.out.println("Votre réponse : " + (reponse ? "Oui" : "Non"));

            System.out.print("En numération, la base de 10 va de 0 à 10 ? (V/F) ");
            input = scanner.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = scanner.nextLine().trim().toUpperCase();
            }
            reponse = input.equals("V");
            System.out.println("Votre réponse : " + (reponse ? "Oui" : "Non"));
            if (!reponse) score++;

            System.out.print("Une table de vérité retourne l'expression algébrique (V/F) ");
            input = scanner.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = scanner.nextLine().trim().toUpperCase();
            }
            reponse = input.equals("V");
            System.out.println("Votre réponse : " + (reponse ? "Oui" : "Non"));
            if (reponse) score++;

            System.out.print("Git permet de stocker à distance son travail (V/F) ");
            input = scanner.nextLine().trim().toUpperCase();
            while (!input.equals("V") && !input.equals("F")) {
                System.out.print("Veuillez répondre par 'V' ou 'F' : ");
                input = scanner.nextLine().trim().toUpperCase();
            }
            reponse = input.equals("V");
            if (reponse) score++;
            System.out.println("Votre réponse : " + (reponse ? "Oui" : "Non"));

            System.out.println("Vous avez obtenu un score de " + score + " sur 5.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie. Veuillez recommencer.");
        } finally {
            scanner.close();
            System.out.println("Merci d'avoir répondu à ce questionnaire !");
             }
    }
}