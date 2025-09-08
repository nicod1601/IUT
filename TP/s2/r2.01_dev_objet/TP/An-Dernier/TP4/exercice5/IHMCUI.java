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

		Console.println ( " 1. Listes des Départements "            );
		Console.println ( " 2. Listes des Regions "                 );
		Console.println ( " 3. Listes des Départements par Region " );
		Console.println ( " 4. Quitter "                            );

		Console.println ();
		Console.print   ( "     votre choix : " );
		Console.couleurFont ( CouleurConsole.ROUGE );

		choix = Console.lireInt();

		Console.normal();
		Console.println ();

		if ( choix < 1 || choix > 4 ) choix = 4;

		return choix;
	}

	public void afficherDept()
	{
		Departement dept;

		String chaine = "+----+-------------------------------+----------+----------+--------+\n" +
		                "|num |nom                            |population|superficie|densite |\n" +
		                "+----+-------------------------------+----------+----------+--------+\n";

		/* A compléter */


		chaine += "+----+-------------------------------+----------+----------+--------+\n";

		Console.println ( chaine);
	}

	public void afficherRegion()
	{
		Region region;

		String chaine = "+----+-----------------------------------+----------+----------+--------+\n" +
		                "|num |nom                                |population|superficie|densite |\n" +
		                "+----+-----------------------------------+----------+----------+--------+\n";
		int nb = metier.getNbRegion();

		for(int cpt=0; cpt < nb ; cpt++)
		{
			dept = metier.getDept( cpt );
			
			if( dept != null)
			{
				chaine += "|" + String.format("%4s", Region.getNumero())
								String.format("%-32s",Region.getNom())
								String.format("%,10d",Region.

		chaine += "+----+-----------------------------------+----------+----------+--------+\n";

		Console.println ( chaine);

	}

	public void afficherRegionAvecDept()
	{
		Region region;
		String chaine ="";

		/* A compléter */

		Console.println ( chaine );
	}

}
