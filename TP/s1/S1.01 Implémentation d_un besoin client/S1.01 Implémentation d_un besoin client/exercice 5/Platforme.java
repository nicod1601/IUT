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

	// Attributs
	private int      ligSortie;
	private int      colSortie;
	private char[][] grille;
	private boolean  visible;

	private int  nivActu;
	private int  posLig;
	private int  posCol;
	private char dirPerso;
	private int  nivMax;
	
	private Caisse[] tabCaisse;

	/*------------------*/
	/*   Constructeur   */
	/*------------------*/

	/**
	 * Constructeur de la classe Platforme.
	 * Initialise les niveaux et charge le premier niveau.
	 */
	public Platforme()
	{
		this.nivMax = 1;
		this.nivActu = 1;
		this.chargerNiveau();
	}

	/*----------------*/
	/*   Accesseurs   */
	/*----------------*/

	/**
	 * Retourne la position de la ligne actuelle.
	 * @return la position de la ligne actuelle
	 */
	public int getPosLig() { return this.posLig; }

	/**
	 * Retourne la position de la colonne actuelle.
	 * @return la position de la colonne actuelle
	 */
	public int getPosCol() { return this.posCol; }

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes de la grille
	 */
	public int getNbLignes() { return this.grille.length; }

	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes de la grille
	 */
	public int getNbColonnes() { return this.grille[0].length; }

	/**
	 * Retourne le niveau maximum atteint.
	 * @return le niveau maximum atteint
	 */
	public int getNivMax() { return this.nivMax; }

	/**
	 * Retourne le niveau actuel.
	 * @return le niveau actuel
	 */
	public int getNivActu() { return this.nivActu; }

	/**
	 * Retourne l'orientation actuelle du personnage.
	 * @return l'orientation actuelle du personnage
	 */
	public char getOrientation() { return this.dirPerso; }

	/**
	 * Retourne la caisse à la position spécifiée.
	 * @param lig la ligne de la caisse
	 * @param col la colonne de la caisse
	 * @return la caisse à la position spécifiée, ou null si aucune caisse n'est trouvée
	 */
	public Caisse getCaisse(int lig, int col)
	{
		int caisseLig;
		int caisseCol;
		Caisse caisse;
	
		caisse = null;
		for (int cptCaisse = 0; cptCaisse < this.tabCaisse.length; cptCaisse++)
		{
			if (this.tabCaisse[cptCaisse] != null)
			{
				caisseLig = this.tabCaisse[cptCaisse].getCaisseLig();
				caisseCol = this.tabCaisse[cptCaisse].getCaisseCol();
				if (lig == caisseLig && col == caisseCol)
				{
					caisse = this.tabCaisse[cptCaisse];
				}
			}
		}
		return caisse;
	}

	/**
	 * Retourne le caractère de la case à la position spécifiée.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return le caractère de la case à la position spécifiée
	 */
	public char getCase(int lig, int col)
	{
		if( lig > this.grille.length - 1    ) { lig = this.grille.length - 1;    }
		if( lig < 0                         ) { lig = 0;                         }
		if( col > this.grille[0].length - 1 ) { col = this.grille[0].length - 1; }
		if( col < 0                         ) { col = 0;                         }

		return this.grille[lig][col];
	}

	/*-------------------*/
	/*  Autres methodes  */
	/*-------------------*/

	/**
	 * Incrémente le niveau maximum.
	 */
	public void ajouterNivMax() { this.nivMax++; }

	/**
	 * Définit le niveau actuel.
	 * @param niv le niveau à définir
	 */
	public void definirNivActu(int niv)
	{
		int preNiv;

		preNiv = this.nivActu;
		this.nivActu = niv;

		if (niv >= this.nivMax) this.nivActu = this.nivMax;
		if (niv <= 1) this.nivActu = 1;

		if (this.nivActu != preNiv)
		{
			this.chargerNiveau();
		}
	}

	/**
	 * Vérifie si la position actuelle est la sortie.
	 * @return true si la position actuelle est la sortie, false sinon
	 */
	public boolean estSortie()
	{
		return this.posLig == this.ligSortie && this.posCol == this.colSortie;
	}

	/**
	 * Retourne l'indice de visibilité de la case à la position spécifiée.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return l'indice de visibilité de la case
	 */
	public int indiceVisible(int lig, int col) 
	{
		if (this.visible)
		{
			return 1;
		}
		int distCol = Math.abs(this.posCol - col);
		int distLig = Math.abs(this.posLig - lig);

		if( distCol <= 1 && distLig <= 1 && posLig >= lig ) { return 1; }
		if( distCol <= 1 && distLig <= 1                  ) { return 1; }
		if( distCol <= 2 && distLig <= 2                  ) { return 2; }
		if( distCol <= 3 && distLig <= 3                  ) { return 3; }
		if( distCol <= 4 && distLig <= 4                  ) { return 4; }
		return 5;
	}

	/**
	 * Vérifie si la case à la position spécifiée est dans le vide.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return true si la case est dans le vide, false sinon
	 */
	public boolean estDansLeVide(int lig, int col)
	{
		int     futurLig;
		boolean enDessous;
		boolean surLaCase;

		futurLig = lig +1;

		if (futurLig > this.grille.length - 1) futurLig = 0;

		enDessous = this.getCase(futurLig, col) != '=';
		surLaCase = this.getCase(lig, col) != '#';

		return enDessous && surLaCase;
	}

	/**
	 * Vérifie si la case à la position spécifiée est une clé.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return true si la case est une clé, false sinon
	 */
	public boolean estCle(int lig, int col)
	{
		return this.getCase(lig, col) >= 'a' && this.getCase(lig, col) <= 'z';
	}

	/**
	 * Vérifie si la case à la position spécifiée est un bouton.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return true si la case est un bouton, false sinon
	 */
	public boolean estBouton(int lig, int col)
	{
		return this.getCase(lig, col) == '^';
	}

	/**
	 * Vérifie si la case à la position spécifiée est une porte.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return true si la case est une porte, false sinon
	 */
	public boolean estPorte(int lig, int col)
	{
		return this.getCase(lig, col) >= 'A' && this.getCase(lig, col) <= 'Z';
	}

	/**
	 * Retourne l'orientation du personnage sous forme de chaîne de caractères.
	 * @return l'orientation du personnage
	 */
	public String orientPers()
	{
		return this.dirPerso == 'E' ? "pers_droit" : "pers_gauche";
	}

	/**
	 * Ouvre la porte correspondant à la clé spécifiée.
	 * @param nomCle le nom de la clé
	 */
	public void ouvrePorte(char nomCle)
	{
		char nomPorte;
		
		nomPorte = (char) ((int) nomCle - 32);
		
		for(int cptLig = 0; cptLig < this.grille.length; cptLig++)
		{
			for(int cptCol = 0; cptCol < this.grille[cptLig].length; cptCol++)
			{
				if( nomPorte == this.getCase(cptLig, cptCol) )
				{
					this.grille[cptLig][cptCol] = ' ';
				}

				if( nomCle == this.getCase(cptLig, cptCol) )
				{
					this.grille[cptLig][cptCol] = ' ';
				}
			}
		}
	}


	/**
	 * Fait sauter le personnage dans la direction spécifiée.
	 * @param dir la direction du saut
	 * @param etape l'étape du saut
	 * @return true si le saut est réussi, false sinon
	 */
	public void sauter(char dir)
	{
		boolean bloc1, bloc2, bloc3, bloc4, echelle;
		boolean etape2;
		int     deltaCol;

		deltaCol  = 0;

		if(dir == 'O') deltaCol = -1;
		if(dir == 'E') deltaCol =  1;

		bloc1   = this.getCase(this.posLig-1, this.posCol +   deltaCol) == '='; // bloc diagonal
		echelle = this.getCase(this.posLig-1, this.posCol +   deltaCol) == '#'; // échelle diagonal
		bloc2   = this.getCase(this.posLig-1, this.posCol             ) == '='; // bloc haut
		bloc3   = this.getCase(this.posLig  , this.posCol +   deltaCol) == '='; // bloc latterale
		bloc4   = this.getCase(this.posLig  , this.posCol + 2*deltaCol) == '='; // bloc latterale à deux cases

		if( dir =='N') // saut verticale
		{
			if(!bloc2) // vérification présence d'un bloc
			{

				if(this.getCase(this.posLig - 1, this.posCol) == '#') // verification de l'echelle
				{
					this.posLig -= 1;
				}
			}
		}

		if(dir == 'E' || dir == 'O') // saut horizontal
		{
			etape2 = false;
			if(!bloc1) // présence bloc diagonal
			{

				if(!bloc2) // présence bloc à droite
				{
					if (this.dirPerso == dir && !this.estPorte(this.posLig - 1, this.posCol + deltaCol))
					{
						this.posLig -=1;
						this.posCol += deltaCol;
						etape2 = true;
					}
					else
						this.dirPerso = this.directionInverseCol(this.dirPerso);

				}
				else
				{
					if(!bloc3)
					{
						
						if (this.dirPerso == dir && !this.estPorte(this.posLig - 1, this.posCol + deltaCol))
						{
							this.posCol += deltaCol;
							this.posLig -=1;
							etape2 = true;
						}
						else
							this.dirPerso = this.directionInverseCol(this.dirPerso);
						
					}
				}

				if(echelle)
				{
					etape2 = false;
				}

				if(!bloc4 && etape2) // présence du bloc à deux cases à droite
				{
					this.posCol += deltaCol;
				}
			}
		}

	}

	/**
	 * Gère la chute du personnage.
	 */
	/*private void tombe()
	{
		while (this.estDansLeVide(this.posLig, this.posCol)) {
			System.out.println("Le personnage tombe.");
			this.posLig++; // Déplacer le personnage d'une ligne vers le bas.
	
			// Empêcher de dépasser les limites de la grille.
			if (this.posLig >= this.grille.length) {
				this.posLig = this.grille.length - 1;
				break;
			}
		}
	}*/

	/**
	 * Déplace le personnage dans la direction spécifiée.
	 * @param dir la direction du déplacement
	 */
	public void deplacer(char dir)
	{
		int futurLig; 
		int futurCol; 
		
		futurLig = this.posLig + this.deltaLig(dir);
		futurCol = this.posCol + this.deltaCol(dir);

		//System.out.println(this.estDansLeVide(futurLig, futurCol));
		System.out.println(this.estDansLeVide(this.posLig, this.posCol));

		/*if(this.estDansLeVide(futurLig, futurCol))
		{
			this.tombe();
			System.out.println("je tombe");
		}*/

		
		for(int cpt=0;cpt<this.tabCaisse.length;cpt++)
		{
			if(this.tabCaisse[cpt] != null)
			{
				if(futurLig == this.tabCaisse[cpt].getCaisseLig() && futurCol == this.tabCaisse[cpt].getCaisseCol())
				{
					this.tabCaisse[cpt].deplacerCaisse(dir);
					System.out.println(this.tabCaisse[cpt].getCaisseLig() + " " + this.tabCaisse[cpt].getCaisseCol());
				}
			}	
		}

		for(int cpt=0;cpt<this.tabCaisse.length;cpt++)
		{
			if(this.tabCaisse[cpt] != null)
			{
				if(futurLig == this.tabCaisse[cpt].getCaisseLig() && futurCol == this.tabCaisse[cpt].getCaisseCol())
				{
					futurLig = this.posLig;
					futurCol = this.posCol;
				}
			}	
		}

		
		/*for(int cpt1=0;cpt1<this.tabCaisse.length;cpt1++)
		{
			if(this.tabCaisse[cpt1] != null)
			{
				for(int cpt2=0;cpt2<this.tabCaisse.length;cpt2++)
				{
					if(this.tabCaisse[cpt2] != null)
					{
						if(this.tabCaisse[cpt1].estEnCollision(this.tabCaisse[cpt2]))
						{
							this.tabCaisse[cpt1].setPosColCaisse(this.tabCaisse[cpt1].getCaisseLig() - 1);
						}
					}
				}

			}	
		}*/
		

		if ( futurLig <  0                     ) futurLig = this.grille.length - 1;
		if ( futurLig >= this.grille.length ) futurLig = 0;
		if ( futurCol <  0                     ) futurCol = this.grille[0].length - 1;
		if ( futurCol >= this.grille[0].length ) futurCol = 0;

		if (estDansLeVide(this.posLig, this.posCol))
		{
			if(this.estSurCaisse(this.posLig,this.posCol))
			{
				this.posLig = futurLig;
				this.posCol = futurCol;
			}
			else
			{
				futurCol = this.posCol;
			}
			
		}

		if (this.grille[futurLig][futurCol] == '=' || this.estPorte(futurLig, futurCol) )
		{
			futurLig = this.posLig;
			futurCol = this.posCol;
		}

		if (dir == 'O' || dir == 'E')
		{
			if (this.dirPerso != dir)
			{
				futurLig = this.posLig;
				futurCol = this.posCol;
				
				this.dirPerso = this.directionInverseCol(this.dirPerso);
			}
		}

		this.posLig = futurLig;
		this.posCol = futurCol;

		if (this.estCle(this.posLig, this.posCol))
		{
			this.ouvrePorte(this.grille[this.posLig][this.posCol]);
		}

		if (this.estBouton(this.posLig, this.posCol))
		{
			this.visible = true;
		}
	}

	public boolean estSurCaisse(int lig, int col)
	{
		boolean enDessous;

		int futurLig = this.posLig + 1;

		for(int cpt=0; cpt < this.tabCaisse.length;cpt++)
		{
			if(this.tabCaisse[cpt] != null)
			{
				if(futurLig == this.tabCaisse[cpt].getCaisseLig())
				{
					return enDessous = true;
				}
			}
		}
		return enDessous = false;
	}

	/**
	 * Charge le niveau actuel à partir d'un fichier de données.
	 */
	public void chargerNiveau()
	{
		int ligne     = 0;
		int colonne   = 0;
		int cptCaisse = 0;

		int futurLig = 0;
		int futurCol = 0;

		String sLigne;
		char   cara;

		this.tabCaisse = new Caisse[3];
		this.dirPerso  = 'E';
		this.visible   = true;

		try
		{
			Scanner sc = new Scanner(new FileInputStream("./data/grille_0" + this.nivActu +
			                                             ".data"), "UTF8");

			while (sc.hasNextLine())
			{
				sLigne = sc.nextLine();
				ligne++;
				colonne = Math.max(colonne, sLigne.length());
			}

			sc.close();

			this.grille = new char[ligne][colonne];

			sc = new Scanner(new FileInputStream("./data/grille_0" + this.nivActu + ".data"), "UTF8");

			for (int cptLig = 0; cptLig < ligne; cptLig++)
			{
				sLigne = sc.nextLine();
				for (int cptCol = 0; cptCol < sLigne.length(); cptCol++)
				{
					cara = sLigne.charAt(cptCol);
					this.grille[cptLig][cptCol] = cara;

					if (cara == '+')
					{
						futurLig = cptLig;
						futurCol = cptCol;
					}

					if (cara == '@')
					{
						this.ligSortie = cptLig;
						this.colSortie = cptCol;
					}

					if (cara == '?')
					{
						this.tabCaisse[cptCaisse] = new Caisse(cptLig, cptCol, this);
						cptCaisse++;
					}

					if (cara == '^')
					{
						this.visible = false;
					}
				}

				for (int cptCol = sLigne.length(); cptCol < colonne; cptCol++)
					this.grille[cptLig][cptCol] = ' ';
			}

			this.posLig = futurLig;
			this.posCol = futurCol;

		} catch (Exception e) { e.printStackTrace(); }
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères de la grille.
	 * @return une représentation sous forme de chaîne de caractères de la grille
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

	/**
	 * Retourne le delta de la ligne en fonction de la direction.
	 * @param direction la direction
	 * @return le delta de la ligne
	 */
	public int deltaLig(char direction)
	{
		int delta = 0;
		if (direction == 'N') delta = -1;
		if (direction == 'S') delta =  1;

		return delta;
	}

	/**
	 * Retourne le delta de la colonne en fonction de la direction.
	 * @param direction la direction
	 * @return le delta de la colonne
	 */
	public int deltaCol(char direction)
	{
		int delta = 0;
		if (direction == 'E') delta =  1;
		if (direction == 'O') delta = -1;

		return delta;
	}

	/**
	 * Retourne la direction inverse de la colonne.
	 * @param dir la direction actuelle
	 * @return la direction inverse de la colonne
	 */
	public char directionInverseCol(char dir)
	{
		char res = ' ';
		if (dir == 'O') res = 'E';
		if (dir == 'E') res = 'O';

		return res;
	}
}
