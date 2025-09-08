import iut.algo.ControleGraphique;
import iut.algo.Couleur;

/**
 * @author Delpech Nicolas
 * TestCarte
 * @date 17/01/2025
 */
public class TestCarte
{
	public static void main(String[] a)
	{
		Carte c;
		int   taille = 10;

		// exercice 1
		// ----------


		c = new Carte ("carte1.data");

		System.out.println ( c );



		// exercice 2
		// ----------

		c.niveler();

		System.out.println ( c );



		// exercice 4
		// ----------

		/* Code à Compléter pour l'exercice 4 */


		// exercice 3
		// ----------

		TestCarte.affichageGraphique ( c, taille );

		// affichageGraphique prend en 1er paramètre  la carte à afficher
		//                          en 2ème paramètre la taille d'une case
		
		


	}
	
	
	public static void affichageGraphique(Carte c, int taille) {
		ControleGraphique ct = new ControleGraphique();

		// Taille de la fenêtre graphique ajustée
		int largeur = c.getNbColonne() * taille;
		int hauteur = c.getNbLigne() * taille;
		ct.setTaille(largeur, hauteur);

		// Remplir le fond de la fenêtre avec une couleur bleue
		ct.prendreStylo(Couleur.BLEU_CIEL);
		ct.rectangle(0, 0, largeur, hauteur);

		// Parcours de chaque case de la carte
		for (int lig = 0; lig < c.getNbLigne(); lig++) {
		    for (int col = 0; col < c.getNbColonne(); col++) {
		        int valeur = c.getVal(lig, col);

		        // Calcul des coordonnées de la case
		        int x = col * taille;
		        int y = lig * taille;

		        // Dessiner des rectangles concentriques pour représenter la valeur
		        for (int niveau = valeur; niveau >= 0; niveau--) {
		            int marge = (valeur - niveau) * (taille / (2 * valeur + 1)); // Ajuste la taille des marges
		            int rectSize = taille - 2 * marge;

		            ct.prendreStylo(getCouleurParNiveau(niveau));
		            ct.rectangle(x + marge, y + marge, rectSize, rectSize);
		        }
		    }
		}
	}

	// Méthode pour récupérer une couleur spécifique selon le niveau
	private static Couleur getCouleurParNiveau(int niveau) {
		switch (niveau) {
		    case 0: return Couleur.VERT_CLAIR;
		    case 1: return Couleur.VERT_FORET;
		    case 2: return Couleur.VERT_JAUNI;
		    case 3: return Couleur.JAUNE_DORE;
		    case 4: return Couleur.ORANGE;
		    case 5: return Couleur.ROUGE_BRIQUE;
		    default: return Couleur.MARRON;
		}
	}


}
