package models.entities;

public class Component {
    private int id;
    private int projectId;
    private String name;
    private double quantity;
    private String componentType;

    public Component(int id, int projectId, String name, double quantity, String componentType) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.quantity = quantity;
        this.componentType = componentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }
}
