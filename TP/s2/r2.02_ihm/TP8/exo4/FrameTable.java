import java.awt.BorderLayout;
import javax.swing.*;


public class FrameTable extends JFrame
{
	private Controleur  ctrl;
	private PanelTable  panel1;
	private PanelAction panel2;

	public FrameTable(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 500, 250 );

		// CrÃ©ation des composants
		this.panel1 = new PanelTable  (this.ctrl);
		this.panel2 = new PanelAction (this.ctrl, this);

		// Positionnement des composants

		this.add ( panel1, BorderLayout.CENTER );
		this.add ( panel2, BorderLayout.SOUTH  );

		this.setVisible ( true );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
