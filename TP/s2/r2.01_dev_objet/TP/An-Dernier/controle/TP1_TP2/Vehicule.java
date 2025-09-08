/** Classe Vehicule
  * @author Philippe Le Pivert
  */

public class Vehicule
{

	// Attributs d'instance
	private boolean moteurEnMarche;  // true en marche, false à l'arrêt
	private int     nbKm;


	public Vehicule ()
	{
		this.moteurEnMarche = false;
		this.nbKm           = 0;
	}

	public void contact()
	{
		this.moteurEnMarche = ! this.moteurEnMarche;
	}

	public void avancer()
	{
		if ( this.moteurEnMarche ) this.nbKm++;
	}

	public String toString()
	{
		return ( this.moteurEnMarche?"Marche":"Arret " ) + "  " + String.format ("%06d", this.nbKm );
	}




}
