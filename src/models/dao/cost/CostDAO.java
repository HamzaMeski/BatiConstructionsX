package models.dao.cost;

public abstract class CostDAO {
    public abstract void APPLY_VTA_AND_PROFIT(Double vta, Double profit, int projectId);
    public abstract void DISPLAY_PROJECT_COST(int projectId);
}
