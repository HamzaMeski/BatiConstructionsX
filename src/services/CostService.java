package services;

import models.dao.cost.PgCostDAO;
import UI.projectCost.CostDisplay;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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

    public void DISPLAY_PROJECT_COST(int projectId) {
        Map<String, Object> projectInfo = model.DISPLAY_PROJECT_INFO(projectId);
        CostDisplay.displayProjectCost(projectInfo);
    }
}
