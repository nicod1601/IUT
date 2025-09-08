/** Projet 2 Exercice 2
 *  GenererTab
 *  @author Equipe 18
 *  @version 17/11/2023
 */
public class GenererTab 
{
	public static int[] GenererTableau(	int nbCases, int valMin, int valMax)
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
			tab[cpt] = (int) (Math.random()*valMax) + valMin;
		}
		return tab;
	}
}
