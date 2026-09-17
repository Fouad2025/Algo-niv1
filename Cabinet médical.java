import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class CabinetMedical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<RendezVous> rendezVousList = new ArrayList<>();
        while (true) {
            System.out.println("1. Ajouter un rendez-vous");
            System.out.println("2. Annuler un rendez-vous");
            System.out.println("3. Décaler un rendez-vous");
            System.out.println("4. Afficher la liste des rendez-vous");
            System.out.println("5. Rechercher un rendez-vous par code de référence");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    ajouterRendezVous(sc, rendezVousList);
                    break;
                case 2:
                    annulerRendezVous(sc, rendezVousList);
                    break;
                case 3:
                    decalerRendezVous(sc, rendezVousList);
                    break;
                case 4:
                    afficherRendezVous(rendezVousList);
                    break;
                case 5:
                    rechercherRendezVous(sc, rendezVousList);
                    break;
                case 6:
                    System.out.println("Au revoir!");
                    sc.close();
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
    private static void ajouterRendezVous(Scanner sc, List<RendezVous> rendezVousList) {
        System.out.print("Entrez le code de référence: ");
        String code = sc.next();
        System.out.print("Entrez la date (dd/MM/yyyy): ");
        String dateStr = sc.next();
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        RendezVous rdv = new RendezVous(code, date);
        rendezVousList.add(rdv);
        System.out.println("Rendez-vous ajouté.");
    }
    private static void annulerRendezVous(Scanner sc, List<RendezVous> rendezVousList) {
        System.out.print("Entrez le code de référence du rendez-vous à annuler: ");
        String code = sc.next();
        RendezVous rdv = trouverRendezVous(code, rendezVousList);
        if (rdv != null) {
            rendezVousList.remove(rdv);
            System.out.println("Rendez-vous annulé.");
        } else {
            System.out.println("Rendez-vous non trouvé.");
        }
    }
    private static void decalerRendezVous(Scanner sc, List<RendezVous> rendezVousList) {
        System.out.print("Entrez le code de référence du rendez-vous à décaler: ");
        String code = sc.next();
        RendezVous rdv = trouverRendezVous(code, rendezVousList);
        if (rdv != null) {
            System.out.print("Entrez la nouvelle date (dd/MM/yyyy): ");
            String newDateStr = sc.next();
            LocalDate newDate = LocalDate.parse(newDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            rdv.setDate(newDate);
            System.out.println("Rendez-vous décalé.");
        } else {
            System.out.println("Rendez-vous non trouvé.");
        }
    }
    private static void afficherRendezVous(List<RendezVous> rendezVousList) {
        if (rendezVousList.isEmpty()) {
            System.out.println("Aucun rendez-vous à afficher.");
        } else {
            System.out.println("Liste des rendez-vous:");
            for (RendezVous rdv : rendezVousList) {
                System.out.println(rdv);
            }
        }
    }
    private static void rechercherRendezVous(Scanner sc, List<RendezVous> rendezVousList) {
        System.out.print("Entrez le code de référence à rechercher: ");
        String code = sc.next();
        RendezVous rdv = trouverRendezVous(code, rendezVousList);
        if (rdv != null) {
            System.out.println("Rendez-vous trouvé: " + rdv);
        } else {
            System.out.println("Rendez-vous non trouvé.");
        }
    }
    private static RendezVous trouverRendezVous(String code, List<RendezVous> rendezVousList) {
        for (RendezVous rdv : rendezVousList) {
            if (rdv.getCode().equalsIgnoreCase(code)) {
                return rdv;
            }
        }
        return null;
    }
class RendezVous {
    private String code;
    private LocalDate date;

    public RendezVous(String code, LocalDate date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "RendezVous{" +
                "code='" + code + '\'' +
                ", date=" + date.format(formatter) +
                '}';
    }
}


