public abstract class Polygone
{
   protected double[] cotes ; //tableau des longueurs de côtés successifs

   protected Polygone(int nbCotes)
   {
    this.cotes=new double[nbCotes];
   }

   public double getPerimetre()
   {
      // calcule le périmètre : somme des longueurs des côtés
      double perimetre;

      perimetre = 0.0;
      for(int cpt=0; cpt < this.cotes.length; cpt++)
      {
         perimetre += cotes[cpt];
      }
      return perimetre;
   }
   public abstract double getAire();
   
   public String toString()
   {
      String s="Figure : " + this.getClass().getName() + "\n";
      s = s + "a pour côtés : " ;

      for(int i=0;i< this.cotes.length; i++)
         s = s + this.cotes[i] + "\t";

      s = s + "\na pour périmètre : " + this.getPerimetre() + "\n" +
              "a pour aire : "        + this.getAire()      + "\n";

      return s ;
   }
} 
