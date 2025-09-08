import iut.algo.Clavier;

public class IHMCUI
{
	private ControleurCUI ctrl;


	public IHMCUI ( ControleurCUI ctrl )
	{
		this.ctrl = ctrl;
	}


	public char lireAction()
	{
		System.out.println ();
		System.out.print   ( "Action (R)etourner 1 tube \n" +
		                     "       (E)changer  2 tubes\n" +
		                     "       (D)eplacer  1 bille\n" +
		                     "       (N)iveau Suivant   \n" +
		                     "       (Q)uitter\n" );

		System.out.println ();
		System.out.print   ( "      Votre choix : " );

		return Clavier.lire_char();
	}


	public int lireTube ( String message )
	{
		System.out.print ( String.format ( "%17s", message ) + " : " );
		return Clavier.lire_int();
	}


	public void afficherPlateau()
	{
		System.out.println ( "--------------------------");
		System.out.println ( "   Objectif nÂ° " + this.ctrl.getNiveau() );
		this.afficherTubes ( 'O' );
		System.out.println ( "--------------------------");
		System.out.println ();
		System.out.println ( "--------------------------");
		System.out.println ( "       Chimiste");
		this.afficherTubes ( 'C' );
		System.out.println ( "--------------------------");
	}

	private void afficherTubes(char type)
	{
		char[][] tab = new char[3][];

		tab[0] = String.format("%-4s", ctrl.getTube(type, 0)).toCharArray();
		tab[1] = String.format("%-4s", ctrl.getTube(type, 1)).toCharArray();
		tab[2] = String.format("%-4s", ctrl.getTube(type, 2)).toCharArray();

		// Trouver la hauteur maximale des tubes
		int maxHauteur = Math.max(tab[0].length, Math.max(tab[1].length, tab[2].length));

		for (int i = maxHauteur - 1; i >= 0; i--) // Parcours des lignes de haut en bas
		{
			for (int j = 0; j < 3; j++) // Parcours des trois tubes
			{
				if (i < tab[j].length)
					System.out.print("  " + tab[j][i] + "  "); // Affiche la bille
				else
					System.out.print("     "); // Espace vide
			}
			System.out.println();
		}

		System.out.println(" *****  *****  *****");
		System.out.println("   1      2      3  ");
	}

	public void finDePartie()
	{
		System.out.println ( "\n\n"              );
		System.out.println ( "-------------"     );
		System.out.println ( "FIN DE PARTIE"     );
		System.out.println ( "-------------\n\n" );
	}
}