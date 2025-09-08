import javax.swing.*;

public class FrameAppli extends JFrame
{
	private PanelConnexion panelCo;

	public FrameAppli()
	{
		this.setTitle("Trouver le code");
		this.setSize(500, 200);

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelCo = new PanelConnexion(this);


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelCo);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/



		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		new FrameAppli();
	}
}