import java.io.FileInputStream;
import java.util.Scanner;
import iut.algo.Decomposeur;

public class ModeleLectureFichier
{

	private void chargerFichier()
	{
		Decomposeur dec;
		String fichier;

		String num, nom;
		int    population, superficie;

		try
		{
			Scanner sc = new Scanner ( new FileInputStream("xx.data"), "UTF8" );


			int cpt = 0;
			while ( sc.hasNextLine() )
			{
				enreg          = scDept.nextLine ();
				dec            = new Decomposeur ( enreg );

				num            = dec.getString(0);
				nom            = dec.getString(1);
				population     = dec.getInt   (2);
				superficie     = dec.getInt   (3);
			}
			sc.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}

}
