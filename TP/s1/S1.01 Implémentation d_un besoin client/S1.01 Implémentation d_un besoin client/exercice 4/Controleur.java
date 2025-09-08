import ihmgui.Controle;
import ihmgui.FrameGrille;

/**
 * Classe Labyrinthe
 *
 * Exercice 4
 *
 * groupe    : 2
 * @author   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
 *
 * créée le : 16/12/2024 21h29
 */

public class Controleur extends Controle
{
	private Labyrinthe  metier;
	private FrameGrille frame;

	/**
	 * Constructeur de la classe Controleur.
	 * Initialise le modèle et l'interface utilisateur, puis lance la boucle principale du jeu.
	 */
	public Controleur()
	{
		this.metier = new Labyrinthe();
		this.frame  = new FrameGrille(this);

		this.frame.setSize(this.metier.getNbLignes()*200, this.metier.getNbColonnes()*100);
		this.frame.setVisible(true);

		this.setFondGrille();
		this.setLargeurImg();
		this.setCoordonneesInfo();
		
		while ( ! this.estSortie() )
		{
			this.jouer("");
		}

		this.frame.fermer();

	}

	/*--------------------------*/
	/*       Modificateur       */
	/*--------------------------*/

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int setNbLigne () { return this.metier.getNbLignes  (); }

	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int setNbColonne () { return this.metier.getNbColonnes(); }

	/**
	 * Retourne la largeur de l'image.
	 * @return la largeur de l'image
	 */
	public int setLargeurImg () { return 40; }

	/*--------------------------*/
	/*        Acceceur          */
	/*--------------------------*/

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int getNbLignes () { return this.metier.getNbLignes  (); }
	
	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int getNbColonnes() { return this.metier.getNbColonnes(); }

	
	/**
	 * Retourne toujours true.
	 * @return true
	 */
	public boolean setNumLigneColonne() { return true; }

	/**
	 * Retourne toujours false.
	 * @return false
	 */
	public boolean setCoordonneesInfo() { return false; }
	
	
	/**
	 * Retourne le caractère à la position spécifiée dans la grille.
	 * @param lig la ligne
	 * @param col la colonne
	 * @return le caractère à la position spécifiée
	 */
	public char getCase (int lig, int col ) { return this.metier.getCase (lig, col); }
	
	/**
	 * Vérifie si le personnage est à la sortie.
	 * @return true si le personnage est à la sortie, sinon false
	 */
	public boolean estSortie () { return this.metier.estSortie();}

	/**
	 * Retourne le chemin de l'image correspondant à la case spécifiée.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @param couche la couche de l'image
	 * @return le chemin de l'image
	 */
	public String setImage(int lig, int col, int couche)
	{

		String rep = "./images/";
		String sImage=null;
		char   symbole;

		symbole = this.metier.getCase(lig, col);

		if ( couche == 0 )
		{
			if ( symbole == '=' ) sImage = this.getTypeImage(lig, col);
			if ( symbole == ' ' ) sImage = rep + "haie_vide.gif";
			if ( symbole == '@' ) sImage = rep + "sortie.gif";
			if ( symbole == 'O' ) sImage = rep + "boule_verte.gif" ;
		}

		return sImage;
	}

	/**
	 * Retourne le chemin de l'image correspondant au type de mur spécifié.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return le chemin de l'image
	 */
	public String getTypeImage(int lig, int col)
	{
		String sImage = "./images/haie_vide.gif";
		char   mur    = this.metier.getCase(lig, col);

		if (mur == '=')
		{
			boolean murNord  = lig >                        0 && this.metier.getCase(lig - 1, col) == '=';
			boolean murSud   = lig < this.getNbLignes()   - 1 && this.metier.getCase(lig + 1, col) == '=';
			boolean murEst   = col < this.getNbColonnes() - 1 && this.metier.getCase(lig, col + 1) == '=';
			boolean murOuest = col >                        0 && this.metier.getCase(lig, col - 1) == '=';

			sImage = "./images/haie_";

			if (murNord                                    ) { sImage += "n";           }
			if (murOuest                                   ) { sImage += "o";           }
			if (murSud                                     ) { sImage += "s";           }
			if (murEst                                     ) { sImage += "e";           }
			if (!murNord && !murOuest && !murSud && !murEst) { sImage = "./images/haie";}

			sImage += ".gif";
		}
		return sImage;
	}


	public String setLabel (int numLbl)
	{
		String lib;

		switch ( numLbl )
		{
			case 0 : lib = "Pas :";        break;
			default: lib = null;
		}

		return lib;
	}

	/**
	 * Permet d'ecrire un texte dans un Label
	 * @param numLbl num du label
	 * @return un nombre de pas en String
	 */
	public String setTextLabel(int numLbl)
	{
		return "" + this.metier.getNbPas();
	}

	/**
	 * Joue un tour du jeu en déplaçant le personnage selon la touche spécifiée.
	 * @param touche la touche de direction
	 */
	public void jouer (String touche)
	{

		if ( touche.equals ( "FL-H" ) ) this.metier.deplacer( 'N', true );
		if ( touche.equals ( "FL-G" ) ) this.metier.deplacer( 'O', true );
		if ( touche.equals ( "FL-B" ) ) this.metier.deplacer( 'S', true );
		if ( touche.equals ( "FL-D" ) ) this.metier.deplacer( 'E', true );

		this.frame.majIHM();
	}
	

	public static void main(String[] a)
	{
		new Controleur();
	}
}
