import iut.algo.Clavier;

public class Tableau
{
    public static void main(String[] a)
    {
       /*----------------------*/
       /*   Données          */
       /*----------------------*/
       int cptLig;
       int cptCol;
       int taille;

       /*----------------------*/
       /*   Instructions      */
       /*----------------------*/
       System.out.print("Entrez la taille: ");
       taille = Clavier.lire_int();
       cptLig = 1;

       System.out.println("+--".repeat(taille) + "+");
       while (cptLig <= taille)
       {
            cptCol = 1;
            while (cptCol <= taille)
            {
                 System.out.print("+ " + cptCol);
                cptCol++;
            }
            System.out.println("+");
            System.out.println("+--".repeat(taille) + "+");
            cptLig++;
       }
    }
}