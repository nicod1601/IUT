import ihmgui.FrameGrille;
import ihmgui.Controle;
import iut.algo.Clavier;

/**
  * Classe Controleur
  *
  * Cette classe représente le contrôleur du jeu de labyrinthe.
  * Elle gère l'interaction entre le modèle (Labyrinthe) et l'interface utilisateur graphique (FrameGrille).
  *
  * Exercice 3
  *
  * groupe    : 2
  * @author   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
  *
  * créée le : 16/12/2024 15h39
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
		this.frame.setSize(this.metier.getNbLignes()*35, this.metier.getNbColonnes()*35);
		this.frame.setVisible(true);

		this.setFondGrille();

		while ( ! this.estSortie() )
		{
			this.jouer("");
		}

		this.frame.fermer();

	}

	/*------------------*/
	/*   Modificateur   */
	/*------------------*/

	public String  setFondGrille() { return "./images/fond.png";  }
	public int     setNbLigne   () { return this.getNbLignes  (); }
	public int     setNbColonne () { return this.getNbColonnes(); }
	public int     setLargeurImg() { return 30;                   }

	/*----------------*/
	/*   Accesseurs   */
	/*----------------*/
	
	public int     getNbLignes   ()                  { return this.metier.getNbLignes  ();         }
	public int     getNbColonnes ()                  { return this.metier.getNbColonnes();         }
	public char    getCase       (int lig, int col ) { return this.metier.getCase      (lig, col); }
	public boolean estSortie     ()                  { return this.metier.estSortie    ();         }


	/**
	 * Retourne le chemin de l'image correspondant à la case spécifiée.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @param couche la couche de l'image
	 * @return le chemin de l'image
	 */
	public String setImage(int lig, int col, int couche)
	{

		String rep    = "./images/";
		String sImage = null;
		char symbole;

		if ( couche==0)
		{
			symbole = this.metier.getCase(lig, col);

			if      ( symbole == 'O' ) sImage = rep + "bille.png" ;
			else if ( symbole == '=' ) sImage = rep + "mur.png"   ;
			else if ( symbole == '@' ) sImage = rep + "sortie.png";
		}
		this.setLargeurImg();
		return sImage;
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

	/**
	 * Méthode principale pour lancer l'application.
	 */
	public static void main(String[] a)
	{
		new Controleur();
	}
}
