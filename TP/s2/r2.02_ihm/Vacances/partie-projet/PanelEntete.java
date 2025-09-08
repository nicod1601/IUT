
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelEntete extends JPanel implements ActionListener
{
	private JTextField txtNom;

	public PanelEntete()
	{
		this.setLayout(new BorderLayout());
		/*------------------------------------*
		/*       Création des composants      */
		/*------------------------------------*/
		this.txtNom = new JTextField(10);

		/*------------------------------------*
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.txtNom);

		/*------------------------------------*
		/*       Activation des composants    */
		/*------------------------------------*/

		
	}

	public String getEntete()
	{
		return this.txtNom.getText();
	}


	public void actionPerformed(ActionEvent e)
	{

	}
}
