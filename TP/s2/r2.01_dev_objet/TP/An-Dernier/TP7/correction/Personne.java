package utilitaire;		// /!\ cette classe la compilation de cette classe  doit
                        //     être redirigée vers votre répertoire de paquetage
public class Personne
{
	private char              sexe;
	private String            nom;

	private Personne          pere;
	private Personne          mere;

	public Personne ( char sexe, String nom )
	{
		this.sexe      = sexe;
		this.nom       = nom;

		this.pere      = null;
		this.mere      = null;

	}

	//Set les parents
	public boolean setParents(Personne mere, Personne pere)
	{
		if (this.pere != null || this.mere != null) { return false; }
		this.mere = mere;
		this.pere = pere;
		return true;
	}

	// Return si l'objet est frere ou non
	public boolean estFrere(Personne personne)
	{
		if ( personne == null  || personne  == this ) return false;
		if ( this.mere == null || this.pere == null ) return false;


		return this.mere == personne.mere && this.pere == personne.pere;

	}
	// Methode qui return si l'objet est demi frere ou non
	public boolean estDemiFrere(Personne personne)
	{
		if ( personne  == null || personne  == this ) return false;
		if ( this.mere == null && this.pere == null ) return false;

		if ( this.mere == null && personne.mere == null && this.pere == personne.pere ) return true;
		if ( this.pere == null && personne.pere == null && this.mere == personne.mere ) return true;

		return this.pere == personne.pere ^ this.mere == personne.mere;
	}

	// Methode qui return si l'objet est parent
	public boolean estParent(Personne personne)
	{
		if ( personne == null || personne == this ) return false;

		return this == personne.pere || this == personne.mere;
	}


	// Methode qui return si l'objet est enfant ou non
	public boolean estEnfant(Personne personne)
	{
		if ( personne == null )return false;
		return personne.estParent(this);
	}

	// Methode qui return si l'objet est grand parent ou non
	public boolean estGrandParent(Personne personne)
	{
		if ( personne == this || personne == null ) return false;

		return this.estParent(personne.mere) || this.estParent(personne.pere);

	}

	// Methode qui return si l'objet est petit enfant ou non
	public boolean estPetitEnfant(Personne personne)
	{
		if (personne == null || personne == this)
			return false;

		return personne.estGrandParent(this);
	}

	// Methode qui return si l'objet est oncle ou non
	public boolean estOncle(Personne personne)
	{
		if (personne == null || personne == this)
			return false;

		return personne.pere != null && ( personne.pere.estFrere( this ) || personne.pere.estDemiFrere( this ) ) ||
			    personne.mere != null && ( personne.mere.estFrere( this ) || personne.mere.estDemiFrere( this )      );
	}
	// Methode qui return si l'objet est neveu ou non
	public boolean estNeveu(Personne personne)
	{
		if (personne == null || personne == this)
			return false;

		return personne.estOncle(this);
	}

	public boolean estCousin(Personne personne)
	{
		if (personne == null || personne == this)
			return false;

		return personne.pere != null && personne.pere.estOncle( this ) ||
		       personne.mere != null && personne.mere.estOncle( this )    ;
	}


	public Personne getPere() { return this.pere; }
	public Personne getMere() { return this.mere; }
	public String   getNom()  { return this.nom;  }
	public char     getSexe() { return this.sexe; }

	public String toString()
	{
		String s = "";

		s += String.format("%-20s",this.nom);

		if (this.mere != null || this.pere != null)
		{
			if   (this.sexe == 'M') { s +=  " fils  "; }
			else { s += " fille "; }

			s += " de ";
		}


		if (this.mere != null)
		{
			s += String.format("%-20s",this.mere.getNom());
			if (this.pere != null) { s += " et "; }

		}

		if (this.pere != null)  { s += this.pere.getNom(); }

		return s;
	}

}
