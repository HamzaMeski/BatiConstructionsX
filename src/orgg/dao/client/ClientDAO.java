package orgg.dao.client;

import orgg.entities.Client;
import java.util.List;

public abstract class ClientDAO {
    public abstract int addClient(Client client);
    public abstract List<Client> searchClientsByName(String name);
    public abstract List<Client> listAllClients();
}