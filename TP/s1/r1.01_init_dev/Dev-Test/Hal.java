import iut.algo.Clavier;


public class Hal
{
	public static void main(String[] a)
	{

		// A partir de l'exercie 1
		char[]   tabRepartition;


		// A partir de l'exercice 2
		String[] libCulture;

		// A partir de l'exercice 3
		char[][] territoire;




		// Exercice 1
		System.out.println ( "==========" );
		System.out.println ( "Exercice 1" );
		System.out.println ( "==========" );

		tabRepartition = Hal.genererTabRepartition();
		System.out.println ( Hal.toString (tabRepartition) );


		// Exercice 2
		System.out.println ( "==========" );
		System.out.println ( "EXERCICE 2" );
		System.out.println ( "==========" );

		libCulture = new String[] { "Patate Douce", "Canne", "Mangue", "Riz" };
		tabRepartition = Hal.genererTabRepartition(libCulture);
		System.out.println ( Hal.toString (tabRepartition) );



		// Exercice 3
		System.out.println ( "==========" );
		System.out.println ( "EXERCICE 3" );
		System.out.println ( "==========" );

		territoire = Hal.genererTerritoire( tabRepartition );
		System.out.println ( Hal.toString (territoire) );


		// Etape 4

		System.out.println ( "==========" );
		System.out.println ( "EXERCICE 4" );
		System.out.println ( "==========" );

		Hal.afficherPourcentage( territoire, libCulture );


		// Etape 5
		System.out.println ( "==========" );
		System.out.println ( "EXERCICE 5" );
		System.out.println ( "==========" );

		Hal.enleverPointIsole( territoire );
		System.out.println ( Hal.toString (territoire) );


	}


	/*-------------------------------------*/
	/* MÃ©thodes Ã  dÃ©finir pour l'Exercie 1 */
	/*-------------------------------------*/
	private static char[] genererTabRepartition()
	{
		char[] tab;
		int pMais, pIndigo, pCanne, sommeP;


		tab = new char[100];

		do
		{
			System.out.print ( "Proportion de MaÃ¯s   : " );
			pMais = Clavier.lire_int();

			System.out.print ( "Proportion d'Indigo  : " );
			pIndigo = Clavier.lire_int();

			System.out.print ( "Proportion de Cannes : " );
			pCanne = Clavier.lire_int();

			sommeP = pMais + pIndigo + pCanne;

			if ( sommeP > 25 )
				System.out.println ( "\nLa somme des proportions dÃ©passe 25\n" );

		}while ( sommeP > 25 );

		int cpt=0;

		for (int cptMais=0; cptMais<pMais; cptMais++ )
			tab[cpt++] = 'M';

		for (int cptIndigo=0; cptIndigo<pIndigo; cptIndigo++ )
			tab[cpt++] = 'I';

		for (int cptCanne=0; cptCanne<pCanne; cptCanne++ )
			tab[cpt++] = 'C';

		while ( cpt < tab.length )
			tab[cpt++] = '.';

		return tab;
	}



	private static String toString(char[] tab)
	{
		String sRet = "";

		for (int cpt=0; cpt<tab.length; cpt++ )
		{
			sRet += tab[cpt] + " ";
			

			if ( (cpt+1) % 25 == 0 ) sRet+= "\n";
		}

		return sRet;
	}


	/*--------------------------------------*/
	/* MÃ©thode  Ã  dÃ©finir pour l'exercice 2 */
	/*--------------------------------------*/
	private static char[] genererTabRepartition(String[] libCulture)
	{
		char[] tabRetour;
		int [] proportionCulture;

		int    nbCulture, nbSaisie;
		int    sommeP;


		tabRetour         = new char[100];
		proportionCulture = new int[libCulture.length];

		nbCulture = 0;


		do
		{
			sommeP = 0;

			for (int cpt=0; cpt<libCulture.length; cpt++ )
			{
				System.out.print ( "Proportion de " + String.format ( "%-12s", libCulture[cpt] ) + " : " );
				proportionCulture[cpt] = Clavier.lire_int();

				sommeP += proportionCulture[cpt];
			}

			if ( sommeP > 25 )
				System.out.println ( "\nLa somme des proportions dÃ©passe 25\n" );

		}while ( sommeP > 25 );

		for (int cpt=0; cpt<libCulture.length; cpt++ )
		{
			for ( int cptSaisie=0; cptSaisie< proportionCulture[cpt]; cptSaisie++ )
				tabRetour[nbCulture++] = libCulture[cpt].charAt(0);
		}



		while ( nbCulture < tabRetour.length )
			tabRetour[nbCulture++] = '.';

		return tabRetour;
	}


	/*--------------------------------------*/
	/* MÃ©thodes Ã  dÃ©finir pour l'exercice 3 */
	/*--------------------------------------*/
	private static char[][] genererTerritoire ( char[] tabRepartition)
	{
		char[][] territoire;

		int nbLig, nbCol;

		System.out.print ( "Nb Lignes   du Territoire : " );
		nbLig = Clavier.lire_int();

		System.out.print ( "Nb Colonnes du Territoire : " );
		nbCol = Clavier.lire_int();

		if ( nbLig <  5 ) nbLig =  5;
		if ( nbLig > 12 ) nbLig = 12;

		if ( nbCol <  8 ) nbCol =  8;
		if ( nbCol > 20 ) nbCol = 20;

		territoire = new char[nbLig][nbCol];

		for ( int lig=0; lig < nbLig; lig++ )
			for ( int col=0 ; col < nbCol; col++ )
				territoire[lig][col] = tabRepartition[ (int) (Math.random()*tabRepartition.length) ];

		return territoire;
	}


	private static String toString ( char[][] tab)
	{
		String sBordure;
		String sRet;


		sBordure = "+";

		for (int cpt=0; cpt<tab[0].length;cpt++)
			sBordure += "-";

		sBordure += "+";


		sRet = sBordure + "\n";

		for ( int lig=0; lig<tab.length; lig++ )
		{
			sRet += "|";

			for ( int col=0; col<tab[lig].length; col++)
			{
				sRet += tab[lig][col];
			}

			sRet+= "|\n";

		}

		sRet += sBordure + "\n";

		return sRet;

	}


	/*--------------------------------------*/
	/* MÃ©thodes Ã  dÃ©finir pour l'exercice 4 */
	/*--------------------------------------*/

	// MÃ©thode Ã  dÃ©finir que si vous avez fait l'Ã©tape 2
	private static int  indiceCulture ( char culture, String[] libCulture )
	{
		for (int cpt=0; cpt<libCulture.length; cpt++ )
			if ( libCulture[cpt].charAt(0) == culture ) return cpt;

		return -1;
	}

	private static void afficherPourcentage ( char[][] tabParcelle, String[] libCulture )
	{
		int[]  nbCulture;
		int    nbParcelles;
		int    indiceCulture;
		double pourcent;


		nbCulture = new int[libCulture.length];

		nbParcelles = tabParcelle.length * tabParcelle[0].length;

		System.out.println ( "produit " + nbParcelles );


		for (int lig=0; lig<tabParcelle.length; lig++)
			for( int col=0; col<tabParcelle[lig].length;col++)
			{
				indiceCulture = Hal.indiceCulture ( tabParcelle[lig][col], libCulture );
				if ( indiceCulture != -1 )
					nbCulture[indiceCulture]++;
			}

		for ( int cpt=0; cpt<libCulture.length; cpt++ )
		{
			pourcent = 1.0 * nbCulture[cpt] / nbParcelles * 100;
			System.out.println ( String.format("%-12s", libCulture[cpt] )  + " : " +
			                     String.format("%3d",  nbCulture [cpt] )  +
			                     " (" + String.format( "%6.2f", pourcent ) + "%" + ")" );
		}
	}


	/*--------------------------------------*/
	/* MÃ©thodes Ã  dÃ©finir pour l'exercice 5 */
	/*--------------------------------------*/
	private static boolean estIsole ( int lig, int col,char[][] territoire )
	{
		int ligN, colN;

		for ( int dLig=-1; dLig<2; dLig++ )
			for ( int dCol=-1; dCol<2; dCol++ )
			{
				ligN = dLig + lig;
				colN = dCol + col;

				if ( ( dLig != 0 || dCol !=0 )                  &&
				     ligN >= 0 && ligN < territoire   .length   &&
				     colN >= 0 && colN < territoire[0].length   &&

				     territoire[ligN][colN] != '.' &&  territoire[ligN][colN] != ' '   ) return false;

			}

		return true;

	}



	private static void enleverPointIsole( char[][] territoire )
	{
		for (int lig=0; lig<territoire.length; lig++)
			for( int col=0; col<territoire[lig].length;col++)

				if ( territoire[lig][col] == '.' && Hal.estIsole ( lig, col, territoire ) )
					 territoire[lig][col] = ' ';


	}



}
