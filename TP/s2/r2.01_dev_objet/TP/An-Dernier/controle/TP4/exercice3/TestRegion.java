import iut.algo.Console;
import iut.algo.CouleurConsole;

public class TestRegion
{
	public static void main(String[] a)
	{
		String  numDept;

		Departement[] ensDepartement = new Departement[ 150 ];
		Region     [] ensRegion      = new Region     [  30 ];

		ensDepartement[0] = new Departement ( "14", "Calvados",         685_262, 5_548 );
		ensDepartement[1] = new Departement ( "27", "Eure",             588_111, 6_040 );
		ensDepartement[2] = new Departement ( "50", "Manche",           499_531, 5_938 );
		ensDepartement[3] = new Departement ( "61", "Orne",             290_891, 6_103 );
		ensDepartement[4] = new Departement ( "76", "Seine-Maritime", 1_251_282, 6_278 );

		// je fais volontairement un trou dans mon tableau
		ensDepartement[6] = new Departement ( "22", "Côtes-d'Armor",    594_375, 6_878 );
		ensDepartement[7] = new Departement ( "29", "Finistère",        899_870, 6_733 );
		ensDepartement[8] = new Departement ( "35", "Ille-et-Vilaine",  996_439, 6_775 );
		ensDepartement[9] = new Departement ( "56", "Morbihan",         727_083, 6_823 );


		ensRegion[0] = new Region ( 23, "Normandie",  5 );

		ensRegion[0].ajouterDepartement ( ensDepartement[0] );
		ensRegion[0].ajouterDepartement ( ensDepartement[1] );
		ensRegion[0].ajouterDepartement ( ensDepartement[2] );
		ensRegion[0].ajouterDepartement ( ensDepartement[3] );
		ensRegion[0].ajouterDepartement ( ensDepartement[4] );

		ensRegion[1] = new Region ( 53, "Bretagne",  4 );

		ensRegion[1].ajouterDepartement ( ensDepartement[6] );
		ensRegion[1].ajouterDepartement ( ensDepartement[7] );
		ensRegion[1].ajouterDepartement ( ensDepartement[8] );
		ensRegion[1].ajouterDepartement ( ensDepartement[9] );

		Console.println ( ensRegion[0] );
		Console.println ( ensRegion[1] );

		// Test de la méthode rechercherDept.

		Console.print ( "Quel département voulez-vous détailler : " );
		Console.couleurFont ( CouleurConsole.ROUGE );
		numDept = Console.lireString();
		Console.normal();

		Departement dept = TestRegion.rechercherDept ( ensDepartement, numDept );

		if ( dept != null )
			Console.println ( dept.toString() );
		else
			Console.println ( "département inexistant" );

	}


	private static Departement rechercherDept (Departement[] tab, String numero)
	{
		for ( int cpt=0; cpt < tab.length ; cpt ++ )
			if ( tab[cpt] != null && tab[cpt].getNumero().equals(numero) )
				return tab[cpt];

		return null;
	}
}