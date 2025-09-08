/*----------------------------------------------*/
/*- Gere le labyrinthe                          */
/*- Exercice 3                                  */
/*- Le groupe 1	                                */
/*- Lucas,Theo,Nichita ,Floriane,Audric         */ 
/*- 17/12/2024 8:30                             */
/*----------------------------------------------*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Labyrinthe 
{
	private int posLig;
	private int posCol;
	private int posLigSortie;
	private int posColSortie;

	private char[][] grille;


	/*--------------------------------------------------------------------------*/
	/* Constructeur par défaut qui initialise le labyrinthe depuis un fichier.  */
	/*--------------------------------------------------------------------------*/
	public Labyrinthe() 
	{

		String   sLigne;
		int      nbLig, nbCol;
		int      cptLig;
		
		nbLig = nbCol = 0;

		try
		{
			Scanner sc = new Scanner ( new FileInputStream( "./data/grille.data" ), "UTF8" );
			
			/*---------------------------------------------------*/
			/*          Lecture de la taille du tableau          */
			/*---------------------------------------------------*/
			
			sLigne = "";
			
			while ( sc.hasNextLine() )
			{
				sLigne = sc.nextLine();
				nbLig  ++;
			}
			sc.close();
			
			nbCol = sLigne.length();
		}
		catch(Exception e){ e.printStackTrace(); }
		
		grille = new char[nbLig][nbCol];

		try
		{
			Scanner sc = new Scanner ( new FileInputStream( "./data/grille.data" ), "UTF8" );
				
			cptLig = 0;
			while ( sc.hasNextLine())
			{
				sLigne = sc.nextLine();
				
				for ( int cptCol = 0; cptCol < grille[0].length; cptCol++ )
				{	
					grille[cptLig][cptCol] = sLigne.charAt( cptCol );
					if (sLigne.charAt(cptCol) == 'O')
					{
						this.posLig = cptLig;
						this.posCol = cptCol;

						grille[cptLig][cptCol] = ' ';
					}
					if (sLigne.charAt(cptCol) == '@')
					{
						this.posLigSortie = cptLig;
						this.posColSortie = cptCol;

						grille[cptLig][cptCol] = ' ';
					}
				}
				cptLig++;
			}		
			sc.close();	
		}
		catch(Exception e){ e.printStackTrace();}
		
    }


	public int getNbLignes()   {return this.grille.length; }


	public int getNbColonnes() { return this.grille[0].length; }

	/*-----------------------------------------------------------------------*/
	/* Retourne le contenu de la case spécifiée par les indices lig et col.  */
	/*-----------------------------------------------------------------------*/
    public char getCase(int lig, int col) 
	{
		char valCase;
		valCase = this.grille[lig][col];

		if (lig == this.posLigSortie && col == this.posColSortie) valCase = '@';
		if (lig == this.posLig && col == this.posCol) valCase = 'O';

		return valCase;
	}

	public boolean estSortie() 
	{
		return this.posLig == this.posLigSortie && this.posCol == this.posColSortie;
	}
	
	/*------------------------------------------*/
	/*          Deplacement du Robot            */
	/*------------------------------------------*/
	public void deplacer(char direction) 
	{
		int nouvelleLig, nouvelleCol;
		
		nouvelleLig  = this.posLig;
		nouvelleCol  = this.posCol;

		if (direction == 'N' && nouvelleLig == 0 )
		{
			if(grille[this.grille.length - 1][this.posCol] != '=')
			{	
				this.posLig = this.grille.length - 1;
				return;
			}
			else
			{
				return;
			}
		}
		
		if (direction == 'S' && nouvelleLig == this.grille.length - 1 )
		{
			
			if( grille[0][this.posCol] != '=' )
			{	
				this.posLig = 0;
				return;
			}
			else
			{
				return;
			}
		}
		
		if (direction == 'O' && nouvelleCol == 0 )
		{
			if( grille[this.posLig][this.grille[0].length - 1] != '=' )
			{	
				this.posCol = this.grille[0].length - 1;
				return;
			}
			else
			{
				return;
			}
		}
		if (direction == 'E' && nouvelleCol == this.grille[0].length - 1) 
		{
			if( grille[this.posLig][0] != '=' )
			{
				this.posCol = 0;
				return;
			}
			else
			{
				return;
			}
			
		}

		/*------------------------------------------*/
		/*       Changement position robot          */
		/*------------------------------------------*/
		System.out.println(nouvelleCol + " " + nouvelleLig);
		switch (direction) 
		{
			case 'N' -> nouvelleLig--;
			case 'S' -> nouvelleLig++;
			case 'O' -> nouvelleCol--;
			case 'E' -> nouvelleCol++;
			default  -> System.out.println("Direction invalide !");
			
		}
		System.out.println(nouvelleCol + " " + nouvelleLig);
		/*------------------------------------------*/
		/*      Verification collision murs         */
		/*------------------------------------------*/
		if ( this.grille[nouvelleLig][nouvelleCol] != '=') 
		{
			
			this.posLig = nouvelleLig;
			this.posCol = nouvelleCol;	
					
		} 
	}

	/*------------------------------------*/
	/*   Méthode toString du labyritnhe   */
	/*------------------------------------*/
	@Override
	public String toString ()
	{
		String s   = "";
		String sep = "+" ;

		/*------------------------------------------*/
		/*   On créer notre séparateur horizontal   */
		/*------------------------------------------*/
		for (int cptCol=0; cptCol < this.grille[0].length; cptCol++)
			sep = sep + "---+";
			
			
		s = s + sep + '\n';
			
		
		/*-----------------------------------------------------------------------*/
		/*   On ajoute ligne par lignes les donées de la grille dans la chaine   */
		/*-----------------------------------------------------------------------*/
		for (int cptLig=0; cptLig < this.grille.length; cptLig++)
		{
			s += "|";
			
			for (int cptCol=0; cptCol < this.grille[cptLig].length; cptCol++)
			{
				
				if (cptLig == this.posLig && cptCol == this.posCol)
				{
					s = s + " O |";
				}
				else
				{
						if  (cptLig == this.posLigSortie && cptCol == this.posColSortie)
						{
							s = s + " @ |";
						}
						else
						{
							s = s + " " + this.grille[cptLig][cptCol] + " |";
						}
					
				}
			}
			s = s + '\n'+ sep + '\n';
			
		}
		
		return s;
	}
}