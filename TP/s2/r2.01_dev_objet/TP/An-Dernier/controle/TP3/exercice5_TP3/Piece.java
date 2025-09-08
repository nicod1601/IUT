
/*Solution 1
 * nous affectons les valeurs par défaut au niveau du constructeur sans paramètre.
 */

public class Piece
{
   private static int cptInstance;

   private String forme;
   private String couleur;
   private int    taille;
   private int    numInstance;

   public String toString()
	{
      return "("   + this.numInstance + "/"   + Piece.cptInstance +
             ") [" + this.forme       + " : " + this.couleur      + " (" + this.taille +" cm) ]";
   }

   public Piece()
   {
      this.forme     = "Sphere";
      this.couleur   = "Bleue";
      this.taille    = 4;

      this.numInstance = ++Piece.cptInstance;
   }

   public Piece(String forme, String couleur, int taille)
   {
      this.forme   = forme;
      this.couleur = couleur;
      this.taille  = taille;

      this.numInstance  = ++Piece.cptInstance;
   }

}

/*Solution 2
 * nous mettons des valeurs par défaut sur les attributs.
 *  Les valeurs ainsi définies seront les nouvelles valeurs
 *  par défaut affectées aux attributs d'instance à chaque nouvelle création d'objet. 
 * Bien entendu les valeurs de ces attributs pourront ensuite évoluer indépendamment 
 * au cours de la vie de nos objets.
 */

 public class Piece
{
   private static int cptInstance;

   private String forme    = "Sphere";
   private String couleur  = "Bleue";
   private int    taille   = 4;
   private int    numInstance;

   public String toString()
   {
      return "("   + this.numInstance + "/"   + Piece.cptInstance +
             ") [" + this.forme       + " : " + this.couleur      + " (" + this.taille +" cm) ]";
   }

   public Piece()
   {
      this.numInstance = ++Piece.cptInstance;
   }

   public Piece(String forme, String couleur, int taille)
   {
      this.forme   = forme;
      this.couleur = couleur;
      this.taille  = taille;

      this.numInstance  = ++Piece.cptInstance;
   }

}

/*Solution 3
 * Arrive alors la solution numéro 3, qui est à mon sens ici 
 * la plus élégante, car elle gère les valeurs par défaut des attributs 
 * d'instance dans des constructeurs, et évite la répétition de code 
 * pouvant être commun à l'ensemble des constructeurs.
 */

 public class Piece
 {
	private static int cptInstance;
 
	private String forme;
	private String couleur;
	private int    taille;
	private int    numInstance;
 
	public String toString()
	{
	   return "("   + this.numInstance + "/"   + Piece.cptInstance +
			  ") [" + this.forme       + " : " + this.couleur      + " (" + this.taille +" cm) ]";
	}
 
	public Piece()
	{
	   this ( "Sphere", "Bleue", 4);
	}
 
	public Piece(String forme, String couleur, int taille)
	{
	   this.forme   = forme;
	   this.couleur = couleur;
	   this.taille  = taille;
 
	   this.numInstance  = ++Piece.cptInstance;
	}
 
 }