import iut.algo.ControleGraphique;
import iut.algo.Couleur;

/**
 * @author Delpech Nicolas
 * TestCarte
 * @date 17/01/2025
 */
 
public class TestCarte
{
	public static void main(String[] a)
	{
		Carte c;
		int   taille = 10;

		// exercice 1
		// ----------


		c = new Carte ("carte1.data");

		System.out.println ( c );



		// exercice 2
		// ----------

		c.niveler();

		System.out.println ( c );



		// exercice 4
		// ----------

		/* Code à Compléter pour l'exercice 4 */


		// exercice 3
		// ----------

		/*
		TestCarte.affichageGraphique ( c, taille );

		// affichageGraphique prend en 1er paramètre  la carte à afficher
		//                          en 2ème paramètre la taille d'une case

		*/

	}

}
