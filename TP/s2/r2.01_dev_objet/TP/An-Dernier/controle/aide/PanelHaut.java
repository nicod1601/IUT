import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Color;

public class PanelHaut extends JPanel
{
	private JLabel lblResultat;
	private JLabel lblMessage;

	public PanelHaut()
	{
		this.setBackground(Color.GRAY);
		this.setLayout( new GridLayout(1,2));

		/*-----------------------*/
		/*Création des composants*/
		/*-----------------------*/
		this.lblResultat = new JLabel();
		this.lblMessage = new JLabel("Bienvenue");

		/*-----------------------*/
		/*Position des composants*/
		/*-----------------------*/
		this.add(this.lblMessage );
		this.add(this.lblResultat);
		
	}

	public void setText ( String message )
	{
		this.lblResultat.setText(message);
		this.lblMessage.setText("Vous avez tirez : ");
	}
}