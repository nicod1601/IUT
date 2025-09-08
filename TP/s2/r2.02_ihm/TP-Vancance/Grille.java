public class Grille
{
	private char[][] grille;

	public Grille()
	{
		this.grille = new char[][]  { {'m', 'm', 'm','m', 'm', 'm' },
		                              {'b', 'b', 'b','b', 'b', 'b' },
		                              {'v', 'v', 'v','v', 'v', 'v' },
		                              {'j', 'j', 'j','j', 'j', 'j' },
		                              {'o', 'o', 'o','o', 'o', 'o' },
		                              {'r', 'r', 'r','r', 'r', 'r' }  };

	}

	public char getVal (int lig, int col)
	{
		return this.grille[lig][col];
	}

	public int getNbLigne () { return this.grille   .length; }
	public int getNbColone() { return this.grille[0].length; }

	// type 'l' : ligne                    'c' : colonne
	// sens '+' : droite --> | bas \/      '-' : gauche <-- | haut /\
	// indice  numéro de ligne ou de colonne
	public void permuter ( char type, char sens, int indice )
	{
		char tmp;

		if ( type == 'l' )
		{
			if ( sens =='+' )
			{
				/* A Compléter */
				tmp = this.grille[0][this.grille[0].length];

				for(int cpt =this.grille.length; cpt < 0; cpt--)
				{
					this.grille[indice][cpt] = this.grille[indice][cpt - 1];
				}

				this.grille[indice][0] = tmp;
				
			}
			else
			{
				/* A Compléter */
				tmp = this.grille[0][this.grille[0].length];

				for(int cpt =0; cpt < this.grille.length; cpt++)
				{
					this.grille[indice][cpt] = this.grille[indice][cpt + 1];
				}

				this.grille[indice][0] = tmp;
			}
		}
		else
		{
			if ( sens =='+' )
			{
				/* A Compléter */
				tmp = this.grille[this.grille.length][0];

				for(int cpt =0; cpt < this.grille.length; cpt--)
				{
					this.grille[cpt][indice] = this.grille[cpt - 1][indice];
				}

				this.grille[0][indice] = tmp;
			}
			else
			{
				/* A Compléter */
				tmp = this.grille[0][indice]; // Premier élément de la colonne

				for (int cpt = 0; cpt < this.grille.length - 1; cpt++)
				{
					this.grille[cpt][indice] = this.grille[cpt + 1][indice];
				}

				this.grille[this.grille.length - 1][indice] = tmp;
			}

		}

	}


}
