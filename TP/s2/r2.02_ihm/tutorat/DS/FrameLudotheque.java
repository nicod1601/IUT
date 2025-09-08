import java.awt.BorderLayout;
import javax.swing.*;


public class FrameLudotheque extends JFrame
{

	public FrameLudotheque()
	{
		this.setTitle    ( "Ludothèque" );
		this.setLocation ( 500, 350 );
		this.setSize     ( 550, 200 );
		this.setLayout(new BorderLayout());

		this.add ( new PanelSaisie() );
		this.add ( new PanelAjouter(), BorderLayout.SOUTH );


		// Instruction pour fermer la fenêtre en swing
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setVisible(true);

	}


	public static void main(String[] a)
	{
		new FrameLudotheque();
	}

}