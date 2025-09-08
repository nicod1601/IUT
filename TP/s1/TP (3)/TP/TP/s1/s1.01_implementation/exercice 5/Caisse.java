/*--------------------------------------------------------------------*/
/*- Classe Jeu : Gere les comportement des caisse                    .*/
/*- Exercice 5                                                        */
/*- Le groupe 1	                                                      */
/*- Audric                                                            */
/*- 18/12/2024 22:30                                                  */
/*--------------------------------------------------------------------*/

public class Caisse
{
	private int posLig;
	private int posCol;

	/*-------------------------------*/
	/* Creer une caisse              */
	/*-------------------------------*/
	public Caisse(int lig,int col)
	{
		this.posLig = lig;
		this.posCol = col;
	}

	public int getPosLig() {return this.posLig;}
	public int getPosCol() {return this.posCol;}


	/*-------------------------------*/
	/* Deplace la caisse             */
	/*-------------------------------*/
	public void deplacer(char direction,int taille)
	{
		if (direction == 'G') this.posCol = (taille + this.posCol-1) % taille;
		if (direction == 'D') this.posCol = (taille + this.posCol+1) % taille;
	}

	/*---------------------------------*/
	/* Applique la gravité a la caisse */
	/*---------------------------------*/
	public void graviterCaisse(){this.posLig++;}
}