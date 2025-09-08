public class Maillon
{
	private Colis   colis;
	private Maillon suivant;
	
	public Maillon(Colis colis)
	{
		this.colis   = colis;
		this.suivant = null;
	}
	
	public void setSuivant(Maillon mail)
	{
		this.suivant = mail;
	}
	
	public Colis   getColis()  { return this.colis  ;}
	public Maillon getSuivant(){ return this.suivant;}
}
