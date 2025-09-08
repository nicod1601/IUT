/** Classe Vehicule
  * @author Philippe Le Pivert
  */
public class VoitureV2
{
	private static int    numero;
	private String classe;

	public VoitureV2 (String classe)
	{
		this.classe = classe;
		this.numero++;
	}

	public String toString()
	{
		return "voiture numéro : " + this.numero + " de " + this.classe + " classe";
	}


	public static void main(String[] a)
	{
		VoitureV2[] ensVoitures = new VoitureV2[5];

		for (int cpt=0; cpt < ensVoitures.length; cpt++)
		{
			ensVoitures[cpt] = new VoitureV2 ( cpt<2?"1ère":"2nd" );
			System.out.println ( "création de " + ensVoitures[cpt] );
		}

		System.out.println ();
		System.out.println ( "Ensemble des voitures créées" );

		for (int cpt=0; cpt < ensVoitures.length; cpt++)
		{
			System.out.println ( ensVoitures[cpt] );
		}

	}
}


