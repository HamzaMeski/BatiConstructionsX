package models.entities;

import models.enums.ProjectStatus;

public class Project {
    private int id;
    private int clientId;
    private String name;
    private double profitMargin;
    private double totalCost;
    private ProjectStatus status;

    public Project(int id, int clientId, String name, double profitMargin, double totalCost, ProjectStatus status) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.profitMargin = profitMargin;
        this.totalCost = totalCost;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
