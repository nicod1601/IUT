package pac.emballage;
import pac.inter.IPeinture;
import pac.inter.IFrabrication;

public class Cube implements IPeinture, IFrabrication
{
	private double coteInterne;
	private double coteExterne;


	public Cube (double coteInterne, double coteExterne )
	{
		this.coteInterne   = coteInterne;
		this.coteExterne   = coteExterne;
	}

	public double getSurfaceExterne()
	{
		return Cube.surface(this.coteExterne);
	}

	public double getSurfaceInterne()
	{
		return Cube.surface(this.coteInterne);
	}

	public double getVolumeExterne()
	{
		return Cube.volume(this.coteExterne);
	}

	public double getVolumeInterne()
	{
		return Cube.volume(this.coteInterne);
	}

	public static double surface(double cote)
	{
		return Math.pow(cote, 2)*6;
	}

	public static double volume(double cote)
	{
		return Math.pow(cote, 3);
	}

}
