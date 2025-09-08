import java.util.GregorianCalendar;

public class HorlogeV1 
{
    public static void main(String[] args)
    {
        /*----------------- */
        /*    Variables     */
        /*----------------- */
        GregorianCalendar calendar;
        int heures;
        int minutes;
        int secondes;

        long debut;
        long fin;

        /*----------------- */
        /*    Instructions  */
        /*----------------- */
        calendar = new GregorianCalendar();

        debut = System.nanoTime();
        for(int cpt =0; cpt<100000000; cpt++)
        {
            heures = calendar.get(GregorianCalendar.HOUR_OF_DAY);
            minutes = calendar.get(GregorianCalendar.MINUTE);
            secondes = calendar.get(GregorianCalendar.SECOND);

            System.out.println(heures + ":" + minutes + ":" + secondes);
        }
        fin = System.nanoTime();
        System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
    }
}
