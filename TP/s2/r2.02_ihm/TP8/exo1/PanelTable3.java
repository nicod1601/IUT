import java.awt.BorderLayout;

import javax.swing.*;


public class PanelTable3 extends JPanel
{
	JTable tblGrilleDonnees;

	public PanelTable3 ()
	{
		JScrollPane spGrilleDonnees;

		this.setLayout ( new BorderLayout() );


		// Création des composants
		String[]   tabEntetes = {   "Prénom"  , "Nom"     , "Premium", "Année Adhésion" };

		Object[][] tabDonnees = { { "Gérard"  , "Menvussa",   true    ,  2019             },
		                          { "Maxime"  , "Ohm"     ,   false   ,  2000             },
		                          { "Lucie"   , "Fair"    ,   false   ,  1998             },
		                          { "Teddy"   , "Fissile" ,   false   ,  2017             },
		                          { "Sarah"   , "Vigotte" ,   true    ,  2011             },
		                          { "Luc"     , "Cratif"  ,   false   ,  2021             },
		                          { "Anne"    , "Orak"    ,   true    ,  2013             },
		                          { "Larry"   , "Bambelle",   false   ,  2019             },
		                          { "Annie"   , "Versère" ,   false   ,  2017             },
		                          { "Laure"   , "Pailleur",   false   ,  2019             },
		                          { "Lara"    , "Tatouye" ,   false   ,  2013             },
		                          { "Judas"   , "Bricot"  ,   false   ,  2011             } };


		tblGrilleDonnees    = new JTable ( tabDonnees, tabEntetes );
 		spGrilleDonnees     = new JScrollPane( tblGrilleDonnees );
		tblGrilleDonnees.setFillsViewportHeight(true);


		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );

	}
}
