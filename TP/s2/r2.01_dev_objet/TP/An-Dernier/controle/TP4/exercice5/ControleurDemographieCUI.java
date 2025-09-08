public class ControleurDemographieCUI
{
	private Metier metier;
	private IHMCUI ihm;

	public ControleurDemographieCUI()
	{
		this.metier = new Metier();
		this.ihm    = new IHMCUI ( metier );

		int choix = this.ihm.menu();
		while ( choix != 4 )
		{
			switch ( choix )
			{
				case 1 : this.ihm.afficherDept();
				         break;
				case 2 : this.ihm.afficherRegion();
				         break;
				case 3 : this.ihm.afficherRegionAvecDept();
				         break;
			}
			choix = this.ihm.menu();
		}
	}

	public static void main(String[] a)
	{
		new ControleurDemographieCUI();
	}
}
