package services;

import orgg.dao.client.PgClientDAO;
import UI.client.ClientDisplay;
import orgg.entities.Client;

import java.util.List;

public class ClientService {
    private PgClientDAO model;
    private ClientDisplay display;

    public ClientService(PgClientDAO model, ClientDisplay display) {
        this.model = model;
        this.display = display;
    }

    public int addClient(Client client) {
        return model.addClient(client);
    }

    public List<Client> searchClients(String name) {
         return model.searchClientsByName(name);
    }

    public void displayClients(String name) {
        List<Client> client = searchClients(name);
    }

    public void displayClients() {}
}