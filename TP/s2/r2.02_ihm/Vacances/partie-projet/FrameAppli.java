import java.awt.*;
import javax.swing.*;

public class FrameAppli extends JFrame
{
	private PanelAppli panelAppli;
	private PanelBarreMenu panelBarreMenu;
	private PanelParametre panelParametre;

	int dir = 1;


	public FrameAppli()
	{
		this.setTitle("Application");
		this.setSize(600, 600);
		
		/*------------------------------------*/
		/*       Création des composants      */
		/*------------------------------------*/
		this.panelAppli     = new PanelAppli(this);
		this.panelBarreMenu = new PanelBarreMenu(this);
		this.panelParametre = new PanelParametre(this);
		
		
		/*------------------------------------*/
		/*    Positionnement des composants   */
		/*------------------------------------*/
		this.add(this.panelAppli);
		this.add(this.panelBarreMenu, BorderLayout.EAST);
		
		
		/*------------------------------------*/
		/*       Activation des composants    */
		/*------------------------------------*/
		
		
		
		this.setVisible(true);
	}

	public void setTable(boolean b)
	{
		this.panelAppli.setTable(b);
	}

	public boolean getSetTable()
	{
		return this.panelAppli.getSetTable();
	}

	public void changerPosition()
    {
		if( this.dir == 1)
		{
			this.getContentPane().removeAll();
			this.add(this.panelAppli);
			this.add(this.panelBarreMenu, BorderLayout.WEST);
			this.dir = 0;
	
			this.revalidate();
			this.repaint();
		}
		else
		{
			this.getContentPane().removeAll();
			this.add(this.panelAppli);
			this.add(this.panelBarreMenu, BorderLayout.EAST);
			this.dir = 1;
	
			this.revalidate();
			this.repaint();
		}
       
    }

	public void setPanelBarreMenu(boolean b)
	{
		this.panelBarreMenu.setVisible(b);
	}

	public boolean barreMenu()
	{
		return this.panelBarreMenu.isVisible();
	}

	public static void main(String[] args)
	{
		new FrameAppli();
	}
}