public class Controleur
{
	private Labyrinthe metier;
	private IhmCui     ihm;


	public Controleur()
	{
		this.metier = new Labyrinthe();
		this.ihm    = new IhmCui (this);
		
		while ( ! this.metier.estSortie() )
		{
			this.ihm.afficherGrille();

			this.metier.deplacer( this.ihm.saisirDirection(), true );
		}

		this.ihm.afficherGrille();
		
	}


	public int     getNbLignes   ()                  { return this.metier.getNbLignes  ();         }
	public int     getNbColonnes ()                  { return this.metier.getNbColonnes();         }
	public char    getCase       (int lig, int col ) { return this.metier.getCase      (lig, col); }
	public boolean estSortie     ()                  { return this.metier.estSortie    ();         }


	public static void main(String[] a)
	{
		new Controleur();
	}
}
