public class Region
{
	private int numero;
	private String nom;
	private int nbDept;
	private Departement[] tabDep;

	public Region(int numero, String nom, int nbDeptTotal)
	{
		this.numero = numero;
		this.nom = nom;
		this.nbDept = 0;
		this.tabDep = new Departement[nbDeptTotal];
	}

	public boolean ajouterDepartement(Departement dep)
	{
		if(this.tabDep.length == this.nbDept || dep.getEstDansRegion() == true) // Vérification pour éviter les doublons
		{
			return false;
		}

		this.tabDep[nbDept++] = dep;

		dep.setEstDansRegion(); // Ce département est utilisé

		return true;
	}

	public int getNumero()
	{
		return this.numero;
	}

	public String getNom()
	{
		return this.nom;
	}

	public int getNbDept()
	{
		return this.nbDept;
	}

	public int getNbDeptTotal()
	{
		return this.tabDep.length;
	}

	public Departement getDept(int indice)
	{
		if (indice > 0 && indice <= tabDep.length)
		{
			return null;
		}

		indice--;
		return tabDep[indice];
	}

	public int getSuperficie()
	{
		int superTot = 0;

		for (int cpt = 0; cpt < this.nbDept; cpt++)
		{
			superTot += tabDep[cpt].getSuperficie();
		}

		return superTot;
	}

	public int getPopulation()
	{
		int popTot = 0;

		for (int cpt = 0; cpt < this.nbDept; cpt++)
		{
			popTot += tabDep[cpt].getPopulation();
		}

		return popTot;
	}

	public double densite()
	{
		if (this.getPopulation() == 0 || this.getSuperficie() == 0) return 0;

		return this.getPopulation() / this.getSuperficie();
	}

	public String toString()
	{
		return "Region [numero=" + numero + ", nom=" + nom + ", nbDept=" + nbDept + ", superficie="
                                 + this.getSuperficie() + ", population=" + this.getPopulation() + ", densite=" + this.densite() + "]";
	}

}