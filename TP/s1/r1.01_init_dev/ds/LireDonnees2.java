import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LireDonnees2 {

    public static void main(String[] args) {
        // Déclaration des données
        String filePath = "donnees.txt";

        // Instructions
        try {
            // Créer une instance de File et Scanner pour lire le fichier
            File file = new File(filePath);
            Scanner scanner = new Scanner(new File("./txt/donnees.txt"), "UTF-8");

            // Lire et traiter chaque ligne du fichier
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                traiterEnregistrement(line);
            }

            // Fermer le scanner après usage
            scanner.close();
        } catch (FileNotFoundException e) {
        }
    }
public static void traiterEnregistrement(String ligne) {
        // Diviser la ligne par tabulation
        String[] donnees = ligne.split("\t");

        // Extraction des données
        String nom = donnees[0];
        String prenom = donnees[1];
        double[] moyennes = new double[6];
        for (int i = 0; i < 6; i++) {
            moyennes[i] = Double.parseDouble(donnees[i + 2]);
        }

        // Calcul de la moyenne générale
        double moyenneGenerale = 0;
        int ueValidees = 0;
        boolean toutesUEValides = true;

        for (double moyenne : moyennes) {
            moyenneGenerale += moyenne;
            if (moyenne < 8) {
                toutesUEValides = false;
            }
            if (moyenne > 10) {
                ueValidees++;
            }
        }
        moyenneGenerale /= 6;

        // Validation du semestre
        boolean semestreValide = moyenneGenerale >= 10 && toutesUEValides && ueValidees >= 4;

        // Affichage des résultats
        System.out.printf("%s %s : Moyenne = %.2f - %s\n", nom, prenom, moyenneGenerale, semestreValide ? "Semestre validé" : "Semestre non validé");
    }
}