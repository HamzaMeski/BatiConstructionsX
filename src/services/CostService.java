package services;

import orgg.dao.cost.PgCostDAO;
import UI.projectCost.CostDisplay;

import java.util.Map;

public class CostService {
    private PgCostDAO model;
    private CostDisplay display;

    public CostService(PgCostDAO model, CostDisplay display) {
        this.model   = model;
        this.display = display;
    }

    public void APPLY_VTA_AND_PROFIT(Double vta, Double profit, int projectId) {
        model.APPLY_VTA_AND_PROFIT(vta, profit, projectId);
    }

    public double DISPLAY_PROJECT_COST(int projectId) {
        Map<String, Object> projectInfo = model.DISPLAY_PROJECT_INFO(projectId);
        return  CostDisplay.displayProjectCost(projectInfo);
    }
}
