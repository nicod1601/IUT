public class TestInt 
{
    public static void main(String[] args)
    {
        final int ITERATION = 100000000;
        /*-----------------*/
        /*    Variables    */
        /*-----------------*/
        int intConteur;

        
         long debut = System.nanoTime();
         intConteur = -2147483648;
         for(int cpt = 0; cpt < ITERATION; cpt++)
         {
             intConteur++;
         }
         long fin = System.nanoTime();
         System.out.println("Temps d'exécution avec int: " + (fin - debut) + " nano");
    }
}
