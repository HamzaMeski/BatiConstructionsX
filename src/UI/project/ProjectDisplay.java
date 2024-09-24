package UI.project;

import orgg.entities.Project;
import java.util.List;
import java.util.ArrayList;

public class ProjectDisplay {
    public static void displayProjects(List<Project> projects) {
        if(projects.size() == 0) {
            System.out.println("    il n'y a pas encore de projet");
        }else {
            for(Project project : projects ) {
                System.out.println("    # Le nom de projet (ID: "+project.getId()+"): "+ project.getName());
            }
        }
        System.out.println("");
    }
}
