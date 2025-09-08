public class Test2
{
   public static void main (String[] arg)
   {
      Piece p1 = new Piece();
      Piece p2 = new Piece( "Cube", "Rouge", 6 );
      System.out.println ( p1.toString() );
      System.out.println ( p2.toString() );
   }
}