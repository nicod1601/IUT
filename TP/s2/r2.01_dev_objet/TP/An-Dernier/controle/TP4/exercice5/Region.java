public class Region
{
	private int           numero;
	private String        nom;

	private Departement[] tabDept;
	private int           nbDept;

	public Region(int numero, String nom, int nbDeptTotal)
	{
		this.numero  = numero;
		this.nom     = nom;

		this.tabDept = new Departement[nbDeptTotal];
		this.nbDept  = 0;
	}

	public boolean ajouterDepartement(Departement dep)
	{
		if ( this.nbDept == this.tabDept.length ) return false;

		this.tabDept[this.nbDept++] = dep;

		return true;
	}

	public int         getNumero     ()           { return this.numero;         }
	public String      getNom        ()           { return this.nom;            }
	public int         getNbDeptTotal()           { return this.tabDept.length; }
	public int         getNbDept     ()           { return this.nbDept;         }
	public Departement getDept       (int indice) { return this.tabDept[indice];}

	public int    getSuperficie()
	{
		int superficie = 0;
		for ( int cpt=0; cpt < this.nbDept; cpt++ )
			superficie += this.tabDept[cpt].getSuperficie();

		return superficie;
	}

	public int    getPopulation()
	{
		int population = 0;
		for ( int cpt=0; cpt < this.nbDept; cpt++ )
			population += this.tabDept[cpt].getPopulation();

		return population;
	}

	public double   densite()
	{
		return (double) this.getPopulation() / this.getSuperficie();
	}


	// Cette méthode toString est une méthode fournissant sans aucune présentation le nom
	// de la Region et le nom de ses départemts.
	// C'est de la responsabilité de l'IHM (IHMCUI) de formater l'affichage.
	// Cette méthode n'est donc utile que pour de la mise au point.
	public String toString()
	{
		String sRet= this.numero + " " + this.nom + "\n";

		for ( int cpt=0; cpt < this.nbDept; cpt++ )
			sRet += "   " + this.tabDept[cpt].getNumero() + " " + this.tabDept[cpt].getNom() + "\n";

		return sRet;
	}


}
