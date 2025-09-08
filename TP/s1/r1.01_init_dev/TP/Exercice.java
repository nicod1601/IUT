import iut.algo.*;
public class Exercice
{
    public static void main(String[] args)
    {
        /*------------------------------ */
        /*            Donnée             */
        /*------------------------------ */

        // Constante 
        final int NB_COL = 15;
        final int NB_LIG = 10;

        // Variable
        String tableau[][] = new String[NB_LIG][NB_COL];
        int cptLig, cptCol;
        int nbLig, nbCol;

        /*------------------------------ */
        /*           Instruction         */
        /*------------------------------ */
        System.out.print("Saisir le nombre de lignes : ");
        nbLig = Clavier.lire_int();

        System.out.print("Saisir le nombre de colonnes : ");
        nbCol = Clavier.lire_int();

        cptLig = 0;
        
        while (cptLig < NB_LIG)
        {
            cptCol = 0;
            while (cptCol < NB_COL)
            {
                if(cptCol == nbCol || cptLig == nbLig)
                {
                    if(cptCol == nbCol && cptLig == nbLig)
                    {
                        tableau[cptLig][cptCol] = "O";
                    }
                    else
                    {
                        tableau[cptLig][cptCol] = "X";
                    }
                    
                }
                else
                {
                    tableau[cptLig][cptCol] = " " ;
                }
                cptCol++;
            }
            cptLig++;
        }

        cptLig = 0;
        while (cptLig < NB_LIG)
        {
            System.out.println("+" + "-+".repeat(NB_COL));
            cptCol = 0;
            while (cptCol < NB_COL)
            {
                System.out.print("|" + tableau[cptLig][cptCol]);
                cptCol++;
            }
            System.out.println("|");
            cptLig++;
        }
        System.out.println("+" + "-+".repeat(NB_COL));


        System.out.println();
        System.out.println();


        /*exercice 19 */
        /*------------------------------ */
        /*            Donnée             */
        /*------------------------------ */

        // Constante 
        final int NB_COL2 = 11;
        final int NB_LIG2 = 11;

        // Variable
        String tableau2[][] = new String[NB_LIG2][NB_COL2];
        int cptLig2, cptCol2;
        int nbLig2, nbCol2;

        /*------------------------------ */
         /*           Instruction         */
        /*------------------------------ */

        System.out.print("Saisir le nombre de lignes : ");
        nbLig2 = Clavier.lire_int();

        System.out.print("Saisir le nombre de colonnes : ");
        nbCol2 = Clavier.lire_int();


        cptLig2 = 0;
        while (cptLig2 < NB_LIG2)
        {
            cptCol2 = 0;
            while (cptCol2 < NB_COL2)
            {
                if(cptCol2 == nbCol2 || cptLig2 == nbLig2)
                {
                    tableau2[cptLig2][cptCol2] = "X";
                }
                else
                {
                    tableau2[cptLig2][cptCol2] = " ";
                }
                cptCol2++;
            }
            cptLig2++;
        }


        //diaginale
        cptLig2 = 0;
        while (cptLig2 < NB_LIG2)
        {
            cptCol2 = 0;
            while (cptCol2 < NB_COL2)
            {
                if(cptCol2 == cptLig2)
                {
                    tableau2[cptLig2][cptCol2] = "X";
                }
                cptCol2++;
            }
            cptLig2++; // Il manquait cette ligne pour incrémenter cptLig2
        }


        cptLig2 = 0;
        while (cptLig2 < NB_LIG2)
        {
            System.out.println("+" + "-+".repeat(NB_COL2));
            cptCol2 = 0;
            while (cptCol2 < NB_COL2)
            {
                System.out.print("|" + tableau2[cptLig2][cptCol2]);
                cptCol2++;
            }
            System.out.println("|");
            cptLig2++;
        }
        System.out.println("+" + "-+".repeat(NB_COL2));
    }

    

}