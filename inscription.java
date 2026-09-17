public class inscription {
    public static void main(String[] args) {
        poserQuestion();
    }

    public static void poserQuestion() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Votre prénom ?: ");
        String reponse = scanner.nextLine().trim().toLowerCase();
        while (reponse.isEmpty()) {
            if (!reponse.matches("^[a-zA-Z]+$")) {
                System.out.print("Veuillez entrer un prénom valide (lettres uniquement) : ");
            }
            reponse = scanner.nextLine().trim().toLowerCase();
        }
        System.out.print("Votre nom ?: ");
        String nom = scanner.nextLine().trim().toLowerCase();
        while (nom.isEmpty()) {
            boolean nomValide = nom.matches("^[\\p{L}]+([\\p{L}\\s\\-]*[\\p{L}])?$");
            if (!nomValide) {
                System.out.print("Veuillez entrer un nom valide (lettres uniquement) : ");
            }
            nom = scanner.nextLine().trim().toLowerCase();
        }
        System.out.print("Votre adresse e-mail ?: ");
        String email = scanner.nextLine().trim().toLowerCase();
        while (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.print("Veuillez entrer une adresse e-mail valide : ");
            email = scanner.nextLine().trim().toLowerCase();
        }
        System.out.print("Votre mot de passe ?: ");
        String motDePasse = scanner.nextLine().trim();
        while (motDePasse.length() < 8 || !motDePasse.matches(".*[A-Z].*") || !motDePasse.matches(".*[a-z].*") || !motDePasse.matches(".*\\d.*")) {
            System.out.print("Le mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule et un chiffre. Veuillez réessayer : ");
            motDePasse = scanner.nextLine().trim();
        }
        System.out.println("Merci, " + reponse + " " + nom + "! Votre inscription est réussie. votre inscription a bien été effectuée, vous recevrez un mail de confirmation à l'adresse : " + email);
        scanner.close();
    }

}
