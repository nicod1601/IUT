/** 
 * Projet 2 Exercice 2
 * TriUtil.java
 * @author Equipe 18
 * @version 17/11/2023
 */
public class TriUtil {

    public static void main(String[] arg) {
        // Constantes
        final int TAILLE_TAB = 100;
        final int VAL_MIN = 0, VAL_MAX = 2000;

        // Données
        int[] tableau;
        int[] tableauCopie;
        long debutTps, finTps;

        // Instructions
        tableau = genererTableau(TAILLE_TAB, VAL_MIN, VAL_MAX);
        tableauCopie = copierTableau(tableau);

        // Tri Selection
        debutTps = System.nanoTime();
        triSelection(tableau);
        finTps = System.nanoTime();
        System.out.println(toString(tableau) + 
            "\nTemps de tri : " + (finTps - debutTps) + 
            " nanosecondes" + 
            "\nTableau trié : " + estTrie(tableau) + "\n");

        tableau = copierTableau(tableauCopie);

        // Tri Bulle
        debutTps = System.nanoTime();
        triBulle(tableau);
        finTps = System.nanoTime();
        System.out.println(toString(tableau) + 
            "\nTemps de tri : " + (finTps - debutTps) + 
            " nanosecondes" + 
            "\nTableau trié : " + estTrie(tableau) + "\n");

        tableau = copierTableau(tableauCopie);

        // Tri Insertion
        debutTps = System.nanoTime();
        triInsertion(tableau);
        finTps = System.nanoTime();
        System.out.println(toString(tableau) + 
            "\nTemps de tri : " + (finTps - debutTps) + 
            " nanosecondes" + 
            "\nTableau trié : " + estTrie(tableau) + "\n");
    }

    public static void triSelection(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            int maxVal = 0, indVal = 0;
            for (int j = 0; j < tab.length - i; j++) {
                if (tab[j] > maxVal) {
                    maxVal = tab[j];
                    indVal = j;
                }
            }
            permuter(tab, tab.length - 1 - i, indVal);
        }
    }

    public static void triBulle(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab.length - 1 - i; j++) {
                if (tab[j] > tab[j + 1]) {
                    permuter(tab, j, j + 1);
                }
            }
        }
    }

    public static void triInsertion(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int tmp = tab[i];
            int j = i - 1;
            while (j >= 0 && tab[j] > tmp) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = tmp;
        }
    }

    public static boolean estTrie(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] genererTableau(int nbCases, int valMin, int valMax) {
        int[] tab = new int[nbCases];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) (Math.random() * valMax) + valMin;
        }
        return tab;
    }

    public static int[] copierTableau(int[] tab) {
        int[] newTab = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            newTab[i] = tab[i];
        }
        return newTab;
    }

    public static String toString(int[] tab) {
        String res = "";
        if (tab.length > 8) {
            res += "+--------+--------+--------+--------+ ... +--------+--------+--------+--------+\n";
            for (int i = 0; i < 4; i++) {
                res += "|" + String.format("%8s", tab[i]);
            }
            res += "|           ";
            for (int i = 4; i > 0; i--) {
                res += "|" + String.format("%8s", tab[tab.length - i]);
            }
            res += "|\n+--------+--------+--------+--------+ ... +--------+--------+--------+--------+\n";
        } else {
            res += "+";
            for (int i = 0; i < tab.length; i++) {
                res += "---+";
            }
            res += "\n";
            for (int i = 0; i < tab.length; i++) {
                res += "|" + String.format("%3s", tab[i]);
            }
            res += "|\n+";
            for (int i = 0; i < tab.length; i++) {
                res += "---+";
            }
            res += "\n";
        }
        return res;
    }

    private static void permuter(int[] tab, int ind1, int ind2) {
        if (tab[ind1] != tab[ind2]) {
            int temp = tab[ind1];
            tab[ind1] = tab[ind2];
            tab[ind2] = temp;
        }
    }
}
