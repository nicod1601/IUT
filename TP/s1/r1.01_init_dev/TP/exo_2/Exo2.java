import iut.algo.Clavier;

public class Exo2
{
    public static void main(String[] args) 
    {
		/*------------*/
		/* Variables  */
		/*------------*/
		int val;
       
		/*--------------*/
		/* Instruction  */
		/*--------------*/
       
		System.out.print("Entrer une valeur : ");
		val = Clavier.lire_int();       
	
		while(val < 20 || val > 100)
		{
			System.out.println(val);
			
			System.out.print("Entrer une valeur : ");
			val = Clavier.lire_int(); 
			
    	}
    }
}
