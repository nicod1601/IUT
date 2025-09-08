import iut.algo.Clavier;

/** Jeu du Verger 
  * date    : 29/11/2020
  * @author : Delpech Nicolas
  */

public class Verger
{
	public static void main(String[] a)
	{
		/*---------------*/
		/*   Données     */
		/*---------------*/
		char[][] plateau;
		int      posLig, posCol;
		int      nbPommes;

		char     dir;
		
		char tmp;
		int ligRobot, colRobot;
		int score;

		/*---------------*/
		/* Instructions  */
		/*---------------*/

		plateau  = new char[10][10];
		nbPommes = 20;
		posLig   = posCol = 0;

		Verger.initialiserPlateau ( plateau, nbPommes );

		System.out.println ( Verger.toString (plateau, posLig, posCol) );

		score = 0;
		while ( score != nbPommes )
		{
			System.out.print ( "Direction ( N O S E ) : " );
			dir = Clavier.lire_char();


			// Attention les 2 lignes suivantes ne fonctionnent que pour un tablier de 10x10
			// modifiez le code pour qu'il s'adapte à n'importe quelle taille de tablier
			posLig = Verger.deplacerLig ( posLig, dir, 10 );
			posCol = Verger.deplacerCol ( posCol, dir, 10 );
			
			ligRobot = colRobot = 0;


			for(int lig=0; lig < plateau.length ; lig++)
			{
				for(int col=0; col < plateau[lig].length ; col++)
				{
					if(plateau[lig][col] == 'X')
					{
						ligRobot = lig; // récupération de la ligne du robot
						colRobot = col; // récupération de la colonne du robot
					}
				}
			}

			// vérfication si on tombe sur une pomme ou pas 
			if(plateau[posCol ][posLig] == '.')
			{
				tmp = plateau[posCol ][posLig];
				plateau[posCol][posLig] = plateau[ligRobot][colRobot];
				plateau[ligRobot][colRobot] = tmp;
				
			}
			else
			{
			
				tmp = '.';
				plateau[posCol][posLig] = plateau[ligRobot][colRobot];
				plateau[ligRobot][colRobot] = tmp;
				
				score++; // compteur pour les pommes qu'on ramasse
			}

			System.out.println ( Verger.toString (plateau, posLig, posCol) );
		}
	}


	/** Cette méthode positionne strictement nbPommes pommes de façon aléatoire dans le verger.
	  * @param plateau tablier matérialisant le verger
	  * @param nbPommes nombre de pommes à positionner dans le verger
	  */
	public static void initialiserPlateau ( char[][] plateau, int nbPommes )
	{
		/*---------------*/
		/*   Données     */
		/*---------------*/
		int ligP;
		int colP;
		int cpt;
		
		/*---------------*/
		/* Instructions  */
		/*---------------*/
		
		for(int lig=0; lig < plateau.length; lig++)
		{
			for(int col=0; col < plateau[lig].length; col++)
			{
				if(lig == 0 && col == 0)
				{
					plateau[lig][col] = 'X';
				}
				else
				{
					plateau[lig][col] = '.';
				}
				
			}
		}
		
		cpt = 0;
		while(cpt < nbPommes)
		{
			ligP = (int) (Math.random()*plateau.length);
			colP = (int) (Math.random()*plateau[0].length);

			if(plateau[ligP][colP] == '.')
			{
				if(ligP != 0 || colP != 0)
				{
					plateau[ligP][colP] = 'O';
					cpt++;
				}
				
			}
		}

	}

	/** Cette méthode retourne sous forme textuelle le contenu du verger
	  * afin qu'il soit affiché.
	  * @param plateau tablier matérialisant le verger
	  * @param posLig  ligne   sur laquelle le robot est positionné
	  * @param posCol  colonne sur laquelle le robot est positionné
	  * @return chaine reprsentant sous forme textuelle le verger
	  */
	public static String toString(char[][] plateau, int posLig, int posCol)
	{
		// Attention le code fourni de cette méthode ne fonctionne qu'avec un plateau de
		// 10x10, il faudra le modifier pour qu'il s'adpate automatiquemen à n'importe
		// quelle taille
		/*---------------*/
		/*   Données     */
		/*---------------*/
		int lig, col;
		int nbPommeCol;
		int nbPommeLig;
		
		/*---------------*/
		/* Instructions  */
		/*---------------*/
		
		nbPommeLig =0;
		nbPommeCol =0;
		String sRet = "";

		System.out.print("     ");
		for(int cpt=0; cpt < plateau.length; cpt++)
		{
			nbPommeCol = nbPommeDansCol(plateau,cpt);
			System.out.print(nbPommeCol + "   ");
		}
		sRet += "\n";
		sRet += "   +" + "----".repeat(plateau[0].length) + "+";
		sRet += "\n";
		for (lig=0;lig<10; lig++)
		{
			nbPommeLig = nbPommeDansLig(plateau,lig);
			sRet += " "+ nbPommeLig + " |";
			for (col=0;col<10; col++)
			{
				if(posLig == col && posCol == lig)
				{
					sRet += " "+ 'X' + "  ";
				}
				else
				{
					sRet += " "+ plateau[lig][col] + "  ";
				}
				
				
			}
			sRet += "|";
			sRet += "\n";
			sRet += "   +" + "----".repeat(plateau[0].length) + "+" + "\n";
		}

		return sRet;
	}


	/** Cette méthode retourne le nombre de pommes présentes dans la
	  * colonne col du plateau
	  * @param plateau tablier matérialisant le verger
	  * @param col     colonne dans laquelle il faut compter le nombre de pommes
	  * @return nombre de pommes présentes sur la colonne col
	  */
	public static int  nbPommeDansCol ( char[][] plateau,  int col )
	{
		int cptPomme;
		
		cptPomme =0;
		for(int lig=0; lig < plateau.length; lig++)
		{
			if(plateau[lig][col] == 'O')
			{
				cptPomme++;
			}
		}
		return cptPomme;
	}


	/** Cette méthode retourne le nombre de pommes présente dans la
	  * ligne lig du plateau
	  * @param plateau tablier matérialisant le verger
	  * @param lig     ligne sur laquelle il faut compter le nombre de pommes
	  * @return nombre de pommes présentes sur laligne lig
	  */
	public static int  nbPommeDansLig ( char[][] plateau, int lig )
	{
		int cptPomme;
		
		cptPomme =0;
		for(int col=0; col < plateau[0].length; col++)
		{
			if(plateau[lig][col] == 'O')
			{
				cptPomme++;
			}
		}
		return cptPomme;
	}


	/** Cette méthode retourne la nouvelle posLig du Robot en fonction de la direction
	  * @param posLig   ligne actuelle du robot
	  * @param dir      direction dans laquelle on tente de déplacer le robot
	  * @param nbLignes nombre de lignes du tablier
	  * @return nouvelle ligne du robot
	  */
	public static int deplacerLig ( int posLig, char dir, int nbLignes )
	{
		if(dir == 'E' && posLig >= 0 && posLig != nbLignes - 1 )
		{
			posLig++;
		}
		
		if(dir == 'O'  && posLig > 0 && posLig != nbLignes)
		{
			posLig--;
		}
		return posLig;
	}

	/** Cette méthode retourne la nouvelle posCol du Robot en fonction de la direction
	  * @param posCol     colonne actuelle du robot
	  * @param dir        direction dans laquelle on tente de déplacer le robot
	  * @param nbColonnes nombre de lignes du tablier
	  * @return nouvelle colonne du robot
	  */
	public static int deplacerCol ( int posCol, char dir, int nbColonnes )
	{
		if(dir == 'N' && posCol > 0 && posCol <= nbColonnes)
		{
			posCol--;
		}
		
		if(dir == 'S'  && posCol >= 0 && posCol != nbColonnes - 1)
		{
			posCol++;
		}
		return posCol;
	}

}
