/**
 * @version 1.0
 * @author Delpech Nicolas
 * @date 22/11/2024
 */
public class Symetrie 
{
    public static void main(String[] args) 
    {
        /*------------------*/
        /*    Variables     */
        /*------------------*/
        char[][] tabSys1;
        char[][] tabSys2;

        /*------------------*/
        /*    Instructions  */
        /*------------------*/

        tabSys1 = new char[][] { { 'A', 'E', 'I', 'M', 'Q' }, 
                                 { 'B', 'F', 'J', 'N', 'R' }, 
                                 { 'C', 'G', 'K', 'O', 'S' }, 
                                 { 'D', 'H', 'L', 'P', 'T' } 
                                                              };

        tabSys2 = new char[][] { { 'A', 'E', 'I', 'M', 'Q' }, 
                                 { 'B', 'F', 'J', 'N', 'R' }, 
                                 { 'C', 'G', 'K', 'O', 'S' }, 
                                 { 'D', 'H', 'L', 'P', 'T' } 
                                                              };

        tabSys1 = symetrie1(tabSys1);
        
        // afficahe du tableau normal
        for(int cpt = 0; cpt < tabSys1.length; cpt++)
        {
            for(int cpt2 = 0; cpt2 < tabSys1[cpt].length; cpt2++)
            {
                System.out.print(tabSys1[cpt][cpt2] + " ");
            }
            System.out.println();
        }


        System.out.println();


        tabSys2 = symetrie2(tabSys2);

        // afficahe du tableau symétrique
        for(int cpt = 0; cpt < tabSys2.length; cpt++)
        {
            for(int cpt2 = 0; cpt2 < tabSys2[cpt].length; cpt2++)
            {
                System.out.print(tabSys2[cpt][cpt2] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] symetrie1(char[][] tab) 
    {
        char tmp;

        long debut = System.nanoTime();
        for(int lig = 0; lig < tab.length; lig++)
        {
            for(int col = 0; col < tab[lig].length / 2; col++)
            {
                tmp = tab[lig][col];
                tab[lig][col] = tab[lig][tab[lig].length - 1 - col];
                tab[lig][tab[lig].length - 1 - col] = tmp;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
        return tab;
        
    }

    public static char[][] symetrie2(char[][] tab) 
    {
        long debut = System.nanoTime();
        char[][] symetrique2 = new char[tab.length][tab[0].length];


        for (int lig = 0; lig < tab.length; lig++) 
        {
            for (int col = 0; col < tab[0].length; col++) 
            {
                symetrique2[lig][col] = tab[lig][tab[0].length - 1 - col];
            }
        }
        long fin = System.nanoTime();
        System.out.println("Temps d'exécution: " + (fin - debut) + " nano");
        return symetrique2;
    }
}
