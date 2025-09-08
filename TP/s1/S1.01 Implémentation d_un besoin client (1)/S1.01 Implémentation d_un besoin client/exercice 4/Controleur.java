import ihmgui.FrameGrille;

import java.io.FileInputStream;
import java.util.Scanner;

import ihmgui.Controle;
import iut.algo.Clavier;

public class Controleur extends Controle
{
	private Labyrinthe  metier;
	private FrameGrille frame;


	public Controleur()
	{
		this.metier = new Labyrinthe();

		this.frame  = new FrameGrille(this);
		this.frame.setSize(this.metier.getNbLignes()*100, this.metier.getNbColonnes()*50);
		this.frame.setVisible(true);

		this.setFondGrille();

		while ( ! this.estSortie() )
		{
			this.jouer("");
		}

		this.frame.fermer();

    }


	public int     getNbLignes   ()                  { return this.metier.getNbLignes  ();         }
	public int     getNbColonnes ()                  { return this.metier.getNbColonnes();         }
	public char    getCase       (int lig, int col ) { return this.metier.getCase      (lig, col); }
	public boolean estSortie     ()                  { return this.metier.estSortie    ();         }

	public String  setFondGrille() { return "./images/fond.png";  }
  	public int     setNbLigne   () { return this.getNbLignes  (); }
	public int     setNbColonne () { return this.getNbColonnes(); }
	public int     setLargeurImg() { return 30;                   }

	public String setImage(int lig, int col, int couche)
	{

		String rep    = "./images/";
		String sImage = null;
		char symbole;
		symbole = this.metier.getCase(lig, col);

		if ( couche == 0)
		{
			if ( symbole == ' ' ) sImage = rep + "haie_vide.gif";
			if ( symbole == 'O' ) sImage = rep + "boule_verte.gif" ;
			if ( symbole == '@' ) sImage = rep + "sortie.gif";
			
		}

		if(couche == 1)
		{
			if ( symbole == '=' ) sImage = rep + suiteMure(lig,col);
			
			
		}
		this.setLargeurImg();
		return sImage;
	}

	public void jouer (String touche)
	{
		if ( touche.equals ( "FL-H" ) ) this.metier.deplacer( 'N', true );
		if ( touche.equals ( "FL-G" ) ) this.metier.deplacer( 'O', true );
		if ( touche.equals ( "FL-B" ) ) this.metier.deplacer( 'S', true );
		if ( touche.equals ( "FL-D" ) ) this.metier.deplacer( 'E', true );

		this.frame.majIHM();
	}

	public String suiteMure(int lig, int col) {
		String rep = "./images/";
	
		// Vérification des voisins autour de la case
		boolean murHaut   = lig > 0                    && this.metier.getCase(lig - 1, col) == '=';
		boolean murBas    = lig < this.getNbLignes()-1 && this.metier.getCase(lig + 1, col) == '=';
		boolean murGauche = col > 0                    && this.metier.getCase(lig, col - 1) == '=';
		boolean murDroite = col < this.getNbColonnes()-1 && this.metier.getCase(lig, col + 1) == '=';
	
		// Association des cas spécifiques
		if (murHaut && murBas && murGauche && murDroite) return rep + "haie_nose.gif"; // Croisement
		if (murHaut && murBas)                          return rep + "haie_ns.gif";   // Mur vertical
		if (murGauche && murDroite)                     return rep + "haie_oe.gif";   // Mur horizontal
		if (murHaut && murDroite)                       return rep + "haie_ne.gif";   // Coin haut droit
		if (murHaut && murGauche)                       return rep + "haie_no.gif";   // Coin haut gauche
		if (murBas && murDroite)                        return rep + "haie_se.gif";   // Coin bas droit
		if (murBas && murGauche)                        return rep + "haie_os.gif";   // Coin bas gauche
		if (murHaut)                                    return rep + "haie_s.gif";    // Bout de mur bas
		if (murBas)                                     return rep + "haie_n.gif";    // Bout de mur haut
		if (murGauche)                                  return rep + "haie_o.gif";    // Bout de mur droit
		if (murDroite)                                  return rep + "haie_e.gif";    // Bout de mur gauche
	
		return rep + "haie.gif"; // Mur isolé par défaut
	}
	
	

	public static void main(String[] a)
	{
		new Controleur();
	}

	/*
	n'a plus d'utilité visblement ?????
	public void majIHM()
	{
		char cara;
		for (int cptLig = 0; cptLig < this.getNbLignes(); cptLig++)
		{
			for (int cptCol = 0; cptCol < this.getNbColonnes(); cptCol++)
			{
				cara = this.getCase(cptLig, cptCol);
				this.setImage(cptLig, cptCol, 0);
			}
		}
	}
	 */
}
