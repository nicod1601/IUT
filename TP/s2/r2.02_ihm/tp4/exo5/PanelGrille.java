import java.awt.*;
import java.awt.event.*;

public class PanelGrille extends Panel implements ActionListener 
{
	private Color[] tabCoul;
	private Button[] btnCouleur;
	
	private Exo5 frame;

	public PanelGrille(Exo5 frame)
	{
	
		this.setLayout(new GridLayout(4,3,10,10));
		this.frame = frame;
		/* ------------------------------ */
		/* Création des composants        */
		/* ------------------------------ */
		this.tabCoul = new Color[] { Color.BLACK,      Color.BLUE,    Color.CYAN,
		                             Color.DARK_GRAY,  Color.GRAY,    Color.GREEN,
		                             Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
		                             Color.PINK,       Color.RED,     Color.WHITE  };
		                             
		this.btnCouleur = new Button[this.tabCoul.length];
		
		for(int cpt = 0; cpt < this.btnCouleur.length; cpt++)
		{
			this.btnCouleur[cpt] = new Button();
			this.btnCouleur[cpt].setBackground(this.tabCoul[cpt]);
		}

		/* ------------------------------ */
		/* Positionnement des composants  */
		/* ------------------------------ */
		for(int cpt = 0; cpt < this.tabCoul.length; cpt ++)
		{
			this.add(this.btnCouleur[cpt]);
		}
		

		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		for(int cpt = 0; cpt < this.tabCoul.length; cpt++)
		{
			this.btnCouleur[cpt].addActionListener(this);
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int cpt = 0; cpt < this.btnCouleur.length; cpt++)
		{
			if(e.getSource() == this.btnCouleur[cpt])
			{
				this.frame.setFond(this.tabCoul[cpt]);
				System.out.println(this.tabCoul[cpt]);
			}
		}
	}
}
