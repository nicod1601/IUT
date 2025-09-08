
import java.awt.*;
import java.awt.event.*;

public class PanelMouse extends Panel
{
	private Label lblMessage;
	private String message;
	
	private int x;
	private int y;

	public PanelMouse()
	{
		Panel panelGrille, panelGrilleZone1, panelGrilleZone2,panelGrilleZone3 ;
		

		this.setLayout ( new BorderLayout() );


		/* ----------------------- */
		/* Création des composants */
		/* ----------------------- */
		panelGrille = new Panel ( new  GridLayout(3,0) );

		panelGrilleZone1 = new Panel();
		panelGrilleZone2 = new Panel();
		panelGrilleZone3 = new Panel();

		panelGrilleZone1.setBackground(new Color(255, 160, 160));
		panelGrilleZone2.setBackground(new Color(160, 255, 160));
		panelGrilleZone3.setBackground(new Color(160, 160, 255));

		this.lblMessage  = new Label();
		this.lblMessage.setBackground(Color.white);
		


		/* ---------------------------- */
		/* Postionnement des composants */
		/* ---------------------------- */
		this.add( panelGrille, BorderLayout.CENTER );
		this.add( this.lblMessage, BorderLayout.SOUTH );

		panelGrille.add( panelGrilleZone1 );
		panelGrille.add( panelGrilleZone2 );
		panelGrille.add( panelGrilleZone3 );


		/* ------------------------- */
		/* Activation des composants */
		/* ------------------------- */
		panelGrilleZone1.addMouseListener(GereSouris.instance());
		panelGrilleZone2.addMouseListener(GereSouris.instance());
		panelGrilleZone3.addMouseListener(GereSouris.instance());

	}

	private class GereSouris extends MouseAdapter
	{
		public static GereSouris gs;

		
	
		public static GereSouris instance()
		{
			if (gs == null) gs = new GereSouris();
			return gs;
		}
	
		private GereSouris(PanelMouse panelMouse)
		{
			this.panelMouse = panelMouse;
		}
	
		public void mouseClicked(MouseEvent e)
		{
			PanelMouse.this.lblMessage.setText ("Click  " + e.getX() + " : " + e.getX() );
			System.out.println(e);
		}
	}

	/*---------------------------------------*/
	/* Méthode de l'interface MouseListener  */
	/* que l'on souhaite intercepter         */
	/*---------------------------------------*/
	/*public void mouseClicked(MouseEvent e)
	{
		PanelMouse.this.lblMessage.setText ("Click  " + e.getX() + " : " + e.getX() );
		PanelMouse.this.lblMessage.setText ("Click  " + e.getClientX() + " : " + e.getClientY() );
		//this.lblMessage.setText ("Click  " + e.getPoint());
		System.out.println(e);
	}
	
	public void mouseEntered(MouseEvent e)
	{
		PanelMouse.this.lblMessage.setText ("Entrer  " + e.getX() + "," + e.getY() );
	}
	
	public void mouseExited(MouseEvent e)
	{
		PanelMouse.this.lblMessage.setText ("Partie  " + e.getX() + "," + e.getY() );
		System.out.println(e);
	}
	
	public void mousePressed(MouseEvent e){}
	
	public void mouseReleased(MouseEvent e){}*/
}
