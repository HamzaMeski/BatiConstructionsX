package models.dao.labor;

import models.entities.Labor;

import java.util.List;

public abstract class LaborDAO {

    public abstract void addLabor(Labor labor);

    public abstract List<Labor> displayProjectLabors(int projectId);
}
