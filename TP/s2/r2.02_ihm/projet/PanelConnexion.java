import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelConnexion extends JPanel implements ActionListener
{
	private JPanel panelId;
	private JPanel panelMdp;
	private JPanel panelCo;

	private JTextField txtMotPasse;
	private JTextField txtId;
	private JButton btnValide;
	private JButton btnCreate;

	private FrameCreation frame;
	private FrameConnexion frameCo;


	public PanelConnexion(FrameConnexion frameCo)
	{
		this.setSize(500, 500);
		this.setLayout(new GridLayout(3,1));

		this.frameCo = frameCo;

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.txtId = new JTextField(20);
		this.txtMotPasse = new JTextField(20);
		this.btnValide = new JButton("Connexion");
		this.btnCreate = new JButton("Créer un compte");

		this.panelCo = new JPanel();
		this.panelId = new JPanel();
		this.panelMdp = new JPanel();

		this.frame = new FrameCreation();

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelCo.add(this.btnValide);
		this.panelCo.add(this.btnCreate);
		this.panelId.add(new JLabel("Identifiant "));
		this.panelId.add(this.txtId);
		this.panelMdp.add(new JLabel("Mot de Passe"));
		this.panelMdp.add(this.txtMotPasse);


		this.add(this.panelId);
		this.add(this.panelMdp);
		this.add(this.panelCo);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnValide.addActionListener(this);
		this.btnCreate.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnValide)
		{
			System.out.println("Connexion");
			System.out.println("Identifiant : " + this.txtId.getText());
			System.out.println("Mot de Passe : " + this.txtMotPasse.getText());
		}
		else if(e.getSource() == this.btnCreate)
		{
			System.out.println("Créer un compte");
			this.frame.setVisible(true);
			this.frameCo.setVisible(false);
		}
	}
}