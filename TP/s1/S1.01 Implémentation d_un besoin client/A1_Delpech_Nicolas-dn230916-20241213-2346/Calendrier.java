/**
 *@author : Delpech Nicolas
 *@version: 1.0
 * Calendrier
 */

public class Calendrier
{
	private int jour  = 0;
	private int mois  = 1;
	private int annee = 1900;
	
	public Calendrier(int jour)
	{
		int cptMois;
		int[] tabJour;
		
		tabJour = Calendrier.tabJour(this.annee);
		
		cptMois = 1;
		for(int cptJour=1; cptJour <= jour ; cptJour++)
		{
			this.jour += cptJour;

			if(cptJour == tabJour[cptMois])
			{
				this.jour = 1;
				cptMois++;
				this.mois  = cptMois;
			}
			
			if(cptMois == 12)
			{
				this.annee = this.annee + 1;
				this.jour = 1;
				cptMois = 1;
				this.mois = cptMois;
				
				tabJour = Calendrier.tabJour(this.annee);
			}
		}
	}
	
	public static boolean estBissextiles(int annee)
	{
		if(annee % 4 == 0 && (annee / 100 == 1 || annee % 400 ==0 ))
		{
			return true;
		}
		return false;
	}
	
	public static int dureeAnne(int annee)
	{
		if(Calendrier.estBissextiles(annee))
		{
			return 366;
		}
		return 365;
	}
	
	public static int dureeMois(int annee, int mois)
	{
		int[] tabJour;
		tabJour = Calendrier.tabJour(annee);
		
		return tabJour[mois];
	}
	
	public static int[] tabJour(int annee)
	{
		int[] tabJour;
		int[] tabMois;
		
		tabJour = new int[13];
		tabMois = new int[13];
		
		for(int cptmois=1; cptmois <= 12 ; cptmois++)
		{
			tabMois[cptmois] = cptmois;
			
			if(cptmois % 3 == 1 || cptmois == 1)
			{
				tabJour[cptmois] = 31;
			}
			else
			{
				if(tabMois[cptmois] == 2)
				{
					if(Calendrier.estBissextiles(annee))
					{
						tabJour[cptmois] = 29;
					}
					else
					{
						tabJour[cptmois] = 28;
					}
				}
				else
				{
					tabJour[cptmois] = 30;
				}
			}
		}
		
		return tabJour;
	}
	
	public static int[] jour2Date(int nbJour)
	{
		return null;
		
	}
	public String toString()
	{
		return this.jour + "/" + this.mois + "/" + this.annee;
	}
}
