public class Departement
{
	private String numero;
	private String nom;
	private int population;
	private int superficie;
	private boolean estDansRegion;

	public Departement(String numero, String nom, int population, int superficie)
	{
		this.numero = numero;
		this.nom = nom;
		this.population = population;
		this.superficie = superficie;
		this.estDansRegion = false;
	}

	public String getNumero()
	{
		return this.numero;
	}

	public String getNom()
	{
		return this.nom;
	}

	public int getPopulation()
	{
		return this.population;
	}

	public int getSuperficie()
	{
		return this.superficie;
	}

	public double getDensite()
	{
		return this.population / this.superficie;
	}

	public boolean getEstDansRegion() // Savoir si le département est déja utilisé, true = utilisé
	{
		return this.estDansRegion;
	}

	public void setEstDansRegion() // Le département est utilisé, true = utilisé
	{
		this.estDansRegion = true;
	}
	
	public String toString()
	{
		return " " + this.nom + " " + this.population + " " + this.superficie + " " ;
	}
}
