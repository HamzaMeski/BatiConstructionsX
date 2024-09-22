package services;

import models.entities.Labor;
import models.dao.labor.PgLaborDAO;
import UI.labor.LaborDisplay;

public class LaborService {
    private static PgLaborDAO model;
    private static LaborDisplay display;

    public LaborService(PgLaborDAO model, LaborDisplay display) {
        this.model   = model;
        this.display = display;
    }

    public static void addLabor(Labor labor) {model.addLabor(labor);}

    public static void displayProjectLabors(int projectId) {model.displayProjectLabors(projectId);}
}
