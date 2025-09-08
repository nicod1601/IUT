public class Piece
{
	private static int nbInstance;

   private String forme;
   private String couleur;
   private int    taille;
   private int numInstance;

	public Piece()
	{
		this ("Sphère", "Bleue", 4);

	}
	
	public Piece( String forme, String couleur, int taille)
	{
		this.numInstance = ++Piece.nbInstance;
		this.forme = forme;
		this.couleur = couleur;
		this.taille = taille;
	}
	
	public boolean Verif (Piece p)
	{
	    return (this.forme + this.couleur).equals(p.forme + p.couleur);
	}
	
	public int compareTo(Piece p)
	{
		return this.taille - p.taille;
	}
	
	
	public String toString()
	{
   		return "(" + this.numInstance + "/" + Piece.nbInstance +") [" + this.forme + " : " + this.couleur + " (" + this.taille +" cm) ]";
	}
}

