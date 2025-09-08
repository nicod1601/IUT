import iut.algo.Clavier;

public class ControleurDemographie
{
	private Metier           metier;
	private FrameDemographie ihm;

	private int              regionActive;

	private ControleurDemographie()
	{
		metier = new Metier();

		regionActive = 0;

		ihm = new FrameDemographie(this);
		ihm.setSize     ( 1000, 750     );
		ihm.setLocation (   10,  10     );
		ihm.setTitle    ( "Demographie" );
		ihm.setVisible  ( true          );
	}

	public void bouton(int region)
	{
		this.regionActive = region;
		this.ihm.majIHM();
	}

	// Méthodes pour positionner les informations sur le graphique
	public String[] listerRegion()
	{
		return this.metier.listerRegion();
	}

	/** Retourne le nom de la Region Active */
	public String getNomRegionActive()
	{
		return this.metier.getRegion(this.regionActive).getNom();
	}

	/** Retourne le nombre de Départements de la Region Active */
	public int getNbDeptRegionActive()
	{
		return this.metier.getRegion(this.regionActive).getNbDept();
	}

	/** Retourne le département d'indice indice de la Region Active.
	  * indice doit être compris entre 0 et le nombre de départements de
	  * la region active.                                                 */
	public String getNomDeptRegionActive(int indice)
	{
		return this.metier.getRegion(regionActive).getDept(indice).getNom();
	}

	/** Retourne le département d'indice indice de la Region Active.
	  * indice doit être compris entre 0 et le nombre de départements de
	  * la region active.                                                 */
	public int getPopulationDeptRegionActive(int indice)
	{
		return this.metier.getRegion(regionActive).getDept(indice).getPopulation();
	}


	// Main
	public static void main(String[] a)
	{
		ControleurDemographie cd = new ControleurDemographie();
	}
}
