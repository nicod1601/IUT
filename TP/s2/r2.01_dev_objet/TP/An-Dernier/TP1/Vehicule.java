/** Classe Vehicule
  * @author Philippe Le Pivert
  */
public class Vehicule
{
	private static boolean moteurEnMarche;
	private int            nbKm;

	public Vehicule ()
	{
		this.moteurEnMarche  = false;
		this.nbKm            = 0;
	}

	public void contact()
	{
		this.moteurEnMarche =! this.moteurEnMarche;
		// A compléter : passage de Marche à Arret ou d'Arret à Marche
	}

	public void avancer()
	{
		if(this.moteurEnMarche = true)
		{
			this.nbKm += 1;
		}
		// A compléter : avance d'une unité le compteur kilométrique si le Moteur est en Marche
	}

	public String toString()
	{
		return ( this.moteurEnMarche?"Marche":"Arret ") + "  " + String.format ("%06d", this.nbKm );
	}

}
