import iut.algo.Console;
import iut.algo.CouleurConsole;


public class IHMCUI
{
	private Metier metier;

	public IHMCUI(Metier metier)
	{
		this.metier = metier;
	}

	public int menu()
	{
		int choix;

		Console.println ( " 1. Liste des Départements "            );
		Console.println ( " 2. Liste des Regions "                 );
		Console.println ( " 3. Liste des Départements par Region " );
		Console.println ( " 4. Quitter "                           );

		Console.println ();
		Console.print   ( "     votre choix : " );
		Console.gras();
		Console.couleurFont ( CouleurConsole.JAUNE );

		choix = Console.lireInt();

		Console.normal();
		Console.println ();

		if ( choix < 1 || choix > 4 ) choix = 4;

		return choix;
	}

	public void afficherDept()
	{
		Departement dept;

		String chaine = "+----+-----------------------+----------+----------+---------+\n" +
		                "|num |nom                    |population|superficie|densite  |\n" +
		                "+----+-----------------------+----------+----------+---------+\n";

		int nb = metier.getNbDept();

		for ( int cpt=0; cpt< nb; cpt++ )
		{
			dept = metier.getDept( cpt );

			if ( dept != null )
				chaine += "|" + String.format ("%4s",    dept.getNumero    () )                                  +
				          "|" + String.format ("%-23s",  dept.getNom       () )                                  +
				          "|" + String.format ("%,10d",  dept.getPopulation() ).replace ( (char) 8239 , ' ' )    +
				          "|" + String.format ("%,10d",  dept.getSuperficie() ).replace ( (char) 8239 , ' ' )    +
				          "|" + String.format ("%,9.2f", dept.densite      () ).replace ( (char) 8239 , ' ' )    + "|\n";
		}

		chaine += "+----+-----------------------+----------+----------+---------+\n";

		Console.println ( chaine );
	}

	public void afficherRegion()
	{
		Region region;

		String chaine = "+----+--------------------------------+----------+----------+--------+\n" +
		                "|num |nom                             |population|superficie|densite |\n" +
		                "+----+--------------------------------+----------+----------+--------+\n";

		int nb = metier.getNbRegion();

		for ( int cpt=0; cpt < nb; cpt++ )
		{
			region = metier.getRegion ( cpt );

			if ( region != null )
				chaine += "|"  + String.format ( "%4s" ,  region.getNumero    () )                               + "|" +
				                 String.format ( "%-32s", region.getNom       () )                               + "|" +
				                 String.format ( "%,10d", region.getPopulation() ).replace ( (char) 8239 , ' ' ) + "|" +
				          "  " + String.format ( "%,8d",  region.getSuperficie() ).replace ( (char) 8239 , ' ' ) + "|" +
				                 String.format ( "%8.2f", region.densite      () ).replace ( (char) 8239 , ' ' ) + "|\n";
		}
		chaine += "+----+--------------------------------+----------+----------+--------+\n";

		Console.println ( chaine );

	}

	public void afficherRegionAvecDept()
	{
		Region      region;
		Departement dept;

		for ( int cptRegion=0; cptRegion< metier.getNbRegion(); cptRegion++ )
		{
			region = metier.getRegion ( cptRegion );

			if ( region != null )
			{
				Console.println ( "+---------------------------------------+" );
				Console.println ( "|" +
				                  String.format ( "%-26s", region.getNom   () ) + " ( " +
				                  String.format ( "%2d",   region.getNbDept() ) + " dept ) |" );
				Console.println ( "+---------------------------------------+" );
				Console.println ( "" );

				for ( int cptDept=0; cptDept< region.getNbDept(); cptDept++ )
				{
					dept = region.getDept ( cptDept );

					Console.println ( "   " +
					                  String.format ("%2s", dept.getNumero() ) + "  " +
					                  String.format ("%-15s", dept.getNom () )
					                );
				}

				Console.println ( "\n" );
			}
		}

	}

}

