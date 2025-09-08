import java.util.Scanner;
import java.io.InputStream;

import iut.algo.Decomposeur;

public class Dedale
{

		/*	Propriétés	*/
		
	private Piece[][] tabPiece;
	private Piece pieceHeros;
	private char orienH;
	private int cptDeplacement = 0;


		// Initialisation du dédale

	public Dedale()
	{
		this.tabPiece =  this.initPiece();


		// Placement du personnage a l'endroit du cercle de depart
		for( int cptLig= 0 ; cptLig < tabPiece.length ; cptLig++)
		{
			for( int cptCol= 0 ; cptCol < tabPiece[cptLig].length ; cptCol++)
			{
				if ( this.tabPiece[cptLig][cptCol] != null && this.tabPiece[cptLig][cptCol].getDepart() )
				{
					this.pieceHeros = this.tabPiece[cptLig][cptCol];

				}
			}

		}
		
		this.orienH = 's';
	}


		/* Accesseurs */
		
	public int getNbLigne() { return this.tabPiece.length; }

	public int getNbColonne() { return this.tabPiece[0].length; }

	public Piece getPiece(int lig, int col) { return this.tabPiece[lig][col]; }

	public char getOrientation() { return this.orienH; }

	public int getDeplacement() { return this.cptDeplacement; }
	
	public Piece getPieceHeros() { return this.pieceHeros; }
	
		// Méthode qui renvoie la pièce adjointe de la pièce aux coordonnées et dans la direction passées en paramètre

	private Piece getPieceAdj(int lig, int col, char dir)
	{

		switch (dir)
		{

			case 'N' ->
			{
				if (lig == 0) {return null;} // Vérifie qu'on est dans le bord superieur
				return this.tabPiece[lig - 1][col];
			}

			case 'O' ->
			{
				if (col == 0) {return null;} // Verifie qu'on est dans le bord gauche
				return this.tabPiece[lig][col - 1];
			}

			case 'S' ->
			{
				if (lig == this.tabPiece.length - 1) {return null;} // Verifie qu'on est dans le bord inférieur
				return this.tabPiece[lig + 1][col];
			}

			case 'E' ->
			{
				if (col == this.tabPiece.length - 1) {return null;} // Verifie qu'on est dans le bord droit
				return this.tabPiece[lig][col + 1];
			}

		}

		return null;

	}

	
	// Méthode qui teste si le tableau est valide
	public boolean estValide()
	{

		// Double boucle qui parcourt toutes les cases une par une 
		for(int i = 0; i < this.tabPiece.length; i++)
		{
			for(int j = 0; j < this.tabPiece[0].length; j++)
			{
				
				// Vérification des cas d'erreurs 
				if (i != 0)
				{
					if (this.tabPiece[i][j].getOuverture('N') != this.tabPiece[i-1][j].getOuverture('S'))
					{
						return false;
					}
				}

				if (j != this.tabPiece[0].length - 1)
				{
					if (this.tabPiece[i][j].getOuverture('E') != this.tabPiece[i][j+1].getOuverture('O'))
					{
						return false;
					}
				}

				if (i != this.tabPiece.length - 1)
				{
					if (this.tabPiece[i][j].getOuverture('S') != this.tabPiece[i+1][j].getOuverture('N'))
					{
						return false;
					}
				}
					
				if (j != 0)
				{
					if (this.tabPiece[i][j].getOuverture('O') != this.tabPiece[i][j-1].getOuverture('E'))
					{
						return false;
					}
				}
			}

		}

		return true;
	}


	// Méthode qui renvoie s si le héros est sur la pièce entrée en paramètre 
	public char getSymboleHeros ( int lig, int col )
	{
		if ( this.tabPiece[lig][col] == this.pieceHeros )
		{
			return 's';
		}

		return ' ';
	}

		// Méthode qui initialise le dédale

	private Piece[][] initPiece()
	{
		Piece[][] tabInitPiece;
		String[]  ficherNiveau;
		

		tabInitPiece = new Piece[5][5];

		// Récuperation du contenu du ficher niveau en une liste
		ficherNiveau = lireFichier("Niveaux/niveau_01.data").split("\t");

		// Parcour du tableau est la chaine contenant les valeurs des cases du niveau est sui instancie les piéces au bonne endroit 
		for( int cptLig= 0 ; cptLig < tabInitPiece.length ; cptLig++)
		{
			for( int cptCol= 0 ; cptCol < tabInitPiece[cptLig].length ; cptCol++)
			{
				// Ce qui ma permit de touvais la bonne formule pour les valuer des piéces 
				//System.out.println("Indice : " + cptCol + " Valeur : " + ficherNiveau[cptCol + (cptLig*5)]);

				tabInitPiece[cptLig][cptCol] = new Piece(Integer.parseInt(ficherNiveau[cptCol+ (cptLig * 5 )]));
				
				if ( tabInitPiece[cptLig][cptCol].getNbNegatif())
				{
					tabInitPiece[cptLig][cptCol] = null;
				}
			}

		}

		return tabInitPiece;

	}

	private String lireFichier(String nomFichier)
	{
		String sRet ,ligne ; 
		sRet = ""  ;
		Decomposeur dc ;

		try
		{
			InputStream ips = this.getClass().getResourceAsStream(nomFichier);
			Scanner scanner =new Scanner(ips, "UTF-8");
			String niveau = scanner.nextLine();
			while (scanner.hasNextLine())
			{
				sRet = sRet + scanner.nextLine() + "\t";
			}
			scanner.close();
		}
		catch (Exception e)
		{
			System.err.println("Erreur de lecture du fichier " + nomFichier + " : " + e.getMessage());
			e.printStackTrace();
		}

		return sRet;
	}
	

		// Méthode qui renvoie la direction opposée de la direction passée en paramètre

	public char getOppose(char dir)
	{
		switch(dir)
		{
			case 'N':
				return 'S';
			case 'S': 
				return 'N';
			case 'E': 
				return 'O';
			case 'O': 
				return 'E';
			default : 
				return ' ';
 		}
		
	}

	// Méthode qui gère les mouvements du héros en fonction des entrées
	
	public void deplacer ( char dir )
	{
		Position positionHeros;

		positionHeros = this.rechercherPosition( this.pieceHeros );


		// Vérifie si le héros ne se dirige pas dans un mur et autorise le mouvement sinon

		if (this.tabPiece[positionHeros.getLig()][positionHeros.getCol()].getOuverture(dir) != false &&
		    this.getPieceAdj(positionHeros.getLig() , positionHeros.getCol() , dir)         != null  && 
			this.getPieceAdj(positionHeros.getLig() , positionHeros.getCol() , dir).getOuverture(this.getOppose(dir))  != false)
		{
			
			// Si le personnage est dans déjà dans la bonne direction , il se déplace sinon l'image change pour le faire tourner 
			switch (dir)
			{
				case 'S' ->
					{
						if (this.orienH == 's' )
						{
							positionHeros.setLig(positionHeros.getLig() + 1);
							this.cptDeplacement += 1;
							System.out.println(this.cptDeplacement);
						}
						else
						{
							this.orienH = 's';
						}
					}

				case 'N' ->
					{
						if (this.orienH == 'n')
						{
							positionHeros.setLig(positionHeros.getLig() - 1);
							this.cptDeplacement += 1;
							System.out.println(this.cptDeplacement);
						}
						else
						{
							this.orienH = 'n';
						}
					}

				case 'O' ->
					{
						if (this.orienH == 'o')
						{
							positionHeros.setCol(positionHeros.getCol() - 1);
							this.cptDeplacement += 1;
							System.out.println(this.cptDeplacement);
						}
						else
						{
							this.orienH = 'o';
						}
					}
					
				case 'E' ->
					{
						if (this.orienH == 'e')
						{
							positionHeros.setCol(positionHeros.getCol() + 1);
							this.cptDeplacement += 1;
							System.out.println(this.cptDeplacement);
						}
						else
						{
							this.orienH = 'e';
						}
					}
				
			}
		}

		// Deplacement du heros
		this.pieceHeros = this.getPiece(positionHeros.getLig() , positionHeros.getCol());
	
	}


		// Méthode qui permute les pièces avec la lave

	public void deplacerPiece(int ligne1, int colonne1, int ligne2, int colonne2)
	{
		Piece pieceTemp;

		if (this.tabPiece[ligne1][colonne1]                   != null &&
		    this.tabPiece[ligne2][colonne2]                   == null &&
		    this.tabPiece[ligne1][colonne1].getValOuverture() != 0    &&
		    this.tabPiece[ligne1][colonne1].getValOuverture() < 16    &&
		    this.tabPiece[ligne1][colonne1] != this.pieceHeros        &&
		    this.tabPiece[ligne2][colonne2] != this.pieceHeros           )
			
		{
			if (ligne1 == ligne2)
			{
				if (colonne2 - colonne1 == -1 || colonne2-colonne1 == 1)
				{
					pieceTemp = this.tabPiece[ligne1][colonne1];
					this.tabPiece[ligne1][colonne1] = this.tabPiece [ligne2][colonne2];
					this.tabPiece[ligne2][colonne2] = pieceTemp;
					this.cptDeplacement += 1;
					System.out.println(this.cptDeplacement);
				}
			}
			else 
			{
				if (colonne1 == colonne2)
				{
					if (ligne2 - ligne1 == -1 || ligne2-ligne1 == 1)
					{
						pieceTemp = this.tabPiece[ligne1][colonne1];
						this.tabPiece[ligne1][colonne1] = this.tabPiece [ligne2][colonne2];
						this.tabPiece[ligne2][colonne2] = pieceTemp;
						this.cptDeplacement += 1;
						System.out.println(this.cptDeplacement);
					}
				}
			}
			
		}
	}


	// Méthode qui retourne l'objet Position de la position de la Pièce entrée en paramètre
	private Position rechercherPosition ( Piece p )
	{
		Position positionPiece;

		positionPiece = new Position( 0,0 );



		for ( int lig = 0 ; lig < this.getNbLigne(); lig++ )
		{
			for ( int col = 0; col < this.getNbColonne(); col ++ )
			{
				if ( this.tabPiece[lig][col] == p )
				{
					positionPiece.setLig( lig );
					positionPiece.setCol( col );
				}
			}
		}

		return positionPiece;
	}
}