public class ArticlePerissable extends Article
{
   private String datePerim;     // date de peremption au format "jj/mm/aaaa"

   public void   setDatePerim  (String datePerim)  { this.datePerim   = datePerim;   }
   public String getDatePerim  (){ return this.datePerim;   }

   public String toString()
   {
      return super.toString() + "Date de Pérenption : " + this.datePerim;
   }
}