package models.dao.labor;

import models.DbConfig;
import models.entities.Labor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgLaborDAO extends LaborDAO {
    private final DbConfig dbConfig = DbConfig.getInstance();

    @Override
    public void addLabor(Labor labor) {
        String sql = "INSERT INTO labors (project_id, name, quantity, componentType, hourlyRate, workHours, workerProductivity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, labor.getProjectId());
            statement.setString(2, labor.getName());
            statement.setDouble(3, labor.getQuantity());
            statement.setString(4, labor.getComponentType());
            statement.setDouble(5, labor.getHourlyRate());
            statement.setDouble(6, labor.getWorkHours());
            statement.setDouble(7, labor.getWorkerProductivity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Labor> displayProjectLabors(int projectId) {
        List<Labor> labors = new ArrayList<>();
        String sql = "SELECT * FROM labors WHERE project_id = ?";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double quantity = resultSet.getDouble("quantity");
                String componentType = resultSet.getString("componentType");
                double hourlyRate = resultSet.getDouble("hourlyRate");
                double workHours = resultSet.getDouble("workHours");
                double workerProductivity = resultSet.getDouble("workerProductivity");
                labors.add(new Labor(id, projectId, name, quantity, componentType, hourlyRate, workHours, workerProductivity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labors;
    }
}
