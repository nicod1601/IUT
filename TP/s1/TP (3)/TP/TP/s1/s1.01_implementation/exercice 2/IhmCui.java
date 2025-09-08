import iut.algo.Clavier;

public class IhmCui {
    private Controleur ctrl;

    public IhmCui(Controleur ctrl) 
	{
        this.ctrl = ctrl;
    }

    public void afficherGrille() 
	{
        int nbLignes = this.ctrl.getNbLignes();
        int nbColonnes = this.ctrl.getNbColonnes();

        /*-----------------------------*/
	    /* Affichage de la grille      */
	    /*-----------------------------*/
        System.out.println("Nombre de lignes : " + nbLignes);
        System.out.println("Nombre de colonnes : " + nbColonnes);
        System.out.println();  // Espace entre les lignes

        for (int lig = 0; lig < nbLignes; lig++) 
		{
            for (int col = 0; col < nbColonnes; col++) 
			{
                char contenuCase = this.ctrl.getCase(lig, col);
                System.out.print(contenuCase + " ");
            }
            System.out.println(); 
        }
    }

    /*----------------------------------------------------------------------------*/
	/* lit un carchtere dans la console qui correspondra a la direction du robot  */
	/*----------------------------------------------------------------------------*/
    public char saisirDirection() 
	{
        System.out.print("Entrez une direction (N, O, S, E) : ");
        char dir = Clavier.lire_char();

        if (dir == 'N' || dir == 'S' || dir == 'E' || dir == 'O') 
		{
            return dir;
        }

        System.out.println("Direction invalide ! Veuillez entrer N, S, E ou O.");
        return saisirDirection();  
    }
}
