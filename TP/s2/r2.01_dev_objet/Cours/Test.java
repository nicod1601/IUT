public class Test
{
	private static int cpt = 0;
	private int num;
	private String nom;

	public Test(int num, String nom)
	{
		if(! nom.equals("test"))
		{
			this = null;
		}
		this.num = num;
		this.nom = nom;

		//Test.cpt = ++Test.cpt;
		++Test.cpt;
	}

	public String toString()
	{
		if(this == null)
		{
			return "null";
		}
		return this.num + " " + this.nom + " " + Test.cpt;
	}

	public static void main(String[] args)
	{
		Test t = new Test(2, "test");
		Test t2 = new Test(1, "caca");
		System.out.println(t);
		System.out.println(t2);
	}
}


