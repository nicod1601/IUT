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

	public int    getNumero     () { return this.numero;         }
	public String getNom        () { return this.nom;            }
	public int    getNbDeptTotal() { return this.tabDept.length; }
	public int    getNbDept     () { return this.nbDept;         }

	public Departement getDept  (int indice)
	{
		return this.tabDept[indice];
	}

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
		return  this.getPopulation() / (double)this.getSuperficie();
	}

	public String toString()
	{
		String sRet= this.numero + " " + this.nom + "  (densité : " +
		             String.format ( "%7.2f", this.densite() ) + " hab/km²)\n";

		for ( int cpt=0; cpt < this.nbDept; cpt++ )
			sRet += "   " + String.format ( "%-2s",  this.tabDept[cpt].getNumero() ) + " " +
			                String.format ( "%-20s", this.tabDept[cpt].getNom()    ) + " " +
			                " (densité : "                                           +
			                String.format ( "%7.2f", this.tabDept[cpt].densite()   ) + " hab/km²)\n";


		return sRet;
	}


}