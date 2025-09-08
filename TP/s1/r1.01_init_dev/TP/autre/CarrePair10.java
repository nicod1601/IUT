import iut.algo.Clavier;


public class CarrePair10
{
    public static void main(String[] args) 
    {
       /*------------*/
       /* Variables  */
       /*------------*/
       int cpt ;
       int nb  ;
       
       /*--------------*/
       /* Instruction  */
       /*--------------*/

       for(cpt = 1; cpt <= 10; cpt++)
       {
		System.out.print("Entrer un nombre :  ");
		nb = Clavier.lire_int();
		
		if(nb % 2 == 0)
		{
			System.out.println(nb*nb);
		}
       }
    }
}
