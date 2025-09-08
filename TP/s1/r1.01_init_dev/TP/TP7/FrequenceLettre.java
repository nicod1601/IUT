import iut.algo.Clavier;

public class FrequenceLettre
{
    public static void main(String[] args)
    {
    	/*-------------- */
        /* Constante     */
        /*-------------- */
        final int TAILLE = 20;
        
        /*-------------- */
        /* Variables     */
        /*-------------- */
        char [] tab ;
        int compteur;
        double proba;
        int cpt;
        int taille;
        
        char cara;
        
        /*-------------- */
        /* Instructions  */
        /*-------------- */
        tab = new char[TAILLE];
        taille = 1;
        cara = 'A';
        cpt = 1;
        
        while(tab[cpt - 1] != '.' && cpt < tab.length)
        {
			tab[cpt] = Clavier.lire_char();
			
			taille++;
			cpt++;
        }
        
        cpt =0;
        while(cara < 'Z')
        {
			while(cara == tab[cpt])
			{
				compteur++;
			}
			cara = (char) cara + 1;
        }
        
        
        
        
        
        
        
        
        cpt = 1;
        while(cpt < tab.length)
        {
			System.out.print(tab[cpt]);
			cpt++;
        }
        
		
    }
}

