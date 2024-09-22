package services;

import models.dao.project.PgProjectDAO;
import UI.project.ProjectDisplay;
import models.entities.Project;

public class ProjectService {
    private PgProjectDAO model;
    private ProjectDisplay display;

    public ProjectService(PgProjectDAO model, ProjectDisplay display) {
        this.model = model;
        this.display = display;
    }

    public int addProject(Project project) {
        return model.addProject(project);
    }

    public void displayAllProjects() {

    }
}