package orgg.dao.project;

import orgg.entities.Project;
import orgg.enums.ProjectStatus;
import orgg.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgProjectDAO extends ProjectDAO {
    private final DbConfig dbConfig = DbConfig.getInstance();

    public int addProject(Project project) {
        String sql = "INSERT INTO projects (client_id, name, profitMargin, totalCost, status, surface, vatRate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int projectId = -1;
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Use setObject to handle Integer type and null values
            statement.setObject(1, project.getClientId(), Types.INTEGER);
            statement.setString(2, project.getName());
            statement.setObject(3, project.getProfitMargin());
            statement.setObject(4, project.getTotalCost());
            statement.setString(5, project.getStatus().name());
            statement.setObject(6, project.getSurface());
            statement.setObject(7, project.getVatRate());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                projectId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectId;
    }

    public List<Project> listAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects";
        try (Connection connection = dbConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                // Use getObject to handle nullable client_id values
                Integer clientId = (Integer) resultSet.getObject("client_id");
                String name = resultSet.getString("name");
                Double profitMargin = resultSet.getDouble("profitMargin");
                Double totalCost = resultSet.getDouble("totalCost");
                ProjectStatus status = ProjectStatus.valueOf(resultSet.getString("status"));
                Double surface = resultSet.getDouble("surface");
                Double vatRate = resultSet.getDouble("vatRate");

                projects.add(new Project(id, clientId, name, profitMargin, totalCost, status, surface, vatRate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public List<Project> displayProjectsByClientId(int clientId) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects WHERE client_id = ?";

        try (Connection connection = dbConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, clientId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");

                    Integer clientIdFromDb = (Integer) resultSet.getObject("client_id");
                    String name = resultSet.getString("name");
                    Double profitMargin = resultSet.getDouble("profitMargin");
                    Double totalCost = resultSet.getDouble("totalCost");
                    ProjectStatus status = ProjectStatus.valueOf(resultSet.getString("status"));
                    Double surface = resultSet.getDouble("surface");
                    Double vatRate = resultSet.getDouble("vatRate");

                    projects.add(new Project(id, clientIdFromDb, name, profitMargin, totalCost, status, surface, vatRate));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }

}
