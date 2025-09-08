package quarto.ihm;
import quarto.Controleur;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

/**
  * Zone pannel pour représenter sous forme graphique l'application
  * @author Philippe Le Pivert.
  */
class PannelPlateau extends JPanel
{

	private final int MARGE_GAUCHE = 20;
	private final int MARGE_HAUT   = 50;
	private final int LARGEUR_IMG  = 70;


	private Controleur ctrl;
	private Graphics2D g2;

	private JButton[]    btnBarre;
	private JButton      btnQuarto;
	private JLabel       lblPlateau, lblPioche, lblPieceAJouer, lblMessage;



	public PannelPlateau (Controleur  ctrl)
	{
		System.out.println ( "IhmGui  (c) iut : Philippe Le Pivert" );

		setLayout  (null);      // Suppression de la gestion des layouts,
		                        // pas très conseillée par la littérature, mais bien pratique

		this.ctrl = ctrl;

		// Positionnement des Boutons de la pioche
		this.btnBarre = new JButton[16];

		int x=400,y=50;

		for (int i = 0;i<btnBarre.length;i++)
		{
			this.btnBarre[i] = new JButton();
			this.add ( btnBarre[i] );
			this.btnBarre[i].setBounds ( x, y, LARGEUR_IMG, LARGEUR_IMG);
			this.btnBarre[i].addActionListener  ( new BoutonAction(i) );

			x += LARGEUR_IMG;
			if ( (i+1)%4==0 ) { x=400; y+=LARGEUR_IMG; }
		}


		// -------------
		// Bouton Quarto

		this.btnQuarto = new JButton( "Quarto!" );
		this.add ( btnQuarto );
		btnQuarto.setBounds ( 400, 400, 100, 20 );

		this.btnQuarto.addActionListener  ( new BoutonAction(20) );

		// ------
		// Labels

		lblPlateau     = new JLabel ( "Plateau" );
		lblPioche      = new JLabel ( "Pioche"  );
		lblPieceAJouer = new JLabel ( "Piece A Jouer" );
		lblMessage     = new JLabel ( );

		this.add ( lblPlateau     );
		this.add ( lblPioche      );
		this.add ( lblPieceAJouer );
		this.add ( lblMessage     );

		lblPlateau.setBounds     (  20,  10, 100, 20 );
		lblPioche.setBounds      ( 400,  10, 100, 20 );
		lblPieceAJouer.setBounds (  20, 370, 100, 20 );
		lblMessage.setBounds     ( 100, 340, 650, 20 );

		lblMessage.setForeground ( new Color ( 58, 77, 140 ) );
		lblMessage.setFont       ( new Font  ( "Arial", Font.BOLD, 16 ) );

		// Instanciation du Gestionnaire d'événement Souris
		// ------------------------------------------------
		GestionSouris ecouteurSouris = new GestionSouris();
		addMouseListener ( ecouteurSouris );
		setFocusable   ( true     );

	}


	/*-----------------------------------------------*/
	/* Méthode permettant de redessinner entièrement */
	/* le contenu de la fenêtre                      */
	/* Attention ne pas modifier le nom de cette     */
	/* méthode                                       */
	/*-----------------------------------------------*/
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		String sImage;
		Image img;

		g2 = (Graphics2D) g;

		// dessin du plateau
		for (int lig=0; lig<ctrl.getNbLigne(); lig++ )
			for (int col=0; col<ctrl.getNbColonne(); col++ )
			{
				sImage = ctrl.getImage ("plateau", lig, col);
				img = getToolkit().getImage (  sImage   );
				g2.drawImage ( img, MARGE_GAUCHE + col * LARGEUR_IMG, MARGE_HAUT + lig * LARGEUR_IMG, this );
			}


		// dessin de la pioche
		for (int lig=0; lig<16; lig++)
		{
			sImage = ctrl.getImage ( "pioche", lig, 0);
			btnBarre[lig].setIcon( new ImageIcon (sImage) );
		}


		// Affichage de la piece en Cours
		sImage = ctrl.getImage ("enCours", 0, 0);
		img = getToolkit().getImage ( sImage );
		g2.drawImage ( img, 20 , 400, this );


		// Affichage du message

		lblMessage.setText( ctrl.getMessage() );

	}



	// Classe interne pour la gestion des événements Souris
	private class GestionSouris extends MouseAdapter
	{

		public void mousePressed(MouseEvent event)
		{
			int x = ( event.getX()- MARGE_GAUCHE ) / LARGEUR_IMG;
			int y = ( event.getY()- MARGE_HAUT   ) / LARGEUR_IMG;

			ctrl.cliquer ( y, x );
		}

	}


	// Classe interne pour la Gestion des Evénements sur Contrôles Btn
	private class BoutonAction implements ActionListener
	{
		private int act;       // identifiant du bouton cliquer au cas
		                       // où l'interface comporterait plusieurs boutons

		public BoutonAction(int act)
		{
			this.act = act;
		}

		public void actionPerformed(ActionEvent event)
		{
			ctrl.bouton ( act );
			PannelPlateau.this.requestFocusInWindow();
		}
	}

}
