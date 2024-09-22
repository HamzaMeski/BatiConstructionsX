package models.dao.material;

import models.entities.Material;

import java.util.List;

public abstract class MaterialDAO {
    public abstract void addMaterial(Material material);
    public abstract List<Material> displayProjectMaterials(int projectId);
}
