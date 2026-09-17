import java.util.Scanner;
public class quizz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int score = 0;
        System.out.println("Bienvenue dans le quiz !");
        System.out.println("Veuillez entrer votre nom :");
        String name = scanner.nextLine();
        System.out.println("Bonjour " + name + ", prêt à commencer le quiz ?");
        System.out.println("Voici la première question :");
        System.out.println("Quel est la capitale de la France ?");
        String reponse1 = scanner.nextLine();
        if (reponse1.equalsIgnoreCase("Paris")) {
            System.out.println("Bonne réponse !");
            score++;
        } else {
            System.out.println("Mauvaise réponse. La bonne réponse est Paris.");
        }
        
       
        System.out.println("Votre score est : " + score);
        System.out.println("Voici la deuxième question :");
        System.out.println("Quel est le plus grand océan du monde ?");
        String reponse2 = scanner.nextLine();
        if (reponse2.equalsIgnoreCase("Pacifique")) {
            System.out.println("Bonne réponse !");
            score++;
        } else {
            System.out.println("Mauvaise réponse. La bonne réponse est Pacifique.");
        }
        
        System.out.println("Votre score est : " + score);
        System.out.println("Voici la troisième question :");
        System.out.println("Quel est le plus grand pays du monde ?");   
        String reponse3 = scanner.nextLine();
        if (reponse3.equalsIgnoreCase("Russie")) {
            System.out.println("Bonne réponse !");
            score++;
        } else {
            System.out.println("Mauvaise réponse. La bonne réponse est Russie.");
        }
       
        System.out.println("Votre score final est : " + score + " sur 3.");
        scanner.close();
    }
}
