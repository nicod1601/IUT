public class Test73
{
   public static void main (String[] arg)
   {

      System.out.print ( " couleur p1 : " );
      Piece p1 = new Piece( "Cube",     Clavier.lireString(), 4 );

      System.out.print ( " couleur p2 : " );
      Piece p2 = new Piece( "Cube",     Clavier.lireString(), 6 );

      System.out.print ( " couleur p3 : " );
      Piece p3 = new Piece( "Pyramide", Clavier.lireString(), 4 );

      System.out.println ( "comparaison p1 p2 : " + p1.         (p2) );
      System.out.println ( "comparaison p1 p3 : " + p1.         (p3) );
   }
} 
