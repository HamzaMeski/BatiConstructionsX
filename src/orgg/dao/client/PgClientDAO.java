package orgg.dao.client;

import orgg.DbConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import orgg.entities.Client;

public class PgClientDAO extends ClientDAO {
    private final DbConfig dbConfig = DbConfig.getInstance();

    @Override
    public int addClient(Client client) {
        String sql = "INSERT INTO clients (name, address, phone, isProfessional) VALUES (?, ?, ?, ?) RETURNING id";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getName());
            statement.setString(2, client.getAddress());
            statement.setString(3, client.getPhone());
            statement.setBoolean(4, client.isProfessional());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients WHERE name ILIKE ?";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getBoolean("isProfessional")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public List<Client> listAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Connection connection = dbConfig.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getBoolean("isProfessional")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
