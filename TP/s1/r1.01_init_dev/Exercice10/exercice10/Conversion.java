public class Conversion
{
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------//


	// Retourne le nombre correspondant au tableau de boolean passer en paramétre
	public static int tab2Entier(boolean[] tab)
	{
		// Variables 
		int intRet ;

		// Instruction 
		
		// Initialisation
		intRet = 0 ;
		
		// Parcour du tableau en faisant la somme a retourner
		for (int cpt=0 ; cpt < tab.length; cpt ++ )
		{
			if( tab[cpt] == true )
			{
				intRet = intRet + (int)(Math.pow(2,cpt));
			}	
		}

		return intRet ;
		
	}



		
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------//

	// Iniformisation de print pour cette classe
	public static String enChaine(boolean[] tab)
	{
		/* Variables */
		String sRet;

		// Construction de la 1ière ligne
		sRet = "";

		for (int cpt = 0 ; cpt < tab.length ; cpt++)
		{
			sRet += "+-----";
		}
		sRet += "+\n";


		// Construction de la 2ième ligne
		for (int cpt = 0 ; cpt < tab.length ; cpt++)
		{
			sRet += "|" + String.format("%-5s",tab[cpt]);
		}
		sRet += "|\n";

		// Construction de la 3ième ligne
		sRet += "";

		for (int cpt = 0 ; cpt < tab.length ; cpt++)
		{
			sRet += "+-----";
		}
		sRet += "+\n";

		// Construction de la 4ième ligne
		sRet += "    ";
		
		for (int cpt = 0 ; cpt < tab.length ; cpt++)
		{
			sRet += cpt + "     ";
		}
		sRet += "  ";

		return sRet;
		
	}







//------------------------------------------------------------------------------------------------------------------------------------------------------------------//

	// Crée un tableu qui stock la valeur binaire de la valeur passer en parametre .
	// Le tableau a la taille donne en paramétre se qui veux dire que si la valeur binaire 
	// ne rentre pas dans la taille de tableau passe en parametre le tableu sera couper 
	public static boolean[] entier2Tab (int valeur, int  nbElt  )
	{

		/*   Données   */

		boolean[] tab;
		

		/* Instruction */

		tab = new boolean[nbElt];


		if( valeur == -1 )
		{
			tab[6] = true;
		} 

		
		// Placement des valeurs vrai ou fausse dans le tableau 
		for (int cpt = 0; cpt < nbElt-1; cpt ++)
		{
		
			tab[cpt] = (valeur % 2 == 1);
			valeur = valeur / 2;
		
		}

		return tab;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------//

	// Inifiormisation de l'affichge de tout les piéces comptenu dans le labirinte
	public static String detail(Dedale dedale)
	{
		String affichage;
		affichage  = "";

		for (int cptLigne = 0 ; cptLigne < dedale.getNbLigne() ; cptLigne++)
		{
			// Affichage du numero de la ligne
			affichage += "\n== Ligne " + cptLigne + " ";
			for (int i = 0 ; i < 90 ; i++)
			{
				affichage += "=";
			}
			
			// Affichage du detail de chaque piece de la ligne
			for (int cptColonne = 0 ; cptColonne < dedale.getNbColonne() ; cptColonne++)
			{
				affichage += "\n" + dedale.getPiece(cptLigne , cptColonne).toString();
			}
		}
		return affichage;
	}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	// Inifiormisation de l'affichge du labirainte
	public static String grille (Dedale dedale )
	{
		String sRet;
		sRet = "";

		for (int cptLig = 0; cptLig < dedale.getNbLigne() ; cptLig++)
		{

			// Construction de la 1er ligne
			for (int cptCol = 0; cptCol < dedale.getNbColonne() ; cptCol++)
			{
				sRet += "+----";
			}

			sRet += "+\n";

			// Construction de la 2ième lignes
			for (int cptCol = 0 ; cptCol < dedale.getNbLigne() ; cptCol++)
			{
				sRet += "|" + String.format("%3d",dedale.getPiece(cptLig, cptCol).getValOuverture()) + " ";
			}
			sRet += "|\n";

		}

		// Construction de la ligne de fin 
		for (int cptCol = 0 ; cptCol < dedale.getNbLigne() ; cptCol++)
		{
			sRet += "+----";
		}
		sRet += "+\n";

		return sRet;
	}
}