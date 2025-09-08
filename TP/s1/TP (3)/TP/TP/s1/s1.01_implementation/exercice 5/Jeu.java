/*--------------------------------------------------------------------*/
/*- Classe Jeu : Représente un Jeu avec un objet qui peut se déplacer.*/
/*- Exercice 5                                                        */
/*- Le groupe 1	                                                      */
/*- Lucas,Theo,Nichita ,Floriane,Audric                               */
/*- 18/12/2024 9:00                                                   */
/*--------------------------------------------------------------------*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Jeu
{

	/*-------------------------------------*/
	/* Position de l'objet dans la grille  */
	/*-------------------------------------*/
	private int posLig;
	private int posCol;
	private int posLigSortie;
	private int posColSortie;
	private int posLigBouton;
	private int posColBouton;
	private int nbNiveau = 11;
	private int niveau      ;
	
	private char dirPrec;
	
	private boolean  joueurSaute;
	private boolean  obscurite  ;
	private boolean  fly        ;
	private boolean  enVie      ;


	/*-----------------------------*/
	/* Grille représentant le Jeu  */
	/*-----------------------------*/
	private char  [][] grille    ;
	private char  []   inventaire;
	private Caisse[]   tabCaisse ;
	private Ennemi[]   tabEnnemis;

	private String[] listeSkin = {"Shrek/","lim/","asterix/","indiana/","link/"};

	

	/*-----------------------------------------------------------------*/
	/* Constructeur par défaut qui initialise le Jeu depuis un fichier */
	/*-----------------------------------------------------------------*/
	public Jeu(int niveau) 
	{
		final int NB_CLEF   = 10;
		final int NB_CAISSE = 10;
		final int NB_ENNEMI = 10;

		String                  sLigne;
		String           cheminFichier;
		int      nbLig ,         nbCol;
		int      cptLig,     cptCaisse;
		int                  cptEnnemi;
		
		nbLig = nbCol = 0;

		this.niveau     = niveau;
		this.inventaire = new char  [NB_CLEF]  ;
		this.tabCaisse  = new Caisse[NB_CAISSE];
		this.tabEnnemis = new Ennemi[NB_ENNEMI];

		cheminFichier  = "./data/grille_" + String.format("%02d",niveau) + ".data";
		this.obscurite = false;
		this.enVie     = true;

		try
		{
			Scanner sc = new Scanner ( new FileInputStream( cheminFichier ), "UTF8" );
			
			/*---------------------------------------------------*/
			/*          Lecture de la taille du tableau          */
			/*---------------------------------------------------*/
			sLigne = "";
			while ( sc.hasNextLine() )
			{
				sLigne = sc.nextLine();
				nbLig  ++             ;
			}
			sc.close();
			
			nbCol = sLigne.length();
		}
		
		catch(Exception e){ e.printStackTrace(); }
		
		this.grille = new char[nbLig +1][nbCol]; // ligne inventaire

		cptCaisse = cptEnnemi = 0;
		
		try
		{
			Scanner sc = new Scanner ( new FileInputStream(cheminFichier), "UTF8" );
				
			cptLig = 0;
			while ( sc.hasNextLine() )
			{
				sLigne = sc.nextLine();
				
				for ( int cptCol = 0; cptCol < grille[0].length; cptCol++ )
				{	
					this.grille[cptLig][cptCol] = sLigne.charAt( cptCol );
			
					switch (sLigne.charAt(cptCol)) 
					{
						case '+':this.posLig                 = cptLig;
								 this.posCol                 = cptCol;
								 this.grille[cptLig][cptCol] =    ' ';
								 break;

						case '@':this.posLigSortie           = cptLig;
								 this.posColSortie           = cptCol;
								 this.grille[cptLig][cptCol] =    ' ';
								 break;

						case '?':this.tabCaisse[cptCaisse]   =  new Caisse(cptLig,cptCol);
								 cptCaisse++;
								 this.grille[cptLig][cptCol] = ' ';
								 break;

						case '^':this.posLigBouton = cptLig;
								 this.posColBouton = cptCol;
								 this.obscurite    =   true;
								 break;

						case '¤':this.tabEnnemis[cptEnnemi]   =  new Ennemi(cptLig,cptCol);
								 cptEnnemi++;
								 this.grille[cptLig][cptCol]  = ' ';
								 break;

						default: break;
					}
				}
				cptLig++;
			}		
			sc.close();	
		}
		catch(Exception e){ e.printStackTrace();}
		this.dirPrec = 'D';
    }
	
	
	/*-----------------------------------------------------------*/
	/* Ajoute la clé dans l'inventaire avec le sybole approprié  */
	/*-----------------------------------------------------------*/
	public void setClef(int lig, int col)
	{
		boolean caseRemplie;
		char    cle        ;
		int     cpt        ;

		caseRemplie = true;
		cpt = 0;
		cle = this.grille[lig][col];
		
		while ( caseRemplie && (cle >='a' && cle <='w') )
		{
			if ( this.inventaire[cpt] < 'a' || this.inventaire[cpt] > 'w' )
			{
				this.inventaire[cpt]  = this.grille[lig][col];
				this.grille[lig][col] = ' ';
				caseRemplie = false;
			}
			cpt++;
		}

	}
	
	public void setGrille(int lig, int col,char newChar){this.grille[lig][col] = newChar;}
	public void SetFly(){this.fly = !this.fly;}
	

	public int      getNbLignes   ()           {return this.grille.length    ;}
	public int      getNbColonnes ()           {return this.grille[0].length ;}
	public int      getPosCol     ()           {return this.posCol           ;}
	public int      getPosLigne   ()           {return this.posLig           ;}
	public int      getNbNiveau   ()           {return this.nbNiveau         ;}
	public int      getNbSkin     ()           {return listeSkin.length      ;}
	public String   getSkin       (int nbSkin) {return listeSkin[nbSkin]     ;}
   	public boolean  getJoueurSaute()           {return this.joueurSaute      ;}
	public boolean  getJoueurVie  ()           {return this.enVie            ;}
	public char[][] getGrille     ()           {return this.grille           ;}
	public char[]   getInventaire ()           {return this.inventaire       ;}
	
	/*-----------------------------------------------------------------------*/
	/* Retourne le contenu de la case spécifiée par les indices lig et col.  */
	/*-----------------------------------------------------------------------*/
	public char getCase(int lig, int col,int couche) 
	{
		char valCase;

		lig     = this.getLigneThorique(lig)  ;
		col     = this.getColonneThorique(col);
		valCase = this.grille[lig][col]       ;

		if (lig    == this.posLigSortie       && col == this.posColSortie) valCase = '@';
		if (couche == 2 && lig == this.posLig && col == this.posCol      ) valCase = '+';
		

		/*----------------------------------------------------------------*/
		/*     Détermine les caisses et les goomba à la couche 1          */
		/*----------------------------------------------------------------*/

		if (couche == 1 )
		{
			for (int cpt = 0 ; cpt < this.tabCaisse.length; cpt++)
			{
				if ( tabCaisse[cpt] != null            && 
				     lig == tabCaisse[cpt].getPosLig() &&
				     col == tabCaisse[cpt].getPosCol() ) 
				{
					valCase = '?';
				}
			}
			for (int cptEnnemi = 0;cptEnnemi<tabEnnemis.length;cptEnnemi++)
			{
				if ( tabEnnemis[cptEnnemi] != null            && 
				     lig == tabEnnemis[cptEnnemi].getPosLig() &&
				     col == tabEnnemis[cptEnnemi].getPosCol() ) 
				{
					valCase = '¤';
				}
			}
		}		

		/*----------------------------------------------------------------*/
		/* Détermine la case qui doit avoir une luminauositée différente  */
		/* et regarde si c'est bien en couche 2                           */
		/*----------------------------------------------------------------*/
		if ( couche == 2 && this.obscurite)
		{
			if(Math.abs(this.posLig - lig) >= 1 || 
			   Math.abs(this.posCol - col) >= 3)
			{
				valCase = '*';
			}

		}

        return valCase;
    }


	/*---------------------------------------------------------------------*/	
	/*     Détermine les animations du joueur selon la direction du joueur */
	/*---------------------------------------------------------------------*/
	public String getAnimation()
	{
		String sRet;
		sRet = "droit";

		if (this.dirPrec == 'D') sRet = "droit";
		if (this.dirPrec == 'G') sRet = "gauche";

		if ( this.joueurMonte(this.posLig,this.posCol) &&
		     getCase(posLig, posCol,0) == '#'           )
		{
			if (this.posLig %2 ==0) sRet = "monte1";
			else                    sRet = "monte2";
		}

		if (this.joueurTombe() || this.joueurSaute ) sRet = "tombe";
	
		return sRet;
	}


	/*----------------------------------------------------------------------*/	
	/*     Détermine le message de fin de niveau a afficher dans les labels */
	/*----------------------------------------------------------------------*/
	public String getMessage()
	{
		String message;
		message = null;
		if (this.estSortie())
		{
			if (this.niveau == nbNiveau ) 
			{
				message = "Gagné ! \"E\" pour quitter.";
			}
			else
			{
				message = "Niveau fini. Appuie sur \"E\".";
			}
		}
		return message;
	}

	/*----------------------------------------------------------------------------*/
	/* Détermine le niveau d'obscurité en fonction de la distance avec le joueur. */
	/*----------------------------------------------------------------------------*/
	public String determinerSombre(int lig,int col)
	{
		String obscurite;
		obscurite = "noir4.png";

		if ((Math.abs(this.posLig - lig) >= 1 || Math.abs(this.posCol - col) >= 3))
			obscurite = "noir1.png";
		if ((Math.abs(this.posLig - lig) >= 2 || Math.abs(this.posCol - col) >= 4))
			obscurite = "noir2.png";
		if ((Math.abs(this.posLig - lig) >= 3 || Math.abs(this.posCol - col) >= 5))
			obscurite = "noir3.png";
		if ((Math.abs(this.posLig - lig) >= 4 || Math.abs(this.posCol - col) >= 6))
			obscurite = "noir4.png";
		
		return obscurite;
	}


	public void  ActiverSombre(){ this.obscurite = !this.obscurite; }

	public boolean joueurTombe(){ return !DeterminerGraviter(this.posLig, this.posCol); }
	

	/*------------------------------------------*/
	/* Indique si le joueur dois tomber ou non  */
	/*------------------------------------------*/
	public boolean DeterminerGraviter(int posLig, int posCol)
	{	
		boolean tombe;

		if (getCase(posLig + 1, posCol,0)              ==   '='       ||
			getCase(posLig + 1, posCol,1)              ==   '?'       ||
			this.getCaisse(this.posLig+1, this.posCol) != null        ||
			this.joueurMonte(posLig,posCol)                           || 
			this.joueurSaute)
		{
			tombe = true;
		}
		else
		{
			tombe = this.fly;
		}
		return tombe;
	}
	

	/*-------------------------------------------------------*/
	/* Indique si le joueur se trouve sur la case de sortie. */
	/*-------------------------------------------------------*/
	public boolean estSortie() 
	{
		return this.posLig == this.posLigSortie && this.posCol == this.posColSortie;
	}
	

	/*--------------------------------------------------*/
	/* Indique si le joueur est sur une échelle ou non  */
	/*--------------------------------------------------*/
	public boolean  joueurMonte(int posLig,int posCol) { return  (getCase(posLig, posCol, 0) == '#'); }


	/*-------------------------------------------------------------*/
	/* Vérifie si on est bloqué par une porte si on a pas de clé,  */
	/* et inversement si on en a une                               */
	/*-------------------------------------------------------------*/
	private boolean bloquerParPorte(int lig, int col)
	{
		Boolean porteCle;

		porteCle = false;
		for(int i =0 ; i< this.inventaire.length ; i++)
		{
			if(this.grille[lig][col] == (char)((int) this.inventaire[i] - ('a'-'A')) )
			{
				porteCle = true;
			}

		}
		return porteCle;
	}
	
	/*-----------------------------------------------------------------------------*/
	/* Gère le deplacement de l'ennemie  qui va dans une direction aléatoire.      */
	/*-----------------------------------------------------------------------------*/
	public void deplacerGoomba()
	{
		int    rdmDir;
		Ennemi ennemiCourant;
		ennemiCourant = null;

		for (int cptEnnemi = 0;cptEnnemi<tabEnnemis.length;cptEnnemi++)
		{
			
			ennemiCourant = tabEnnemis[cptEnnemi]  ;
			if (ennemiCourant != null)
			{
				rdmDir = (int)(Math.random() *2);
				
				if (rdmDir == 0)
				{
					if (this.getCase(this.getLigneThorique(ennemiCourant.getPosLig()+1), 
									this.getColonneThorique(ennemiCourant.getPosCol()+1), 0 ) == '=')
						{ 
							ennemiCourant.deplacer('D', this.grille[0].length); 
						}
				}
				else
				{
					if (this.getCase(this.getLigneThorique(ennemiCourant.getPosLig()+1), 
									this.getColonneThorique(ennemiCourant.getPosCol()-1), 0)  == '=')
						{ 
							ennemiCourant.deplacer('G', this.grille[0].length); 
						}
				}
				
			}
		}
	}

	/*--------------------------------------------------------------*/
	/* Gere le saut du personnage a l'horizontale et la diagonale.  */
	/*--------------------------------------------------------------*/
	public void sauter(char dir)
	{
		boolean saufEffectue;

		saufEffectue = true;

		if (this.joueurSaute||this.joueurTombe()) saufEffectue = false;

		if ( joueurMonte(this.posLig, this.posCol)&& dir == ' ' )
		{
			if (getCase(this.getLigneThorique(posLig-1), posCol,0) != '#') saufEffectue = false;
			if (saufEffectue)              this.posLig = this.getLigneThorique(this.posLig -1 );
			
			Graviter();
			saufEffectue = false;
		}
	
		this.dirPrec = ' ';

		if ( dir == 'D' && this.getCase(this.posLig-1, this.posCol+1,0) == '=' ) saufEffectue = false;
		if ( dir == 'G' && this.getCase(this.posLig-1, this.posCol-1,0) == '=' ) saufEffectue = false;
		if ( dir == ' ' && this.getCase(this.posLig-1, this.posCol,  0) == '=' ) saufEffectue = false;

		if ( saufEffectue ) this.posLig = this.getLigneThorique(this.posLig-1);

		if (dir == 'D')
		{
			this.dirPrec = 'D';

			if ( this.getCase(this.posLig, this.posCol+1,0)  == '=' ||
				(this.getCase(this.posLig, this.posCol+1,0) >= 'A'  &&
				 this.getCase(this.posLig, this.posCol+1,0) <= 'Z')   ) saufEffectue = false;

			if (saufEffectue) this.posCol +=1;
		}

		if (dir == 'G')
		{
			this.dirPrec = 'G';

			if ( this.getCase(this.posLig, this.posCol-1,0) == '=' || 
			     this.getCase(this.posLig, this.posCol-1,0) >= 'A' &&
				 this.getCase(this.posLig, this.posCol-1,0) <= 'Z'    ) saufEffectue = false;

			if (saufEffectue) this.posCol -= 1;
		}
		

		this.posCol = this.getColonneThorique(this.posCol);

		if ( saufEffectue ) this.joueurSaute = true;
	}

	/*------------------------------------*/
	/* Gere la fin de l'animation du saut */
	/*------------------------------------*/
	public void finSauter()
	{
		if ( !joueurSaute ) return;

		try{ Thread.sleep(300); } catch (InterruptedException ex){}

		this.joueurSaute = false;

		if ( this.joueurTombe() && this.dirPrec != ' ' )
		{
			if (this.dirPrec == 'D' && this.getCase(this.posLig, this.posCol+1,0) != '=')
			{
				this.posCol = this.getColonneThorique(this.posCol+1);
			}
			if (this.dirPrec == 'G' && this.getCase(this.posLig, this.posCol-1,0) != '=')
			{
				this.posCol = this.getColonneThorique(this.posCol-1);
			}
		}
	}


	/*-------------------------------*/
	/* Gère le deplacement du joueur */
	/*-------------------------------*/
	public void deplacer(char direction) 
	{
		int     nouvelleLig, nouvelleCol;
		Caisse  caisseJoueur;
		boolean saufEffectue;

		saufEffectue = true;

		nouvelleLig  = this.posLig;
		nouvelleCol  = this.posCol;
		
		if ( this.getCase(this.posLig, this.posCol, 0) == 'X' ) this.enVie = false;

		if ( direction == 'S' && this.posLig == this.grille[0].length - 1 )                         
		{
			if( grille[this.posLig][this.grille.length - 1] != '=' ) this.posLig = 0;
			
			saufEffectue = false;
		}

		if ( direction == 'O' && nouvelleCol == 0 )                         
		{
			if ( grille[this.posLig][this.grille[0].length - 1] != '=') 
			{
				this.posCol = this.grille[0].length - 1;
			}
			saufEffectue = false;
		}
		if ( direction == 'E' && nouvelleCol == this.grille[0].length - 1 ) 
		{
			if ( grille[this.posLig][0] != '=' ) 
			{
				this.posCol = 0;
			}
			saufEffectue = false;
			
		}
	
		if( DeterminerGraviter(this.posLig, nouvelleCol) && saufEffectue )
		{
			switch (direction) 
			{
				case 'S' :  nouvelleLig = this.getLigneThorique(nouvelleLig+1);
							this.dirPrec = ' ';
							break;
				case 'O' : 	if (this.dirPrec == 'G')nouvelleCol--;
							this.dirPrec = 'G';
							break;
				case 'E' : 	if (this.dirPrec == 'D')nouvelleCol++;
							this.dirPrec = 'D';
							break;
				default  :  break;
			
			}
        	/*------------------------------------------*/
        	/*      Verification collision murs         */
        	/*------------------------------------------*/
			if ( this.grille[nouvelleLig][nouvelleCol] != '=') 
			{
				caisseJoueur = this.getCaisse(nouvelleLig, nouvelleCol);
				if (caisseJoueur != null)
				{
					if (this.peutBougerCaisse(caisseJoueur))
					{
						caisseJoueur.deplacer(this.dirPrec,this.grille[0].length);
						this.posLig = nouvelleLig;
						this.posCol = nouvelleCol;
						while (this.getCase(caisseJoueur.getPosLig()+1,caisseJoueur.getPosCol(), 0) != '=' &&
							   this.getCase(caisseJoueur.getPosLig()+1,caisseJoueur.getPosCol(), 0) != 'X' &&
						       this.getCaisse(caisseJoueur.getPosLig()+1, caisseJoueur.getPosCol()) == null)
						{
							caisseJoueur.graviterCaisse();
						}
					}
					else
					{
						return;
					}
				}
				nouvelleCol = this.getColonneThorique(nouvelleCol);
				nouvelleLig = this.getLigneThorique(nouvelleLig);
				this.deplacerGoomba();

				if (this.getCase(nouvelleLig, nouvelleCol, 0) == 'X' ||
					this.getGoomba(nouvelleLig, nouvelleCol) != null) this.enVie = false;

				if (this.getPorte(nouvelleLig, nouvelleCol))
				{
					if ( !this.bloquerParPorte(nouvelleLig, nouvelleCol) ) saufEffectue = false;
					if (saufEffectue) this.posLig = nouvelleLig;
					if (saufEffectue) this.posCol = nouvelleCol;	
					if (saufEffectue) this.grille[nouvelleLig][nouvelleCol] = ' ';
				}
				else
				{
					this.posLig = nouvelleLig;
					this.posCol = nouvelleCol;	
				}

				if (this.getCase(nouvelleLig, nouvelleCol, 0) == '^') this.obscurite = false;
				this.Graviter();
				if (!this.estBouton()) this.obscurite = false;
				
			} 
		}
		else
		{
			if (saufEffectue)this.Graviter();
		}	
	}

	private boolean getPorte(int lig,int col)   
	{ 
		return  (this.grille[lig][col]<'Z' && this.grille[lig][col]>'A')   ;
	}

	private int getLigneThorique(int ligne)     
	{ 
		return( (this.grille.length -1 + ligne ) % (this.grille.length-1) );
	}
 
	private int getColonneThorique(int Colonne) 
	{ 
		return((this.grille[0].length + Colonne) % this.grille[0].length)  ;
	}

	private Caisse getCaisse(int ligCaisse,int colCaisse)
    {
        for ( int cpt = 0 ; cpt < this.tabCaisse.length; cpt++ )
        {
			if (tabCaisse[cpt] != null && ligCaisse == tabCaisse[cpt].getPosLig() &&
			    colCaisse == tabCaisse[cpt].getPosCol()) return tabCaisse[cpt];
		}
        return null;
    }

	/*------------------------------------------------------------------*/
    /*  Verification de la présence d'un interrupteur pour la lumière   */
    /*------------------------------------------------------------------*/
	private boolean estBouton()
	{
		boolean boutonPresent;

		boutonPresent = false;

		for ( int cptLig = 0; cptLig < grille.length; cptLig ++ )

			for ( int cptCol = 0; cptCol < grille[0].length; cptCol++ )

				if (grille[cptLig][cptCol] == '^') boutonPresent = true;

		return boutonPresent;
	}

	/*-----------------------------------------------------------------*/
	/* Retourne un booleen qui verifie si on peut déplacer la caisse.  */
	/*-----------------------------------------------------------------*/
	private boolean peutBougerCaisse(Caisse caisseJoueur)
    {
		boolean bougerCaisse;

		bougerCaisse = true;

		if (this.dirPrec == ' ' || this.joueurMonte(this.posLig, this.posCol)) bougerCaisse = false;
        if (this.dirPrec == 'G' && getCase(caisseJoueur.getPosLig(), caisseJoueur.getPosCol() -1 , 1) != ' ')
		{
			bougerCaisse = false;
		}

        if (this.dirPrec == 'D' && getCase(caisseJoueur.getPosLig(), caisseJoueur.getPosCol() +1 , 1) != ' ')
		{
			bougerCaisse = false;
		}

        return bougerCaisse;
    }


	/*---------------------------------------------------------------------------------*/
	/* Détermine si il y a un ennemi sur la case spécifiée par les indices lig et col  */
	/*---------------------------------------------------------------------------------*/
	private Ennemi getGoomba(int posLig,int posCol)
	{
		Ennemi goombaPos;
		goombaPos = null;
		for (int cpt = 0;cpt<tabEnnemis.length;cpt++)
		{
			if (tabEnnemis[cpt] != null               && 
			    tabEnnemis[cpt].getPosLig() == posLig && 
			    tabEnnemis[cpt].getPosCol() == posCol)
				goombaPos = tabEnnemis[cpt];
		}
		return goombaPos;
	}

	/*----------------------------------------------------------*/
	/*  Perrmet de faire tombé le joueur si il en a l'occasion  */
	/*----------------------------------------------------------*/
	private void Graviter()
	{

		if(!DeterminerGraviter(this.posLig, this.posCol))
		{
			if (getCase(this.getLigneThorique(this.posLig + 1), this.posCol, 0) =='X') enVie = false;
			this.posLig = this.getLigneThorique(this.posLig + 1);

		}
	}
}