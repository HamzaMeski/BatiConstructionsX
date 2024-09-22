package lib;

import java.util.ArrayList;
import java.util.List;

public class YesNo {
    public static String displayAlert(String message) {
        String choise;
        boolean validInput;
        do {
            System.out.print(message + " (y/n) : ");
             choise = ScanInput.scanner.nextLine().toLowerCase();
             String userChoise = choise;
            List<String> inputs = new ArrayList<>(List.of("y", "n"));
            validInput = inputs.stream().anyMatch(c -> c.equals(userChoise));
            if(!validInput) System.out.println("Entrée invalide");
        }while(!validInput);
        return choise;
    }
}
