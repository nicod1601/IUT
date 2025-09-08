import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelIndex extends JPanel implements ActionListener
{
	private JLabel lblId;
	private JButton btnDeco;

	private Panel panelMenu;
	private PanelCours panelCours;
	private FrameIndex frame;
	private FrameAppli frameAppli;

	public PanelIndex(FrameIndex frame, FrameAppli frameAppli)
	{
		this.setLayout(new BorderLayout());

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.frame = frame;
		this.frameAppli = frameAppli;

		this.panelCours = new PanelCours();

		this.panelMenu = new Panel(new FlowLayout(FlowLayout.RIGHT)); 
		this.lblId = new JLabel("");

		this.btnDeco = new JButton("Deconnexion");
		this.btnDeco.setBackground(Color.RED);


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelMenu.add(this.lblId);
		this.panelMenu.add(this.btnDeco);
		
		
		this.add(this.panelMenu, BorderLayout.NORTH);
		this.add(this.panelCours, BorderLayout.WEST);

		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnDeco.addActionListener(this);

	}

	public void setId(String nom , String prenom, String sexe)
	{
		this.lblId.setText(nom + " " + prenom + " " + sexe);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnDeco)
		{
			this.frame.setVisible(false);
			this.frameAppli.setVisible(true);
		}
	}
}