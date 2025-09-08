import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LireDonnees4 {

    public static void main(String[] args) {
        // Déclaration des données
        String inputFilePath = "donnees.txt";
        String outputFilePath = "sortie.txt";

        try {
            // Créer une instance de File et Scanner pour lire le fichier
            File inputFile = new File(inputFilePath);
            Scanner scanner = new Scanner(new File("./txt/donnees.txt"), "UTF-8");

            // Créer une instance de PrintWriter pour écrire dans le fichier de sortie
            PrintWriter writer = new PrintWriter(outputFilePath, "UTF-8");

            // Ajouter un en-tête au fichier de sortie
            writer.println("Nom\tPrénom\tMoyenne générale\tValidation du semestre");

            // Lire et traiter chaque ligne du fichier
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String resultat = traiterEnregistrement(line);
                writer.println(resultat);
            }

            // Fermer le scanner et le writer après usage
            scanner.close();
            writer.close();

            System.out.println("Traitement terminé. Les résultats ont été écrits dans " + outputFilePath);
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.out.println("Erreur lors de l'écriture dans le fichier de sortie.");
            e.printStackTrace();
        }
    }

    public static String traiterEnregistrement(String ligne) {
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

        // Retourner les résultats formatés pour l'écriture dans le fichier
        return String.format("%s\t%s\t%.2f\t%s", nom, prenom, moyenneGenerale, semestreValide ? "Semestre validé" : "Semestre non validé");
    }
}
