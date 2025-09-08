/** Projet 2 Exercice 2
 *  TriUtil.java
 *  @author Equipe 18
 *  @version 06/12/2024
 */
public class TriUtil
{
	public static void main(String[] arg)
	{
		/*-----------------------------------------*/
		/*                Constante                */
		/*-----------------------------------------*/
			final int TAILLE_TAB = 100 ;
			final int VAL_MIN = 0, VAL_MAX = 2000 ;
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
			int [] tableau ;
			int [] tableauInverse;
			int [] tableau_copie ;
			int [] tableau_copie2 ;
			long debutTps, finTps ;
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
			tableau = TriUtil.genererTableau(TAILLE_TAB, VAL_MIN, VAL_MAX) ;
			tableauInverse = TriUtil.genererTableauInverse(TAILLE_TAB, VAL_MIN, VAL_MAX) ;
			tableau_copie = TriUtil.copierTableau(tableau) ;
			tableau_copie2 = TriUtil.copierTableau(tableauInverse) ;


			tableau = TriUtil.copierTableau(tableau_copie) ;
			System.out.println("+---------------------+");
			System.out.println("+    Tri Selection    +");
			System.out.println("+---------------------+");
			debutTps = System.nanoTime() ;
			triSelection(tableau);
			finTps = System.nanoTime() ;
			System.out.println(toString(tableau) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableau) + "\n\n");

			tableau = TriUtil.copierTableau(tableau_copie) ;
			System.out.println("+---------------------+");
			System.out.println("+      Tri Bulle      +");
			System.out.println("+---------------------+");
			debutTps = System.nanoTime() ;
			triBulle(tableau);
			finTps = System.nanoTime() ;
			System.out.println(toString(tableau) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableau) + "\n\n");


			tableau = TriUtil.copierTableau(tableau_copie) ;
			System.out.println("+---------------------+");
			System.out.println("+     Tri Insertion   +");
			System.out.println("+---------------------+");
			debutTps = System.nanoTime() ;
			triInsertion(tableau);
			finTps = System.nanoTime() ;
			System.out.println(toString(tableau) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableau) + "\n\n");


			System.out.println();
			System.out.println("+-------------------------------------+");
			System.out.println("+          Inverse Tableau            +");
			System.out.println("+-------------------------------------+");
			System.out.println();


			tableauInverse = TriUtil.copierTableau(tableau_copie2) ;
			System.out.println("+-------------------------------------+");
			System.out.println("+    Tri Selection Tableau Inversé    +");
			System.out.println("+-------------------------------------+");
			debutTps = System.nanoTime();
			triSelection(tableauInverse);
			finTps = System.nanoTime();
			System.out.println(toString(tableauInverse) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableauInverse) + "\n\n");

			tableauInverse = TriUtil.copierTableau(tableau_copie2);
			System.out.println("+-------------------------------------+");
			System.out.println("+      Tri Bulle Tableau Inversé      +");
			System.out.println("+-------------------------------------+");
			debutTps = System.nanoTime();
			triBulle(tableauInverse);
			finTps = System.nanoTime();
			System.out.println(toString(tableauInverse) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableauInverse) + "\n\n");

			tableauInverse = TriUtil.copierTableau(tableau_copie2);
			System.out.println("+-------------------------------------+");
			System.out.println("+    Tri Insertion Tableau Inversé    +");
			System.out.println("+-------------------------------------+");
			debutTps = System.nanoTime();
			triInsertion(tableauInverse);
			finTps = System.nanoTime();
			System.out.println(toString(tableauInverse) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableauInverse) + "\n\n");


			System.out.println();
			System.out.println("+----------------------------------------+");
			System.out.println("+          Tableau Déjà Trier            +");
			System.out.println("+----------------------------------------+");
			System.out.println();


			System.out.println("+----------------------------------------+");
			System.out.println("+        Tri Selection déjà trier        +");
			System.out.println("+----------------------------------------+");
			triSelection(tableau);
			debutTps = System.nanoTime();
			triSelection(tableau);
			finTps = System.nanoTime();
			System.out.println(toString(tableau) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableau) + "\n\n");

			System.out.println("+----------------------------------------+");
			System.out.println("+          Tri Bulle déjà trier          +");
			System.out.println("+----------------------------------------+");
			triBulle(tableau);
			debutTps = System.nanoTime();
			triBulle(tableau);
			finTps = System.nanoTime();
			System.out.println(toString(tableau) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableau) + "\n\n");

			System.out.println("+----------------------------------------+");
			System.out.println("+        Tri Insertion déjà trier        +");
			System.out.println("+----------------------------------------+");
			triInsertion(tableau);
			debutTps = System.nanoTime();
			triInsertion(tableau);
			finTps = System.nanoTime();
			System.out.println(toString(tableau) + "\nTemps de tri : " + (finTps - debutTps) + " nanosecondes" + "\nTableau trié : " + estTrie(tableau) + "\n\n");
	}
	public static void triSelection( int[] tab)
	{
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
			int cpt1, cpt2;
			int maxVal, indVal;
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
			cpt1 = 0;
			while (cpt1 < tab.length)
			{	
				maxVal = indVal = 0;
				cpt2 = 0;
				while (cpt2 < tab.length - cpt1)
				{
					if (maxVal < tab[cpt2])
					{
						maxVal = tab[cpt2];
						indVal = cpt2;
					}
					cpt2++;
				}
				TriUtil.permuter (tab, tab.length-1-cpt1, indVal) ;
				cpt1++;
			}
	}
	public static void triBulle(int[] tab)
	{
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
			for (int cpt1 = 0; cpt1 < tab.length - 1; cpt1++)
			{
				for (int cpt2 = 0; cpt2 < tab.length - 1 - cpt1; cpt2++)
				{
					if (tab[cpt2] > tab[cpt2 + 1])
					{
						TriUtil.permuter( tab, cpt2, (cpt2 + 1) );
					}
				}
			}
	}
	public static void triInsertion( int[] tab)
	{
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
			int cpt1, cpt2 ;
			int tmp ;
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
		cpt1 = 1 ;
		while (cpt1 < tab.length)
		{
			tmp = tab[cpt1];
			cpt2 = cpt1 - 1 ;
			while (cpt2 >= 0 && tab[cpt2] > tmp)
			{
				tab[cpt2 + 1] = tab[cpt2] ;
				cpt2-- ;
			}
			tab[cpt2 + 1] = tmp ;
			cpt1++ ;
		}
	}
	public static boolean estTrie ( int[] tab )
	{
		for (int cpt=0; cpt < tab.length - 1; cpt++)
		{
			if (tab[cpt] > tab[cpt+1])
			{
				return false;
			}
		}
		return true;
	}
	public static int[] genererTableau ( int nbCases, int valMin, int valMax )
	{
		int[] tab;
		tab = new int [nbCases];
		for (int cpt=0; cpt<tab.length; cpt++)
		{
			tab [cpt] = (int)(Math.random() * valMax) + valMin;
		}
		return tab;
	}
	public static int[] genererTableauInverse(int nbCases, int valMin, int valMax) 
	{
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
		int[] tab = new int[nbCases];
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
	
		for (int cpt = 0; cpt < tab.length; cpt++) {
			tab[cpt] = valMax - cpt;
		}
		return tab;
	}
	public static int[] copierTableau ( int[] tab )
	{
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
		int [] newTab;
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
		newTab = new int [tab.length] ;
	
		for (int cpt=0; cpt<tab.length;cpt++)
		{
			newTab[cpt] = tab[cpt] ;
		}
		return newTab ;
	}
	public static String toString ( int[] tab )
	{
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
			String res  ;
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
		if (tab.length > 8)
		{
			res = "+--------+--------+--------+--------+ . . . . . +--------+--------+--------+--------+\n";
			for (int cpt1 = 0; cpt1 < 4; cpt1++)
			{
				res = res + "|" + String.format( "%8s" , String.valueOf( tab[cpt1] ) );
			}
			res = res + "|           ";
			for (int cpt = 4; cpt > 0; cpt--)
			{
				res = res + "|" + String.format( "%8s" , String.valueOf( tab[tab.length - 1 - cpt] ) );
			}
			res = res + "|\n+--------+--------+--------+--------+ . . . . . +--------+--------+--------+--------+\n";
			for (int cpt = 0; cpt < 4; cpt++)
			{
				res = res + String.format( "%9s" , String.valueOf( cpt ) );
			}
			res = res + "            ";
			for (int cpt = 0; cpt < 4; cpt++)
			{
				res = res + String.format( "%9s" ,  String.valueOf( tab.length - 4 + cpt ) );
			}
			return res;
		}
		return "";
	}
	private static void permuter ( int[] tab, int ind1, int ind2 )
	{
		/*-----------------------------------------*/
		/*                Donnee                   */
		/*-----------------------------------------*/
			int temp ;
		/*-----------------------------------------*/
		/*              Instruction                */
		/*-----------------------------------------*/
		if ( tab[ind1] != tab[ind2] )
		{
			temp = tab[ind1]      ;
			tab[ind1] = tab[ind2] ;
			tab[ind2] = temp      ;
		}
	}
}





