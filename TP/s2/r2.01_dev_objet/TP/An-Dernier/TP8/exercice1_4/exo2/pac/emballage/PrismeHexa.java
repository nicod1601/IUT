package pac.emballage;
import pac.inter.IPeinture;
import pac.inter.IFrabrication;

public class PrismeHexa implements IPeinture, IFrabrication
{
	private double coteInterne;
	private double coteExterne;

	private double hauteurInterne;
	private double hauteurExterne;

	public PrismeHexa (double coteInterne, double coteExterne, double hauteurInterne, double hauteurExterne ) 
	{
		this.coteInterne    = coteInterne;
		this.coteExterne    = coteExterne;

		this.hauteurInterne = hauteurInterne;
		this.hauteurExterne = hauteurExterne;
	}

	public double getSurfaceExterne()
	{
		return PrismeHexa.surface(this.coteExterne,this.hauteurExterne);
	}

	public double getSurfaceInterne()
	{
		return PrismeHexa.surface(this.coteInterne,this.hauteurInterne);
	}

	public double getVolumeExterne()
	{
		return PrismeHexa.volume(this.coteExterne,this.hauteurExterne);
	}

	public double getVolumeInterne()
	{
		return PrismeHexa.volume(this.coteInterne,this.hauteurInterne);
	}

	public static double surface(double cote, double hauteur)
	{
		return cote * hauteur * 6  +
			   cote * hauteur * ( 3* Math.sqrt(3)/2 ) * 2;
	}

	public static double volume(double cote, double hauteur)
	{
		return cote * cote * ( 3* Math.sqrt(3)/2 ) * hauteur;
	}

}