public class Piece
{
	/* Attributs de classe */
	private static int cptInstance = 0;

	/* Attributs d'instance */
	private String forme   ;
	private String couleur ;
	private int    taille  ;
	private int    numInstance;


	public Piece()
	{
		this.forme   = null;
		this.couleur = null;
		this.taille  = 0;

		this.numInstance = ++Piece.cptInstance;
	}

	public Piece(String forme, String couleur, int taille)
	{
		this.forme   = forme;
		this.couleur = couleur;
		this.taille  = taille;

		this.numInstance = ++Piece.cptInstance;
	}

	public String toString()
	{
		return "(" + this.numInstance + "/"   + Piece.cptInstance + ") " +
		       "[" + this.forme       + " : " + this.couleur + " (" + this.taille +" cm) ]";
	}
}