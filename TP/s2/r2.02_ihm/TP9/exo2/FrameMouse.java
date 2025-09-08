import java.awt.*;
import java.awt.event.*;

public class FrameMouse extends Frame 
{
	public FrameMouse()
	{
		this.setTitle   ( "Evenements lies a la souris" );
		this.setSize    ( 400,300 );
		this.setLocation(  50, 50 );

		this.add ( new PanelMouse() );

		// Gestion de la fermture de la fenêtre
		this.addWindowListener( new WindowAdapter(){ public void windowClosing(WindowEvent e){System.exit(0);} } );

		this.setVisible(true);
	}


	/*---------------------------------------*/
	/* Main pour lancer l'application        */
	/*---------------------------------------*/
	public static void main(String args[])
	{
		new FrameMouse();
	}
}
