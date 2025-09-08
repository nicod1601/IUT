import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelDonnee extends JPanel implements ActionListener
{
	private int nbLigne = 1;
	private JTextField[][] tabTxt;
	private String[] tabEntete;
	private JButton btn;

	private PanelTable panel;
	

	public PanelDonnee(PanelTable panel)
	{
		this.panel = panel;

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.btn = new JButton("+");

		this.tabEntete = this.panel.getTabEntete();
		this.updateTable();

		this.setLayout(new GridLayout(this.nbLigne + 1,this.tabEntete.length));


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.btn);

		for(int cpt=0;cpt<this.tabEntete.length-1;cpt++)
		{
			this.add(new JLabel());
		}

		for(int cpt=0;cpt<this.tabEntete.length;cpt++)
		{
			this.add(new JLabel(this.tabEntete[cpt]));
		}


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btn.addActionListener(this);

	}

	public void updateTable()
	{
		this.tabEntete = this.panel.getTabEntete();
		this.revalidate();
		this.repaint();
	}
	public void actionPerformed(ActionEvent e)
	{

	}
}
