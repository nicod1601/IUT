import iut.algo.*;

/**
 * @author Nicolas Delpech et Pierre Coignare
 * @version 1.0
 * @date 30/11/2021
 * 
 * RobotTracer Version Graphique V1.0
 */

public class RobotTracerGUI
{
    public static void main(String[] args) 
    {
        /*------------*/
        /* Variables  */
        /*------------*/
        String action;
        ControleGraphique ct;
        
        char orientation;
        int avance;
        int cordX, cordY;
        int ancCordX, ancCordY;

        /*--------------*/
        /* Instruction  */
        /*--------------*/
        ct = new ControleGraphique();
        ct.setTaille(600, 500);
        ct.prendreStylo(Couleur.NOIR);

        cordX = cordY = 100;

        System.out.print("action :  ");
        action = Clavier.lireString();
		
		// Initialisation
        cordY = cordX = 100;
        orientation = 'N';
		
		// Instruction
        while(!action.equals("FIN"))
        {
            // Sauvegarder les anciennes coordonnées avant le déplacement
            ancCordX = cordX;
            ancCordY = cordY;
            
            if(estEntier(action))
            { 
                avance = Integer.parseInt(action);
                
                // Déplacement selon l'orientation
                switch (orientation) 
                {
                    case 'N':
                        cordY = cordY - avance; // Nord
                        break;
                    case 'S':
                        cordY = cordY + avance; // Sud
                        break;
                    case 'O':
                        cordX = cordX - avance; // Ouest
                        break;
                    case 'E':
                        cordX = cordX + avance; // Est
                        break;
                }

                // Dessiner la ligne (entre ancienne et nouvelle position)
                ct.ligne(ancCordX, ancCordY, cordX, cordY);
            }
            else
            {
                orientation = Orientation(action, orientation);
            }
            
            System.out.println("[" + orientation + "    " + String.format( "%3d",cordX) + ":" + String.format( "%3d",cordY) + "]");

            // Mettre à jour le graphe
            ct.majDessin();
            	
            // Nouvelle action
            System.out.print("action :  ");
            action = Clavier.lireString();
        }
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
    
    // Méthode pour vérifier l'orientation
    public static char Orientation(String action, char orientation) 
    {
        switch (action) {
            case "D": // Rotation à droite
                switch (orientation) {
                    case 'N':
                        orientation = 'E'; // Nord -> Est
                        break;
                    case 'E':
                        orientation = 'S'; // Est -> Sud
                        break;
                    case 'S':
                        orientation = 'O'; // Sud -> Ouest
                        break;
                    case 'O':
                        orientation = 'N'; // Ouest -> Nord
                        break;
                }
                break;
            case "G": // Rotation à gauche
                switch (orientation) {
                    case 'N':
                        orientation = 'O'; // Nord -> Ouest
                        break;
                    case 'O':
                        orientation = 'S'; // Ouest -> Sud
                        break;
                    case 'S':
                        orientation = 'E'; // Sud -> Est
                        break;
                    case 'E':
                        orientation = 'N'; // Est -> Nord
                        break;
                }
                break;
        }
        
        return orientation;
    }
}
