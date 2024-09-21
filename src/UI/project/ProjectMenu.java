package UI.project;

import lib.ScanInput;

public class ProjectMenu {

    public static void displayMenu() {
        int option;
        do {
            System.out.println("--- Recherche de client ---");
            System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
            System.out.println("    1. Chercher un client existant");
            System.out.println("    2. Ajouter un nouveau client");
            System.out.println("    3. retour");
            System.out.print("\nChoisissez une option : ");
            option = ScanInput.scanner.nextInt();
            ScanInput.scanner.nextLine();

            switch(option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("    ...");
                default:
                    System.out.println("    Aucune option pour le chiffre saisie.");
                    break;
            }
        }while(option != 3);
    }
}