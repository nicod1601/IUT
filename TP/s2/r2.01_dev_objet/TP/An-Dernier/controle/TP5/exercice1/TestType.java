public class TestType
{
	public static void main(String[] a)
	{

		/*---------------*/
		/*   Données     */
		/*---------------*/
		double petitDouble;
		Double grandDouble;

		float   petitFloat;
		Float   grandFloat;

		String  uneChaine;

		/*---------------*/
		/* Instructions  */
		/*---------------*/

		/* --------------------------------------------------------------- */
		/*   1.1 : Affecter un Double dans un double                       */
		/* --------------------------------------------------------------- */
		System.out.println ( "\n** 1.1 **");

		grandDouble = 1853.2541;

		petitDouble = grandDouble;
		petitDouble = grandDouble.doubleValue();  // autre possibilité que nous pouvons aujourd'hui oublié
																// graçe au mécanisme d'auto-boxing

		petitDouble = (double) grandDouble;			// un pau alambiqué, mais pourquoi pas

		System.out.println ( "a " + grandDouble );
		System.out.println ( "b " + petitDouble );


		/* --------------------------------------------------------------- */
		/*   1.2  Affecter un double dans un Double                        */
		/* --------------------------------------------------------------- */
		System.out.println ( "\n** 1.2 **" );

		// on vient déjà de le faire à la ligne 26 du programme
		petitDouble = 156.23;

		grandDouble = petitDouble;
		// grandDouble = new Double (petitDouble);   impossible deprecated
		grandDouble = Double.valueOf ( petitDouble );		// certes stylé, mais l'auto-boxing nous convient parfaitement


		System.out.println ( "a " + grandDouble );
		System.out.println ( "b " + petitDouble );


		/* ---------------------------------------------------------------- */
		/*   1.3  Affecter un String "12.4" dans un double                  */
		/* ---------------------------------------------------------------- */
		System.out.println ( "\n** 1.3 **" );

		uneChaine = "12.4";

		petitDouble = Double.parseDouble ( uneChaine );
		System.out.println ( "a " + petitDouble );

		// Nous pourrions également passer par la méthode de classe Double valueOf ( double d )
		// Mais celle ne renvoit pas un double mais un Double, ce qui provoque un traitement
		// supplémentaire d'autoboxing
		petitDouble = Double.valueOf ( uneChaine );
		System.out.println ( "a " + petitDouble );



		// Version Hors-Piste en cas de chaine invalide

		uneChaine = "12.4A";

		try
		{
			petitDouble = Double.parseDouble ( uneChaine );
		}
		catch ( Exception e)
		{
			System.out.println ( "  votre chaine ne correspond pas à un double, \n  votre double reçoit arbitrairement la valeur 0" );
			petitDouble = 0.0;
		}

		System.out.println ( "c " + petitDouble );


		/* ---------------------------------------------------------------- */
		/*   1.4  Affecter un String "12.4" dans un Double                  */
		/* ---------------------------------------------------------------- */
		System.out.println ( "\n** 1.4 **" );

		uneChaine = "12.4";
		//grandDouble = new Double (uneChaine);   impossible deprecated, et est également remplacé par valueOf

		// on pourrait comme à la question précédente passer par parseDouble, mais cette fois-ci c'est valueOf
		// qui est la plus adaptée, car retroune diretemet un Double
		grandDouble = Double.valueOf ( uneChaine );
		System.out.println ( "a " + grandDouble );


		/* ---------------------------------------------------------------- */
		/*   1.5  Affecter un Double dans un String                         */
		/* ---------------------------------------------------------------- */
		System.out.println ( "\n** 1.5 **" );

		grandDouble = 159.951;

		uneChaine = grandDouble.toString();		// version la plus adaptée
		System.out.println ( "a " + uneChaine );


		uneChaine = "" + grandDouble;				// version peu élégante mais qui fonctionne
		System.out.println ( "b " + uneChaine );

		/* ---------------------------------------------------------------- */
		/*   1.6  Affecter un double dans un String                         */
		/* ---------------------------------------------------------------- */
		System.out.println ( "\n** 1.6 **" );

		petitDouble = 357.756;
		uneChaine = Double.toString ( petitDouble ); // version la plus adaptée
		System.out.println ( "a " + uneChaine );

		uneChaine = String.valueOf  ( petitDouble );
		System.out.println ( "b " + uneChaine );

		uneChaine = petitDouble + "";                // version peu élégante mais qui fonctionne
		System.out.println ( "c " + uneChaine );

		// un autre moyen consiterait à utilser String.format
		uneChaine = String.format ( "%f", petitDouble );
		System.out.println ( "d " + uneChaine );

		// Il est recommandé de mettre une précision, (voir peutêtre une largeur cf fiche complémentaire)
		// Notez au passage l'arrondi.
		uneChaine = String.format ( "%.2f", petitDouble );
		System.out.println ( "e " + uneChaine );


		// un Moyen un peu plus alambiqué :
		uneChaine = Double.valueOf ( petitDouble ).toString();
		System.out.println ( "f " + uneChaine );


		/* ------------------------------------------------------------------ */
		/*   1.7  Affecter un float dans un Double                            */
		/* ------------------------------------------------------------------ */
		System.out.println ( "\n** 1.7 **" );

		petitFloat = 1.1f;                            // /!\ bien mettre le f pour indiquer qu'il s'agit d'un littéral float
				                                        // (sinon sans f il s'agit d'un littéral double)

		//grandDouble = petitFloat;                   // l'auto-boxing ne fonctionne qu'entre un type primitif et son type enveloppe (Wrapper)

		// solution 1
		petitDouble = petitFloat;
		grandDouble = petitDouble;
		System.out.println ( "a " + grandDouble );

		// solution 2
		grandDouble = (double) petitFloat;
		System.out.println ( "b " + grandDouble );


		// Nous éviterons de repasser par une chaine intermédiaire


		/* ------------------------------------------------------------------- */
		//*   1.8  Affecter un Double dans un float                            */
		/* ------------------------------------------------------------------- */
		System.out.println ( "\n** 1.8 **" );

		grandDouble = 1234567890123.1234567890123;

		System.out.println ( "a " + grandDouble );  // notez bien le résultat

		petitFloat = (float) grandDouble.doubleValue();
		System.out.println ( "b " + petitFloat );

		petitFloat = (float) (double) grandDouble;
		System.out.println ( "c " + petitFloat );


	}

}