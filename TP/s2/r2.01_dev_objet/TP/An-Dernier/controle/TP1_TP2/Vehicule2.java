/** Classe Vehicule
  * @author Philippe Le Pivert
  */

public class Vehicule
{
	// Attributs de Classe
	private static boolean moteurEnMarche = false;  // true en marche, false à l'arrêt

	// Attributs d'instance
	private int     nbKm;



	public Vehicule ()
	{
		//this.moteurEnMarche = false;  // il n'est pas très logique d'initialiser
		                                // un attribut de classe dans un constructeur.
		this.nbKm       = 0;
	}

	public void contact()
	{
		Vehicule.moteurEnMarche = ! Vehicule.moteurEnMarche;
	}

	public void avancer()
	{
		if ( Vehicule.moteurEnMarche ) this.nbKm++;
	}

	public String toString()
	{
		return ( Vehicule.moteurEnMarche?"Marche":"Arret " ) + "  " + String.format ("%06d", this.nbKm );
	}


}
