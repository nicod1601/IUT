import iut.algo.Clavier;

public class Parfait
{
    public static void main(String[] args) 
    {
		/*------------*/
		/* Variables  */
		/*------------*/
		int nb    ;
		int somme ;
		int cpt   ;
       
		/*--------------*/
		/* Instruction  */
		/*--------------*/
		
		System.out.print("Entrer une nombre : ");
		nb = Clavier.lire_int();
		
		somme = 0;
		cpt   = 1;
		
		while( cpt < nb)
		{
			if(nb % cpt == 0){ somme += cpt;}
			
			cpt++;
		}
		
		if(somme == nb)
		{
			System.out.println(nb + " est Parfait");
		}
		else
		{
			System.out.println(nb + " n'est pas Parfait");
		}
		
    }
}
