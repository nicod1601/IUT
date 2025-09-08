package quarto.metier;

/** Cette classe permet de gérer une Piece.
  * Une pièce possède 4 type de caractéristiques avec des 2 valeurs pour
  * chacune des caractéristiques.
  * @author Philippe Le Pivert.
  */
class Piece
{
	/* Attributs de Classe   */
	/* - - - - - - - - - - - */

	/** Couleur : Bleu Rouge   */
	static final String[] tabCouleur = { "Bl", "Rg" };

	/** Volume  : Creux Plein  */
	static final String[] tabEtat    = { "Cr", "Pl" };

	/** Taille  : Grand Petit  */
	static final String[] tabTaille  = { "Gd", "Pt" };

	/** Forme   : Rond Carré   */
	static final String[] tabForme   = { "Rd", "Ca" };


	/* Attributs d'instance  */
	/* - - - - - - - - - - - */

	private String couleur;
	private String etat;
	private String taille;
	private String forme;


	/** Constructeur d'une Piece */
	public Piece ( String couleur, String etat, String taille, String forme )
	{
		this.couleur = couleur;
		this.etat    = etat;
		this.taille  = taille;
		this.forme   = forme;
	}

	/** Retourne la valeur d'une des 4 caractéristiques d'une Piece */
	public String getCarac(String carac)
	{
		if ( carac.equals( "couleur" ) ) return this.couleur;
		if ( carac.equals( "etat"    ) ) return this.etat;
		if ( carac.equals( "taille"  ) ) return this.taille;
		if ( carac.equals( "forme"   ) ) return this.forme;

		return null;
	}

	/* Retourne sous forme Textuelle l'état d'une Piece */
	public String toString()
	{
		return this.couleur + this.etat + this.taille + this.forme;
	}
}
