class SalleTP2 extends Salle
{
   private int nbPoste;
   
   public SalleTP2()
   {
      super();
      this.nbPoste = this.nbTable;
   }

   public String toString()
   {
      return this.nbTable + " " + this.nbChaise + " " + this.nbPoste;
   }

   public static void main(String[] arg)
   {
      SalleTP2 salleTP= new SalleTP2();
      System.out.println ( salleTP );
   }
}