import iut.algo.Clavier;
/**
 * @author : Delpech Nicolas
 * @version : 1.0
 * @date : 30/11/2021
 * 
 * RobotTracer
 */
public class RobotTracer
{
    public static void main(String[] args) 
    {
        /*------------*/
        /* Variables  */
        /*------------*/
        char orientation;
        int avance      ;
        int cordX, cordY;
        String action   ;
       
        /*--------------*/
        /* Instruction  */
        /*--------------*/
        System.out.print("action :  ");
        action = Clavier.lireString();
		
        cordY = cordX = 100;
        orientation = 'N';
		
        while(!action.equals("FIN"))
        {
            if(estEntier(action))
            {
                avance = Integer.parseInt(action); // convertir la chaine en entier
                
                // Déplacement selon l'orientation
                if(orientation == 'N')
                {
                    cordY = cordY - avance;
                }
                else if(orientation == 'S')
                {
                    cordY = cordY + avance;
                }
                
                if(orientation == 'O')
                {
                    cordX = cordX - avance;
                }
                else if(orientation == 'E')
                {
                    cordX = cordX + avance;
                }
            }
            else
            {
            	orientation = Orientation(action, orientation);
            }
            
            System.out.println("[" + orientation + "    " + String.format( "%3d",cordX) + ":" + String.format( "%3d",cordY) + "]");
            	
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
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
     // Méthode pour vérifier l'orientation
    public static char Orientation(String action, char orientation) 
    {
		if(action.equals("D")) // Rotation à droite
        {
            if(orientation == 'N')
            {
                orientation = 'E'; // Nord -> Est
            }
            else if(orientation == 'E')
            {
                orientation = 'S'; // Est -> Sud
            }
            else if(orientation == 'S')
            {
                orientation = 'O'; // Sud -> Ouest
            }
            else if(orientation == 'O')
            {
                orientation = 'N'; // Ouest -> Nord
            }
        }
        else
        {
			if(orientation == 'N')
			{
				orientation = 'O'; // Nord -> Ouest
			}
			else if(orientation == 'O')
			{
				orientation = 'S'; // Ouest -> Sud
			}
			else if(orientation == 'S')
			{
				orientation = 'E'; // Sud -> Est
			}
			else if(orientation == 'E')
			{
				orientation = 'N'; // Est -> Nord
			}
       	}
            
            return orientation;
    }
}

