/** Classe Livre
  * @author Philippe Le Pivert
  */
public class Livre
{
	/*------------------*/
	/*     Attributs    */
	/*------------------*/

	//Attributs de classe
	private static int nbInstances; // possible de mettre private static int nbInstances = 0;

	//Attributs d'instance
	private String  titre;

	/*------------------*/
	/*     Méthodes     */
	/*------------------*/
	public Livre ( String titre )
	{
		this.titre = titre;
		Livre.nbInstances++;
	}
	public String toString()
	{
		return this.titre;
	}

	public static int getNbInstances()
	{
		return Livre.nbInstances;

	}

}
