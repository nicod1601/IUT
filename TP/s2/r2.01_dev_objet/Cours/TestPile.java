public class TestPile 
{
	public static void main(String[] args)
	{
		Pile pile = new Pile();

		pile.empiler('A');

		System.out.println(TestPile.afficherPile(pile));

		pile.empiler('B');
		pile.empiler('C');

		System.out.println(TestPile.afficherPile(pile));
	}
	public static String afficherPile(Pile p)
	{
		String sRet="";

		for(int cpt = 0; cpt < p.tabCara.length; cpt++)
		{
			sRet += p.tabCara[cpt] + " ";
		}
		return sRet;
	}
}
