import lib.ScanInput;
import UI.client.ClientMenu;
import UI.project.ProjectMenu;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║               MENU PRINCIPAL           ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║    [1] ❖ Créer un nouveau projet       ║");
            System.out.println("║    [2] ❖ Afficher projets existants    ║");
            System.out.println("║    [3] ❖ Calculer le coût d'un projet  ║");
            System.out.println("║    [4] ❖ Ajouter des clients           ║");
            System.out.println("║    [5] ❖ Quitter le programme          ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("        >> CHOISIR UNE OPTION: ");

            option = ScanInput.scanner.nextInt();
            ScanInput.scanner.nextLine();

            switch(option) {
                case 1:
                    ProjectMenu.displayMenu();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    ClientMenu.addClient();
                    break;
                case 5:
                    System.out.println("    ...");
                    break;
                default:
                    System.out.println("    Aucune option pour le chiffre saisie.");
                    break;
            }
        }while(option != 5);
    }
 }
