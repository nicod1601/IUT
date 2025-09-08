import java.awt.*;
import javax.swing.*;

public class FrameIndex extends JFrame 
{
	private PanelIndex panelIndex;

	public FrameIndex(FrameAppli frameAppli)
	{
		this.setTitle("Trouver le code");
		this.setSize(500, 200);
		this.setLayout(new BorderLayout());

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelIndex = new PanelIndex(this, frameAppli);


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelIndex);

		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/



		this.setVisible(false);
	}
	public void setId(String nom , String prenom, String sexe)
	{
		this.panelIndex.setId(nom, prenom, sexe);
	}
}