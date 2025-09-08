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

		ensRegions[0]      = new Region (76, "Normandie", 2);
		ensDepartements[0] = new Departement ("75206", "audric"  , 500000, 98541);
		ensDepartements[1] = new Departement ("75204", "paul"    , 250000, 36521);
		ensDepartements[2] = new Departement ("41505", "valentin", 622841, 54125);



		ensRegions[1]      = new Region (75, "Ile de France", 4);
		ensDepartements[3] = new Departement ("95822", "jojo", 647512, 52555);
		ensDepartements[4] = new Departement ("41111", "toto", 685142, 66242);
		ensDepartements[5] = new Departement ("69696", "soso", 952541, 74522);


		ensRegions[0].ajouterDepartement ( ensDepartements[0] );
		ensRegions[0].ajouterDepartement ( ensDepartements[1] );
		ensRegions[0].ajouterDepartement ( ensDepartements[2] );
		
		ensRegions[0].ajouterDepartement ( ensDepartements[0] );

		ensRegions[1].ajouterDepartement ( ensDepartements[3] );
		ensRegions[1].ajouterDepartement ( ensDepartements[4] );
		ensRegions[1].ajouterDepartement ( ensDepartements[5] );
		
		


		Console.println ( ensRegions[0] );
		Console.println ( ensRegions[1] );
		
		System.out.println(TestRegion.rechercherDept(ensDepartements,"41111"));
	}
	
	private static Departement rechercherDept (Departement[] tab, String numero)
	{
		for(Departement d : tab)
		{
			if(d == null){ return null;}
		
			if(d.getNumero().equals(numero))
			{
				return d;
			}
		}
		return null;
	}

}
