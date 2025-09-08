import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LireDonnees5 {

    public static void main(String[] args) {
        // Déclaration des données
        String inputFilePath = "niveau.data";

        try {
            // Créer une instance de File et Scanner pour lire le fichier
            File inputFile = new File(inputFilePath);
            Scanner scanner = new Scanner(new File("./txt/niveau.data"), "UTF-8");

            // Déterminer le nombre de lignes et de colonnes
            List<String> lignes = new ArrayList<>();
            int colonnes = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lignes.add(line);
                colonnes = line.length(); // Toutes les lignes ont le même nombre de colonnes
            }

            int lignesTotal = lignes.size();

            // Instancier un tableau régulier à deux dimensions
            char[][] tableau = new char[lignesTotal][colonnes];

            // Remplir le tableau avec le contenu du fichier
            for (int i = 0; i < lignesTotal; i++) {
                String ligne = lignes.get(i);
                for (int j = 0; j < colonnes; j++) {
                    tableau[i][j] = ligne.charAt(j);
                }
            }

            // Afficher le tableau
            System.out.println("Contenu du tableau :");
            for (char[] ligne : tableau) {
                for (char c : ligne) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }

            // Fermer le scanner après usage
            scanner.close();
} catch (FileNotFoundException e) {
            //System.out.println("Erreur : Le fichier d'entrée "" + inputFilePath + "" est introuvable.");
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur lors du traitement du fichier.");
            e.printStackTrace();
        }
    }
}