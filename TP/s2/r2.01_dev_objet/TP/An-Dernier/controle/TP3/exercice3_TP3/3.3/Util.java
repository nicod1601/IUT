public class Util
{
   private Util(){}

   public static int min (int val1, int val2 )
   {
      if ( val1 < val2 ) return val1;
      return val2;
   }

   public static int max (int val1, int val2 )
   {
      if ( val1 > val2 ) return val1;
      return val2;
   }
}