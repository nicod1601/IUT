/** Projet 2 Exercice 2
 *  GenererTab
 *  @author Equipe 18
 *  @version 17/11/2023
 */
public class TriInsertion
{
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
}