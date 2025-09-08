package pac;
import pac.inter.*;

public class AtelierFabrication 
{
    private double masseVolume;          // g/cm3
	private double volumFab;             // cm3
	private int    nbEmballageFabrique;  // en unité

    public AtelierFabrication  ( double masseVolume )
	{
		this.masseVolume = masseVolume;
		this.volumFab   = 0.0;
		this.nbEmballageFabrique= 0;
	}

	public void reInitCompteur()
	{
		this.volumFab   = 0.0;
		this.nbEmballageFabrique= 0;
	}
s
    public void fabriquer ( IFabrication emb )
	{
		this.volumFab += emb.getSurfaceExterne() - emb.getVolumeInterne();
		this.nbEmballageFabrique++;
	}

    public String toString()
	{
		return " volume : " + String.format("%7.2f", this.volumFab)+ " cm3 :"+
		                       String.format("%3d", this.nbEmballageFabrique);
	}
    
}
