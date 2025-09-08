import ihmgui.Controle;
import ihmgui.FrameGrille;

/**
 * Classe Controleur
 *
 * Cette classe représente le contrôleur du jeu de platforme.
 *
 * Exercice 5
 *
 * groupe    : 2
 * auteurs   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
 *
 * créée le : 16/12/2024 21h29
 */

public class Controleur extends Controle
{
	private Platforme   metier;
	private FrameGrille frame;
	private String      theme;

	/**
	 * Constructeur de la classe Controleur.
	 * Initialise les composants du jeu et lance la boucle principale.
	 */
	public Controleur()
	{
		this.metier = new Platforme();
		this.frame  = new FrameGrille(this);

		this.frame.setSize(this.metier.getNbColonnes()*200, this.metier.getNbLignes()*200);
		this.frame.setVisible(true);

		this.setFondGrille();
		this.setLargeurImg();
		this.theme = "mario";

		while ( this.metier.getNivActu() < 7)
		{
			while ( ! this.estSortie() )
			{
				this.jouer("");

				if ( this.estSortie() )
				{
					if(this.metier.getNivMax() == this.metier.getNivActu())
					{
						this.metier.ajouterNivMax();
					}
				}
			}

			this.setLabel(0);
		}

		this.frame.fermer();
	}

	/*------------------------------------*/
	/* Méthodes de gestion de l'affichage */
	/*------------------------------------*/

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int setNbLigne() { return this.metier.getNbLignes(); }

	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int setNbColonne() { return this.metier.getNbColonnes(); }

	/**
	 * Retourne la largeur de l'image.
	 * @return la largeur de l'image
	 */
	public int setLargeurImg() { return 52; }

	/**
	 * Retourne le chemin de l'image de fond de la grille.
	 * @return le chemin de l'image de fond
	 */
	public String setFondGrille() { return "./images/" + this.theme + "/fond.png"; }

	/**
	 * Retourne la largeur du label.
	 * @return la largeur du label
	 */
	public int setLargeurLabel() { return 1000; }

	/**
	 * Retourne la marge gauche.
	 * @return la marge gauche
	 */
	public int setMargeGauche() { return 0; }

	/*-----------------------------------------*/
	/* Méthodes de récupération d'informations */
	/*-----------------------------------------*/
	
	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int getNbLignes() { return this.metier.getNbLignes(); }

	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int getNbColonnes() { return this.metier.getNbColonnes(); }

	/**
	 * Retourne le caractère à la position spécifiée dans la grille.
	 * @param lig la ligne
	 * @param col la colonne
	 * @return le caractère à la position spécifiée
	 */
	public char getCase(int lig, int col) { return this.metier.getCase(lig, col); }

	/**
	 * Vérifie si le personnage est à la sortie.
	 * @return true si le personnage est à la sortie, sinon false
	 */
	public boolean estSortie() { return this.metier.estSortie(); }

	/*------------------------------*/
	/* Méthodes de gestion du thème */
	/*------------------------------*/

	/**
	 * Change le thème du jeu.
	 * @return le nouveau thème
	 */
	public String changerTheme()
	{
		switch (this.theme)
		{
			case "lem"     -> this.theme = "link";
			case "link"    -> this.theme = "asterix";
			case "asterix" -> this.theme = "indiana";
			case "indiana" -> this.theme = "mario";
			case "mario"   -> this.theme = "lem";
		}
		return this.theme;
	}

	// Méthodes pour l'image et l'affichage

	/**
	 * Retourne le chemin de l'image à afficher pour une case donnée.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @param couche la couche de l'image
	 * @return le chemin de l'image
	 */
	public String setImage(int lig, int col, int couche)
	{
		String rep = "./images/" + this.theme + "/";
		String sImage = null;

		char symbole;

		int  ligSupp;
		int  posCaisseLig, posCaisseCol;

		Caisse caisse;

		symbole = this.metier.getCase(lig, col);

		if (couche == 0)
		{
			switch (symbole)
			{
				case '=' -> sImage = this.getTypeImage(lig, col);
				case '@' -> sImage = rep + "sortie.png";
				case '#' -> 
				{
					ligSupp = lig - 1;
					
					if ( ligSupp                    <   0 ) { ligSupp = this.getNbLignes() - 1;  }
					if ( this.getCase(ligSupp, col) != '#') { sImage = rep + "echelle_haut.png"; }
					else                                    { sImage = rep + "echelle.png";      }
				}
				case 'b' -> sImage = rep + "clebleue.png";
				case 'B' -> sImage = rep + "portebleue.png";
				case 'r' -> sImage = rep + "clerouge.png";
				case 'R' -> sImage = rep + "porterouge.png";
				case 'v' -> sImage = rep + "cleverte.png";
				case 'V' -> sImage = rep + "porteverte.png";
				case '+' -> sImage = rep + "";
				case '^' -> sImage = rep + "bouton.png";
				default  -> sImage = rep + "vide52.png";
			}

			caisse = this.metier.getCaisse(lig, col);

			if (caisse != null)
			{
				posCaisseLig = caisse.getCaisseLig();
				posCaisseCol = caisse.getCaisseCol();

				if( posCaisseLig == lig && posCaisseCol == col)
				{
					sImage = rep + "caisse.png";
				}
			}
		}
		else 
			if ( couche == 1 )
			{
				switch ( this.metier.indiceVisible(lig, col) )
				{
					case 1 -> sImage = rep + "";
					case 2 -> sImage = rep + "black_20_opacity.png";
					case 3 -> sImage = rep + "black_50_opacity.png";
					case 4 -> sImage = rep + "black_80_opacity.png";
					case 5 -> sImage = rep + "black_100_opacity.png";
				}

				if( lig ==  this.metier.getPosLig() && col == this.metier.getPosCol() )
				{
					if( this.metier.estDansLeVide(lig, col) && this.metier.getCaisse(lig+1, col) == null )
					{
						sImage = rep + "pers_tombe.png";
					}
					else
					{
						if( symbole == '#' )
						{
							if( lig % 2 == 0 )
								sImage = rep + "pers_monte1.png";
							else
								sImage = rep + "pers_monte2.png";
						}
						else
						{
							if( col % 2 == 0 )
								sImage = rep + this.metier.orientPers() + ".png";
							else
								sImage = rep + this.metier.orientPers() + "_2.png";
						}
					}
				}
			}

		return sImage;
	}

	/**
	 * Retourne le type d'image pour une case donnée.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return le chemin de l'image
	 */
	public String getTypeImage(int lig, int col) {
		String sImage = "./images/" + this.theme + "/";

		boolean murGauche = col > 0 && this.metier.getCase(lig, col - 1) != '=';
		boolean murDroite = col + 1 < this.getNbColonnes() && this.metier.getCase(lig, col + 1) != '=';

		return sImage + 
			(murGauche && murDroite ? "sol_gauche_droit.png" : 
			murGauche ? "sol_gauche.png" : 
			murDroite ? "sol_droit.png" : "sol.png");
	}


	/**
	 * Retourne le libellé du bouton spécifié.
	 * @param numBtn le numéro du bouton
	 * @return le libellé du bouton
	 */
	public String setBouton(int numBtn)
	{
		String lib = null;

		if (numBtn == 0) { lib = "Niveau précédent"; }
		if (numBtn == 1) { lib = "Niveau suivant";   }
		if (numBtn == 2) { lib = "Recommencer";      }
		if (numBtn == 3) { lib =  "Changer le Theme"; }

		return lib;
	}

	/**
	 * Gère l'action du bouton spécifié.
	 * @param action l'action du bouton
	 */
	public void bouton(int action)
	{
		if (action == 0) { this.metier.definirNivActu(this.metier.getNivActu() - 1); }
		if (action == 1) { this.metier.definirNivActu(this.metier.getNivActu() + 1); }
		if (action == 2) { this.metier.chargerNiveau();                              }
		if (action == 3) { this.changerTheme();                                      }

		this.frame.majIHM();
	}

	/**
	 * Retourne le libellé du label spécifié.
	 * @param numLbl le numéro du label
	 * @return le libellé du label
	 */
	public String setLabel(int numLbl)
	{
		String lib = null;

		if (numLbl == 0)
		{
			lib = "";
		}

		return lib;
	}

	/**
	 * Retourne le texte du label spécifié.
	 * @param numLbl le numéro du label
	 * @return le texte du label
	 */
	public String setTextLabel(int numLbl)
	{
		String label = null;

		if (numLbl == 0)
		{
			if (this.estSortie())
				label = "Nouveau niveau disponible";
		}
		return label;
	}

	/*--------------------------------*/
	/* Méthode pour jouer et déplacer */
	/*--------------------------------*/
	/**
	 * Joue et déplace le personnage en fonction de la touche pressée.
	 * @param touche la touche pressée
	 */
	public void jouer(String touche)
	{
		this.tombe();

		if( touche.equals("FL-H"   ) ) this.metier.deplacer('N');
		if( touche.equals("FL-G"   ) ) this.metier.deplacer('O');
		if( touche.equals("FL-B"   ) ) this.metier.deplacer('S');
		if( touche.equals("FL-D"   ) ) this.metier.deplacer('E');

		if( touche.equals("E"   ) )this.metier.definirNivActu(this.metier.getNivActu() + 1);
		if( touche.equals("A"   ) )this.metier.definirNivActu(this.metier.getNivActu() - 1);

		if( touche.equals("CR-FL-G") ) this.metier.sauter('O');
		if( touche.equals("CR-FL-D") ) this.metier.sauter('E');
		if( touche.equals("CR-"    ) ) this.metier.sauter('N');
		
		this.frame.majIHM();
	}

	private void tombe()
	{
		if ( this.metier.estDansLeVide(this.metier.getPosLig(), this.metier.getPosCol()) )
		{
			this.metier.deplacer('S');
			this.animation();
		}
	}

	/**
	 * Gère l'animation du personnage.
	 */
	private void animation()
	{
		try
		{
			Thread.sleep(350);
		} catch (Exception e) { e.printStackTrace(); }
	}

	/**
	 * Méthode principale pour lancer l'application.
	 * @param a arguments de la ligne de commande
	 */
	public static void main(String[] a)
	{
		new Controleur();
	}

}