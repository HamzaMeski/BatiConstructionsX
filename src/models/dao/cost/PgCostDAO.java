package models.dao.cost;

import models.DbConfig;
import java.sql.*;

import java.sql.SQLException;

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
    public void DISPLAY_PROJECT_COST(int projectId) {

    }
}
