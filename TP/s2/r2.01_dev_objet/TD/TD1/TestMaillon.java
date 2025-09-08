public class TestMaillon
{
	public static void main(String[] args)
	{
		Maillon m;

		m = new Maillon(1, null);
		m = new Maillon(10, m);

		System.out.println(m.getValeur());
		System.out.println(m.getDessous().getValeur());
	}
}
