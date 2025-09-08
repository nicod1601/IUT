public class LesTrie 
{
    public static void main(String[] args) 
    {
        int[] tab = new int[]{2, 1, 5, 3, 4};

        LesTrie.triInsertion(tab);
        System.out.println("Après tri : " + affichement(tab));
        
    }
    public static String affichement(int[] tab)
    {
        String affichage = "";
        for (int cpt = 0; cpt < tab.length; cpt++)
        {
            affichage += tab[cpt] + " ";
        }
        return affichage;
    }
    public static int[] triInsertion(int[] tab)
    {
        int tmp;

        for(int cpt = 1; cpt < tab.length; cpt++)
        {
            for(int cpt2 = 0; cpt2 < cpt; cpt2++)
            {
                if(tab[cpt] < tab[cpt2])
                {
                    tmp = tab[cpt];
                    tab[cpt] = tab[cpt2];
                    tab[cpt2] = tmp;
                }
            }
        }
        return tab;
    }
}
