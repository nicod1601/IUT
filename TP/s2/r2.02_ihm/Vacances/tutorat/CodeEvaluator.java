import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CodeEvaluator {
    public static void main(String[] args) {
        String file1 = "./partie1CO/PanelConnexion.java"; // Premier fichier à comparer
        String file2 = "./partie2CO/PanelConnexion.java"; // Deuxième fichier à comparer
        
        try {
            List<String> code1 = preprocessCode(Files.readAllLines(Paths.get(file1)));
            List<String> code2 = preprocessCode(Files.readAllLines(Paths.get(file2)));

            double similarityScore = calculateStructuralSimilarity(code1, code2);
            int errorsFile1 = countCompilationErrors(file1);
            int errorsFile2 = countCompilationErrors(file2);
            
            boolean file1Compiles = (errorsFile1 == 0);
            boolean file2Compiles = (errorsFile2 == 0);
            
            int executionScore = (file1Compiles && file2Compiles) ? 10 : 0;
            int finalScore = (int) ((similarityScore * 15) / 100) + executionScore;

            System.out.println("Score de similarité : " + similarityScore + "%");
            System.out.println("Erreurs de compilation dans " + file1 + " : " + errorsFile1);
            System.out.println("Erreurs de compilation dans " + file2 + " : " + errorsFile2);
            System.out.println("Exécution réussie : " + (file1Compiles && file2Compiles ? "Oui" : "Non"));
            System.out.println("Note finale : " + finalScore + "/20");
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des fichiers : " + e.getMessage());
        }
    }

    public static List<String> preprocessCode(List<String> code) {
        List<String> processedCode = new ArrayList<>();
        for (String line : code) {
            String normalized = line.replaceAll("\\s+", "").toLowerCase(); // Supprime les espaces et met en minuscule
            if (!normalized.isEmpty() && !normalized.startsWith("//")) { // Ignore les lignes vides et commentaires
                processedCode.add(normalized);
            }
        }
        return processedCode;
    }

    public static double calculateStructuralSimilarity(List<String> code1, List<String> code2) {
        Set<String> uniqueLines1 = new HashSet<>(code1);
        Set<String> uniqueLines2 = new HashSet<>(code2);
        
        Set<String> commonLines = new HashSet<>(uniqueLines1);
        commonLines.retainAll(uniqueLines2);

        int totalLines = Math.max(uniqueLines1.size(), uniqueLines2.size());
        return (double) commonLines.size() / totalLines * 100;
    }

    public static int countCompilationErrors(String filePath) {
        try {
            Process compileProcess = new ProcessBuilder("javac", filePath).start();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
            
            int errorCount = 0;
            while (errorReader.readLine() != null) {
                errorCount++;
            }
            compileProcess.waitFor();
            return errorCount;
        } catch (Exception e) {
            return -1; // Retourne -1 en cas d'erreur inattendue
        }
    }
}
