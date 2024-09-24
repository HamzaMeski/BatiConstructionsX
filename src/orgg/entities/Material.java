package orgg.entities;

public class Material extends Component {
    private double unitCost;
    private double transportCost;
    private double qualityCoefficient;

    public Material(int id, int projectId, String name, double quantity, String componentType, double unitCost, double transportCost, double qualityCoefficient) {
        super(id, projectId, name, quantity, componentType);
        this.unitCost = unitCost;
        this.transportCost = transportCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }
}
