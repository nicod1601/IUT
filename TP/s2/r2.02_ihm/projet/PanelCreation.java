import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelCreation extends JPanel implements ActionListener
{
	private JPanel panelEmail;
	private JPanel panelId;
	private JPanel panelMdp;
	private JPanel panelCo;

	private JTextField txtEmail;
	private JTextField txtMotPasse;
	private JTextField txtId;
	private JButton btnValide;


	public PanelCreation()
	{
		this.setSize(500, 500);
		this.setLayout(new GridLayout(4,1));

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		
		this.txtId = new JTextField(20);
		this.txtMotPasse = new JTextField(20);
		this.btnValide = new JButton("Connexion");
		this.txtEmail = new JTextField(20);

		
		this.panelEmail = new JPanel();
		this.panelCo = new JPanel();
		this.panelId = new JPanel();
		this.panelMdp = new JPanel();

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelCo.add(this.btnValide);
		this.panelId.add(new JLabel("Identifiant "));
		this.panelId.add(this.txtId);
		this.panelMdp.add(new JLabel("Mot de Passe"));
		this.panelMdp.add(this.txtMotPasse);
		this.panelEmail.add(new JLabel("Email "));
		this.panelEmail.add(this.txtEmail);



		this.add(this.panelEmail);
		this.add(this.panelId);
		this.add(this.panelMdp);
		this.add(this.panelCo);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnValide.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnValide)
		{
			System.out.println("Connexion");
			System.out.println("Identifiant : " + this.txtId.getText());
			System.out.println("Mot de Passe : " + this.txtMotPasse.getText());
		}
	}
}