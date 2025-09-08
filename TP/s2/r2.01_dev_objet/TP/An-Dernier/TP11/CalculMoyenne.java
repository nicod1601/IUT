import utilitaire.Etudiant;
public class CalculMoyenne
{
	private static ListeEtdDouble led;

	public static void main ( String arg[] )
	{
		led = new ListeEtdDouble	();

		led.ajouterEnTete( new Etudiant ( "Daivant", "Rose",    14.0 ) );
		led.ajouter ( new Etudiant ( "Lairbon", "Oussama", 15.0 ) );
		led.ajouter ( new Etudiant ( "Ousi",    "Jacques", 12.0 ) );

		System.out.println ( "\n" + led );
		calculerMoyenne();

		led.inserer ( new Etudiant ( "Patamob", "Alphonse", 13.0 ) );

		System.out.println ( "\n" + led );
		calculerMoyenne();

	}

	public static void calculerMoyenne()
	{
		double somme = 0, moyenne = 0;

		if (!led.estVide())
		{
			for(int cpt=0;cpt<led.taille();cpt++)
			{
				somme += led.consulter().getMoyenne();
				led.suivant();
			}
			System.out.println ( "Somme : " + String.format( "%.2f",somme)   );

			/*if(!led.estVide())
			{
				led.memoriserCurseur();

				led.positionneDebut();

				while(led.aUnSuivant())
				{
					somme += led.consulter().getMoyenne();
					led.suivant();
				}
				somme += led.consulter().getMoyenne();
			}*/

			moyenne = somme / led.taille();
			System.out.println ( "Moyenne : " + String.format( "%.2f",moyenne)   );


		}
		else
			System.out.println ( "calcul impossible" );
	}

}
