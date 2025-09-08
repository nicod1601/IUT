import java.util.GregorianCalendar;

public class Client
{
	private String  nom;
	private String  prenom;
	private boolean premium;
	private int     anneeAdh;

	public Client (String nom, String prenom, boolean premium, int anneeAdh )
	{
		this.nom      = nom;
		this.prenom   = prenom;
		this.premium  = premium;
		this.anneeAdh = anneeAdh;
	}

	public String  getNom     () { return this.nom;      }
	public String  getPrenom  () { return this.prenom;   }
	public boolean getPremium () { return this.premium;  }
	public int     getAnneeAdh() { return this.anneeAdh; }

	public boolean setPremium ( boolean val )
	{
		int annee = new GregorianCalendar().get ( GregorianCalendar.YEAR );

		if ( val && annee - this.anneeAdh < 5 ) return false;

		this.premium = val;
		return true;
	}
	
	public boolean setAnnee ( int val )
	{
		int annee = new GregorianCalendar().get ( GregorianCalendar.YEAR );

		if ( val < 1900 || val > annee  ) return false;
		if (this.premium && annee - val < 5) return false;

		this.anneeAdh = val;
		return true;
	}

	public String  toString   ()
	{
		return String.format ( "%-15s", this.prenom  ) + " " +
		       String.format ( "%-15s", this.nom     ) + " " +
		       String.format ( "%-5s" , this.premium ) + " " +
		       String.format ( "%4d",   this.anneeAdh);
	}

}
