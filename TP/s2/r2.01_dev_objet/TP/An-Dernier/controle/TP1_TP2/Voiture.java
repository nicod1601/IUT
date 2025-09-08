public class Voiture
{
	private static int  nbVoitures = 0;

	private int    numero;
	private String classe;


	public Voiture (String classe)
	{
		this.classe = classe;
		this.numero = ++Voiture.nbVoitures;
	}

	public String toString()
	{
		return "voiture numéro : " + this.numero + " de " + this.classe + " classe";
	}


	public static void main(String[] a)
	{
		Voiture[] tab = new Voiture[5];

		for (int cpt=0; cpt < tab.length; cpt++)
		{
			tab[cpt] = new Voiture ( cpt<2?"1ère":"2nde" );
			System.out.println ( "création de " + tab[cpt] );
		}

		System.out.println ();
		System.out.println ( "Ensemble des voitures créées" );

		for (int cpt=0; cpt < tab.length; cpt++)
		{
			System.out.println ( tab[cpt] );
		}

	}
}

