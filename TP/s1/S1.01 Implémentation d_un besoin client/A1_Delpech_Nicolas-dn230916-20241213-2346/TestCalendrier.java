public class TestCalendrier
{
	public static void main(String[] a)
	{
		/*-----------------------*/
		/*        Donnée         */
		/*-----------------------*/
		Calendrier calendrier;
		int nbJourAnnee, nbJourMois;
		
		long debut,fin;
		
		/*-----------------------*/
		/*      Instruction      */
		/*-----------------------*/
		
		/*-----------------------------------*/
		/*      Création des calendrier      */
		/*-----------------------------------*/
		debut = System.nanoTime();
		calendrier = new Calendrier(1);
		fin = System.nanoTime();
		
		System.out.println(calendrier );
		System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
		
		debut = System.nanoTime();
		calendrier = new Calendrier(32);
		fin = System.nanoTime();
		
		System.out.println(calendrier );
		System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
		
		debut = System.nanoTime();
		calendrier = new Calendrier(60);
		fin = System.nanoTime();
		
		System.out.println(calendrier );
		System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
		
		debut = System.nanoTime();
		calendrier = new Calendrier(366);
		fin = System.nanoTime();
		
		System.out.println(calendrier );
		System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
		
		/*--------------------------------------------*/
		/*      Test de la méthode estBissextiles     */
		/*--------------------------------------------*/
		for(int cpt=0;cpt < 20; cpt++)
		{
			debut = System.nanoTime();
			Calendrier.estBissextiles(2000 + cpt);
			fin = System.nanoTime();
			System.out.println(Calendrier.estBissextiles(1900 + cpt));
			System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
		}
		
		
		debut = System.nanoTime();
		nbJourMois = Calendrier.dureeMois(1992,2);
		fin = System.nanoTime();
		System.out.println(nbJourMois);
		System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
		
		
	}
}
