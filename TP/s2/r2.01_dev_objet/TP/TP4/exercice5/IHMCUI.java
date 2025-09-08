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
	
		int nb = metier.getNbDept(); // Nombre total de départements
	
		for (int cpt = 0; cpt < nb; cpt++)
		{
			dept = metier.getDept(cpt);
	
			if (dept != null)
			{
				chaine += String.format("|%-4s|%-31s|%,10d|%,10d|%,8.2f|\n",
										dept.getNumero(), 
										dept.getNom(),
										dept.getPopulation(),
										dept.getSuperficie(),
										dept.densite());
			}
		}
	
		chaine += "+----+-------------------------------+----------+----------+--------+\n";
	
		Console.println(chaine);
	}
	
	

	public void afficherRegion()
	{
		Region region;
	
		String chaine = "+----+-----------------------------------+----------+----------+--------+\n" +
						"|num |nom                                |population|superficie|densite |\n" +
						"+----+-----------------------------------+----------+----------+--------+\n";
	
		int nb = metier.getNbRegion();
	
		for(int cpt = 0; cpt < nb; cpt++)
		{
			region = metier.getRegion(cpt);
	
			if(region != null)
			{
				chaine += String.format("|%-4d|%-35s|%,10d|%,10d|%,9.2f|\n",
										region.getNumero(),
										region.getNom(),
										region.getPopulation(),
										region.getSuperficie(),
										region.densite());
			}
		}
	
		chaine += "+----+-----------------------------------+----------+----------+--------+\n";
	
		Console.println(chaine);
	}
	

	public void afficherRegionAvecDept()
	{
		String chaine = "";
		int nbRegion = metier.getNbRegion();
	
		for(int i = 0; i < nbRegion; i++)
		{
			Region region = metier.getRegion(i);
	
			if(region != null)
			{
				chaine += String.format("\nRegion: %s (%d)\n", region.getNom(), region.getNumero());
				chaine += "-------------------------------------------------\n";
	
				for(int j = 0; j < region.getNbDept(); j++)
				{
					Departement dept = region.getDept(j);
					if (dept != null)
					{
						chaine += String.format(" - %s (%s)\n", dept.getNom(), dept.getNumero());
					}
				}
			}
		}
	
		Console.println(chaine);
	}
	

}
