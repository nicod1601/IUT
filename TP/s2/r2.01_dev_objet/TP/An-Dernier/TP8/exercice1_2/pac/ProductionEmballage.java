package pac;
import pac.emballage.*;

public class ProductionEmballage
{
	public static void main (String[] a)
	{
		AtelierPeinture at = new AtelierPeinture ( 20 );

		at.peindre ( new Cube ( 18.8, 20.0 ) );

		System.out.println ( at );

		at.peindre ( new Cube ( 18.8, 20.0 ) );

		System.out.println ( at );

		at.peindre ( new Cylindre ( 14.8, 15.0, 25.8, 26.0 ) );

		System.out.println ( at );

		at.peindre ( new PrismeHexa ( 14.8, 15.0, 25.8, 26.0 ) );

		System.out.println ( at );

	}
}
