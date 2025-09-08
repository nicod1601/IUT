package PanelCours;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelDev extends JPanel implements ActionListener
{
	public PanelDev()
	{
		this.setLayout(new BorderLayout());

		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/


		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(new JLabel("Developpement Objet"), BorderLayout.NORTH);


		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/



		this.setVisible(false);

	}

	public void actionPerformed(ActionEvent e)
	{

	}
}