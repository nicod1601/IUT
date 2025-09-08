public class Exo1 
{
    public static void main(String[] args)
    {
        /*------------ */
        /* Constantes  */
        /*------------ */
        final int TAILLE_ENTIER = 12;
        final int TAILLE_CARA   = 10;

        /*-------------- */
        /* Variables     */
        /*-------------- */
        int [] tabEntier;
        char[] tabCaractere;

        /*-------------- */
        /* Instructions  */
        /*-------------- */
        tabEntier    = new int [TAILLE_ENTIER];
        tabCaractere = new char[TAILLE_CARA ];

		// instruction
        for(int cpt = 0; cpt < tabEntier.length; cpt++)
        {
            tabEntier[cpt] = (int) (Math.random()*10);
        }
        
        for(int cpt = 0; cpt < tabCaractere.length; cpt++)
        {
            tabCaractere[cpt] = (char) ('A' + Math.random()*26);
        }
        
        // affichage
        for(int cpt = 0; cpt < tabEntier.length; cpt++)
        {
            System.out.print(tabEntier[cpt]);
        }
        
        System.out.println();
        
        for(int cpt = 0; cpt < tabCaractere.length; cpt++)
        {
            System.out.print(tabCaractere[cpt]);
        }
        
        System.out.println();
    }
}

