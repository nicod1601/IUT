/*--------------------------------------------------------------------*/
/*- Classe Jeu : Gere les comportement de l'enemie                   .*/
/*- Exercice 5                                                        */
/*- Le groupe 1	                                                      */
/*- Audric                                                            */
/*- 19/12/2024 22:30                                                  */
/*--------------------------------------------------------------------*/

public class Ennemi
{
	private int posLig;
	private int posCol;
	private int delay ;


	/*-------------------------------*/
	/* Creer un Ennemi               */
	/*-------------------------------*/
	public Ennemi(int lig,int col)
	{
		this.posLig = lig;
		this.posCol = col;
	}

	public int getPosLig() {return this.posLig;}
	public int getPosCol() {return this.posCol;}
	public int getTemps () {return this.delay ;}


	/*---------------------------------*/
	/* Deplace le monstre              */
	/*---------------------------------*/
	public void deplacer(char direction,int taille)
	{
		if (!delayReduire())
		{
			if (direction == 'G') this.posCol = (taille + this.posCol-1) % taille;
			if (direction == 'D') this.posCol = (taille + this.posCol+1) % taille;
			this.delay = 20;
		} 
	}

	/*---------------------------------*/
	/* Ajoute un delay pour eviter que */
	/* le monstre bouge trop vide      */
	/*---------------------------------*/
	public boolean delayReduire()
	{
		this.delay--;
		return this.delay >= 0;
	}
}