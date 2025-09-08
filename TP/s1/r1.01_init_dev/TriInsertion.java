/**
 * Projet 2 Exercice 2
 * Classe TriInsertion
 * Implémente le tri par insertion et une méthode pour trouver les indices du maximum et du minimum.
 * 
 * @author Equipe 18
 * @version 17/11/2023
 */
public class TriInsertion
{

    /**
     * Trie un tableau d'entiers en utilisant le tri par insertion.
     * 
     * @param tab le tableau d'entiers à trier
     */
    public static void triInsertion(int[] tab)
    {
        // Taille du tableau
        int taille = tab.length;

        // Parcourir chaque élément à partir du deuxième
        for (int i = 1; i < taille; i++)
        {
            int temp = tab[i]; // Élement en cours de traitement
            int j = i - 1;

            // Déplacement des éléments plus grands que temp
            while (j >= 0 && tab[j] > temp)
            {
                tab[j + 1] = tab[j];
                j--;
            }

            // Insérer l'élément à sa position correcte
            tab[j + 1] = temp;
        }
    }

    /**
     * Affiche les indices des éléments maximum et minimum d'un tableau.
     * 
     * @param tab le tableau d'entiers à analyser
     */
    public static void indicesMinMax(int[] tab) {
        if (tab.length == 0) {
            System.out.println("Le tableau est vide.");
            return;
        }

        // Initialisation des indices
        int indiceMax = 0;
        int indiceMin = 0;

        // Parcourir le tableau pour trouver les indices du min et du max
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > tab[indiceMax]) {
                indiceMax = i;
            }
            if (tab[i] < tab[indiceMin]) {
                indiceMin = i;
            }
        }

        // Afficher les résultats
        System.out.println("Indice du maximum : " + indiceMax);
        System.out.println("Indice du minimum : " + indiceMin);
    }

    /**
     * Exemple d'utilisation de la classe TriInsertion.
     */
    public static void main(String[] args) {
        int[] tableau = { 29, 14, 10, 37, 13 };

        // Affichage du tableau initial
        System.out.println("Tableau initial :");
        afficherTableau(tableau);

        // Tri du tableau
        triInsertion(tableau);

        // Affichage du tableau trié
        System.out.println("\nTableau trié :");
        afficherTableau(tableau);

        // Indices du maximum et du minimum
        indicesMinMax(tableau);
    }

    /**
     * Affiche les éléments d'un tableau d'entiers.
     * 
     * @param tab le tableau à afficher
     */
    public static void afficherTableau(int[] tab) {
        for (int val : tab) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
