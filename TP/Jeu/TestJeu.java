import iut.algo.Clavier;

public class TestJeu 
{
	public static void main(String[] args) 
	{
		/*--------------------------*/
        /*      Donnee du jeu       */
        /*--------------------------*/

		Joueur joueur1;
		Joueur joueur2;
		Carte[] pioche;

		int choixCarte    ;
		int pvJoueur      ;
		int bouclierJoueur;
		int toure         ;

		/*--------------------------*/
        /*   Initialisation du jeu  */
        /*--------------------------*/

		/*choix des noms de joueurs */

		joueur1 = new Joueur("Joueur 1", 200);
		joueur2 = new Joueur("Joueur 2", 200);

		System.out.println("Saisir un nom pour le Joueur 1 :");
		joueur1.setNom(Clavier.lireString());

		System.out.println("Saisir un nom pour le Joueur 2 :");
		joueur2.setNom(Clavier.lireString());


		/* la pioche */

		pioche = Carte.creerPioche();

		pioche = Carte.melangerPioche(pioche);

		/*---------------------------*/
		/*       Début  du jeu       */
		/*---------------------------*/

		toure = 0;
		joueur1.setMainCartes(pioche);
        joueur2.setMainCartes(pioche);

		System.out.println("+-------------------------------------+"                  );
		System.out.println("+          Jeu de Cartes " + joueur1.getNom() + "         +");
		System.out.println("+-------------------------------------+"                  );

	

		while (joueur1.getPvJoueur() > 0 && joueur2.getPvJoueur() > 0) 
		{

			for(int cpt = 0; cpt < joueur1.getMainJoueur().length; cpt++)
			{
				System.out.println(joueur1.getMainJoueur()[cpt] + " ");
			}
	
	
			System.out.println("+-------------------------------------+"                  );
			System.out.println("+          Jeu de Cartes " + joueur2.getNom() + "         +");
			System.out.println("+-------------------------------------+"                  );
	
			for(int cpt = 0; cpt < joueur2.getMainJoueur().length; cpt++)
			{
				System.out.println(joueur2.getMainJoueur()[cpt] + " ");
			}


            // Tour du Joueur 1
            System.out.print("Joueur 1: Choisie une carte : ");
            choixCarte = Clavier.lire_int();
        
            Carte carteJouee = joueur1.choisirCarte(choixCarte);

            if (carteJouee.getType().equals("Rouge")) {

                pvJoueur = joueur2.getPvJoueur() - carteJouee.getAtt();
                joueur2.setPvJoueur(pvJoueur);

            } else if (carteJouee.getType().equals("Vert")) {

                pvJoueur = joueur1.getPvJoueur() + carteJouee.getHeal();
                joueur1.setPvJoueur(pvJoueur);

            } else {

                bouclierJoueur = joueur1.getBouclier() + carteJouee.getDef();
                joueur1.setBlouclier(bouclierJoueur);

            }

            joueur1.retirerCarte(choixCarte);
            joueur1.piocherNouvelleCarte(pioche);
        
            // Tour du Joueur 2
            System.out.print("Joueur 2: Choisie une carte : ");
            choixCarte = Clavier.lire_int();
        
            carteJouee = joueur2.choisirCarte(choixCarte);
            if (carteJouee.getType().equals("Rouge")) {
                pvJoueur = joueur1.getPvJoueur() - carteJouee.getAtt();
                joueur1.setPvJoueur(pvJoueur);
            } else if (carteJouee.getType().equals("Vert")) {
                pvJoueur = joueur2.getPvJoueur() + carteJouee.getHeal();
                joueur2.setPvJoueur(pvJoueur);
            } else {
                bouclierJoueur = joueur2.getBouclier() + carteJouee.getDef();
                joueur2.setBlouclier(bouclierJoueur);
            }
            joueur2.retirerCarte(choixCarte);
            joueur2.piocherNouvelleCarte(pioche);
        
            // Affichage de l'état des joueurs
            System.out.println("+-----------------+");
            System.out.println("     Tour " + toure);
            System.out.println("+-----------------+");
            System.out.println(joueur1);
            System.out.println(joueur2);
            System.out.println("+-----------------+");
            System.out.println("  Fin du tour " + toure);
            System.out.println("+-----------------+");
        
            toure++;
        }

		
	}
}
