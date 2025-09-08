import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;


public class PanelTable extends JPanel
{
	private Controleur ctrl;
	private JTable     tblGrilleDonnees;

	public PanelTable (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new BorderLayout() );

		JScrollPane spGrilleDonnees;
		
		// CrÃ©ation des composants
		this.tblGrilleDonnees = new JTable ( new GrilleDonneesModel(ctrl) );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

 		spGrilleDonnees   = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );
	}

}