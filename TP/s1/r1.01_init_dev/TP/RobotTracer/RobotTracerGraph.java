import iut.algo.*;

/**
 * @author : Delpech Nicolas
 * @version : 1.0
 * @date : 30/11/2021
 * 
 * RobotTracer
 */
public class RobotTracerGraph
{
    public static void main(String[] args) 
    {
        /*------------*/
        /* Variables  */
        /*------------*/
        ControleGraphique ct;
        char orientation;
        int avance;
        int cordX, cordY;
        String action;
        boolean traceurActif = true; // Le traceur est actif par défaut
        
        int cordXDep, cordYDep;
       
        /*--------------*/
        /* Instructions  */
        /*--------------*/
        
        // Initialisation
        ct = new ControleGraphique();
        ct.prendreStylo(Couleur.NOIR);
        ct.setTaille(600, 500);
        
        cordX = cordY = 100;
        cordXDep = cordYDep = 100;
        orientation = 'N';
        
        // Dessin initial du cercle
        ct.cercle(cordXDep, cordYDep, 10);
        dessinerFleche(ct, cordXDep, cordYDep, orientation, traceurActif);
        
        ct.setTypeAction('F'); // Basculer sur le calque fixe
        ct.effacer('F'); // Effacer le calque fixe si nécessaire
        ct.majDessin(); // Mettre à jour l'affichage

        //---------------------------------------
        System.out.print("action : ");
        action = Clavier.lireString();

        while (!action.equals("FIN"))
        {
            if (estEntier(action))
            {
                avance = Integer.parseInt(action); // Convertir la chaîne en entier

                // Calculer les nouvelles coordonnées selon l'orientation
                int ancienCordXDep = cordXDep;
                int ancienCordYDep = cordYDep;

                if (orientation == 'N')
                {
                    cordYDep = cordYDep - avance;
                }
                else if (orientation == 'S')
                {
                    cordYDep = cordYDep + avance;
                }
                else if (orientation == 'O') // Ouest
                {
                    cordXDep = cordXDep - avance;
                }
                else if (orientation == 'E') // Est
                {
                    cordXDep = cordXDep + avance;
                }

                // Si le traceur est actif, tracer la ligne
                if (traceurActif) {
                    ct.setTypeAction('F');
                    ct.prendreStylo(Couleur.NOIR);
                    ct.ligne(ancienCordXDep, ancienCordYDep, cordXDep, cordYDep);
                }

                ct.majDessin(); // Mettre à jour l'affichage pour le calque fixe

                // Dessiner le nouveau cercle sur le calque M
                ct.setTypeAction('M');
                ct.effacer('M'); // Effacer l'ancien robot
                ct.cercle(cordXDep, cordYDep, 10);
                
                // Dessiner le triangle en fonction de l'orientation
                dessinerFleche(ct, cordXDep, cordYDep, orientation, traceurActif);

                ct.majDessin(); // Mettre à jour l'affichage pour le calque mobile
            }
            else if (action.equals("T")) // Action pour lever ou abaisser le traceur
            {
                // Inverser l'état du traceur
                traceurActif = !traceurActif;

                // Changer la couleur du robot en fonction de l'état du traceur
                ct.setTypeAction('M');
                ct.effacer('M'); // Effacer l'ancien robot
                ct.prendreStylo(traceurActif ? Couleur.NOIR : Couleur.ROUGE);
                ct.cercle(cordXDep, cordYDep, 10);
                dessinerFleche(ct, cordXDep, cordYDep, orientation, traceurActif);
                ct.majDessin(); // Mettre à jour l'affichage pour le calque mobile
            }
            else
            {
                orientation = Orientation(action, orientation);
                ct.setTypeAction('M');
                ct.effacer('M'); // Effacer l'ancien robot
                ct.prendreStylo(traceurActif ? Couleur.NOIR : Couleur.ROUGE);
                ct.cercle(cordXDep, cordYDep, 10);
                dessinerFleche(ct, cordXDep, cordYDep, orientation, traceurActif);
            }
            
            System.out.println("[" + orientation + "    " + String.format("%3d", cordXDep) + ":" + String.format("%3d", cordYDep) + "]");
            ct.majDessin();
            
            // Nouvelle action
            System.out.print("action : ");
            action = Clavier.lireString();
        }
    }
    public static void dessinerFleche(ControleGraphique ct, int x, int y, char orientation, boolean traceurActif) {
        int taille = 10; // Taille de la flèche (vous pouvez ajuster selon vos besoins)
        int rayonCercle = 10; // Rayon du cercle
    
        // Définir les points de la flèche en fonction de l'orientation
        int x1 = x; // Point de la tête de la flèche
        int y1 = y; // Point de la tête de la flèche
        int x2, y2, x3, y3;
    
        // Calculer la position de la flèche au bord du cercle
        switch (orientation) {
            case 'N':
                y1 -= rayonCercle; // Déplacer y vers le haut
                x2 = x - taille; 
                y2 = y1 + taille; 
                x3 = x + taille; 
                y3 = y1 + taille; 
                break;
            case 'S':
                y1 += rayonCercle; // Déplacer y vers le bas
                x2 = x - taille; 
                y2 = y1 - taille; 
                x3 = x + taille; 
                y3 = y1 - taille; 
                break;
            case 'O':
                x1 -= rayonCercle; // Déplacer x vers la gauche
                x2 = x1 + taille; 
                y2 = y1 - taille; 
                x3 = x1 + taille; 
                y3 = y1 + taille; 
                break;
            case 'E':
                x1 += rayonCercle; // Déplacer x vers la droite
                x2 = x1 - taille; 
                y2 = y1 - taille; 
                x3 = x1 - taille; 
                y3 = y1 + taille; 
                break;
            default:
                return; // Si orientation n'est pas reconnue, ne rien dessiner
        }
    
        // Dessiner la flèche
        ct.prendreStylo(traceurActif ? Couleur.NOIR : Couleur.ROUGE); // Rouge si le traceur est désactivé
        ct.ligne(x1, y1, x2, y2); // Ligne gauche
        ct.ligne(x2, y2, x3, y3); // Ligne vers le bas droit
        ct.ligne(x3, y3, x1, y1); // Ligne retour à la tête de la flèche
    }
    

    // Méthode pour vérifier si une chaîne est un entier
    public static boolean estEntier(String action) 
    {
        try
        {
            Integer.parseInt(action);
            return true;
        } 
        catch (NumberFormatException e) 
        {
            return false;
        }
    }
    
    // Méthode pour gérer l'orientation
    public static char Orientation(String action, char orientation) 
    {
        if (action.equals("D")) // Rotation à droite
        {
            if (orientation == 'N') orientation = 'E'; // Nord -> Est
            else if (orientation == 'E') orientation = 'S'; // Est -> Sud
            else if (orientation == 'S') orientation = 'O'; // Sud -> Ouest
            else if (orientation == 'O') orientation = 'N'; // Ouest -> Nord
        }
        else // Rotation à gauche
        {
            if (orientation == 'N') orientation = 'O'; // Nord -> Ouest
            else if (orientation == 'O') orientation = 'S'; // Ouest -> Sud
            else if (orientation == 'S') orientation = 'E'; // Sud -> Est
            else if (orientation == 'E') orientation = 'N'; // Est -> Nord
        }
        return orientation;
    }
}
