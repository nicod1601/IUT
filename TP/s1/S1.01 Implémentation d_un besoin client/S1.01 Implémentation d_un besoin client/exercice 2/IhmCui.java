import iut.algo.Clavier;

/**
  * Classe IhmCui
  *
  * Cette classe représente l'interface utilisateur en mode console pour le jeu de labyrinthe.
  * Elle permet d'afficher la grille et de saisir les directions de déplacement.
  *
  * Exercice 2
  *
  * groupe    : 2
  * @author   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
  *
  * créée le : 16/12/2024 13h29
  */
 
public class IhmCui
{
	private Controleur ctrl;

	/**
	 * Constructeur de la classe IhmCui.
	 * @param ctrl le contrôleur du jeu
	 */
	public IhmCui( Controleur ctrl )
	{
		this.ctrl = ctrl;
	}

	/**
	 * Affiche la grille du labyrinthe dans la console.
	 */
	public void afficherGrille()
	{
		String ligne = "+---";
		for (int cpt = 1; cpt < this.ctrl.getNbLignes(); cpt++)
		{
			ligne += "+---";
		}

		ligne += "+";
		String res = ligne + "\n";

		for (int cptLig = 0; cptLig < this.ctrl.getNbLignes(); cptLig++)
		{
			res += "|";
			for (int cptCol = 0; cptCol < this.ctrl.getNbColonnes(); cptCol++)
			{
				res += " " + this.ctrl.getCase(cptLig, cptCol) + " |";
			}
			res += "\n" + ligne + "\n";
		}

		System.out.println(res);
	}

	/**
	 * Demande à l'utilisateur de saisir une direction de déplacement.
	 * @return la direction saisie par l'utilisateur
	 */
	public char saisirDirection()
	{
		char dir ;

		System.out.print("Entrer une direction : ");
		dir = Clavier.lire_char();

		return dir;
	}

}