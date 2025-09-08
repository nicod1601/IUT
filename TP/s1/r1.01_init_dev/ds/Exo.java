import iut.algo.Clavier;

public class Exo
{
    public static void main(String[] arg) 
    {
        /*------------------- */
        /*       Donnée       */
        /*------------------- */

        char[] tab = genererTabRepartition();
        String[] tabProba = genererTabRepartition();

        

        /*------------------- */
        /*    Instrcution     */
        /*------------------- */

         System.out.println(toString(tab));


    }

    private static char[] genererTabRepartition()
    {
        

        int proporMais  ;
        int proporIndigo;
        int proporCannes ;

        int somme = 25;
        
        char[] tab = new char[somme];

        System.out.print("Prportion de Mais    : ");
        proporMais = Clavier.lire_int();

        System.out.print("Prportion d'Indigo   : ");
        proporIndigo = Clavier.lire_int();
        
        System.out.print("Prportion de Cannes : ");
        proporCannes = Clavier.lire_int();




        while(proporMais + proporCannes + proporIndigo > somme)
        {
            System.out.println("La somme des proportions dépasse 25");

            System.out.print("Prportion de Mais    : ");
            proporMais = Clavier.lire_int();

            System.out.print("Prportion d'Indigo   : ");
            proporIndigo = Clavier.lire_int();

            System.out.print("Prportion de Cannes : ");
            proporCannes = Clavier.lire_int();
        }

        // Remplit le tableau avec les proportions spécifiées
        int index = 0;

        // Remplissage pour le maïs
        for (int i = 0; i < proporMais; i++)
        {
            tab[index++] = 'M';
        }

        // Remplissage pour l'indigo
        for (int i = 0; i < proporIndigo; i++)
        {
            tab[index++] = 'I';
        }

        // Remplissage pour les cannes
        for (int i = 0; i < proporCannes; i++)
        {
            tab[index++] = 'C';
        }

        // Remplissage des cases restantes avec des points
        while (index < somme)
        {
            tab[index++] = '.';
        }

        return tab;
    }

    private static String toString(char[] tab)
    {
        String str = "";

        for(int cpt1=0; cpt1 < 4; cpt1++)
        {
            for(int cpt=0; cpt < tab.length; cpt++)
            {
                if(cpt1 < 1)
                {
                    str += (tab[cpt] + " ");
                    
                }
                else
                {
                    str += ". ";
                }
                
            }
            str += '\n';
        }

        return str;
    }
}