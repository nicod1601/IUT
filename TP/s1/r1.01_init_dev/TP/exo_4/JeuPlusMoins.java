import iut.algo.Clavier;

public class JeuPlusMoins
{
    public static void main(String[] args) 
    {
		/*------------*/
		/* Variables  */
		/*------------*/
		int val        ;
		int valTrouver ;
		int nbEssaie   ;

       
		/*--------------*/
		/* Instruction  */
		/*--------------*/
		
		System.out.print("Entrer une valeur : ");
		val = Clavier.lire_int();
		
		valTrouver = (int) (Math.random () * 100 );
		nbEssaie = 1;
		
		while( val != valTrouver)
		{
			nbEssaie += 1;
		
			if(val < valTrouver){System.out.println("Plus Grand");}
			if(val > valTrouver){System.out.println("Plus Petit");}
			
			System.out.print("Entrer une valeur : ");
			val = Clavier.lire_int();
		}
		if(val == valTrouver){System.out.println("Vous avez Gagner " + "Essaie : " + nbEssaie);}
		
		
    }
}
