package models.dao.cost;

import java.util.Map;

public abstract class CostDAO {
    public abstract void APPLY_VTA_AND_PROFIT(Double vta, Double profit, int projectId);
    public abstract Map<String, Object> DISPLAY_PROJECT_INFO(int projectId);
}
