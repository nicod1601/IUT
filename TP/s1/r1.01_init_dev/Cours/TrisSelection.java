public class TrisSelection
{
    public static void main(String[] args)
    {
        /*-----------------*/
        /*    Variables    */
        /*-----------------*/
        int taille = 5;
        int[] tab;

        /*-----------------*/
        /*    Instructions */
        /*-----------------*/
        tab = new int[]{2, 1, 5, 3, 4};

        System.out.println("Avant tri : " + affichement(tab, taille));
        triSelection(tab, taille);
        System.out.println("Après tri : " + affichement(tab, taille));
    }

    public static String affichement(int[] tab, int taille)
    {
        String affichage = "";
        for (int cpt = 0; cpt < taille; cpt++)
        {
            affichage += tab[cpt] + " ";
        }
        return affichage;
    }

    public static void triSelection(int[] tab, int taille)
    {
        for (int cpt1 = 0; cpt1 < taille - 1; cpt1++)
        {
            // Trouver l'indice du plus petit élément dans la portion non triée
            int minIndex = i;
            for (int cpt2 = cpt1 + 1; j < taille; cpt2++)
            {
                if (tab[cpt2] < tab[minIndex])
                {
                    minIndex = cpt2;
                }
            }
            // Échanger le plus petit élément avec le premier élément non trié
            int tmp = tab[cpt1];
            tab[cpt1] = tab[minIndex];
            tab[minIndex] = tmp;
        }
    }
}
