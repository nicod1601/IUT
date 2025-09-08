/*----------------------------------------------*/
/*- Gere la l'interface graphique. Le mode débug*/
/*- Exercice 4                                  */
/*- Le groupe 1	                                */
/*- Lucas,Theo,Nichita ,Floriane,Audric         */ 
/*- 17/12/2024 13:00                            */
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
		
		frame.setSize     ( this.metier.getNbColonnes()*50,this.metier.getNbLignes()*50);
		frame.setLocation ( 250,  20            );
		frame.setTitle    ( "Jeu metier"   );
		frame.setVisible  ( true                 );
	}

	
	public int     setNbLigne        () { return metier.getNbLignes();   }
	public char    setNbColonne      () { return (char)('A' + metier.getNbColonnes()); }
	public boolean setNumLigneColonne() { return true;                   }
	public int     setLargeurImg     () { return 40;                     }
	public String  setFondGrille     () { return "./images/fond.png";    }


	/*--------------------------------------------------------*/
	/* Creer l'image approprié pour la ligne et colonne       */
	/*--------------------------------------------------------*/
	public String setImage ( int ligne, int colonne, int couche)
	{   
		char   symbole;
		String rep = "./images/";
		String sImage = "";

		String direction;

		if ( couche == 0)
		{
			symbole = metier.getCase(ligne,colonne);
			
			if      ( symbole == '=') sImage = rep + this.DeterminerDirection(ligne,colonne);
			else if ( symbole == 'O') sImage = rep +  "boule_verte.gif";
			else if ( symbole == '@') sImage = rep + "sortie.gif";
			else                      sImage = rep + "haie_vide.gif";
		}


		return sImage;
	} 

	/*--------------------------------------------------------*/
	/* Gere le déplacement du joueur tant qu'on ne sort pas.  */
	/*--------------------------------------------------------*/
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
	

	/*--------------------------------------------------------*/
	/* Determine la direction du haie                         */
	/*--------------------------------------------------------*/
	public String DeterminerDirection(int ligne,int colonne)
	{
		String direction;

		direction = "haie_";

		if (ligne != 0 && metier.getCase(ligne, colonne)==metier.getCase(ligne-1, colonne )) direction += "n";
		if (colonne !=0 &&metier.getCase(ligne, colonne)==metier.getCase(ligne, colonne-1 )) direction += "o";
		if (ligne != metier.getNbLignes()-1 && metier.getCase(ligne, colonne)==metier.getCase(ligne+1, colonne ) ) direction += "s";
		if (colonne != metier.getNbColonnes()-1 &&metier.getCase(ligne, colonne)==metier.getCase(ligne, colonne+1 )) direction += "e";
		if (direction == "haie_") direction = "haie";

		direction += ".gif";

		System.out.println(direction);
		return direction;
	}

	public static void main(String[] a)
	{
		Controleur ctrl = new Controleur();
	}
}
