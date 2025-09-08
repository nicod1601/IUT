import java.io.FileInputStream;
import java.util.Scanner;

/**
  * Classe Labyrinthe
  *
  * Exercice 3
  *
  * groupe    : 2
  * @author   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
  *
  * créée le : 16/12/2024 15h37
  */
 
public class Labyrinthe
{
	private int      posLig;
	private int      posCol;

	private int      ligSortie;
	private int      colSortie;

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
		int    ligne;
		int    colonne;
		String sLigne;
		char   cara;
		
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
					this.grille[cptLig][cptCol] = sLigne.charAt(cptCol);

					if (cara == '@') 
					{
						this.ligSortie = cptLig;
						this.colSortie = cptCol;
					}
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

	/*----------------*/
	/*   Accesseurs   */
	/*----------------*/

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int  getNbLignes  ()                 { return this.grille.length;       }

	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int  getNbColonnes()                 { return this.grille[0].length;    }

	/**
	 * Retourne le caractère à la position spécifiée dans la grille.
	 * @param lig la ligne
	 * @param col la colonne
	 * @return le caractère à la position spécifiée
	 */
	public char getCase      (int lig, int col) { return this.grille[lig][col];    }

	/*-------------------*/
	/*  Autres Methodes  */
	/*-------------------*/

	/**
	 * Vérifie si le personnage est à la sortie.
	 * @return true si le personnage est à la sortie, sinon false
	 */
	public boolean estSortie() { return this.posLig == this.ligSortie && this.posCol == this.colSortie;}

	/**
	 * Déplace le personnage dans la direction spécifiée.
	 * @param dir la direction du déplacement ('N', 'O', 'S', 'E')
	 * @param torique indique si le déplacement est torique
	 */
	public void deplacer(char dir, boolean torique)
	{
		int futurLig, futurCol;
		
		futurLig = this.posLig + this.deltaLig(dir);
		futurCol = this.posCol + this.deltaCol(dir);


		if (torique) 
		{
			if( futurLig < 0                         ) futurLig = this.grille.length    -1;
			if( futurLig > this.grille.length -1     ) futurLig = 0;
			
			if( futurCol < 0                         ) futurCol = this.grille[0].length -1;
			if( futurCol > this.grille[0].length -1     ) futurCol = 0; 

			if(this.grille[futurLig][futurCol] == '=')
			{
				futurLig = this.posLig;
				futurCol = this.posCol;
			}
		}
		else 
		{
			if (futurLig < 0 || futurLig >= this.grille.length    ||
				futurCol < 0 || futurCol >= this.grille[0].length ||
				this.grille[futurLig][futurCol] == '=')
			{
				futurLig = this.posLig;
				futurCol = this.posCol;
			}
		}

		this.grille[this.posLig][this.posCol] = ' ';
		this.posLig                           = futurLig;
		this.posCol                           = futurCol;
		this.grille[this.posLig][this.posCol] = 'O';

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

	private int deltaLig(char dir)
	{
		int delta;

		switch (dir)
		{
			case 'N': delta = -1; break;
			case 'S': delta = +1; break;
			default : delta =  0; break;
		}

		return delta;
	}

	private int deltaCol(char dir)
	{
		int delta;

		switch (dir)
		{
			case 'O': delta = -1; break;
			case 'E': delta = +1; break;
			default : delta =  0; break;
		}

		return delta;
	}

}