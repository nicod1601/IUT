/** Classe ControleurDemographieCUI.
  * Cette classe fait la passerelle entre la partie Metier et la partie IHM
  * @author Philippe Le Pivert
  */

public class ControleurDemographieCUI
{
	private Metier metier;
	private IHMCUI ihmcui;

	public ControleurDemographieCUI()
	{
		this.metier = new Metier();
		this.ihmcui = new IHMCUI ( metier );

		int choix = this.ihmcui.menu();
		while ( choix != 4 )
		{
			switch ( choix )
			{
				case 1 : this.ihmcui.afficherDept();
				         break;
				case 2 : this.ihmcui.afficherRegion();
				         break;
				case 3 : this.ihmcui.afficherRegionAvecDept();
				         break;
			}
			choix = this.ihmcui.menu();
		}
	}

	public static void main(String[] a)
	{
		new ControleurDemographieCUI();
	}
}
