public class TestArticles
{
	public static void main (String[] args)
	{
		Article           art1= new Article();
		ArticlePerissable art2= new ArticlePerissable();


		art1.setReference   ( 10239102 );
		art1.setDesignation ( "Livre"  );
		art1.setPrix        ( 12.3     );

		art2.setReference   ( 10382034     );
		art2.setDesignation ( "Conserve"   );
		art2.setPrix        ( 6.5          );
		art2.setDatePerim   ( "12/12/2015" );


		System.out.println  ( "["                       +
		                      art1.getReference()       +
		                      " "                       +
		                      art1.getDesignation()     +
		                      " "                       +
		                      art1.getPrix() + " euros" +
		                      "]"
		                    );

		System.out.println ();

		System.out.println  ( "["                       +
							  art2.getReference()       +
							  " "                       +
							  art2.getDesignation()     +
							  " "                       +
							  art2.getPrix() + " euros" +
							  " "                       +
							  art2.getDatePerim()       +
							  "]"
							);
	}
}