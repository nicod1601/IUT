import iut.algo.Clavier;

public class JusquA50 
{
    public static void main(String[] args)
    {
    
    	/*-------------- */
        /* Constante     */
        /*-------------- */
        final int TAILLEMAX = 50;
        
        /*-------------- */
        /* Variables     */
        /*-------------- */
        int [] tab;
        int taille;
        int somme, sommePaire;

        /*-------------- */
        /* Instructions  */
        /*-------------- */
		System.out.print("Entrer une taille : ");
		taille = Clavier.lire_int();
		
		tab = new int[TAILLEMAX];

		// rentrer les valeurs du tableau
        for(int cpt = 0; cpt < taille; cpt++)
        {
        	System.out.print("val : ");
            tab[cpt] = Clavier.lire_int();
        }
        
        // affiche le tableau et la somme des éléments
        somme = 0;
        for(int cpt = 0; cpt < taille; cpt++)
        {
			System.out.print(tab[cpt] + " ");
			somme = somme + tab[cpt];
        }
        System.out.println();
        System.out.println("somme : " + somme);
        
        // affiche la somme des nombre paire
        System.out.print("somme paire : ");
        for(int cpt = 0; cpt < taille; cpt++)
        {
			if(tab[cpt] % 2 == 0)
			{
				System.out.print(" " + tab[cpt]);
				sommePaire++;
			}
        }
        System.out.println();
        
        // affiche la somme des nombre impaire
        System.out.print("somme impaire : " + somme - sommePaire );
        
        System.out.println();
    }
}

