public class Departement
{
	private String numero;
	private String nom;
	private int    population;
	private int    superficie;

	public Departement ( String numero, String nom, int population, int superficie )
	{
		this.numero     = numero;
		this.nom        = nom;
		this.population = population;
		this.superficie = superficie;
	}

	public String getNumero    () { return this.numero;     }
	public String getNom       () { return this.nom;        }
	public int    getPopulation() { return this.population; }
	public int    getSuperficie() { return this.superficie; }

	public double densite      ()
	{
		return (double) this.population / this.superficie;
	}

	public String toString()
	{
		return this.nom + " " +
		       String.format ( "%,10d", this.population )  + " hab   " +
		       String.format ( "%,10d", this.superficie )  + " km²   " +
		       String.format ( "%7.2f", this.densite()  )  + " hab/km²";
	}
}
