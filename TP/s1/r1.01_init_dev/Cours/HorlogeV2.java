public class HorlogeV2 
{
    public static void main(String[] args)
    {

        /*----------------- */
        /*    Variables     */
        /*----------------- */
        int secondes;
        String affichage;

        long debut;
        long fin;

        /*----------------- */
        /*    Instructions  */
        /*----------------- */
        secondes = 0;

        debut = System.nanoTime();
        for(int cpt =0; cpt<80000; cpt++)
        {
            secondes++;
            affichage = "" + (secondes / 3600) + "H " + (secondes % 3600 ) / 60 + "M " + secondes % 60 + "S";
        }

        fin = System.nanoTime();
        System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
    }
}
