
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelBarreMenu extends JPanel implements ActionListener
{
	private JButton btnTable;
	private JPanel panelBtn;

	private FrameAppli frame;

	public PanelBarreMenu(FrameAppli frame)
	{
		this.setLayout(new GridLayout(3,1));
		this.setBackground(Color.LIGHT_GRAY);
		this.frame = frame;
		/*------------------------------------*
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelBtn = new JPanel();
		this.panelBtn.setOpaque(false);
		this.btnTable = new JButton("Tableau");

		/*------------------------------------*
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelBtn.add(this.btnTable);

		this.add(new JLabel());
		this.add(this.panelBtn);

		/*------------------------------------*
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnTable.addActionListener(this);


		this.setVisible(false);
		
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnTable)
		{
			System.out.println("Tableau");
			if(this.frame.getSetTable())
			{
				this.frame.setTable(false);	
			}
			else
			{
				this.frame.setTable(true);
			}
		}
	}
}
