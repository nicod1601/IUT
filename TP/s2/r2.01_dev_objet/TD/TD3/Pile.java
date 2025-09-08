public class Pile
{
	private char[] ensCarac;
	private int    sommet;
	
	public Pile(int nbEltTot)
	{
		this.ensCarac = new char[nbEltTot];
		this.sommet   = 0;
	}
	
	public Pile(Pile p)
	{
		this.ensCarac = new char[p.ensCarac.length];
		this.sommet   = p.sommet;
		
		for(int cpt = 0; cpt < this.ensCarac.length; cpt++)
		{
			this.ensCarac[cpt] = p.ensCarac[cpt];
		}
	}
	
	public boolean estVide()
	{
		return this.sommet == 0;
	}
	
	public boolean estPlein()
	{
		return this.sommet == this.ensCarac.length;
	}
	
	public boolean empiler(char c)
	{
		if(this.estPlein()){return false;}
		
		this.ensCarac[this.sommet++] = c;
		return true;
	}
	
	public char depiler()
	{
		if(!this.estVide())
		{
			return ensCarac[this.sommet--];
		}
		return ' ';
	}
	
	public void retourner()
	{
		char tmp;
		int n = this.sommet;

		for(int cpt = 0; cpt < n / 2; cpt++)
		{
		    tmp = this.ensCarac[cpt];
		    this.ensCarac[cpt] = this.ensCarac[n - 1 - cpt];
		    this.ensCarac[n - 1 - cpt] = tmp;
		}

		/*autre solution */
		/* dépiler la pile et de remettre dans l'ordre mais en retourner */


	}
	
	public String toString()
	{
		String sRet="";
		
		/*for(int cpt = 0; cpt < this.ensCarac.length; cpt++)
		{
			sRet += "| "+ this.ensCarac[ this.ensCarac.length - 1 -cpt] + " |" + "\n";
		}
		sRet += " __";*/

		for(int cpt = 0; cpt < this.sommet; cpt++)
		{
			sRet += this.ensCarac[cpt] + " ";
		}
		
		return sRet;
	}
	
	public static void main(String[] a )
	{
		Pile p;
		p = new Pile(4);
		p.empiler('A');
		p.empiler('C');
		p.empiler('E');
		p.empiler('D');
		
		p.retourner();
		
		System.out.println(p);
		p.retourner();
		System.out.println(p);
		System.out.println(p.estVide());
	}
}
