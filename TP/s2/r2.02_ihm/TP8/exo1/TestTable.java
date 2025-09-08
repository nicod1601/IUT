import java.awt.GridLayout;
import javax.swing.*;


public class TestTable extends JFrame
{
	public TestTable()
	{
		PanelTable1 panel1;
		PanelTable2 panel2;
		PanelTable3 panel3;
		PanelTable4 panel4;

		this.setLayout ( new GridLayout ( 4, 1, 5, 5 ) );
		this.setSize   ( 500, 600 );

		// Création des composants

		panel1 = new PanelTable1 ();
		panel2 = new PanelTable2 ();
		panel3 = new PanelTable3 ();
		panel4 = new PanelTable4 ();

		// Positionnement des composants

		this.add ( panel1 );
		this.add ( panel2 );
		this.add ( panel3 );
		this.add ( panel4 );

		this.setVisible ( true );
	}


	public static void main(String[] a){ new TestTable(); }

}