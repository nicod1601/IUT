import iut.algo.Clavier;

public class Tableau
{
    public static void main(String[] a)
    {
       /*----------------------*/
       /*   Données          */
       /*----------------------*/
       int nbLettre;
       char[] tab;
       int cpt;

       char cara;
       /*----------------------*/
       /*   Instructions      */
       /*----------------------*/
       System.out.print("Entrez la nombre de lettre: ");
       nbLettre = Clavier.lire_int();


       tab = new char[nbLettre];
       cara = 'A';
       cpt = 0;
       while(cpt < nbLettre)
       {
           tab[cpt] = cara;
           cpt++;
           cara = (char) (cara + 1);
       }

       cpt = 0;
       while(cpt < nbLettre)
       {
           System.out.print(tab[cpt] + " ");
           cpt++;
       }
       
    }
}
