/** Projet 2 Exercice 2
 *  GenererTab
 *  @author Equipe 18
 *  @version 17/11/2023
 */
public class EstTrier 
{
	public static boolean estTrier(int[] tab)
	{
		/*                                         */
		/*              Instruction                */
		/*                                         */
		for(int cpt = 0; cpt < tab.length - 1; cpt++)
		{
			if ( tab[cpt] > tab[cpt + 1])
			{
				return false;
			}
		}
		return true;
	}
}
