public class Piece
{
   private String forme;
   private String couleur;
   private int    taille;

   public String toString()
   {
      return "[" + this.forme + " : " + this.couleur + " (" + this.taille +" cm) ]";
   }

   public Piece()
   {
		this.forme   = null;
		this.couleur = null;
		this.taille  = 0   ;

   }
}

