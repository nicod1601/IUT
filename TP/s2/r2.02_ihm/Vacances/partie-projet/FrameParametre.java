import javax.swing.*;

public class FrameParametre extends JFrame
{
	private PanelParametre panelParemetre;

	private FrameAppli frame;
	
	public FrameParametre(FrameAppli frame)
	{
		this.setSize(200, 600);
		this.frame = frame;
		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelParemetre = new PanelParametre(this.frame);
		


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelParemetre);

		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		
		
		
		this.setVisible(false);
	}
}