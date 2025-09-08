/** Classe Circuit
  * permet de tester la progression de 2 Vehicules
  * @author Philippe Le Pivert
  */
public class Circuit
{
	public static void main(String[] a)
	{
		/*-------------------*/
		/* variables         */
		/*-------------------*/
		Vehicule v1, v2;
		int      cpt;

		/*-------------------*/
		/* instructions      */
		/*-------------------*/
		v1 = new Vehicule ();
		v2 = new Vehicule ();

		v1.contact();
		v1.avancer();
		v1.avancer();

		v1.contact();

		System.out.println ( "     v1 : " + v1 + "   v2 : " + v2 );

		for (cpt=0; cpt<20; cpt ++)
		{
			if ( cpt%5 == 0 ){ System.out.println ("     v1 contact" ); v1.contact(); }
			if ( cpt%3 == 0 ){ System.out.println ("     v2 contact" ); v2.contact(); }

			v1.avancer();
			v2.avancer();

			System.out.println ( String.format("%2d",cpt) + "   v1 : " + v1 + "   v2 : " + v2 );

			try{Thread.sleep(500);}catch(Exception e){}
		}

	}

}