import javax.swing.table.AbstractTableModel;

public class GrilleDonneesModel extends AbstractTableModel
{
	private String[]   tabEntetes;
	private Object[][] tabDonnees;

	public GrilleDonneesModel ()
	{
		this.tabEntetes = new String[] {   "Prénom"  , "Nom"     , "Premium", "Année Adhésion" };

		this.tabDonnees = new Object[][] { { "Gérard"  , "Menvussa",   true    ,  2019             },
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
	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabDonnees.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabDonnees[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	public boolean isCellEditable(int row, int col)
	{
		return col == 2;
	}

	public void setValueAt(Object value, int row, int col)
	{
		this.tabDonnees[row][col] = value;
		this.fireTableCellUpdated(row, col);
	}

}