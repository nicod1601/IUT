import iut.algo.Console;        // Pour les windowsiens, consultez la page ressources sur la classe Console
import iut.algo.CouleurConsole; // vous avez un .jar à installer sur votre machine
                                // Vous avez normalement du le faire au S1 si vous aviez utilisé la classe Console
                                // sur vos propres machines

public class TestRegion
{
	public static void main(String[] a)
	{
		String  numDept;

		Departement[] tabDepartement = new Departement[ 150 ];	//@1
		Region     [] tabRegion      = new Region     [  30 ];


		tabDepartement[0] = new Departement ( "14", "Calvados",        685262, 5548 );
		tabDepartement[1] = new Departement ( "27", "Eure",            588111, 6040 );
		tabDepartement[2] = new Departement ( "50", "Manche",          499531, 5938 );
		tabDepartement[3] = new Departement ( "61", "Orne",            290891, 6103 );
		tabDepartement[4] = new Departement ( "76", "Seine-Maritime", 1251282, 6278 );

		// je fais volontairement un trou dans mon tableau
		tabDepartement[6] = new Departement ( "22", "Côtes-d'Armor",   594375, 6878 );
		tabDepartement[7] = new Departement ( "29", "Finistère",       899870, 6733 );
		tabDepartement[8] = new Departement ( "35", "Ille-et-Vilaine", 996439, 6775 );
		tabDepartement[9] = new Departement ( "56", "Morbihan",        727083, 6823 );


		tabRegion[0] = new Region ( 23, "Normandie",  5 );

		tabRegion[0].ajouterDepartement ( tabDepartement[0] );
		tabRegion[0].ajouterDepartement ( tabDepartement[1] );
		tabRegion[0].ajouterDepartement ( tabDepartement[2] );
		tabRegion[0].ajouterDepartement ( tabDepartement[3] );
		tabRegion[0].ajouterDepartement ( tabDepartement[4] );

		tabRegion[1] = new Region ( 53, "Bretagne",  4 );

		tabRegion[1].ajouterDepartement ( tabDepartement[6] );
		tabRegion[1].ajouterDepartement ( tabDepartement[7] );
		tabRegion[1].ajouterDepartement ( tabDepartement[8] );
		tabRegion[1].ajouterDepartement ( tabDepartement[9] );

		Console.println ( tabRegion[0] );
		Console.println ( tabRegion[1] );
	}
}

/*----*/
/* @1 */
/*----------------------------------------------------------------*/
/*  Je surdimensionne volontairement mon tableau de Département   */
/*  pour faire mes tests sur les Regions Normandie et Bretagne    */
/*----------------------------------------------------------------*/
