public class Calendrier
{
	private int annee;
	private int mois ;
	private int jour ;

	public Calendrier(int annee, int mois, int jour)
	{
		this.annee = annee;
		this.mois = mois;
		this.jour = jour;
	}

	public Calendrier(int jour)
	{
		this.jour = jour;
	}

	/*Accesseurs */
	public int getAnnee(){return annee;}
	public int getMois(){return mois;}
	public int getJour(){return jour;}

	/*Modificateurs */
	public void setAnnee(int annee){this.annee = annee;}
	public void setMois(int mois){this.mois = mois;}
	public void setJour(int jour){this.jour = jour;}

	/*Methode */
	

}