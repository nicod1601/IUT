import iut.algo.Clavier;

public class Snake3 {
	public static void main(String[] args) 
	{
		/*-----------------*/
		/*    Constante    */
		/*-----------------*/
		final int NB_CASE = 10;
		/*-----------------*/
		/*    Variables    */
		/*-----------------*/
		char[][] grille;
		int toure;
		char direction;

		int ligS, colS, ligP, colP;

		/*-----------------*/
		/*   Instructions  */
		/*-----------------*/
		grille = new char[NB_CASE][NB_CASE];

		// Position initiale du serpent
		ligS = grille.length / 2;
		colS = grille[0].length / 2;

		// Position initiale de la pomme
		ligP = (int) (Math.random() * NB_CASE);
		colP = (int) (Math.random() * NB_CASE);

		// Initialisation de la grille
		grille = initGrille(grille, ligS, colS, ligP, colP);

		// Affichage initial
		System.out.println(afficheGrille(grille));

		toure = 0;
		while (toure < 100) {
			System.out.println("Direction (z, q, s, d) :");
			direction = Clavier.lire_char();

			// Mise à jour de la grille et des coordonnées
			grille = deplacement(grille, direction, ligS, colS );

			// Vérifie si la pomme est mangée
			if (ligS == ligP && colS == colP) {
				System.out.println("Pomme mangée !");
				ligP = (int) (Math.random() * NB_CASE);
				colP = (int) (Math.random() * NB_CASE);
				grille[ligP][colP] = 'O';
			}

			// Affichage de la grille
			System.out.println(afficheGrille(grille));
			toure++;
		}
	}

	public static char[][] initGrille(char[][] grille, int ligS, int colS, int ligP, int colP)
	{
		for (int cpt = 0; cpt < grille.length; cpt++) {
			for (int cpt2 = 0; cpt2 < grille[0].length; cpt2++) {
				if (cpt == ligP && cpt2 == colP) {
					grille[cpt][cpt2] = 'O'; // Pomme
				} else if (cpt == ligS && cpt2 == colS) {
					grille[cpt][cpt2] = 'S'; // Serpent
				} else {
					grille[cpt][cpt2] = ' '; // Case vide
				}
			}
		}
		return grille;
	}

	public static String afficheGrille(char[][] grille) {
		StringBuilder affiche = new StringBuilder();
		affiche.append("  ".repeat(grille[0].length)).append("\n");
		for (int cpt = 0; cpt < grille.length; cpt++) {
			affiche.append(" |");
			for (int cpt2 = 0; cpt2 < grille[0].length; cpt2++) {
				affiche.append(grille[cpt][cpt2]).append("|");
			}
			affiche.append("\n");
		}
		return affiche.toString();
	}

	public static char[][] deplacement(char[][] grille, char direction, int ligS, int colS)
	{
		char tmp;

		switch (direction) 
		{
			case 'z': tmp = grille[ligS - 1][colS];
				grille[ligS - 1][colS] = grille[ligS][colS];
				grille[ligS][colS] = tmp;
				
				break;
			case 'q': tmp = grille[ligS][colS - 1];
				grille[ligS][colS - 1] = grille[ligS][colS];
				grille[ligS][colS] = tmp;
				
				break;
			case 's': tmp = grille[ligS + 1][colS];
				grille[ligS + 1][colS] = grille[ligS][colS];
				grille[ligS][colS] = tmp;
				
				break;
			case 'd': tmp = grille[ligS][colS + 1];
				grille[ligS][colS + 1] = grille[ligS][colS];
				grille[ligS][colS] = tmp;
				
				break;
		}
		return grille;
	}
} 
