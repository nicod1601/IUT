import iut.algo.Clavier;

public class Kheops
{
    public static void main(String[] args) 
    {
		/*------------*/
		/* Variables  */
		/*------------*/
		int etage    ;
		int nbEtage  ;
		int cptVide  ;
		int cptEtoile;

       
		/*--------------*/
		/* Instruction  */
		/*--------------*/
		
		System.out.print("Entrer un nombre d'étage : ");
		nbEtage = Clavier.lire_int();
		
		etage = 1;
		
		while(etage <= nbEtage)
		{
			cptVide = 0;
			while(cptVide < nbEtage - etage)
			{
				System.out.print(" ");

				cptVide++;
			}
			
			cptEtoile = 0;
			while(cptEtoile < 2*etage -1)
			{
				System.out.print("*");

				cptEtoile++;
			}
			System.out.println();
			etage++;
		}
		
		
		
    }
}
