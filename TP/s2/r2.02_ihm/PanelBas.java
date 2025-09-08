
import java.awt.*;

public class PanelBas extends Panel 
{
	private Button btnChoix1;
	private Button btnChoix2;
	
	public PanelBas()
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(Color.WHITE);
		/*--------------------------- */
		/* Création des composants    */
		/*--------------------------- */
		this.btnChoix1 = new Button("Choix 1");
		this.btnChoix2 = new Button("Choix 2");

		this.btnChoix1.setBackground(Color.BLUE);
		this.btnChoix2.setBackground(Color.BLUE);
		
		/*--------------------------- */
		/* Ajout des composants       */
		/*--------------------------- */
		this.add(this.btnChoix1);
		this.add(this.btnChoix2);
	}
}