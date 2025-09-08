import iut.algo.Clavier;
import java.awt.Point;


/**
 * @author : Delpech Nicolas, Harris Audric
 * @version : 1.0
 * @date : 07/11/2024
 * 
 * Taquin
 */
 
public class Taquin
{
    public static void main(String[] args) 
    {
        /*--------------*/
        /*   Donnees    */
        /*--------------*/
        //constante
        //final int TAILLE = 4;
        
        //variables
        int taille          ;
        char[][] tab        ;
        char[][] tabMelange ;
        int ligVide, colVide;
        int cptToure        ;
        
        char dir    ;
        int nbAction;
        Point vide  ;
        boolean fin ;
        
        /*--------------*/
        /* Instruction  */
        /*--------------*/
        System.out.print("Taper une taille : ");
        taille = Clavier.lire_int();
        while (taille > 6 || taille < 1)
        {
        	System.out.print("Taper une taille : ");
        	taille = Clavier.lire_int();
        }

        System.out.println();
        
        tab        = new char[taille][taille];
        tabMelange = new char[taille][taille];
        ligVide    = colVide = taille - 1    ;
        
        vide = new Point(ligVide, colVide);
        
        tab = Taquin.InitTaquin(tab, ligVide, colVide);
        
        tabMelange = Taquin.InitTaquin(tabMelange, ligVide, colVide);
        Taquin.melanger(tabMelange);
        fin = Taquin.fin(tabMelange,tab);
        
        cptToure =0;
        
        Taquin.affichage(tabMelange, cptToure);
        System.out.println(Taquin.affichage(tabMelange, cptToure));
        
        while(fin != true)
        {
         	System.out.print("dir : ");
         	dir = Clavier.lire_char();
         	
         	if (dir == 'N' || dir == 'S' || dir == 'O' || dir == 'E' )cptToure++;
         	
         	Taquin.deplacer(tabMelange, dir, vide);
			System.out.println(Taquin.affichage(tabMelange, cptToure));
			
			fin = Taquin.fin(tabMelange,tab);
        }
        
        System.out.println("Tu as GAGNE ?!! + 1000 d'aura");
        
     }
     
     public static char[][] InitTaquin(char[][] tab, int ligVide, int colVide)
     {
     	/*--~---------*/
     	/* Variable   */
     	/*------------*/
     	char lettre;
     	
     	/*--------------*/
        /* Instruction  */
        /*--------------*/
        
        lettre = 'A';
     	
     	for(int cptLig=0; cptLig < tab.length; cptLig++)
        {
        	for(int cptCol=0; cptCol < tab[cptLig].length; cptCol++)
        	{
        		tab[cptLig][cptCol] = lettre;
        		lettre++;
        	}
        }
        tab[ligVide][colVide] = ' ';
        
        return tab;
     }
     public static boolean deplacer(char[][] tab, char dir, Point vide)
     {
     	/*---------------*/
     	/*   Variable    */
     	/*---------------*/
     	int x, y;
     	
     	/*--------------*/
        /* Instruction  */
        /*--------------*/
     	x = (int) vide.getX();
     	y = (int) vide.getY();
     	
     	
     	if(
     	   	y == 0                  && dir == 'N' ||
     	   	y == tab[y].length - 1  && dir == 'S' ||
     	   	x == 0                  && dir == 'O' ||
     	   	x == tab.length - 1     && dir == 'E' 
     	  )
     	  {
     	  	return false;
     	  } 
     	  
     	  switch(dir)
     	  {
     	  	case 'N' -> 
     	  		{
     	  			tab[y][x]   = tab[y-1][x];
     	  			tab[y-1][x] = ' ';
     	  			vide.setLocation(x, y-1);
     	  		}
     	  	case 'S' -> 
     	  		{
     	  			tab[y][x]   = tab[y+1][x];
     	  			tab[y+1][x] = ' ';
     	  			vide.setLocation(x, y+1);
     	  		}
     	  	case 'O' ->
     	  		{
     	  			tab[y][x]   = tab[y][x-1];
     	  			tab[y][x-1] = ' ';
     	  			vide.setLocation(x-1, y);
     	  		}
     	  	case 'E' ->
     	  		{
     	  			tab[y][x]   = tab[y][x+1];
     	  			tab[y][x+1] = ' ';
     	  			vide.setLocation(x+1, y);
     	  		}
     	  	case '~' ->
     	  		{
     	  			System.out.println("Le tilda c'est le $Home .");
     	  		}
     	  }
     	  return true;
     }
     
     public static char[][] melanger(char tab[][])
     {
     	/*--------------*/
     	/*  Variable    */
     	/*--------------*/
     	int cpt;
     	int tmpLig, tmpCol;
     	char tmp;
     	
     	/*-----------------*/
     	/*  Instruction    */
     	/*-----------------*/
     	
     	cpt = 0;
     	while(cpt < 1000)
     	{
     		for(int cptLig = 0; cptLig < tab.length; cptLig++)
     		{
     			for(int cptCol = 0; cptCol < tab[cptLig].length; cptCol++)
     			{
     				int numHasard ;
     				
     				numHasard = (int)(Math.random() * (tab.length -1) * (tab[cptLig].length-1));
     				tmpLig = numHasard % tab.length;
     				tmpCol = (int) tab[cptLig].length -1 - tmpLig;
     				if (tab[cptLig][cptCol] != ' ')
     				{
		 				tmp = tab[cptLig][cptCol];
		                tab[cptLig][cptCol] = tab[tmpLig][tmpCol];
		                tab[tmpLig][tmpCol] = tmp;
		 			}
     			}
     		}
     		cpt++;
     	}
     	return tab;
     	
     }
     
     public static String affichage(char[][] tab, int nbToures)
     {
     	String srt;
     	/*------------------*/
     	/*   Instruction    */
     	/*------------------*/
     	
     	srt = "";
     	
     	srt +="+"+"---+".repeat(tab[0].length) + "\n";
        for(int cptLig=0; cptLig < tab.length; cptLig++)
        {
        	srt +="|";
        	for(int cptCol=0; cptCol < tab[cptLig].length; cptCol++)
        	{
        		srt += " " + tab[cptLig][cptCol] + " |";
        	}
        	srt += "\n";
        	srt += "+"+"---+".repeat(tab[0].length) + "\n";
        }
        if(nbToures == 1 || nbToures == 0)
        {
        	srt += "Nombre de tour : " + nbToures;
        }
        else
        {
        	srt += "Nombre de tours : " + nbToures;
        }
        
        System.out.println();
        
        return srt;
     }
     
     
	// Vérification si les deux tableaux sont identiques
	public static boolean fin(char[][] tabMelanger, char[][] tabOrig)
	{
    	for (int cpt1 = 0; cpt1 < tabMelanger.length; cpt1++)
    	{
        	for (int cpt2 = 0; cpt2 < tabMelanger[0].length; cpt2++)
        	{
            	if (tabMelanger[cpt1][cpt2] != tabOrig[cpt1][cpt2])
            	{
                	return false;
            	}
            }
        }
    	return true;
    }
   

}

