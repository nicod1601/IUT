import iut.algo.Clavier;
import java.util.ArrayList;
import java.util.List;

public class Snake2 {
    public static void main(String[] args) {
        /*-----------------*/
        /*    Constante    */
        /*-----------------*/
        final int NB_CASE = 10;
        /*-----------------*/
        /*    Variables    */
        /*-----------------*/
        char[][] grille;
        int toure;
        char direction;

        int ligP, colP;
        List<int[]> snakeBody = new ArrayList<>(); // Liste pour stocker les positions du serpent

        /*-----------------*/
        /*   Instructions  */
        /*-----------------*/
        grille = new char[NB_CASE][NB_CASE];

        // Position initiale du serpent
        int ligS = grille.length / 2;
        int colS = grille[0].length / 2;
        snakeBody.add(new int[]{ligS, colS}); // Tête du serpent

        // Position initiale de la pomme
        ligP = (int) (Math.random() * NB_CASE);
        colP = (int) (Math.random() * NB_CASE);

        // Initialisation de la grille
        grille = initGrille(grille, snakeBody, ligP, colP);

        // Affichage initial
        System.out.println(afficheGrille(grille));

        toure = 0;
        while (toure < 100) {
            System.out.println("Direction (z, q, s, d) :");
            direction = Clavier.lire_char();

            // Mise à jour des coordonnées du serpent
            snakeBody = deplacement(grille, direction, snakeBody);

            // Vérifie si la pomme est mangée
            int[] head = snakeBody.get(0); // La tête du serpent
            if (head[0] == ligP && head[1] == colP) {
                System.out.println("Pomme mangée !");
                snakeBody.add(new int[]{-1, -1}); // Ajoute un segment temporaire
                ligP = (int) (Math.random() * NB_CASE);
                colP = (int) (Math.random() * NB_CASE);
                grille[ligP][colP] = 'O';
            }

            // Met à jour la grille
            grille = initGrille(grille, snakeBody, ligP, colP);

            // Affichage de la grille
            System.out.println(afficheGrille(grille));
            toure++;
        }
    }

    public static char[][] initGrille(char[][] grille, List<int[]> snakeBody, int ligP, int colP) {
        // Vide la grille
        for (int cpt = 0; cpt < grille.length; cpt++) {
            for (int cpt2 = 0; cpt2 < grille[0].length; cpt2++) {
                grille[cpt][cpt2] = ' ';
            }
        }

        // Place la pomme
        grille[ligP][colP] = 'O';

        // Place le serpent
        for (int i = 0; i < snakeBody.size(); i++) {
            int[] part = snakeBody.get(i);
            if (part[0] != -1 && part[1] != -1) { // Ignore les segments temporaires
                grille[part[0]][part[1]] = (i == 0) ? 'S' : 'M'; // 'S' pour la tête, 'M' pour le corps
            }
        }

        return grille;
    }

    public static String afficheGrille(char[][] grille) {
        StringBuilder affiche = new StringBuilder();
        affiche.append("  ".repeat(grille[0].length)).append("\n");
        for (int cpt = 0; cpt < grille.length; cpt++) {
            affiche.append(" |");
            for (int cpt2 = 0; cpt2 < grille[0].length; cpt2++) {
                affiche.append(grille[cpt][cpt2]).append("|");
            }
            affiche.append("\n");
        }
        return affiche.toString();
    }

    public static List<int[]> deplacement(char[][] grille, char direction, List<int[]> snakeBody) {
        // Calcule la nouvelle position de la tête
        int[] head = snakeBody.get(0);
        int newLigS = head[0];
        int newColS = head[1];

        switch (direction) {
            case 'z': // Haut
                newLigS = Math.max(0, newLigS - 1);
                break;
            case 'q': // Gauche
                newColS = Math.max(0, newColS - 1);
                break;
            case 's': // Bas
                newLigS = Math.min(grille.length - 1, newLigS + 1);
                break;
            case 'd': // Droite
                newColS = Math.min(grille[0].length - 1, newColS + 1);
                break;
        }

        // Ajoute la nouvelle tête à la liste
        snakeBody.add(0, new int[]{newLigS, newColS});

        // Retire le dernier segment si le serpent n'a pas grandi
        if (snakeBody.get(snakeBody.size() - 1)[0] == -1) {
            snakeBody.remove(snakeBody.size() - 1);
        } else {
            snakeBody.remove(snakeBody.size() - 1);
        }

        return snakeBody;
    }
}

