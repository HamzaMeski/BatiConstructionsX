package models.dao.material;

import models.entities.Material;
import models.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgMaterialDAO extends MaterialDAO {
    private final DbConfig dbConfig = DbConfig.getInstance();

    @Override
    public void addMaterial(Material material) {
        String sql = "INSERT INTO materials (project_id, name, quantity, componentType, unitCost, transportCost, qualityCoefficient) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, material.getProjectId());
            statement.setString(2, material.getName());
            statement.setDouble(3, material.getQuantity());
            statement.setString(4, material.getComponentType());
            statement.setDouble(5, material.getUnitCost());
            statement.setDouble(6, material.getTransportCost());
            statement.setDouble(7, material.getQualityCoefficient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Material> displayProjectMaterials(int projectId) {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT * FROM materials WHERE project_id = ?";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double quantity = resultSet.getDouble("quantity");
                String componentType = resultSet.getString("componentType");
                double unitCost = resultSet.getDouble("unitCost");
                double transportCost = resultSet.getDouble("transportCost");
                double qualityCoefficient = resultSet.getDouble("qualityCoefficient");
                materials.add(new Material(id, projectId, name, quantity, componentType, unitCost, transportCost, qualityCoefficient));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }
}
