import java.util.ArrayList;
import java.util.Collections; 

public class Test9
{
   public static void main (String[] arg)
   {
      ArrayList<Piece> tab = new ArrayList<Piece>();


      tab.add ( new Piece( "Cube",     "Rouge", 1 ) );
      tab.add ( new Piece( "Cube",     "Rouge", 7 ) );
      tab.add ( new Piece( "Sphere",   "Mauve", 2 ) );
      tab.add ( new Piece( "Pyramide", "Rouge", 4 ) );
      tab.add ( new Piece( "Cube",     "Cyan",  1 ) );
      tab.add ( new Piece( "Pyramide", "Verte", 3 ) );

      System.out.println ( tab );

      Collections.sort ( tab );

      System.out.println ( tab );
   }
} 
