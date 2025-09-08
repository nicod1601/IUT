import javax.swing.*;

public class FrameConnexion extends JFrame
{
	private PanelConnexion panelCo;

	public FrameConnexion()
	{
		this.setTitle("Trouver le code");
		this.setSize(400, 130);

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



		this.setVisible(true);;
	}
	public static void main(String[] args)
	{
		new FrameConnexion();
	}
}