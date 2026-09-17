import java.util.Scanner;

public class WhileInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("exit")) {
            System.out.println("Enter text (type 'exit' to quit): ");
            input = scanner.nextLine();
        }
        scanner.close();
    }
}