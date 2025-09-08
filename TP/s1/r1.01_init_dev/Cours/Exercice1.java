/** Ex 1 (SAE 1.02)
    Devoir à rendre
    @autor Damestoy Ethan, Delpech Nicolas, Grangeon Alan et Bermendora Pol Armand
    @version 22/11/2024
*/

public class Exercice1 {

    public static void main(String[] argv)
    {

        /*----------------*/
        /*   Données      /
        /----------------/s

        /*  Variables    */
        /*- - - - - - - - */

        long debut, fin;

        /*----------------*/
        /*  Instructions  */
        /*----------------*/

        debut = System.nanoTime();
        for (short i = 0; i<10000; i++)
        {
            for (short j = 0; j<10000; j++)
            {
            }
        }
        fin = System.nanoTime();
        System.out.println("Short : " + (fin-debut) + " ns");

        debut = System.nanoTime();

        for (int i = 0; i<10000; i++)
        {
            for (int j = 0; j<10000; j++)
            {
            }
        }

        fin = System.nanoTime();

        System.out.println("Int   : " + (fin-debut) + " ns");

        debut = System.nanoTime();

        for (long i = 0; i<10000; i++)
        {
            for (long j = 0; j<10000; j++)
            {
            }
        }

        fin = System.nanoTime();

        System.out.println("Long  : " + (fin-debut) + " ns");

    }

} 