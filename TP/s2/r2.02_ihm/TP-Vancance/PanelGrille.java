import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelGrille extends JPanel implements ActionListener
{
	Controleur ctrl;

	JLabel[][] tabLblCase;
	JButton[]  tabButton;


	public PanelGrille(Controleur ctrl)
	{
		String[][] modele;
		this.ctrl = ctrl;

		int cas;
		int cptBtn=0;

		this.tabLblCase = new JLabel[this.ctrl.getNbLigne()][this.ctrl.getNbColonne()];
		this.tabButton  = new JButton[2*this.ctrl.getNbLigne() + 2*this.ctrl.getNbColonne()];
	
		this.setLayout ( new GridLayout ( this.ctrl.getNbLigne()+2, this.ctrl.getNbColonne()+2, 1, 1 ) );

		modele = this.getModele();


		/*------------------------------*/
		/* Création des composants      */
		/*------------------------------*/

		// Création des Labels
		this.tabLblCase  = new JLabel [ this.ctrl.getNbLigne() ] [ this.ctrl.getNbColonne() ];


		for (int lig=0;lig<tabLblCase.length; lig++ )
			for (int col=0;col<tabLblCase[lig].length; col++ )
			{
				/* A compléter */
				this.tabLblCase[lig][col] = new JLabel(); // Initialisation du JLabel
				this.tabLblCase[lig][col].setOpaque(true); // Permet d'afficher la couleur de fond
				this.tabLblCase[lig][col].setBackground(this.ctrl.getCouleur(lig, col));
			}


		// Création des Boutons
		this.tabButton = new JButton[ 2*this.ctrl.getNbLigne() + 2*this.ctrl.getNbColonne() ];

		cptBtn = 0;

		for (int lig=0;lig<modele.length; lig++ )
			for (int col=0;col<modele[lig].length; col++ )
				if ( modele[lig][col] != null && modele[lig][col].startsWith ("fl_" ) )
				{
					this.tabButton[cptBtn++] = new JButton(" " + new ImageIcon("fl_"+modele[lig][col]+".gif"));
				}


		/*------------------------------*/
		/* Postionnement des composants */
		/*------------------------------*/
		cptBtn = 0;

		for (int lig=0; lig<modele.length; lig++ )
			for (int col=0; col<modele[lig].length; col++ )
			{
				if ( modele[lig][col] == null            ) cas=0;
				else if ( modele[lig][col].startsWith ("fl_" )) cas=1;
				else                                            cas=2;

				switch ( cas )
				{
					case 0 -> this.add(new JLabel());/* A compléter */
					case 1 -> this.add(this.tabButton[cptBtn++]);/* A compléter */
					case 2 -> this.add(this.tabLblCase[lig - 1][col - 1 ]);/* A compléter */
				}
		}


		/*------------------------------*/
		/* Activation des composants    */
		/*------------------------------*/
		for (int cpt=0; cpt<this.tabButton.length; cpt++)
			this.tabButton[cpt].addActionListener(this);

	}


	public void majIHM()
	{
		for ( int lig=0; lig< this.tabLblCase.length; lig++)
			for ( int col=0; col< this.tabLblCase[lig].length; col++)
			{
				this.tabLblCase[lig][col].setBackground(this.ctrl.getCouleur(lig, col));
				this.tabLblCase[lig][col].repaint();
			}

	}

	public void actionPerformed ( ActionEvent e)
	{
		for(int cpt =0; cpt < this.tabButton.length; cpt++)
		{
			if(e.getSource() == this.tabButton[cpt])
			{
				if(cpt > 0 && cpt < 5)
				{
					this.ctrl.permuter('c', '-', cpt);
				}
				else
				{
					if(cpt > 18 && cpt < 23)
					{
						this.ctrl.permuter('c', '+', cpt);
					}
					else
					{
						
					}
				}
			}
		}
	}


	private String[][] getModele()
	{
		/* Voici un exemple de Modele généré pour une grille de 6 x 6

		{ {null,        "fl_haut", "fl_haut", "fl_haut", "fl_haut", "fl_haut", "fl_haut", null        },
	     {"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		  {"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		  {"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		  {"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		  {"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		  {"fl_gauche", "val",     "val",     "val",     "val",     "val",     "val",     "fl_droite" },
		  {null,        "fl_bas",  "fl_bas",  "fl_bas",  "fl_bas",  "fl_bas",  "fl_bas",   null       }  };
		*/


		// Construction du Modele correspondant à la taille de notre Grille.
		String[][] tabModele = new String[ctrl.getNbLigne()+2][ctrl.getNbColonne()+2];

		for (int lig = 1; lig < tabModele.length-1; lig++ )
		{
			tabModele[lig][0]                          = "fl_gauche";
			tabModele[lig][tabModele[lig].length - 1 ] = "fl_droite";
		}

		for (int col = 1; col < tabModele[0].length-1; col++ )
		{
			tabModele[0]                     [col] = "fl_haut";
			tabModele[tabModele.length - 1 ] [col] = "fl_bas";
		}

		for (int lig=1; lig < tabModele.length-1; lig++ )
			for (int col = 1; col < tabModele[0].length-1; col++ )
				tabModele[lig][col] = "val";

		return tabModele;
	}
}
