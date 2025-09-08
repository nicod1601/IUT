import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LireParoles {

    public static void main(String[] args) {
        // Déclaration des données
        String filePath = "paroles.txt";

        // Instructions
        try {
            // Créer une instance de File et Scanner pour lire le fichier
            File file = new File(filePath);
            Scanner scanner = new Scanner(new File("./txt/paroles.txt"), "UTF-8");

            // Lire et afficher chaque ligne du fichier
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Fermer le scanner après usage
            scanner.close();
        } catch (FileNotFoundException e) {
        }
    }
}