import java.awt.*;
public class PanelDroit extends Panel 
{
	private Button[] tabBtn;

	public PanelDroit()
	{
		this.setLayout(new GridLayout(5,2, 10,10));
		this.setBackground(Color.WHITE);


		/*--------------------------- */
		/* Création des composants    */
		/*--------------------------- */
		this.tabBtn = new Button[10];
		for(int cpt = 0; cpt < this.tabBtn.length; cpt++)
		{
			this.tabBtn[cpt] = new Button("" + ( (cpt+ 1 ) * 10));
			this.tabBtn[cpt].setBackground(Color.GREEN);
		}

		/*--------------------------- */
		/* Ajout des composants       */
		/*--------------------------- */
		for(int cpt = 0; cpt < this.tabBtn.length; cpt++)
		{
			this.add(this.tabBtn[cpt]);
		}
	}
}
