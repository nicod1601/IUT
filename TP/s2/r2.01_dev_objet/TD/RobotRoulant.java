public class RobotRoulant 
{
	private static final int NB_LIGNE    = 8;
	private static final int NB_COLONNE  = 8;

	private static int numRobot;

	private int    id;
	private int    ligne;
	private int    colonne;
	private String couleur;

	public RobotRoulant(int ligne, int colonne, String couleur)
	{
		if(ligne < 0)
		{
			ligne = 0;	
		}

		if(colonne < 0)
		{
			colonne = 0;	
		}

		if(ligne > NB_LIGNE - 1)
		{
			ligne = NB_LIGNE - 1;	
		}

		if(colonne > NB_COLONNE - 1)
		{
			colonne = NB_COLONNE - 1;	
		}

		this.ligne     = ligne      ;
		this.colonne   = colonne    ;
		this.couleur   = couleur    ;

		this.id      = ++RobotRoulant.numRobot;
	}

	public boolean  deplacer(String direction, RobotRoulant[] ensRobot)
	{
		int nvLigne   = this.ligne;
		int nvColonne = this.colonne;

		if(direction == null){return false;}

		if(direction.charAt(0) == 'N'){nvLigne--;}
		if(direction.charAt(0) == 'S'){nvLigne++;}

		if(direction.length() > 1)
		{
			if(direction.charAt(1) == 'O'){nvColonne--;}
			if(direction.charAt(1) == 'E'){nvColonne++;}
		}
		else
		{
			if(direction.charAt(0) == 'O'){nvColonne--;}
			if(direction.charAt(0) == 'E'){nvColonne++;}
		}
		
		

		for(int cpt = 0; cpt < ensRobot.length; cpt++)
		{
			if(ensRobot[cpt] != this)
			{
				if(ensRobot[cpt].getCordX() == nvLigne && ensRobot[cpt].getCordY() == nvColonne)
				{
					return false;
				}
			}
		}

		return true;
	}

	public int getCordX() { return this.ligne  ; }
	public int getCordY() { return this.colonne; }

	public String getType() { return "RbotR"; }

	public String toString()
	{
		return getType() + "(" + this.ligne + " | " + this.colonne +  " | " + this.couleur + ")";
	}

	public static void main(String[] args) 
	{
		final int TAILLE = 16;

		RobotRoulant[] ensRobotRoulants = new RobotRoulant[TAILLE];

		for(int cpt = 0; cpt < ensRobotRoulants.length - 8; cpt++)
		{
			ensRobotRoulants[cpt] = new RobotRoulant(0, cpt, "Bleu");
		}

		for(int cpt = 8; cpt < ensRobotRoulants.length; cpt++)
		{
			ensRobotRoulants[cpt] = new RobotRoulant(7, cpt - 8, "Orange");
		}

		for(int cpt = 0; cpt < ensRobotRoulants.length; cpt++)
		{
			System.out.println(ensRobotRoulants[cpt]);
		}
	}
}