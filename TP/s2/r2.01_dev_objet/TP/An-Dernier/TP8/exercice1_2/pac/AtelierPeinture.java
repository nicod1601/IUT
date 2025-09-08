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
		this.surfacePeinte += emb.getSurfaceExterne();
		this.nbEmballagePeint++;
	}

	public void peindre ( PrismeHexa emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne();
		this.nbEmballagePeint++;
	}

	public String toString()
	{
		return " surface : " + String.format("%7.2f", this.surfacePeinte)+ " l nb :"+
		                       String.format("%3d", this.nbEmballagePeint);
	}
}
