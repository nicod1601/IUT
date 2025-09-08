import pac.emballage.Cube;
import pac.emballage.Cylindre;
import pac.emballage.PrismeHexa;

public class Test12
{
	public static void main (String[] a)
	{
		Cube       cub =  new Cube       ( 18.8, 20.0 );
		Cylindre   cyl =  new Cylindre   ( 14.8, 15.0, 25.8, 26.0 );
		PrismeHexa pri =  new PrismeHexa ( 14.8, 15.0, 25.8, 26.0 );

		System.out.println ( "Cube       surface externe : " + cub.getSurfaceExterne() );
		System.out.println ( "Cube       surface interne : " + cub.getSurfaceInterne() );
		System.out.println ( "Cube       volume  externe : " + cub.getVolumeExterne () );
		System.out.println ( "Cube       volume  interne : " + cub.getVolumeInterne () );

		System.out.println ();

		System.out.println ( "Cylindre   surface externe : " + cyl.getSurfaceExterne() );
		System.out.println ( "Cylindre   surface interne : " + cyl.getSurfaceInterne() );
		System.out.println ( "Cylindre   volume  externe : " + cyl.getVolumeExterne () );
		System.out.println ( "Cylindre   volume  interne : " + cyl.getVolumeInterne () );

		System.out.println ();

		System.out.println ( "PrismeHexa surface externe : " + pri.getSurfaceExterne() );
		System.out.println ( "PrismeHexa surface interne : " + pri.getSurfaceInterne() );
		System.out.println ( "PrismeHexa volume  externe : " + pri.getVolumeExterne () );
		System.out.println ( "PrismeHexa volume  interne : " + pri.getVolumeInterne () );
	}
}
