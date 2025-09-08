class SalleTP1 extends Salle
{
   private int nbPoste;


   public String toString()
   {
      return this.nbTable + " " + this.nbChaise + " " + this.nbPoste;
   }

   public static void main(String[] arg)
   {
      SalleTP1 salleTP= new SalleTP1();
      System.out.println ( salleTP );
   }
} 
