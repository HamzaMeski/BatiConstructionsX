package models.dao.cost;

import models.DbConfig;
import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class PgCostDAO extends CostDAO {
    private final DbConfig dbConfig = DbConfig.getInstance();

    @Override
    public void APPLY_VTA_AND_PROFIT(Double vta, Double profit, int projectId) {
        String sql = "UPDATE projects SET profitMargin = ?, vatRate = ? WHERE id = ?";
        try (Connection connection = dbConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, profit);
            statement.setDouble(2, vta);
            statement.setInt(3, projectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Object> DISPLAY_PROJECT_INFO(int projectId) {
        Map<String, Object> result = new HashMap<>();

        String projectSql = "SELECT * FROM projects WHERE id = ?";
        String materialsSql = "SELECT * FROM materials WHERE project_id = ?";
        String laborsSql = "SELECT * FROM labors WHERE project_id = ?";
        String userSql = "SELECT name FROM clients WHERE id = (SELECT client_id FROM projects WHERE id = ?)";

        try (Connection connection = dbConfig.getConnection();
             PreparedStatement projectStmt = connection.prepareStatement(projectSql);
             PreparedStatement materialsStmt = connection.prepareStatement(materialsSql);
             PreparedStatement laborsStmt = connection.prepareStatement(laborsSql);
             PreparedStatement userStmt = connection.prepareStatement(userSql)) {

            // Step 1: Get project info
            projectStmt.setInt(1, projectId);
            ResultSet projectRs = projectStmt.executeQuery();
            if (projectRs.next()) {
                Map<String, Object> projectInfo = new HashMap<>();
                projectInfo.put("id", projectRs.getInt("id"));
                projectInfo.put("name", projectRs.getString("name"));
                projectInfo.put("profitMargin", projectRs.getDouble("profitMargin"));
                projectInfo.put("totalCost", projectRs.getDouble("totalCost"));
                projectInfo.put("status", projectRs.getString("status"));
                projectInfo.put("surface", projectRs.getDouble("surface"));
                projectInfo.put("vatRate", projectRs.getDouble("vatRate"));
                result.put("projectInfo", projectInfo);
            }

            // Step 2: Get materials info
            materialsStmt.setInt(1, projectId);
            ResultSet materialsRs = materialsStmt.executeQuery();
            List<Map<String, Object>> materials = new ArrayList<>();
            while (materialsRs.next()) {
                Map<String, Object> material = new HashMap<>();
                material.put("id", materialsRs.getInt("id"));
                material.put("name", materialsRs.getString("name"));
                material.put("quantity", materialsRs.getDouble("quantity"));
                material.put("unitCost", materialsRs.getDouble("unitCost"));
                material.put("transportCost", materialsRs.getDouble("transportCost"));
                material.put("qualityCoefficient", materialsRs.getDouble("qualityCoefficient"));
                materials.add(material);
            }
            result.put("materials", materials);

            // Step 3: Get labors info
            laborsStmt.setInt(1, projectId);
            ResultSet laborsRs = laborsStmt.executeQuery();
            List<Map<String, Object>> labors = new ArrayList<>();
            while (laborsRs.next()) {
                Map<String, Object> labor = new HashMap<>();
                labor.put("id", laborsRs.getInt("id"));
                labor.put("name", laborsRs.getString("name"));
                labor.put("quantity", laborsRs.getDouble("quantity"));
                labor.put("hourlyRate", laborsRs.getDouble("hourlyRate"));
                labor.put("workHours", laborsRs.getDouble("workHours"));
                labor.put("workerProductivity", laborsRs.getDouble("workerProductivity"));
                labors.add(labor);
            }
            result.put("labors", labors);

            // Step 4: Get client name based on userId
            userStmt.setInt(1, projectId);
            ResultSet userRs = userStmt.executeQuery();
            if (userRs.next()) {
                String userName = userRs.getString("name");
                if (userName == null) {
                    result.put("userName", null);
                } else {
                    result.put("userName", userName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}