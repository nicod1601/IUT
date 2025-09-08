/** Classe Vehicule
  * @author Philippe Le Pivert
  */
public class Vehicule
{
	// Attributs de class
	private static boolean moteurEnMarche = false;

	// Attributs d'instance
	private int     nbKm;

	public Vehicule ()
	{
		//this.moteurEnMarche  = false;
		this.nbKm            = 0;
	}

	public void contact()
	{
		// A compléter : passage de Marche à Arret ou d'Arret à Marche
		Vehicule.moteurEnMarche =! Vehicule.moteurEnMarche;
		//this.moteurEnMarche = false == this.moteurEnMarche;
	}

	public void avancer()
	{
		// A compléter : avance d'une unité le compteur kilométrique si le Moteur est en Marche
		if(Vehicule.moteurEnMarche)
		{
			this.nbKm += 1;
		}
	}

	public String toString()
	{
		return ( Vehicule.moteurEnMarche?"Marche":"Arret ") + "  " + String.format ("%06d", this.nbKm );
	}

}
