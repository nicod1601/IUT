public class Piece implements Comparable<Piece>
{
   private static int cptInstance;

   private String forme;
   private String couleur;
   private int    taille;
   private int    numInstance;

   public String toString()
   {
      return "(" + numInstance +"/" + cptInstance +") [" + forme + " : " + couleur + " (" + taille +" cm) ]";
   }

   public Piece()
   {
      this("Sphere", "Bleue", 4 );
   }
   
	public int compareTo( Piece p)
	{
		return this.taille - p.taille;
	}

   public Piece(String forme, String couleur, int taille)
   {
      this.forme   = forme;
      this.couleur = couleur;
      this.taille  = taille;

      numInstance = ++cptInstance;
   }

}

