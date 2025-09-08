
import java.awt.*;

public class PanelHaut extends Panel 
{
	private Button btnOui;
	private Button btnNon;
	
	public PanelHaut()
	{
		this.setLayout(new FlowLayout());
		this.setBackground(Color.BLACK);
		/*--------------------------- */
		/* Création des composants    */
		/*--------------------------- */
		this.btnOui = new Button("Oui");
		this.btnNon = new Button("Non");

		this.btnOui.setBackground(Color.RED);
		this.btnNon.setBackground(Color.RED);
		
		/*--------------------------- */
		/* Ajout des composants       */
		/*--------------------------- */
		this.add(this.btnOui);
		this.add(this.btnNon);
	}
}