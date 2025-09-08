
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelParametre extends JPanel implements ActionListener
{
	private JPanel panelBtn;
	private JPanel panelBarre;
	private JButton btnPosition;

	private JScrollBar sbrR;
	private JScrollBar sbrG;
	private JScrollBar sbrB;
	private JPanel panelCouleur;
	

	private FrameAppli frame;

	public PanelParametre(FrameAppli frame)
	{
		this.setLayout(new BorderLayout());
		this.frame = frame;
		/*------------------------------------*
		/*       Création des composants      */
		/*------------------------------------*/
		this.btnPosition = new JButton("Changer la position");
		this.panelBtn = new JPanel();
		this.panelBarre = new JPanel(new GridLayout(3,1));

		this.sbrR = new JScrollBar(0,10,1,0,255+10);
		this.sbrG = new JScrollBar(0,10,1,0,255+10);
		this.sbrB = new JScrollBar(0,10,1,0,255+10);
		this.panelCouleur = new JPanel(new GridLayout(3,1));

		/*------------------------------------*
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelBtn.add(this.btnPosition);

		this.panelBarre.add(new JLabel());
		this.panelBarre.add(this.panelBtn);

		this.panelCouleur.add(this.sbrR);
		this.panelCouleur.add(this.sbrG);
		this.panelCouleur.add(this.sbrB);

		this.add(this.panelBarre, BorderLayout.WEST);
		this.add(this.panelCouleur, BorderLayout.CENTER);

		/*------------------------------------*
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnPosition.addActionListener(this);

		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnPosition)
		{
			System.out.println("Changer la position");
			this.frame.changerPosition();
		}
	}
}
