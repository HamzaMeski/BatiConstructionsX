package UI.client;

import UI.client.ClientMenu;
import orgg.dao.client.PgClientDAO;
import services.ClientService;
import orgg.entities.Client;
import java.util.List;
import java.util.ArrayList;

public class ClientDisplay {
    private static PgClientDAO model = new PgClientDAO();
    private static ClientDisplay display = new ClientDisplay();
    private static ClientService clientService = new ClientService(model, display);

    public static List<Client> displayAllClients() {
        List<Client> allClients = clientService.listAllClients();
        if(allClients.size() == 0) {
            System.out.println("    il n'y a pas encore de client");
        }else {
            for(Client client : allClients) {
                System.out.println("    # nom de client: "+ client.getName()+" (ID: "+ client.getId()+")");
            }
        }

        System.out.println("");

        return allClients;
    }
}