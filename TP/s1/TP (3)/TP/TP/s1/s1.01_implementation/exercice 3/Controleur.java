/*----------------------------------------------*/
/*- Gere la l'interface graphique               */
/*- Exercice 3                                  */
/*- Le groupe 1	                                */
/*- Lucas,Theo,Nichita ,Floriane,Audric         */ 
/*- 17/12/2024 8:30                             */
/*----------------------------------------------*/

import ihmgui.Controle;
import ihmgui.FrameGrille;

public class Controleur extends Controle
{
    private Labyrinthe metier; // Modèle
    private FrameGrille frame;    // Vue

	/*-----------------------------*/
	/* Constructeur de Controleur  */
	/*-----------------------------*/
    public Controleur() 
    {
        metier = new Labyrinthe();
        frame  = new FrameGrille(this);
        
        frame.setSize     ( this.metier.getNbColonnes()*35,this.metier.getNbLignes()*35);
		frame.setLocation ( 200,  10            );
		frame.setTitle    ( "Jeu metier"        );
		frame.setVisible  ( true                );
    }

    /*------------------------------------------------------------------------------*/
	/* Méthode jouer qui enregistre les touche et donne la direction du déplacement */
	/*------------------------------------------------------------------------------*/
	public void jouer (String touche)
	{
		if ( touche.equals ( "CR-Z" ) ) System.out.println ( "Pourquoi voulez-vous annuler ? " );
		if ( touche.equals ( "FL-H" ) ) metier.deplacer ( 'N' );
		if ( touche.equals ( "FL-G" ) ) metier.deplacer ( 'O' );
		if ( touche.equals ( "FL-B" ) ) metier.deplacer ( 'S' );
		if ( touche.equals ( "FL-D" ) ) metier.deplacer ( 'E' );


        if(this.metier.estSortie())
        {
            System.out.print("Vous Avez Gagné ?!!!!");
            this.frame.fermer(); // Ferme l'application
        }

		frame.majIHM();

	}
    
    /*----------------------------------------------------------*/
	/* Méthode pour sélectionner la bonne image selon la couche */
	/*----------------------------------------------------------*/
    public String setImage ( int ligne, int colonne, int couche)
	{   
        char   symbole;
		String rep = "./images/";
		String sImage = "";

        if ( couche == 0)
        {
            symbole = metier.getCase(ligne,colonne);

            if      ( symbole == '=') sImage = rep +    "mur.png";
            else if ( symbole == 'O') sImage = rep +  "bille.png";
            else if ( symbole == '@') sImage = rep + "sortie.png";
            else                      sImage = rep + "vide30.png";
        }

		return sImage;
	} 

    public int     setNbLigne        () { return metier.getNbLignes();   }
	public int     setNbColonne      () { return metier.getNbColonnes(); }
	public boolean setNumLigneColonne() { return true;                   }
	public int     setLargeurImg     () { return 30;                     }
    public String  setFondGrille     () { return "./images/fond.png";    }

    /*---------------------------------------*/
	/* Méthode main, qui lance le controleur */
	/*---------------------------------------*/
    public static void main(String[] a)
	{
		Controleur ctrl = new Controleur();
	}
}