import iut.algo.Clavier;

public class Snake {
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
			int[] newCoords = deplacement(grille, direction, ligS, colS, ligP, colP);
			ligS = newCoords[0];
			colS = newCoords[1];

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

	public static int[] deplacement(char[][] grille, char direction, int ligS, int colS, int ligP, int colP)
	{
		// Efface la position actuelle du serpent
		grille[ligS][colS] = ' ';

		// Mise à jour des coordonnées selon la direction
		switch (direction) {
			case 'z': // Haut
				if (ligS > 0) {
					ligS--; // Déplace vers le haut si pas sur le bord
				}
				break;
			case 'q': // Gauche
				if (colS > 0) {
					colS--; // Déplace vers la gauche si pas sur le bord
				}
				break;
			case 's': // Bas
				if (ligS < grille.length - 1) {
					ligS++; // Déplace vers le bas si pas sur le bord
				}
				break;
			case 'd': // Droite
				if (colS < grille[0].length - 1) {
					colS++; // Déplace vers la droite si pas sur le bord
				}
				break;
		}
		
		

		// Met à jour la nouvelle position du serpent
		grille[ligS][colS] = 'S';

		// Retourne les nouvelles coordonnées
		return new int[]{ligS, colS};
	}
} 
