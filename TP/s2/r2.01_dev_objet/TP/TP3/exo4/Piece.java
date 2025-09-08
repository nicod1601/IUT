public class Piece
{

	private static int nbInstance;
	private int    numInstance;
	private String forme;
	private String couleur;
	private int    taille;

	public String toString()
	{
	return "(" + this.numInstance + "/" + Piece.nbInstance +") [" + this.forme + " : " + this.couleur + " (" + this.taille +" cm) ]";
	}


	public Piece()
	{
		this(null, null, 0);
	}

	public Piece( String forme, String couleur, int taille)
	{
		this.forme = forme;
		this.couleur = couleur;
		this.taille = taille;
		this.numInstance = ++Piece.nbInstance;
	}

}