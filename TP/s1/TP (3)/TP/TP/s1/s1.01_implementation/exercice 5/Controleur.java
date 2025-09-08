/*----------------------------------------------*/
/*- Gere la l'interface graphique. Le mode débug*/
/*- Exercice 5                                  */
/*- Le groupe 1	                                */
/*- Lucas,Theo,Nichita ,Floriane,Audric         */ 
/*- 18/12/2024 8:40                             */
/*----------------------------------------------*/

import ihmgui.Controle;
import ihmgui.FrameGrille;


public class Controleur extends Controle
{
	final private String MOT_DE_PASSE = "TILDA";

	private Jeu         metier;  //Classe métier
	private FrameGrille frame ;  //Classe vue  

	private boolean     action   ;
	private boolean     finJeu   ;
	private boolean     debug    ;
	private boolean     continuer;
	
	private int         niveau   ;
	private int         niveauMax;
	private int         nbSkin   ;

	private String      codeDebug;
	
	private char        direction;


	/*-----------------------------*/
	/* Constructeur de Controleur  */
	/*-----------------------------*/
	public Controleur() 
	{
		this.debug     = false;
		this.finJeu    = false;
		this.continuer = false;
		this.niveau    = 1 ;
		this.nbSkin    = 0 ;
		this.niveauMax = 1 ;
		this.codeDebug = "";

		metier = new Jeu(this.niveau) ; //Instanciation de notre classe métier
		frame  = new FrameGrille(this); //Instanciation de la fenêtre graphique 
		
		frame.setSize     ( 1700,1100       );
		frame.setLocation ( 0,  10          );
		frame.setTitle    ( "Assasin Shrek" );
		frame.setVisible  ( true            );
	}

	/*--------------------------------------*/
	/* Méthode pour la gestion des boutons  */
	/*--------------------------------------*/
	public String setBouton(int numBtn)
	{
		String lib;
	
		switch (numBtn) 
		{
			case 0: lib = "Réinitialiser"   ; break;
			case 1: lib = "Niveau précédent"; break;
			case 2: lib = "Prochain niveau" ; break;
			case 3: lib = "Fermer Jeu"      ; break;
			case 4: lib = "Changer skin"    ; break;
			
			/*---------------------------------------*/
			/*   Création des Bouton dans le debug   */
			/*---------------------------------------*/
			case 5: if ( this.debug ) { lib = "Prochain niveau debug";} 
					else {            lib = null;}      break;
			case 6: if ( this.debug ) { lib = "Sombre";} 
					else {            lib = null;}      break;
			case 7: if ( this.debug ) { lib = "Fly";} 
					else {            lib = null;}      break;
			default:lib = null;
		}
		return lib;
	}

	/*------------------------------------*/
	/* Création des actions des boutons   */
	/*------------------------------------*/
	public void bouton(int action)
	{
		switch (action) 
		{
			case 0 -> reinitiasliserPartie    (); 
			case 1 -> passerPrecedentNiveau   ();
			case 2 -> passerProchainNiveau    ();
			case 3 -> this.finJeu = true        ;
			case 4 -> changerSkin             ();
			/*------------------*/
			/*   Bouton debug   */
			/*------------------*/
			case 5 -> passerProchainNiveauAbsolu  ();
			case 6 -> metier.ActiverSombre        ();
			case 7 -> metier.SetFly               ();
			default-> System.out.print("Vous avez appuyé un bouton qui n'existe pas");
		}
	}


	/*----------------------------------------------*/
	/* Active le mode debug en créant une nouvelle  */
	/* fenêtre avec des nouveaux boutons            */
	/*----------------------------------------------*/
	private void activeDebug() 
	{       
			this.debug = true;

			frame.fermer();

			frame  = new FrameGrille(this);

			frame.setSize     ( 2000,1100);
			frame.setLocation ( 0,  0               );
			frame.setTitle    ( "Assasin shrek "    );
			frame.setVisible  ( true                );
		
	}

	/*----------------------------------*/
    /* Permet de passer au skin suivant */
	/*----------------------------------*/
	private void changerSkin() 
	{
		this.nbSkin = (this.nbSkin + 1 ) % metier.getNbSkin();
		frame.majIHM();
	}
	
	/*------------------------------------------------------------------------------*/
	/* Permet de réinitiasliser la partie en intansiant une nouvelle classe métier  */
	/*------------------------------------------------------------------------------*/
	private void reinitiasliserPartie() 
	{
		metier = new Jeu(this.niveau);
		frame.majIHM();
	}
	
	/*--------------------------------------*/
	/* Permet de passer au niveau précedent */
	/*--------------------------------------*/
	private void passerPrecedentNiveau() 
	{
		if ( this.niveau > 1 )
		{
			this.niveau--  ;
			metier = new Jeu(this.niveau);
			frame.majIHM ();
		}
	}

	/*------------------------------------------------------------------------------------*/
	/* Passe au prochain niveau, même ceux non faits, uniquement accessible en mode debug */
	/*------------------------------------------------------------------------------------*/
	private void passerProchainNiveauAbsolu() 
	{
		if ( this.niveau < metier.getNbNiveau() ) 
		{   
			this.niveau++;
			
			if (this.niveau > this.niveauMax )  this.niveauMax = this.niveau ;

			metier = new Jeu(this.niveau);
			frame.majIHM();
		}
		else
		{
			this.finJeu = true;
		}
	}

	/*----------------------------------------------------------*/
	/* Passe au prochain niveau uniquement s'il a déjà été joué */
	/*----------------------------------------------------------*/
	private void passerProchainNiveau() 
	{
		if (this.niveau < this.niveauMax)
		{
			if (this.niveau < metier.getNbNiveau()) 
			{   
				this.niveau++;
				metier = new Jeu(this.niveau);
				frame.majIHM();
			}
			else
			{
				this.finJeu = true;
			}    
		}
	}

    /*------------------------------------------------------------------------*/
    /* Boucle principale du jeu : gère les actions du joueur,les mises à jour */
    /* de l'interface, les transitions entre niveaux et la fin du jeu.        */
    /*------------------------------------------------------------------------*/
	public void lancer()
	{
		int tempsEntreFrames;

		tempsEntreFrames = 50;
		
		while ( !finJeu )
		{
			if ( this.action )
			{
				tempsEntreFrames = 150; 

				metier.deplacer ( this.direction );
				
				frame.majIHM  ();
				recupererObjet();
				
				if ( !metier.joueurTombe() )
				{
					this.action      = false;
					tempsEntreFrames =    50;
				}
			}
			metier.deplacerGoomba();

			/*--------------------------------------------------------------------*/
			/* Temporisation nécessaire pour ne pas prendre toutes les ressources */
			/*--------------------------------------------------------------------*/
			try{ Thread.sleep(tempsEntreFrames); } catch (InterruptedException ex){}
			frame.majIHM();
			metier.finSauter();
			
			if ( !metier.getJoueurVie() ) reinitiasliserPartie();

			if ( metier.estSortie() )
			{
				this.setTextLabel(0)    ;
				this.continuer = false  ;

				while ( !this.continuer )
				{
					if (finJeu) break;
					try{ Thread.sleep(tempsEntreFrames); } catch (InterruptedException ex){}
				}

				this.passerProchainNiveauAbsolu();
			}
			
		}
		
		frame.majIHM();
		frame.fermer();

	}

	/*----------------------------------------------------------------*/
	/*    Gère les déplacements déclenchés par les touches du joueur  */
	/*    Et gère également le mot de passe pour le mode débug        */
	/*----------------------------------------------------------------*/
	public void jouer (String touche)
	{
		this.codeDebug += touche;

		if (!metier.joueurTombe())
		{
			if ( touche.equals ( "CR-FL-D" ) ) metier.sauter('D');
			if ( touche.equals ( "CR-FL-G" ) ) metier.sauter('G');
			if ( touche.equals ( "CR-"     ) ) metier.sauter(' ');


			if ( touche.equals ( "FL-H" )    ) metier.deplacer ( 'N' );
			if ( touche.equals ( "FL-G" )    ) metier.deplacer ( 'O' );
			if ( touche.equals ( "FL-B" )    ) metier.deplacer ( 'S' );
			if ( touche.equals ( "FL-D" )    ) metier.deplacer ( 'E' );

			if ( touche.equals ( "E"    )    ) this.continuer = true;
			
			this.action = true;
		}

		/*-------------------------------------------------------*/
		/* Gestion de l'écriture du mot de passe du mode débug   */
		/*-------------------------------------------------------*/
		if ( touche.equals( "" + MOT_DE_PASSE.charAt(0) ) ||
		     codeDebug.length() > MOT_DE_PASSE.length()   
		   )
			this.codeDebug = "" + MOT_DE_PASSE.charAt(0);

		if ( codeDebug.equals(MOT_DE_PASSE)) activeDebug();
	}



	/*--------------------------------------*/
	/*  Méthode pour la gestion des label   */
	/*--------------------------------------*/
	public String setLabel (int numLbl)
	{
		String lib;

		switch ( numLbl )
		{
			case 0 : lib = "";  break;
			
			default: lib = null;	//Cette dernière ligne est importante, fin de construction des labels
		}

		return lib;
	}
	
	/*-----------------------------------------------------------------------*/
	/* Méthode pour la récuprer le message correspondant renvoyer par le jeu */
	/*-----------------------------------------------------------------------*/
	public String  setTextLabel(int numLbl){return metier.getMessage();}
    
    /*----------------------------------------------------------*/
	/* Méthode pour sélectionner la bonne image selon la couche */
	/*----------------------------------------------------------*/
	public String setImage ( int ligne, int colonne, int couche)
	{   
		char   symbole = ' ';
		String rep     = "./images/";
		String skin    = metier.getSkin(nbSkin);
		String sImage  = rep + skin;

		if (ligne == metier.getGrille().length - 1)
		{
			if (colonne < metier.getInventaire().length - 1)
			{
				symbole = metier.getInventaire()[colonne];

				if ( symbole == 'b' ) sImage += "clebleue.png";
				if ( symbole == 'r' ) sImage += "clerouge.png";
				if ( symbole == 'v' ) sImage += "cleverte.png";
				if ( symbole == 'd' ) sImage += "clediam.png" ;
			}
		}
		else
		{

			symbole = metier.getCase(ligne,colonne,couche);

			/*------------------------------*/
			/* Place les images en couche 0 */
			/*------------------------------*/
			if ( couche == 0 )
			{
				switch (symbole) 
					{
						case '=':  sImage += this.determinerDirection(ligne,colonne);  break;
						case '@':  sImage += "sortie.png";                             break;
						case '#':  sImage += this.determinerEchelle(ligne,colonne);    break;
						case '^':
							sImage += "bouton.png";
							break;
						case 'X':
						sImage = "./images/Spikes.png";
							break;
						default:
							sImage += "vide52.png";
                            break;
                    }
			}


			/*------------------------------*/
			/* Place les images en couche 1 */
			/*------------------------------*/
			if ( couche == 1 )
			{
				
				switch (symbole) 
				{
					case 'B' -> sImage +=      "portebleue.png";
					case 'R' -> sImage +=      "porterouge.png";
					case 'V' -> sImage +=      "porteverte.png";
					case 'D' -> sImage +=       "portediam.png";
					case 'b' -> sImage +=        "clebleue.png";
					case 'r' -> sImage +=        "clerouge.png";
					case 'v' -> sImage +=        "cleverte.png";
					case 'd' -> sImage +=         "clediam.png";
					case '?' -> sImage +=          "caisse.png";
					case '¤' -> sImage  = "./images/Goomba.png";
					default  -> sImage +=          "vide52.png";
						
				}
			}

			/*------------------------------*/
			/* Place les images en couche 2 */
			/*------------------------------*/
			if ( couche == 2 )
			{
				if ( symbole == '+' ) sImage += this.determinerAnimation() + ".png";
				if ( symbole == '*' ) sImage = "./images/" + metier.determinerSombre(ligne,colonne);
			}
		}

		return sImage;
	}
	
	/*----------------------------------------------------------*/
	/* Détermine les images du personnage selon sa direction    */
	/*----------------------------------------------------------*/
	public String determinerAnimation(){return "pers_" + metier.getAnimation();}


	/*--------------------------------------------------*/
	/* Détermine les images du sol selon sa position    */
	/*--------------------------------------------------*/
	public String determinerDirection(int ligne,int colonne)
	{
		String direction;

		direction = "sol";

		
		if (colonne !=0 &&metier.getCase(ligne, colonne,0) !=
			metier.getCase(ligne, colonne-1 ,0)) direction += "_gauche";
		if (colonne != metier.getNbColonnes()-1 &&metier.getCase(ligne, colonne,0) !=
			metier.getCase(ligne, colonne+1,0)) direction += "_droit";
		

		direction += ".png";

		return direction;
	}

	/*--------------------------------------*/
	/* Détermine les images des échelles    */
	/*--------------------------------------*/
	public String determinerEchelle(int ligne,int colonne)
	{
		String direction;

		direction = "echelle";

		if (ligne != 0 && metier.getCase(ligne, colonne,0) != 
			metier.getCase(ligne-1, colonne,0)) direction += "_haut";

		direction += ".png";
		return direction;
	}


	/*--------------------------------------------------------------------*/
	/* Permet de récupérer les objets et les enlevé de la grlle de base   */
	/*--------------------------------------------------------------------*/
	public void recupererObjet() 
	{
			if (metier.getCase(metier.getPosLigne(),metier.getPosCol(),0) != ' ' &&
				metier.getCase(metier.getPosLigne(),metier.getPosCol(),0) != '#' &&
				metier.getCase(metier.getPosLigne(),metier.getPosCol(),0) != '@' )
			{
				metier.setClef(metier.getPosLigne(),metier.getPosCol())        ;
				metier.setGrille(metier.getPosLigne(), metier.getPosCol(), ' ');
			}
	}

	public int     setNbLigne        () { return metier.getNbLignes();   }
	public int     setNbColonne      () { return metier.getNbColonnes(); }
	public boolean setNumLigneColonne() { return false;                  }
	public int     setLargeurImg     () { return 52;                     }
	public String  setFondGrille     () { return "./images/" + metier.getSkin(nbSkin) + "fond.png";}
	public int     setLargeurLabel   () { return 400;                    }

	public static void main(String[] a)
	{
		new Controleur().lancer();
	}
}