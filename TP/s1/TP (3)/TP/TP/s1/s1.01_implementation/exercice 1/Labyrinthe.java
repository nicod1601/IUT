import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Classe Labyrinthe : Représente un labyrinthe avec un objet qui peut se déplacer.
 * Exercice 1 : Initialisation et manipulation d'un labyrinthe.
 * Groupe : 1
 * @author : Theo, Lucas, Floriane, Nichita, Audric
 * Date : 16/12/2024 14:30
 */
public class Labyrinthe 
{

	/*-------------------------------------*/
	/* Position de l'objet dans la grille  */
	/*-------------------------------------*/

	private int posLig;
	private int posCol;

	// Grille représentant le labyrinthe
	private char[][] grille;

	/*---------------------------------------------------------------------------*/
	/* Constructeur par défaut qui initialise le  labyrinthe depuis un fichier.  */
	/*---------------------------------------------------------------------------*/
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
				}
				cptLig++;
			}		
			sc.close();	
		}
		catch(Exception e){ e.printStackTrace();}
		
    }
	
		

	/*------------------------------------------*/
	/*          Deplacement du Robot            */
	/*------------------------------------------*/
	public void deplacer(char direction) 
	{
		int nouvelleLig, nouvelleCol;
		
		nouvelleLig  = this.posLig;
		nouvelleCol  = this.posCol;

		if (direction == 'N' && nouvelleLig == 0)                         return;
		if (direction == 'S' && nouvelleLig == this.grille.length - 1)    return;
		if (direction == 'O' && nouvelleCol == 0)                         return;
		if (direction == 'E' && nouvelleCol == this.grille[0].length - 1) return;

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

	/*------------------------------------------------------*/
	/* Retourne une représentation textuelle du labyrinthe. */
	/*------------------------------------------------------*/
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
					s = s + " " + this.grille[cptLig][cptCol] + " |";
				}
			}
			s = s + '\n'+ sep + '\n';
			
		}
		
		return s;
	}
}