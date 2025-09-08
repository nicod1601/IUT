public class Maillon
{
	private Maillon dessous;
	private int elt;
	
	public Maillon(int e, Maillon d)
	{
		this.elt = e;
		this.dessous = d;
	}
	
	public int getValeur()
	{
		return this.elt;
	}

	public Maillon getDessous()
	{
		return this.dessous;
	}
}