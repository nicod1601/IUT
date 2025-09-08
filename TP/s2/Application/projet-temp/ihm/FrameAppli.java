package ihm;

import java.awt.BorderLayout;
import javax.swing.*;

public class FrameAppli extends JFrame
{
	private PanelMenu panelMenu;

	public FrameAppli()
	{
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setTitle("App");

		
		/* Créations des composants */
		this.panelMenu = new PanelMenu();

		/* Ajout des composants */
		this.add(this.panelMenu, BorderLayout.NORTH);

		this.setVisible(true);
	}
}
