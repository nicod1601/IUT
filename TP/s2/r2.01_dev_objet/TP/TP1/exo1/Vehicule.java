/** Classe Vehicule
  * @author Philippe Le Pivert
  */
public class Vehicule
{
	private boolean moteurEnMarche;
	private int     nbKm;

	public Vehicule ()
	{
		this.moteurEnMarche  = false;
		this.nbKm            = 0;
	}

	public void contact()
	{
		// A compléter : passage de Marche à Arret ou d'Arret à Marche
		this.moteurEnMarche =! this.moteurEnMarche;
	}

	public void avancer()
	{
		// A compléter : avance d'une unité le compteur kilométrique si le Moteur est en Marche
		if(this.moteurEnMarche)
		{
			this.nbKm += 1;
		}
	}

	public String toString()
	{
		return ( this.moteurEnMarche?"Marche":"Arret ") + "  " + String.format ("%06d", this.nbKm );
	}

}
