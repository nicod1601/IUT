import java.io.File;
import java.util.Scanner;
import iut.algo.Decomposeur;


public class Metier
{
	private Departement[] ensDept;
	private int           nbDept;

	private Region[] ensRegion;
	private int      nbRegion;

	public Metier ()
	{
		ensDept   = new Departement[101];
		ensRegion = new Region     [ 18];

		this.chargerDept   ();
		this.chargerRegion ();
		this.lierRegionDept();
	}

	/** Retourne le nombre total de départements */
	public int getNbDept  (){ return this.nbDept;   }

	/** Retourne le nombre total de région */
	public int getNbRegion(){ return this.nbRegion; }

	/** Retourne le Département situé à l'indice indice
	  * Si l'indice est invalide cette méthode devra retourner null  */
	public Departement getDept(int indice)
	{
		if ( indice < 0 || indice >= this.nbDept ) return null;

		return this.ensDept[indice];

	}

	/** Retourne la Région situé à l'indice indice
	  * Si l'indice est invalide cette méthode devra retourner null  */
	public Region getRegion(int indice)
	{
		if ( indice < 0 || indice >= this.nbRegion ) return null;

		return this.ensRegion[indice];
	}

	/** Retourne dans un tableau de String l'ensemble des NOMS de chaque région */
	public String[] listerRegion()
	{
		String[] liste = new String[this.nbRegion];

		for (int cpt=0; cpt < this.nbRegion ; cpt++ )
			liste[cpt] = ensRegion[cpt].getNom();

		return liste;
	}

	/** Charge l'ensemble des départements ensDept à partir du fichier departement.data
	  * Reprendre le code de l'exercice 4
	  * Cette méthode affecte également nbDepartement                                   */
	private void chargerDept()
	{
		Scanner     scDept=null;
		Decomposeur dec;
		String      enreg;

		String numDept, nomDept;
		int    populationDept, superficieDept;

		try
		{
			scDept = new Scanner ( new File ( "departement.data" ), "UTF-8" );

			while ( scDept.hasNextLine() )
			{
				enreg = scDept.nextLine();
				dec   = new Decomposeur ( enreg );

				numDept        = dec.getString(0);
				nomDept        = dec.getString(1);
				populationDept = dec.getInt   (2);
				superficieDept = dec.getInt   (3);

				// Attention à bien incrémenter l'attribut nbDept, donc ne pas utiliser de variable locale à la méthode
				this.ensDept[this.nbDept++] = new Departement ( numDept, nomDept, populationDept, superficieDept );
			}
		}
		catch(Exception e){ e.printStackTrace(); }

		scDept.close();

	}


	/** Charge l'ensemble des régions ensRegion à partir du fichier region.data
	  * Reprendre le code de l'exercice 4
	  * Cette méthode affecte également nbRegion                                */
	private void chargerRegion()
	{
		Scanner     scRegion = null;
		Decomposeur dec;
		String      enreg;

		int    numRegion, nbDept;
		String nomRegion;

		try
		{
			scRegion = new Scanner ( new File ( "region.data" ), "UTF-8" );

			while ( scRegion.hasNextLine() )
			{
				enreg = scRegion.nextLine();
				dec   = new Decomposeur ( enreg );

				numRegion   = dec.getInt   (0);
				nomRegion   = dec.getString(1);
				nbDept      = dec.getInt   (2);

				// Attention à bien incrémenter l'attribut nbRegion, donc ne pas utiliser de variable locale à la méthode
				this.ensRegion[this.nbRegion++] = new Region ( numRegion, nomRegion, nbDept );
			}

		}
		catch(Exception e){ e.printStackTrace(); }

		scRegion.close();
	}

	/** Affecte à Chaque Region les différents départements
	  * Reprendre le code de l'exercice 4                                       */
	public void lierRegionDept()
	{
		Decomposeur dec;
		String enreg;

		int    numRegion, nbDept;
		String nomRegion, numDept;

		Departement dept;

		try
		{
			Scanner scRegion = new Scanner ( new File ( "region.data" ), "UTF-8" );

			int cptRegion=0;
			while ( scRegion.hasNextLine() )
			{
				enreg = scRegion.nextLine();
				dec   = new Decomposeur ( enreg );

				nbDept = dec.getInt(2);
				for ( int cptDept=0; cptDept < nbDept ; cptDept++ )
				{
					numDept = dec.getString ( 3+cptDept );
					dept    = this.rechercherDept ( numDept );

					if ( dept != null )
						ensRegion[cptRegion].ajouterDepartement( dept );
				}

				cptRegion++;
			}
		}
		catch(Exception e){ e.printStackTrace(); }
	}

	/** Retourne le Departement possédant le numéro numero.
	  * Attention il ne s'agit pas ici d'une recherche par indice.
	  * Cette méthode retourne null, s'il n'existe pas de Département
	  * avec ce numero
	  * Reprendre le code de l'exercice 4                                       */
	private Departement rechercherDept ( String numero)
	{
		for ( int cpt=0; cpt < this.nbDept ; cpt ++ )
			if ( ensDept[cpt] != null && ensDept[cpt].getNumero().equals(numero) )
				return ensDept[cpt];

		return null;
	}

}