import java.util.Scanner;  

public class MessageAvecScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   
        System.out.print("Bienvenue chez O'Kito ");
        
      
        String message = scanner.nextLine();
        
       
        System.out.println( message);
        
       
        scanner.close();
    }
}