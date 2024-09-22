package services;

import models.dao.cost.PgCostDAO;
import UI.projectCost.CostDisplay;

public class CostService {
    private static PgCostDAO model;
    private static CostDisplay display;

    public CostService(PgCostDAO model, CostDisplay display) {
        this.model   = model;
        this.display = display;
    }

    public static void APPLY_VTA_AND_PROFIT(Double vta, Double profit, int projectId) {
        model.APPLY_VTA_AND_PROFIT(vta, profit, projectId);
    }

    public static void DISPLAY_PROJECT_COST(int projectId) {

    }
}