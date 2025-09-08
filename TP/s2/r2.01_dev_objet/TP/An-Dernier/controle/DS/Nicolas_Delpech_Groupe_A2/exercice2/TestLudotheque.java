/**
*@author Delpech Nicolas
*/

public class TestLudotheque
{
	public static void main(String[] a)
	{
		Ludotheque ludo = new Ludotheque();

		/* --------------------- */
		/*      Exercice 2       */
		/* --------------------- */
		TestLudotheque.titre ( 2 );
		
			for (int cpt=0; cpt<ludo.getNbEditeur(); cpt++ )
			{
				System.out.println ( "|" + ludo.getEditeur(cpt).getNumEditeur() + "|" +
									ludo.getEditeur(cpt).getNomEditeur() + "|" );
			}

		/* --------------------- */
		/*      Exercice 4       */
		/* --------------------- */
/*		TestLudotheque.titre ( 4 );

		for (int cpt=0; cpt<ludo.getNbJeu(); cpt++ )
			System.out.println ( "|" + ludo.getJeu(cpt).getNomJeu()       + "|" +
			                           ludo.getJeu(cpt).getNbJoueurMini() + "|" +
			                           ludo.getJeu(cpt).getNbJoueurMaxi() + "|"     );
*/

		/* --------------------- */
		/*      Exercice 5       */
		/* --------------------- */
/*		TestLudotheque.titre ( 5 );

		for (int cpt=0; cpt<ludo.getNbJeu(); cpt++ )
			System.out.println ( "|" + ludo.getJeu(cpt).getNomJeu ()                    + "|" +
			                           ludo.getJeu(cpt).getEditeur().getNomEditeur()    + "|" +
			                           ludo.getJeu(cpt).getNbJoueurMini()               + "|" +
			                           ludo.getJeu(cpt).getNbJoueurMaxi()               + "|"    );
*/

	}

	private static void titre (int numero)
	{
		System.out.println ( "\n--------------------"    );
		System.out.println (   "    Exercice  " + numero );
		System.out.println (   "--------------------\n"  );
	}


}
