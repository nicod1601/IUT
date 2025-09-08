
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelAppli extends JPanel implements ActionListener
{
	private JPanel panelMenu;

	private JButton btnParametre;
	private JButton btnBarreMenu;

	private FrameAppli frame;
	private FrameParametre frameParametre;
	private PanelTable panelTable;

	public PanelAppli(FrameAppli frame)
	{
		this.setLayout(new BorderLayout());
		this.frame = frame;

		/*------------------------------------*
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.panelMenu.setBackground(Color.LIGHT_GRAY);


		this.btnParametre = new JButton("Parametre");
		this.btnBarreMenu = new JButton("+");

		this.frameParametre = new FrameParametre(this.frame);

		this.panelTable = new PanelTable();

		/*------------------------------------*
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.panelMenu.add(this.btnParametre);
		this.panelMenu.add(this.btnBarreMenu);

		this.add(this.panelMenu, BorderLayout.NORTH);
		this.add(this.panelTable);

		/*------------------------------------*
		/*       Activation des composants    */
		/*------------------------------------*/
		this.btnParametre.addActionListener(this);
		this.btnBarreMenu.addActionListener(this);
		
	}

	public boolean getSetTable()
	{
		return this.panelTable.getSetTable();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnBarreMenu)
		{
			System.out.println("Barre Menu");

			if(this.frame.barreMenu())
			{
				this.frame.setPanelBarreMenu(false);
				this.btnBarreMenu.setText("+");
			}
			else
			{
				this.frame.setPanelBarreMenu(true);
				this.btnBarreMenu.setText("-");
			}

		}

		if(e.getSource() == this.btnParametre)
		{
			System.out.println("Parametre");

			this.frameParametre.setVisible(true);
		}
	}

	public void setTable(boolean b)
	{
		this.panelTable.setVisible(b);
	}
}
