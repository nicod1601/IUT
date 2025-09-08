public class Trioutile
{
	public class TriUtil 
	{
		// Génération du Tableau
		private static int[] GenererTableau(int nbCases, int valMin, int valMax)
		{
			/*                                         */
			/*                Donnee                   */
			/*                                         */
				int[] tab;
			/*                                         */
			/*              Instruction                */
			/*                                         */
			tab = new int [nbCases];
			for(int cpt = 0; cpt < tab.length; cpt++)
			{
				tab[cpt] = (int) (Math.random()*(valMax + valMin));
			}
			return tab;
		}
		// Fonction du CopieTableau
		private static int[] copierTableau(int[] tab) 
		{
			int[] copie = new int[tab.length];
			for (int cpt = 0; cpt < tab.length; cpt++)
			{
				copie[cpt] = tab[cpt];
			}
			return copie;
		}
		// Faire le tri Sélection
		private static void triSelection(int[] tab) 
		{
			/*                                         */
			/*                Donnee                   */
			/*                                         */
				int indiceMin;
				int temp;
			/*                                         */
			/*              Instruction                */
			/*                                         */
			int taille = tab.length;
			for (int cpt1 = 0; cpt1 < taille - 1; cpt1++) 
			{
				indiceMin = cpt1;
				for (int cpt2 = cpt1 + 1; cpt2 < taille; cpt2++) 
				{
					if (tab[cpt2] < tab[indiceMin]) 
					{
						indiceMin = cpt2;
					}
				}
				temp = tab[indiceMin];
				tab[indiceMin] = tab[cpt1];
				tab[cpt1] = temp;
			}
			System.out.println("triSelection");
			for (int cpt = 0; cpt < tab.length; cpt++)
			{
				System.out.print(tab[cpt] + "|");
			}
			System.out.println();
		}
	
		// Tri par insertion
		public static void triInsertion(int[] tab) 
		{
			/*                                         */
			/*                Donnee                   */
			/*                                         */
				int taille;
				int temp;
				int cpt2;
			/*                                         */
			/*              Instruction                */
			/*                                         */
			taille = tab.length;
			for (int cpt1 = 1; cpt1 < taille ; cpt1++) 
			{
				temp = tab[cpt1];
				cpt2 = cpt1 - 1;
	
				while (cpt2 >= 0 && tab[cpt2] > temp) 
				{
					tab[cpt2 + 1] = tab[cpt2];
					cpt2 = cpt2 - 1;
				}
				tab[cpt2 + 1] = temp;
			}
			System.out.println("triInsertion");
			for (int cpt = 0; cpt < tab.length; cpt++)
			{
				System.out.print(tab[cpt] + "|");
			}
			System.out.println();
		}
		// Trouver l'indice du maximum et du minimum dans un tableau
		public static void indicesMinMax(int[] tab) 
		{
			/*                                         */
			/*                Donnee                   */
			/*                                         */
				int indiceMax;
				int indiceMin;
			/*                                         */
			/*              Instruction                */
			/*                                         */
	
			indiceMax = 0;
			indiceMin = 0;
			for (int cpt1 = 1; cpt1 < tab.length ; cpt1++) 
			{
				if (tab[cpt1] > tab[indiceMax]) 
				{
					indiceMax = cpt1;
				} 
				else if (tab[cpt1] < tab[indiceMin]) 
				{
					indiceMin = cpt1;
				}
			}
			System.out.println("Indice du maximum : " + indiceMax);
			System.out.println("Indice du minimum : " + indiceMin);
		}
		// Fonction pour permuter le tri
		static void permuter(int[] tab, int ind1, int ind2) 
		{
			int temp = tab[ind1];
			tab[ind1] = tab[ind2];
			tab[ind2] = temp;
		}
		public static String toString(int[] tab )
		{
			/*                                         */
			/*                Donnee                   */
			/*                                         */
				String sep;
			/*                                         */
			/*              Instruction                */
			/*                                         */

			sep = "+--------+--------+--------+--------+ . . . . +--------+--------+--------+--------+\n";

			// Affichage des 4 premières valeurs du tableau
			sep += "|";
			for (int cpt1 = 0; cpt1 < 4; cpt1++) {
				sep += String.format(" %-6d |", tab[cpt1]);
			}
			sep += ". . . . |";
			for (int cpt1 = tab.length - 4; cpt1 < tab.length; cpt1++) {
				sep += String.format(" %-6d |", tab[cpt1]);
			}
			sep += "\n";
	
			// Ligne séparatrice horizontale après l'affichage des valeurs
			sep += "+--------+--------+--------+--------+ . . . . +--------+--------+--------+--------+\n";
	
			// Affichage des indices du tableau
			sep += "|";
			for (int cpt2 = 0; cpt2 < tab.length; cpt2++) {
				sep += String.format("%-5d |", cpt2);
			}
			sep += "\n";
	
			return sep;
		}
		public static void main(String[] arg)
		{
			/*                                         */
			/*                Donnee                   */
			/*                                         */
			int valeurMax;
			int valeurMin;
			int nbCases;
			int[] tab;
			int[] tab1;
			/*                                         */
			/*              Instruction                */
			/*                                         */
			nbCases = 50;
			valeurMax =1000;
			valeurMin = 1;

			tab = TriUtil.GenererTableau(nbCases, valeurMax, valeurMin);
			System.out.println("Tableau Original");
			System.out.print(tab);
			tab1 = TriUtil.copierTableau(tab);
			TriUtil.triSelection(tab1);
			TriUtil.toString(tab1);
			System.out.println("Tableau Selection");
			System.out.print(tab1);

		}
	}
}




















