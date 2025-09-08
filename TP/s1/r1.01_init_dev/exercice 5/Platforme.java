import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Classe Plateforme
 *
 * Exercice 5
 *
 * groupe    : 2
 * auteurs   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
 *
 * créée le : 17/12/2024 11H09
 */

public class Platforme
{
	private int      ligSortie;
	private int      colSortie;

	private char[][] grille;
	private int      nivActu;

	//Info joueur
	private int      posLig;
	private int      posCol;
	private char     dirPerso;
	private int      nivMax;

	private Caisse[] tabCaisse;

	/*------------------*/
	/*   constructeur   */
	/*------------------*/

	public Platforme()
	{
		this.dirPerso  = 'E';
		this.nivMax    = 1  ;
		this.nivActu   = 1  ;

		this.chargerNiveau(nivActu);

	}

	/*----------------*/
	/*   accesseurs   */
	/*----------------*/

	public int  getPosLig      ()                 { return this.posLig;              }
	public int  getPosCol      ()                 { return this.posCol;              }
	public int  getNbLignes    ()                 { return this.grille.length;       }
	public int  getNbColonnes  ()                 { return this.grille[0].length;    }
	public int  getNivMax      ()                 { return this.nivMax;              }
	public int  getNivActu     ()                 { return this.nivActu;             }
	public char getOrientation ()                 { return this.dirPerso;            }

	public Caisse getCaisse(int lig, int col) {
		int caisseLig;
		int caisseCol;

		for (int cptCaisse = 0; cptCaisse < this.tabCaisse.length; cptCaisse++) {
			if (this.tabCaisse[cptCaisse] != null) {
				caisseLig = this.tabCaisse[cptCaisse].getCaisseLig();
				caisseCol = this.tabCaisse[cptCaisse].getCaisseCol();

				if (lig == caisseLig && col == caisseCol) {
					return this.tabCaisse[cptCaisse];
				}
			}
		}
		return null;
	}

	public char getCase        (int lig, int col)
	{
		if (lig > this.grille.length    -1 ) { lig = this.grille.length    -1; }
		if (lig < 0                        ) { lig = 0;                        }
		if (col > this.grille[0].length -1 ) { col = this.grille[0].length -1; }
		if (col < 0                        ) { col = 0;                        }

		return this.grille[lig][col];
	}


	/*-------------------*/
	/*  autres methodes  */
	/*-------------------*/

	public void ajouterNivMax() { this.nivMax++; }

	public void definirNivActu(int niv)
	{
		int preNiv;
		preNiv = this.nivActu;

		this.nivActu = niv;
		if( niv >= this.nivMax ) this.nivActu = this.nivMax;
		if( niv <= 1           ) this.nivActu = 1;

		if (this.nivActu != preNiv)
			this.chargerNiveau (this.nivActu);
	}

	public boolean estSortie() { return this.posLig == this.ligSortie && this.posCol == this.colSortie;}

	public int indiceVisible(int lig, int col) {
		int distCol = Math.abs(this.posCol - col); // Distance en colonnes
		int distLig = Math.abs(this.posLig - lig); // Distance en lignes

		//si la distance est inférieure ou égale à 1 et que la hauteur de ligne est >= 1
		if (distCol <= 1 && distLig <= 1 && posLig >= lig) {
			return 1;
		}
		//il doit entouré ceux qui ont la condition précédente
		if (distCol <= 1 && distLig <= 1) {
			return 1;
		}

		else if (distCol <= 2 && distLig <= 2) {
			return 2;
		}
		else if (distCol <= 3 && distLig <= 3) {
			return 3;
		}
		else if (distCol <= 4 && distLig <= 4) {
			return 4;
		}
		else {
			return 5;
		}
	}




	public boolean estDansLeVide(int lig, int col)
	{
		boolean enDessous;
		boolean surLaCase;

		int     futurLig ;

		futurLig = lig + 1;

		if(futurLig > this.grille.length -1) futurLig = 0;

		enDessous = this.getCase(futurLig, col ) != '=';
		surLaCase = this.getCase(lig     , col ) != '#';

		return enDessous && surLaCase;
	}

	public boolean estCle(int lig, int col)
	{
		return this.getCase(lig, col) >=  'a' && this.getCase(lig, col) <= 'z';
	}

	public boolean estPorte(int lig, int col)
	{
		return this.getCase(lig, col) >=  'A' && this.getCase(lig, col) <= 'Z';
	}

	public String orientPers()
	{
		return this.dirPerso == 'E' ? "pers_droit" : "pers_gauche";
	}

	public void ouvrePorte(char nomCle)
	{
		char nomPorte;

		nomPorte = (char) ((int)nomCle - 32);

		for (int cptLig = 0; cptLig < this.grille.length; cptLig++)
		{
			for (int cptCol = 0; cptCol < this.grille[cptLig].length; cptCol++)
			{
				if(nomPorte == this.getCase(cptLig, cptCol)) { this.grille[cptLig][cptCol] = ' '; }
				if(nomCle   == this.getCase(cptLig, cptCol)) { this.grille[cptLig][cptCol] = ' '; }
			}
		}
	}

	public void tomber()
	{
		try
		{
			Thread.sleep(200);
			this.deplacer('S');
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void sauterOld(char dir)
	{
		boolean bloc1, bloc2, bloc3, bloc4;
		boolean debutSaut;
		int     deltaCol;

		deltaCol  = 0;
		debutSaut = false;

		if(dir == 'O') deltaCol = -1;
		if(dir == 'E') deltaCol =  1;


		bloc1 = this.getCase(this.posLig-1, this.posCol +   deltaCol) == '=';
		bloc2 = this.getCase(this.posLig-1, this.posCol             ) == '=';
		bloc3 = this.getCase(this.posLig,   this.posCol +   deltaCol) == '=';
		bloc4 = this.getCase(this.posLig,   this.posCol + 2*deltaCol) == '=';


		if( dir == 'J' )
		{
			if( !bloc2 )
			{
				this.posLig -= 1;
				debutSaut = true;
			}
		}
		else
		{
			if( !bloc1 )
			{
				if( !bloc2 )
				{
					if( this.dirPerso == dir )
					{
						this.posLig -= 1;
						this.posCol += deltaCol;
						debutSaut = true;
					}
					else
						this.dirPerso = this.directionInverseCol(this.dirPerso);
				}
				else
				{
					if( !bloc3 )
					{
						if( this.dirPerso == dir )
						{
							this.posLig -= 1;
							this.posCol += deltaCol;
							debutSaut = true;
						}
						else
							this.dirPerso = this.directionInverseCol(this.dirPerso);
					}
				}
			}
			else
			{
				if( !bloc2 && debutSaut )
				{
					this.posLig -= 1;
				}

			}

			if( this.posLig < 0                         ) this.posLig = this.grille.length    -1;

			if( this.posCol < 0                         ) this.posLig = this.grille[0].length -1;
			if( this.posCol > this.grille[0].length -1  ) this.posCol = 0;


			if (debutSaut)
			{
				if( this.getCase(this.posLig, this.posCol) != '#' && !bloc3 )
				{
					if( !bloc4 )
					{
						this.posLig += 1;
						this.posCol += deltaCol;
					}
				}
			}

		}

		if( this.posLig < 0                         ) this.posLig = this.grille.length    -1;


		if( this.posCol < 0                         ) this.posLig = this.grille[0].length -1;
		if( this.posCol > this.grille[0].length -1  ) this.posCol = 0;

	}

	public void sauter(char dir) {
		boolean obstacleDiagonal, obstacleHaut, obstacleDroite, obstacleDroiteDroite;
		int deltaCol = 0;

		// Détermine le décalage horizontal en fonction de la direction
		if (dir == 'O') deltaCol = -1;  // Déplacement vers la gauche
		if (dir == 'E') deltaCol = 1;   // Déplacement vers la droite
		//if (dir == 'N') deltaCol = this.getOrientation() == 'E' ? 1 : -1; // Vers la droite ou gauche selon orientation

		System.out.println("dir : " + dir);
		System.out.println("DeltaCol : " + deltaCol);

		// Vérifie les obstacles à différentes positions autour du joueur
		obstacleDiagonal     = this.getCase(this.posLig - 1, this.posCol + deltaCol)  == '=';  // Obstacle diagonale (haut et à gauche/droite)
		obstacleHaut         = this.getCase(this.posLig - 1, this.posCol)                 == '=';  // Obstacle haut
		obstacleDroite       = this.getCase(this.posLig, this.posCol + deltaCol)          == '=';  // Obstacle à droite
		obstacleDroiteDroite = this.getCase(this.posLig, this.posCol + 2 * deltaCol)      == '=';  // Obstacle à 2 cases à droite

		/*System.out.println("Obstacle diagonal : " + obstacleDiagonal);
		System.out.println("Obstacle haut : " + obstacleHaut);
		System.out.println("Obstacle droite : " + obstacleDroite);
		System.out.println("Obstacle droite droite : " + obstacleDroiteDroite);
		 */

		int casActuel = 0;

		if (!obstacleDiagonal && !obstacleHaut)
		{
			if (!obstacleDroiteDroite){
				this.posLig = this.posLig;
				this.posCol += 2 * deltaCol;
			}
			else
			{
				this.posLig = this.posLig - 1;
				this.posCol += deltaCol;
			}
		}
	}

	private void attendre()
	{
		try
		{
			Thread.sleep(500);
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void deplacer(char dir)
	{
		int futurLig, futurCol;
		Caisse futurCaisse;

		futurLig = this.posLig + this.deltaLig(dir);
		futurCol = this.posCol + this.deltaCol(dir);

		futurCaisse = this.getCaisse(futurLig, futurCol);
		if (futurCaisse != null)
		{
			futurCaisse.deplacerCaisse(dir);
		}

		if(this.estDansLeVide(posLig, posCol) && this.getCaisse(posLig+1, posCol) == null)
		{
			futurLig = this.posLig+1;
			futurCol = this.posCol;
		}

		if( ! this.estDansLeVide(posLig, posCol) && dir == 'N' && this.estPorte(posLig, posCol) )
		{
			futurLig = this.posLig;
			futurCol = this.posCol;
		}

		if( futurLig < 0                         ) futurLig = this.grille.length    -1;
		if( futurLig > this.grille.length -1     ) futurLig = 0;

		if( futurCol < 0                         ) futurCol = this.grille[0].length -1;
		if( futurCol > this.grille[0].length -1  ) futurCol = 0;

		if( this.grille[futurLig][futurCol] == '=' || this.getCaisse(futurLig, futurCol) != null || this.estPorte(futurLig, futurCol) )
		{
			futurLig = this.posLig;
			futurCol = this.posCol;
		}


		if( dir == 'O' || dir == 'E')
		{
			if( this.dirPerso != dir )
			{
				futurLig = this.posLig;
				futurCol = this.posCol;
				this.dirPerso = this.directionInverseCol(this.dirPerso);
			}
		}

		this.posLig = futurLig;
		this.posCol = futurCol;

		if( this.estCle(this.posLig, this.posCol) ) { this.ouvrePorte(this.grille[this.posLig][this.posCol]); }
	}

	public void chargerNiveau(int niveau)
	{
		int    ligne;
		int    colonne;
		int    cptCaisse;

		String sLigne;
		char   cara;

		this.tabCaisse = new Caisse[3];

		try
		{
			Scanner sc = new Scanner ( new FileInputStream( "src/sae1_1/sae1_1.exercice5_BACK/data/grille_0" +  this.nivActu + ".data" ), "UTF8" );

			ligne     = 0 ;
			colonne   = 0 ;
			cptCaisse = 0 ;
			sLigne    = "";

			while (sc.hasNextLine())
			{
				sLigne = sc.nextLine();
				ligne++;
				colonne = Math.max(colonne, sLigne.length());
			}

			sc.close();

			this.grille = new char[ligne][colonne];

			sc = new Scanner ( new FileInputStream( "src/sae1_1/sae1_1.exercice5_BACK/data/grille_0" +  this.nivActu + ".data" ), "UTF8" );

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
					if (cara == '+')
					{
						this.posLig = cptLig;
						this.posCol = cptCol;
					}

					if (cara == '?')
					{
						this.tabCaisse[cptCaisse] = new Caisse( cptLig, cptCol, this);
						System.out.println(this.getCaisse(cptLig, cptCol));
						System.out.println(cptCaisse);
						cptCaisse++;
					}

				}

				for (int cptCol = sLigne.length(); cptCol < colonne; cptCol++)
					this.grille[cptLig][cptCol] = ' ';

			}
		}
		catch (Exception e) { e.printStackTrace(); }
	}

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

	private char directionInverseCol(char dir) { return ( dir == 'O' ? 'E' : 'O' ); }

}