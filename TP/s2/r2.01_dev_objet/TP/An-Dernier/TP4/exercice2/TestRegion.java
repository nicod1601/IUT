import iut.algo.Console;

/** TestRegion
  * @author Philippe Le pivert
  */

public class TestRegion
{
	public static void main(String[] a)
	{
		Departement[] ensDepartements = new Departement[ 150  ];   // on prend un nombre suffisament grand
		Region     [] ensRegions      = new Region     [  30  ];   // "    "   "    "        "         "

		ensDepartements[0] = new Departement ("76600", "Haute-Normandie", 250000, 54000);


		ensRegions[0]      = new Region (76, "Normandie", 2);
		ensRegions[1]      = new Region (75, "Ile de France", 4);


		ensRegions[0].ajouterDepartement ( ensDepartements[0] );

		ensRegions[0].ajouterDepartement ( ensDepartements[0] );

		ensRegions[1].ajouterDepartement ( ensDepartements[0] );


		Console.println ( ensRegions[0] );
		Console.println ( ensRegions[1] );
	}

}