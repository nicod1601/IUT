import java.io.FileReader;
import java.util.Scanner;
import iut.algo.Decomposeur;
import java.io.FileInputStream;

public class Metier
{
	private Departement[] ensDepartements;
	private int           nbDept;

	private Region     [] ensRegions;
	private int           nbRegion;

	public Metier ()
	{
		this.ensDepartements = new Departement[101];
		this.ensRegions      = new Region     [ 27];

		this.chargerDept   ();
		this.chargerRegion ();
		this.lierRegionDept(ensRegions, ensDepartements);
	}

	/** Retourne le nombre total de départements */
	public int getNbDept  (){ return this.nbDept;   }

	/** Retourne le nombre total de région */
	public int getNbRegion(){ return this.nbRegion; }

	/** Retourne le Département situé à l'indice indice
	  * Si l'indice est invalide cette méthode devra retourner null  */
	public Departement getDept(int indice)
	{
		if (indice < 0 || indice >= this.nbDept) return null;

		return this.ensDepartements[indice];
	}

	/** Retourne la Région située à l'indice indice
	  * Si l'indice est invalide cette méthode devra retourner null  */
	public Region getRegion(int indice)
	{
		if (indice < 0 || indice >= this.nbRegion) return null;

		return this.ensRegions[indice];
	}

	/** Retourne dans un tableau de String l'ensemble des NOMS de chaque région */
	public String[] listerRegion()
	{
		String[] liste = new String[this.nbRegion];

		for(int cpt=0; cpt< this.nbRegion; cpt++)
		{
			liste[cpt] = this.ensRegions[cpt].getNom();
		}

		return liste;
	}

	/** Charge l'ensemble des départements tabDept à partir du fichier departement.data
	  * Reprendre le code de l'exercice 4
	  * Cette méthode affecte également nbDepartement                                   */
	private void chargerDept()
	{
		Scanner     scDept = null;
		Decomposeur dec            ;
		String      enreg          ;

		String numDept, nomDept;
		int populationDept, superficieDept;

		try
		{
			scDept = new Scanner(new FileInputStream("departement.data"),"UTF8");

			while(scDept.hasNextLine())
			{
				enreg = scDept.nextLine();
				dec = new Decomposeur(enreg);

				numDept       = dec.getString(0);
				nomDept       = dec.getString(1);
				populationDept= dec.getInt   (2);
				superficieDept= dec.getInt   (3);

				this.ensDepartements[this.nbDept++] = new Departement(numDept, nomDept, populationDept, superficieDept);
			}
		}
		catch(Exception e){e.printStackTrace();}
	}

	/** Charge l'ensemble des régions tabRegion à partir du fichier region.data
	  * Reprendre le code de l'exercice 4
	  * Cette méthode affecte également nbRegion                                */
	private void chargerRegion()
	{
		Scanner     scRegion = null;
		Decomposeur dec            ;
		String      enreg          ;

		String nomRegion;
		int numRegion, nbDept;

		try
		{
			scRegion = new Scanner(new FileInputStream("region.data"),"UTF8");

			while(scRegion.hasNextLine())
			{
				enreg = scRegion.nextLine();
				dec = new Decomposeur(enreg);

				numRegion        = dec.getInt   (0);
				nomRegion        = dec.getString(1);
				nbDept           = dec.getInt   (2);

				this.ensRegions[this.nbRegion++] = new Region(numRegion, nomRegion, nbDept);
			}
		}
		catch(Exception e){e.printStackTrace();}
	}

	/** Affecte à Chaque Region les différents départements
	  * Reprendre le code de l'exercice 4                                       */
	public void lierRegionDept()
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
					dept = this.rechercherDept (numDept);
					
					if (dept != null)
						tabRegion[cptRegion].ajouterDepartement( dept );
				}
				
				cptRegion++;
			}
			
			
			scReg.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}

	/** Retourne le Departement possdant le numéro numero.
	  * Attention il ne s'agit pas ici d'une recherche par indice.
	  * Cette méthode retourne null, s'il n'existe pas de Département
	  * avec ce numero
	  * Reprendre le code de l'exercice 4                                       */
	private Departement rechercherDept ( String numero)
	{
		for(int cpt=0; cpt < this.bDept; cpt++)
		{
			if(ensDept[cpt] != null && ensDept[cpt].getNumero().equals(numero))
			{
				return ensDept[cpt];
			}
			
			return null;
		}
	}

}
