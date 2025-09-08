import iut.algo.Clavier;


/**
 * @author : Delpech Nicolas
 * @version : 1.0
 * @date : 30/11/2021
 * 
 * RobotTracer
 */
public class Exo1
{
    public static void main(String[] args) 
    {
        /*------------*/
        /* Donnees    */
        /*------------*/
        
        //constante 
        final int POINT_CHAMPS    = 2;
        final int POINT_COLLINES  = 3;
        
        // variables
		int nbChamps  ;
		int nbCollines;
		
		int pv;
		int bonusChamps;
		int bonusCollines;
		int total;
        /*--------------*/
        /* Instruction  */
        /*--------------*/
        bonusChamps = bonusCollines = 0;
        
        System.out.print("nb de Champs   : ");
        nbChamps = Clavier.lire_int();
        
        System.out.print("nb de Collines : ");
        nbCollines = Clavier.lire_int();
        
         while(nbChamps + nbCollines > 10)
        {
        	System.out.println();
        	 
        	System.out.print("nb de Champs   : ");
        	nbChamps = Clavier.lire_int();
        
        	System.out.print("nb de Collines : ");
        	nbCollines = Clavier.lire_int();
        }
        
        
        pv = nbChamps * POINT_CHAMPS + nbCollines * POINT_COLLINES;
        
        
        // bonus et malus pour nbChamps
        if(nbChamps <= 3 )
        {
        	bonusChamps = -3;
        }
        if(nbChamps >= 4 && nbChamps <= 6)
        {
        	bonusChamps = 1;
        }
        if(nbChamps >= 7 && nbChamps <= 9)
        {
        	bonusChamps = 2;
        }
        if(nbChamps == 10)
        {
        	bonusChamps = 3;
        }
        
        // bonus et malus pour nbCollines
        if(nbCollines <= 3 )
        {
        	bonusCollines = -3;
        }
        if(nbCollines >= 4 && nbCollines <= 7)
        {
        	bonusCollines = 1;
        }
        if(nbChamps >= 8 && nbChamps <= 10)
        {
        	bonusCollines = 2;
        }
        
        total = pv + bonusChamps + bonusCollines;
        
        System.out.println();
        System.out.println("PV             : " + pv           );
        System.out.println("Bonus Champs   : " + bonusChamps  );
        System.out.println("Bonus Collines : " + bonusCollines);
        System.out.println("                 --- ");
        System.out.println("Total          : " + total);
        
    }

}

