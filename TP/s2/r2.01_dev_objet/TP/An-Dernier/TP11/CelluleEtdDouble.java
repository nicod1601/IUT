import utilitaire.Etudiant;
public class CelluleEtdDouble
{
	/*-------------------------------*/
	/* Attributs                     */
	/*-------------------------------*/
	private CelluleEtdDouble prc;
	private CelluleEtdDouble svt;

	private Etudiant etd;

	/*-------------------------------*/
	/* Constructeur                  */
	/*-------------------------------*/
	public CelluleEtdDouble(Etudiant etd)
	{
		this.prc = null;
		this.svt = null;

		this.etd = etd;
	}

	/*-------------------------------*/
	/* Modificateurs                 */
	/*-------------------------------*/
	public void setPrc(CelluleEtdDouble prc)
	{
		this.prc = prc;
	}

	public void setSvt(CelluleEtdDouble svt)
	{
		this.svt = svt;
	}

	public void setEtudiant(Etudiant etd)
	{
		this.etd = etd;
	}

	/*-------------------------------*/
	/* Accesseurs                    */
	/*-------------------------------*/
	public CelluleEtdDouble getPrc()
	{
		return prc;
	}

	public CelluleEtdDouble getSvt()
	{
		return svt;
	}

	public Etudiant getEtudiant()
	{
		return etd;
	}
}