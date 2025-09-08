/**
  * Classe Controleur
  *
  * Exercice 2
  *
  * groupe    : 2
  * @author   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
  *
  * créée le : 16/12/2024 13h29
  */
 
public class Controleur
{
	private Labyrinthe metier;
	private IhmCui     ihm;


	/**
	 * Constructeur de la classe Controleur.
	 * Initialise le modèle et l'interface utilisateur, puis lance la boucle principale du jeu.
	 */
	public Controleur()
	{
		this.metier = new Labyrinthe();
		this.ihm    = new IhmCui (this);
		
		while ( ! this.metier.estSortie() )
		{
			this.ihm.afficherGrille();

			this.metier.deplacer( this.ihm.saisirDirection(), true );
		}

		this.ihm.afficherGrille();
		
	}

	/*------------------------------------------*/
	/*                 Acceceur                 */
	/*------------------------------------------*/ 

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int     getNbLignes   ()                  { return this.metier.getNbLignes  ();         }
	
	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int     getNbColonnes ()                  { return this.metier.getNbColonnes();         }
	
	/**
	 * Retourne le caractère à la position spécifiée dans la grille.
	 * @param lig la ligne
	 * @param col la colonne
	 * @return le caractère à la position spécifiée
	 */
	public char    getCase       (int lig, int col ) { return this.metier.getCase      (lig, col); }
	
	/**
	 * Vérifie si le personnage est à la sortie.
	 * @return true si le personnage est à la sortie, sinon false
	 */
	public boolean estSortie     ()                  { return this.metier.estSortie    ();         }


	/**
	 * Méthode principale pour lancer l'application.
	 */
	public static void main(String[] a)
	{
		new Controleur();
	}
}
