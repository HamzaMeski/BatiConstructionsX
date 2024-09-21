
import lib.ScanInput;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║               MAIN MENU                ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║    [1] |- Create a new project         ║");
            System.out.println("║    [2] |- Display existing projects    ║");
            System.out.println("║    [3] |- Calculate cost of a project  ║");
            System.out.println("║    [4] |- Exit program                 ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("        >> SET OPTION: ");

            option = ScanInput.scanner.nextInt();
            ScanInput.scanner.nextLine();

            switch(option) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                default:
                    System.out.println("There is no option with that number");
                    break;
            }
        }while(option != 4);
    }
 }
