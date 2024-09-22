package UI.material;

import lib.ScanInput;
import lib.BC;
import services.MaterialService;
import models.dao.material.PgMaterialDAO;
import models.entities.Material;

public class MaterialMenu {
    private static PgMaterialDAO model = new PgMaterialDAO();
    private static MaterialDisplay display = new MaterialDisplay();
    private static MaterialService materialService = new MaterialService(model, display);

    public static void addMaterial(int projectId) {
        System.out.println("\n--- Ajout des matériaux ---");

        System.out.println("    Entrez le nom du matériau : ");
        String name = ScanInput.scanner.nextLine();

        System.out.println("    Entrez la quantité de ce matériau (en m²) : ");
        double quantity = ScanInput.scanner.nextDouble();
        BC.clean();

        System.out.println("    Entrez le coût unitaire de ce matériau (€/m²) : ");
        double unitCost = ScanInput.scanner.nextDouble();
        BC.clean();

        System.out.println("    Entrez le coût de transport de ce matériau (€) : ");
        double transportCost =  ScanInput.scanner.nextDouble();
        BC.clean();

        System.out.println("    Entrez le coefficient de qualité du matériau (1.0 = standard, > 1.0 = haute qualité) : ");
        double qualityCoefficient =  ScanInput.scanner.nextDouble();
        BC.clean();

        Material material = new Material(0, projectId, name, quantity, null, unitCost, transportCost, qualityCoefficient);

        materialService.addMaterial(material);
    }
}