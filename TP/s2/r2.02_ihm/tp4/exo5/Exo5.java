import java.awt.*;

public class Exo5 extends Frame
{
	private PanelCouleur panelCouleur;
	private PanelGrille  panelGrille;
	
	public Exo5()
	{
		this.setTitle("Palette de couleur");
		this.setLocation(500,500);
		this.setSize(500, 500);
		this.setLayout(new GridLayout(1,2));

		/* ------------------------------ */
		/* Création des composants        */
		/* ------------------------------ */
		this.panelCouleur = new PanelCouleur();
		this.panelGrille  = new PanelGrille(this);

		/* ------------------------------ */
		/* Positionnement des composants  */
		/* ------------------------------ */
		this.add(this.panelGrille);
		this.add(this.panelCouleur);


		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		

		this.setVisible(true);
	}

	public void setFond(Color c)
	{
		this.panelCouleur.setBackground(c);
	}
	public static void main(String[] a)
	{
		new Exo5();
	}
}
