public class Region
{
	//-----------
	//  Attributs
	
	public String nom     ;
	
	public int numero     ;
	public int nbDeptTotal;
	
	public Departement[] tabDept;
	public int        nbDept = 0;

	//----------
	//  Méthodes

	//  Constructeur

	public Region( int numero, String nom, int nbDeptTotal)
	{
		this.numero      = numero     ;
		this.nom         = nom        ;
		this.nbDeptTotal = nbDeptTotal;
		this.tabDept = new Departement[this.nbDeptTotal];
	}

	//  Accesseurs

	public int         getNumero        () { return this.numero     ;}

	public String      getNom           () { return this.nom        ;}

	public int         getNbDept        () { return this.nbDept     ;}
	
	public int         getNbDeptTotal   () { return this.nbDeptTotal;}
	
	public Departement getDept(int indice) 
	{
		if (indice < 0 || indice >= this.nbDept) return null;

		return this.tabDept[indice];
	}
	
	public int getSuperficie() 
	{
		int superficieTotale = 0;
		
		for (int cpt = 0; cpt < this.nbDept; cpt++)
		{
			superficieTotale += this.tabDept[cpt].getSuperficie();
		}
		
		return superficieTotale;
	}
	
	public int getPopulation() 
	{
		int populationTotale = 0;
		
		for (int cpt = 0; cpt < this.nbDept; cpt++)
		{
			populationTotale += this.tabDept[cpt].getPopulation();
		}
		
		return populationTotale;
	}

	// Autres méthodes

	public double densite()
	{
		double dRet;
		
		if (this.getPopulation() == 0 || this.getSuperficie() == 0) { return 0.0f / 0.0f; }

		dRet = (double)this.getPopulation() / this.getSuperficie();

		return dRet;
	}
	
	public boolean ajouterDepartement( Departement dep)
	{
		if (dep == null) { return false; } 
		
		
		this.tabDept[this.nbDept] = new Departement(dep.getNumero(), dep.getNom(), dep.getPopulation(), dep.getSuperficie());
		this.nbDept++;
		return true;
	}
	
	public String toString()
	{
		String sRet;
		
		sRet = String.format("%2d", this.numero) + " "+ String.format("%-26s", this.nom) + "(densité : " + String.format("%6.2f", this.densite()) + " hab/km²)\n";
		
		for (int cpt = 0; cpt < this.nbDept; cpt++)
		{
			sRet += "   " + String.format("%2s", this.tabDept[cpt].getNumero()) + " "+ String.format("%-25s", this.tabDept[cpt].getNom()) + "(densité : " + String.format("%9.2f", this.tabDept[cpt].densite()) + " hab/km²)\n";
		}
		
		return sRet;
	}
	
}
