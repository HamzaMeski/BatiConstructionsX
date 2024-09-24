package orgg.dao.project;

import orgg.entities.Project;
import java.util.List;

public abstract class ProjectDAO {
    public abstract int addProject(Project project);
    public abstract List<Project> listAllProjects();
}
