
import ihmgui.Controle;
import ihmgui.FrameGrille;

/**
 * Classe Labyrinthe
 *
 * Exercice 5
 *
 * groupe    : 2
 * auteurs   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
 *
 * créée le : 16/12/2024 21h29
 */

public class Controleur extends Controle
{
	private Platforme   metier;
	private FrameGrille frame;

	private String      theme;

	public Controleur()
	{
		this.metier = new Platforme();
		this.frame  = new FrameGrille(this);

		this.frame.setSize(this.metier.getNbLignes()*300, this.metier.getNbColonnes()*200);
		this.frame.setVisible(true);

		this.setFondGrille();
		this.setLargeurImg();
		this.theme = "lem";

		while ( this.metier.getNivActu() < 6)
		{
			while ( ! this.estSortie() )
			{
				this.jouer("");

				if ( this.estSortie() )
				{
					if(this.metier.getNivMax() == this.metier.getNivActu())
					{
						System.out.println(this.metier.getNivMax() + " " + this.metier.getNivActu() );
						this.metier.ajouterNivMax();
						System.out.println("ajout max");  //~~~~~~debug~~~~~~//
					}
				}
			}

			this.setLabel(0);
		}

		this.frame.fermer();

	}

	public int     setNbLigne       ()                  { return this.metier.getNbLignes  ();            }
	public int     setNbColonne     ()                  { return this.metier.getNbColonnes();            }
	public int     setLargeurImg    ()                  { return 52;                                     }
	public String  setFondGrille    ()                  { return "./images/" + this.theme + "/fond.png"; }

	public int     setLargeurLabel  ()	                { return 1000;                                   }
	public int     setMargeGauche   ()                  { return 0;                                      }

	public int     getNbLignes      ()                  { return this.metier.getNbLignes  ();            }
	public int     getNbColonnes    ()                  { return this.metier.getNbColonnes();            }
	public char    getCase          (int lig, int col ) { return this.metier.getCase      (lig, col);    }
	public boolean estSortie        ()                  { return this.metier.estSortie    ();            }

	public String changerTheme()
	{
		switch (this.theme)
		{
			case "lem"     -> this.theme = "link";
			case "link"    -> this.theme = "asterix";
			case "asterix" -> this.theme = "indiana";
			case "indiana" -> this.theme = "mario";
			case "mario"   -> this.theme = "lem";
		}
		System.out.println(this.theme);
		return this.theme;
	}


	public String setImage(int lig, int col, int couche)
	{

		String    rep = "./images/" + this.theme + "/";
		String sImage = null;

		char   symbole = this.metier.getCase(lig, col);


		if ( couche == 0 )
		{
			switch (symbole)
			{
				case '=' -> sImage = this.getTypeImage(lig, col);
				case '@' -> sImage = rep + "sortie.png";
				case '#' ->
				{
					int ligSupp;
					ligSupp = lig - 1;
					if ( ligSupp < 0                        ) { ligSupp = this.getNbLignes() - 1;  }
					if (  this.getCase(ligSupp, col) != '#' ) { sImage = rep + "echelle_haut.png"; }
					else { sImage = rep + "echelle.png"; }
				}

				case 'b' -> sImage = rep + "clebleue.png";
				case 'B' -> sImage = rep + "portebleue.png";

				case 'r' -> sImage = rep + "clerouge.png";
				case 'R' -> sImage = rep + "porterouge.png";

				case 'v' -> sImage = rep + "cleverte.png";
				case 'V' -> sImage = rep + "porteverte.png";

				case '+' -> sImage = rep + "";

				default -> sImage = rep + "vide52.png";
			}

			Caisse caisse = this.metier.getCaisse(lig, col);

			if (caisse != null)
			{
				int posCaisseLig = caisse.getCaisseLig();
				int posCaisseCol = caisse.getCaisseCol();

				if( posCaisseLig == lig && posCaisseCol == col)
				{
					sImage = rep + "caisse.png";
				}
			}
		}
		else
		if ( couche == 1 )
		{

			/*switch (this.metier.indiceVisible(lig, col))
			{
				case 1 -> sImage = rep + "";
				case 2 -> sImage = rep + "black_20_opacity.png";
				case 3 -> sImage = rep + "black_50_opacity.png";
				case 4 -> sImage = rep + "black_80_opacity.png";
				case 5 -> sImage = rep + "black_100_opacity.png";
			}
			 */

			int posLig = this.metier.getPosLig();
			int posCol = this.metier.getPosCol();

			if (lig == posLig && col == posCol)
			{
				if(this.metier.estDansLeVide(lig, col) && this.metier.getCaisse(lig+1, col) == null)
				{
					sImage = rep + "pers_tombe.png";
				}
				else
				{
					if(symbole == '#')
					{
						if(lig % 2 == 0)
							sImage = rep + "pers_monte1.png";
						else
							sImage = rep + "pers_monte2.png";

					}
					else
					{
						if(col % 2 == 0)
							sImage = rep + this.metier.orientPers() + ".png";
						else
							sImage = rep + this.metier.orientPers() + "_2.png";
					}

				}
			}
		}

		return sImage;
	}


	public String getTypeImage(int lig, int col)
	{
		String  sImage = "./images/" + this.theme + "/";
		boolean murGauche;
		boolean murDroite;

		murGauche = col > 0 && this.metier.getCase(lig, col - 1) != '=';
		murDroite = col + 1 <  this.getNbColonnes() && (this.metier.getCase(lig, col + 1) != '=');

		if (murGauche && murDroite) return sImage + "sol_gauche_droit.png";
		if (murGauche)              return sImage + "sol_gauche.png";
		if (murDroite)              return sImage + "sol_droit.png";

		return sImage + "sol.png";
	}

	public String setBouton(int numBtn)
	{
		String lib;

		lib = null;

		if (numBtn == 0) { return "Niveau précédent";}
		if (numBtn == 1) { return "Niveau suivant";  }
		if (numBtn == 2) { return "Recommencer";     }
		if (numBtn == 3) { return "Changer Theme";   }

		return lib;
	}

	public void bouton(int action)
	{
		if ( action == 0 ) { this.metier.definirNivActu(this.metier.getNivActu() - 1 );  }
		if ( action == 1 ) { this.metier.definirNivActu(this.metier.getNivActu() + 1 );  }
		if ( action == 2 ) { this.metier.chargerNiveau (this.metier.getNivActu()     );  }
		if ( action == 3 ) { this.changerTheme();                                        }

		this.frame.majIHM();



		System.out.println("niv actu : " + metier.getNivActu()); //~~~~~~~~debug
		System.out.println("niv Max  : " + metier.getNivMax() +"\n"); //~~~~~~~~debug
	}

	public String setLabel (int numLbl)
	{
		String lib;

		lib = null;

		if (numLbl == 0)
		{
			lib="";
		}

		return lib;
	}

	public String setTextLabel(int numLbl)
	{
		if (numLbl == 0)
		{
			if ( this.estSortie())
				return "Nouveau niveau disponible";
			else
				return "";
		}
		return "";
	}



	public void jouer (String touche)
	{

		if ( touche.equals ( "FL-H" ) ) this.metier.deplacer( 'N' );
		if ( touche.equals ( "FL-G" ) ) this.metier.deplacer( 'O' );
		if ( touche.equals ( "FL-B" ) ) this.metier.deplacer( 'S' );
		if ( touche.equals ( "FL-D" ) ) this.metier.deplacer( 'E' );

		if ( touche.equals ( "CR-FL-G" )) this.metier.sauter( 'O' );

		if ( touche.equals ( "CR-FL-D" )) this.metier.sauter( 'E' );
		
		if ( touche.equals ( "CR-FL-H"     )){this.metier.sauter( 'N' );}



		if ( touche != "")
			System.out.println(touche);


		if (this.metier.estDansLeVide(this.metier.getPosLig(), this.metier.getPosCol()))
		{
			this.metier.tomber();
		}

		this.frame.majIHM();
	}


	public static void main(String[] a)
	{
		new Controleur();
	}
}
