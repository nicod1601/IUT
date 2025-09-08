import java.io.FileInputStream;
import java.util.Scanner;

public class Test
{
	public static void main(String[] args) 
	{
		/*------------------*/
		/*       Donnee     */
		/*------------------*/
		int[] tabEntier;



		/*------------------*/
		/*     Instruction  */
		/*------------------*/

		tabEntier = new int[5];

		for(int cpt = 0; cpt < 6; cpt++)
		{
			tabEntier[cpt] = cpt;
		}

		for(int cpt = 0; cpt < tabEntier.length; cpt++)
		{
			System.out.println(tabEntier[cpt]);
		}


	}

}