package UI.project;

import UI.client.ClientDisplay;
import lib.ScanInput;
import lib.BC;
import lib.YesNo;
import UI.client.ClientMenu;
import orgg.dao.client.PgClientDAO;
import orgg.dao.cost.PgCostDAO;
import orgg.dao.project.PgProjectDAO;
import orgg.dao.project.ProjectDAO;
import services.ProjectService;
import UI.project.ProjectDisplay;
import orgg.entities.Project;
import orgg.enums.ProjectStatus;
import UI.material.MaterialMenu;
import UI.labor.LaborMenu;
import UI.projectCost.CostMenu;
import UI.projectCost.CostDisplay;
import services.CostService;
import services.ClientService;
import orgg.entities.Client;
import orgg.dao.quote.PgQuoteDAO;
import UI.quote.QuoteMenu;

import java.util.List;
import java.util.ArrayList;

public class ProjectMenu {
    static private PgProjectDAO model = new PgProjectDAO();
    static private ProjectDisplay display = new ProjectDisplay();
    static ProjectService projectService = new ProjectService(model, display);

    static private PgClientDAO clientModel = new PgClientDAO();
    static private ClientDisplay clientDisplay = new ClientDisplay();
    static ClientService clientService = new ClientService(clientModel, clientDisplay);

    static private PgCostDAO costModel = new PgCostDAO();
    static private CostDisplay costDisplay = new CostDisplay();
    static CostService costService = new CostService(costModel, costDisplay);

    static List<Client> allClients;

    public static void displayMenu() {
        int option;
        do {
            System.out.println("--- Recherche de client ---");
            System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
            System.out.println("    1. Chercher un client existant");
            System.out.println("    2. Ajouter un nouveau client");
            System.out.println("    3. retour");
            System.out.print("\nChoisissez une option : ");
            option = ScanInput.scanner.nextInt();
            BC.clean();

            int clientId;
            switch(option) {
                case 1:
                     clientId = ClientMenu.searchClients();
                    if(clientId != 0) {
                        if(continueProcess()) addProject(clientId);
                    }
                    break;
                case 2:
                     clientId = ClientMenu.addClient();
                     if(continueProcess()) addProject(clientId);
                    break;
                case 3:
                    System.out.println("    ...");
                default:
                    System.out.println("    Aucune option pour le chiffre saisie.");
                    break;
            }
        }while(option != 3);
    }

    public static boolean continueProcess() {
        String choise = YesNo.displayAlert("Souhaitez-vous continuer avec ce client ?");
        if(choise.equals("y")) return true;
        else return false;
    }

    public static void addProject(Integer clientId) {
        System.out.println("");
        if(clientId == null) System.out.println("--- Infos à propos de Projet ---");
        else System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("    Entrez le nom du projet : ");
        String projectName = ScanInput.scanner.nextLine();
        System.out.print("\n    Entrez la surface de de l'espace (en m²) : ");
        Double surface = ScanInput.scanner.nextDouble();
        BC.clean();

        Project project = new Project(0, clientId, projectName, null, null, ProjectStatus.PENDING, surface, null);
        int projectId = projectService.addProject(project);

        /*
        Adding Materials to the project
         */
        MaterialMenu.addMaterial(projectId);

        /*
        Adding Labors to the project
         */
        LaborMenu.addLabor(projectId);

        /*
        Applaying VTA and Profit to the project
         */
        CostMenu.APPLY_VTA_AND_PROFIT(projectId);

        /*
        Project cost displaying
         */
        double totalCost = costService.DISPLAY_PROJECT_COST(projectId);

        /*
        Quote management
         */
        QuoteMenu.addQuote(totalCost, projectId);
    }

    /* Displaying all projects */
    public static void displayProjects() {
        int option;
        do {
            System.out.println("---Affichage des projets existants---");
            System.out.println("    1. Afficher tous les projets:");
            System.out.println("    2. Afficher les projets d'un client:");
            System.out.println("    3. Retour");
            System.out.print("\n    Choisissez une option : ");
            option = ScanInput.scanner.nextInt();
            BC.clean();

            switch(option) {
                case 1:
                    displayAllProjects();
                    break;

                case 2:
                    displayProjectsByClient();
                    break;

                case 3:
                    System.out.println("    ...");
                    break;

                default:
                    System.out.println("    Aucune option pour le chiffre saisie.");
                    break;
            }
        }while(option != 3);
    }

    public static void displayProjectsByClient() {
        int option;
        do {
            System.out.println("    1.Afficher des clients ");
            System.out.println("    2.Afficher des projets d'un client par son ID ");
            System.out.print("\n    Saisir votre option: ");
            option = ScanInput.scanner.nextInt();
            BC.clean();

            switch(option) {
                case 1:
                    displayAllClients();
                    break;

                case 2:
                    getProjectsById();
                    break;

                default:
                    System.out.println("    Entrée invalide!");
                    break;
            }
        }while(!(option==1) && !(option==2));
    }

    public static void displayAllClients() {
        allClients = ClientDisplay.displayAllClients();
    }

    public static void getProjectsById() {
        int clientId;
        boolean idExist;
        do {
            System.out.println("    Entrer l'ID de client pour afficher ses projets ");
            int id = ScanInput.scanner.nextInt();
            clientId = id;
            BC.clean();
            idExist = allClients.stream().anyMatch(c -> c.getId() == id);
        }while(!idExist);

        List<Project> projects = projectService.displayProjectsByClientId(clientId);
        ProjectDisplay.displayProjects(projects);
    }

    public static void displayAllProjects() {
        projectService.displayAllProjects();
    }
}
