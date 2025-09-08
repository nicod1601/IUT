public class Piece
{
	private String forme;
	private String couleur;
	private int    taille;

	public String toString()
	{
		return "[" + forme + " : " + couleur + " (" + taille +" cm) ]";
	}

}