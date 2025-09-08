import java.awt.*;
import javax.swing.*;

public class FrameAs extends JFrame 
{
	private JPanel             panelCoul;
	private PanelSelectCouleur panelRouge;
	private PanelSelectCouleur panelVert;
	private PanelSelectCouleur panelBleu;

	public FrameAs()
	{
		this.setTitle("Scrollbar");
		this.setSize(600,600);
		this.setLocation(50,50);
		this.setLayout(new GridLayout(4,1));

		/*-----------------------------*/
		/* Création des composants     */
		/*-----------------------------*/
		this.panelCoul  = new JPanel();
		this.panelRouge = new PanelSelectCouleur(this);
		this.panelVert  = new PanelSelectCouleur(this);
		this.panelBleu  = new PanelSelectCouleur(this);
		
		this.panelRouge.setBackground(Color.RED  );

		this.panelVert.setBackground(Color.GREEN);

		this.panelBleu .setBackground(Color.BLUE );

		this.panelCoul .setBackground(Color.BLACK);
		this.panelCoul .setOpaque(true  );
		
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add(this.panelCoul );
		this.add(this.panelRouge);
		this.add(this.panelVert );
		this.add(this.panelBleu );

		/*-----------------------------*/
		/* Activation des composants   */
		/*-----------------------------*/

		this.setVisible(true);
	}
	
	public void couleur()
	{
		int r = this.panelRouge.getVal();
		int v = this.panelVert .getVal();
		int b = this.panelBleu .getVal();

		this.panelCoul.setBackground(new Color(r,v,b));
	}


	public static void main(String [] args)
	{
		new FrameAs();
	}
}

