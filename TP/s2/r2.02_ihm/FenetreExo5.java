import java.awt.*;

public class FenetreExo5 extends Frame
{
	private PanelHaut panelHaut;
	private PanelBas panelBas;
	private PanelDroit panelDroit;


	public FenetreExo5()
	{
		this.setTitle("Exercice 5");
		this.setSize(500,400);
		this.setBackground(Color.GRAY);

		this.setLayout(new BorderLayout());
		/*--------------------------- */
		/* Création des composants    */
		/*--------------------------- */
		this.panelHaut = new PanelHaut();
		this.panelBas = new PanelBas();
		this.panelDroit = new PanelDroit();
		
		/*--------------------------- */
		/* Ajout des composants       */
		/*--------------------------- */
		this.add(this.panelHaut, BorderLayout.NORTH);
		this.add(this.panelBas, BorderLayout.SOUTH);
		this.add(this.panelDroit, BorderLayout.EAST);
		this.add(new Panel());



		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new FenetreExo5();
	}
	
}
