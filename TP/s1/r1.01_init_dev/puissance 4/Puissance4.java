import iut.algo.Clavier;
public class Puissance4 
{
    public static void main(String[] args) 
    {

        /*------------------*/
        /*     Constantes   */
        /*------------------*/
        final int NB_LIG = 6;
        final int NB_COL = 7;

        /*------------------*/
        /*     Variables    */
        /*------------------*/
        char joueur;
        int tour;
        boolean aGagne;
        boolean grillePleine;
        char[][] grille;
        char colonne;

        /*------------------*/
        /*   Instructions   */
        /*------------------*/
        joueur = 'X';
        tour = 1;
        aGagne = grillePleine = false;

        grille = new char[NB_LIG][NB_COL];

        Puissance4.initGrille(grille);
        Puissance4.afficher(grille);

        while(!aGagne && !grillePleine)
        {
            System.out.println("tour : " + tour + " Joueur : " + joueur + " choisissez une colonne : ");
            colonne = Clavier.lire_char();

            if(Puissance4.poserJetion(grille, colonne, joueur))
            {
                joueur = Puissance4.changerJouer(joueur);
                tour++;
            }
            else
            {
                System.out.println("Colonne invalide");
            }

            Puissance4.afficher(grille);
            grillePleine = Puissance4.grillePleine(grille);
            aGagne = Puissance4.gagne(grille);
        }

        if(aGagne)
        {
            System.out.println("Le joueur " + Puissance4.changerJouer(joueur) + " gagne en " + tour-- + " tours");
        }
        else
        {
            System.out.println("Partie nulle");
        }

    }

    private static char[][] initGrille(char[][] grille) 
    {
        for(int lig = 0; lig < grille.length; lig++)
        {
            for(int col = 0; col < grille[lig].length; col++)
            {
                grille[lig][col] = ' ';
            }
        }
        return grille;
    }

    private static void afficher(char[][] grille) 
    {
        System.out.println("+" + "---+".repeat(grille[0].length));
        System.out.print("|");
        for(int lig = 0; lig < grille.length; lig++)
        {
            
            for(int col = 0; col < grille[lig].length; col++)
            {
                System.out.print(" " + grille[lig][col] + " |");
            }
            System.out.println();
            System.out.print("+" + "---+".repeat(grille[lig].length) + "\n" +"|");

        }
    }

    private static boolean poserJetion(char[][] grille, char colonne, char joueur) 
    {
        for(int lig = grille.length - 1; lig >= 0; lig--)
        {
            if(grille[lig][colonne - 'A'] == ' ')
            {
                grille[lig][colonne - 'A'] = joueur;
                return true;
            }
        }
        return false;
    }

    private static char changerJouer(char joueur) 
    {
        if(joueur == 'X')
        {
            return 'O';
        }
        else
        {
            return 'X';
        }
    }

    private static boolean grillePleine(char[][] grille) 
    {
        for(int lig = 0; lig < grille.length; lig++)
        {
            for(int col = 0; col < grille[lig].length; col++)
            {
                if(grille[lig][col] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean gagne(char[][] grille)
    {
        for(int lig = 0; lig < grille.length; lig++)
        {
            for(int col = 0; col < grille[lig].length; col++)
            {
                if(grille[lig][col] != ' ' && grille[lig][col] == grille[lig][col + 1] && grille[lig][col] == grille[lig][col + 2] && grille[lig][col] == grille[lig][col + 3])
                {
                    return true;
                }
            }
        }

        for(int col= 0; col < grille[0].length; col++)
        {
            for(int lig = 0; lig < grille.length - 3; lig++)
            {
                if(grille[lig][col] != ' ' && grille[lig][col] == grille[lig + 1][col] && grille[lig][col] == grille[lig + 2][col] && grille[lig][col] == grille[lig + 3][col])
                {
                    return true;
                }
            }
        }

        for(int lig = 0; lig < grille.length - 3; lig++)
        {
            for(int col = 0; col < grille[0].length - 3; col++)
            {
                if(lig == col)
                {
                    if(grille[lig][col] != ' ' && grille[lig][col] == grille[lig + 1][col + 1] && grille[lig][col] == grille[lig + 2][col + 2] && grille[lig][col] == grille[lig + 3][col + 3])
                    {
                        return true;
                    }
                }
                else
                {
                    if(grille[lig][col] != ' ' && grille[lig][col] == grille[lig + 1][col + 1] && grille[lig][col] == grille[lig + 2][col + 2] && grille[lig][col] == grille[lig + 3][col + 3])
                    {
                        return true;
                    }
                }
            }
        }
        

        return false;
    }
}
