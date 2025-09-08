import java.awt.BorderLayout;

import javax.swing.*;


public class PanelTable4 extends JPanel
{
	JTable tblGrilleDonnees;

	public PanelTable4 ()
	{
		JScrollPane spGrilleDonnees;

		this.setLayout ( new BorderLayout() );


		// Création des composants
		tblGrilleDonnees    = new JTable ( new GrilleDonneesModel() );
 		spGrilleDonnees     = new JScrollPane( tblGrilleDonnees );
		tblGrilleDonnees.setFillsViewportHeight(true);


		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );

	}
}