

public class RobotVolant
{
	public static final int LIG     = 8;
	public static final int COL     = 8;
	public static final int HAUTEUR = 8;

	private static int nombre =0;
	private int numero;

	private int ligne;
	private int colonne;
	private int hauteur;
	private String couleur;

	public RobotVolant(String couleur,int ligne, int colonne, int hauteur)
	{
		this.numero = ++RobotVolant.nombre;

		if(ligne   < 0        ){ligne   =0;}
		if(colonne < 0        ){colonne =0;}
		if(hauteur < 0        ){hauteur =0;}

		if(hauteur > RobotVolant.HAUTEUR-1){hauteur = RobotVolant.HAUTEUR-1;}
		if(ligne   > RobotVolant.LIG-1    ){ligne   = RobotVolant.LIG-1;    }
		if(colonne > RobotVolant.COL-1    ){colonne = RobotVolant.COL-1;    }

		this.ligne   = ligne;
		this.colonne = colonne;
		this.hauteur = hauteur;
		this.couleur = couleur;
	}

	public boolean deplacer(String dir, RobotVolant[] ensRobot)
	{
		int nvlLigne = this.ligne   + this.deltaLigne(dir);
		int nvlCol   = this.colonne + this.deltaCol  (dir);
		int nvlHaut  = this.hauteur + this.deltaHaut (dir);

		if(nvlLigne >= RobotVolant.LIG || nvlLigne < 0 || nvlCol >= RobotVolant.COL || nvlCol < 0 || nvlHaut >= RobotVolant.HAUTEUR || nvlHaut < 0)
		{
			return false;
		}
		
		for(RobotVolant robot : ensRobot)
		{
			if(robot != null && robot.ligne == nvlLigne && robot.colonne == nvlCol && robot.hauteur == nvlHaut)
			{
				return false;
			}
		}

		return true;
	}

	public int deltaLigne(String dir)
	{
		if(dir.length() > 1)
		{
			if(dir.charAt(1) == 'O'){return -1;}
			if(dir.charAt(1) == 'E'){return  1;}
		}
		else
		{
			if(dir.charAt(0) == 'O'){return -1;}
			if(dir.charAt(0) == 'E'){return  1;}
		}
		return 0;
	}

	public int deltaCol(String dir)
	{
		if(dir.length() > 1)
		{
			if(dir.charAt(1) == 'N'){return -1;}
			if(dir.charAt(1) == 'S'){return  1;}
		}
		else
		{
			if(dir.charAt(0) == 'N'){return -1;}
			if(dir.charAt(0) == 'S'){return  1;}
		}
		return 0;
	}

	public int deltaHaut(String dir)
	{
		if(dir.charAt(0) == 'H'){return -1;}
		if(dir.charAt(0) == 'B'){return  1;}
		return 0;
	}
}
