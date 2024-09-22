package models.dao.project;

import models.entities.Project;
import java.util.List;

public abstract class ProjectDAO {
    public abstract int addProject(Project project);
    public abstract List<Project> listAllProjects();
}
