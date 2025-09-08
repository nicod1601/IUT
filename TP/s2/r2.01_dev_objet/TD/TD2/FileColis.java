public class FileColis
{
	private Maillon tete;
	private Maillon queue;
	
	public FileColis()
	{
		this.tete = this.queue = null;
	}
	
	public void enfiler(Colis nvColis)
	{
		Maillon nvMaillon = new Maillon(nvColis);
		
		if( this.estVide())
		{
			this.tete = this.queue = nvMaillon;
		}	
		else
		{
			this.queue.setSuivant(nvMaillon);
			this.queue = nvMaillon;
		}
	}
	
	public Colis getTete()
	{ 
		if( ! this.estVide() )
			return this.tete.getColis() ;
		
		return null;
	}
	
	public void supprimer()
	{
		if( this.estVide() ) return;
		
		if(this.tete == this.queue)
		{
			this.tete = this.queue = null;
		}
		else
		{
			this.tete = this.tete.getSuivant();
		}
	}
	
	public boolean estVide()
	{
		return this.tete == null && this.queue == null;
	}
	
	public String toString()
	{
		String sRet = "";
		
		Maillon mail = this.tete;
		while( mail != null )
		{
			sRet += mail.getColis();
			mail = mail.getSuivant();
		}
		
		return sRet;
		
	}
	
	public static void main(String[] a)
	{
		FileColis fc = new FileColis();
		fc.enfiler(new Colis('A'));
		fc.enfiler(new Colis('B'));
		fc.enfiler(new Colis('C'));
		fc.enfiler(new Colis('D'));
		System.out.println(fc);
	}
}
