import iut.algo.*;

public class RobotTracerGUIV2
{
    public static void main(String[] args)
    {
        String action;
        ControleGraphique ct;
        
        char orientation;
        int avance;
        int cordX, cordY;
        int ancCordX, ancCordY;

        ct = new ControleGraphique();
        ct.setTaille(600, 500);
        ct.prendreStylo(Couleur.VERT);
        
        cordX = cordY = 100;
        orientation = 'N';

        System.out.print("action : ");
        action = Clavier.lireString();

        ct.setTypeAction('F');

        while (!action.equals("FIN")) 
        {
            ancCordX = cordX;
            ancCordY = cordY;

            if (estEntier(action)) 
            { 
                avance = Integer.parseInt(action);       
                
                switch (orientation)
                {
                    case 'N':
                        cordY -= avance; 
                        break;
                    case 'S':
                        cordY += avance;
                        break;
                    case 'O':
                        cordX -= avance;
                        break;
                    case 'E':
                        cordX += avance;
                        break;
                }

                ct.setTypeAction('F');
                ct.prendreStylo(Couleur.VIOLET);
                ct.ligne(ancCordX, ancCordY, cordX, cordY);
            } 
            else 
            {
                orientation = Orientation(action, orientation);
            }
            
            ct.prendreStylo(Couleur.VERT);
            ct.setTypeAction('M');
            ct.effacer('M');

            ct.cercle(cordX, cordY, 10);
            dessinerV(ct, cordX, cordY, orientation);

            System.out.println("[" + orientation + "    " + String.format("%3d", cordX) + ":" + String.format("%3d", cordY) + "]");

            ct.majDessin(); 

            System.out.print("action : ");
            action = Clavier.lireString();
        }
        ct.quitter();
    }
    
    public static boolean estEntier(String action) 
    {
        try {
            Integer.parseInt(action);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static char Orientation(String action, char orientation)
    {
        switch (action)
        {
            case "D":
                switch (orientation)
                {
                    case 'N': orientation = 'E'; break; 
                    case 'E': orientation = 'S'; break; 
                    case 'S': orientation = 'O'; break; 
                    case 'O': orientation = 'N'; break; 
                }
                break;
            case "G":
                switch (orientation)
                {
                    case 'N': orientation = 'O'; break; 
                    case 'O': orientation = 'S'; break; 
                    case 'S': orientation = 'E'; break; 
                    case 'E': orientation = 'N'; break; 
                }
                break;
        }
        return orientation; 
    }

    public static void dessinerV(ControleGraphique ct, int x, int y, char orientation)
    {
        // Variables
        int longueur = 19; // Longueur de la flèche
        int largeur = 6;  // Largeur de la base de la flèche
        int xTip = x, yTip = y; // Position de la pointe de la flèche

        // Choix de la couleur pour la flèche
        ct.prendreStylo(Couleur.VERT); 

        // Détermination des coordonnées de la flèche selon l'orientation
        switch (orientation)
        {
            case 'N': // Flèche pointant vers le nord
                yTip -= 10; // Positionner la pointe au-dessus du centre
                ct.ligne(xTip, yTip, x - largeur, yTip + longueur); // Ligne gauche
                ct.ligne(xTip, yTip, x + largeur, yTip + longueur); // Ligne droite
                break;

            case 'S': // Flèche pointant vers le sud
                yTip += 10; // Positionner la pointe en dessous du centre
                ct.ligne(xTip, yTip, x - largeur, yTip - longueur); // Ligne gauche
                ct.ligne(xTip, yTip, x + largeur, yTip - longueur); // Ligne droite
                break;

            case 'O': // Flèche pointant vers l'ouest
                xTip -= 10; // Positionner la pointe à gauche du centre
                ct.ligne(xTip, yTip, xTip + longueur, y - largeur); // Ligne haute
                ct.ligne(xTip, yTip, xTip + longueur, y + largeur); // Ligne basse
                break;

            case 'E': // Flèche pointant vers l'est
                xTip += 10; // Positionner la pointe à droite du centre
                ct.ligne(xTip, yTip, xTip - longueur, y - largeur); // Ligne haute
                ct.ligne(xTip, yTip, xTip - longueur, y + largeur); // Ligne basse
                break;
        }
    }

}