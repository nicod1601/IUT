public class Article
{
   private int    reference;
   private double prix;
   private String designation;

   public void   setReference  (int    reference)  { this.reference   = reference;   }
   public void   setDesignation(String designation){ this.designation = designation; }
   public void   setPrix       (double prix)       { this.prix        = prix;        }

   public int    getReference  (){ return this.reference;   }
   public String getDesignation(){ return this.designation; }
   public double getPrix       (){ return this.prix;        }

   public String toString()
   {
      return this.reference + " " + this.designation + ": "+ this.prix + " euros";
   }

}
