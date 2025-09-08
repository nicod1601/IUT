
import java.awt.event.*;
import javax.swing.*;

public class PanelAction extends JPanel implements ActionListener
{
	private  Controleur ctrl;
	private  JButton    btnSauvegarder;
	private  JButton    btnCreer;
	
	private FrameNouveauClient frameNVClient;
	private FrameTable frame;

	public PanelAction (Controleur ctrl, FrameTable frame)
	{
		this.ctrl = ctrl;
		this.frame = frame;
		// crÃ©ation des composants
		this.btnSauvegarder = new JButton ( "Sauvegarder" );
		this.btnCreer       = new JButton ( "Creer Nouveau Cliens ");
		this.frameNVClient  = new FrameNouveauClient(this.ctrl, this.frame);

		// Positionnement des composants
		this.add ( this.btnSauvegarder );
		this.add ( this.btnCreer       );

		// Activation des composants
		this.btnSauvegarder.addActionListener ( this );
		this.btnCreer.addActionListener(this);
	}


	public void actionPerformed ( ActionEvent e)
	{
		if(e.getSource() == this.btnSauvegarder)
		{
			this.ctrl.sauvegarder ();
		}
		
		if(e.getSource() == this.btnCreer)
		{
			this.frameNVClient.setVisible(true);	
		}
	}


}
