import iut.algo.Clavier;

public class MinMax
{
    public static void main(String[] args)
    {
    	/*-------------- */
        /* Constante     */
        /*-------------- */
        final int TAILLE = 40;
    
        /*-------------- */
        /* Variables     */
        /*-------------- */
        int [] tab;
        int min, max;
        int cpt;
        

        /*-------------- */
        /* Instructions  */
        /*-------------- */
		tab = new int[TAILLE];
		cpt = 0;
		min = 40;
		max = 20;

		// rentrer les valeurs du tableau
        while(cpt < tab.length)
        {
            tab[cpt] = (int) ( Math.random()* 21) + 20;
            
            if( tab[cpt] > max ){ max = tab[cpt];}
            if( tab[cpt] < min ){ min = tab[cpt];}
            
            cpt++;
        }
        
        cpt = 0;
        while(cpt < tab.length)
        {
            System.out.print(tab[cpt] + " ");
            
            cpt++;
        }
        System.out.println();
        System.out.print("Min : " + min + '\n' +
                         "Max : " + max 
                        );
        
        System.out.println();
    }
}

