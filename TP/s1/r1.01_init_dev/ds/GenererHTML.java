import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GenererHTML {

    public static void main(String[] args) {
        // Déclaration des fichiers d'entrée et de sortie
        String inputFilePath = "donnees.txt";
        String outputFilePath = "sortie.html";

        try {
            // Créer une instance de File et Scanner pour lire le fichier
            File inputFile = new File(inputFilePath);
            Scanner scanner = new Scanner(new File("./txt/exemple.html"), "UTF-8");

            // Créer le fichier HTML
            PrintWriter writer = new PrintWriter(new File("./txt/exemple1.html"), "UTF-8");

            // Écrire l'en-tête HTML
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"fr\">");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<title>Résultats</title>");
            writer.println("<style>");
            writer.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; }\n" +
                    "th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }\n" +
                    "th { background-color: #f2f2f2; }\n" +
                    "tr:nth-child(even) { background-color: #f9f9f9; }\n" +
                    "tr:hover { background-color: #f1f1f1; }");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1 style=\"text-align:center;\">Résultats des Étudiants</h1>");
            writer.println("<table>");
            writer.println("<tr>");
            writer.println("<th>Nom</th>");
            writer.println("<th>Prénom</th>");
            writer.println("<th>UE1</th>");
            writer.println("<th>UE2</th>");
            writer.println("<th>UE3</th>");
            writer.println("<th>UE4</th>");
            writer.println("<th>UE5</th>");
            writer.println("<th>UE6</th>");
            writer.println("<th>Moyenne</th>");
            writer.println("<th>Validation</th>");
            writer.println("</tr>");

            // Lire et traiter le fichier ligne par ligne
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Vérifier si la ligne est vide
                if (line.trim().isEmpty()) {
                    continue; // Ignorer les lignes vides
                }

                String[] enregistrement = line.split("\t");

                // Vérifier si la ligne a au moins 8 colonnes
                if (enregistrement.length < 8) {
                    System.out.println("Ligne ignorée car mal formatée : " + line);
                    continue;
                }

                String nom = enregistrement[0];
                String prenom = enregistrement[1];
                double[] ues = new double[6];
                boolean erreurNote = false;

                for (int i = 0; i < 6; i++) {
                    try {
                        ues[i] = Double.parseDouble(enregistrement[i + 2].replace(",", "."));
                    } catch (NumberFormatException e) {
                        System.out.println("Erreur lors de la conversion d'une note pour l'étudiant : " + nom + " " + prenom);
                        ues[i] = 0; // Affecter une valeur par défaut en cas d'erreur
                        erreurNote = true;
                    }
                }

                double moyenne = 0;
                int ueValidees = 0;
                boolean toutesSuperieuresA8 = true;

                for (double note : ues) {
                    moyenne += note;
                    if (note >= 10) {
                        ueValidees++;
                    }
                    if (note < 8) {
                        toutesSuperieuresA8 = false;
                    }
                }

                moyenne /= 6;
                boolean valide = moyenne >= 10 && toutesSuperieuresA8 && ueValidees >= 4;

                // Écrire la ligne dans le fichier HTML
                writer.println("<tr>");
                writer.println("<td>" + nom + "</td>");
                writer.println("<td>" + prenom + "</td>");
                for (double note : ues) {
                    writer.println("<td>" + String.format("%.2f", note).replace(".", ",") + "</td>");
                }
                writer.println("<td>" + String.format("%.2f", moyenne).replace(".", ",") + "</td>");
                writer.println("<td>" + (valide ? "Oui" : "Non") + "</td>");
                writer.println("</tr>");
            }

            // Terminer le fichier HTML
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");

            writer.close();
            scanner.close();

            System.out.println("Fichier HTML généré avec succès : " + outputFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Le fichier d'entrée \"" + inputFilePath + "\" est introuvable.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur lors du traitement du fichier.");
            e.printStackTrace();
        }
    }
}
