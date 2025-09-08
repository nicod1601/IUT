package pac;
import pac.inter.IPeinture;

public class AtelierPeinture 
{
	private double pouvoirCouvrant;   // m²/litre
	private double surfacePeinte;     // cm²
	private int    nbEmballagePeint;  // en unité

	public AtelierPeinture ( double pouvoirCouvrant )
	{
		this.pouvoirCouvrant = pouvoirCouvrant;
		this.surfacePeinte   = 0.0;
		this.nbEmballagePeint= 0;
	}

	public void reInitCompteur()
	{
		this.surfacePeinte   = 0.0;
		this.nbEmballagePeint= 0;
	}

	public void peindre ( IPeinture emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne()/10000/this.pouvoirCouvrant;
		this.nbEmballagePeint++;
	}

	public String toString()
	{
		return " surface : " + String.format("%7.2f", this.surfacePeinte)+ " l nb :"+
		                       String.format("%3d", this.nbEmballagePeint);
	}
}
