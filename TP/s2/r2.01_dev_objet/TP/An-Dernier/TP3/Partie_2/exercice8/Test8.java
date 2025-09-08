public class Test8
{
   public static void main (String[] arg)
   {

      Piece p1 = new Piece( "Cube",     "Rouge", 4 );
      Piece p2 = new Piece( "Cube",     "Rouge", 6 );
      Piece p3 = new Piece( "Pyramide", "Verte", 4 );

      System.out.println ( "comparaison p1 p2 : " + p1.compareTo (p2) );
      System.out.println ( "comparaison p1 p3 : " + p1.compareTo (p3) );
      System.out.println ( "comparaison p2 p3 : " + p2.compareTo (p3) );
   }
} 
