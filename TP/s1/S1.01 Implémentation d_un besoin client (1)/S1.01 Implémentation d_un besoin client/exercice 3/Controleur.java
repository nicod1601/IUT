import ihmgui.FrameGrille;
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
		this.frame.setSize(this.metier.getNbLignes()*35, this.metier.getNbColonnes()*35);
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

		if ( couche==0)
		{
			symbole = this.metier.getCase(lig, col);

			if      ( symbole == 'O' ) sImage = rep + "bille.png" ;
			else if ( symbole == '=' ) sImage = rep + "mur.png"   ;
			else if ( symbole == '@' ) sImage = rep + "sortie.png";
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
