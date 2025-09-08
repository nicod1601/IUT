public class Piece
{

	    /******************/
	    /*   Attributs    */
	    /******************/

	private static final String[] tabDir = {"Nord", "Ouest", "Sud", "Est"};
	private String nom;
	private boolean[] informations;
	
	
	    /******************/
	    /*  Constructeurs */
	    /******************/


	// Initialisation de la piece dans le cas ou seule sa valeur est passee en argument

	public Piece(int valeur)
	{
		this(valeur,"");
	}

	// Initialisation de la pièce dans le cas ou son nom et sa valeur son passes en argument

	public Piece(int valeur, String nom)
	{
		this.informations = Conversion.entier2Tab(valeur, 7);
		if (nom.length() > 12)
		{
			this.nom = nom.substring(0, nom.length() - 12);
		}
		else
		{
			this.nom = nom;
		}
		

	}


	/******************/
	/*  Methodes      */
	/******************/

	/* Accesseurs */
	// Accesseur qui retourne la valeur entiere correspondant à l'ensemble des informations presentes dans la piece
	
	public int getValOuverture()
	{
		return Conversion.tab2Entier(this.informations);
	}

	// Accesseur qui indique s'il y a une ouverture dans la direction dir ('N' 'O' 'S' ou 'E' )

	public boolean getOuverture(char dir)
	{

		switch(dir)
		{
			case 'N' :
				return this.informations[0];
			case 'O' :
				return this.informations[1];
			case 'S' :
				return this.informations[2];
			case 'E' :
				return this.informations[3];
			default :
				return false ;
		}

	}
	
	/* Accesseur qui indique si la piece est une piece de depart */
	public boolean getDepart()
	{
		return this.informations[4];
	}

	/* Accesseur qui indique si la piece est une piece d'arrivee */
	public boolean getArrivee()
	{
		return this.informations[5];
	}

	public boolean getNbNegatif()
	{
		return this.informations[6];
	}

	// Methode qui retourne l'indice correspondant au parametre dir dans le tableau tabDir 
	public static int indiceDir(char dir)
	{
		for(int cpt = 0 ; cpt < tabDir.length ; cpt++ )
		{
			if ((tabDir[cpt].charAt(0)) == dir )
			{
				return cpt;
			}

		}
		
		return -1;      // On retourne -1 dans le cas où le parametre dir
		                // n'est pas inclus dans le tableau
	}

	// Methode qui retourne sous forme textuelle l'etat de la piece
	public String toString()
	{
		String affichage;


		affichage = String.format("%2s" , this.getValOuverture());
		if (!(this.nom.equals("")))
		{
		
			affichage += String.format("%-16s" , " (" + this.nom ) + " ) ==>";
		}
		else
		{
			affichage += String.format("%-18s" , "") + " ==>";
		}


		for (int i = 0 ; i < 4; i++)
		{
			affichage += String.format("%-4s" , " " + tabDir[i]) + "(" + i +") " + ":" +
			             String.format("%-5s" , this.informations[i]);
		}


		affichage += " Depart : " + String.format("%-5s", this.informations[4]) +
		             " Fin : "    + String.format("%-5s", this.informations[5]);

		return affichage;
	}
}
