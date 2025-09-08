public class Pile
{
	private static final int TAILLE = 100;
	private int sommet;
	private char tab[];

	public Pile()
	{
		this.sommet = 0;
		this.tab = new char[Pile.TAILLE];
	}

	public int getSommet()
	{
		return this.sommet;
	}

	public boolean estVide()
	{
		return this.sommet == 0;
	}

	public boolean empiler(char c)
	{
		if(this.sommet == this.tab.length)
		{
			return false;
		}

		this.tab[++this.sommet] = c;
		return true;
	}

	public void supprimer()
	{
		if(! this.estVide())
		{
			this.sommet--;
		}
	}

	public char consulter()
	{
		return this.tab[this.sommet ];
	}

	public char depiler()
	{
		return this.tab[--this.sommet];
	}

	public static void main(String[] args)
	{
		Pile p = new Pile();
		System.out.println(p.estVide());
		System.out.println(" " + p.getSommet());
		p.empiler('a');
		System.out.println(" " + p.getSommet());
		p.empiler('b');
		System.out.println(" " + p.getSommet());
		p.empiler('c');
		System.out.println(" " + p.getSommet());
		System.out.println(p.consulter());

		p.supprimer();
		System.out.println(" " + p.getSommet());
		System.out.println(p.consulter());
	}
}