/** Classe Vehicule
 * @author Philippe Le Pivert
*/
public class Voiture
{
	private static int numero;

	private int nbVoitures;
	private String classe;

	public Voiture (String classe)
	{
		this.classe = classe;
		this.nbVoitures = ++Voiture.numero;
	}

	public String toString()
	{
		return "voiture numéro : " + this.nbVoitures + " de " + this.classe + " classe";
	}


	public static void main(String[] a)
	{

	Voiture[] ensVoitures = new Voiture[5];		for (int cpt=0; cpt < ensVoitures.length; cpt++)
	{
		int num = cpt + 1;
		ensVoitures[cpt] = new Voiture ( "création de la voiture " + num );
	}
	
	System.out.println ();
	System.out.println ( "Ensemble des voitures créées" );

	for (int cpt=0; cpt < ensVoitures.length; cpt++)
	{
		System.out.println ( ensVoitures[cpt] );
	}
	
	for (int cpt=0; cpt < ensVoitures.length; cpt++)
	{
		int num = cpt + 1;
		ensVoitures[cpt] = new Voiture ( "création de la voiture " + num );
	}
	
	System.out.println ();
	System.out.println ( "Ensemble des voitures créées" );

	for (int cpt=0; cpt < ensVoitures.length; cpt++)
	{
		System.out.println ( ensVoitures[cpt] );
	}

	}
}


