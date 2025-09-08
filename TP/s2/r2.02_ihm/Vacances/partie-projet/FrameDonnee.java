import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class FrameDonnee extends JFrame implements ActionListener
{
	private PanelDonnee panelDonnee;
	private PanelTable panelTable;

	public FrameDonnee(PanelTable panelTable)
	{
		this.setTitle("Application");
		this.setSize(200, 600);
		this.setLayout(new BorderLayout());
		this.panelTable = panelTable;
		
		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelDonnee = new PanelDonnee(this.panelTable);

	
		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelDonnee);
		

		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/

		
		
		
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e)
	{


	}


	public void update()
    {
        this.panelDonnee.updateTable();
    }
}