/** Projet 2 Exercice 2
 *  GenererTab
 *  @author Equipe 18
 *  @version 17/11/2023
 */
public class TriSelection
{
	// Fonction pour effectuer le tri par sélection
	public static void triSelection(int[] tab) 
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
			// Échange des éléments
			temp = tab[indiceMin];
			tab[indiceMin] = tab[cpt1];
			tab[cpt1] = temp;
		}
	}
	// Fonction pour trouver l'indiceMin et l'indiceMax
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
		for (int cpt1 = 1; cpt1 < tab.length; cpt1++) 
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
}