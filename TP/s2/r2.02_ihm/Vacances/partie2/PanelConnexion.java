import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelConnexion extends JPanel implements ActionListener
{
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JButton btnConnexion;

	private Panel panel;
	private CheckboxGroup chSexe;
	private Checkbox chHomme;
	private Checkbox chFemme;

	private FrameIndex frame;
	private FrameAppli frameAppli;

	public PanelConnexion(FrameAppli frame)
	{
		this.setSize(500, 500);
		this.setLayout(new GridLayout(4,2));
		this.setBackground(Color.lightGray);

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.txtNom    = new JTextField(20);
		this.txtPrenom = new JTextField(20);

		this.panel = new Panel();
		this.chSexe = new CheckboxGroup();
		
		this.chHomme = new Checkbox("Homme");
		this.chFemme = new Checkbox("Femme");

		this.chHomme.setCheckboxGroup(this.chSexe);
		this.chFemme.setCheckboxGroup(this.chSexe);

		this.btnConnexion = new JButton("Connexion");
		this.btnConnexion.setBackground(Color.GREEN);

		this.frameAppli = frame;

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panel.add(this.chHomme);
		this.panel.add(this.chFemme);


		this.add(new JLabel("Nom       :"));
		this.add(this.txtNom);
		this.add(new JLabel("Prénom :   "));
		this.add(this.txtPrenom);
		this.add(new JLabel("Sexe        :"));
		this.add(this.panel);
		this.add(new JLabel(" "));
		this.add(this.btnConnexion);



		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnConnexion.addActionListener(this);
		this.txtNom.addActionListener(this);
		this.txtPrenom.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnConnexion)
		{
			System.out.println("Connexion");

			if(this.frame != null)
			{
				this.frame.setVisible(true);
				this.frameAppli.setVisible(false);
				this.frame.setId(this.txtNom.getText(), this.txtPrenom.getText(), this.chSexe.getSelectedCheckbox().getLabel());
			}
			else
			{
				this.frame = new FrameIndex(this.frameAppli);
				this.frame.setVisible(true);
				this.frameAppli.setVisible(false);
				this.frame.setId(this.txtNom.getText(), this.txtPrenom.getText(), this.chSexe.getSelectedCheckbox().getLabel());
			}
			
		}
	}
}