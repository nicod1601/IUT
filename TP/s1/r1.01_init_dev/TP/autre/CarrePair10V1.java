import iut.algo.Clavier;


public class CarrePair10V1
{
    public static void main(String[] args) 
    {
       /*------------*/
       /* Variables  */
       /*------------*/
       int nb  ;
       
       /*--------------*/
       /* Instruction  */
       /*--------------*/
	System.out.print("Entrer un nombre :  ");
	nb = Clavier.lire_int();
	
       while(nb >= 0)
       {
		
		if(nb % 2 == 0)
		{
			System.out.println(nb*nb +" est Pair");
		}
		else
		{
			System.out.println(nb*nb +" est Impaire");
		}
		System.out.print("Entrer un nombre :  ");
		nb = Clavier.lire_int();
       }
    }
}
