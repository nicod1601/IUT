import  iut.algo.Clavier;
public class Morpion
{
   public static void main (String[] a)
   {
      /*--------------*/
      /* Données      */
      /*--------------*/

      char[][] grille;
      char     joueur;

      int lig, col;

      boolean grillePleine, gagne;


      /*--------------*/
      /* Instructions */
      /*--------------*/

      grille = new char[3][3];
      grille = Morpion.initGrille (grille);


      joueur = 'X';

      grillePleine = gagne = false;


      //Affichage du tableau par appel à la méthode dédiée
      System.out.println ( Morpion.enChaine( grille ));

      while ( grillePleine == false && gagne == false )
      {
          //Demande au joueur en cours les coordonnées d'une case
          System.out.print("lig : ");
          lig = Clavier.lire_int();

          System.out.print("col : ");
          col = Clavier.lire_int();

          //Place éventuellement le symbole du joueur en cours
          if (grille[lig][col] == ' ')
          {
             grille[lig][col] = joueur;
          }
          else
          {
             System.out.println("Case occupée");

             // On redemande les coordonnées
             System.out.print("lig : ");
             lig = Clavier.lire_int();

             System.out.print("col : ");
             col = Clavier.lire_int();

             grille[lig][col] = joueur;
          }

          //Affichage de grille de jeu
          System.out.println ( Morpion.enChaine( grille ));

          //Passe au joueur suivant
          joueur = Morpion.joueurSuivant(joueur);

          //Gagne?
          if (Morpion.gagne(grille))
          {
             System.out.println("Le joueur " + joueur + " a gagné");
          }

          gagne = Morpion.gagne(grille);
          
          //Pleine?
          if (Morpion.grillePleine(grille))
          {
             System.out.println("Match nul");
          }

          grillePleine = Morpion.grillePleine(grille);

      }

   }

   public static char[][] initGrille ( char[][] gr )
   {
      for (int lig = 0; lig < gr.length; lig++)
      {
         for (int col = 0; col < gr[lig].length; col++)
         {
            gr[lig][col] = ' ';
         }
      }
      return gr;
   }


   public static String enChaine ( char[][] gr )
   {
      for (int lig = 0; lig < gr.length; lig++)
      {
         for (int col = 0; col < gr[lig].length; col++)
         {
            System.out.print(gr[lig][col]);
         }
         System.out.println();
      }
      return "";
   }
   
   public static boolean grillePleine ( char[][] gr )
   {
      for(int lig = 0; lig < gr.length; lig++)
      {
         for(int col = 0; col < gr[lig].length; col++)
         {
            if (gr[lig][col] == ' ')
            {
               return false;
            }
         }
      }
      return true;
   }

   public static char joueurSuivant ( char joueur )
   {
      if (joueur == 'X')
      {
         return 'O';
      }
      else
      {
         return 'X';
      }
   }
   
   public static boolean gagne ( char[][] gr )
   {
      for (int lig = 0; lig < gr.length; lig++)
      {
         for (int col = 0; col < gr[lig].length; col++)
         {
            
         }
      }
      return false;
   }
}