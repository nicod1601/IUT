/** Classe Bibliotheque
  * @author Philippe Le Pivert
  */
public class Bibliotheque
{
	public static void main(String[] a)
	{
		/*-------------------*/
		/* variables         */
		/*-------------------*/
		Livre[] ensLivres;


		/*-------------------*/
		/* instructions      */
		/*-------------------*/
		ensLivres = new Livre[5];

		System.out.println ( "il y a eu " + Livre.getNbInstances() + " instance(s) de créée(s)" );

		ensLivres[0] = new Livre ( "Le secret du janissaire"     );
		ensLivres[1] = new Livre ( "Pavillion Noir"              );
		ensLivres[2] = new Livre ( "L'archipel du danger"        );
		ensLivres[3] = new Livre ( "Le Mystère de l'ile étrange" );
		ensLivres[4] = new Livre ( "Jean Sans Lune"              );

		for (int cpt=0; cpt< ensLivres.length; cpt++ )
			System.out.println ( ensLivres[cpt] );

		System.out.println ( "il y a eu " + Livre.getNbInstances() + " instance(s) de créée(s)" );

		ensLivres[0] = new Livre ( "Luna incognita"        );
		ensLivres[1] = new Livre ( "Chasseurs de chimères" );
		ensLivres[2] = new Livre ( "Le Maitre d'armes"     );
		ensLivres[3] = new Livre ( "Revers de fortune"     );
		ensLivres[4] = new Livre ( "De la lune à la terre" );

		for (int cpt=0; cpt< ensLivres.length; cpt++ )
			System.out.println ( ensLivres[cpt] );

		System.out.println ( "il y a eu " + Livre.getNbInstances() + " instance(s) de créée(s)" );


	}

}
