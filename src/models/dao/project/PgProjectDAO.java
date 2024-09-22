package models.dao.project;

import models.entities.Project;
import models.enums.ProjectStatus;
import models.DbConfig;

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
            statement.setInt(1, project.getClientId());
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
                int clientId = resultSet.getInt("client_id");
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
}
