import arbre.Personne;

public class TestPersonne 
{
	public static void main(String[] a)
	{
		Personne arth, uther, ygraine;

		arth = new Personne('M',"Arthur");
		uther = new Personne('M', "Uther");
		ygraine = new Personne('F', "Ygraine");

		arth.setParents(uther,ygraine);

		System.out.println(arth);
		System.out.println(uther);
		System.out.println(ygraine);
	
	}
}
