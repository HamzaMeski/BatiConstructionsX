package UI.projectCost;

public class CostDisplay {

    public static void displayProjectCost(int projectId) {
        System.out.println("--- Résultat du Calcul ---");
        System.out.println("Nom du projet : ");
        System.out.println("Client : ");
        System.out.println("Adresse du chantier : ");
        System.out.println("Surface : ");

        System.out.println("--- Détail des Coûts ---");
        System.out.println("1. Matériaux : ");
        // here we will display infos of all materials
        System.out.println("**Coût total des matériaux avant TVA :");
        System.out.println("**Coût total des matériaux avec TVA (20%) :");

        System.out.println("2. Main-d'œuvres : ");
        // here we will display infos of all labors
        System.out.println("**Coût total de la main-d'œuvre avant TVA :");
        System.out.println("**Coût total de la main-d'œuvre avec TVA (20%) : ");

        System.out.println("3. Coût total avant marge :");
        System.out.println("4. Marge bénéficiaire (15%) ");
    }
}
