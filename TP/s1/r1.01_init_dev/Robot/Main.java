import iut.algo.Clavier;

public class Main 
{
    public static void main(String[] args) 
    {
        /*--------------*/
        /* Constante    */
        /*--------------*/

        final int  TAILLE_LIG = 8;
        final int  TAILLE_COL = 8;

        /*------------*/
        /* Variable   */
        /*------------*/
        Robot rb1;
        Robot rb2;
        Robot[][] tabRobots;

        String direction;

        /*---------------*/
        /* Instruction   */
        /*---------------*/
        rb1 =  new Robot(2, 'D', "jaune", 'W');
        rb2 =  new Robot(6, 'E', "blanc", 'E');

        tabRobots = new Robot[TAILLE_LIG][TAILLE_COL];

        tabRobots = Main.Inittab(tabRobots, rb1, rb2);

        System.out.println(Main.affichage(tabRobots));

        

        while(Main.fin(rb1, rb2) == false || Main.fin(rb2, rb1) == false)
        { 
            System.out.print("Direction Rb1:  ");
            direction = Clavier.lireString();

            Main.deplacementRb(direction, tabRobots, rb1);
            Main.fin(rb1, rb2);
            if(Main.fin(rb1, rb2) == true)
            {
                System.out.println("RB1 à WIN !!!!");
            }

            System.out.print("Direction Rb2:  ");
            direction = Clavier.lireString();

            Main.deplacementRb(direction, tabRobots, rb2);
            Main.fin(rb1, rb2);
            if(Main.fin(rb2, rb1) == true)
            {
                System.out.println("RB2 à WIN !!!!");
            }

           
            System.out.println(Main.fin(rb2, rb1));
            System.out.println(rb2.toString());
            System.out.println(rb1.toString());
        }
        

    }

    public static Robot[][] Inittab(Robot[][] tab, Robot rb1, Robot rb2)
    {
        for(int lig = 1; lig < tab.length; lig++)
        {
            for(char col = 'A'; col < 'A' + tab[0].length; col++)
            {
                int colIndex = col - 'A'; // Convert char to integer index

                if (rb1.getLigne() == lig && rb1.getColonne() == col)
                {
                    tab[lig][colIndex] = rb1;
                } 
                else
                {
                    if (rb2.getLigne() == lig && rb2.getColonne() == col)
                    {
                        tab[lig][colIndex] = rb2;
                    }
                    else 
                    {
                        tab[lig][colIndex] = null;
                    }
                } 
                
            }
            
        }
        return tab;
    }

    public static String affichage(Robot[][] tab)
    {
        String str ="";

        str += "+" + "----+".repeat(tab.length) + "\n";

        for(int lig = 0; lig < tab.length; lig++)
        {
            str += "|";
            for (int col = 0; col < tab[0].length; col++)
            {
                if (tab[lig][col] == null)
                {
                    str += String.format("%5s", "|");
                } 
                else 
                {
                    str += "  X |";
                }
            }
            str += "\n";
            str += "+" + "----+".repeat(tab.length) + "\n";
        }

        return str;
    }

    public static void deplacementRb(String direction, Robot[][] tab, Robot rb)
    {
        // Position actuelle du robot
        int ligneActuelle = rb.getLigne();
        int colActuelle = rb.getColonne() - 'A';
    
        // Variables pour la nouvelle position
        int nouvelleLigne = ligneActuelle;
        int nouvelleColonne = colActuelle;
    
        switch (direction.toUpperCase())
        {
            case "N":
                nouvelleLigne -= 1; // Aller vers le nord (haut)
                break;
            case "S":
                nouvelleLigne += 1; // Aller vers le sud (bas)
                break;
            case "E":
                nouvelleColonne += 1; // Aller vers l'est (droite)
                break;
            case "O":
                nouvelleColonne -= 1; // Aller vers l'ouest (gauche)
                break;
            default:
                System.out.println("Direction invalide !");
                return;
        }
    
        // Vérification des limites
        if (nouvelleLigne < 0 || nouvelleLigne >= tab.length || nouvelleColonne < 0 || nouvelleColonne >= tab[0].length) 
        {
            System.out.println("Déplacement hors limites !");
            return;
        }
    
        // Vérification si la case cible est vide
        if (tab[nouvelleLigne][nouvelleColonne] == null)
        {
            // Effectuer l'échange des positions
            tab[ligneActuelle][colActuelle] = null;
            tab[nouvelleLigne][nouvelleColonne] = rb;
    
            // Mise à jour des coordonnées du robot
            rb.setLigne(nouvelleLigne);
            rb.setColonne((char) ('A' + nouvelleColonne));
        }
    
        // Affichage du tableau mis à jour
        System.out.println(Main.affichage(tab));
    }

    public static boolean fin(Robot rbP, Robot rbD)
    {
        if(rbP.getLigne() == rbD.getLigne() && rbP.getColonne() == rbD.getColonne())
        {
            return true;
        }
        return false;
    }
}
