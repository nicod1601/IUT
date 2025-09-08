import ihmgui.FrameGrille;
import ihmgui.Controle;
import javax.swing.JFrame;
import java.lang.String ;

public class Controleur extends Controle
{
	
		/*	Propriétés	*/

	private Dedale metier;
	private FrameGrille frame;


		// Initialisation du controleur

	public Controleur()
	{
		this.metier = new Dedale();
		this.frame  = new FrameGrille(this);

		frame.setSize    (200 * metier.getNbColonne(), 120 * metier.getNbLigne());
		frame.setLocation(10, 10);
		frame.setTitle   ("Dédale");


		//frame.add(buttonNiveauSuivant  );


		frame.setVisible (true);

	}

	public String setBouton(int numBtn)
	{
		String lib;

		switch ( numBtn )
		{
			case 0 : lib = "Boutton niveau précedant ";
				break;
			case 1 : lib = "Boutton niveau suivantes ";
				break;
			
			default: lib = null;
		}

		return lib;
	}

	public void bouton(int numbtn)
	{
		Piece pieceHero;
		
		if (numbtn == 0)
		{
			pieceHero = metier.getPieceHeros() ;
			
			if ( pieceHero.getArrivee()  )
			{
				System.out.println("Arrivéée");
			}
		}

	}

	public String setLabel (int numLbl)
	{
		String lib;

		switch ( numLbl )
		{
			case 0: lib = "Deplacement :";
				break;

			default: lib = null;
		}
		
		return lib;
	}

	public String setTextLabel (int numLbl)
	{
		return metier.getDeplacement() + "";
	}
	
	public int setNbLigne()
	{
		return this.metier.getNbLigne();
	}

	public int setNbColonne()
	{
		return this.metier.getNbColonne();
	}

	public int setLargeurImg()
	{
		return 100;
	}

	public String setFondGrille()
	{
		return "images/fond.png";
	}



	public String setImage(int ligne, int colonne, int couche)
	{
		String rep    = "images/";
		String sImage = "";
		
		Piece symbole;
		
		int valeurPiece;
		

			// Placement de l'image lave

		if (metier.getPiece(ligne, colonne) == null )
		{
			sImage = rep + "lave.png" ;
			return sImage;
		}
		
		symbole = metier.getPiece(ligne, colonne);
		
		valeurPiece = symbole.getValOuverture();
		

			// Permet d'avoir la bonne case pour le depart et l'arrivée

		if ( metier.getPiece(ligne , colonne).getDepart())
		{
			valeurPiece = valeurPiece - 16 ;
		}
		if ( metier.getPiece(ligne , colonne).getArrivee())
		{
			valeurPiece = valeurPiece - 32 ;
		}

			
			// Attribution des cases à leur endroit

		if (couche == 0)
		{
			switch (valeurPiece)
			{

				case  0 -> sImage = rep + "P00.png" ;
				case  1 -> sImage = rep + "P01.png" ;
				case  2 -> sImage = rep + "P02.png" ;
				case  3 -> sImage = rep + "P03.png" ;
				case  4 -> sImage = rep + "P04.png" ;
				case  5 -> sImage = rep + "P05.png" ;
				case  6 -> sImage = rep + "P06.png" ;
				case  7 -> sImage = rep + "P07.png" ;
				case  8 -> sImage = rep + "P08.png" ;
				case  9 -> sImage = rep + "P09.png" ;
				case 10 -> sImage = rep + "P10.png" ;
				case 11 -> sImage = rep + "P11.png" ;
				case 12 -> sImage = rep + "P12.png" ;
				case 13 -> sImage = rep + "P13.png" ;
				case 14 -> sImage = rep + "P14.png" ;
				case 15 -> sImage = rep + "P15.png" ;
			}
	
		}
		
			// Bloc qui permet de passer les cercles

		if (couche == 1)
		{
			if (metier.getPiece(ligne , colonne).getDepart())
			{
				sImage = rep + "depart.png";
				
			}
			if (metier.getPiece(ligne , colonne).getArrivee())
			{
				sImage = rep + "arrivee.png";
			}
		}
		
		
			// Placement du personnage

		if (couche == 2 && metier.getSymboleHeros(ligne, colonne) == 's')
		{
			sImage = rep + "dw_" + metier.getOrientation() + ".png";
			
		}


		return sImage;
	}



		// Méthode jouer qui s'active lors du pressage de touches

	public void jouer(String touche)
	{
		switch (touche)
		{
			case "FL-H" -> metier.deplacer('N',true);
			case "FL-B" -> metier.deplacer('S',true);
			case "FL-G" -> metier.deplacer('O',true);
			case "FL-D" -> metier.deplacer('E',true);
		}

		frame.majIHM();
		// Méthode glisser qui est déclenchée lors de la permutation d'une pièce avec la lave
	}


	public void glisser(int ligne1, int colonne1, int ligne2, int colonne2)
	{
		metier.deplacerPiece( ligne1, colonne1, ligne2, colonne2);

		frame.majIHM();
	}


	// Déclaration du controleur
	public static void main(String[] a)
	{
		new Controleur();
		
	}

}
