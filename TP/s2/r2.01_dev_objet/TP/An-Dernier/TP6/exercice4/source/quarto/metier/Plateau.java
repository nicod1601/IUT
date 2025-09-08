package quarto.metier;

import java.util.ArrayList;
import java.util.Collections;

/** Classe Metier Principale du Projet.
  * Cette Classe gère l'ensemble des objets du projet :<br />
  * - la pioche de Pièces, le plateau, le respect des règles.
  * @author Philippe Le Pivert.
  */
public class Plateau
{
	/** Ensemble des Pièces que l'on peut jouer */
	private ArrayList<Piece>  pioche;

	/** Plateau de Jeu */
	private Piece[][]         tabPiece;

	/** Piece piochée par un joueur pour que l'autre joueur la place. */
	private Piece             pieceAJouer;

	/** Nom des joueurs */
	private String[]          tabJoueur;

	/** Indice du Joueur Courant */
	private int               indJoueurCourant;

	/** Est-ce que la fin de Partie est atteinte ?
	  * affectée à vrai dès qu'un joueur décide de déclarer "Quatro".
	  * ainsi on arrête la possibilité de continuer la partie.
	  */
	private boolean           bFinPartie;

	/** Zone qui sert à stocker l'information sur le déroulement de la partie qui sera
	  * donnée aux joueurs.
	  */
	private String            message;



	// ---------------
	// Le constructeur
	// ---------------

	/** Initialisation de l'ensemble des Objets du Plateau.
	  * Pioche, Plateau, Joueur.
	  * @param nomJoueur, noms des joueurs participant à la partie.
	  */
	public Plateau (String[] nomJoueur)
	{
		this.pioche           = new ArrayList<Piece>();
		this.tabPiece         = new Piece[4][4];
		this.pieceAJouer      = null;
		this.tabJoueur        = nomJoueur;
		this.indJoueurCourant = 0;
		this.bFinPartie       = false;

		this.message          = Message.tabMessage[0];

		this.initPioche();
	}

	// -------------------------
	// Les différents accesseurs
	// -------------------------
	/** Retourne une pièce du plateau.
	  * @param lig, ligne de la case.
	  * @param col, colonne de la case.
	  * @return code des caractéristiques d'une pièce, null si pas de pièce.
	  */
	public String getPiecePlateau ( int lig, int col )
	{
		if ( tabPiece[lig][col] == null ) return null;
		else return tabPiece[lig][col].toString();
	}

	/** Retourne une pièce de la pioche.
	  * @param indice, numéro de la pièce de la pioche.
	  * @return code des caractéristiques d'une pièce, null si pas de pièce.
	  */
	public String getPioche ( int indice )
	{
		if   (indice >= this.pioche.size() ) return null;
		else return pioche.get(indice).toString();
	}

	/** Retourne la pièce à jouer.
	  * @return code des caractéristiques d'une pièce, null si pas de pièce.
	  */
	public String getPieceAJouer  ()
	{
		if ( this.pieceAJouer == null ) return null;
		return this.pieceAJouer.toString();
	}

	/** Retourne le nom du joueur courant.
	  * @return nom du Joueur
	  */
	public String getNomJoueurEnCours () { return this.tabJoueur[this.indJoueurCourant]; }

	/** Retourne des informations sur le déroulement de la partie.
	  * @return message
	  */
	public String getMessage     () { return this.message;            }

	/** Retourne le nombre de lignes du plateau.
	  * nombre de lignes
	  */
	public int    getNbLigne     () { return this.tabPiece.length;    }

	/** Retourne le nombre de colonnes du plateau.
	  * @return nombre de colonnes
	  */
	public int    getNbColonne   () { return this.tabPiece[0].length; }

	/** Retourne le nombre de pièces présents dans la pioche.
	  * @return nombre de Pièce dans la pioche
	  */
	public int    getTaillePioche() { return this.pioche.size();      }



	// --------------------
	// Les Méthodes de Jeux
	// --------------------

	/** Prise d'une pièce de la pioche.
	  * Cette méthodeprend une pièce de la pioche et la place comme Pièce à joueur
	  * par l'adversaire.
	  * L'action ne peut se faire que s'il ne reste pas de pièce à jouer et
	  * que l'indice ind est un indice valide dans la pioche.
	  * @param ind indice de la pièce que l'on veut prendre dans la pioche
	  */
	public void piocher(int ind)
	{
		if (this.bFinPartie ) return;

		if ( this.pieceAJouer != null || ind >= pioche.size() )
		{
			this.message = Message.tabMessage[3];
		}
		else
		{
			this.pieceAJouer = this.pioche.get(ind);
			this.pioche.remove(ind);
			this.changerJoueur();
			this.message = Message.tabMessage[1];
		}
	}


	/** Changement de Joueur. Cette méthode change le joueur en cours.
	  * Elle est déclenchée une fois qu'un joueur à pioche une pièce
	  * pour que son adversaire la joue.
	  */
	private void changerJoueur()
	{
		this.indJoueurCourant = ( this.indJoueurCourant==0 ? 1 : 0 );
	}


	/** Placement de la Pièce à jouer.
	  * Cette méthode place sur le plateau la pièce à jouer.
	  * Le placement est possible si :<br />
	  * - il y a une pièce à jouer,<br />
	  * - les coordonnées choisies font parties du plateau,<br />
	  * - la case choisie est vide.
	  * @param lig ligne de la case choisie
	  * @param col colonne de la case choisie
	  */
	public void placer ( int lig, int col)
	{
		if (this.bFinPartie ) return;

		if ( this.pieceAJouer == null             ||
		     lig < 0 || lig >= this.getNbLigne()  ||
		     col < 0 || lig >= this.getNbLigne()  ||
		     this.tabPiece[lig][col] != null          )
	     {
			 this.message = Message.tabMessage[4];
		 }
		 else
		 {
			 this.tabPiece[lig][col] = this.pieceAJouer;
			 this.pieceAJouer        = null;
			 this.message            = Message.tabMessage[2];
		 }
	}


	/** Méthode déclenchant la fin de la partie.
	  * Cette méthode vérifie également si le joueur à déclenché la fin de la partie à
	  * bon escient.
	  */
	public void quarto()
	{
		if (this.bFinPartie ) return;

		// Vérification que la partie est bien finie
		if ( this.aGagne() )
			this.message  = Message.tabMessage[5];
		else
			this.message  = Message.tabMessage[6];

		this.bFinPartie = true;
	}


	/** Détermine s'il y a une ligne avec une caractéristique commune.
	  * @return vrai si fin de fin de Partie
	  */
	private boolean aGagne()
	{
		String sValEtat, sTypEtat;
		int    nbCarac;

		for ( int etat=0;etat<8;etat++)
		{
			sValEtat =this.getValEtat(etat);
			sTypEtat =this.getTypEtat(etat);

			// verif lignes
			for ( int lig=0; lig<this.getNbLigne(); lig++ )
			{
				nbCarac=0;
				for ( int col=0;col<this.getNbColonne(); col++ )
					if ( this.tabPiece[lig][col] != null                     &&
					     this.tabPiece[lig][col].getCarac(sTypEtat).equals(sValEtat) )
					     nbCarac++;

				if ( nbCarac==4 ) return true;
			}

			// verif colonnes
			for ( int col=0; col<this.getNbColonne(); col++ )
			{
				nbCarac=0;
				for ( int lig=0; lig<this.getNbLigne(); lig++ )
					if ( this.tabPiece[lig][col] != null                     &&
					     this.tabPiece[lig][col].getCarac(sTypEtat).equals(sValEtat) )
					     nbCarac++;

				if ( nbCarac==4 ) return true;
			}

			// verif diagonale 1
			nbCarac=0;
			for ( int lig=0; lig<this.getNbLigne(); lig++ )
				if ( this.tabPiece[lig][lig] != null                     &&
					 this.tabPiece[lig][lig].getCarac(sTypEtat).equals(sValEtat) )
					 nbCarac++;

			if ( nbCarac==4 ) return true;


			// verif diagonale 2
			nbCarac=0;
			for ( int lig=0; lig<this.getNbLigne(); lig++ )
				if ( this.tabPiece[lig][getNbColonne()-1-lig] != null                     &&
					 this.tabPiece[lig][getNbColonne()-1-lig].getCarac(sTypEtat).equals(sValEtat) )
					 nbCarac++;

			if ( nbCarac==4 ) return true;
		}

		return false;
	}


	/** Méthode utilisée pour rendre plus modulaire la méthode aGagne.
	  * Elle est utilisée en parallèle avec getTypeEtat
	  */
	private String getValEtat(int caract)
	{
			if ( caract == 0 ) return Piece.tabCouleur[0];
			if ( caract == 1 ) return Piece.tabCouleur[1];

			if ( caract == 2 ) return Piece.tabEtat   [0];
			if ( caract == 3 ) return Piece.tabEtat   [1];

			if ( caract == 4 ) return Piece.tabTaille [0];
			if ( caract == 5 ) return Piece.tabTaille [1];

			if ( caract == 6 ) return Piece.tabForme  [0];
			if ( caract == 7 ) return Piece.tabForme  [1];

			return null;
	}

	/** Méthode utilisée pour rendre plus modulaire la méthode aGagne.
	  * Elle est utilisée en parallèle avec getValEtat
	  */
	private String getTypEtat(int caract)
	{
			if ( caract == 0  ||  caract == 1 ) return "couleur";
			if ( caract == 2  ||  caract == 3 ) return "etat";
			if ( caract == 4  ||  caract == 5 ) return "taille";
			if ( caract == 6  ||  caract == 7 ) return "forme";

			return null;
	}


	// -----------------------------
	// Les Méthodes d'initialisation
	// -----------------------------
	/** Initialise la pioche avec les 16 pièces différentes.
	  * La pioche est mélangée
      */
	private void initPioche()
	{
		for (int coul=0; coul<2; coul++ )
			for (int etat=0; etat<2; etat++ )
				for (int taille=0; taille<2; taille++ )
					for (int forme=0; forme<2; forme++ )

						this.pioche.add ( new Piece ( Piece.tabCouleur[coul],
						                              Piece.tabEtat   [etat],
						                              Piece.tabTaille [taille],
						                              Piece.tabForme  [forme]   ) );
		Collections.shuffle ( this.pioche );
	}


}
