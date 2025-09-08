import iut.algo.*;

public class TestGraphique
{
    public static void main(String[] a)
    {
        /*-----------------*/
        /* Variables       */
        /*-----------------*/
        ControleGraphique ct;
        int ecartX;  // écart horizontal
        int ecartY;  // écart vertical

        int cptLig;  // compteur pour les lignes
        int cptCol;  // compteur pour les colonnes
        int taille;  // taille du plateau (ici 3x3)

        /*-----------------*/
        /* Instructions    */
        /*-----------------*/

        /* initialisation de la zone de dessin */
        ct = new ControleGraphique();
        ct.setTaille(600, 600);  // taille de la fenêtre

        taille = 3;  // Plateau 3x3
        int tailleCarre = 100;  // Taille de chaque carré

        // On part d'une position initiale
        int positionDepartX = 50;
        int positionDepartY = 50;

        for (cptLig = 0; cptLig < taille; cptLig++) {
            for (cptCol = 0; cptCol < taille; cptCol++) {
                // Calcul de la position de chaque carré sans écart
                ecartX = positionDepartX + cptCol * tailleCarre;
                ecartY = positionDepartY + cptLig * tailleCarre;

                // Dessiner un rectangle (carré) à la position calculée
                ct.rectanglePeint(ecartX, ecartY, ecartX + tailleCarre, ecartY + tailleCarre, Couleur.GRIS);
            }
        }
    }
}
