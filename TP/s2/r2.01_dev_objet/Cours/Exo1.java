public class Exo1
{
	public static void main(String[] args)
	{
		System.out.println("Exercice 1.2");
		/*--------------------- */
		/*      Partie donnee     */
		/*--------------------- */
		char[] tabCara;

		/*--------------------- */
		/*      Partie main     */
		/*--------------------- */
		 tabCara = new char[3];

		for(int cpt = 0; cpt < tabCara.length ; cpt++)
		{
			tabCara[cpt] = (char) ('C' - cpt);
		}

		System.out.println("+--------------------+");
		System.out.println("+----Partie Pile-----+");
		System.out.println("+--------------------+");

		Exo1.affichage(tabCara);
		Exo1.enleverPile(tabCara);
		System.out.println();
		Exo1.affichage(tabCara);

		System.out.println();

		System.out.println("+--------------------+");
		System.out.println("+----Partie File-----+");
		System.out.println("+--------------------+");

		Exo1.affichage(tabCara);
		Exo1.enleverFile(tabCara);
		System.out.println();
		Exo1.affichage(tabCara);


	}

	public static void affichage(char[] tabCara)
	{
		for(int cpt = 0; cpt < tabCara.length; cpt++)
		{
			System.out.println(tabCara[cpt]);
		}
	}

	public static void enleverFile(char[] tabCara)
	{
		for(int cpt = 0; cpt < tabCara.length ; cpt++)
		{
			if(cpt == tabCara.length - 1)
			{
				tabCara[cpt] = ' ';
			}
		}
	}

	public static void enleverPile(char[] tabCara)
	{
		for(int cpt = 0; cpt < tabCara.length ; cpt++)
		{
			if(cpt == 0)
			{
				tabCara[cpt] = ' ';
			}
		}
	}


}