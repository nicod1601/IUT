package pac;
import pac.emballage.*;

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

	public void peindre ( Cylindre emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne();
		this.nbEmballagePeint++;
	}

	public void peindre ( Cube emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne()/*/10000/this.pouvoirCouvrant*/;
		this.nbEmballagePeint++;
	}

	public void peindre ( PrismeHexa emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne();
		this.nbEmballagePeint++;
	}

	public String toString()
	{
		return "Nb emballages : " + String.format("%3d", this.nbEmballagePeint) + "\n"
				+ "Surface peinte : " + String.format("%7.2f", this.surfacePeinte) + " cm²\n"
				+ "Consommation : " + String.format("%7.2f", this.surfacePeinte / this.nbEmballagePeint) + " l\n";
	}
}
