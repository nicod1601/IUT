import java.awt.BorderLayout;

import javax.swing.*;

public class PanelTable2 extends JPanel
{
	JTable tblGrilleDonnees;

	public PanelTable2 ()
	{
		this.setLayout ( new BorderLayout() );

		// création des composants
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


		tblGrilleDonnees = new JTable ( tabDonnees, tabEntetes );


		// positionnement des composants
		this.add ( tblGrilleDonnees                 , BorderLayout.CENTER );
		this.add ( tblGrilleDonnees.getTableHeader(), BorderLayout.NORTH  );
	}
}