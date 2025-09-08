import java.awt.*;
import javax.swing.*;

public class FrameCode extends JFrame
{
	private PanelBouton panelBouton;
	private PanelAffichage panelAffichage;

	public FrameCode()
	{
		this.setTitle("Trouver le code");
		this.setSize(200, 500);
		this.setLayout(new GridLayout(2,1));

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelAffichage = new PanelAffichage();
		this.panelBouton = new PanelBouton(this);


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelAffichage);
		this.add(this.panelBouton);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/



		this.setVisible(true);
	}
	public void setNum(int num)
	{
		this.panelAffichage.setNum(num);
	}

	public void valide(boolean b)
	{
		this.panelAffichage.valide(b);
	}

	public static void main(String[] args)
	{
		new FrameCode();
	}
}