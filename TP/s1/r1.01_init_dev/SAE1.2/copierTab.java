public class copierTab 
{
	public static int[] copierTableau(int[] tab) 
	{
		int[] copie = new int[tab.length];
		for (int cpt = 0; cpt < tab.length; cpt++)
		{
			copie[cpt] = tab[cpt];
		}
		return copie;
	}
}
