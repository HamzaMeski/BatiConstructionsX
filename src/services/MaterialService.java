package services;

import orgg.dao.material.PgMaterialDAO;
import UI.material.MaterialDisplay;
import orgg.entities.Material;

public class MaterialService {
    private static PgMaterialDAO model;
    private static MaterialDisplay display;

    public MaterialService(PgMaterialDAO model, MaterialDisplay display) {
        this.model = model;
        this.display = display;
    }

    public static void addMaterial(Material material) {
        model.addMaterial(material);
    }

    public static void displayProjectMaterials(int projectId) {
        model.displayProjectMaterials(projectId);
    }
}