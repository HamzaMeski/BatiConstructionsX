package services;

import orgg.dao.project.PgProjectDAO;
import UI.project.ProjectDisplay;
import orgg.entities.Project;

import java.util.List;
import java.util.ArrayList;

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

    public List<Project> displayProjectsByClientId(int clientId) {
        return model.displayProjectsByClientId(clientId);
    }

    public void displayAllProjects() {
        List<Project> projects = model.listAllProjects();
        ProjectDisplay.displayProjects(projects);
    }
}
