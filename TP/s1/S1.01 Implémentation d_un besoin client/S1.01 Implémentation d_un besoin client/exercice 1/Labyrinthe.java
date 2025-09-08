import java.io.FileInputStream;
import java.util.Scanner;

/**
  * Classe Labyrinthe
  *
  * Exercice 1
  *
  * groupe   : 2
  * @author  : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
  *
  * créée le : 16/12/2024 12h17
  */

public class Labyrinthe
{
	private int      posLig;
	private int      posCol;

	private char[][] grille;

	/*------------------*/
	/*   constructeur   */
	/*------------------*/

	/**
	 * Constructeur de la classe Labyrinthe.
	 * Initialise la grille à partir d'un fichier et positionne le personnage.
	 */
	public Labyrinthe()
	{
		int ligne   = 0;
		int colonne = 0;
		String sLigne;
		char cara;
			
		try
		{
			Scanner sc = new Scanner ( new FileInputStream( "./data/grille.data" ), "UTF8" );

			ligne   = 0 ;
			colonne = 0 ;
			sLigne  = "";

			while (sc.hasNextLine())
			{
				sLigne = sc.nextLine();
				ligne++;
				colonne = Math.max(colonne, sLigne.length());
			}

			sc.close();

			this.grille = new char[ligne][colonne];

			sc = new Scanner ( new FileInputStream( "./data/grille.data" ), "UTF8" );
			
			for (int cptLig = 0; cptLig < ligne; cptLig++)
			{
				sLigne = sc.nextLine();
				for (int cptCol = 0; cptCol < sLigne.length(); cptCol++)
				{
					cara = sLigne.charAt(cptCol);
					this.grille[cptLig][cptCol] = cara;
					if (cara == 'O') 
					{
						this.posLig = cptLig;
						this.posCol = cptCol;
					}
				}
				for (int cptCol = sLigne.length(); cptCol < colonne; cptCol++)
				{
					this.grille[cptLig][cptCol] = ' ';
				}
			}
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	/*-------------------*/
	/*  Autres Methodes  */
	/*-------------------*/
	 
	/**
	 * Déplace le personnage dans la direction spécifiée.
	 * @param dir la direction du déplacement ('N', 'O', 'S', 'E')
	 */
	public void deplacer(char dir)
	{
		switch (dir)
		{
			case 'N':
				if (this.posLig-1 >= 0 &&
				    this.grille[this.posLig-1][this.posCol] != '=')
				{
					this.grille[this.posLig][this.posCol] = ' ';
					this.posLig--;
					this.grille[this.posLig][this.posCol] = 'O';
				}
				break;

			case 'O':
				if (this.posCol-1 >= 0 &&
				    this.grille[this.posLig][this.posCol-1] != '=')
				{
					this.grille[this.posLig][this.posCol] = ' ';
					this.posCol--;
					this.grille[this.posLig][this.posCol] = 'O';
				}
				break;

			case 'S':
				if (this.posLig+1 < this.grille.length &&
				    this.grille[this.posLig+1][this.posCol] != '=')
				{
					this.grille[this.posLig][this.posCol] = ' ';
					this.posLig++;
					this.grille[this.posLig][this.posCol] = 'O';
				}
				break;

			case 'E':
				if (this.posCol+1 < this.grille[this.posLig].length &&
				    this.grille[this.posLig][this.posCol+1] != '=')
				{
					this.grille[this.posLig][this.posCol] = ' ';
					this.posCol++;
					this.grille[this.posLig][this.posCol] = 'O';
				}
				break;
		}
	}

	/**
	 * Retourne une représentation en chaîne de caractères du labyrinthe.
	 * @return la représentation en chaîne de caractères du labyrinthe
	 */
	public String toString()
	{
		String ligne = "+---";
		for (int cpt = 1; cpt < this.grille[0].length; cpt++)
		{
			ligne += "+---";
		}

		ligne += "+";
		String res = ligne + "\n";

		for (int cptLig = 0; cptLig < this.grille.length; cptLig++)
		{
			res += "|";
			for (int cptCol = 0; cptCol < this.grille[cptLig].length; cptCol++)
			{
				res += " " + this.grille[cptLig][cptCol] + " |";
			}
			res += "\n" + ligne + "\n";
		}

		return res;
	}

}