import iut.algo.Clavier;

public class Test
{
	public static void main(String[] args) 
	{
		/*-----------------*/
		/*    Constante    */
		/*-----------------*/
		final int TAILLE = 5;
		
		/*-----------------*/
		/*    Variables    */
		/*-----------------*/
		char[][] grille;
		
		/*-----------------*/
		/*   Instructions  */
		/*-----------------*/
		grille = new char[TAILLE][TAILLE];
		
		Test.initGrille(grille);
		System.out.println(Test.affichage(grille));
		
		
		
	}
	public static char[][] initGrille(char[][] tab)
	{	
		for(int lig=0; lig < tab.length; lig++)
		{
			for(int col=0; col < tab[0].length; col++)
			{
				tab[lig][col] = ' ';
			}
		}
		
		return tab;	
	}
	public static String affichage(char[][] tab)
	{
		/*-----------------*/
		/*    Variables    */
		/*-----------------*/
		String str;
		
		/*-----------------*/
		/*   Instructions  */
		/*-----------------*/
		str = "";
		
		str += "+"+"---+".repeat(tab[0].length) + "\n";
		
		for(int lig=0; lig < tab.length; lig++)
		{
			str += "|";
			for(int col=0; col < tab[0].length; col++)
			{
				str += " " + tab[lig][col] + " |";
			}
			str += "\n";
			str += "+"+"---+".repeat(tab[0].length) + "\n";
		}
		return str;
		
		
	}
}
