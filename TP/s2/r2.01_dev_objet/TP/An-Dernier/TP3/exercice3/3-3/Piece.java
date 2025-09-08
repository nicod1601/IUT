public class Piece
{
	private static int nbInstance;

   private String forme;
   private String couleur;
   private int    taille;
   private int numInstance;

	public Piece()
	{
		this.forme   = null;
		this.couleur = null;
		this.taille  = 0   ;

		// sinon autre écriture this (null, null, 0);

	}
	
	public Piece( String forme, String couleur, int taille)
	{
		this.numInstance = ++Piece.nbInstance;
		this.forme = forme;
		this.couleur = couleur;
		this.taille = taille;
	}
	
	public String toString()
	{
   		return "(" + this.numInstance + "/" + Piece.nbInstance +") [" + this.forme + " : " + this.couleur + " (" + this.taille +" cm) ]";
	} 
}

