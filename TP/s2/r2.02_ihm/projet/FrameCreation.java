import javax.swing.*;

public class FrameCreation extends JFrame
{
	private PanelCreation panelCreation;

	public FrameCreation()
	{

		this.setTitle("Trouver le code");
		this.setSize(400, 130);

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelCreation = new PanelCreation();


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelCreation);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/



		this.setVisible(true);;
	}
	public static void main(String[] args)
	{
		new FrameCreation();
	}
}