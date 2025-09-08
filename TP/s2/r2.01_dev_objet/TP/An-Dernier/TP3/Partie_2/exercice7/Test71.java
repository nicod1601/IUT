public class Test71
{
   public static void main (String[] arg)
   {

      Piece p1 = new Piece( "Cube", "Rouge", 6 );
      Piece p2 = new Piece( "Cube", "Rouge", 6 );

      System.out.println ( p1.toString() );
      System.out.println ( p2.toString() );

      System.out.print ( p1.equals   (p2) );
      System.out.println ();

   }
} 
