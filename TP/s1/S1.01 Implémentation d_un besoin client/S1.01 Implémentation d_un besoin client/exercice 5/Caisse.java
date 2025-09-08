/**
 * Classe Caisse
 *
 * Exercice 5
 *
 * groupe    : 2
 * auteurs   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
 *
 * créée le : 18/12/2024 19H15
 * Version 1
 */

public class Caisse
{
	private int ligCaisse;
	private int colCaisse;
	private Platforme plt;

	/**
	 * Constructeur de la classe Caisse.
	 * @param lig la ligne de la caisse
	 * @param col la colonne de la caisse
	 * @param plt la plateforme associée
	 */
	public Caisse(int lig, int col, Platforme plt)
	{
		this.ligCaisse = lig;
		this.colCaisse = col;
		this.plt = plt;
	}

	/**
	 * Retourne le nombre de lignes de la grille.
	 * @return le nombre de lignes
	 */
	public int getNbLig() { return this.plt.getNbLignes(); }

	/**
	 * Retourne le nombre de colonnes de la grille.
	 * @return le nombre de colonnes
	 */
	public int getNbCol() { return this.plt.getNbColonnes(); }

	/**
	 * Retourne la ligne de la caisse.
	 * @return la ligne de la caisse
	 */
	public int getCaisseLig() { return this.ligCaisse; }

	/**
	 * Retourne la colonne de la caisse.
	 * @return la colonne de la caisse
	 */
	public int getCaisseCol() { return this.colCaisse; }

	public void setPosLigCaisse(int lig){this.ligCaisse = lig;}
	public void setPosColCaisse(int col){this.ligCaisse = col;}
	

	/**
	 * Vérifie si la case spécifiée est dans le vide.
	 * @param lig la ligne de la case
	 * @param col la colonne de la case
	 * @return true si la case est dans le vide, sinon false
	 */
	public boolean estDansLeVide(int lig, int col)
	{
		boolean enDessous;
		boolean surLaCase;
		int futurLig = lig + 1;

		if (futurLig > this.getNbLig() - 1) futurLig = 0;

		enDessous = this.plt.getCase(futurLig, col) == ' ' || this.plt.getCase(futurLig, col) == '#';
		surLaCase = this.plt.getCase(lig, col) != '=';

		return enDessous && surLaCase;
	}

	/**
	 * Fait tomber la caisse.
	 */
	public void tomber()
	{
		this.deplacerCaisse('S');
		try
		{
			Thread.sleep(200);
			
		} catch (Exception e) { e.printStackTrace(); }
	}

	/**
	 * Déplace la caisse dans la direction spécifiée.
	 * @param dir la direction du déplacement
	 */
	public void deplacerCaisse(char dir)
	{
		int futurLig = this.getCaisseLig() + this.deltaLig(dir);
		int futurCol = this.getCaisseCol() + this.deltaCol(dir);
		Caisse autre;

		if(this.plt.getCase(futurLig, futurCol) != '#' && this.plt.getCase(futurLig, futurCol) != '=')
		{
			switch (dir)
			{
				case 'E' -> futurCol = this.colCaisse + 1;
				case 'O' -> futurCol = this.colCaisse - 1;
				case 'S' -> futurLig = this.ligCaisse + 1;
				default -> {
					futurLig = this.ligCaisse;
					futurCol = this.colCaisse;
				}
			}



			if (futurLig < 0) futurLig = this.getNbLig() - 1;
			if (futurLig > this.getNbLig() - 1) futurLig = 0;
			if (futurCol < 0) futurCol = this.getNbCol() - 1;
			if (futurCol > this.getNbCol() - 1) futurCol = 0;

			if (this.plt.getCase(futurLig, futurCol) == '=' || this.plt.getCase(futurLig, futurCol) == '#')
			{
				futurLig = this.ligCaisse;
				futurCol = this.colCaisse;
			}
			else
			{
				this.ligCaisse = futurLig;
				this.colCaisse = futurCol;
			}

			

			if(this.estDansLeVide(futurLig, futurCol))
			{
				this.tomber();
				System.out.println("la caisse tombe");
			}
		}
	}

	public boolean estEnCollision(Caisse autre)
	{
		if(this.ligCaisse == autre.getCaisseLig() && this.colCaisse == autre.getCaisseCol())
		{
			return true;
		}
		return false;
	}

	/**
	 * Retourne le delta de la ligne pour la direction spécifiée.
	 * @param dir la direction
	 * @return le delta de la ligne
	 */
	private int deltaLig(char dir)
	{
		int delta;
		switch (dir)
		{
			case 'N': delta = -1; break;
			case 'S': delta = +1; break;
			default: delta = 0; break;
		}
		return delta;
	}

	/**
	 * Retourne le delta de la colonne pour la direction spécifiée.
	 * @param dir la direction
	 * @return le delta de la colonne
	 */
	private int deltaCol(char dir)
	{
		int delta;
		switch (dir)
		{
			case 'O': delta = -1; break;
			case 'E': delta = +1; break;
			default: delta = 0; break;
		}
		return delta;
	}
}