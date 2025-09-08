public class TT 
{
    public static void main(String[] args) 
    {
        int cpt = 0;
        while (true) 
        { 
          System.out.print("| ");
          try{Thread .sleep(100);}catch(Exception e){}
          cpt++;
          if(cpt == 100)
          {
            System.out.println("vous avez perdu");
          }
        }
    }
}
