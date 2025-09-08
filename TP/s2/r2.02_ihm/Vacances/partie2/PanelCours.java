import PanelCours.PanelDev;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelCours extends JPanel implements ActionListener
{
	private JButton[] tabBtnCours;
	private Panel panelMenu;
	private String[] tabCours;

	private PanelDev panelDev;

	public PanelCours()
	{
		this.setLayout(new GridLayout(4,1,2,2));

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.tabCours = new String[]{"Accueil ","Dev Objet", "Bado", "IHM"};

		this.panelMenu = new Panel(new FlowLayout());

		this.tabBtnCours = new JButton[this.tabCours.length];
		for(int cpt =0; cpt < this.tabCours.length; cpt++)
		{
			this.tabBtnCours[cpt] = new JButton(this.tabCours[cpt]);
		}
		
		this.panelDev = new PanelDev();

		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelMenu.add(this.tabBtnCours[0]));
		this.add(this.panelMenu.add(this.tabBtnCours[1]));
		this.add(this.panelMenu.add(this.tabBtnCours[2]));

		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		for(int cpt =0; cpt < this.tabCours.length; cpt++)
		{
			this.tabBtnCours[cpt].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.tabBtnCours[0])
		{
			System.out.println("Accueil");
			//this.frame.setCours(this.panelDev);
			
		}
		if(e.getSource() == this.tabBtnCours[1])
		{
			System.out.println("Dev Objet");
		}
		if(e.getSource() == this.tabBtnCours[2])
		{
			System.out.println("Bado");
		}
		if(e.getSource() == this.tabBtnCours[3])
		{
			System.out.println("IHM");
		}
	}
}