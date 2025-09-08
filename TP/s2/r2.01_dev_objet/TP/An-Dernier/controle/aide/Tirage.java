import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Tirage extends JFrame
{
	private PanelHaut   panelCenter;
	private PanelCentre panelSud;
	private PanelDroite panelDroite;
	private PanelGauche panelGauche;

	public Tirage()
	{
		/*---------------------*/
		/*Paramètre de la Frame*/
		/*---------------------*/
		this.setTitle("site");
		this.setLocation(100,100);
		this.setSize(800,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // fermeture de la fenetre + le programme
		this.setBackground(Color.CYAN);
		//this.setLayout(new BorderLayout(2,2));
		this.setLayout(new BorderLayout(1,1));

		/*-----------------------*/
		/*Création des composants*/
		/*-----------------------*/
		this.panelCenter = new PanelHaut();
		this.panelSud = new PanelCentre(this);
		this.panelDroite = new PanelDroite(this);
		this.panelGauche = new PanelGauche();

		/*-----------------------*/
		/*Position des composants*/
		/*-----------------------*/
		this.add(this.panelGauche,BorderLayout.WEST);
		this.add(this.panelCenter  , BorderLayout.CENTER );
		this.add(this.panelDroite, BorderLayout.EAST  );
		this.add(this.panelSud, BorderLayout.SOUTH);

		this.pack();
		this.setVisible(true);

	}

	public void setText ( String mess)
	{
		this.panelCenter.setText (mess);
	}

	public void Background(Color c)
	{
		this.panelSud.Background(c);
	}

	public void setEnabled(boolean t)
	{
		this.panelSud.setEnabled(t);
	}
	public static void main(String [] args) { new Tirage(); }
}