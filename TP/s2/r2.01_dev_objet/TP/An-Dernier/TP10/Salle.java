public class Salle
{
   protected int nbTable;
   protected int nbChaise;

  public Salle()
   {
      this(12,24);
      System.out.println ( "**A**" );
   }

   public Salle(int nbTable, int nbChaise)
   {
      this.nbTable = nbTable;
      this.nbChaise = nbChaise;

      System.out.println ( "**B**" );
   }

   /*public static void main(String[] arg)
   {
      Salle salle1 = new Salle();
      System.out.println();
      Salle salle2 = new Salle(20,42);
   }*/
} 
