import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exchange rates (example rates, please update with real values from the provided link)
        final double EUR_TO_USD = 1.11;
        final double EUR_TO_GBP = 0.8572;
        final double USD_TO_EUR = 0.8785;
        final double USD_TO_GBP = 0.7535;
        final double GBP_TO_EUR = 1.1666;
        final double GBP_TO_USD = 1.3275;

        System.out.println("Quel est votre monnaie ? (EUR, USD, GBP)");
        String inputCurrency = scanner.nextLine().toUpperCase();

        if (!inputCurrency.equals("EUR") && !inputCurrency.equals("USD") && !inputCurrency.equals("GBP")) {
            System.out.println("Erreur : Devise non reconnue !");
            scanner.close();
            return;
        }

        System.out.println("Quel est votre montant ?");
        if (!scanner.hasNextDouble()) {
            System.out.println("Erreur : Montant invalide !");
            scanner.close();
            return;
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Erreur : Le montant doit être positif !");
            scanner.close();
            return;
        }
        scanner.nextLine(); // Consume the newline character

        System.out.println("Vous voulez la convertir en quelle devise ? (EUR, USD, GBP)");
        String outputCurrency = scanner.nextLine().toUpperCase();

        if (!outputCurrency.equals("EUR") && !outputCurrency.equals("USD") && !outputCurrency.equals("GBP")) {
            System.out.println("Erreur : Devise non reconnue !");
            scanner.close();
            return;
        }

        if (inputCurrency.equals(outputCurrency)) {
            System.out.println("Erreur : Vous ne pouvez pas convertir la même devise !");
            scanner.close();
            return;
        }

        double convertedAmount = 0.0;

        // Conversion logic
        if (inputCurrency.equals("EUR") && outputCurrency.equals("USD")) {
            convertedAmount = amount * EUR_TO_USD;
        } else if (inputCurrency.equals("EUR") && outputCurrency.equals("GBP")) {
            convertedAmount = amount * EUR_TO_GBP;
        } else if (inputCurrency.equals("USD") && outputCurrency.equals("EUR")) {
            convertedAmount = amount * USD_TO_EUR;
        } else if (inputCurrency.equals("USD") && outputCurrency.equals("GBP")) {
            convertedAmount = amount * USD_TO_GBP;
        } else if (inputCurrency.equals("GBP") && outputCurrency.equals("EUR")) {
            convertedAmount = amount * GBP_TO_EUR;
        } else if (inputCurrency.equals("GBP") && outputCurrency.equals("USD")) {
            convertedAmount = amount * GBP_TO_USD;
        }

        System.out.printf("Résultat : %.2f %s%n", convertedAmount, outputCurrency);

        // Close the scanner
        scanner.close();
    }
}