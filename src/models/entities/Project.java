package models.entities;

import models.enums.ProjectStatus;

public class Project {
    private int id;
    private int clientId;
    private String name;
    private Double profitMargin;
    private Double totalCost;
    private ProjectStatus status;
    private Double surface;

    public Project(int id, int clientId, String name, Double profitMargin, Double totalCost, ProjectStatus status, Double surface) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.profitMargin = profitMargin;
        this.totalCost = totalCost;
        this.status = status;
        this.surface = surface;
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

    public Double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(Double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }
}
