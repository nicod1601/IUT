public class Voiture
{
	private int numero ;
	private String classe ;
	private static int nbVoiture ;
	
	public Voiture(String classe)
	{
		this.classe = classe;
		this.numero = ++Voiture.nbVoiture;
	}
	public String toString()
	{
		return "voiture numéro : " + this.numero + " de " + this.classe + " classe";
	}
	public static void main(String[] a)
	{
		Voiture[] ensVoitures = new Voiture[10];

		for (int cpt=0; cpt < ensVoitures.length; cpt++)
		{
			ensVoitures[cpt] = new Voiture ( cpt<2?"1ère":"2nd" );
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
