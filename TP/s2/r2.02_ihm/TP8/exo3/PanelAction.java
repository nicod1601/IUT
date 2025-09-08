
import java.awt.event.*;
import javax.swing.*;

public class PanelAction extends JPanel implements ActionListener
{
	private  Controleur ctrl;
	private  JButton    btnSauvegarder;

	public PanelAction (Controleur ctrl )
	{
		this.ctrl = ctrl;

		// crÃ©ation des composants
		this.btnSauvegarder = new JButton ( "Sauvegarder" );

		// Positionnement des composants
		this.add ( this.btnSauvegarder );

		// Activation des composants
		this.btnSauvegarder.addActionListener ( this );
	}


	public void actionPerformed ( ActionEvent e)
	{
		this.ctrl.sauvegarder ();
	}


}