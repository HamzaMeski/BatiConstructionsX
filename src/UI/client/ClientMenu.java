package UI.client;

import lib.ScanInput;
import UI.client.ClientDisplay;
import lib.ScanInput;
import models.entities.Client;
import models.dao.client.PgClientDAO;
import services.ClientService;
import models.entities.Client;

import java.util.Locale;

public class ClientMenu {
    private static PgClientDAO model = new PgClientDAO();
    private static ClientDisplay display = new ClientDisplay();
    private static ClientService clientService = new ClientService(model, display);

    public static void addClient() {
        System.out.println("---Ajout d'un client---");
        System.out.print("    # nom: ");
        String name =  ScanInput.scanner.nextLine();
        System.out.print("    # addresse: ");
        String address =  ScanInput.scanner.nextLine();
        System.out.print("    # téléphone: ");
        String phone =  ScanInput.scanner.nextLine();

        String isProfessionalOption;
        do {
            System.out.print("    # est professionnel? (y/n): ");
            isProfessionalOption = ScanInput.scanner.nextLine();
        }while(!isProfessionalOption.equals("y") && !isProfessionalOption.equals("n"));
        boolean isProfessional;
        if(isProfessionalOption.equals("y")) isProfessional = true;
        else isProfessional = false;

        Client client = new Client(0, name, address, phone, isProfessional);
        clientService.addClient(client);
    }

    public static void searchClients() {
        System.out.println("---recherche d'un client---");
        System.out.print("    # le nom du client: ");
        String name = ScanInput.scanner.nextLine();
        clientService.searchClients(name);
    }

    public static void listAllClients() {}
}