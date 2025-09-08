import java.io.FileInputStream;
import java.util.Scanner;
import iut.algo.Decomposeur;
import iut.algo.Console;

/** Class Demographie
  * @author Philippe Le Pivert
  */

public class Demographie
{

	public static void main(String[] a)
	{
		Departement[] ensDepartements = new Departement[101];  // @1
		Region     [] ensRegions      = new Region     [ 18];

		// Question 4.1
		Console.println ( "Etape 1");
		Demographie.chargerDept   (ensDepartements);
		Demographie.afficherDept  (ensDepartements);

		// Question 4.2
		Console.println ( "Etape 2");
		Demographie.chargerRegion (ensRegions);
		Demographie.afficherRegion(ensRegions);

		// Question 4.3
		Console.println ( "Etape 3");
		Demographie.lierRegionDept(ensRegions, ensDepartements);
		Demographie.afficherRegion(ensRegions);
		Demographie.afficherRegionAvecDept(ensRegions);
	}


	// Question 4.1
	private static void chargerDept(Departement[] tab)
	{
		Decomposeur dec;
		String enreg;

		String numDept, nomDept;
		int    populationDept, superficieDept;

		int indiceDep = 0;
		try
		{
			Scanner scDept = new Scanner ( new FileInputStream ("departement.data") );
			
			while ( scDept.hasNextLine() )
			{
				
				enreg = scDept.nextLine();
				dec   = new Decomposeur ( enreg );
				tab[indiceDep++] = new Departement (dec.getString(0), dec.getString(1), dec.getInt(2), dec.getInt(3));
			}
			
			/*for (int cpt = 0; cpt < nbLigne; cpt++)
			{
				enreg = scDept.nextLine();
				dec   = new Decomposeur ( enreg );
				tab[cpt] = new Departement (dec.getString(0), dec.getString(1), dec.getInt(2), dec.getInt(3));
				
			}*/
			
			
			scDept.close();
		}
		catch(Exception e){ e.printStackTrace(); }
		
		
	}


	// Question 4.2o
	// Attention on ne fait pas encore les liens entre une Region et ses départements
	private static void chargerRegion(Region[] tab)
	{
		Decomposeur dec;
		String enreg;

		int    numRegion, nbReg;
		String nomRegion;
		
		int indiceRegion =0;
		try
		{
			Scanner scReg = new Scanner ( new FileInputStream ("region.data") );
			
			while ( scReg.hasNextLine() )
			{
				enreg = scReg.nextLine();
				dec   = new Decomposeur ( enreg );
				tab[indiceRegion++] = new Region (dec.getInt(0), dec.getString(1), dec.getInt(2));
			}

			
			scReg.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}


	// Question 4.3
	public static void lierRegionDept(Region[] tabRegion, Departement[] tabDept)
	{
		Decomposeur decReg;
		String enregReg;
		
		int    numRegion, nbDept;
		String nomRegion, numDept;
		
		Departement dept;
		
		try
		{
			Scanner scReg = new Scanner ( new FileInputStream ("region.data"     ) );
			
			int cptRegion = 0;
			while (scReg.hasNextLine())
			{
				enregReg = scReg.nextLine();
				decReg   = new Decomposeur (enregReg);
				
				nbDept = decReg.getInt(2);
				for (int cptDept = 0; cptDept < nbDept; cptDept++)
				{
					numDept = decReg.getString (3 + cptDept);
					dept = Demographie.rechercherDept (tabDept, numDept);
					
					if (dept != null)
						tabRegion[cptRegion].ajouterDepartement( dept );
				}
				
				cptRegion++;
			}
			
			
			scReg.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}


	// Question 4.1
	private static void afficherDept(Departement[] tab)
	{
		String chaine = "+----+------------------------+----------+----------+---------+\n" +
		                "|num |nom                     |population|superficie|densite  |\n" +
		                "+----+------------------------+----------+----------+---------+\n";

		for ( int cpt=0; cpt< tab.length; cpt++ )
			chaine += "|" + String.format("%-3s ",  tab[cpt].getNumero    ())
			       +  "|" + String.format("%-24s",  tab[cpt].getNom       ())
			       +  "|" + String.format("%,10d",  tab[cpt].getPopulation()).replace ( (char) 8239 , ' ' )
			       +  "|" + String.format("%,10d",  tab[cpt].getSuperficie()).replace ( (char) 8239 , ' ' )
			       +  "|" + String.format("%,9.2f", tab[cpt].densite      ()).replace ( (char) 8239 , ' ' ) + "|\n";


		chaine += "+----+------------------------+----------+----------+---------+\n";

		Console.println ( chaine);
	}


	// Question 4.2
	// Attention à la remarque @1
	private static void afficherRegion(Region[] tab)
	{
		String chaine = "+----+--------------------------+----------+----------+---------+\n" +
		                "|num |nom                       |population|superficie|densite  |\n" +
		                "+----+--------------------------+----------+----------+---------+\n";
		for ( int cpt=0; cpt< tab.length; cpt++ )
			chaine += "|" + String.format("%-3s ",  tab[cpt].getNumero    ())
			       +  "|" + String.format("%-26s",  tab[cpt].getNom       ())
			       +  "|" + String.format("%,10d",  tab[cpt].getPopulation()).replace ( (char) 8239 , ' ' )
			       +  "|" + String.format("%,10d",  tab[cpt].getSuperficie()).replace ( (char) 8239 , ' ' )
			       +  "|" + String.format("%,9.2f", tab[cpt].densite      ()).replace ( (char) 8239 , ' ' ) + "|\n";

		chaine += "+----+--------------------------+----------+----------+---------+\n";

		Console.println (chaine);

	}


	// Question 4.3
	private static void afficherRegionAvecDept(Region[] tab)
	{
		for ( int cpt=0; cpt< tab.length; cpt++ )
			Console.println ( tab[cpt] );
	}


	private static Departement rechercherDept (Departement[] tab, String numero)
	{
		for (int cpt = 0; cpt < tab.length; cpt++)
			if (tab[cpt].getNumero().equals(numero)) { return tab[cpt]; }
		
		
		return null;
	}

}

/*----*/
/* @1 */
/*-----------------------------------------------------------------*/
/* Afin de vous faciliter la tâche j'affecte en dur                */
/*    le nombre de département à 100 et                            */
/*    le nombre de région      à 18                                */
/*                                                                 */
/* Il aurait été plus judicieux  dans  les  méthodes  chargerXxxxx */
/* de parcourir une première fois les deux fichiers pour connaitre */
/* le nombre précis de départements et de régions.                 */
/*                                                                 */
/* Attention si la valeur 101 est bonne  la  valeur  27,  elle  ne */
/* l'est pas. Elle est en effet trop grande, mais cela ne doit pas */
/* empêcher votre programme de fonctionner, à vous d'être vigilant */
/* quand vous parcourerez tabRegion de  tester  qu'un  élément  ne */
/* possède pas la valeur null.                                     */
/*                                                                 */
/*-----------------------------------------------------------------*/
